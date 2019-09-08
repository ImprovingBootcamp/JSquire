import framework.NumbersKihonBase;

public class NumbersKihon extends NumbersKihonBase {
    @Override
    protected int returnTheMaximumValueOfInt() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected int returnTheMinimumValueOfInt() {
        return Integer.MIN_VALUE;
    }

    @Override
    protected int returnTheRemainderOfADividedByB(int a, int b) {
        return a % b;
    }

    @Override
    protected double returnTheMaximumValueOfDouble() {
        return Double.MAX_VALUE;
    }

    @Override
    protected double returnTheMinimumValueOfDouble() {
        return Double.MIN_VALUE;
    }

    @Override
    protected boolean returnTrueIfAIsNotANumber(double a) {
        return Double.isNaN(a);
    }

    @Override
    protected boolean returnTrueIfAIsAnInfinite(double a) {
        return Double.isInfinite(a);
    }
}
