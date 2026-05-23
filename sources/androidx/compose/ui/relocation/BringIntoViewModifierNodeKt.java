package androidx.compose.ui.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
/* compiled from: BringIntoViewModifierNode.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"bringIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "bounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BringIntoViewModifierNodeKt {
    public static /* synthetic */ Object bringIntoView$default(DelegatableNode delegatableNode, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return bringIntoView(delegatableNode, function0, continuation);
    }

    public static final Object bringIntoView(DelegatableNode delegatableNode, final Function0<Rect> function0, Continuation<? super Unit> continuation) {
        BringIntoViewModifierNode bringIntoViewModifierNode;
        final LayoutCoordinates requireLayoutCoordinates;
        Object bringIntoView;
        NodeChain nodes$ui;
        if (delegatableNode.getNode().isAttached()) {
            int m7135constructorimpl = NodeKind.m7135constructorimpl(524288);
            if (!delegatableNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = delegatableNode.getNode().getParent$ui();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            loop0: while (true) {
                bringIntoViewModifierNode = null;
                if (requireLayoutNode == null) {
                    break;
                }
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                            Modifier.Node node = parent$ui;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                if (node instanceof BringIntoViewModifierNode) {
                                    bringIntoViewModifierNode = node;
                                    break loop0;
                                }
                                if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
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
                                                        Boxing.boxBoolean(mutableVector.add(node));
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    Boxing.boxBoolean(mutableVector.add(delegate$ui));
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
            BringIntoViewModifierNode bringIntoViewModifierNode2 = bringIntoViewModifierNode;
            return (bringIntoViewModifierNode2 != null && (bringIntoView = bringIntoViewModifierNode2.bringIntoView((requireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(delegatableNode)), new Function0<Rect>() { // from class: androidx.compose.ui.relocation.BringIntoViewModifierNodeKt$bringIntoView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Rect invoke() {
                    Rect invoke;
                    Function0<Rect> function02 = function0;
                    if (function02 == null || (invoke = function02.invoke()) == null) {
                        LayoutCoordinates layoutCoordinates = requireLayoutCoordinates;
                        if (!layoutCoordinates.isAttached()) {
                            layoutCoordinates = null;
                        }
                        if (layoutCoordinates != null) {
                            return SizeKt.m5193toRectuvyYCjk(IntSizeKt.m8343toSizeozmzZPI(layoutCoordinates.mo6826getSizeYbymL2g()));
                        }
                        return null;
                    }
                    return invoke;
                }
            }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? bringIntoView : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
