package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/OverscrollModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "overscrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)V", "attachIfNeeded", "", "onAttach", "onDetach", "update", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class OverscrollModifierNode extends DelegatingNode {
    private DelegatableNode overscrollNode;

    public OverscrollModifierNode(DelegatableNode delegatableNode) {
        this.overscrollNode = delegatableNode;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        attachIfNeeded();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode delegatableNode = this.overscrollNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
    }

    public final void update(DelegatableNode delegatableNode) {
        DelegatableNode delegatableNode2 = this.overscrollNode;
        if (delegatableNode2 != null) {
            undelegate(delegatableNode2);
        }
        this.overscrollNode = delegatableNode;
        attachIfNeeded();
    }

    private final void attachIfNeeded() {
        DelegatableNode delegatableNode;
        Modifier.Node node;
        DelegatableNode delegatableNode2 = this.overscrollNode;
        if (delegatableNode2 == null || (node = delegatableNode2.getNode()) == null || node.isAttached()) {
            delegatableNode = null;
        } else {
            DelegatableNode delegatableNode3 = this.overscrollNode;
            Intrinsics.checkNotNull(delegatableNode3);
            delegatableNode = delegate(delegatableNode3);
        }
        this.overscrollNode = delegatableNode;
    }
}
