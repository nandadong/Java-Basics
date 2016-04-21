import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Vector;


public class Parser {
	private RandomAccessFile database;
	private BufferedReader scripts;
	private PrintWriter log;
	private int count;
	public Parser(RandomAccessFile database, BufferedReader scripts, PrintWriter log) {
		count = 0;
		this.database = database;
        this.scripts = scripts;
        this.log = log;
	}
	public void parse() {
		String line;
		String[] values;
		long westLong = 0;
		long eastLong = 0;
		long southLat = 0;
		long northLat = 0;
		long latitude = 0;
		long longitude = 0;
		long offset = 0;
		long height, width;
		Vector<Long> offsets;
		Vector<Point> q;
		prQuadTree<Point> tree = null;
		Point p;
		BufferPool pool = new BufferPool();
		//Hashtable table = new Hashtable();
		BufferedReader data = null;
		Index index = new Index();
		try {
			while ((line = scripts.readLine()) != null) {
				if (!line.startsWith(";") && !line.isEmpty()) {
					values = line.split("\t");
					switch(values[0]) {
	            	case "world":
	            		log.println(line);
	            		log.println();
	            		log.println("Latitude/longitude values in index entries are shown as signed integers, in total seconds.");
	            		log.println();
	            		log.println("World boundaries are set to:");
	            		westLong = tolong(values[1]);
	            		eastLong = tolong(values[2]);
	            		southLat = tolong(values[3]);
	            		northLat = tolong(values[4]);
	            		//printout:
	            		log.println("              " + northLat);
	            		log.println("   " + westLong + "                " + eastLong);
	            		log.println("              " + southLat);
	            		//log.println(D + " " + M + " " + S);
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	case "import":
	            		//Add all valid GIS records to database file:
	            		count++;
	            		log.println("Command " + count + ": " + line);
	            		values = line.split("\t");
	            		try{
	            			data = new BufferedReader(new FileReader(values[1]));
	            		} catch(FileNotFoundException e) {
	                    	System.err.println("Cannot read file: " + values[1]);
	                    	System.exit(1);
	                    }
	            		line = data.readLine();
	            		//System.getProperty("line.separator")
	            		database.writeBytes(line + "\n");
	            		while((line = data.readLine()) != null) {
	            			if(!line.isEmpty()) {
	            				values = line.split("\\|");
	            				if((values[7].endsWith("N") || values[7].endsWith("S")) && (values[8].endsWith("W") 
	            						|| values[8].endsWith("E"))) {
		    	            		latitude = tolong(values[7]);		
		    	            		longitude = tolong(values[8]);
		    	            		if(longitude >= westLong && longitude <= eastLong && latitude >= southLat
		    	            				&& latitude <= northLat)
		            					database.writeBytes(line + "\n");
	            				} 
	            				else
	            					database.writeBytes(line + "\n");
	            			}
	            		}
	            		//Store database records to prQuadTree and Hashtable:
	            		database.seek(offset);
	            		line = database.readLine();
	            		offset = database.getFilePointer();
	            		tree = new prQuadTree<Point>(westLong, eastLong, southLat, northLat);
	            		while((line = database.readLine()) != null) {
	            			values = line.split("\\|");
	            			if((values[7].endsWith("N") || values[7].endsWith("S")) && (values[8].endsWith("W") 
            						|| values[8].endsWith("E"))) {
		            			latitude = tolong(values[7]);
		            			longitude = tolong(values[8]);
		            			p = new Point(longitude, latitude, offset);
		            			tree.insert(p);
	            			}
//	            			feature = values[1] + values[3];
	            			index.insert(values[1], values[3], offset);
	            			offset = database.getFilePointer();
	            		}
	            		log.println();
	            		log.println("Imported Features by name: " + tree.find(westLong, eastLong, southLat, northLat).size());
	            		log.println("Longest probe sequence:    " + index.getLongestProbe());
	            		log.println("Imported Locations:        " + tree.find(westLong, eastLong, southLat, northLat).size());
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	case "what_is_at":
	            		count++;
	            		log.println("Command " + count + ": " + line);
	            		values = line.split("\t");
	            		log.println();
	            		latitude = tolong(values[1]);
	            		longitude = tolong(values[2]);
//	            		latitude = 138536;
//	            		longitude = -286231;		(unsolved problem here: display duplicate leaves)
	            		p =  tree.find(new Point(longitude, latitude, 0));
	            		if(p == null)
	            			log.println("   Nothing was found at " + values[1] + "   " + values[2]);
	            		else {
		            		log.println("   The following features were found at " + values[1] + "   " + values[2]);
		            		offsets = p.getO();
		            		for(int i = 0; i < offsets.size(); i++) {
			            		offset = offsets.get(i);
			            		database.seek(offset);
			            		line = database.readLine();
			            		pool.insert(line, offset);
			            		values = line.split("\\|");
			            		log.println(offset + ":  " + values[1] + "  " + values[5] + "  " + values[3]);
		            		}
	            		}
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	case "what_is":
	            		count++;
	            		log.println("Command " + count + ": " + line);
	            		log.println();
	            		values = line.split("\t");
	            		offsets = index.find(values[1], values[2]);
	            		if(offsets == null)
	            			log.println("No records match " + values[1] + " and " + values[2]);
	            		else {
		            		offset = offsets.lastElement();
//		            		for(int i = 0; i < offsets.size(); i++)
//		            			offset = offset + offsets.elementAt(i);
		            		database.seek(offset);
		            		line = database.readLine();
		            		pool.insert(line, offset);
		            		values = line.split("\\|");
		            		log.println(offset + ":  " + values[5] + "  " + values[7] + "  " + values[8]);
	            		}
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	case "what_is_in":
	            		count++;
	            		log.println("Command " + count + ": " + line);
	            		log.println();
	            		values = line.split("\t");
	            		int c, record;
	            		switch(values[1]) {
	            		case "-l":
	            			latitude = tolong(values[2]);
	            			longitude = tolong(values[3]);
	            			height = Long.valueOf(values[4]);
	            			width = Long.valueOf(values[5]);
	            			q = tree.find(longitude-width, longitude+width, latitude-height, latitude+height);
	            			if(q == null || (c = q.size()) == 0)
	            				log.println("   Nothing was found in (" + values[2] + " +/- " + values[4] + ", " + values[3]
	            						+ " +/- " + values[5] + ")");
	            			else {
		            			c = q.size();
		            			record = 0;
		            			for(int i = 0; i < c; i++) {
		            				offsets = q.elementAt(i).getO();
		            				for(int j = 0; j < offsets.size(); j++)
		            					record++;
		            			}
		            			log.println("   The following " + record + " features were found in (" + values[2] + " +/- " + values[4]
		            					+ ", " + values[3] + " +/- " + values[5] + ")");
		            			for(int i = 0; i < c; i++) {
		            				offsets = q.elementAt(i).getO();
		            				
		            				for(int j = 0; j < offsets.size(); j++) {
		            					//c++;
		            					offset = offsets.get(j);
			            				database.seek(offset);
			            				line = database.readLine();
			            				pool.insert(line, offset);
			            				values = line.split("\\|");
			            				log.println("  Feature ID   : " + values[0]);
			            				log.println("  Feature Name : " + values[1]);
			            				log.println("  Feature Cat  : " + values[2]);
			            				log.println("  State        : " + values[3]);
			            				log.println("  County       : " + values[5]);
			            				log.println("  Latitude     : " + values[7]);
			            				log.println("  Longitude    : " + values[8]);
			            				log.println("  Elev in ft   : " + values[16]);
			            				log.println("  USGS Quad    : " + values[17]);
			            				log.println("  Date created : " + values[18]);
			            				log.println();
		            				}
		            			}
	            			}
	            			break;
	            		case "-c":
		            		latitude = tolong(values[2]);
	            			longitude = tolong(values[3]);
	            			height = Long.valueOf(values[4]);
	            			width = Long.valueOf(values[5]);
	            			q = tree.find(longitude-width, longitude+width, latitude-height, latitude+height);
	            			if(q == null || (c = q.size()) == 0)
	            				log.println("   Nothing was found in (" + values[2] + " +/- " + values[4] + ", " + values[3]
	            						+ " +/- " + values[5] + ")");
	            			else {
		            			c = q.size();
		            			record = 0;
		            			for(int i = 0; i < c; i++) {
		            				offsets = q.elementAt(i).getO();
		            				
		            				for(int j = 0; j < offsets.size(); j++) {
		            					offset = offsets.get(j);
			            				database.seek(offset);
			            				line = database.readLine();
			            				pool.insert(line, offset);
			            				record++;
		            				}
		            			}
		            			log.println(record + " features were found in (" + values[2] + " +/- " + values[4] + ", " + values[3]
		            					+ " +/- " + values[5] + ")");
	            			}
	            			break;
	            		default:
	            			latitude = tolong(values[1]);
	            			longitude = tolong(values[2]);
	            			height = Long.valueOf(values[3]);
	            			width = Long.valueOf(values[4]);
	            			q = tree.find(longitude-width, longitude+width, latitude-height, latitude+height);
	            			if(q == null || (c = q.size()) == 0)
	            				log.println("   Nothing was found in (" + values[1] + " +/- " + values[3] + ", " + values[2]
	            						+ " +/- " + values[4] + ")");
	            			else {
		            			c = q.size();
		            			record = 0;
		            			for(int i = 0; i < c; i++) {
		            				offsets = q.elementAt(i).getO();
		            				for(int j = 0; j < offsets.size(); j++)
		            					record++;
		            			}
		            			log.println("   The following " + record + " features were found in (" + values[1] + " +/- " + values[3]
		            					+ ", " + values[2] + " +/- " + values[4] + ")");
		            			for(int i = 0; i < c; i++) {
		            				offsets = q.elementAt(i).getO();
		            				
		            				for(int j = 0; j < offsets.size(); j++) {
		            					offset = offsets.get(j);
			            				database.seek(offset);
			            				line = database.readLine();
			            				pool.insert(line, offset);
			            				values = line.split("\\|");
			            				log.println(offset + ":  " + values[1] + "  " + values[3] + "  " + values[7] + "  " 
			            				+ values[8]);
		            				}
		            			}
	            			}
	            			break;
	            		}
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	case "debug":
	            		count++;
	            		log.println("Command " + count + ": " + line);
	            		values = line.split("\t");
	            		switch(values[1]) {
	            		case "quad":
	            			tree.printTree(log);
	            			break;
	            		case "hash":
	            			index.print(log);
	            			break;
	            		case "pool":
	            			pool.printPool(log);
	            			break;
	            		default:
	            			break;
	            		}
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	case "quit":
	            		count++;
	            		log.println("Command " + count + ": " + line);
	            		log.println();
	            		log.println("Terminating execution of commands.");
	            		break;
	            	default:
	            		count++;
	            		values = line.split("\t");
	            		log.println("Command not found! Undefined command: " + values[0]);
	            		log.println("--------------------------------------------------------------------------------");
	            		break;
	            	}
				} else {
					log.println(line);
				}
				log.flush();
			}
		}
		catch (IOException e) {
            System.err.println("Cannot read script");
        }
	}
	
	private long tolong(String DMS) {
		long value = 0;
		String D, M, S;
		if(DMS.length() == 7) {
			D = DMS.substring(0, 2);
    		M = DMS.substring(2, 4);
    		S = DMS.substring(4, 6);
    		value = Long.valueOf(S) + 60*Long.valueOf(M) + 3600*Long.valueOf(D);
    		if(DMS.charAt(6) == 'S')
    			value = -value;
		} else {
			D = DMS.substring(0, 3);
    		M = DMS.substring(3, 5);
    		S = DMS.substring(5, 7);
    		value = Long.valueOf(S) + 60*Long.valueOf(M) + 3600*Long.valueOf(D);
    		if(DMS.charAt(7) == 'W')
    			value = -value;
		}
		return value;
	}
}
