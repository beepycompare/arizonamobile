package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;
/* compiled from: Pager.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\f*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "consumeOnOrientation", "consumeOnOrientation-QWom1Mo", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    public DefaultPagerNestedScrollConnection(PagerState pagerState, Orientation orientation) {
        this.state = pagerState;
        this.orientation = orientation;
    }

    public final PagerState getState() {
        return this.state;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: consumeOnOrientation-QWom1Mo  reason: not valid java name */
    public final long m978consumeOnOrientationQWom1Mo(long j, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return Velocity.m6918copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
        }
        return Velocity.m6918copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo816onPreScrollOzD1aCk(long j, int i) {
        if (NestedScrollSource.m5194equalsimpl0(i, NestedScrollSource.Companion.m5206getUserInputWNlRxjI()) && Math.abs(this.state.getCurrentPageOffsetFraction()) > 1.0E-6d) {
            float currentPageOffsetFraction = this.state.getCurrentPageOffsetFraction() * this.state.getPageSize$foundation_release();
            float pageSize = ((this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing()) * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + currentPageOffsetFraction;
            if (this.state.getCurrentPageOffsetFraction() > 0.0f) {
                pageSize = currentPageOffsetFraction;
                currentPageOffsetFraction = pageSize;
            }
            float f = -this.state.dispatchRawDelta(-RangesKt.coerceIn(Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L)), currentPageOffsetFraction, pageSize));
            float intBitsToFloat = this.orientation == Orientation.Horizontal ? f : Float.intBitsToFloat((int) (j >> 32));
            if (this.orientation != Orientation.Vertical) {
                f = Float.intBitsToFloat((int) (j & 4294967295L));
            }
            return Offset.m3830copydBAh8RU(j, intBitsToFloat, f);
        }
        return Offset.Companion.m3853getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo510onPostScrollDzOQY0M(long j, long j2, int i) {
        if (NestedScrollSource.m5194equalsimpl0(i, NestedScrollSource.Companion.m5205getSideEffectWNlRxjI()) && m977mainAxisk4lQ0M(j2) != 0.0f) {
            throw new CancellationException("Scroll cancelled");
        }
        return Offset.Companion.m3853getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo509onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return Velocity.m6913boximpl(m978consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    /* renamed from: mainAxis-k-4lQ0M  reason: not valid java name */
    private final float m977mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }
}
