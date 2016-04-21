import java.io.PrintWriter;


public class Hashtable<T> {
	
	private static int[] sizes = { 1019, 2027, 4079, 8123, 16267, 32503,
			65011, 130027, 260111, 520279, 1040387, 2080763, 4161539,
			8323151, 16646323 };
	private static final double LOAD_FACTOR = 0.7;
	private T[] table;
    private int size;
    private int size_num;
    private int longest_probe;
//  private long offset;
    //wrong use of offset!
	public Hashtable() {
		size = 0;
        size_num = 0;
        longest_probe = 0;
        table = (T[]) new Object[sizes[size_num]];
        
	}
	
	public int getSize() {
        return size;
    }
	
	public T insert(T elem) {
		double capacity = (double)size/table.length;
		if(capacity > LOAD_FACTOR)
			increaseSize();
		T duplicate = insert_helper(elem, table);
		if(duplicate == null) {
			size++;
			return null;
		}
		return duplicate;
	}
	private T insert_helper(T elem, T[] tb) {
		int home = Math.abs(elem.hashCode() % tb.length);
		int i;
		for(i = 0 ; ; i++) {
			int step = (home + (i * i + i) / 2) % tb.length;
			if (tb[step] == null) {
                tb[step] = elem;
                break;
            }
			if (tb[step].equals(elem)) {
                return tb[step];
            }
		}
		longest_probe = Math.max(i, longest_probe);
		return null;	
	}
	private void increaseSize() {
		size_num++;
        T[] new_table = (T[]) new Object[sizes[size_num]];
        for (T elem : table) {
            if (elem != null) {
                insert_helper(elem, new_table);
            }
        }
        table = new_table;
	}
	
	public T find(T elem) {
		int home = Math.abs(elem.hashCode() % table.length);
		for (int i = 0 ; ; i++) {
            int index = home + ((i * i + i) / 2) % table.length;
            if (table[index] == null) {
                return null;
            }
            if (table[index].equals(elem)) {
                return table[index];
            }
        }
	}
	
	public int getLongestProbe() {
		return longest_probe;
	}
	
	public void printTable(PrintWriter log) {
		log.println();
		log.println("Format of display is");
		log.println("Slot number: data record");
		log.println("Current table size is " + table.length);
		log.println("Number of elements in table is " + size);
		log.println();
		for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                log.println(i + ":  " + table[i]);
            }
        }
	}
	
	
}
