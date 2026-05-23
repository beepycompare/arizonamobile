package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: AnimateBoundsModifier.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u001dJ\u001d\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b*\u0010+J6\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020DJ\u0018\u0010E\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020DH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010!\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\"\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u001dR\u0013\u0010%\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010,\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b,\u0010-R/\u0010/\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b0\u0010'\"\u0004\b1\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b5\u0010'R\u0016\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006F"}, d2 = {"Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "", "<init>", "()V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "value", "Landroidx/compose/ui/geometry/Size;", "targetSize", "getTargetSize-NH-jbRc", "()J", "J", "Landroidx/compose/ui/geometry/Offset;", "targetOffset", "getTargetOffset-F1C5BW0", "isPending", "", "lookaheadAnimationVisualDebugHelper", "Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "getLookaheadAnimationVisualDebugHelper", "()Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "setLookaheadAnimationVisualDebugHelper", "(Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;)V", "updateTargetSize", "", "size", "updateTargetSize-uvyYCjk", "(J)V", "updateTargetOffset", TypedValues.CycleType.S_WAVE_OFFSET, "updateTargetOffset-k-4lQ0M", "currentPosition", "currentSize", "getCurrentSize-NH-jbRc", "setCurrentSize-uvyYCjk", "currentBounds", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "updateCurrentBounds", "position", "updateCurrentBounds-tz77jQw", "(JJ)V", "isIdle", "()Z", "<set-?>", "animatedValue", "getAnimatedValue", "setAnimatedValue", "(Landroidx/compose/ui/geometry/Rect;)V", "animatedValue$delegate", "Landroidx/compose/runtime/MutableState;", "getValue", "directManipulationParents", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "additionalOffset", "updateTargetOffsetAndAnimate", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "directManipulationParentsDirty", "includeMotionFrameOfReference", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animate", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BoundsTransformDeferredAnimation {
    public static final int $stable = 8;
    private long additionalOffset;
    private Animatable<Rect, AnimationVector4D> animatable;
    private final MutableState animatedValue$delegate;
    private List<LayoutCoordinates> directManipulationParents;
    private boolean isPending;
    private LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
    private long targetSize = Size.Companion.m5180getUnspecifiedNHjbRc();
    private long targetOffset = Offset.Companion.m5118getUnspecifiedF1C5BW0();
    private long currentPosition = Offset.Companion.m5118getUnspecifiedF1C5BW0();
    private long currentSize = Size.Companion.m5180getUnspecifiedNHjbRc();

    public BoundsTransformDeferredAnimation() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animatedValue$delegate = mutableStateOf$default;
        this.additionalOffset = Offset.Companion.m5119getZeroF1C5BW0();
    }

    /* renamed from: getTargetSize-NH-jbRc  reason: not valid java name */
    public final long m79getTargetSizeNHjbRc() {
        return this.targetSize;
    }

    /* renamed from: getTargetOffset-F1C5BW0  reason: not valid java name */
    public final long m78getTargetOffsetF1C5BW0() {
        return this.targetOffset;
    }

    public final LookaheadAnimationVisualDebugHelper getLookaheadAnimationVisualDebugHelper() {
        return this.lookaheadAnimationVisualDebugHelper;
    }

    public final void setLookaheadAnimationVisualDebugHelper(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper) {
        this.lookaheadAnimationVisualDebugHelper = lookaheadAnimationVisualDebugHelper;
    }

    /* renamed from: updateTargetSize-uvyYCjk  reason: not valid java name */
    public final void m82updateTargetSizeuvyYCjk(long j) {
        if (this.targetSize != InlineClassHelperKt.UnspecifiedPackedFloats && !IntSize.m8329equalsimpl0(IntSizeKt.m8339roundToIntSizeuvyYCjk(j), IntSizeKt.m8339roundToIntSizeuvyYCjk(this.targetSize))) {
            this.isPending = true;
        }
        this.targetSize = j;
        if (this.currentSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.currentSize = j;
        }
    }

    /* renamed from: updateTargetOffset-k-4lQ0M  reason: not valid java name */
    private final void m76updateTargetOffsetk4lQ0M(long j) {
        if ((this.targetOffset & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats && !IntOffset.m8287equalsimpl0(IntOffsetKt.m8305roundk4lQ0M(j), IntOffsetKt.m8305roundk4lQ0M(this.targetOffset))) {
            this.isPending = true;
        }
        this.targetOffset = j;
        if ((this.currentPosition & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.currentPosition = j;
        }
    }

    /* renamed from: getCurrentSize-NH-jbRc  reason: not valid java name */
    public final long m77getCurrentSizeNHjbRc() {
        return this.currentSize;
    }

    /* renamed from: setCurrentSize-uvyYCjk  reason: not valid java name */
    public final void m80setCurrentSizeuvyYCjk(long j) {
        this.currentSize = j;
    }

    public final Rect getCurrentBounds() {
        long j = this.currentSize;
        long j2 = this.currentPosition;
        if ((9223372034707292159L & j2) == InlineClassHelperKt.UnspecifiedPackedFloats || j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return null;
        }
        return RectKt.m5143Recttz77jQw(j2, j);
    }

    /* renamed from: updateCurrentBounds-tz77jQw  reason: not valid java name */
    public final void m81updateCurrentBoundstz77jQw(long j, long j2) {
        this.currentPosition = j;
        this.currentSize = j2;
    }

    public final boolean isIdle() {
        if (this.isPending) {
            return false;
        }
        Animatable<Rect, AnimationVector4D> animatable = this.animatable;
        return animatable == null || !animatable.isRunning();
    }

    private final Rect getAnimatedValue() {
        return (Rect) this.animatedValue$delegate.getValue();
    }

    private final void setAnimatedValue(Rect rect) {
        this.animatedValue$delegate.setValue(rect);
    }

    public final Rect getValue() {
        if (isIdle()) {
            return null;
        }
        return getAnimatedValue();
    }

    public final void updateTargetOffsetAndAnimate(LookaheadScope lookaheadScope, Placeable.PlacementScope placementScope, CoroutineScope coroutineScope, boolean z, boolean z2, BoundsTransform boundsTransform) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates != null) {
            LayoutCoordinates lookaheadScopeCoordinates = lookaheadScope.getLookaheadScopeCoordinates(placementScope);
            long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
            if (!z2 && z) {
                ArrayList arrayList = this.directManipulationParents;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int i = 0;
                LayoutCoordinates layoutCoordinates = coordinates;
                while (!Intrinsics.areEqual(lookaheadScope.toLookaheadCoordinates(layoutCoordinates), lookaheadScopeCoordinates)) {
                    if (layoutCoordinates.getIntroducesMotionFrameOfReference()) {
                        if (arrayList.size() == i) {
                            arrayList.add(layoutCoordinates);
                            m5119getZeroF1C5BW0 = Offset.m5108plusMKHz9U(m5119getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(layoutCoordinates));
                        } else if (!Intrinsics.areEqual(arrayList.get(i), layoutCoordinates)) {
                            long m5107minusMKHz9U = Offset.m5107minusMKHz9U(m5119getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(arrayList.get(i)));
                            arrayList.set(i, layoutCoordinates);
                            m5119getZeroF1C5BW0 = Offset.m5108plusMKHz9U(m5107minusMKHz9U, LayoutCoordinatesKt.positionInParent(layoutCoordinates));
                        }
                        i++;
                    }
                    layoutCoordinates = layoutCoordinates.getParentCoordinates();
                    if (layoutCoordinates == null) {
                        break;
                    }
                }
                int size = arrayList.size() - 1;
                if (i <= size) {
                    while (true) {
                        m5119getZeroF1C5BW0 = Offset.m5107minusMKHz9U(m5119getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(arrayList.get(size)));
                        arrayList.remove(arrayList.size() - 1);
                        if (size == i) {
                            break;
                        }
                        size--;
                    }
                }
                this.directManipulationParents = arrayList;
            }
            this.additionalOffset = Offset.m5108plusMKHz9U(this.additionalOffset, m5119getZeroF1C5BW0);
            m76updateTargetOffsetk4lQ0M(Offset.m5108plusMKHz9U(LookaheadScope.m6848localLookaheadPositionOfauaQtc$default(lookaheadScope, lookaheadScopeCoordinates, coordinates, 0L, z2, 2, null), this.additionalOffset));
            setAnimatedValue(animate(coroutineScope, boundsTransform).m5140translatek4lQ0M(Offset.m5095constructorimpl(this.additionalOffset ^ (-9223372034707292160L))));
        }
    }

    private final Rect animate(CoroutineScope coroutineScope, BoundsTransform boundsTransform) {
        Rect value;
        LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
        long j = this.targetOffset;
        if ((9223372034707292159L & j) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            long j2 = this.targetSize;
            if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                Rect m5143Recttz77jQw = RectKt.m5143Recttz77jQw(j, j2);
                Animatable<Rect, AnimationVector4D> animatable = this.animatable;
                if (animatable == null) {
                    animatable = new Animatable<>(m5143Recttz77jQw, VectorConvertersKt.getVectorConverter(Rect.Companion), null, null, 12, null);
                }
                this.animatable = animatable;
                if (this.isPending) {
                    this.isPending = false;
                    if (IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled() && (lookaheadAnimationVisualDebugHelper = this.lookaheadAnimationVisualDebugHelper) != null) {
                        Intrinsics.checkNotNull(lookaheadAnimationVisualDebugHelper);
                        Rect currentBounds = getCurrentBounds();
                        Intrinsics.checkNotNull(currentBounds);
                        FiniteAnimationSpec<Rect> createAnimationSpec = boundsTransform.createAnimationSpec(currentBounds, m5143Recttz77jQw);
                        Rect currentBounds2 = getCurrentBounds();
                        Intrinsics.checkNotNull(currentBounds2);
                        lookaheadAnimationVisualDebugHelper.calculatePath$animation(createAnimationSpec, currentBounds2, m5143Recttz77jQw, animatable.getVelocity());
                    }
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new BoundsTransformDeferredAnimation$animate$1(animatable, m5143Recttz77jQw, boundsTransform, this, null), 1, null);
                }
            }
        }
        Animatable<Rect, AnimationVector4D> animatable2 = this.animatable;
        return (animatable2 == null || (value = animatable2.getValue()) == null) ? Rect.Companion.getZero() : value;
    }
}
