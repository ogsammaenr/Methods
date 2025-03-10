public class Divide_Two_Integers {
    public static void main(String[] args) {


    }


    public int divide(int dividend, int divisor) {
        int div = dividend;
        int sonuç = 0;

        if (divisor > 0) {
            while (div - divisor >= 0) {
                div = div - divisor;
                sonuç++;

            }
        }
        else {
            while (div - divisor <= 0) {
                div = div + divisor;
                sonuç++;
            }
        }
        return sonuç ;

    }

}
