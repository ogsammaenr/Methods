import java.util.Scanner;

public class hesap_makinesi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("kaç adet sayı girmek istiyorsunuz?  :  ");
        int uzunluk = sc.nextInt();

        int[] dizi = new int[uzunluk];
        for (int i = 0; i < uzunluk; i++) {
            System.out.print("lütfen " + i + ". elemanı giriniz : ");
            dizi[i] = sc.nextInt();
        }
        System.out.println("sayılara yapmak istediğiniz işlemi seçiniz");
        int islem = sc.nextInt();

        System.out.println(hesap_makinesi(dizi, islem));
    }

    public static float hesap_makinesi(int[] sayilar, int islem) {
        float cevap = 0;

        if (islem == 4)
            cevap = 1;
        else if (islem == 3)
            cevap = sayilar[0];

        for (int i = 0; i < sayilar.length; i++) {
            if (islem == 1)
                cevap += sayilar[i];
            else if (islem == 2)
                cevap -= sayilar[i];
            else if (islem == 3 && i != 0)
                cevap /= sayilar[i];
            else if (cevap == 4)
                cevap *= sayilar[i];

        }

        return cevap;
    }


}
