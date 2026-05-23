package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "getPostSlopOffset", "positionChange", "touchSlop", "shouldCommit", "", "getPostSlopOffset-qto3Fdw", "(JFZ)J", "reset", "", "initialPositionAccumulator", "reset-k-4lQ0M", "(J)V", "isDeltaAtAngleOfInterest", "delta", "isDeltaAtAngleOfInterest-k-4lQ0M", "(J)Z", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private Orientation orientation;
    private long totalPositionChange;

    /* compiled from: DragGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Horizontal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Vertical.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

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
        this((i & 1) != 0 ? null : orientation, (i & 2) != 0 ? Offset.Companion.m5119getZeroF1C5BW0() : j, null);
    }

    /* renamed from: mainAxis-k-4lQ0M  reason: not valid java name */
    public final float m640mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* renamed from: crossAxis-k-4lQ0M  reason: not valid java name */
    public final float m637crossAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j & 4294967295L : j >> 32));
    }

    /* renamed from: getPostSlopOffset-qto3Fdw$default  reason: not valid java name */
    public static /* synthetic */ long m635getPostSlopOffsetqto3Fdw$default(TouchSlopDetector touchSlopDetector, long j, float f, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return touchSlopDetector.m638getPostSlopOffsetqto3Fdw(j, f, z);
    }

    /* renamed from: getPostSlopOffset-qto3Fdw  reason: not valid java name */
    public final long m638getPostSlopOffsetqto3Fdw(long j, float f, boolean z) {
        long m5108plusMKHz9U;
        float abs;
        long j2 = this.totalPositionChange;
        if (z) {
            m5108plusMKHz9U = Offset.m5108plusMKHz9U(j2, j);
            this.totalPositionChange = m5108plusMKHz9U;
        } else {
            m5108plusMKHz9U = Offset.m5108plusMKHz9U(j2, j);
        }
        if (this.orientation == null) {
            abs = Offset.m5101getDistanceimpl(m5108plusMKHz9U);
        } else {
            abs = Math.abs(m640mainAxisk4lQ0M(m5108plusMKHz9U));
        }
        if (abs >= f) {
            return m634calculatePostSlopOffsettuRUvjQ(f);
        }
        return Offset.Companion.m5118getUnspecifiedF1C5BW0();
    }

    /* renamed from: reset-k-4lQ0M$default  reason: not valid java name */
    public static /* synthetic */ void m636resetk4lQ0M$default(TouchSlopDetector touchSlopDetector, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.Companion.m5119getZeroF1C5BW0();
        }
        touchSlopDetector.m641resetk4lQ0M(j);
    }

    /* renamed from: reset-k-4lQ0M  reason: not valid java name */
    public final void m641resetk4lQ0M(long j) {
        this.totalPositionChange = j;
    }

    /* renamed from: isDeltaAtAngleOfInterest-k-4lQ0M  reason: not valid java name */
    public final boolean m639isDeltaAtAngleOfInterestk4lQ0M(long j) {
        long m5108plusMKHz9U = Offset.m5108plusMKHz9U(this.totalPositionChange, j);
        double atan2 = (((float) Math.atan2(Math.abs(Float.intBitsToFloat((int) (m5108plusMKHz9U & 4294967295L))), Math.abs(Float.intBitsToFloat((int) (m5108plusMKHz9U >> 32))))) * 180.0f) / 3.141592653589793d;
        Orientation orientation = this.orientation;
        int i = orientation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        return i != 1 ? i == 2 && atan2 > 30.0d : atan2 < 30.0d;
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ  reason: not valid java name */
    private final long m634calculatePostSlopOffsettuRUvjQ(float f) {
        Orientation orientation = this.orientation;
        long j = this.totalPositionChange;
        if (orientation == null) {
            return Offset.m5107minusMKHz9U(this.totalPositionChange, Offset.m5110timestuRUvjQ(Offset.m5098divtuRUvjQ(j, Offset.m5101getDistanceimpl(j)), f));
        }
        float m640mainAxisk4lQ0M = m640mainAxisk4lQ0M(j) - (Math.signum(m640mainAxisk4lQ0M(this.totalPositionChange)) * f);
        float m637crossAxisk4lQ0M = m637crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(m637crossAxisk4lQ0M) & 4294967295L) | (Float.floatToRawIntBits(m640mainAxisk4lQ0M) << 32));
        }
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(m637crossAxisk4lQ0M) << 32) | (Float.floatToRawIntBits(m640mainAxisk4lQ0M) & 4294967295L));
    }
}
