public class asalsayi {
    public static void main(String[] args) {
        String islem = "1.5 + 1.5";
        String[] parts = islem.split(" ");


        double sayi1 = 0;
        double sayi2 = 0;
        char operator = ' ';

        StringBuffer str = new StringBuffer(islem);

        for (int i = 0; i < parts.length; i++) {


            try {
                sayi1 = Double.parseDouble(parts[i]);
            } catch (NumberFormatException e) {
                operator = parts[i].charAt(0);
            }


            if (operator == '+') {
                if (i + 1 < parts.length) {
                    sayi2 += Double.parseDouble(parts[++i]) + sayi1;
                    sayi1 = 0;
                }
                operator = ' ';

            } else if (operator == '-') {
                if (i + 1 < parts.length) {
                    sayi2 += sayi1;
                    sayi2 -= Double.parseDouble(parts[++i]);
                    sayi1 = 0;
                }
            }else if (operator == '*') {
                if (i + 1 < parts.length) {
                    sayi2 += sayi1;
                    sayi2 *= Double.parseDouble(parts[++i]);
                    sayi1 = 0;
                }
            }else if (operator == '/') {
                if (i + 1 < parts.length) {
                    sayi2 += sayi1;
                    sayi2 /= Double.parseDouble(parts[++i]);
                    sayi1 = 0;
                }
            }

        }
        System.out.println(sayi2);
    }
}
/**
 * 1 nesne tabanlı programlama
 * 1 masaüstü uygulama
 * 1 metod
 * 1 String buffer
 * 1 sıralama algoritmaları
 */