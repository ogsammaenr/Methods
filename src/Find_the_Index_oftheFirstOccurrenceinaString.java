public class Find_the_Index_oftheFirstOccurrenceinaString {
    public static void main(String[] args) {
        int a = strStr("telefon", "telefon");
        System.out.println(a+5);
    }


    public static int strStr(String haystack, String needle) {
        char[] haystack_array = haystack.toCharArray();
        char[] needle_array = needle.toCharArray();

        if (haystack == needle) {
            return 0;
        }

        int control;
        for (int i = 0; i < haystack.length(); i++) {
            control = 0;
            for (int j = 0; j < needle.length(); j++) {
                if (i+j < haystack.length() && haystack_array[i + j] == needle_array[i + j]) {
                    control++;
                }
                else{
                    break;
                }
            }
            if (control == needle.length()) {
                return i;
            }
        }
        return -1;
    }


}
