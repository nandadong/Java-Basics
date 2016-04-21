import java.io.PrintWriter;
import java.util.Vector;

public class Index {
	private Hashtable<Name> index;
	public Index() {
		index = new Hashtable<Name>();
	}
	public Vector<Long> find(String name, String state) {
        Name entry = index.find(new Name(name, state));
        if (entry == null) {
            return null;
        }
        return entry.getO();
    }
	public int getLongestProbe() {
        return index.getLongestProbe();
    }
	public int getSize() {
		return index.getSize();
	}
	public void insert(String name, String state, long offset) {
        Name duplicate;
        if ((duplicate = index.insert(new Name(name, state, offset))) != null) {
            duplicate.addO(offset);
        }
    }
	public void print(PrintWriter log) {
		index.printTable(log);
	}
	
}
