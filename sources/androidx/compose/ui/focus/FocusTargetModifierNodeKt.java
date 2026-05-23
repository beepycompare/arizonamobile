package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusTargetModifierNode.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0001¨\u0006\u0010"}, d2 = {"FocusTargetModifierNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "Lkotlin/ParameterName;", "name", "previous", "current", "", "FocusTargetModifierNode-PYyLHbc", "(ILkotlin/jvm/functions/Function2;)Landroidx/compose/ui/focus/FocusTargetModifierNode;", "getFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTargetModifierNodeKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the other overload with added parameters for focusability and onFocusChange")
    public static final /* synthetic */ FocusTargetModifierNode FocusTargetModifierNode() {
        return new FocusTargetNode(0, false, null, new FocusTargetModifierNodeKt$FocusTargetModifierNode$1(InvalidateSemantics.INSTANCE), 7, null);
    }

    /* renamed from: FocusTargetModifierNode-PYyLHbc$default  reason: not valid java name */
    public static /* synthetic */ FocusTargetModifierNode m5015FocusTargetModifierNodePYyLHbc$default(int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Focusability.Companion.m5037getAlwaysLCbbffg();
        }
        if ((i2 & 2) != 0) {
            function2 = null;
        }
        return m5014FocusTargetModifierNodePYyLHbc(i, function2);
    }

    /* renamed from: FocusTargetModifierNode-PYyLHbc  reason: not valid java name */
    public static final FocusTargetModifierNode m5014FocusTargetModifierNodePYyLHbc(int i, Function2<? super FocusState, ? super FocusState, Unit> function2) {
        return new FocusTargetNode(i, false, function2, null, 10, null);
    }

    public static final Rect getFocusedRect(FocusTargetModifierNode focusTargetModifierNode) {
        if (focusTargetModifierNode.getNode().isAttached()) {
            FocusState focusState = focusTargetModifierNode.getFocusState();
            if (focusState.getHasFocus()) {
                if (focusState.isFocused()) {
                    Intrinsics.checkNotNull(focusTargetModifierNode, "null cannot be cast to non-null type androidx.compose.ui.focus.FocusTargetNode");
                    return FocusTargetNode.fetchFocusRect$ui$default((FocusTargetNode) focusTargetModifierNode, null, 1, null);
                }
                FocusTargetModifierNode focusTargetModifierNode2 = focusTargetModifierNode;
                FocusTargetNode activeFocusTargetNode = DelegatableNodeKt.requireOwner(focusTargetModifierNode2).getFocusOwner().getActiveFocusTargetNode();
                if (activeFocusTargetNode != null) {
                    return activeFocusTargetNode.fetchFocusRect$ui(DelegatableNodeKt.requireLayoutCoordinates(focusTargetModifierNode2));
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
