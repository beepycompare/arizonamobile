package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
/* compiled from: IndirectPointerInputDragCycleDetector.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\b\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\u0002H\u0002\u001a\f\u0010\u000e\u001a\u00020\f*\u00020\u0002H\u0000\u001a1\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\b\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\b\u001a?\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!\"\u000e\u0010\"\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"positionChange", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "positionChange-_bfSUIo", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)J", "positionChangeIgnoreConsumed", "positionChangeIgnoreConsumed-_bfSUIo", "changedToUpIgnoreConsumed", "", "changedToDown", "changedToDownIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "positionChangeInternal-wfG_k4k", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;Z)J", "primaryAxisPosition", "primaryAxisPosition-_bfSUIo", "primaryAxisPosition-grjNGvw", "(JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)J", "primaryAxisPreviousPosition", "primaryAxisPreviousPosition-_bfSUIo", "addIndirectPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", NotificationCompat.CATEGORY_EVENT, "smoother", "Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "nodeOffset", "addIndirectPointerInputChange-Qf4Zb88", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;J)V", "SmoothingFactor", "", "PixelSensibility", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndirectPointerInputDragCycleDetectorKt {
    private static final int PixelSensibility = 2;
    private static final int SmoothingFactor = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: positionChange-_bfSUIo  reason: not valid java name */
    public static final long m545positionChange_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        return m547positionChangeInternalwfG_k4k(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: positionChangeIgnoreConsumed-_bfSUIo  reason: not valid java name */
    public static final long m546positionChangeIgnoreConsumed_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        return m547positionChangeInternalwfG_k4k(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean changedToUpIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return indirectPointerInputChange.getPreviousPressed() && !indirectPointerInputChange.getPressed();
    }

    private static final boolean changedToDown(IndirectPointerInputChange indirectPointerInputChange) {
        return (indirectPointerInputChange.isConsumed() || indirectPointerInputChange.getPreviousPressed() || !indirectPointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return !indirectPointerInputChange.getPreviousPressed() && indirectPointerInputChange.getPressed();
    }

    /* renamed from: positionChangeInternal-wfG_k4k$default  reason: not valid java name */
    static /* synthetic */ long m548positionChangeInternalwfG_k4k$default(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m547positionChangeInternalwfG_k4k(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis, z);
    }

    /* renamed from: positionChangeInternal-wfG_k4k  reason: not valid java name */
    private static final long m547positionChangeInternalwfG_k4k(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, boolean z) {
        return (z || !indirectPointerInputChange.isConsumed()) ? Offset.m5107minusMKHz9U(m549primaryAxisPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis), m551primaryAxisPreviousPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis)) : Offset.Companion.m5119getZeroF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: primaryAxisPosition-_bfSUIo  reason: not valid java name */
    public static final long m549primaryAxisPosition_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float intBitsToFloat;
        if (orientation == null) {
            return indirectPointerInputChange.m6190getPositionF1C5BW0();
        }
        if (indirectPointerEventPrimaryDirectionalMotionAxis == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.m6171equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6176getXnZO2Niw())) {
            intBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.m6190getPositionF1C5BW0() >> 32));
        } else {
            if (!(indirectPointerEventPrimaryDirectionalMotionAxis != null ? IndirectPointerEventPrimaryDirectionalMotionAxis.m6171equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6177getYnZO2Niw()) : false)) {
                return indirectPointerInputChange.m6190getPositionF1C5BW0();
            }
            intBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.m6190getPositionF1C5BW0() & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
    }

    /* renamed from: primaryAxisPosition-grjNGvw  reason: not valid java name */
    private static final long m550primaryAxisPositiongrjNGvw(long j, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float intBitsToFloat;
        if (orientation == null) {
            return j;
        }
        if (indirectPointerEventPrimaryDirectionalMotionAxis == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.m6171equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6176getXnZO2Niw())) {
            intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        } else {
            if (!(indirectPointerEventPrimaryDirectionalMotionAxis != null ? IndirectPointerEventPrimaryDirectionalMotionAxis.m6171equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6177getYnZO2Niw()) : false)) {
                return j;
            }
            intBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
    }

    /* renamed from: primaryAxisPreviousPosition-_bfSUIo  reason: not valid java name */
    private static final long m551primaryAxisPreviousPosition_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float intBitsToFloat;
        if (orientation == null) {
            return indirectPointerInputChange.m6191getPreviousPositionF1C5BW0();
        }
        if (indirectPointerEventPrimaryDirectionalMotionAxis == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.m6171equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6176getXnZO2Niw())) {
            intBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.m6191getPreviousPositionF1C5BW0() >> 32));
        } else {
            if (!(indirectPointerEventPrimaryDirectionalMotionAxis != null ? IndirectPointerEventPrimaryDirectionalMotionAxis.m6171equalsimpl0(indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl(), IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.m6177getYnZO2Niw()) : false)) {
                return indirectPointerInputChange.m6191getPreviousPositionF1C5BW0();
            }
            intBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.m6191getPreviousPositionF1C5BW0() & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addIndirectPointerInputChange-Qf4Zb88  reason: not valid java name */
    public static final void m544addIndirectPointerInputChangeQf4Zb88(VelocityTracker velocityTracker, IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, IndirectPointerInputEventSmoother indirectPointerInputEventSmoother, long j) {
        velocityTracker.m6791addPositionUv8p0NA(indirectPointerInputChange.getUptimeMillis(), Offset.m5108plusMKHz9U(m550primaryAxisPositiongrjNGvw(indirectPointerInputEventSmoother.m552smoothEventPositiontuRUvjQ(indirectPointerInputChange), orientation, indirectPointerEventPrimaryDirectionalMotionAxis), j));
    }
}
