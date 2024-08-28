import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.replace("\"","");
        text = text.replace(" ","");
        String[] data = text.split("[+*/-]");
        String line1 = data[0];
        if (line1.length() > 10) {
            throw new IllegalArgumentException("Длина строки должна быть не более 10 символов!");}
        String line2 = data[1];
        if (line2.length() > 10) {
            throw new IllegalArgumentException("Длина строки должна быть не более 10 символов!");}
        System.out.println(calculator(oper(text),line1,line2));
    }
    static String calculator (String text,String line1,String line2) {
        String rez = null;
        int num2;
        switch (text){
           case "+":
               rez = line1 + line2;
               if (line1.matches("\\d+")) {
                   throw new IllegalArgumentException("Первый аргумент должна быть строка!");}
               return "\"" +rez+ "\"";
           case "-": rez = line1.replace(line2," ");
               return "\""+rez+"\"";
           case "*": num2 = key(line2);
                     rez = line1;
                     for (int i = 1; i < num2; i++) {
                     rez += line1;
                     }
               if (rez.length() > 40) {
                   return rez.substring(0, 40) + "...";
               }
               return "\"" +rez+ "\"";
           case "/": num2 = key(line2);
                     rez = line1.substring(0,num2);
               return "\"" +rez+ "\"";
           default: throw new RuntimeException("Введен неправильный оператор");
    }
    }
    static int key(String num) {
        return switch (num) {
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

    static String oper (String text){
        if (text.contains("+")) return "+";
        if (text.contains("-")) return "-";
        if (text.contains("*")) return "*";
        if (text.contains("/")) return "/";
        throw new RuntimeException("Не содержит оператор");
    }
}

