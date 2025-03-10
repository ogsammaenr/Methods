public class Longest_Common_Prefix {
    public static void main(String[] args) {

        String[] a = {"dog","racecar","car"};
        String b = longestCommonPrefix(a);
        System.out.println("Longest Common Prefix : " + b);

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){

            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                     prefix = prefix.substring(0, j);
                }

            }

        }
        return prefix;
    }

}
