package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
/* compiled from: MotionDragHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$1$1", f = "MotionDragHandler.kt", i = {0, 0, 0, 1, 2, 2}, l = {77, 80, 85}, m = "invokeSuspend", n = {"$this$effectScope", "dragState", "isTouchUp", "$this$effectScope", "$this$effectScope", "isTouchUp"}, s = {"L$0", "L$1", "I$0", "L$0", "L$0", "I$0"})
/* loaded from: classes2.dex */
final class MotionDragHandlerKt$motionPointerInput$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<MotionDragState> $dragChannel;
    final /* synthetic */ TransitionHandler $swipeHandler;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionDragHandlerKt$motionPointerInput$2$1$1(TransitionHandler transitionHandler, Channel<MotionDragState> channel, Continuation<? super MotionDragHandlerKt$motionPointerInput$2$1$1> continuation) {
        super(2, continuation);
        this.$swipeHandler = transitionHandler;
        this.$dragChannel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MotionDragHandlerKt$motionPointerInput$2$1$1 motionDragHandlerKt$motionPointerInput$2$1$1 = new MotionDragHandlerKt$motionPointerInput$2$1$1(this.$swipeHandler, this.$dragChannel, continuation);
        motionDragHandlerKt$motionPointerInput$2$1$1.L$0 = obj;
        return motionDragHandlerKt$motionPointerInput$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MotionDragHandlerKt$motionPointerInput$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
        if (r12 == r0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0070 -> B:37:0x00c2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b3 -> B:34:0x00b4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b6 -> B:36:0x00bf). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        int i;
        MotionDragState motionDragState;
        CoroutineScope coroutineScope2;
        boolean isDragging;
        int i2;
        CoroutineScope coroutineScope3;
        int i3;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            i = 0;
            motionDragState = null;
            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
            }
        } else if (i4 == 1) {
            i3 = this.I$0;
            motionDragState = (MotionDragState) this.L$1;
            coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            coroutineScope = coroutineScope3;
            obj2 = this.$dragChannel.mo9990tryReceivePtdJZtk();
            if (ChannelResult.m10007isSuccessimpl(obj2)) {
            }
            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
            }
        } else if (i4 != 2) {
            if (i4 == 3) {
                int i5 = this.I$0;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                i2 = i5;
                coroutineScope = coroutineScope2;
                i = i2;
                motionDragState = null;
                obj2 = this.$dragChannel.mo9990tryReceivePtdJZtk();
                if (ChannelResult.m10007isSuccessimpl(obj2)) {
                    motionDragState = (MotionDragState) ChannelResult.m10003getOrThrowimpl(obj2);
                    if (motionDragState.isDragging()) {
                        i = 0;
                    }
                }
                if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                    if (i != 0 && this.$swipeHandler.pendingProgressWhileTouchUp()) {
                        this.L$0 = coroutineScope;
                        this.L$1 = motionDragState;
                        this.I$0 = i;
                        this.label = 1;
                        if (this.$swipeHandler.updateProgressWhileTouchUp(this) != coroutine_suspended) {
                            coroutineScope3 = coroutineScope;
                            i3 = i;
                            i = i3;
                            coroutineScope = coroutineScope3;
                            obj2 = this.$dragChannel.mo9990tryReceivePtdJZtk();
                            if (ChannelResult.m10007isSuccessimpl(obj2)) {
                            }
                            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                            }
                        }
                    } else {
                        if (motionDragState == null) {
                            this.L$0 = coroutineScope;
                            this.L$1 = null;
                            this.label = 2;
                            obj = this.$dragChannel.receive(this);
                        }
                        MotionDragState motionDragState2 = motionDragState;
                        coroutineScope2 = coroutineScope;
                        JobKt.ensureActive(coroutineScope2.getCoroutineContext());
                        isDragging = motionDragState2.isDragging();
                        i2 = !isDragging;
                        if (isDragging != 0) {
                            this.L$0 = coroutineScope2;
                            this.L$1 = null;
                            this.I$0 = i2;
                            this.label = 3;
                            if (this.$swipeHandler.m7155onTouchUpsFctU(motionDragState2.m7096getVelocity9UxMQ8M(), this) != coroutine_suspended) {
                                i5 = i2;
                                i2 = i5;
                                coroutineScope = coroutineScope2;
                                i = i2;
                                motionDragState = null;
                                obj2 = this.$dragChannel.mo9990tryReceivePtdJZtk();
                                if (ChannelResult.m10007isSuccessimpl(obj2)) {
                                }
                                if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                                }
                            }
                        } else {
                            this.$swipeHandler.m7156updateProgressOnDragk4lQ0M(motionDragState2.m7095getDragAmountF1C5BW0());
                            coroutineScope = coroutineScope2;
                            i = i2;
                            motionDragState = null;
                            obj2 = this.$dragChannel.mo9990tryReceivePtdJZtk();
                            if (ChannelResult.m10007isSuccessimpl(obj2)) {
                            }
                            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            motionDragState = (MotionDragState) obj;
            MotionDragState motionDragState22 = motionDragState;
            coroutineScope2 = coroutineScope;
            JobKt.ensureActive(coroutineScope2.getCoroutineContext());
            isDragging = motionDragState22.isDragging();
            i2 = !isDragging;
            if (isDragging != 0) {
            }
        }
    }
}
