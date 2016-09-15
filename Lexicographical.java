public class Lexicographical {
    // The basic idea is to find the next number
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>();
        int current = 1;
        for (int i = 0; i < n; i ++) {
            list.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else if (current % 10 != 9 && current + 1 <= n) {
                current ++;
            } else {
                current /= 10;
                while (current % 10 == 9) {
                    current /= 10;
                }
                current ++;
            }
        }
        return list;
    }
}
