import java.util.Scanner;
class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        while (true) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
        }
    }
    public static String calc(String input) throws IllegalArgumentException {
            String[] parts = input.split(" ");
        if (parts.length < 3) {
            throw new IllegalArgumentException("т.к. строка не является математической операцией или не введены пробелы между операндами и оператором");
        }
        if (parts.length > 3) {
            throw new IllegalArgumentException("т.к. формат математической оперции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введены не числа");
        }
        if (a <= 0 || a > 10 || b <= 0 || b > 10) {
            throw new IllegalArgumentException("Введенные числа выходят за диапазон 1 ... 10");
        }
            int result;
            switch (parts[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Недопустимая операция");
            }
        return String.valueOf(result);
    }
}