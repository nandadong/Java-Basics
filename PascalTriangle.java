import java.util.*;
public class PascalTriangle {
	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> list = generate(numRows);
		System.out.print(list + "\n");
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return list;
		} 
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		list.add(al);
		if (numRows == 1) {
			return list;
		} 
		al = new ArrayList<Integer>();
		al.add(1);
		al.add(1);
		list.add(al);
		if (numRows == 2) {
			return list;	
		}
		int num = 2;
		while (num < numRows) {
			al = new ArrayList<Integer>();
			al.add(1);
			for (int i = 0; i < num - 1; i++) {
				al.add(list.get(num-1).get(i) + list.get(num-1).get(i+1));
			}
			al.add(1);
			list.add(al);
			num ++;
		}
		return list;
	}
}