package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: RxConvert.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$2", f = "RxConvert.kt", i = {0, 1, 1}, l = {147, 148}, m = "invokeSuspend", n = {"$this$rxObservable", "$this$rxObservable", "t"}, s = {"L$0", "L$0", "L$2"}, v = 1)
/* loaded from: classes5.dex */
final class RxConvertKt$asObservable$2<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<T> $this_asObservable;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RxConvertKt$asObservable$2(ReceiveChannel<? extends T> receiveChannel, Continuation<? super RxConvertKt$asObservable$2> continuation) {
        super(2, continuation);
        this.$this_asObservable = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asObservable$2 rxConvertKt$asObservable$2 = new RxConvertKt$asObservable$2(this.$this_asObservable, continuation);
        rxConvertKt$asObservable$2.L$0 = obj;
        return rxConvertKt$asObservable$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        if (r0.send(r9, r8) == r1) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0069 -> B:7:0x0019). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<T> it;
        ChannelIterator<T> channelIterator;
        Object hasNext;
        ProducerScope producerScope = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.$this_asObservable.iterator();
            this.L$0 = producerScope;
            this.L$1 = it;
            this.L$2 = null;
            this.label = 1;
            hasNext = it.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i == 2) {
                channelIterator = (ChannelIterator) this.L$1;
                ResultKt.throwOnFailure(obj);
                it = channelIterator;
                this.L$0 = producerScope;
                this.L$1 = it;
                this.L$2 = null;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = hasNext;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    T next = channelIterator.next();
                    this.L$0 = producerScope;
                    this.L$1 = channelIterator;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(next);
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            channelIterator = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }
}
