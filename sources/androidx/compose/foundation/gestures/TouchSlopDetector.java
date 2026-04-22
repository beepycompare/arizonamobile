package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "addPositions", "currentPosition", "previousPosition", "touchSlop", "addPositions-akrDWew", "(JJF)J", "reset", "", "initialPositionAccumulator", "reset-k-4lQ0M", "(J)V", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private Orientation orientation;
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

    public final void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation, (i & 2) != 0 ? Offset.Companion.m4543getZeroF1C5BW0() : j, null);
    }

    /* renamed from: mainAxis-k-4lQ0M  reason: not valid java name */
    public final float m606mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* renamed from: crossAxis-k-4lQ0M  reason: not valid java name */
    public final float m605crossAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j & 4294967295L : j >> 32));
    }

    /* renamed from: addPositions-akrDWew  reason: not valid java name */
    public final long m604addPositionsakrDWew(long j, long j2, float f) {
        float abs;
        long m4532plusMKHz9U = Offset.m4532plusMKHz9U(this.totalPositionChange, Offset.m4531minusMKHz9U(j, j2));
        this.totalPositionChange = m4532plusMKHz9U;
        if (this.orientation == null) {
            abs = Offset.m4525getDistanceimpl(m4532plusMKHz9U);
        } else {
            abs = Math.abs(m606mainAxisk4lQ0M(m4532plusMKHz9U));
        }
        if (abs >= f) {
            return m602calculatePostSlopOffsettuRUvjQ(f);
        }
        return Offset.Companion.m4542getUnspecifiedF1C5BW0();
    }

    /* renamed from: reset-k-4lQ0M$default  reason: not valid java name */
    public static /* synthetic */ void m603resetk4lQ0M$default(TouchSlopDetector touchSlopDetector, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.Companion.m4543getZeroF1C5BW0();
        }
        touchSlopDetector.m607resetk4lQ0M(j);
    }

    /* renamed from: reset-k-4lQ0M  reason: not valid java name */
    public final void m607resetk4lQ0M(long j) {
        this.totalPositionChange = j;
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ  reason: not valid java name */
    private final long m602calculatePostSlopOffsettuRUvjQ(float f) {
        Orientation orientation = this.orientation;
        long j = this.totalPositionChange;
        if (orientation == null) {
            return Offset.m4531minusMKHz9U(this.totalPositionChange, Offset.m4534timestuRUvjQ(Offset.m4522divtuRUvjQ(j, Offset.m4525getDistanceimpl(j)), f));
        }
        float m606mainAxisk4lQ0M = m606mainAxisk4lQ0M(j) - (Math.signum(m606mainAxisk4lQ0M(this.totalPositionChange)) * f);
        float m605crossAxisk4lQ0M = m605crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m4519constructorimpl((Float.floatToRawIntBits(m605crossAxisk4lQ0M) & 4294967295L) | (Float.floatToRawIntBits(m606mainAxisk4lQ0M) << 32));
        }
        return Offset.m4519constructorimpl((Float.floatToRawIntBits(m605crossAxisk4lQ0M) << 32) | (Float.floatToRawIntBits(m606mainAxisk4lQ0M) & 4294967295L));
    }
}
