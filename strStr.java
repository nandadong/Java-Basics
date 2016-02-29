class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null)
            return -1;
        if(source == "" && target == "")
            return 0;
        int i, j;
        for(i = 0; i < source.length(); i++) {
            if(target == "")
                return 0;
            if(source.charAt(i) == target.charAt(0)) {
                for(j = 0; j < target.length(); j++) {
                    if(source.charAt(i + j) != target.charAt(j))
                        break;
                }
                if(j == target.length())
                    return i;
            }
            
            
        }
        return -1;
    }
}