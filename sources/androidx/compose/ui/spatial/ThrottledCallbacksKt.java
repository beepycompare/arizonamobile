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
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Q-MZNJw", "(Landroidx/compose/ui/node/DelegatableNode;JJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThrottledCallbacksKt {
    /* renamed from: rectInfoFor-Q-MZNJw  reason: not valid java name */
    public static final RelativeLayoutBounds m5954rectInfoForQMZNJw(DelegatableNode delegatableNode, long j, long j2, long j3, long j4, float[] fArr) {
        NodeCoordinator m5560requireCoordinator64DMado = DelegatableNodeKt.m5560requireCoordinator64DMado(delegatableNode, NodeKind.m5700constructorimpl(2));
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (requireLayoutNode.isPlaced()) {
            if (requireLayoutNode.getOuterCoordinator$ui_release() != m5560requireCoordinator64DMado) {
                long m6806constructorimpl = IntOffset.m6806constructorimpl(j);
                long m3829constructorimpl = Offset.m3829constructorimpl((Float.floatToRawIntBits(IntOffset.m6812getXimpl(m6806constructorimpl)) << 32) | (Float.floatToRawIntBits(IntOffset.m6813getYimpl(m6806constructorimpl)) & 4294967295L));
                long mo5446getSizeYbymL2g = m5560requireCoordinator64DMado.getCoordinates().mo5446getSizeYbymL2g();
                long m6829roundk4lQ0M = IntOffsetKt.m6829roundk4lQ0M(requireLayoutNode.getOuterCoordinator$ui_release().getCoordinates().mo5447localPositionOfR5De75A(m5560requireCoordinator64DMado, m3829constructorimpl));
                return new RelativeLayoutBounds(m6829roundk4lQ0M, IntOffset.m6806constructorimpl(((IntOffset.m6812getXimpl(m6829roundk4lQ0M) + ((int) (mo5446getSizeYbymL2g >> 32))) << 32) | ((IntOffset.m6813getYimpl(m6829roundk4lQ0M) + ((int) (mo5446getSizeYbymL2g & 4294967295L))) & 4294967295L)), j3, j4, fArr, delegatableNode, null);
            }
            return new RelativeLayoutBounds(j, j2, j3, j4, fArr, delegatableNode, null);
        }
        return null;
    }
}
