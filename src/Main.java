import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String sums = scanner.nextLine();
        calc(sums);
    }

    public static void calc(String input) throws Exception {
        String regex = "(^\\d+\\s[\\+\\-\\*\\/]\\s\\d+$)|(^[IXVixv]+\\s[\\+\\-\\*\\/]\\s[IXVixv]+$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда одной системы счисления и один оператор (+, -, /, *)");
        }
        int supersums = 0;
        String[] abc = input.toUpperCase().split(" ");
        if (matcher.group(2) == null) {
            int sums1 = Integer.parseInt(abc[0]);
            int sums2 = Integer.parseInt(abc[2]);
            if (sums1 < 0 | sums1 > 10 | sums2 < 0 | sums2 > 10) {
                throw new Exception("операнды должны быть в промежутке от 1 до 10");
            }
            switch (abc[1]) {
                case "+" -> supersums = sums1 + sums2;
                case "-" -> supersums = sums1 - sums2;
                case "*" -> supersums = sums1 * sums2;
                case "/" -> supersums = sums1 / sums2;
            }
            System.out.println(supersums);
        } else {
            String[] romanian = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
            int sums1 = Arrays.asList(romanian).indexOf(abc[0]);
            if (sums1 >= 0) {
                sums1 += 1;
            } else {
                throw new Exception("Некорректный(ые) операнд(ы)");
            }
            int sums2 = Arrays.asList(romanian).indexOf(abc[2]);
            if (sums2 >= 0) {
                sums2 += 1;
            } else {
                throw new Exception("Некорректный(ые) операнд(ы)");
            }
            switch (abc[1]) {
                case "+" -> supersums = sums1 + sums2;
                case "-" -> supersums = sums1 - sums2;
                case "*" -> supersums = sums1 * sums2;
                case "/" -> supersums = sums1 / sums2;
            }
            if (supersums > 0) {
                System.out.println(Convertation.convert(supersums));
            } else {
                throw new Exception("Результат выражения с римскими операндами не может быть отрицательным");
            }

        }
    }


}
