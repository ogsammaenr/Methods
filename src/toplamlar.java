import java.util.Scanner;

public class toplamlar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("lütfen bir sayı giriniz");
        int n = sc.nextInt();
        //System.out.println("tek toplam = " + tektoplam(n) + "\nçift toplam = " + cifttoplam(n));
        toplamlar(n);
    }
    public static int tektoplam(int n){
        int tektoplam = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 1)
                tektoplam += i;
        }
        return tektoplam;
    }
    public static int cifttoplam(int n){
        int cifttoplam = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                cifttoplam += i;
        }
        return cifttoplam;
    }
    public static void toplamlar(int n){
        int tektoplam = 0;
        int cifttoplam = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                tektoplam += i;
            else
                cifttoplam += i;
        }
        System.out.println("tek toplam = " + tektoplam +"\nçift toplam = " + cifttoplam);
    }
}
