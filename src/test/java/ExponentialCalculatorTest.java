import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ExponentialCalculatorTest {
    @Test
    void testGapingResult() {
        assertThat(ExponentialCalculator.gapeMeDaddy(), is(69.69));
    }
}
