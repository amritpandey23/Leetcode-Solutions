class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(transform(w, codes));
        }
        return set.size();
    }
    
    private String transform(String word, String[] codes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            sb.append(codes[word.charAt(i) - 'a']);
        }
        return sb.toString();
    }
}