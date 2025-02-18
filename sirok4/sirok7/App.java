package sirok7;

public class App {

    public static void main(String[] args) {
        // Перевіряємо наявність трьох аргументів
        if (args.length != 3) {
            System.out.println("Usage: java -jar Calculator.jar <num1> <num2> <operation>");
            System.exit(1);
        }

        // Парсимо числа та операцію
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        String operation = args[2];

        // Перемінна для результату
        double result = 0;

        // Виконуємо операцію в залежності від введеного оператора
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    System.exit(1);
                }
                break;
            default:
                System.out.println("Error: Invalid operation! Use +, -, x, or /.");
                System.exit(1);
        }

        // Виводимо результат
        System.out.println("Result: " + result);
    }
}

