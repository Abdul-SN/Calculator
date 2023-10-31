import java.util.Scanner;

class Main{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор выполняет следующие операции(+; -; *; /;) между двумя числами.\nВведите целые числа от 1 до 10, \nлибо Римские числа от I до X:");
        //Создаю переменную input для считывания выражения с клавиартуры, далее передаю его в метод calc
        String input = scanner.nextLine();
        input = input.toUpperCase().replaceAll("\\s", "");
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        int a, b;
        String mathSymbol, output;
        boolean isRoman;
        //С помощью сплита я поделил введенное выражение на массив из двух чисел, но пока что в СТРОЧНОМ типе
        // Квадратные скобки в сплите обозначают, что я могу поделить выражение с помощью любого символа из перечисленных
        String[] number = input.split("[+\\-*/]");

        if (number.length != 2) throw new Exception("Проверьте введенное выражение!\nДопустимо использование только  2-х чисел и одного из перечисленных математических символов");
        //С помощью метода whatSymbol определяем матем-й символ введенного выражения и задаем значение переменной mathSymbol
        mathSymbol = whatSymbol(input);
        // Проверка, что оба числа римские, если да, то конвертирую в арабские с помощью метода
        if (Second.isRoman(number[0]) && Second.isRoman(number[1])) {
        // конвертируем оба числа в арабские
            a = Second.toArabic(number[0]);
            b = Second.toArabic(number[1]);
            isRoman = true;
        } else if (!Second.isRoman(number[0]) && !Second.isRoman(number[1])) {
            a = Integer.parseInt(number[0]);
            b = Integer.parseInt(number[1]);
            isRoman = false;
        } else {
            throw new Exception("Числа должны быть одной системы счисления");
        }
        //Этот оператор исключает ввод чисел больше 10
        if (a > 10 || b > 10) {
            throw new Exception("ВВеденные числа не могут быть больше 10");
        }

        int arabian = calculator (a, b, mathSymbol);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Числа должны быть больше 0");
            }
            output = Second.toRoman(arabian);
            } else {
        //Конвертируем арабское число в тип String
            output = String.valueOf(arabian);
        }
        return output;
    }

    public static String whatSymbol(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }

    public static int calculator (int a, int b, String mathSymbol) {
        return switch (mathSymbol) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
class Second {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};



    public static boolean isRoman(String val) {
        for (String s : romanArray) {
            if (val.equals(s)) {
                return true;
            }
        }
        return false;

    }
        // Конвертрую в Арабские числа
    public static int toArabic(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }
        // Конвертрую в Римские числа
    public static String toRoman(int arabian) {
        return romanArray[arabian];
    }
}








