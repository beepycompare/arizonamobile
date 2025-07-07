package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {421, TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_PHASE, 432, 434, 437}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
/* loaded from: classes.dex */
public final class DragGestureNode$startListeningForEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$startListeningForEvents$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$startListeningForEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$1 = new DragGestureNode$startListeningForEvents$1(this.this$0, continuation);
        dragGestureNode$startListeningForEvents$1.L$0 = obj;
        return dragGestureNode$startListeningForEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$startListeningForEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c9, code lost:
        if (r7.this$0.drag(new androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.AnonymousClass1(r1, r7.this$0, null), r7) != r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0104, code lost:
        if (r8 == r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0118, code lost:
        if (r8 != r0) goto L7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:43:0x00ee, B:40:0x00d2], limit reached: 56 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0092 -> B:19:0x005f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00eb -> B:19:0x005f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f2 -> B:19:0x005f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0104 -> B:19:0x005f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0118 -> B:11:0x0027). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        CoroutineScope coroutineScope2;
        CoroutineScope coroutineScope3;
        Object processDragCancel;
        Object processDragCancel2;
        Object processDragStop;
        T t;
        Object processDragStart;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                break;
            case 1:
                objectRef = (Ref.ObjectRef) this.L$2;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                t = (DragEvent) obj;
                objectRef.element = t;
                if (objectRef2.element instanceof DragEvent.DragStarted) {
                    this.L$0 = coroutineScope;
                    this.L$1 = objectRef2;
                    this.L$2 = null;
                    this.label = 2;
                    processDragStart = this.this$0.processDragStart((DragEvent.DragStarted) objectRef2.element, this);
                    if (processDragStart != coroutine_suspended) {
                        objectRef3 = objectRef2;
                        coroutineScope2 = coroutineScope;
                        this.L$0 = coroutineScope2;
                        this.L$1 = objectRef3;
                        this.label = 3;
                        break;
                    }
                    return coroutine_suspended;
                }
                break;
            case 2:
                objectRef3 = (Ref.ObjectRef) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope2;
                this.L$1 = objectRef3;
                this.label = 3;
                break;
            case 3:
                objectRef3 = (Ref.ObjectRef) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused) {
                    coroutineScope3 = coroutineScope2;
                    this.L$0 = coroutineScope3;
                    this.L$1 = null;
                    this.label = 6;
                    processDragCancel = this.this$0.processDragCancel(this);
                    break;
                }
                coroutineScope = coroutineScope2;
                try {
                } catch (CancellationException unused2) {
                    coroutineScope3 = coroutineScope;
                    this.L$0 = coroutineScope3;
                    this.L$1 = null;
                    this.label = 6;
                    processDragCancel = this.this$0.processDragCancel(this);
                }
                if (objectRef3.element instanceof DragEvent.DragStopped) {
                    DragGestureNode dragGestureNode = this.this$0;
                    T t2 = objectRef3.element;
                    Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.label = 4;
                    processDragStop = dragGestureNode.processDragStop((DragEvent.DragStopped) t2, this);
                    if (processDragStop == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (objectRef3.element instanceof DragEvent.DragCancelled) {
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.label = 5;
                    processDragCancel2 = this.this$0.processDragCancel(this);
                    break;
                }
                break;
            case 4:
                coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused3) {
                    this.L$0 = coroutineScope3;
                    this.L$1 = null;
                    this.label = 6;
                    processDragCancel = this.this$0.processDragCancel(this);
                    break;
                }
                coroutineScope = coroutineScope3;
                break;
            case 5:
                coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope3;
                break;
            case 6:
                coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            objectRef = new Ref.ObjectRef();
            channel = this.this$0.channel;
            if (channel != null) {
                this.L$0 = coroutineScope;
                this.L$1 = objectRef;
                this.L$2 = objectRef;
                this.label = 1;
                obj = channel.receive(this);
                if (obj != coroutine_suspended) {
                    objectRef2 = objectRef;
                    t = (DragEvent) obj;
                    objectRef.element = t;
                    if (objectRef2.element instanceof DragEvent.DragStarted) {
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            objectRef2 = objectRef;
            t = 0;
            objectRef.element = t;
            if (objectRef2.element instanceof DragEvent.DragStarted) {
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {428}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = objectRef;
            this.this$0 = dragGestureNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$event, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
            return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:25:0x0066). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:24:0x0063). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Function1 function1;
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                function1 = (Function1) this.L$0;
                if (this.$event.element instanceof DragEvent.DragStopped) {
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                Ref.ObjectRef<DragEvent> objectRef = (Ref.ObjectRef) this.L$1;
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
                T t = (DragEvent) obj;
                objectRef.element = t;
                if ((this.$event.element instanceof DragEvent.DragStopped) && !(this.$event.element instanceof DragEvent.DragCancelled)) {
                    DragEvent dragEvent = this.$event.element;
                    t = 0;
                    DragEvent.DragDelta dragDelta = dragEvent instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) dragEvent : null;
                    if (dragDelta != null) {
                        function1.invoke(dragDelta);
                    }
                    objectRef = this.$event;
                    channel = this.this$0.channel;
                    if (channel != null) {
                        this.L$0 = function1;
                        this.L$1 = objectRef;
                        this.label = 1;
                        obj = channel.receive(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        T t2 = (DragEvent) obj;
                    }
                    objectRef.element = t2;
                    if (this.$event.element instanceof DragEvent.DragStopped) {
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
