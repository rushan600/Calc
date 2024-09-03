import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textIn = scanner.nextLine();
        String[] text = textIn.split("\"");
        String line1 = text[1];
        String line2;
        String oper;
        if (text[2].replace(" ", "").length() > 1) {
            oper = text[2].substring(0, 3);
            line2 = text[2].replace(oper, "");
        } else {
            oper = text[2];
            line2 = text[3];
        }
        if (line1.length() > 10 && line2.length() > 10) {
            throw new IllegalArgumentException("Длина строки должна быть не более 10 символов!");
        }
        System.out.println(calculator(line1,line2,oper));


    }
    static String calculator(String line1, String line2, String oper) {
        String rez = null;
        int num2;
        switch (oper) {
            case " + ": {
                rez = line1 + line2;
                break;
            }
            case " - ": {
                rez = line1.replace(line2, "");
                break;
            }
            case " * ": {
                num2 = num(line2);
                rez = line1.repeat(num2);
                if (rez.length() > 40) {
                    return rez.substring(0, 40) + "...";
                }
                break;
            }
            case " / ": {
                num2 = num(line2);
                rez = line1.substring(0,num2);
                break;
            }
            default: throw new RuntimeException("Введен неправильный оператор");
        }
        return "\"" +rez+ "\"";
    }
    static int num(String line2) {
        return switch (line2) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            default -> throw new RuntimeException("Диапозон чисен от 1 до 10 включительно");
        };
    }
}
