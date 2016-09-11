public class DecodeString {
	public String decodeString(String s) {
        String result = "", num = "";
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            // if c is a digit
            if (c >= '0' && c <= '9') {
                num += c;
            }
            // if c is '['
            else if (c == '[') {
                int k = Integer.valueOf(num), count = 1, index = i + 1;
                for ( ; index < s.length(); index ++) {
                    if (s.charAt(index) == '[') count ++;
                    else if (s.charAt(index) == ']') count --;
                    if (count == 0) break;
                }
                String sub = s.substring(i + 1, index);
                for (int j = 0; j < k; j ++) result += decodeString(sub);
                i = index; // attention here, not index + 1, cuz when program enter loop again it will + 1
                num = "";
            }
            // if c is a letter
            else if (c >= 'a' && c <= 'z') result += c;
        }
        return result;
    }
}
