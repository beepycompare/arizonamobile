package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusTraversal.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aC\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\f\u0010\u0011\u001a\u00020\f*\u00020\u0002H\u0000\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0000\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002\"\u0018\u0010\u0012\u001a\u00020\n*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "focusSearch", "", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "focusRect", "isEligibleForFocusSearch", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "activeChild", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "findActiveFocusNode", "findNonDeactivatedParent", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTraversalKt {

    /* compiled from: FocusTraversal.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8  reason: not valid java name */
    public static final FocusRequester m5027customFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusRequester focusRequester;
        FocusRequester start;
        FocusProperties fetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4986getNextdhqQ8s())) {
            return fetchFocusProperties$ui.getNext();
        }
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4987getPreviousdhqQ8s())) {
            return fetchFocusProperties$ui.getPrevious();
        }
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4989getUpdhqQ8s())) {
            return fetchFocusProperties$ui.getUp();
        }
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4982getDowndhqQ8s())) {
            return fetchFocusProperties$ui.getDown();
        }
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4985getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                start = fetchFocusProperties$ui.getStart();
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                start = fetchFocusProperties$ui.getEnd();
            }
            focusRequester = start != FocusRequester.Companion.getDefault() ? start : null;
            return focusRequester == null ? fetchFocusProperties$ui.getLeft() : focusRequester;
        } else if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4988getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                end = fetchFocusProperties$ui.getEnd();
            } else if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                end = fetchFocusProperties$ui.getStart();
            }
            focusRequester = end != FocusRequester.Companion.getDefault() ? end : null;
            return focusRequester == null ? fetchFocusProperties$ui.getRight() : focusRequester;
        } else if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4983getEnterdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4984getExitdhqQ8s())) {
            CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
            FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
            if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4983getEnterdhqQ8s())) {
                fetchFocusProperties$ui.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
            } else {
                fetchFocusProperties$ui.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
            }
            if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                return FocusRequester.Companion.getCancel();
            }
            if (activeFocusTargetNode != focusOwner.getActiveFocusTargetNode()) {
                return FocusRequester.Companion.getRedirect$ui();
            }
            return FocusRequester.Companion.getDefault();
        } else {
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
    }

    /* renamed from: focusSearch-0X8WOeE  reason: not valid java name */
    public static final Boolean m5028focusSearch0X8WOeE(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        int m4988getRightdhqQ8s;
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4986getNextdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4987getPreviousdhqQ8s())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.m5042oneDimensionalFocusSearchOMvw8(focusTargetNode, i, function1));
        }
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4985getLeftdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4988getRightdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4989getUpdhqQ8s()) || FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4982getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m5053twoDimensionalFocusSearchsMXa3k8(focusTargetNode, i, rect, function1);
        }
        if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4983getEnterdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                m4988getRightdhqQ8s = FocusDirection.Companion.m4988getRightdhqQ8s();
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                m4988getRightdhqQ8s = FocusDirection.Companion.m4985getLeftdhqQ8s();
            }
            FocusTargetNode findActiveFocusNode = findActiveFocusNode(focusTargetNode);
            if (findActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m5053twoDimensionalFocusSearchsMXa3k8(findActiveFocusNode, m4988getRightdhqQ8s, rect, function1);
            }
            return null;
        } else if (FocusDirection.m4978equalsimpl0(i, FocusDirection.Companion.m4984getExitdhqQ8s())) {
            FocusTargetNode findActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
            FocusTargetNode findNonDeactivatedParent = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            return Boolean.valueOf((findNonDeactivatedParent == null || Intrinsics.areEqual(findNonDeactivatedParent, focusTargetNode)) ? false : function1.invoke(findNonDeactivatedParent).booleanValue());
        } else {
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m4980toStringimpl(i))).toString());
        }
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        LayoutCoordinates findRootCoordinates;
        if (focusTargetNode.isAttached()) {
            NodeCoordinator coordinator$ui = focusTargetNode.getCoordinator$ui();
            if (coordinator$ui != null && (findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(coordinator$ui)) != null) {
                if (!findRootCoordinates.isAttached()) {
                    findRootCoordinates = null;
                }
                if (findRootCoordinates != null) {
                    return focusTargetNode.fetchFocusRect$ui(findRootCoordinates);
                }
            }
            return Rect.Companion.getZero();
        }
        return Rect.Companion.getZero();
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator$ui;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator$ui2 = focusTargetNode.getCoordinator$ui();
        return (coordinator$ui2 == null || (layoutNode = coordinator$ui2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator$ui = focusTargetNode.getCoordinator$ui()) == null || (layoutNode2 = coordinator$ui.getLayoutNode()) == null || !layoutNode2.isAttached()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode getActiveChild(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.getNode().isAttached()) {
            FocusTargetNode focusTargetNode2 = focusTargetNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
            if (!focusTargetNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui = focusTargetNode2.getNode().getChild$ui();
            if (child$ui == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode2.getNode(), false);
            } else {
                mutableVector.add(child$ui);
            }
            while (mutableVector.getSize() != 0) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui() & m7135constructorimpl) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                    if (focusTargetNode3.getNode().isAttached()) {
                                        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode3.getFocusState().ordinal()];
                                        if (i == 1 || i == 2 || i == 3) {
                                            return focusTargetNode3;
                                        }
                                        if (i != 4) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node = delegate$ui;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        } else {
                            node = node.getChild$ui();
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeFocusTargetNode = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode();
        if (activeFocusTargetNode == null || !activeFocusTargetNode.isAttached()) {
            return null;
        }
        return activeFocusTargetNode;
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode focusTargetNode) {
        NodeChain nodes$ui;
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
        if (!focusTargetNode2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui = focusTargetNode2.getNode().getParent$ui();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                while (parent$ui != null) {
                    if ((parent$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                        Modifier.Node node = parent$ui;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3.fetchFocusProperties$ui().getCanFocus()) {
                                    return focusTargetNode3;
                                }
                            } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
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
                        continue;
                    }
                    parent$ui = parent$ui.getParent$ui();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui();
            parent$ui = (requireLayoutNode == null || (nodes$ui = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
        }
        return null;
    }
}
