import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Vector;


public class BufferPool {
	private static final int CAPACITY = 10;
	private Vector<String> pool;
	private Vector<Long> offsets;
	//private int size;
	public BufferPool() {
		pool = new Vector(CAPACITY);
		offsets = new Vector(CAPACITY);
		//size = 0;
	}
	public void insert(String record, long offset) {
		if(find(offset) != null)
			;
		else if(pool.size() == CAPACITY) {
			pool.remove(0);
			offsets.remove(0);
		}
		pool.addElement(record);
		offsets.addElement(offset);
	}
	public String find(long offset) {
		for(int i = 0; i < offsets.size(); i++) {
			if(offsets.elementAt(i) == offset) {
				offsets.remove(i);
				return pool.remove(i);
			}
		}
		return null;
	}
	public void printPool(PrintWriter log) {
		log.println();
		log.println("MRU");
		if(pool.isEmpty())
			log.println(" Empty BufferPool");
		else {
			for(int i = pool.size() - 1; i >= 0; i--) 
				log.println(" " + offsets.elementAt(i) + ":  " + pool.elementAt(i));
		}
		log.println("LRU");
	}
}
