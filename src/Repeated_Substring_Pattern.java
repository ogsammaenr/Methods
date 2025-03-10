public class Repeated_Substring_Pattern {

    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abcabcabca"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        String[] patterns = new String[chars.length/2];
        int control;

        //girdinin parçalanabilecek bütün ihtimalleri bir diziye atanır
        for (int i = 1; i <= chars.length / 2; i++) {
            patterns[i-1] = String.copyValueOf(chars, 0, i);
        }

        //parçalar teker teker denenir
        int deger = 0;
        for(int i = 0; i < patterns.length; i++){
            control = 0;


            for (int j = 0; j < chars.length; j++) {
                deger = j % patterns[i].length();
                if (chars[j] == patterns[i].charAt(deger)) {
                    control++;
                }
            }
            if (control == chars.length && chars.length % patterns[i].length() == 0) {
                return true;
            }

        }



        return false;
    }

}
