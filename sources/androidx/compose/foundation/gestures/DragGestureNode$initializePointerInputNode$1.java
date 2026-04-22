package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragGestureNode$initializePointerInputNode$1 implements PointerInputEventHandler {
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragGestureNode$initializePointerInputNode$1(DragGestureNode dragGestureNode) {
        this.this$0 = dragGestureNode;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final VelocityTracker velocityTracker = new VelocityTracker();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.this$0));
        final DragGestureNode dragGestureNode = this.this$0;
        Function3 function3 = new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DragGestureNode$initializePointerInputNode$1.invoke$lambda$0(DragGestureNode.this, velocityTracker, (PointerInputChange) obj, (PointerInputChange) obj2, (Offset) obj3);
            }
        };
        final DragGestureNode dragGestureNode2 = this.this$0;
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragGestureNode$initializePointerInputNode$1.invoke$lambda$1(VelocityTracker.this, pointerInputScope, dragGestureNode2, (PointerInputChange) obj);
            }
        };
        final DragGestureNode dragGestureNode3 = this.this$0;
        Function0 function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DragGestureNode$initializePointerInputNode$1.invoke$lambda$2(DragGestureNode.this);
            }
        };
        final DragGestureNode dragGestureNode4 = this.this$0;
        Function0 function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DragGestureNode$initializePointerInputNode$1.invoke$lambda$3(DragGestureNode.this));
            }
        };
        final DragGestureNode dragGestureNode5 = this.this$0;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, this.this$0, function3, function1, function0, function02, new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DragGestureNode$initializePointerInputNode$1.invoke$lambda$4(DragGestureNode.this, longRef, velocityTracker, (PointerInputChange) obj, (Offset) obj2);
            }
        }, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$0(DragGestureNode dragGestureNode, VelocityTracker velocityTracker, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
        Channel channel;
        dragGestureNode.nodeOffset = Offset.Companion.m4543getZeroF1C5BW0();
        if (dragGestureNode.getCanDrag().invoke(PointerType.m6153boximpl(pointerInputChange.m6088getTypeT8wyACA())).booleanValue()) {
            if (!dragGestureNode.isListeningForEvents$foundation()) {
                dragGestureNode.startListeningForEvents();
            }
            VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
            long m4531minusMKHz9U = Offset.m4531minusMKHz9U(pointerInputChange2.m6085getPositionF1C5BW0(), offset.m4537unboximpl());
            channel = dragGestureNode.channel;
            if (channel != null) {
                ChannelResult.m10710boximpl(channel.mo8396trySendJP2dKIU(new DragEvent.DragStarted(m4531minusMKHz9U, null)));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$1(VelocityTracker velocityTracker, PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, PointerInputChange pointerInputChange) {
        Channel channel;
        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
        float maximumFlingVelocity = pointerInputScope.getViewConfiguration().getMaximumFlingVelocity();
        long m6191calculateVelocityAH228Gc = velocityTracker.m6191calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        velocityTracker.resetTracking();
        channel = dragGestureNode.channel;
        if (channel != null) {
            ChannelResult.m10710boximpl(channel.mo8396trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m488toValidVelocityTH1AsA0(m6191calculateVelocityAH228Gc), false, null)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$2(DragGestureNode dragGestureNode) {
        Channel channel;
        channel = dragGestureNode.channel;
        if (channel != null) {
            ChannelResult.m10710boximpl(channel.mo8396trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean invoke$lambda$3(DragGestureNode dragGestureNode) {
        return !dragGestureNode.startDragImmediately();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invoke$lambda$4(DragGestureNode dragGestureNode, Ref.LongRef longRef, VelocityTracker velocityTracker, PointerInputChange pointerInputChange, Offset offset) {
        long j;
        Channel channel;
        long j2;
        long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(dragGestureNode));
        if (!Offset.m4524equalsimpl0(positionOnScreen, longRef.element)) {
            long m4531minusMKHz9U = Offset.m4531minusMKHz9U(positionOnScreen, longRef.element);
            j2 = dragGestureNode.nodeOffset;
            dragGestureNode.nodeOffset = Offset.m4532plusMKHz9U(j2, m4531minusMKHz9U);
        }
        longRef.element = positionOnScreen;
        j = dragGestureNode.nodeOffset;
        VelocityTrackerKt.m6192addPointerInputChange0AR0LA0(velocityTracker, pointerInputChange, j);
        channel = dragGestureNode.channel;
        if (channel != null) {
            ChannelResult.m10710boximpl(channel.mo8396trySendJP2dKIU(new DragEvent.DragDelta(offset.m4537unboximpl(), false, null)));
        }
        return Unit.INSTANCE;
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {624}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = dragGestureNode;
            this.$onDragStart = function3;
            this.$onDragEnd = function1;
            this.$onDragCancel = function0;
            this.$shouldAwaitTouchSlop = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_SuspendingPointerInputModifierNode, this.this$0, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1] */
        /* JADX WARN: Type inference failed for: r11v1, types: [androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1] */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v11 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.CoroutineScope] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    Object detectDragGestures = DragGestureDetectorKt.detectDragGestures(this.$this_SuspendingPointerInputModifierNode, this.this$0.getOrientationLock(), this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, (Continuation) this);
                    r1 = coroutineScope;
                    this = detectDragGestures;
                    if (detectDragGestures == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (r1 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = coroutineScope2;
                    this = this;
                }
            } catch (CancellationException e) {
                channel = this.this$0.channel;
                if (channel != null) {
                    ChannelResult.m10710boximpl(channel.mo8396trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                }
                if (!CoroutineScopeKt.isActive(r1)) {
                    throw e;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
