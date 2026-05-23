package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import kotlin.Metadata;
/* compiled from: SemanticsModifierNode.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"invalidateSemantics", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "useMinimumTouchTarget", "", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Z", "effectiveBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/Modifier$Node;", "clipBounds", "boundsInRoot", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SemanticsModifierNodeKt {
    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        DelegatableNodeKt.requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui();
    }

    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration semanticsConfiguration) {
        return SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect effectiveBoundsInRoot(Modifier.Node node, boolean z, boolean z2) {
        if (node.getNode().isAttached()) {
            if (!z) {
                return boundsInRoot(DelegatableNodeKt.m6990requireCoordinator64DMado(node, NodeKind.m7135constructorimpl(8)), z2);
            }
            return DelegatableNodeKt.m6990requireCoordinator64DMado(node, NodeKind.m7135constructorimpl(8)).touchBoundsInRoot();
        }
        return Rect.Companion.getZero();
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates, boolean z) {
        return LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates).localBoundingBoxOf(layoutCoordinates, z);
    }
}
