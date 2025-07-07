package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusTransactions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001e\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u001e\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0002*\u00020\u0002H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "performRequestFocusLegacy", "performRequestFocusOptimized", "requestFocusForChild", "childNode", "requestFocusForOwner", "requireActiveChild", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            return performRequestFocusOptimized(focusTargetNode);
        }
        return performRequestFocusLegacy(focusTargetNode);
    }

    /* JADX WARN: Type inference failed for: r13v7 */
    private static final boolean performRequestFocusOptimized(FocusTargetNode focusTargetNode) {
        MutableVector mutableVector;
        int i;
        NodeChain nodes$ui_release;
        Modifier.Node node;
        NodeChain nodes$ui_release2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        MutableVector mutableVector2;
        FocusTargetNode focusTargetNode4 = focusTargetNode;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode4).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int i2 = 1;
        if (activeFocusTargetNode == focusTargetNode) {
            FocusStateImpl focusStateImpl = focusState;
            focusTargetNode.dispatchFocusCallbacks$ui_release(focusStateImpl, focusStateImpl);
            return true;
        }
        int i3 = 0;
        if (activeFocusTargetNode != null || requestFocusForOwner(focusTargetNode)) {
            int i4 = 1024;
            int i5 = 16;
            if (activeFocusTargetNode != null) {
                mutableVector = new MutableVector(new FocusTargetNode[16], 0);
                FocusTargetNode focusTargetNode5 = activeFocusTargetNode;
                int m5700constructorimpl = NodeKind.m5700constructorimpl(1024);
                if (!focusTargetNode5.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui_release = focusTargetNode5.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                Modifier.Node node2 = parent$ui_release;
                                MutableVector mutableVector3 = null;
                                while (node2 != null) {
                                    int i6 = i4;
                                    if (node2 instanceof FocusTargetNode) {
                                        mutableVector.add((FocusTargetNode) node2);
                                    } else if ((node2.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                        Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release();
                                        int i7 = 0;
                                        while (delegate$ui_release != null) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                                i7++;
                                                if (i7 == i2) {
                                                    focusTargetNode3 = focusTargetNode4;
                                                    node2 = delegate$ui_release;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        focusTargetNode3 = focusTargetNode4;
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        focusTargetNode3 = focusTargetNode4;
                                                        mutableVector2 = mutableVector3;
                                                    }
                                                    if (node2 != null) {
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(node2);
                                                        }
                                                        node2 = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(delegate$ui_release);
                                                    }
                                                    mutableVector3 = mutableVector2;
                                                }
                                            } else {
                                                focusTargetNode3 = focusTargetNode4;
                                            }
                                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                            focusTargetNode4 = focusTargetNode3;
                                            i2 = 1;
                                        }
                                        focusTargetNode2 = focusTargetNode4;
                                        int i8 = i2;
                                        if (i7 == i8) {
                                            i2 = i8;
                                            i4 = i6;
                                            focusTargetNode4 = focusTargetNode2;
                                        } else {
                                            node2 = DelegatableNodeKt.pop(mutableVector3);
                                            i4 = i6;
                                            focusTargetNode4 = focusTargetNode2;
                                            i2 = 1;
                                        }
                                    }
                                    focusTargetNode2 = focusTargetNode4;
                                    node2 = DelegatableNodeKt.pop(mutableVector3);
                                    i4 = i6;
                                    focusTargetNode4 = focusTargetNode2;
                                    i2 = 1;
                                }
                            }
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                            i4 = i4;
                            focusTargetNode4 = focusTargetNode4;
                            i2 = 1;
                        }
                    }
                    FocusTargetNode focusTargetNode6 = focusTargetNode4;
                    int i9 = i4;
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    parent$ui_release = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                    i4 = i9;
                    focusTargetNode4 = focusTargetNode6;
                    i2 = 1;
                }
            } else {
                mutableVector = null;
            }
            FocusTargetNode focusTargetNode7 = focusTargetNode4;
            MutableVector mutableVector4 = new MutableVector(new FocusTargetNode[16], 0);
            int m5700constructorimpl2 = NodeKind.m5700constructorimpl(i4);
            if (!focusTargetNode7.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release2 = focusTargetNode7.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode7);
            int i10 = 1;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl2) != 0) {
                    while (parent$ui_release2 != null) {
                        if ((parent$ui_release2.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                            FocusTargetNode focusTargetNode8 = parent$ui_release2;
                            MutableVector mutableVector5 = null;
                            while (focusTargetNode8 != null) {
                                if (focusTargetNode8 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode9 = focusTargetNode8;
                                    Boolean valueOf = mutableVector != null ? Boolean.valueOf(mutableVector.remove(focusTargetNode9)) : null;
                                    if (valueOf == null || !valueOf.booleanValue()) {
                                        mutableVector4.add(focusTargetNode9);
                                    }
                                    if (focusTargetNode9 == activeFocusTargetNode) {
                                        i10 = i3;
                                    }
                                } else if ((focusTargetNode8.getKindSet$ui_release() & m5700constructorimpl2) != 0 && (focusTargetNode8 instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release2 = ((DelegatingNode) focusTargetNode8).getDelegate$ui_release();
                                    int i11 = i3;
                                    node = focusTargetNode8;
                                    while (delegate$ui_release2 != null) {
                                        if ((delegate$ui_release2.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                            i11++;
                                            if (i11 == 1) {
                                                node = delegate$ui_release2;
                                            } else {
                                                if (mutableVector5 == null) {
                                                    mutableVector5 = new MutableVector(new Modifier.Node[i5], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector5 != null) {
                                                        mutableVector5.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector5 != null) {
                                                    mutableVector5.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                        delegate$ui_release2 = delegate$ui_release2.getChild$ui_release();
                                        i5 = 16;
                                        node = node;
                                    }
                                    if (i11 == 1) {
                                        i3 = 0;
                                        i5 = 16;
                                        focusTargetNode8 = node;
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector5);
                                i3 = 0;
                                i5 = 16;
                                focusTargetNode8 = node;
                            }
                        }
                        parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                        i3 = 0;
                        i5 = 16;
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent$ui_release2 = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                i3 = 0;
                i5 = 16;
            }
            if (i10 == 0 || activeFocusTargetNode == null) {
                i = 1;
            } else {
                i = 1;
                if (!clearFocus$default(activeFocusTargetNode, false, true, 1, null)) {
                    return false;
                }
            }
            grantFocus(focusTargetNode);
            if (mutableVector != null) {
                int size = mutableVector.getSize() - i;
                Object[] objArr = mutableVector.content;
                if (size < objArr.length) {
                    while (size >= 0) {
                        FocusTargetNode focusTargetNode10 = (FocusTargetNode) objArr[size];
                        if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                            return false;
                        }
                        focusTargetNode10.dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                        size--;
                    }
                }
            }
            int size2 = mutableVector4.getSize() - 1;
            Object[] objArr2 = mutableVector4.content;
            if (size2 < objArr2.length) {
                while (size2 >= 0) {
                    FocusTargetNode focusTargetNode11 = (FocusTargetNode) objArr2[size2];
                    if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode11.dispatchFocusCallbacks$ui_release(focusTargetNode11 == activeFocusTargetNode ? FocusStateImpl.Active : FocusStateImpl.Inactive, FocusStateImpl.ActiveParent);
                    size2--;
                }
            }
            if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                return false;
            }
            focusTargetNode.dispatchFocusCallbacks$ui_release(focusState, FocusStateImpl.Active);
            if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                return false;
            }
            if (ComposeUiFlags.isViewFocusFixEnabled && DelegatableNodeKt.requireLayoutNode(focusTargetNode7).getInteropView() == null) {
                DelegatableNodeKt.requireOwner(focusTargetNode7).getFocusOwner().mo3740requestFocusForOwner7o62pno(FocusDirection.m3718boximpl(FocusDirection.Companion.m3729getNextdhqQ8s()), null);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e7, code lost:
        if (grantFocus(r11) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fa, code lost:
        if (grantFocus(r11) != false) goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean performRequestFocusLegacy(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2;
        NodeChain nodes$ui_release;
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        boolean z = true;
        if (i != 1 && i != 2) {
            if (i == 3) {
                if (clearChildFocus$default(focusTargetNode, false, false, 3, null)) {
                }
                z = false;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                FocusTargetNode focusTargetNode3 = focusTargetNode;
                int m5700constructorimpl = NodeKind.m5700constructorimpl(1024);
                if (!focusTargetNode3.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui_release = focusTargetNode3.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode3);
                loop0: while (true) {
                    if (requireLayoutNode == null) {
                        focusTargetNode2 = null;
                        break;
                    }
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                MutableVector mutableVector = null;
                                focusTargetNode2 = parent$ui_release;
                                while (focusTargetNode2 != null) {
                                    if (focusTargetNode2 instanceof FocusTargetNode) {
                                        break loop0;
                                    }
                                    if ((focusTargetNode2.getKindSet$ui_release() & m5700constructorimpl) != 0 && (focusTargetNode2 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) focusTargetNode2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    focusTargetNode2 = delegate$ui_release;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (focusTargetNode2 != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(focusTargetNode2);
                                                        }
                                                        focusTargetNode2 = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    focusTargetNode2 = DelegatableNodeKt.pop(mutableVector);
                                }
                                continue;
                            }
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                }
                FocusTargetNode focusTargetNode4 = focusTargetNode2;
                if (focusTargetNode4 != null) {
                    FocusStateImpl focusState = focusTargetNode4.getFocusState();
                    z = requestFocusForChild(focusTargetNode4, focusTargetNode);
                    if (z && focusState != focusTargetNode4.getFocusState()) {
                        focusTargetNode4.dispatchFocusCallbacks$ui_release();
                    }
                } else {
                    if (requestFocusForOwner(focusTargetNode)) {
                    }
                    z = false;
                }
            }
        }
        if (z) {
            if (ComposeUiFlags.isViewFocusFixEnabled) {
                FocusTargetNode focusTargetNode5 = focusTargetNode;
                if (DelegatableNodeKt.requireLayoutNode(focusTargetNode5).getInteropView() == null) {
                    DelegatableNodeKt.requireOwner(focusTargetNode5).getFocusOwner().mo3740requestFocusForOwner7o62pno(FocusDirection.m3718boximpl(FocusDirection.Companion.m3729getNextdhqQ8s()), null);
                }
            }
            focusTargetNode.dispatchFocusCallbacks$ui_release();
        }
        return z;
    }

    public static final boolean captureFocus(FocusTargetNode focusTargetNode) {
        boolean z = false;
        if (ComposeUiFlags.isTrackFocusEnabled) {
            int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i == 1) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(true);
                focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Active, FocusStateImpl.Captured);
                return true;
            } else if (i != 2) {
                if (i == 3 || i == 4) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else {
                return true;
            }
        }
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.getOngoingTransaction()) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i2 == 1) {
                focusTargetNode.setFocusState(FocusStateImpl.Captured);
                focusTargetNode.dispatchFocusCallbacks$ui_release();
            } else if (i2 != 2) {
                if (i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                return z;
            }
            z = true;
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    public static final boolean freeFocus(FocusTargetNode focusTargetNode) {
        boolean z = false;
        if (ComposeUiFlags.isTrackFocusEnabled) {
            int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 || i == 4) {
                        return false;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(false);
                focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Captured, FocusStateImpl.Active);
            }
            return true;
        }
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.getOngoingTransaction()) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3 && i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return z;
                }
                focusTargetNode.setFocusState(FocusStateImpl.Active);
                focusTargetNode.dispatchFocusCallbacks$ui_release();
            }
            z = true;
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            if (ComposeUiFlags.isTrackFocusEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Active, FocusStateImpl.Inactive);
                }
            } else {
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui_release();
                }
            }
            return true;
        } else if (i == 2) {
            if (z) {
                if (ComposeUiFlags.isTrackFocusEnabled) {
                    DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                    if (z2) {
                        focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Captured, FocusStateImpl.Inactive);
                        return z;
                    }
                } else {
                    focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                    if (z2) {
                        focusTargetNode.dispatchFocusCallbacks$ui_release();
                    }
                }
            }
            return z;
        } else if (i != 3) {
            if (i == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        } else if (clearChildFocus(focusTargetNode, z, z2)) {
            if (!ComposeUiFlags.isTrackFocusEnabled) {
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui_release();
                }
            } else if (z2) {
                focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
            }
            return true;
        } else {
            return false;
        }
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTargetNode.this.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 3 || i == 4) {
            if (ComposeUiFlags.isTrackFocusEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(focusTargetNode);
                return true;
            }
            focusTargetNode.setFocusState(FocusStateImpl.Active);
            return true;
        }
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        FocusTargetNode focusTargetNode3;
        Modifier.Node node;
        NodeChain nodes$ui_release;
        NodeChain nodes$ui_release2;
        FocusTargetNode focusTargetNode4 = focusTargetNode2;
        int m5700constructorimpl = NodeKind.m5700constructorimpl(1024);
        if (!focusTargetNode4.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode4.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode4);
        loop0: while (true) {
            focusTargetNode3 = null;
            if (requireLayoutNode == null) {
                node = null;
                break;
            }
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                        node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((node.getKindSet$ui_release() & m5700constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
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
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
        }
        if (Intrinsics.areEqual(node, focusTargetNode)) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i2 == 1) {
                boolean grantFocus = grantFocus(focusTargetNode2);
                if (grantFocus) {
                    focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                }
                return grantFocus;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        FocusTargetNode focusTargetNode5 = focusTargetNode;
                        int m5700constructorimpl2 = NodeKind.m5700constructorimpl(1024);
                        if (!focusTargetNode5.getNode().isAttached()) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        Modifier.Node parent$ui_release2 = focusTargetNode5.getNode().getParent$ui_release();
                        LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
                        loop4: while (true) {
                            if (requireLayoutNode2 == null) {
                                break;
                            }
                            if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                while (parent$ui_release2 != null) {
                                    if ((parent$ui_release2.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                        Modifier.Node node2 = parent$ui_release2;
                                        MutableVector mutableVector2 = null;
                                        while (node2 != null) {
                                            if (node2 instanceof FocusTargetNode) {
                                                focusTargetNode3 = node2;
                                                break loop4;
                                            }
                                            if ((node2.getKindSet$ui_release() & m5700constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                                                int i3 = 0;
                                                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                                    if ((delegate$ui_release2.getKindSet$ui_release() & m5700constructorimpl2) != 0) {
                                                        i3++;
                                                        if (i3 == 1) {
                                                            node2 = delegate$ui_release2;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            if (node2 != null) {
                                                                if (mutableVector2 != null) {
                                                                    mutableVector2.add(node2);
                                                                }
                                                                node2 = null;
                                                            }
                                                            if (mutableVector2 != null) {
                                                                mutableVector2.add(delegate$ui_release2);
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i3 == 1) {
                                                }
                                            }
                                            node2 = DelegatableNodeKt.pop(mutableVector2);
                                        }
                                        continue;
                                    }
                                    parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                                }
                            }
                            requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                            parent$ui_release2 = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                        }
                        FocusTargetNode focusTargetNode6 = focusTargetNode3;
                        if (focusTargetNode6 == null && requestFocusForOwner(focusTargetNode)) {
                            boolean grantFocus2 = grantFocus(focusTargetNode2);
                            if (grantFocus2) {
                                focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                            }
                            return grantFocus2;
                        } else if (focusTargetNode6 == null || !requestFocusForChild(focusTargetNode6, focusTargetNode)) {
                            return false;
                        } else {
                            boolean requestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
                            if (focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent) {
                                if (requestFocusForChild) {
                                    focusTargetNode6.dispatchFocusCallbacks$ui_release();
                                }
                                return requestFocusForChild;
                            }
                            throw new IllegalStateException("Deactivated node is focused".toString());
                        }
                    }
                    throw new NoWhenBranchMatchedException();
                }
                requireActiveChild(focusTargetNode);
                if (clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode2)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException("Non child node cannot request focus.".toString());
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        return DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().mo3740requestFocusForOwner7o62pno(null, null);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m3762performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        FocusTargetNode focusTargetNode2;
        NodeChain nodes$ui_release;
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                FocusTargetNode focusTargetNode3 = focusTargetNode;
                int m5700constructorimpl = NodeKind.m5700constructorimpl(1024);
                if (!focusTargetNode3.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui_release = focusTargetNode3.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode3);
                loop0: while (true) {
                    if (requireLayoutNode == null) {
                        focusTargetNode2 = null;
                        break;
                    }
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m5700constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                focusTargetNode2 = parent$ui_release;
                                MutableVector mutableVector = null;
                                while (focusTargetNode2 != null) {
                                    if (focusTargetNode2 instanceof FocusTargetNode) {
                                        break loop0;
                                    }
                                    if ((focusTargetNode2.getKindSet$ui_release() & m5700constructorimpl) != 0 && (focusTargetNode2 instanceof DelegatingNode)) {
                                        int i3 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) focusTargetNode2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m5700constructorimpl) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    focusTargetNode2 = delegate$ui_release;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (focusTargetNode2 != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(focusTargetNode2);
                                                        }
                                                        focusTargetNode2 = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                    focusTargetNode2 = DelegatableNodeKt.pop(mutableVector);
                                }
                                continue;
                            }
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                }
                FocusTargetNode focusTargetNode4 = focusTargetNode2;
                if (focusTargetNode4 == null) {
                    return CustomDestinationResult.None;
                }
                int i4 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode4.getFocusState().ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 4) {
                                CustomDestinationResult m3762performCustomRequestFocusMxy_nc0 = m3762performCustomRequestFocusMxy_nc0(focusTargetNode4, i);
                                CustomDestinationResult customDestinationResult = m3762performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? m3762performCustomRequestFocusMxy_nc0 : null;
                                return customDestinationResult == null ? m3760performCustomEnterMxy_nc0(focusTargetNode4, i) : customDestinationResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        return m3762performCustomRequestFocusMxy_nc0(focusTargetNode4, i);
                    }
                    return CustomDestinationResult.Cancelled;
                }
                return m3760performCustomEnterMxy_nc0(focusTargetNode4, i);
            }
            throw new NoWhenBranchMatchedException();
        }
        return m3759performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m3759performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                CustomDestinationResult m3759performCustomClearFocusMxy_nc0 = m3759performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
                if (m3759performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    m3759performCustomClearFocusMxy_nc0 = null;
                }
                return m3759performCustomClearFocusMxy_nc0 == null ? m3761performCustomExitMxy_nc0(focusTargetNode, i) : m3759performCustomClearFocusMxy_nc0;
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomEnter-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m3760performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(focusTargetNode);
                int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                fetchFocusProperties$ui_release.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
                int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                    FocusRequester cancel = FocusRequester.Companion.getCancel();
                    if (cancel == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.Companion.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m3748requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                } else if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null)) {
                    FocusRequester redirect$ui_release = FocusRequester.Companion.getRedirect$ui_release();
                    if (redirect$ui_release == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui_release == FocusRequester.Companion.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m3748requestFocus3ESFkO8$default(redirect$ui_release, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m3761performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(focusTargetNode);
                int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                fetchFocusProperties$ui_release.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
                int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                    FocusRequester cancel = FocusRequester.Companion.getCancel();
                    if (cancel == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.Companion.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m3748requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                } else if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null)) {
                    FocusRequester redirect$ui_release = FocusRequester.Companion.getRedirect$ui_release();
                    if (redirect$ui_release == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui_release == FocusRequester.Companion.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m3748requestFocus3ESFkO8$default(redirect$ui_release, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
