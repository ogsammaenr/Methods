public class longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("abcb");

        System.out.println(a);

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = 1;
        int templength;

        if (s.length() == 0 && s != " ")
            return 0;

        for (int i = 0; i < s.length(); i++) {
            templength = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (chars[i] != chars[j]) {
                    templength++;
                    if(j == s.length() - 1)
                        return templength;
                }
                else {
                    if (templength > length) {
                        length = templength;
                    }
                    break;
                }
            }
        }
        return length;
    }
}
