package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BeyondBoundsLayout.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"searchBeyondBounds", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final <T> T m3716searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        FocusTargetNode focusTargetNode2;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int m5426getBeforehoxUOeE;
        NodeChain nodes$ui_release;
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
        if ((focusTargetNode4 == null || !Intrinsics.areEqual(focusTargetNode4.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) && (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) != null) {
            if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3732getUpdhqQ8s())) {
                m5426getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m5424getAbovehoxUOeE();
            } else if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3725getDowndhqQ8s())) {
                m5426getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m5427getBelowhoxUOeE();
            } else if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3728getLeftdhqQ8s())) {
                m5426getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m5428getLefthoxUOeE();
            } else if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3731getRightdhqQ8s())) {
                m5426getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m5429getRighthoxUOeE();
            } else if (FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3729getNextdhqQ8s())) {
                m5426getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m5425getAfterhoxUOeE();
            } else if (!FocusDirection.m3721equalsimpl0(i, FocusDirection.Companion.m3730getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            } else {
                m5426getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m5426getBeforehoxUOeE();
            }
            return (T) beyondBoundsLayoutParent.mo894layouto7g1Pn8(m5426getBeforehoxUOeE, function1);
        }
        return null;
    }
}
