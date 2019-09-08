import framework.NumbersKihonBase;

public class NumbersKihon extends NumbersKihonBase {
    @Override
    protected int Return_The_Maximum_Value_Of_Int32() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected int Return_The_Minimum_Value_Of_Int32() {
        return Integer.MIN_VALUE;
    }

    @Override
    protected int Return_The_Remainder_Of_a_Divided_By_b(int a, int b) {
        return a % b;
    }

    @Override
    protected double Return_The_Maximum_Value_Of_Double() {
        return Double.MAX_VALUE;
    }

    @Override
    protected double Return_The_Minimum_Value_Of_Double() {
        return Double.MIN_VALUE;
    }

    @Override
    protected boolean Return_True_If_a_Is_Not_A_Number(double a) {
        return Double.isNaN(a);
    }

    @Override
    protected boolean Return_True_If_a_Is_An_Infinity(double a) {
        return Double.isInfinite(a);
    }
}
