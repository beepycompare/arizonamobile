package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.Metadata;
/* compiled from: BringIntoViewSpec.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038WX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getScrollAnimationSpec$annotations", "()V", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "calculateScrollDistance", TypedValues.CycleType.S_WAVE_OFFSET, "size", "containerSize", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface BringIntoViewSpec {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Deprecated(message = "Animation spec customization is no longer supported.")
    static /* synthetic */ void getScrollAnimationSpec$annotations() {
    }

    @Deprecated(message = "Animation spec customization is no longer supported.")
    default AnimationSpec<Float> getScrollAnimationSpec() {
        return Companion.getDefaultScrollAnimationSpec$foundation_release();
    }

    default float calculateScrollDistance(float f, float f2, float f3) {
        return Companion.defaultCalculateScrollDistance$foundation_release(f, f2, f3);
    }

    /* compiled from: BringIntoViewSpec.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewSpec$Companion;", "", "()V", "DefaultBringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getDefaultBringIntoViewSpec$foundation_release", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "DefaultScrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getDefaultScrollAnimationSpec$foundation_release", "()Landroidx/compose/animation/core/AnimationSpec;", "defaultCalculateScrollDistance", TypedValues.CycleType.S_WAVE_OFFSET, "size", "containerSize", "defaultCalculateScrollDistance$foundation_release", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final AnimationSpec<Float> DefaultScrollAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        private static final BringIntoViewSpec DefaultBringIntoViewSpec = new BringIntoViewSpec() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1
        };

        private Companion() {
        }

        public final AnimationSpec<Float> getDefaultScrollAnimationSpec$foundation_release() {
            return DefaultScrollAnimationSpec;
        }

        public final BringIntoViewSpec getDefaultBringIntoViewSpec$foundation_release() {
            return DefaultBringIntoViewSpec;
        }

        public final float defaultCalculateScrollDistance$foundation_release(float f, float f2, float f3) {
            float f4 = f2 + f;
            if (f < 0.0f || f4 > f3) {
                if (f >= 0.0f || f4 <= f3) {
                    float f5 = f4 - f3;
                    return Math.abs(f) < Math.abs(f5) ? f : f5;
                }
                return 0.0f;
            }
            return 0.0f;
        }
    }
}
