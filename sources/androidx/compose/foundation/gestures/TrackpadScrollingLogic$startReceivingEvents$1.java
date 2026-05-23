package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TrackpadScrollingLogic;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrackpadScrollingLogic.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic$startReceivingEvents$1", f = "TrackpadScrollingLogic.kt", i = {0, 1}, l = {99, 99}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"}, v = 1)
/* loaded from: classes.dex */
public final class TrackpadScrollingLogic$startReceivingEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TrackpadScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackpadScrollingLogic$startReceivingEvents$1(TrackpadScrollingLogic trackpadScrollingLogic, Continuation<? super TrackpadScrollingLogic$startReceivingEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = trackpadScrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrackpadScrollingLogic$startReceivingEvents$1 trackpadScrollingLogic$startReceivingEvents$1 = new TrackpadScrollingLogic$startReceivingEvents$1(this.this$0, continuation);
        trackpadScrollingLogic$startReceivingEvents$1.L$0 = obj;
        return trackpadScrollingLogic$startReceivingEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrackpadScrollingLogic$startReceivingEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:17:0x0039). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        TrackpadScrollingLogic trackpadScrollingLogic;
        ScrollingLogic scrollingLogic;
        Object dispatchTrackpadScroll;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else if (i == 1) {
                scrollingLogic = (ScrollingLogic) this.L$2;
                trackpadScrollingLogic = (TrackpadScrollingLogic) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope2;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                dispatchTrackpadScroll = trackpadScrollingLogic.dispatchTrackpadScroll(scrollingLogic, (TrackpadScrollingLogic.TrackpadScrollDelta) obj, this);
                if (dispatchTrackpadScroll != coroutine_suspended) {
                    coroutineScope = coroutineScope2;
                }
                return coroutine_suspended;
            } else if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope3;
            }
            boolean isActive = JobKt.isActive(coroutineScope.getCoroutineContext());
            trackpadScrollingLogic = this.this$0;
            if (!isActive) {
                trackpadScrollingLogic.receivingPanEventsJob = null;
                return Unit.INSTANCE;
            }
            scrollingLogic = trackpadScrollingLogic.getScrollingLogic();
            channel = this.this$0.channel;
            this.L$0 = coroutineScope;
            this.L$1 = trackpadScrollingLogic;
            this.L$2 = scrollingLogic;
            this.label = 1;
            Object receive = channel.receive(this);
            if (receive == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope2 = coroutineScope;
            obj = receive;
            this.L$0 = coroutineScope2;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            dispatchTrackpadScroll = trackpadScrollingLogic.dispatchTrackpadScroll(scrollingLogic, (TrackpadScrollingLogic.TrackpadScrollDelta) obj, this);
            if (dispatchTrackpadScroll != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            this.this$0.receivingPanEventsJob = null;
            throw th;
        }
    }
}
