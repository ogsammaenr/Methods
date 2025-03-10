public class Reverse_Integer {
    public static void main(String[] args) {

        int[] dizi = {0,0,1,1,2,2,3,4,5,5,6,6};
        int sayi = -321;

        System.out.println(reverse(sayi));

    }
    public static long reverse(long x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if (rev > Integer.MAX_VALUE)
            return 0;
        else if (rev < Integer.MIN_VALUE)
            return 0;

        return rev;
    }


}
