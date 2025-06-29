import java.util.Arrays;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abc"));
    }

    public static String longestPalindrome(String s) {

    char[] chars = s.toCharArray();
    char[] control_chars ;
    String[] palindromes = new String[0];
    int length ;

    for (int i = 0; i < s.length(); i++) {
        length = 0;
        control_chars = new char[0];

        for (int j = i; j < s.length(); j++) {
            control_chars = Arrays.copyOf(control_chars, length + 1);
            control_chars[length] = chars[j];

            int control = 0;
            for(int k = 0; k <= length; k++) {
                if (control_chars[k] == control_chars[length - k]) {
                    control++;
                }
            }

            if (control == length + 1) {
                palindromes = Arrays.copyOf(palindromes, palindromes.length + 1);
                palindromes[palindromes.length - 1] = new String(control_chars);
            }

            length++;
        }

    }
    String palindrome = palindromes[0];
    for(String i : palindromes) {
        if (palindrome.length() < i.length()){
            palindrome = i;
        }
    }

    return palindrome;
}
}
