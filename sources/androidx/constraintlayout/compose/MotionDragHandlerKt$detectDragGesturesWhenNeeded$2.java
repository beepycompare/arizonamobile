package androidx.constraintlayout.compose;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
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
import kotlin.jvm.internal.Ref;
/* compiled from: MotionDragHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2", f = "MotionDragHandler.kt", i = {0, 1, 1, 1}, l = {166, 174, 183}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop"}, s = {"L$0", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class MotionDragHandlerKt$detectDragGesturesWhenNeeded$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Boolean> $onAcceptFirstDown;
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MotionDragHandlerKt$detectDragGesturesWhenNeeded$2(Function1<? super Offset, Boolean> function1, Function1<? super Offset, Unit> function12, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super MotionDragHandlerKt$detectDragGesturesWhenNeeded$2> continuation) {
        super(2, continuation);
        this.$onAcceptFirstDown = function1;
        this.$onDragStart = function12;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MotionDragHandlerKt$detectDragGesturesWhenNeeded$2 motionDragHandlerKt$detectDragGesturesWhenNeeded$2 = new MotionDragHandlerKt$detectDragGesturesWhenNeeded$2(this.$onAcceptFirstDown, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        motionDragHandlerKt$detectDragGesturesWhenNeeded$2.L$0 = obj;
        return motionDragHandlerKt$detectDragGesturesWhenNeeded$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((MotionDragHandlerKt$detectDragGesturesWhenNeeded$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
        if (r12 != r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00db, code lost:
        if (r12 == r0) goto L23;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0097 -> B:24:0x009a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        AwaitPointerEventScope awaitPointerEventScope2;
        final Ref.LongRef longRef;
        PointerInputChange pointerInputChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = awaitPointerEventScope3;
            this.label = 1;
            obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, true, null, this, 2, null);
            if (obj != coroutine_suspended) {
                awaitPointerEventScope = awaitPointerEventScope3;
            }
            return coroutine_suspended;
        } else if (i == 1) {
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    this.$onDragCancel.invoke();
                } else {
                    this.$onDragEnd.invoke();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            longRef = (Ref.LongRef) this.L$2;
            pointerInputChange = (PointerInputChange) this.L$1;
            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 == null || pointerInputChange2.isConsumed()) {
                if (pointerInputChange2 != null) {
                    this.$onDragStart.invoke(Offset.m3826boximpl(pointerInputChange2.m5313getPositionF1C5BW0()));
                    this.$onDrag.invoke(pointerInputChange2, Offset.m3826boximpl(longRef.element));
                    long m5311getIdJ3iCeTQ = pointerInputChange2.m5311getIdJ3iCeTQ();
                    final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope2, m5311getIdJ3iCeTQ, new Function1<PointerInputChange, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2.2
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
                }
                return Unit.INSTANCE;
            }
            this.L$0 = awaitPointerEventScope2;
            this.L$1 = pointerInputChange;
            this.L$2 = longRef;
            this.label = 2;
            obj = DragGestureDetectorKt.m439awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, pointerInputChange.m5311getIdJ3iCeTQ(), new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3, Offset offset) {
                    m7087invokeUv8p0NA(pointerInputChange3, offset.m3847unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
                public final void m7087invokeUv8p0NA(PointerInputChange pointerInputChange3, long j) {
                    pointerInputChange3.consume();
                    Ref.LongRef.this.element = j;
                }
            }, this);
        }
        PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
        if (!this.$onAcceptFirstDown.invoke(Offset.m3826boximpl(pointerInputChange3.m5313getPositionF1C5BW0())).booleanValue()) {
            return Unit.INSTANCE;
        }
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = Offset.Companion.m3853getZeroF1C5BW0();
        awaitPointerEventScope2 = awaitPointerEventScope;
        longRef = longRef2;
        pointerInputChange = pointerInputChange3;
        this.L$0 = awaitPointerEventScope2;
        this.L$1 = pointerInputChange;
        this.L$2 = longRef;
        this.label = 2;
        obj = DragGestureDetectorKt.m439awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, pointerInputChange.m5311getIdJ3iCeTQ(), new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange32, Offset offset) {
                m7087invokeUv8p0NA(pointerInputChange32, offset.m3847unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
            public final void m7087invokeUv8p0NA(PointerInputChange pointerInputChange32, long j) {
                pointerInputChange32.consume();
                Ref.LongRef.this.element = j;
            }
        }, this);
    }
}
