import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ilk sayıyı giriniz : ");
        int sayi1 = sc.nextInt();
        System.out.println("ikinci sayiyi giriniz : ");
        int sayi2 = sc.nextInt();

        System.out.println("yapmak istediğiniz işlemi seçiniz(1: toplama, 2: çıkarma, 3: bölme, 4: çarpma) ");
        int islem = sc.nextInt();
        switch (islem) {
            case 1:
                System.out.println(toplama(sayi1, sayi2));
                break;
            case 2:
                System.out.println(çıkarma(sayi1, sayi2));
                break;
            case 3:
                System.out.println(bölme(sayi1, sayi2));
                break;
            case 4:
                System.out.println(çarpma(sayi1, sayi2));
                break;
            default:
                System.out.println("lütfen geçerli bir işlem seçiniz");


                String s = "asdasd";
                System.out.println(s.length());

        }
    }
    public static int toplama(int a, int b) {
        return a + b;
    }
    public static int çıkarma(int a, int b) {
        return a - b;
    }
    public static int çarpma(int a, int b) {
        return a * b;
    }
    public static int bölme(int a, int b) {
        return a / b;
    }



}