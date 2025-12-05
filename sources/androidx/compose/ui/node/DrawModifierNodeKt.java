package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
/* compiled from: DrawModifierNode.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"invalidateDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "dispatchDraw", "Landroidx/compose/ui/node/DelegatableNode;", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m7046requireCoordinator64DMado(drawModifierNode, NodeKind.m7195constructorimpl(1)).invalidateLayer();
        }
    }

    public static final void dispatchDraw(DelegatableNode delegatableNode, ContentDrawScope contentDrawScope) {
        Modifier.Node node = delegatableNode.getNode();
        int m7195constructorimpl = NodeKind.m7195constructorimpl(4);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof DrawModifierNode) {
                ((DrawModifierNode) node).draw(contentDrawScope);
            } else if ((node.getKindSet$ui() & m7195constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                int i = 0;
                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                    if ((delegate$ui.getKindSet$ui() & m7195constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            node = delegate$ui;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui);
                            }
                        }
                    }
                }
                if (i == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }
}
