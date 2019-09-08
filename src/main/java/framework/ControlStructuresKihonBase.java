package framework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

public abstract class ControlStructuresKihonBase {
    @Test
    public void callHitOnAIfValIsTrueElseCallHitOnBv1() {
        // Arrange
        var a = mock(ITarget.class);
        var b = mock(ITarget.class);
        boolean val = true;

        // Act
        callHitOnAIfValIsTrueElseCallHitOnB(val, a, b);

        // Assert
        verify(a).hit();
        verify(b, never()).hit();
    }

    @Test
    public void callHitOnAIfValIsTrueElseCallHitOnBv2() {
        // Arrange
        var a = mock(ITarget.class);
        var b = mock(ITarget.class);
        boolean val = false;

        // Act
        callHitOnAIfValIsTrueElseCallHitOnB(val, a, b);

        // Assert
        verify(b).hit();
        verify(a, never()).hit();
    }

    @Test
    public void callHitOnAOnceForEachMemberOfList() {
        // Arrange
        var a = mock(ITarget.class);
        var list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

        // Act
        callHitOnAOnceForEachMemberOfList(a, list);

        // Assert
        verify(a, times(4)).hit();
    }

    @Test
    public void callHitOnAWhileAIsValidIsTrue() {
        // Arrange
        var a = mock(ITarget.class);
        doReturn(true, true, true, true, false)
                .when(a).getIsValid();

        // Act
        callHitOnAWhileAIsValidIsTrue(a);

        // Assert
        verify(a);
    }

    @Test
    public void nTimesCallHitOnA() {
        // Arrange
        var a = mock(ITarget.class);
        var n = 132;

        // Act
        nTimesCallHitOnA(n, a);

        // Assert
        verify(a, times(n)).hit();
    }

    @Test
    public void callHitOnAOnceAndContinueUntilIsValidIsFalse() {
        // Arrange
        var a = mock(ITarget.class);
        doReturn(true, true, true, true, false)
                .when(a).getIsValid();

        // Act
        callHitOnAOnceAndLoopUntilIsValidIsFalse(a);

        // Assert
        verify(a, times(5)).hit();
    }

    protected abstract void callHitOnAIfValIsTrueElseCallHitOnB(boolean val, ITarget a, ITarget b);

    protected abstract void callHitOnAOnceForEachMemberOfList(ITarget a, Collection<String> list);

    protected abstract void callHitOnAWhileAIsValidIsTrue(ITarget a);

    protected abstract void nTimesCallHitOnA(int n, ITarget a);

    protected abstract void callHitOnAOnceAndLoopUntilIsValidIsFalse(ITarget a);

}
