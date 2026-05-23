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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.Channel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrackpadScrollingLogic.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3", f = "TrackpadScrollingLogic.kt", i = {0}, l = {178}, m = "invokeSuspend", n = {"$this$userScroll"}, s = {"L$0"}, v = 1)
/* loaded from: classes.dex */
public final class TrackpadScrollingLogic$dispatchTrackpadScroll$3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<TrackpadScrollingLogic.TrackpadScrollDelta> $targetScrollDelta;
    final /* synthetic */ ScrollingLogic $this_dispatchTrackpadScroll;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TrackpadScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackpadScrollingLogic$dispatchTrackpadScroll$3(TrackpadScrollingLogic trackpadScrollingLogic, ScrollingLogic scrollingLogic, Ref.ObjectRef<TrackpadScrollingLogic.TrackpadScrollDelta> objectRef, Continuation<? super TrackpadScrollingLogic$dispatchTrackpadScroll$3> continuation) {
        super(2, continuation);
        this.this$0 = trackpadScrollingLogic;
        this.$this_dispatchTrackpadScroll = scrollingLogic;
        this.$targetScrollDelta = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrackpadScrollingLogic$dispatchTrackpadScroll$3 trackpadScrollingLogic$dispatchTrackpadScroll$3 = new TrackpadScrollingLogic$dispatchTrackpadScroll$3(this.this$0, this.$this_dispatchTrackpadScroll, this.$targetScrollDelta, continuation);
        trackpadScrollingLogic$dispatchTrackpadScroll$3.L$0 = obj;
        return trackpadScrollingLogic$dispatchTrackpadScroll$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((TrackpadScrollingLogic$dispatchTrackpadScroll$3) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
    /* JADX WARN: Type inference failed for: r7v15, types: [androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0061 -> B:14:0x0064). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NestedScrollScope nestedScrollScope;
        Channel channel;
        Channel channel2;
        TrackpadScrollingLogic.TrackpadScrollDelta sumOrNull;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NestedScrollScope nestedScrollScope2 = (NestedScrollScope) this.L$0;
            TrackpadScrollingLogic trackpadScrollingLogic = this.this$0;
            ScrollingLogic scrollingLogic = this.$this_dispatchTrackpadScroll;
            trackpadScrollingLogic.dispatchTrackpadScroll(nestedScrollScope2, scrollingLogic.m623toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m619reverseIfNeededMKHz9U(this.$targetScrollDelta.element.m643getValueF1C5BW0())));
            nestedScrollScope = nestedScrollScope2;
            if (!this.$targetScrollDelta.element.isEnd()) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Ref.ObjectRef<TrackpadScrollingLogic.TrackpadScrollDelta> objectRef = (Ref.ObjectRef) this.L$1;
            nestedScrollScope = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            T t = obj;
            objectRef.element = t;
            this.this$0.trackVelocity(this.$targetScrollDelta.element);
            TrackpadScrollingLogic trackpadScrollingLogic2 = this.this$0;
            channel2 = trackpadScrollingLogic2.channel;
            sumOrNull = trackpadScrollingLogic2.sumOrNull(channel2);
            if (sumOrNull != null) {
                TrackpadScrollingLogic trackpadScrollingLogic3 = this.this$0;
                Ref.ObjectRef<TrackpadScrollingLogic.TrackpadScrollDelta> objectRef2 = this.$targetScrollDelta;
                trackpadScrollingLogic3.trackVelocity(sumOrNull);
                objectRef2.element = objectRef2.element.plus(sumOrNull);
            }
            TrackpadScrollingLogic trackpadScrollingLogic4 = this.this$0;
            ScrollingLogic scrollingLogic2 = this.$this_dispatchTrackpadScroll;
            trackpadScrollingLogic4.dispatchTrackpadScroll(nestedScrollScope, scrollingLogic2.m623toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic2.m619reverseIfNeededMKHz9U(this.$targetScrollDelta.element.m643getValueF1C5BW0())));
            if (!this.$targetScrollDelta.element.isEnd()) {
                objectRef = this.$targetScrollDelta;
                channel = this.this$0.channel;
                this.L$0 = nestedScrollScope;
                this.L$1 = objectRef;
                this.label = 1;
                Object busyReceive = NonTouchScrollingLogicKt.busyReceive(channel, this);
                t = busyReceive;
                if (busyReceive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef.element = t;
                this.this$0.trackVelocity(this.$targetScrollDelta.element);
                TrackpadScrollingLogic trackpadScrollingLogic22 = this.this$0;
                channel2 = trackpadScrollingLogic22.channel;
                sumOrNull = trackpadScrollingLogic22.sumOrNull(channel2);
                if (sumOrNull != null) {
                }
                TrackpadScrollingLogic trackpadScrollingLogic42 = this.this$0;
                ScrollingLogic scrollingLogic22 = this.$this_dispatchTrackpadScroll;
                trackpadScrollingLogic42.dispatchTrackpadScroll(nestedScrollScope, scrollingLogic22.m623toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic22.m619reverseIfNeededMKHz9U(this.$targetScrollDelta.element.m643getValueF1C5BW0())));
                if (!this.$targetScrollDelta.element.isEnd()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
