package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DelegatingNode.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\b\rJ!\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\u001eJ\u001f\u0010\u000e\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0004J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u0018\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0)H\u0080\b¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\nH\u0010¢\u0006\u0002\b,J\r\u0010-\u001a\u00020\nH\u0010¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\nH\u0010¢\u0006\u0002\b0J\r\u00101\u001a\u00020\nH\u0010¢\u0006\u0002\b2J\r\u00103\u001a\u00020\nH\u0010¢\u0006\u0002\b4R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00065"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "selfKindSet", "", "getSelfKindSet$ui$annotations", "getSelfKindSet$ui", "()I", "updateCoordinator", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui", "delegate", "getDelegate$ui", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui", "(Landroidx/compose/ui/Modifier$Node;)V", "delegateUnprotected", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "delegateUnprotected$ui", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "undelegateUnprotected", "instance", "undelegateUnprotected$ui", "setAsDelegateTo", "owner", "setAsDelegateTo$ui", "undelegate", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "forEachImmediateDelegate", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui", "markAsAttached", "markAsAttached$ui", "runAttachLifecycle", "runAttachLifecycle$ui", "runDetachLifecycle", "runDetachLifecycle$ui", "markAsDetached", "markAsDetached$ui", "reset", "reset$ui", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public static /* synthetic */ void getSelfKindSet$ui$annotations() {
    }

    public final int getSelfKindSet$ui() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui(NodeCoordinator nodeCoordinator) {
        super.updateCoordinator$ui(nodeCoordinator);
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.updateCoordinator$ui(nodeCoordinator);
        }
    }

    public final Modifier.Node getDelegate$ui() {
        return this.delegate;
    }

    public final void setDelegate$ui(Modifier.Node node) {
        this.delegate = node;
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui(T t) {
        return (T) delegate(t);
    }

    public final void undelegateUnprotected$ui(DelegatableNode delegatableNode) {
        undelegate(delegatableNode);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui(Modifier.Node node) {
        super.setAsDelegateTo$ui(node);
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.setAsDelegateTo$ui(node);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T extends DelegatableNode> T delegate(T t) {
        Modifier.Node node = t.getNode();
        if (node != t) {
            Modifier.Node node2 = t instanceof Modifier.Node ? (Modifier.Node) t : null;
            Modifier.Node parent$ui = node2 != null ? node2.getParent$ui() : null;
            if (node == getNode() && Intrinsics.areEqual(parent$ui, this)) {
                return t;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        }
        if (node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui(getNode());
        int kindSet$ui = getKindSet$ui();
        int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
        node.setKindSet$ui(calculateNodeKindSetFromIncludingDelegates);
        validateDelegateKindSet(calculateNodeKindSetFromIncludingDelegates, node);
        node.setChild$ui(this.delegate);
        this.delegate = node;
        node.setParent$ui(this);
        updateNodeKindSet(getKindSet$ui() | calculateNodeKindSetFromIncludingDelegates, false);
        if (isAttached()) {
            if ((calculateNodeKindSetFromIncludingDelegates & NodeKind.m6535constructorimpl(2)) != 0 && (kindSet$ui & NodeKind.m6535constructorimpl(2)) == 0) {
                NodeChain nodes$ui = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui();
                getNode().updateCoordinator$ui(null);
                nodes$ui.syncCoordinators();
            } else {
                updateCoordinator$ui(getCoordinator$ui());
            }
            node.markAsAttached$ui();
            node.runAttachLifecycle$ui();
            NodeKindKt.autoInvalidateInsertedNode(node);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void undelegate(DelegatableNode delegatableNode) {
        Modifier.Node node = null;
        for (Modifier.Node node2 = this.delegate; node2 != null; node2 = node2.getChild$ui()) {
            if (node2 == delegatableNode) {
                if (node2.isAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(node2);
                    node2.runDetachLifecycle$ui();
                    node2.markAsDetached$ui();
                }
                node2.setAsDelegateTo$ui(node2);
                node2.setAggregateChildKindSet$ui(0);
                if (node == null) {
                    this.delegate = node2.getChild$ui();
                } else {
                    node.setChild$ui(node2.getChild$ui());
                }
                node2.setChild$ui(null);
                node2.setParent$ui(null);
                int kindSet$ui = getKindSet$ui();
                int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                updateNodeKindSet(calculateNodeKindSetFromIncludingDelegates, true);
                if (isAttached() && (kindSet$ui & NodeKind.m6535constructorimpl(2)) != 0 && (NodeKind.m6535constructorimpl(2) & calculateNodeKindSetFromIncludingDelegates) == 0) {
                    NodeChain nodes$ui = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui();
                    getNode().updateCoordinator$ui(null);
                    nodes$ui.syncCoordinators();
                    return;
                }
                return;
            }
            node = node2;
        }
        throw new IllegalStateException(("Could not find delegate: " + delegatableNode).toString());
    }

    private final void validateDelegateKindSet(int i, Modifier.Node node) {
        int kindSet$ui = getKindSet$ui();
        if ((i & NodeKind.m6535constructorimpl(2)) == 0 || (NodeKind.m6535constructorimpl(2) & kindSet$ui) == 0 || (this instanceof LayoutModifierNode)) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node);
    }

    private final void updateNodeKindSet(int i, boolean z) {
        Modifier.Node child$ui;
        int kindSet$ui = getKindSet$ui();
        setKindSet$ui(i);
        if (kindSet$ui != i) {
            if (DelegatableNodeKt.isDelegationRoot(this)) {
                setAggregateChildKindSet$ui(i);
            }
            if (isAttached()) {
                Modifier.Node node = getNode();
                DelegatingNode delegatingNode = this;
                while (delegatingNode != null) {
                    i |= delegatingNode.getKindSet$ui();
                    delegatingNode.setKindSet$ui(i);
                    if (delegatingNode == node) {
                        break;
                    }
                    delegatingNode = delegatingNode.getParent$ui();
                }
                if (z && delegatingNode == node) {
                    i = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
                    node.setKindSet$ui(i);
                }
                int aggregateChildKindSet$ui = i | ((delegatingNode == null || (child$ui = delegatingNode.getChild$ui()) == null) ? 0 : child$ui.getAggregateChildKindSet$ui());
                while (delegatingNode != null) {
                    aggregateChildKindSet$ui |= delegatingNode.getKindSet$ui();
                    delegatingNode.setAggregateChildKindSet$ui(aggregateChildKindSet$ui);
                    delegatingNode = delegatingNode.getParent$ui();
                }
            }
        }
    }

    public final void forEachImmediateDelegate$ui(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            function1.invoke(delegate$ui);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui() {
        super.markAsAttached$ui();
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.updateCoordinator$ui(getCoordinator$ui());
            if (!delegate$ui.isAttached()) {
                delegate$ui.markAsAttached$ui();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui() {
        super.runDetachLifecycle$ui();
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.runDetachLifecycle$ui();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui() {
        super.reset$ui();
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.reset$ui();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui() {
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.runAttachLifecycle$ui();
        }
        super.runAttachLifecycle$ui();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui() {
        for (Modifier.Node delegate$ui = getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
            delegate$ui.markAsDetached$ui();
        }
        super.markAsDetached$ui();
    }
}
