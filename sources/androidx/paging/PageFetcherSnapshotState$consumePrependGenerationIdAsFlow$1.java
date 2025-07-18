package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageFetcherSnapshotState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, Continuation<? super PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcherSnapshotState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return ((PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        int i;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            channel = ((PageFetcherSnapshotState) this.this$0).prependGenerationIdCh;
            i = ((PageFetcherSnapshotState) this.this$0).prependGenerationId;
            channel.mo7544trySendJP2dKIU(Boxing.boxInt(i));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
