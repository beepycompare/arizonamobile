package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
/* compiled from: ThrottledCallbacks.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThrottledCallbacksKt {
    /* renamed from: rectInfoFor-Dg36KO4  reason: not valid java name */
    public static final RelativeLayoutBounds m7247rectInfoForDg36KO4(DelegatableNode delegatableNode, long j, long j2, long j3, long j4, long j5, float[] fArr) {
        NodeCoordinator m6843requireCoordinator64DMado = DelegatableNodeKt.m6843requireCoordinator64DMado(delegatableNode, NodeKind.m6989constructorimpl(2));
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (requireLayoutNode.isPlaced()) {
            if (requireLayoutNode.getOuterCoordinator$ui_release() != m6843requireCoordinator64DMado) {
                long m8118constructorimpl = IntOffset.m8118constructorimpl(j);
                long m5028constructorimpl = Offset.m5028constructorimpl((Float.floatToRawIntBits(IntOffset.m8124getXimpl(m8118constructorimpl)) << 32) | (Float.floatToRawIntBits(IntOffset.m8125getYimpl(m8118constructorimpl)) & 4294967295L));
                long mo6706getSizeYbymL2g = m6843requireCoordinator64DMado.getCoordinates().mo6706getSizeYbymL2g();
                long m8141roundk4lQ0M = IntOffsetKt.m8141roundk4lQ0M(requireLayoutNode.getOuterCoordinator$ui_release().getCoordinates().mo6707localPositionOfR5De75A(m6843requireCoordinator64DMado, m5028constructorimpl));
                return new RelativeLayoutBounds(m8141roundk4lQ0M, IntOffset.m8118constructorimpl(((IntOffset.m8124getXimpl(m8141roundk4lQ0M) + ((int) (mo6706getSizeYbymL2g >> 32))) << 32) | ((IntOffset.m8125getYimpl(m8141roundk4lQ0M) + ((int) (mo6706getSizeYbymL2g & 4294967295L))) & 4294967295L)), j3, j4, j5, fArr, delegatableNode, null);
            }
            return new RelativeLayoutBounds(j, j2, j3, j4, j5, fArr, delegatableNode, null);
        }
        return null;
    }
}
