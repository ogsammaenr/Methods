public class valid_palindrome {
    public static void main(String[] args) {



    }

    public boolean isPalindrome(String s) {
        String metin = s.replaceAll("[\\p{Punct}\\s]", "").toLowerCase();
        int dogru_mu = 0;
        for (int i = 0; i < metin.length(); i++){
            if (metin.charAt(i) != metin.charAt(metin.length()-i)){
                dogru_mu ++;
            }
        }
        if (dogru_mu == 0)
            return true;
        else
            return false;
    }
}
