import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorAdvancedTest {

    @ParameterizedTest
    @CsvSource({
            "5, !, 120",      // 5! = 120
            "0, !, 1",        // 0! = 1
            "10, !, 3628800"  // 10! = 3 628 800
    })

    void testFactorial(double value, char action, double expected) throws Exception {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue(value);
        calculator.calculateAdvanced(action);
        assertThat(calculator.getCurrentValue(), is(expected));
    }

    @Test
    void testCalculateAdvancedNotSupportedOperation() {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        assertThrows(NotSupportedOperationException.class, () -> calculator.calculateAdvanced('Z'));
    }

    @Test
    void testCalculateAdvancedNumberNotInArea() {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue(-1.0);
        assertThrows(NumberNotInAreaException.class, () -> calculator.calculateAdvanced('!'));
        calculator.setCurrentValue(11.0);
        assertThrows(NumberNotInAreaException.class, () -> calculator.calculateAdvanced('!'));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 27", // 3 ^ 3 = 27
            "2, 8, 256" // 2 ^ 8 = 256
    })

    void testCalculateAdvanced(double value, char action, double expected) throws Exception {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue(value);
        calculator.calculateAdvanced(action);
        assertThat(calculator.getCurrentValue(), is(expected));
    }

    @Test
    void testFactorialOutOfRange() {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue(11.0);
        assertThrows(NumberNotInAreaException.class, () -> calculator.calculateAdvanced('!'));
    }

    @ParameterizedTest
    @CsvSource({
            "153, A, true",   // 153 is Armstrong
            "28, P, true",    // 28 is perfect
            "10, A, false",   // 10 is not Armstrong
            "12, P, false",   // 12 is not perfect
            "1, A, true",     // 1 is Armstrong
    })

    void testHasCharacteristic(int value, char characteristic, boolean expected) throws Exception {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue((double) value);
        assertThat(calculator.hasCharacteristic(characteristic), is(expected));
    }

    @Test
    void testHasCharacteristicNumberNotInArea() {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue(0.0);
        assertThrows(NumberNotInAreaException.class, () -> calculator.hasCharacteristic('A'));
    }

    @Test
    void testHasCharacteristicNotSupportedOperation() {
        CalculatorAdvanced calculator = new CalculatorAdvanced();
        calculator.setCurrentValue(153.0);
        assertThrows(NotSupportedOperationException.class, () -> calculator.hasCharacteristic('Z'));
    }
}