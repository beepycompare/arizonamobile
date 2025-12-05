package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
/* compiled from: FocusRequesterModifierNode.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"requestFocus", "", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "captureFocus", "freeFocus", "saveFocusedChild", "restoreFocusedChild", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusRequesterModifierNodeKt {
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00b6, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean requestFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int m7195constructorimpl = NodeKind.m7195constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                return ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled ? FocusTargetModifierNode.m5086requestFocus3ESFkO8$default(focusTargetNode, 0, 1, null) : focusTargetNode.fetchFocusProperties$ui().getCanFocus() ? FocusTargetModifierNode.m5086requestFocus3ESFkO8$default(focusTargetNode, 0, 1, null) : TwoDimensionalFocusSearchKt.m5125findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, FocusDirection.Companion.m5059getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode2) {
                        return Boolean.valueOf(FocusTargetModifierNode.m5086requestFocus3ESFkO8$default(focusTargetNode2, 0, 1, null));
                    }
                });
            }
            if ((node.getKindSet$ui() & m7195constructorimpl) != 0 && (node instanceof DelegatingNode)) {
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
        if (!focusRequesterModifierNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusRequesterModifierNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child$ui);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                return ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled ? FocusTargetModifierNode.m5086requestFocus3ESFkO8$default(focusTargetNode2, 0, 1, null) : focusTargetNode2.fetchFocusProperties$ui().getCanFocus() ? FocusTargetModifierNode.m5086requestFocus3ESFkO8$default(focusTargetNode2, 0, 1, null) : TwoDimensionalFocusSearchKt.m5125findChildCorrespondingToFocusEnterOMvw8(focusTargetNode2, FocusDirection.Companion.m5059getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(FocusTargetNode focusTargetNode22) {
                                        return Boolean.valueOf(FocusTargetModifierNode.m5086requestFocus3ESFkO8$default(focusTargetNode22, 0, 1, null));
                                    }
                                });
                            }
                            if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                    if ((delegate$ui2.getKindSet$ui() & m7195constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                        continue;
                    } else {
                        node2 = node2.getChild$ui();
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean captureFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int m7195constructorimpl = NodeKind.m7195constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                if (FocusTransactionsKt.captureFocus((FocusTargetNode) node)) {
                    return true;
                }
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
        if (!focusRequesterModifierNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusRequesterModifierNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child$ui);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                if (FocusTransactionsKt.captureFocus((FocusTargetNode) node2)) {
                                    return true;
                                }
                            } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                    if ((delegate$ui2.getKindSet$ui() & m7195constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                        continue;
                    } else {
                        node2 = node2.getChild$ui();
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean freeFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int m7195constructorimpl = NodeKind.m7195constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                if (FocusTransactionsKt.freeFocus((FocusTargetNode) node)) {
                    return true;
                }
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
        if (!focusRequesterModifierNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusRequesterModifierNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child$ui);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                if (FocusTransactionsKt.freeFocus((FocusTargetNode) node2)) {
                                    return true;
                                }
                            } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                    if ((delegate$ui2.getKindSet$ui() & m7195constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                        continue;
                    } else {
                        node2 = node2.getChild$ui();
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean saveFocusedChild(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int m7195constructorimpl = NodeKind.m7195constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                if (FocusRestorerKt.saveFocusedChild((FocusTargetNode) node)) {
                    return true;
                }
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
        if (!focusRequesterModifierNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusRequesterModifierNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child$ui);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                if (FocusRestorerKt.saveFocusedChild((FocusTargetNode) node2)) {
                                    return true;
                                }
                            } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                    if ((delegate$ui2.getKindSet$ui() & m7195constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                        continue;
                    } else {
                        node2 = node2.getChild$ui();
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean restoreFocusedChild(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int m7195constructorimpl = NodeKind.m7195constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                if (FocusRestorerKt.restoreFocusedChild((FocusTargetNode) node)) {
                    return true;
                }
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
        if (!focusRequesterModifierNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusRequesterModifierNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child$ui);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                if (FocusRestorerKt.restoreFocusedChild((FocusTargetNode) node2)) {
                                    return true;
                                }
                            } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                    if ((delegate$ui2.getKindSet$ui() & m7195constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                        continue;
                    } else {
                        node2 = node2.getChild$ui();
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PinnableContainer.PinnedHandle pinFocusedChild(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int m7195constructorimpl = NodeKind.m7195constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                PinnableContainer.PinnedHandle pinFocusedChild = FocusRestorerKt.pinFocusedChild((FocusTargetNode) node);
                if (pinFocusedChild != null) {
                    return pinFocusedChild;
                }
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
        if (!focusRequesterModifierNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui = focusRequesterModifierNode2.getNode().getChild$ui();
        if (child$ui == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child$ui);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui() & m7195constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                PinnableContainer.PinnedHandle pinFocusedChild2 = FocusRestorerKt.pinFocusedChild((FocusTargetNode) node2);
                                if (pinFocusedChild2 != null) {
                                    return pinFocusedChild2;
                                }
                            } else if ((node2.getKindSet$ui() & m7195constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                    if ((delegate$ui2.getKindSet$ui() & m7195constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                        continue;
                    } else {
                        node2 = node2.getChild$ui();
                    }
                }
            }
        }
        return null;
    }
}
