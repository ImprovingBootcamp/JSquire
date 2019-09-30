package framework.bases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NumbersKihonBase {
    protected abstract int returnTheMaximumValueOfInt();

    protected abstract int returnTheMinimumValueOfInt();

    protected abstract int returnTheRemainderOfADividedByB(int a, int b);

    protected abstract double returnTheMaximumValueOfDouble();

    protected abstract double returnTheMinimumValueOfDouble();

    protected abstract boolean returnTrueIfAIsNotANumber(double a);

    protected abstract boolean returnTrueIfAIsAnInfinite(double a);

    @Test
    public void returnTheMaximumValueOfIntTest() {
        // Arrange


        // Act
        int result = returnTheMaximumValueOfInt();

        // Assert
        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void returnTheMinimumValueOfInt32Test() {
        // Arrange


        // Act
        int result = returnTheMinimumValueOfInt();

        // Assert
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void returnTheRemainderOfADividedByB() {
        // Arrange
        int a = 251;
        int b = 25;

        // Act
        int remainder = returnTheRemainderOfADividedByB(a, b);

        // Assert
        assertEquals(a % b, remainder);
    }

    @Test
    public void returnTheMaximumValueOfDoubleTest() {
        // Arrange


        // Act
        double actual = returnTheMaximumValueOfDouble();

        // Assert
        assertEquals(Double.MAX_VALUE, actual);
    }

    @Test
    public void returnTheMinimumValueOfDoubleTest() {
        // Arrange


        // Act
        double actual = returnTheMinimumValueOfDouble();

        // Assert
        assertEquals(Double.MIN_VALUE, actual);
    }

    @Test
    public void returnTrueIfAIsNotANumberTest1() {
        // Arrange
        double a = 1.24;

        // Act
        var result = returnTrueIfAIsNotANumber(a);

        // Assert
        assertEquals(Double.isNaN(a), result);
    }

    @Test
    public void returnTrueIfAIsNotANumberTest2() {
        // Arrange
        double a = Double.NEGATIVE_INFINITY;

        // Act
        var result = returnTrueIfAIsNotANumber(a);

        // Assert
        assertEquals(Double.isNaN(a), result);
    }

    @Test
    public void returnTrueIfAIsNotANumberTest3() {
        // Arrange
        double a = Double.NaN;

        // Act
        var result = returnTrueIfAIsNotANumber(a);

        // Assert
        assertEquals(Double.isNaN(a), result);
    }

    @Test
    public void returnTrueIfAIsAnInfinityTest1() {
        // Arrange
        double a = 1.24;

        // Act
        var actual = returnTrueIfAIsAnInfinite(a);

        // Assert
        assertEquals(Double.isInfinite(a), actual);
    }

    @Test
    public void returnTrueIfAIsAnInfinityTest2() {
        // Arrange
        double a = Double.NEGATIVE_INFINITY;

        // Act
        var actual = returnTrueIfAIsAnInfinite(a);

        // Assert
        assertEquals(Double.isInfinite(a), actual);
    }

    @Test
    public void returnTrueIfAIsAnInfinityTest3() {
        // Arrange
        double a = Double.POSITIVE_INFINITY;

        // Act
        var actual = returnTrueIfAIsAnInfinite(a);

        // Assert
        assertEquals(Double.isInfinite(a), actual);
    }
}
