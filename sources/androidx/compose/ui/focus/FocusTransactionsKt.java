package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
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
/* compiled from: FocusTransactions.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a \u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0002\u001a)\u0010\n\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\b\u000f\u001a\f\u0010\u0010\u001a\u00020\u0002*\u00020\u0002H\u0002\u001a\u001b\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001b\u0010\u0017\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001a\u001b\u0010\u0019\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"performRequestFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "captureFocus", "freeFocus", "clearFocus", "forced", "refreshFocusEvents", "grantFocus", "clearChildFocus", "requestOwnerFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-Etdf9zw", "requireActiveChild", "performCustomRequestFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomRequestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomClearFocus", "performCustomClearFocus-Mxy_nc0", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
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

    /* JADX WARN: Type inference failed for: r13v7 */
    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        MutableVector mutableVector;
        NodeChain nodes$ui;
        Modifier.Node node;
        NodeChain nodes$ui2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        MutableVector mutableVector2;
        FocusTargetNode focusTargetNode4 = focusTargetNode;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode4).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int i = 1;
        if (activeFocusTargetNode == focusTargetNode) {
            FocusStateImpl focusStateImpl = focusState;
            focusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl, focusStateImpl);
            return true;
        }
        int i2 = 0;
        MutableVector mutableVector3 = null;
        if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if ((activeFocusTargetNode == null || activeFocusTargetNode.isInteropViewHost()) && !focusTargetNode.isInteropViewHost() && !m4450requestOwnerFocusEtdf9zw$default(focusTargetNode, null, null, 3, null)) {
                return false;
            }
        } else if (activeFocusTargetNode == null && !m4450requestOwnerFocusEtdf9zw$default(focusTargetNode, null, null, 3, null)) {
            return false;
        }
        int i3 = 1024;
        int i4 = 16;
        if (activeFocusTargetNode != null) {
            mutableVector = new MutableVector(new FocusTargetNode[16], 0);
            FocusTargetNode focusTargetNode5 = activeFocusTargetNode;
            int m6535constructorimpl = NodeKind.m6535constructorimpl(1024);
            if (!focusTargetNode5.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = focusTargetNode5.getNode().getParent$ui();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m6535constructorimpl) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                            MutableVector mutableVector4 = mutableVector3;
                            Modifier.Node node2 = parent$ui;
                            while (node2 != null) {
                                int i5 = i3;
                                if (node2 instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) node2);
                                } else if ((node2.getKindSet$ui() & m6535constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui = ((DelegatingNode) node2).getDelegate$ui();
                                    int i6 = 0;
                                    while (delegate$ui != null) {
                                        if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                            i6++;
                                            if (i6 == i) {
                                                focusTargetNode3 = focusTargetNode4;
                                                node2 = delegate$ui;
                                            } else {
                                                if (mutableVector4 == null) {
                                                    focusTargetNode3 = focusTargetNode4;
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    focusTargetNode3 = focusTargetNode4;
                                                    mutableVector2 = mutableVector4;
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                                mutableVector4 = mutableVector2;
                                            }
                                        } else {
                                            focusTargetNode3 = focusTargetNode4;
                                        }
                                        delegate$ui = delegate$ui.getChild$ui();
                                        focusTargetNode4 = focusTargetNode3;
                                        i = 1;
                                    }
                                    focusTargetNode2 = focusTargetNode4;
                                    int i7 = i;
                                    if (i6 == i7) {
                                        i = i7;
                                        i3 = i5;
                                        focusTargetNode4 = focusTargetNode2;
                                    }
                                    node2 = DelegatableNodeKt.pop(mutableVector4);
                                    i3 = i5;
                                    focusTargetNode4 = focusTargetNode2;
                                    i = 1;
                                }
                                focusTargetNode2 = focusTargetNode4;
                                node2 = DelegatableNodeKt.pop(mutableVector4);
                                i3 = i5;
                                focusTargetNode4 = focusTargetNode2;
                                i = 1;
                            }
                        }
                        parent$ui = parent$ui.getParent$ui();
                        i3 = i3;
                        focusTargetNode4 = focusTargetNode4;
                        i = 1;
                        mutableVector3 = null;
                    }
                }
                FocusTargetNode focusTargetNode6 = focusTargetNode4;
                int i8 = i3;
                requireLayoutNode = requireLayoutNode.getParent$ui();
                parent$ui = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
                i3 = i8;
                focusTargetNode4 = focusTargetNode6;
                i = 1;
                mutableVector3 = null;
            }
        } else {
            mutableVector = null;
        }
        FocusTargetNode focusTargetNode7 = focusTargetNode4;
        MutableVector mutableVector5 = new MutableVector(new FocusTargetNode[16], 0);
        int m6535constructorimpl2 = NodeKind.m6535constructorimpl(i3);
        if (!focusTargetNode7.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui2 = focusTargetNode7.getNode().getParent$ui();
        LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode7);
        int i9 = 1;
        while (requireLayoutNode2 != null) {
            if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m6535constructorimpl2) != 0) {
                while (parent$ui2 != null) {
                    if ((parent$ui2.getKindSet$ui() & m6535constructorimpl2) != 0) {
                        FocusTargetNode focusTargetNode8 = parent$ui2;
                        MutableVector mutableVector6 = null;
                        while (focusTargetNode8 != null) {
                            if (focusTargetNode8 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode9 = focusTargetNode8;
                                Boolean valueOf = mutableVector != null ? Boolean.valueOf(mutableVector.remove(focusTargetNode9)) : null;
                                if (valueOf == null || !valueOf.booleanValue()) {
                                    mutableVector5.add(focusTargetNode9);
                                }
                                if (focusTargetNode9 == activeFocusTargetNode) {
                                    i9 = i2;
                                }
                            } else if ((focusTargetNode8.getKindSet$ui() & m6535constructorimpl2) != 0 && (focusTargetNode8 instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui2 = ((DelegatingNode) focusTargetNode8).getDelegate$ui();
                                int i10 = i2;
                                node = focusTargetNode8;
                                while (delegate$ui2 != null) {
                                    if ((delegate$ui2.getKindSet$ui() & m6535constructorimpl2) != 0) {
                                        i10++;
                                        if (i10 == 1) {
                                            node = delegate$ui2;
                                        } else {
                                            if (mutableVector6 == null) {
                                                mutableVector6 = new MutableVector(new Modifier.Node[i4], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector6 != null) {
                                                    mutableVector6.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector6 != null) {
                                                mutableVector6.add(delegate$ui2);
                                            }
                                        }
                                    }
                                    delegate$ui2 = delegate$ui2.getChild$ui();
                                    i4 = 16;
                                    node = node;
                                }
                                if (i10 == 1) {
                                    i2 = 0;
                                    i4 = 16;
                                    focusTargetNode8 = node;
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector6);
                            i2 = 0;
                            i4 = 16;
                            focusTargetNode8 = node;
                        }
                    }
                    parent$ui2 = parent$ui2.getParent$ui();
                    i2 = 0;
                    i4 = 16;
                }
            }
            requireLayoutNode2 = requireLayoutNode2.getParent$ui();
            parent$ui2 = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            i2 = 0;
            i4 = 16;
        }
        if (i9 == 0 || activeFocusTargetNode == null || clearFocus$default(activeFocusTargetNode, false, true, 1, null)) {
            grantFocus(focusTargetNode);
            if (ComposeUiFlags.isOptimizedFocusEventDispatchEnabled && i9 != 0 && activeFocusTargetNode != null) {
                activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
            }
            if (mutableVector != null) {
                int size = mutableVector.getSize() - 1;
                Object[] objArr = mutableVector.content;
                if (size < objArr.length) {
                    while (size >= 0) {
                        FocusTargetNode focusTargetNode10 = (FocusTargetNode) objArr[size];
                        if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                            return false;
                        }
                        focusTargetNode10.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                        size--;
                    }
                }
            }
            int size2 = mutableVector5.getSize() - 1;
            Object[] objArr2 = mutableVector5.content;
            if (size2 < objArr2.length) {
                while (size2 >= 0) {
                    FocusTargetNode focusTargetNode11 = (FocusTargetNode) objArr2[size2];
                    if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode11.dispatchFocusCallbacks$ui(focusTargetNode11 == activeFocusTargetNode ? FocusStateImpl.Active : FocusStateImpl.Inactive, FocusStateImpl.ActiveParent);
                    size2--;
                }
            }
            if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                return false;
            }
            focusTargetNode.dispatchFocusCallbacks$ui(focusState, FocusStateImpl.Active);
            if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                return false;
            }
            if (ComposeUiFlags.isViewFocusFixEnabled && DelegatableNodeKt.requireLayoutNode(focusTargetNode7).getInteropView() == null) {
                m4449requestOwnerFocusEtdf9zw(focusTargetNode, FocusDirection.m4399boximpl(FocusDirection.Companion.m4410getNextdhqQ8s()), null);
                return true;
            }
            return true;
        }
        return false;
    }

    public static final boolean captureFocus(FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(true);
            focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Captured);
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

    public static final boolean freeFocus(FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(false);
            focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Captured, FocusStateImpl.Active);
        }
        return true;
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
            if (!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
                }
            }
            return true;
        } else if (i == 2) {
            if (z && !ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Captured, FocusStateImpl.Inactive);
                }
            }
            return z;
        } else if (i != 3) {
            if (i == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        } else if (clearChildFocus(focusTargetNode, z, z2)) {
            if (z2) {
                focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
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
                FocusTargetNode.this.fetchFocusProperties$ui();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(focusTargetNode);
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

    /* renamed from: requestOwnerFocus-Etdf9zw$default  reason: not valid java name */
    static /* synthetic */ boolean m4450requestOwnerFocusEtdf9zw$default(FocusTargetNode focusTargetNode, FocusDirection focusDirection, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            focusDirection = null;
        }
        if ((i & 2) != 0) {
            rect = null;
        }
        return m4449requestOwnerFocusEtdf9zw(focusTargetNode, focusDirection, rect);
    }

    /* renamed from: requestOwnerFocus-Etdf9zw  reason: not valid java name */
    private static final boolean m4449requestOwnerFocusEtdf9zw(FocusTargetNode focusTargetNode, FocusDirection focusDirection, Rect rect) {
        return DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().mo4423requestOwnerFocus7o62pno(focusDirection, rect);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m4448performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        FocusTargetNode focusTargetNode2;
        NodeChain nodes$ui;
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode focusTargetNode3 = focusTargetNode;
            int m6535constructorimpl = NodeKind.m6535constructorimpl(1024);
            if (!focusTargetNode3.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = focusTargetNode3.getNode().getParent$ui();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode3);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    focusTargetNode2 = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m6535constructorimpl) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                            focusTargetNode2 = parent$ui;
                            MutableVector mutableVector = null;
                            while (focusTargetNode2 != null) {
                                if (focusTargetNode2 instanceof FocusTargetNode) {
                                    break loop0;
                                }
                                if ((focusTargetNode2.getKindSet$ui() & m6535constructorimpl) != 0 && (focusTargetNode2 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) focusTargetNode2).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                focusTargetNode2 = delegate$ui;
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
                                                    mutableVector.add(delegate$ui);
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
                        parent$ui = parent$ui.getParent$ui();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui();
                parent$ui = (requireLayoutNode == null || (nodes$ui = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            }
            FocusTargetNode focusTargetNode4 = focusTargetNode2;
            if (focusTargetNode4 == null) {
                return CustomDestinationResult.None;
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode4.getFocusState().ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        CustomDestinationResult m4448performCustomRequestFocusMxy_nc0 = m4448performCustomRequestFocusMxy_nc0(focusTargetNode4, i);
                        CustomDestinationResult customDestinationResult = m4448performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? m4448performCustomRequestFocusMxy_nc0 : null;
                        return customDestinationResult == null ? m4446performCustomEnterMxy_nc0(focusTargetNode4, i) : customDestinationResult;
                    }
                    return m4448performCustomRequestFocusMxy_nc0(focusTargetNode4, i);
                }
                return CustomDestinationResult.Cancelled;
            }
            return m4446performCustomEnterMxy_nc0(focusTargetNode4, i);
        }
        return m4445performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m4445performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                CustomDestinationResult m4445performCustomClearFocusMxy_nc0 = m4445performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
                if (m4445performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    m4445performCustomClearFocusMxy_nc0 = null;
                }
                return m4445performCustomClearFocusMxy_nc0 == null ? m4447performCustomExitMxy_nc0(focusTargetNode, i) : m4445performCustomClearFocusMxy_nc0;
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomEnter-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m4446performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusProperties fetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                fetchFocusProperties$ui.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                    FocusRequester cancel = FocusRequester.Companion.getCancel();
                    if (cancel == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.Companion.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4432requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                } else if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                    FocusRequester redirect$ui = FocusRequester.Companion.getRedirect$ui();
                    if (redirect$ui == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui == FocusRequester.Companion.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4432requestFocus3ESFkO8$default(redirect$ui, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m4447performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusProperties fetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                fetchFocusProperties$ui.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                    FocusRequester cancel = FocusRequester.Companion.getCancel();
                    if (cancel == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.Companion.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4432requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                } else if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                    FocusRequester redirect$ui = FocusRequester.Companion.getRedirect$ui();
                    if (redirect$ui == FocusRequester.Companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui == FocusRequester.Companion.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4432requestFocus3ESFkO8$default(redirect$ui, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
