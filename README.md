# **Calculator Project**


## **Overview**

This project implements a `Calculator` and `CalculatorAdvanced` class in Java, providing a robust foundation for **testing and quality assurance** of mathematical operations. The primary focus is on ensuring the reliability, correctness, and maintainability of the codebase. Advanced testing methodologies, including **unit testing**, **100% code coverage**, and **mutation testing** with PIT, have been applied to validate the quality of the implementation.


## **Features**

**Basic Calculator (Calculator Class)**
1. Basic Arithmetic Operations
    - Addition (`+`)
    - Subtraction (`-`)
    - Multiplication (`*`)
    - Division (`/`)


2. Custom Exceptions
    - `DivisionByZeroException`: Thrown when dividing by zero.
    - `NotSupportedOperationException`: Thrown for unsupported operators.
   
**Advanced Calculator (CalculatorAdvanced Class)**
1. Factorial Calculation
    - Computes the factorial of an integer (`!`).
    - Supported range: `0` to `10`.
      
2. Exponentiation
    - Raises the current value to an integer power.
      
3. Number Characteristics
    - Armstrong Numbers (`A`): Validates if a number is an Armstrong number.
    - Perfect Numbers (`P`): Checks if a number is perfect.

4. Custom Exceptions
    - `NumberNotInAreaException`: Thrown when a number is out of the allowed range.
    - `NotSupportedOperationException`: Thrown for unsupported actions or characteristics.
  

## **Focus on Testing and Quality Assurance**

**Code Coverage**
  - The project achieves 100% test coverage, ensuring that every line of code is exercised by the test suite, leaving no untested paths in the logic.
    
**Mutation Testing**
  - Mutation testing was conducted using PIT (Pitest) to evaluate the test suite's effectiveness.
  - All surviving mutants were killed, demonstrating the ability to detect subtle bugs and potential weaknesses in the code.
    
**Error Handling**
  - The code is designed with custom exceptions to ensure predictable and safe handling of edge cases such as division by zero, unsupported operations, and invalid ranges.

**Unit Tests**
  - Comprehensive unit tests validate all functionalities, including edge cases and invalid inputs.
  - Tests are written with JUnit 5 and leverage Hamcrest Matchers for precise and readable assertions.

**Sample Test: Factorial Calculation**

```java
@Test
void testFactorial() throws Exception {
    CalculatorAdvanced calculator = new CalculatorAdvanced();
    calculator.setCurrentValue(5.0);
    calculator.calculateAdvanced('!');
    assertThat(calculator.getCurrentValue(), is(120.0));
}
```

## **Usage**

**1. Basic Calculator**

```java
Calculator calculator = new Calculator();

// Perform basic operations
calculator.setCurrentValue(10.0);
calculator.calculate(5.0, '+'); // 10 + 5 = 15
System.out.println(calculator.getCurrentValue()); // Output: 15.0
```

**2. Advanced Calculator**

```java
CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();

// Factorial Calculation
calculatorAdvanced.setCurrentValue(5.0);
calculatorAdvanced.calculateAdvanced('!'); // 5! = 120
System.out.println(calculatorAdvanced.getCurrentValue()); // Output: 120.0

// Check Armstrong Number
calculatorAdvanced.setCurrentValue(153.0);
boolean isArmstrong = calculatorAdvanced.hasCharacteristic('A'); // True for 153
System.out.println(isArmstrong); // Output: true
```

## **Testing Results**

1. Full Test Coverage
    - The codebase is fully covered by tests, ensuring that all functionalities, including edge cases, are verified.

2. Mutation Testing
    - Mutation testing was conducted to simulate possible faults in the code. The test suite successfully detected and neutralized all mutants, demonstrating the tests' effectiveness.

## **Dependencies**
  - Java 21
  - JUnit 5 for testing
  - Hamcrest Matchers for assertions
  - PIT (Pitest) for mutation testing
    
## **How to Run**

**1. Clone the Repository**

```bash
git clone <repository-url>
cd <repository-folder>
```

**2. Compile the Code**

```bash
javac -d bin src/*.java
```

**3. Run Tests**
    - Use your IDE or the command line to run tests with JUnit 5.

**4. Run Mutation Testing Install PIT (Pitest) and run mutation tests with:**

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```
