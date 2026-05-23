package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GestureNode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/GestureNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/Modifier$Node;", "gestureConnection", "Landroidx/compose/foundation/GestureConnection;", "<init>", "(Landroidx/compose/foundation/GestureConnection;)V", "getGestureConnection", "()Landroidx/compose/foundation/GestureConnection;", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "TraverseKey", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GestureNode extends Modifier.Node implements TraversableNode, DelegatableNode {
    public static final TraverseKey TraverseKey = new TraverseKey(null);
    private final GestureConnection gestureConnection;

    public GestureNode(GestureConnection gestureConnection) {
        this.gestureConnection = gestureConnection;
    }

    public final GestureConnection getGestureConnection() {
        return this.gestureConnection;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return TraverseKey;
    }

    /* compiled from: GestureNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/GestureNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }
}
