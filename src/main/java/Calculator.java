public class Calculator {

    private Double currentValue;

    /**
     * Default constructor initializing currentValue to 0.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    public Calculator() { this.currentValue = 0.0; }

    /**
     * Applies a mathematical operation based on the given operator.
     * @param value the value used in the operation.
     * @param operator the operator (+, -, *, /).
     * @throws DivisionByZeroException if division by zero is attempted.
     * @throws NotSupportedOperationException if the operator is not supported.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException {

        switch (operator) {
            case '+':
                currentValue += value;
                break;

            case '-':
                currentValue -= value;
                break;

            case '*':
                currentValue *= value;
                break;

            case '/':
                if (value == 0)
                    throw new DivisionByZeroException("Division by zero!");

                currentValue /= value;
                break;

            default:
                throw new NotSupportedOperationException("Unsupported operation!");
        }
    }

    /**
     * Getter for currentValue.
     * @return the current value.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Setter for currentValue.
     * @param value the new value to set.
     * @author Saša Vujančević
     * @version 1.0
     * @date 13. 12. 2024.
     */
    public void setCurrentValue(Double value) {
        currentValue = value;
    }
}

/**
 * Exception for division by zero.
 * @author Saša Vujančević
 * @version 1.0
 * @date 13. 12. 2024.
 */
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

/**
 * Exception for unsupported operations.
 * @author Saša Vujančević
 * @version 1.0
 * @date 13. 12. 2024.
 */
class NotSupportedOperationException extends Exception {
    public NotSupportedOperationException(String message) {
        super(message);
    }
}