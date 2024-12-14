public class CalculatorAdvanced extends Calculator {

    /**
     * Performs advanced operations like factorial and exponentiation.
     * @param action the operation to perform ('!' for factorial, 0-9 for exponentiation).
     * @throws NumberNotInAreaException if the number is out of allowed range for factorial.
     * @throws NotSupportedOperationException if the action is not supported.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {

        int intValue = (int) Math.floor(getCurrentValue());

        if (action == '!') {

            if (intValue < 0 || intValue > 10)
                throw new NumberNotInAreaException("Number out of range for factorial!");

            setCurrentValue((double) factorial(intValue));
        }

        else if (Character.isDigit(action)) {

            int exponent = Character.getNumericValue(action);
            setCurrentValue((double) power(intValue, exponent));
        }

        else {
            throw new NotSupportedOperationException("Unsupported action!");
        }
    }

    /**
     * Helper for factorial.
     * @param n number to be used in function.
     * @return factorial of the number.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    private int factorial(int n) {

        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * Helper for exponentiation.
     * @param base number to be exponentiated in the function.
     * @param exponent value of the exponent.
     * @return exponentiation of the number.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    private int power(int base, int exponent) {

        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }

    /**
     * Determines if currentValue satisfies specific characteristics.
     * @param value the characteristic to check ('A' for Armstrong, 'P' for perfect).
     * @return true if the characteristic is satisfied, false otherwise.
     * @throws NumberNotInAreaException if currentValue < 1.
     * @throws NotSupportedOperationException if the characteristic is not supported.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    public Boolean hasCharacteristic(char value) throws NumberNotInAreaException, NotSupportedOperationException {

        int intValue = (int) Math.floor(getCurrentValue());

        if (intValue < 1)
            throw new NumberNotInAreaException("Number must be >= 1!");

        switch (value) {
            case 'A':
                return isArmstrong(intValue);

            case 'P':
                return isPerfect(intValue);

            default:
                throw new NotSupportedOperationException("Unsupported characteristic!");
        }
    }

    /**
     * Helper for checking if Armstrong number.
     * @param number to be checked.
     * @return true if Armstrong, false otherwise.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    private boolean isArmstrong(int number) {

        int sum = 0;
        int temp = number;
        int digits = String.valueOf(number).length();

        while (temp != 0) {

            int digit = temp % 10;
            sum += power(digit, digits);
            temp /= 10;
        }

        return sum == number;
    }

    /**
     * Helper for checking if perfect number.
     * @param number to be checked.
     * @return true if perfect, false otherwise.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    private boolean isPerfect(int number) {

        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {

            if (number % i == 0)
                sum += i;
        }

        return sum == number;
    }
}

/**
 * Exception for number not in allowed area.
 * @author Saša Vujančević
 * @version 1.0
 * @date 13. 12. 2024.
 */
class NumberNotInAreaException extends Exception {
    public NumberNotInAreaException(String message) {
        super(message);
    }
}