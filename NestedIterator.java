public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private Map<NestedInteger, List<Integer>> map;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        map = new HashMap<NestedInteger, List<Integer>>();
        for (NestedInteger ni : nestedList) nestedHelper(ni);
    }
    
    private void nestedHelper(NestedInteger nestedList) {
        if (map.containsKey(nestedList)) {
            list.addAll(map.get(nestedList));
            return;
        }
        List<Integer> l = new ArrayList<Integer>();
        if (nestedList.isInteger()) {
            l.add(nestedList.getInteger());
        } else {
            for (NestedInteger ni : nestedList.getList()) {
                nestedHelper(ni);
            }
        }
        map.put(nestedList, l);
        list.addAll(l);
    }
    
    @Override
    public Integer next() {
        return list.remove(0);
    }

    @Override
    public boolean hasNext() {
        return list.size() != 0;
    }
}
