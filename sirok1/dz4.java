public class dz4 {
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

    public static void main(String[] args) {
        String exampleString = "hello world";
        char exampleSymbol = 'o';
        int result = findSymbolOccurrence(exampleString, exampleSymbol);
        System.out.println("Символ '" + exampleSymbol + "' зустрічається " + result + " разів у рядку '" + exampleString + "'.");
    }
}
