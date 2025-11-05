package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LookaheadLayoutCoordinates.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010%J\u0017\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020 H\u0016¢\u0006\u0004\b+\u0010%J\u0017\u0010,\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010%J\u0017\u0010.\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b/\u0010%J\u001f\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020 H\u0016¢\u0006\u0004\b3\u00104J'\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020 2\u0006\u00105\u001a\u00020\u001bH\u0016¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u0002092\u0006\u00101\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u001bH\u0016J\u001f\u0010;\u001a\u00020<2\u0006\u00101\u001a\u00020\u00012\u0006\u0010=\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016¢\u0006\u0004\bB\u0010CJ\u0011\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0012H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000f¨\u0006G"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "getParentCoordinates", "isAttached", "", "()Z", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "localToRoot", "localToRoot-MK-Hz9U", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "clipBounds", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "get", "", "alignmentLine", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable = 0;
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo6705getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSize.m8161constructorimpl((lookaheadDelegate.getWidth() << 32) | (lookaheadDelegate.getHeight() & 4294967295L));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy$ui_release = getCoordinator().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return this.lookaheadDelegate.isPlacedUnderMotionFrameOfReference();
    }

    /* renamed from: getLookaheadOffset-F1C5BW0  reason: not valid java name */
    private final long m6725getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m5039minusMKHz9U(mo6706localPositionOfR5De75A(rootLookaheadDelegate.getCoordinates(), Offset.Companion.m5051getZeroF1C5BW0()), getCoordinator().mo6706localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), Offset.Companion.m5051getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo6711screenToLocalMKHz9U(long j) {
        return Offset.m5040plusMKHz9U(getCoordinator().mo6711screenToLocalMKHz9U(j), m6725getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo6709localToScreenMKHz9U(long j) {
        return getCoordinator().mo6709localToScreenMKHz9U(Offset.m5040plusMKHz9U(j, m6725getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo6714windowToLocalMKHz9U(long j) {
        return Offset.m5040plusMKHz9U(getCoordinator().mo6714windowToLocalMKHz9U(j), m6725getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo6710localToWindowMKHz9U(long j) {
        return getCoordinator().mo6710localToWindowMKHz9U(Offset.m5040plusMKHz9U(j, m6725getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo6708localToRootMKHz9U(long j) {
        return getCoordinator().mo6708localToRootMKHz9U(Offset.m5040plusMKHz9U(j, m6725getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo6706localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo6707localPositionOfS_NoaFU(layoutCoordinates, j, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo6707localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinates) layoutCoordinates).lookaheadDelegate;
            lookaheadDelegate.getCoordinator().onCoordinatesUsed$ui_release();
            LookaheadDelegate lookaheadDelegate2 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                long m8126minusqkQi6aY = IntOffset.m8126minusqkQi6aY(IntOffset.m8127plusqkQi6aY(lookaheadDelegate.m6928positionIniSbpLlY$ui_release(lookaheadDelegate2, !z), IntOffsetKt.m8140roundk4lQ0M(j)), this.lookaheadDelegate.m6928positionIniSbpLlY$ui_release(lookaheadDelegate2, !z));
                return Offset.m5027constructorimpl((Float.floatToRawIntBits(IntOffset.m8123getXimpl(m8126minusqkQi6aY)) << 32) | (Float.floatToRawIntBits(IntOffset.m8124getYimpl(m8126minusqkQi6aY)) & 4294967295L));
            }
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
            long m8127plusqkQi6aY = IntOffset.m8127plusqkQi6aY(IntOffset.m8127plusqkQi6aY(lookaheadDelegate.m6928positionIniSbpLlY$ui_release(rootLookaheadDelegate, !z), rootLookaheadDelegate.mo6917getPositionnOccac()), IntOffsetKt.m8140roundk4lQ0M(j));
            LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            long m8126minusqkQi6aY2 = IntOffset.m8126minusqkQi6aY(m8127plusqkQi6aY, IntOffset.m8127plusqkQi6aY(this.lookaheadDelegate.m6928positionIniSbpLlY$ui_release(rootLookaheadDelegate2, !z), rootLookaheadDelegate2.mo6917getPositionnOccac()));
            long m5027constructorimpl = Offset.m5027constructorimpl((Float.floatToRawIntBits(IntOffset.m8124getYimpl(m8126minusqkQi6aY2)) & 4294967295L) | (Float.floatToRawIntBits(IntOffset.m8123getXimpl(m8126minusqkQi6aY2)) << 32));
            NodeCoordinator wrappedBy$ui_release = rootLookaheadDelegate2.getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            NodeCoordinator wrappedBy$ui_release2 = rootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release2);
            return wrappedBy$ui_release.mo6707localPositionOfS_NoaFU(wrappedBy$ui_release2, m5027constructorimpl, z);
        }
        LookaheadDelegate rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        long mo6707localPositionOfS_NoaFU = mo6707localPositionOfS_NoaFU(rootLookaheadDelegate3.getLookaheadLayoutCoordinates(), j, z);
        long mo6917getPositionnOccac = rootLookaheadDelegate3.mo6917getPositionnOccac();
        long m5039minusMKHz9U = Offset.m5039minusMKHz9U(mo6707localPositionOfS_NoaFU, Offset.m5027constructorimpl((4294967295L & Float.floatToRawIntBits(IntOffset.m8124getYimpl(mo6917getPositionnOccac))) | (Float.floatToRawIntBits(IntOffset.m8123getXimpl(mo6917getPositionnOccac)) << 32)));
        LayoutCoordinates parentCoordinates = rootLookaheadDelegate3.getCoordinator().getParentCoordinates();
        if (parentCoordinates == null) {
            parentCoordinates = rootLookaheadDelegate3.getCoordinator().getCoordinates();
        }
        return Offset.m5040plusMKHz9U(m5039minusMKHz9U, parentCoordinates.mo6707localPositionOfS_NoaFU(layoutCoordinates, Offset.Companion.m5051getZeroF1C5BW0(), z));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo6712transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        getCoordinator().mo6712transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo6713transformToScreen58bKbWc(float[] fArr) {
        getCoordinator().mo6713transformToScreen58bKbWc(fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }
}
