import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите 2 целых числа: ");
        String nums1 = scan.next();
        String oper = scan.next();
        String nums2 = scan.next();
        String s = scan.nextLine();

        if (!s.isEmpty()) throw new RuntimeException("Строка не может иметь больше двух чисел");
        else {
            int[] key1 = key(nums1);
            int[] key2 = key(nums2);

            int num1 = key1[0];
            int num2 = key2[0];

            if (key1[1] == 2 || key2[1] == 2) throw new RuntimeException("Вы ввели неподходящие значения");
            if (key1[1] == key2[1]) {
                if (key1[1] == 1) {
                    int rez = calculated(num1, num2, oper);
                    System.out.println("Ответ для арабских чисел");
                    System.out.println(nums1 + " " + oper + " " + nums2 + " = " + rez);
                }
                if (key1[1] == 0) {
                    String rez = convert(calculated(num1, num2, oper));
                    /*if (rez < 0) {System.out.println("в римских числах нет отрицательных чисел");}*/
                    System.out.println("Ответ для римские чисел");
                    System.out.println(nums1 + " " + oper + " " + nums2 + " = " + rez);
                }
            } else throw new RuntimeException("Вы ввели римское число вместе с арабским");
        }
    }

    static int calculated(int num1, int num2, String oper) {
        int rez = 0;
        rez = switch (oper) {
            case ("+") -> num1 + num2;
            case ("-") -> num1 - num2;
            case ("*") -> num1 * num2;
            case ("/") -> num1 / num2;
            default -> throw new RuntimeException("Введен неправильный оператор");};
        return rez;
    }

    static String convert(int rez) {
        if (rez < 0) throw new RuntimeException("в римских цифрах нет отрицательных чисел");
        if (rez == 0) throw new RuntimeException("в римских цифрах нет нуля");
        String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[rez];
    }

    static int[] key(String num) {
        int[] key = {0, 0};
        switch (num) {
            case "I", "1":
                if (num.equals("1")) key[1] = 1;
                key[0] = 1;
                break;
            case "II", "2":
                if (num.equals("2")) key[1] = 1;
                key[0] = 2;
                break;
            case "III", "3":
                if (num.equals("3")) key[1] = 1;
                key[0] = 3;
                break;
            case "IV", "4":
                if (num.equals("4")) key[1] = 1;
                key[0] = 4;
                break;
            case "V", "5":
                if (num.equals("5")) key[1] = 1;
                key[0] = 5;
                break;
            case "VI", "6":
                if (num.equals("6")) key[1] = 1;
                key[0] = 6;
                break;
            case "VII", "7":
                if (num.equals("7")) key[1] = 1;
                key[0] = 7;
                break;
            case "VIII", "8":
                if (num.equals("8")) key[1] = 1;
                key[0] = 8;
                break;
            case "IX", "9":
                if (num.equals("9")) key[1] = 1;
                key[0] = 9;
                break;
            case "X", "10":
                if (num.equals("10")) key[1] = 1;
                key[0] = 10;
                break;
            default: key[1] = 2;
        }
        return key;
    }
}