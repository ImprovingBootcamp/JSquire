package framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class NumbersKihonBase {
    protected abstract int Return_The_Maximum_Value_Of_Int32();
    protected abstract int Return_The_Minimum_Value_Of_Int32();
    protected abstract int Return_The_Remainder_Of_a_Divided_By_b(int a, int b);
    protected abstract double Return_The_Maximum_Value_Of_Double();
    protected abstract double Return_The_Minimum_Value_Of_Double();
    protected abstract boolean Return_True_If_a_Is_Not_A_Number(double a);
    protected abstract boolean Return_True_If_a_Is_An_Infinity(double a);

            @Test
    public void Return_The_Maximum_Value_Of_Int32_Test()
    {
        // Arrange


        // Act
        int result = Return_The_Maximum_Value_Of_Int32();

        // Assert
        assertEquals(Integer.MAX_VALUE, result);
    }

        @Test
    public void Return_The_Minimum_Value_Of_Int32_Test()
    {
        // Arrange


        // Act
        int result = Return_The_Minimum_Value_Of_Int32();

        // Assert
        assertEquals(Integer.MIN_VALUE, result);
    }

        @Test
    public void Return_The_Remainder_Of_a_Divided_By_b()
    {
        // Arrange
        int a = 251;
        int b = 25;

        // Act
        int remainder = Return_The_Remainder_Of_a_Divided_By_b(a, b);

        // Assert
        assertEquals(a % b, remainder);
    }

        @Test
    public void Return_The_Maximum_Value_Of_Double_Test()
    {
        // Arrange


        // Act
        double actual = Return_The_Maximum_Value_Of_Double();

        // Assert
        assertEquals(Double.MAX_VALUE, actual);
    }

        @Test
    public void Return_The_Minimum_Value_Of_Double_Test()
    {
        // Arrange


        // Act
        double actual = Return_The_Minimum_Value_Of_Double();

        // Assert
        assertEquals(Double.MIN_VALUE, actual);
    }

        @Test
    public void Return_True_If_a_Is_Not_A_Number_Test1()
    {
        // Arrange
        double a = 1.24;

        // Act
        var result = Return_True_If_a_Is_Not_A_Number(a);

        // Assert
        assertEquals(Double.isNaN(a), result);
    }

        @Test
    public void Return_True_If_a_Is_Not_A_Number_Test2()
    {
        // Arrange
        double a = Double.NEGATIVE_INFINITY;

        // Act
        var result = Return_True_If_a_Is_Not_A_Number(a);

        // Assert
        assertEquals(Double.isNaN(a), result);
    }

        @Test
    public void Return_True_If_a_Is_Not_A_Number_Test3()
    {
        // Arrange
        double a = Double.NaN;

        // Act
        var result = Return_True_If_a_Is_Not_A_Number(a);

        // Assert
        assertEquals(Double.isNaN(a), result);
    }

        @Test
    public void Return_True_If_a_Is_An_Infinity_Test1()
    {
        // Arrange
        double a = 1.24;

        // Act
        var actual = Return_True_If_a_Is_An_Infinity(a);

        // Assert
        assertEquals(Double.isInfinite(a), actual);
    }

        @Test
    public void Return_True_If_a_Is_An_Infinity_Test2()
    {
        // Arrange
        double a = Double.NEGATIVE_INFINITY;

        // Act
        var actual = Return_True_If_a_Is_An_Infinity(a);

        // Assert
        assertEquals(Double.isInfinite(a), actual);
    }

        @Test
    public void Return_True_If_a_Is_An_Infinity_Test3()
    {
        // Arrange
        double a = Double.POSITIVE_INFINITY;

        // Act
        var actual = Return_True_If_a_Is_An_Infinity(a);

        // Assert
        assertEquals(Double.isInfinite(a), actual);
    }
}
