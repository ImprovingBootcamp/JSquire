package kihons;

import framework.bases.ControlStructuresKihonBase;
import framework.exceptions.NotImplementedYetException;
import framework.Target;

import java.util.Collection;

public class ControlStructuresKihon extends ControlStructuresKihonBase {
    @Override
    protected void callHitOnAIfValIsTrueElseCallHitOnB(boolean val, Target a, Target b) {
        throw new NotImplementedYetException();
    }

    @Override
    protected void callHitOnAOnceForEachMemberOfList(Target a, Collection<String> list) {
        throw new NotImplementedYetException();
    }

    @Override
    protected void callHitOnAWhileAIsValidIsTrue(Target a) {
        throw new NotImplementedYetException();
    }

    @Override
    protected void nTimesCallHitOnA(int n, Target a) {
        throw new NotImplementedYetException();
    }

    @Override
    protected void callHitOnAOnceAndLoopUntilIsValidIsFalse(Target a) {
        throw new NotImplementedYetException();
    }
}
