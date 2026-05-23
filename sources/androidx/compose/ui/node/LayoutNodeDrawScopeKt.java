package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node nextDrawNode(DelegatableNode delegatableNode) {
        int m7135constructorimpl = NodeKind.m7135constructorimpl(4);
        int m7135constructorimpl2 = NodeKind.m7135constructorimpl(2);
        Modifier.Node child$ui = delegatableNode.getNode().getChild$ui();
        if (child$ui == null || (child$ui.getAggregateChildKindSet$ui() & m7135constructorimpl) == 0) {
            return null;
        }
        while (child$ui != null && (child$ui.getKindSet$ui() & m7135constructorimpl2) == 0) {
            if ((child$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                return child$ui;
            }
            child$ui = child$ui.getChild$ui();
        }
        return null;
    }
}
