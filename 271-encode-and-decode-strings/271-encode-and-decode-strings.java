public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i, n, j, len;
        List<String> Ans;
        StringBuilder num, sb;
        
        i = j = 0;
        n = s.length();
        Ans = new ArrayList<>();
        
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                num = new StringBuilder();
                while (s.charAt(i) != '#') {
                    num.append(s.charAt(i));
                    i++;
                }
                len = Integer.parseInt(num.toString());
                i++;
                sb = new StringBuilder();
                j = 0;
                for (j = i; j < (i + len); ++j) {
                    sb.append(s.charAt(j));
                }
                Ans.add(sb.toString());
                i = j;
            }
        }
        return Ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));