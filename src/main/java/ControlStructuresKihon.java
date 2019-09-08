import framework.ControlStructuresKihonBase;
import framework.ITarget;

import java.util.Collection;

public class ControlStructuresKihon extends ControlStructuresKihonBase {
    @Override
    protected void callHitOnAIfValIsTrueElseCallHitOnB(boolean val, ITarget a, ITarget b) {
        if (val) a.hit();
        else b.hit();
    }

    @Override
    protected void callHitOnAOnceForEachMemberOfList(ITarget a, Collection<String> list) {
        for (String s :
                list) {
            a.hit();
        }
    }

    @Override
    protected void callHitOnAWhileAIsValidIsTrue(ITarget a) {
        while (a.getIsValid()) {
            a.hit();
        }
    }

    @Override
    protected void nTimesCallHitOnA(int n, ITarget a) {
        for (int i = 0; i < n; i++) {
            a.hit();
        }
    }

    @Override
    protected void callHitOnAOnceAndLoopUntilIsValidIsFalse(ITarget a) {
        do {
            a.hit();
        } while (a.getIsValid());
    }
}
