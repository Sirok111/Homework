public class dzzz4 {

    public static int findSymbolOccurrence(String string, char symbol) {
        if (string == null) {
            throw new IllegalArgumentException("Рядок не може бути null.");
        }

        int count = 0;
        for (char c : string.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }


    public static int findWordPosition(String source, String target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Рядки не можуть бути null.");
        }

        return source.indexOf(target);
    }

    public static String stringReverse(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Рядок не може бути null.");
        }

        return new StringBuilder(string).reverse().toString();
    }
    public static void main(String[] args) {
        String exampleString = "hello world";
        char exampleSymbol = 'o';
        int result = findSymbolOccurrence(exampleString, exampleSymbol);
        System.out.println("Символ '" + exampleSymbol + "' зустрічається " + result + " разів у рядку '" + exampleString + "'.");
        String source = "Apollo";
        String target = "pollo";
        int position = findWordPosition(source, target);
        System.out.println("Підрядок '" + target + "' знаходиться на позиції " + position + " у рядку '" + source + "'.");
        source = "Apple";
        target = "Plant";
        position = findWordPosition(source, target);
        System.out.println("Підрядок '" + target + "' знаходиться на позиції " + position + " у рядку '" + source + "'.");
        String original = "Hello";
        String reversed = stringReverse(original);
        System.out.println("Рядок '" + original + "' у зворотному порядку: '" + reversed + "'.");
    }
}

