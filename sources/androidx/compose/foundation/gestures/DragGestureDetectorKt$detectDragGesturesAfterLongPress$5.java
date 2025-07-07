package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {354, 355, RouletteView.PREMIUM_ROULETTE_WIDTH}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
        this.$onDrag = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[Catch: CancellationException -> 0x00c8, TryCatch #0 {CancellationException -> 0x00c8, blocks: (B:8:0x0015, B:32:0x008e, B:34:0x0096, B:36:0x00a8, B:38:0x00b4, B:39:0x00b7, B:40:0x00ba, B:41:0x00c0, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[Catch: CancellationException -> 0x00c8, TryCatch #0 {CancellationException -> 0x00c8, blocks: (B:8:0x0015, B:32:0x008e, B:34:0x0096, B:36:0x00a8, B:38:0x00b4, B:39:0x00b7, B:40:0x00ba, B:41:0x00c0, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c0 A[Catch: CancellationException -> 0x00c8, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00c8, blocks: (B:8:0x0015, B:32:0x008e, B:34:0x0096, B:36:0x00a8, B:38:0x00b4, B:39:0x00b7, B:40:0x00ba, B:41:0x00c0, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        PointerInputChange pointerInputChange;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                awaitPointerEventScope = awaitPointerEventScope3;
            } else if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                            int size = changes.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                PointerInputChange pointerInputChange2 = changes.get(i2);
                                if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                    pointerInputChange2.consume();
                                }
                            }
                            this.$onDragEnd.invoke();
                        } else {
                            this.$onDragCancel.invoke();
                        }
                        return Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(Offset.m3826boximpl(pointerInputChange.m5313getPositionF1C5BW0()));
                    long m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
                    final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, m5311getIdJ3iCeTQ, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                            invoke2(pointerInputChange3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(PointerInputChange pointerInputChange3) {
                            function2.invoke(pointerInputChange3, Offset.m3826boximpl(PointerEventKt.positionChange(pointerInputChange3)));
                            pointerInputChange3.consume();
                        }
                    }, this);
                    if (obj != coroutine_suspended) {
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = awaitPointerEventScope;
            this.label = 2;
            obj = DragGestureDetectorKt.m435awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, ((PointerInputChange) obj).m5311getIdJ3iCeTQ(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            this.$onDragCancel.invoke();
            throw e;
        }
    }
}
