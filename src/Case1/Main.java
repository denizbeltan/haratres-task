package Case1;

import java.util.Scanner;

public class Main {
    public static int counter(String enteredWord, char letter) {
        int count = 0;
        for (int i = 0; i < enteredWord.length(); i++) {
            if (enteredWord.charAt(i) == letter) {
                count++;
            }
        }

        return count;
    }

    public static void check(String input, String enteredWord) {
        if (input.isEmpty()) {
            System.out.println("Geçersiz giriş. Bir harf giriniz.");

            return;
        }

        char letter = input.charAt(0);
        int count = counter(enteredWord, letter);
        System.out.println("Girilen cümlede '" + letter + "' harfi toplamda " + count + " defa geçmektedir.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Maksimum karakter sayısını belirleyiniz:");
        String maxChar = scanner.nextLine();
        int numChar = Integer.parseInt(maxChar);

        System.out.println("Lütfen bir cümle giriniz:");
        String enteredWord = scanner.nextLine();

        while (enteredWord.length() > numChar) {
            System.out.println("Belirlediğiniz maksimum karakter sayısı:" + maxChar);
            System.out.println("Lütfen bu değere uygun yeni bir cümle giriniz:");
            enteredWord = scanner.nextLine();
        }

        System.out.println("Büyük/küçük harf duyarlılığı aktif olsun mu? (Evet/Hayır)");
        String caseSensibility = scanner.nextLine();
        while ((!caseSensibility.equalsIgnoreCase("evet")) && (!caseSensibility.equalsIgnoreCase("hayır"))) {
            System.out.println("Lütfen evet veya hayır seçeneklerinden birini yazınız.");
            caseSensibility = scanner.nextLine();
        }

        System.out.println("Analiz etmek için bir harf giriniz:");

        String input = scanner.nextLine();
        if (!caseSensibility.equalsIgnoreCase("evet")) {
            input = input.toLowerCase();
            enteredWord = enteredWord.toLowerCase();
        }

        check(input, enteredWord);

        scanner.close();
    }
}
