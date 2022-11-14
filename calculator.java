
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) throws ScannerException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение:");
        String input = scan.nextLine();
        scan.close();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws ScannerException {
        romanNum convert = new romanNum();
        String[] actions = {"+", "-", "/", "*"};
        String[] op = {"\\+", "-", "/", "\\*"};
        int operatorIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                operatorIndex = i;
                break;
            }
        }
        if (operatorIndex == -1) {
            throw new ScannerException("т.к. строка не является математической операцией");
        }
        String[] data = input.split(op[operatorIndex]);
        if (convert.isRoman(data[0]) == convert.isRoman(data[1])) {
            int a, b;
            boolean isRoman = convert.isRoman(data[0]);
            if (isRoman) {
                a = convert.romanToInt(data[0]);
                b = convert.romanToInt(data[1]);
                if (a <= 0 || a > 10) {
                    throw new ScannerException("Ввод чисел от 1 до 10 включительно");
                }
                if (b <= 0 || b > 10) {
                    throw new ScannerException("Ввод чисел от 1 до 10 включительно");
                }
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
                if (a <= 0 || a > 10) {
                    throw new ScannerException("Ввод чисел от 1 до 10 включительно");
                }
                if (b <= 0 || b > 10) {
                    throw new ScannerException("Ввод чисел от 1 до 10 включительно");
                }
                if (a != 10 & input.length() > 3 & b != 10) {
                    throw new ScannerException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
            }
            int result = switch (actions[operatorIndex]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;
            };
            if (isRoman) {
                System.out.println(convert.IntToRoman(result));}
            else {
                System.out.println(result);
            }
        } else {
            throw new ScannerException("т.к. используются одновременно разные системы счисления");
        }
      return input;
    }
}



