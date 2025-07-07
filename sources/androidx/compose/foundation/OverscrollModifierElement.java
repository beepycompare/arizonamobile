package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/OverscrollModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/OverscrollModifierNode;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/OverscrollEffect;)V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class OverscrollModifierElement extends ModifierNodeElement<OverscrollModifierNode> {
    private final OverscrollEffect overscrollEffect;

    public OverscrollModifierElement(OverscrollEffect overscrollEffect) {
        this.overscrollEffect = overscrollEffect;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OverscrollModifierNode create() {
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return new OverscrollModifierNode(overscrollEffect != null ? overscrollEffect.getNode() : null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(OverscrollModifierNode overscrollModifierNode) {
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        overscrollModifierNode.update(overscrollEffect != null ? overscrollEffect.getNode() : null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OverscrollModifierElement) && Intrinsics.areEqual(this.overscrollEffect, ((OverscrollModifierElement) obj).overscrollEffect);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null) {
            return overscrollEffect.hashCode();
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("overscroll");
        inspectorInfo.getProperties().set("overscrollEffect", this.overscrollEffect);
    }
}
