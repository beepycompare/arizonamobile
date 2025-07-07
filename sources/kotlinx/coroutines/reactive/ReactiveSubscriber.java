package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0086@¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/reactivestreams/Subscriber;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "requestSize", "", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "subscription", "Lorg/reactivestreams/Subscription;", "channel", "Lkotlinx/coroutines/channels/Channel;", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onNext", "", "value", "(Ljava/lang/Object;)V", "onComplete", "onError", "t", "", "onSubscribe", CmcdData.STREAMING_FORMAT_SS, "makeRequest", FacebookDialog.COMPLETION_GESTURE_CANCEL, "kotlinx-coroutines-reactive"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactiveSubscriber<T> implements Subscriber<T> {
    private final Channel<T> channel;
    private final long requestSize;
    private Subscription subscription;

    public ReactiveSubscriber(int i, BufferOverflow bufferOverflow, long j) {
        this.requestSize = j;
        this.channel = kotlinx.coroutines.channels.ChannelKt.Channel$default(i == 0 ? 1 : i, bufferOverflow, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object takeNextOrNull(Continuation<? super T> continuation) {
        ReactiveSubscriber$takeNextOrNull$1 reactiveSubscriber$takeNextOrNull$1;
        int i;
        Object obj;
        Throwable m9970exceptionOrNullimpl;
        if (continuation instanceof ReactiveSubscriber$takeNextOrNull$1) {
            reactiveSubscriber$takeNextOrNull$1 = (ReactiveSubscriber$takeNextOrNull$1) continuation;
            if ((reactiveSubscriber$takeNextOrNull$1.label & Integer.MIN_VALUE) != 0) {
                reactiveSubscriber$takeNextOrNull$1.label -= Integer.MIN_VALUE;
                Object obj2 = reactiveSubscriber$takeNextOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = reactiveSubscriber$takeNextOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Channel<T> channel = this.channel;
                    reactiveSubscriber$takeNextOrNull$1.label = 1;
                    obj = channel.mo9958receiveCatchingJP2dKIU(reactiveSubscriber$takeNextOrNull$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj2);
                    obj = ((ChannelResult) obj2).m9978unboximpl();
                }
                m9970exceptionOrNullimpl = ChannelResult.m9970exceptionOrNullimpl(obj);
                if (m9970exceptionOrNullimpl == null) {
                    throw m9970exceptionOrNullimpl;
                }
                if (obj instanceof ChannelResult.Failed) {
                    ChannelResult.m9970exceptionOrNullimpl(obj);
                    return null;
                }
                return obj;
            }
        }
        reactiveSubscriber$takeNextOrNull$1 = new ReactiveSubscriber$takeNextOrNull$1(this, continuation);
        Object obj22 = reactiveSubscriber$takeNextOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = reactiveSubscriber$takeNextOrNull$1.label;
        if (i != 0) {
        }
        m9970exceptionOrNullimpl = ChannelResult.m9970exceptionOrNullimpl(obj);
        if (m9970exceptionOrNullimpl == null) {
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!ChannelResult.m9976isSuccessimpl(this.channel.mo7544trySendJP2dKIU(t))) {
            throw new IllegalArgumentException(("Element " + t + " was not added to channel because it was full, " + this.channel).toString());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.channel.close(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        makeRequest();
    }

    public final void makeRequest() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription = null;
        }
        subscription.request(this.requestSize);
    }

    public final void cancel() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription = null;
        }
        subscription.cancel();
    }
}
