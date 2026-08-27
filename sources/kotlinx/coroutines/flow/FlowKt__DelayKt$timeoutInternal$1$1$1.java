package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0, 0, 0, 0, 0}, l = {395}, m = "invokeSuspend", n = {"value", "$v$c$kotlinx-coroutines-channels-ChannelResult$-$this$onSuccess$0$iv", "it", "$i$f$onSuccess-WpGqRn0", "$i$a$-onSuccess-WpGqRn0-FlowKt__DelayKt$timeoutInternal$1$1$1$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<T> $downStream;
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> continuation) {
        super(2, continuation);
        this.$downStream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, continuation);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = ((ChannelResult) obj).m11479unboximpl();
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return m11497invokeWpGqRn0(((ChannelResult) obj).m11479unboximpl(), continuation);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m11497invokeWpGqRn0(Object obj, Continuation<? super Boolean> continuation) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(ChannelResult.m11467boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.$downStream;
            if (!(obj2 instanceof ChannelResult.Failed)) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$1 = obj2;
                this.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj3 = this.L$1;
            ResultKt.throwOnFailure(obj);
            obj2 = obj3;
        }
        if (obj2 instanceof ChannelResult.Closed) {
            Throwable m11471exceptionOrNullimpl = ChannelResult.m11471exceptionOrNullimpl(obj2);
            if (m11471exceptionOrNullimpl != null) {
                throw m11471exceptionOrNullimpl;
            }
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(true);
    }
}
