package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.CoreMotionScene;
import kotlin.Metadata;
/* compiled from: MotionScene.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/MotionScene;", "Landroidx/constraintlayout/core/state/CoreMotionScene;", "getConstraintSetInstance", "Landroidx/constraintlayout/compose/ConstraintSet;", "name", "", "getTransitionInstance", "Landroidx/constraintlayout/compose/Transition;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MotionScene extends CoreMotionScene {
    ConstraintSet getConstraintSetInstance(String str);

    Transition getTransitionInstance(String str);
}
