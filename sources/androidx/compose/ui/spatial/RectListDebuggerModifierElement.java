package androidx.compose.ui.spatial;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
/* compiled from: RectListDebugger.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/spatial/RectListDebuggerModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/spatial/RectListDebuggerModifierNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class RectListDebuggerModifierElement extends ModifierNodeElement<RectListDebuggerModifierNode> {
    public static final RectListDebuggerModifierElement INSTANCE = new RectListDebuggerModifierElement();

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return 123;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(RectListDebuggerModifierNode rectListDebuggerModifierNode) {
    }

    private RectListDebuggerModifierElement() {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public RectListDebuggerModifierNode create() {
        return new RectListDebuggerModifierNode();
    }
}
