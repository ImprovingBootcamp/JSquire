package framework.bases;

import framework.Target;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

public abstract class ControlStructuresKihonBase {
    @Test
    public void callHitOnAIfValIsTrueElseCallHitOnBv1() {
        // Arrange
        var a = mock(Target.class);
        var b = mock(Target.class);
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
        var a = mock(Target.class);
        var b = mock(Target.class);
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
        var a = mock(Target.class);
        var list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

        // Act
        callHitOnAOnceForEachMemberOfList(a, list);

        // Assert
        verify(a, times(4)).hit();
    }

    @Test
    public void callHitOnAWhileAIsValidIsTrue() {
        // Arrange
        var a = mock(Target.class);
        doReturn(true, true, true, true, false)
                .when(a).isValid();

        // Act
        callHitOnAWhileAIsValidIsTrue(a);

        // Assert
        verify(a, times(5)).isValid();
    }

    @Test
    public void nTimesCallHitOnA() {
        // Arrange
        var a = mock(Target.class);
        var n = 132;

        // Act
        nTimesCallHitOnA(n, a);

        // Assert
        verify(a, times(n)).hit();
    }

    @Test
    public void callHitOnAOnceAndContinueUntilIsValidIsFalse() {
        // Arrange
        var a = mock(Target.class);
        doReturn(true, true, true, true, false)
                .when(a).isValid();

        // Act
        callHitOnAOnceAndLoopUntilIsValidIsFalse(a);

        // Assert
        verify(a, times(5)).hit();
    }

    protected abstract void callHitOnAIfValIsTrueElseCallHitOnB(boolean val, Target a, Target b);

    protected abstract void callHitOnAOnceForEachMemberOfList(Target a, Collection<String> list);

    protected abstract void callHitOnAWhileAIsValidIsTrue(Target a);

    protected abstract void nTimesCallHitOnA(int n, Target a);

    protected abstract void callHitOnAOnceAndLoopUntilIsValidIsFalse(Target a);

}
