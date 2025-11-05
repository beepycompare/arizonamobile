package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b\u000f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "addPointerInputChange-dBAh8RU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)J", "reset", "", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private final Orientation orientation;
    private long totalPositionChange;

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, j);
    }

    private TouchSlopDetector(Orientation orientation, long j) {
        this.orientation = orientation;
        this.totalPositionChange = j;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation, (i & 2) != 0 ? Offset.Companion.m5051getZeroF1C5BW0() : j, null);
    }

    /* renamed from: mainAxis-k-4lQ0M  reason: not valid java name */
    public final float m611mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* renamed from: crossAxis-k-4lQ0M  reason: not valid java name */
    public final float m610crossAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j & 4294967295L : j >> 32));
    }

    /* renamed from: addPointerInputChange-dBAh8RU  reason: not valid java name */
    public final long m609addPointerInputChangedBAh8RU(PointerInputChange pointerInputChange, float f) {
        float abs;
        long m5040plusMKHz9U = Offset.m5040plusMKHz9U(this.totalPositionChange, Offset.m5039minusMKHz9U(pointerInputChange.m6569getPositionF1C5BW0(), pointerInputChange.m6570getPreviousPositionF1C5BW0()));
        this.totalPositionChange = m5040plusMKHz9U;
        if (this.orientation == null) {
            abs = Offset.m5033getDistanceimpl(m5040plusMKHz9U);
        } else {
            abs = Math.abs(m611mainAxisk4lQ0M(m5040plusMKHz9U));
        }
        if (abs >= f) {
            return m608calculatePostSlopOffsettuRUvjQ(f);
        }
        return Offset.Companion.m5050getUnspecifiedF1C5BW0();
    }

    public final void reset() {
        this.totalPositionChange = Offset.Companion.m5051getZeroF1C5BW0();
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ  reason: not valid java name */
    private final long m608calculatePostSlopOffsettuRUvjQ(float f) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m5039minusMKHz9U(this.totalPositionChange, Offset.m5042timestuRUvjQ(Offset.m5030divtuRUvjQ(j, Offset.m5033getDistanceimpl(j)), f));
        }
        float m611mainAxisk4lQ0M = m611mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m611mainAxisk4lQ0M(this.totalPositionChange)) * f);
        float m610crossAxisk4lQ0M = m610crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m5027constructorimpl((Float.floatToRawIntBits(m611mainAxisk4lQ0M) << 32) | (Float.floatToRawIntBits(m610crossAxisk4lQ0M) & 4294967295L));
        }
        return Offset.m5027constructorimpl((Float.floatToRawIntBits(m610crossAxisk4lQ0M) << 32) | (Float.floatToRawIntBits(m611mainAxisk4lQ0M) & 4294967295L));
    }
}
