import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "10, 5, +, 15", // 10 + 5 = 15
            "5, 5, -, 0", // 5 - 5 = 0
            "3, 4, *, 12", // 3 * 4 = 12
            "8, 2, /, 4" // 8 / 2 = 4
    })

    void testCalculate(Double currentValue, Double value, char operator, Double expected) throws Exception {
        Calculator calculator = new Calculator();
        calculator.setCurrentValue(currentValue);
        calculator.calculate(value, operator);
        assertThat(calculator.getCurrentValue(), is(expected));
    }

    @Test
    void testDivisionByZeroException() {
        Calculator calculator = new Calculator();
        assertThrows(DivisionByZeroException.class, () -> calculator.calculate(0.0, '/'));
    }

    @Test
    void testNotSupportedOperationException() {
        Calculator calculator = new Calculator();
        assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(10.0, '%'));
    }
}