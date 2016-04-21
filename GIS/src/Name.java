import java.io.PrintWriter;
import java.util.Vector;




public class Name {
	private String toHash;
	private Vector<Long> offsets;
	public Name(String name, String state) {
        this(name, state, 0);
    }
	public Name(String name, String state, long offset) {
        this.toHash = name + ":" + state;
        offsets = new Vector<Long>();
        this.offsets.add(offset);
    }
	public void addO(long offset) {
        offsets.add(offset);
    }
	public boolean equals(Object other) {
        if (!other.getClass().equals(Name.class)) {
            return false;
        }
        return this.toHash.equals(((Name) other).toHash);
    }
	public Vector<Long> getO() {
        return offsets;
    }
	@Override
	public int hashCode() {
		 int hashValue = 0;
		 for (int Pos = 0; Pos < toHash.length(); Pos++) { // use all elements
			 hashValue = (hashValue << 4) + toHash.charAt(Pos); // shift/mix
			 int hiBits = hashValue & 0xF0000000; // get high nybble
			 if (hiBits != 0)
				 hashValue ^= hiBits >> 56; // xor high nybble with second nybble
			 hashValue &= ~hiBits; // clear high nybble
		 }
		 return hashValue;
	}
	@Override
	public String toString() {
		return "[" + toHash + ", " +offsets + "]";
	}
}
