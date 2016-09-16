public class IsValidSerialization {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        // diff = outdegree - indegree, except for root
        int diff = 1; 
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
