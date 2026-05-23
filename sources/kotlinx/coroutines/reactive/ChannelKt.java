package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;
/* compiled from: Channel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0001\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Publisher;", "action", "Lkotlin/Function1;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "request", "", "openSubscription", "kotlinx-coroutines-reactive"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: all -> 0x00cb, TryCatch #2 {all -> 0x00cb, blocks: (B:23:0x00a9, B:25:0x00b1, B:26:0x00c3), top: B:41:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3 A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #2 {all -> 0x00cb, blocks: (B:23:0x00a9, B:25:0x00b1, B:26:0x00c3), top: B:41:0x00a9 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009d -> B:41:0x00a9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelKt$collect$1 channelKt$collect$1;
        int i;
        ReceiveChannel receiveChannel;
        int i2;
        ReceiveChannel channel$default;
        int i3;
        ChannelIterator it;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        int i4;
        ChannelKt$collect$1 channelKt$collect$12;
        int i5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelKt$collect$1) {
                channelKt$collect$1 = (ChannelKt$collect$1) continuation;
                if ((channelKt$collect$1.label & Integer.MIN_VALUE) != 0) {
                    channelKt$collect$1.label -= Integer.MIN_VALUE;
                    Object obj = channelKt$collect$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelKt$collect$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        i2 = 0;
                        channel$default = toChannel$default(publisher, 0, 1, null);
                        i3 = 0;
                        it = channel$default.iterator();
                        th = null;
                        receiveChannel2 = channel$default;
                        receiveChannel3 = receiveChannel2;
                        i4 = 0;
                        channelKt$collect$12 = channelKt$collect$1;
                        i5 = 0;
                        channelKt$collect$12.L$0 = SpillingKt.nullOutSpilledVariable(publisher);
                        channelKt$collect$12.L$1 = function1;
                        channelKt$collect$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelKt$collect$12.L$3 = receiveChannel2;
                        channelKt$collect$12.L$4 = SpillingKt.nullOutSpilledVariable(channel$default);
                        channelKt$collect$12.L$5 = it;
                        channelKt$collect$12.I$0 = i3;
                        channelKt$collect$12.I$1 = i4;
                        channelKt$collect$12.I$2 = i5;
                        channelKt$collect$12.I$3 = i2;
                        channelKt$collect$12.label = 1;
                        hasNext = it.hasNext(channelKt$collect$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i6 = channelKt$collect$1.I$3;
                        int i7 = channelKt$collect$1.I$2;
                        int i8 = channelKt$collect$1.I$1;
                        int i9 = channelKt$collect$1.I$0;
                        ChannelIterator channelIterator = (ChannelIterator) channelKt$collect$1.L$5;
                        ReceiveChannel receiveChannel4 = (ReceiveChannel) channelKt$collect$1.L$4;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) channelKt$collect$1.L$3;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelKt$collect$1.L$2;
                        Function1<? super T, Unit> function12 = (Function1) channelKt$collect$1.L$1;
                        Publisher<T> publisher2 = (Publisher) channelKt$collect$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ChannelKt$collect$1 channelKt$collect$13 = channelKt$collect$1;
                        int i10 = i6;
                        publisher = publisher2;
                        ReceiveChannel receiveChannel7 = receiveChannel6;
                        ReceiveChannel receiveChannel8 = receiveChannel4;
                        int i11 = i9;
                        int i12 = i8;
                        int i13 = i7;
                        function1 = function12;
                        ReceiveChannel receiveChannel9 = receiveChannel5;
                        ChannelIterator channelIterator2 = channelIterator;
                        Throwable th2 = null;
                        ChannelKt$collect$1 channelKt$collect$14 = channelKt$collect$13;
                        try {
                            if (!((Boolean) obj).booleanValue()) {
                                function1.invoke((Object) channelIterator2.next());
                                i2 = i10;
                                i5 = i13;
                                channelKt$collect$12 = channelKt$collect$14;
                                i4 = i12;
                                th = th2;
                                i3 = i11;
                                it = channelIterator2;
                                channel$default = receiveChannel8;
                                receiveChannel2 = receiveChannel9;
                                receiveChannel3 = receiveChannel7;
                                try {
                                    channelKt$collect$12.L$0 = SpillingKt.nullOutSpilledVariable(publisher);
                                    channelKt$collect$12.L$1 = function1;
                                    channelKt$collect$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    channelKt$collect$12.L$3 = receiveChannel2;
                                    channelKt$collect$12.L$4 = SpillingKt.nullOutSpilledVariable(channel$default);
                                    channelKt$collect$12.L$5 = it;
                                    channelKt$collect$12.I$0 = i3;
                                    channelKt$collect$12.I$1 = i4;
                                    channelKt$collect$12.I$2 = i5;
                                    channelKt$collect$12.I$3 = i2;
                                    channelKt$collect$12.label = 1;
                                    hasNext = it.hasNext(channelKt$collect$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    int i14 = i5;
                                    i10 = i2;
                                    obj = hasNext;
                                    receiveChannel7 = receiveChannel3;
                                    receiveChannel9 = receiveChannel2;
                                    receiveChannel8 = channel$default;
                                    channelIterator2 = it;
                                    i11 = i3;
                                    th2 = th;
                                    i12 = i4;
                                    channelKt$collect$14 = channelKt$collect$12;
                                    i13 = i14;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel9, th2);
                                        return Unit.INSTANCE;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    receiveChannel = receiveChannel2;
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        ChannelsKt.cancelConsumed(receiveChannel, th);
                                        throw th4;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            receiveChannel = receiveChannel9;
                            throw th;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
        channelKt$collect$1 = new ChannelKt$collect$1(continuation);
        Object obj2 = channelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelKt$collect$1.label;
    }

    private static final <T> Object collect$$forInline(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel channel$default = toChannel$default(publisher, 0, 1, null);
        try {
            ReceiveChannel receiveChannel = channel$default;
            ChannelIterator it = channel$default.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke((Object) it.next());
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(channel$default, null);
            Unit unit2 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
        }
    }

    public static /* synthetic */ ReceiveChannel toChannel$default(Publisher publisher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return toChannel(publisher, i);
    }

    public static final <T> ReceiveChannel<T> toChannel(Publisher<T> publisher, int i) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel openSubscription$default(Publisher publisher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return openSubscription(publisher, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Transforming publisher to channel is deprecated, use asFlow() instead")
    public static final /* synthetic */ ReceiveChannel openSubscription(Publisher publisher, int i) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }
}
