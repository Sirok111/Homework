package sirok5;

class ArraySizeException extends Exception {
    public ArraySizeException(String message) {
        super(message);
    }
}

class ArrayDataException extends Exception {
    public ArrayDataException(String message) {
        super(message);
    }
}

public class ArrayValueCalculator {
    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || !checkInnerArrays(array)) {
            throw new ArraySizeException("Array must be 4x4 in size");
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data at position [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    private static boolean checkInnerArrays(String[][] array) {
        for (String[] row : array) {
            if (row.length != 4) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "X", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = doCalc(validArray);
            System.out.println("Sum: " + result);
        } catch (ArraySizeException e) {
            System.err.println("Array size error: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("Array data error: " + e.getMessage());
        }

        try {
            int result = doCalc(invalidDataArray);
            System.out.println("Sum: " + result);
        } catch (ArraySizeException e) {
            System.err.println("Array size error: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("Array data error: " + e.getMessage());
        }
    }
}
