package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {395}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<T> $downStream;
    /* synthetic */ Object L$0;
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
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return m10030invokeWpGqRn0(((ChannelResult) obj).m10009unboximpl(), continuation);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m10030invokeWpGqRn0(Object obj, Continuation<? super Boolean> continuation) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(ChannelResult.m9997boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10009unboximpl;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            m10009unboximpl = ((ChannelResult) this.L$0).m10009unboximpl();
            FlowCollector<T> flowCollector = this.$downStream;
            if (!(m10009unboximpl instanceof ChannelResult.Failed)) {
                this.L$0 = m10009unboximpl;
                this.label = 1;
                if (flowCollector.emit(m10009unboximpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = m10009unboximpl;
            }
            if (m10009unboximpl instanceof ChannelResult.Closed) {
                return Boxing.boxBoolean(true);
            }
            Throwable m10001exceptionOrNullimpl = ChannelResult.m10001exceptionOrNullimpl(m10009unboximpl);
            if (m10001exceptionOrNullimpl != null) {
                throw m10001exceptionOrNullimpl;
            }
            return Boxing.boxBoolean(false);
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            obj2 = this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        m10009unboximpl = obj2;
        if (m10009unboximpl instanceof ChannelResult.Closed) {
        }
    }
}
