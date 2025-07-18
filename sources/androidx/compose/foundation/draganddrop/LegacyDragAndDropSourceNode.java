package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: LegacyDragAndDropSource.android.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR=\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u0018X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/draganddrop/LegacyDragAndDropSourceNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "setDragAndDropSourceHandler", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "setDrawDragDecoration", "(Lkotlin/jvm/functions/Function1;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyDragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {
    public static final int $stable = 8;
    private Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> dragAndDropSourceHandler;
    private Function1<? super DrawScope, Unit> drawDragDecoration;
    private long size = IntSize.Companion.m6860getZeroYbymL2g();

    public final Function1<DrawScope, Unit> getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    public final void setDrawDragDecoration(Function1<? super DrawScope, Unit> function1) {
        this.drawDragDecoration = function1;
    }

    public final Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final void setDragAndDropSourceHandler(Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.dragAndDropSourceHandler = function2;
    }

    public LegacyDragAndDropSourceNode(Function1<? super DrawScope, Unit> function1, Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.drawDragDecoration = function1;
        this.dragAndDropSourceHandler = function2;
        final DragAndDropModifierNode dragAndDropModifierNode = (DragAndDropModifierNode) delegate(DragAndDropNodeKt.DragAndDropModifierNode());
        delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.draganddrop.LegacyDragAndDropSourceNode.1

            /* compiled from: LegacyDragAndDropSource.android.kt */
            @Metadata(d1 = {"\u0000\u0083\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J=\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2'\u0010\u001d\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001e¢\u0006\u0002\b\"H\u0096A¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0017\u0010(\u001a\u00020)*\u00020*H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0017\u0010(\u001a\u00020)*\u00020-H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020**\u00020-H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001a\u00100\u001a\u00020**\u00020\u0004H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001a\u00100\u001a\u00020**\u00020)H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00105J\u0017\u00106\u001a\u000207*\u00020\bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u0004*\u00020*H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b;\u00104J\u0017\u0010:\u001a\u00020\u0004*\u00020-H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b<\u00102J\r\u0010=\u001a\u00020>*\u00020?H\u0097\u0001J\u0017\u0010@\u001a\u00020\b*\u000207H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bA\u00109J\u0017\u0010B\u001a\u00020-*\u00020*H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001a\u0010B\u001a\u00020-*\u00020\u0004H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010DJ\u001a\u0010B\u001a\u00020-*\u00020)H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u0014\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\b8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0012\u0010\u0017\u001a\u00020\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"androidx/compose/foundation/draganddrop/LegacyDragAndDropSourceNode$1$1", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "<anonymous parameter 0>", "", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTransfer", "", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* renamed from: androidx.compose.foundation.draganddrop.LegacyDragAndDropSourceNode$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C00071 implements DragAndDropSourceScope, PointerInputScope {
                private final /* synthetic */ PointerInputScope $$delegate_0;
                final /* synthetic */ DragAndDropModifierNode $dragAndDropModifierNode;
                final /* synthetic */ LegacyDragAndDropSourceNode this$0;

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
                    return this.$$delegate_0.awaitPointerEventScope(function2, continuation);
                }

                @Override // androidx.compose.ui.unit.Density
                public float getDensity() {
                    return this.$$delegate_0.getDensity();
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                /* renamed from: getExtendedTouchPadding-NH-jbRc */
                public long mo379getExtendedTouchPaddingNHjbRc() {
                    return this.$$delegate_0.mo379getExtendedTouchPaddingNHjbRc();
                }

                @Override // androidx.compose.ui.unit.FontScaling
                public float getFontScale() {
                    return this.$$delegate_0.getFontScale();
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public boolean getInterceptOutOfBoundsChildEvents() {
                    return this.$$delegate_0.getInterceptOutOfBoundsChildEvents();
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                /* renamed from: getSize-YbymL2g */
                public long mo380getSizeYbymL2g() {
                    return this.$$delegate_0.mo380getSizeYbymL2g();
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public ViewConfiguration getViewConfiguration() {
                    return this.$$delegate_0.getViewConfiguration();
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: roundToPx--R2X_6o */
                public int mo382roundToPxR2X_6o(long j) {
                    return this.$$delegate_0.mo382roundToPxR2X_6o(j);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: roundToPx-0680j_4 */
                public int mo383roundToPx0680j_4(float f) {
                    return this.$$delegate_0.mo383roundToPx0680j_4(f);
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public void setInterceptOutOfBoundsChildEvents(boolean z) {
                    this.$$delegate_0.setInterceptOutOfBoundsChildEvents(z);
                }

                @Override // androidx.compose.ui.unit.FontScaling
                /* renamed from: toDp-GaN1DYA */
                public float mo384toDpGaN1DYA(long j) {
                    return this.$$delegate_0.mo384toDpGaN1DYA(j);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toDp-u2uoSUM */
                public float mo385toDpu2uoSUM(float f) {
                    return this.$$delegate_0.mo385toDpu2uoSUM(f);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toDp-u2uoSUM */
                public float mo386toDpu2uoSUM(int i) {
                    return this.$$delegate_0.mo386toDpu2uoSUM(i);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toDpSize-k-rfVVM */
                public long mo387toDpSizekrfVVM(long j) {
                    return this.$$delegate_0.mo387toDpSizekrfVVM(j);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toPx--R2X_6o */
                public float mo388toPxR2X_6o(long j) {
                    return this.$$delegate_0.mo388toPxR2X_6o(j);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toPx-0680j_4 */
                public float mo389toPx0680j_4(float f) {
                    return this.$$delegate_0.mo389toPx0680j_4(f);
                }

                @Override // androidx.compose.ui.unit.Density
                public Rect toRect(DpRect dpRect) {
                    return this.$$delegate_0.toRect(dpRect);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toSize-XkaWNTQ */
                public long mo390toSizeXkaWNTQ(long j) {
                    return this.$$delegate_0.mo390toSizeXkaWNTQ(j);
                }

                @Override // androidx.compose.ui.unit.FontScaling
                /* renamed from: toSp-0xMU5do */
                public long mo391toSp0xMU5do(float f) {
                    return this.$$delegate_0.mo391toSp0xMU5do(f);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toSp-kPz2Gy4 */
                public long mo392toSpkPz2Gy4(float f) {
                    return this.$$delegate_0.mo392toSpkPz2Gy4(f);
                }

                @Override // androidx.compose.ui.unit.Density
                /* renamed from: toSp-kPz2Gy4 */
                public long mo393toSpkPz2Gy4(int i) {
                    return this.$$delegate_0.mo393toSpkPz2Gy4(i);
                }

                C00071(PointerInputScope pointerInputScope, DragAndDropModifierNode dragAndDropModifierNode, LegacyDragAndDropSourceNode legacyDragAndDropSourceNode) {
                    this.$dragAndDropModifierNode = dragAndDropModifierNode;
                    this.this$0 = legacyDragAndDropSourceNode;
                    this.$$delegate_0 = pointerInputScope;
                }

                @Override // androidx.compose.foundation.draganddrop.DragAndDropSourceScope
                public void startTransfer(DragAndDropTransferData dragAndDropTransferData) {
                    this.$dragAndDropModifierNode.mo3675drag12SF9DM(dragAndDropTransferData, IntSizeKt.m6867toSizeozmzZPI(mo380getSizeYbymL2g()), this.this$0.getDrawDragDecoration());
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object invoke = LegacyDragAndDropSourceNode.this.getDragAndDropSourceHandler().invoke(new C00071(pointerInputScope, dragAndDropModifierNode, LegacyDragAndDropSourceNode.this), continuation);
                return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
            }
        }));
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo377onRemeasuredozmzZPI(long j) {
        this.size = j;
    }
}
