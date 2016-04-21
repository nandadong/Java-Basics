import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


// On my honor:
//
// - I have not discussed the Java language code in my program with
// anyone other than my instructor or the teaching assistants
// assigned to this course.
//
// - I have not used Java language code obtained from another student,
// or any other unauthorized source, either modified or unmodified.
//
// - If any Java language code or documentation used in my program
// was obtained from another source, such as a text book or course
// notes, that has been clearly noted with a proper citation in
// the comments of my program.
//
// - I have not designed this program in such a way as to defeat or
// interfere with the normal operation of the Curator System.
//
// <Dong Nan>
public class GIS {
	private static RandomAccessFile database;
    private static BufferedReader scripts;
    private static PrintWriter log;

	public static void main(String[] args) {
		database = null;
        scripts = null;
        log = null;
        if(args.length < 3) {
        	System.out.println("Command line: java GIS <database file name> <command script file name> <log file name>");
        	System.exit(0);
        }
        Parser par;
        //database initialization:
        try {
        	File db = new File(args[0]);
        	db.delete();
        	db.createNewFile();
        	database = new RandomAccessFile(db, "rw");
        }
        catch(FileNotFoundException e) {
        	System.err.println("Cannot read/write file: " + args[0]);
        	System.exit(1);
        }
        catch(IOException e) {
        	System.err.println("Cannot create: " + args[0]);
        	System.exit(1);
        }
        //scripts initialization:
        try{
        	scripts = new BufferedReader(new FileReader(args[1]));
        }
        catch(FileNotFoundException e) {
        	System.err.println("Cannot read file: " + args[1]);
        	System.exit(1);
        }
        //log initialization:
        try  {
        	File lg = new File(args[2]);
            lg.delete();
            lg.createNewFile();
            log = new PrintWriter(lg, "UTF-8");
        }
        catch(FileNotFoundException e) {
        	System.err.println("Cannot write file: " + args[2]);
        	System.exit(1);
        }
        catch(IOException e) {
        	System.err.println("Cannot create: " + args[2]);
        	System.exit(1);
        }
        //Parse commands:
        par = new Parser(database, scripts, log);
        log.println("GIS Program - Dong Nan(nandong@vt.edu)");
        log.println();
        log.println("dbFile:    " + args[0]);
        log.println("script:    " + args[1]);
        log.println("log:       " + args[2]);
        SimpleDateFormat date = new SimpleDateFormat();
        date.applyPattern("EEE, d MMM yyyy HH:mm:ss");
        log.println(("Start time: " + date.format(new GregorianCalendar().getTime())));
        log.println("Quadtree children are printed in the order SW  SE  NE  NW");
        log.println("--------------------------------------------------------------------------------");
        par.parse();
        //Exit program:
        try {
            database.close();
            scripts.close();
        }
        catch (IOException e) {
            System.err.println("Cannot write file: " + args[0]);
        }
        // log the date and time
        date = new SimpleDateFormat();
        date.applyPattern("EEE, d MMM yyyy HH:mm:ss");
        log.println(("End time: " + date.format(new GregorianCalendar().getTime())));
        log.println("--------------------------------------------------------------------------------");
        // close the log file
        log.close();

        System.exit(0);
	}
	
	
}
