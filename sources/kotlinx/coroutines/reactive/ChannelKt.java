package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;
/* compiled from: Channel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0001\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Publisher;", "action", "Lkotlin/Function1;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "request", "", "openSubscription", "kotlinx-coroutines-reactive"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:26:0x0067, B:28:0x006f, B:29:0x0079), top: B:42:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:26:0x0067, B:28:0x006f, B:29:0x0079), top: B:42:0x0067 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0063 -> B:14:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelKt$collect$1 channelKt$collect$1;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
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
                        ReceiveChannel channel$default = toChannel$default(publisher, 0, 1, null);
                        try {
                            receiveChannel2 = channel$default;
                            it = channel$default.iterator();
                            channelKt$collect$1.L$0 = function1;
                            channelKt$collect$1.L$1 = receiveChannel2;
                            channelKt$collect$1.L$2 = it;
                            channelKt$collect$1.label = 1;
                            hasNext = it.hasNext(channelKt$collect$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th2) {
                            receiveChannel = channel$default;
                            th = th2;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        it = (ChannelIterator) channelKt$collect$1.L$2;
                        receiveChannel = (ReceiveChannel) channelKt$collect$1.L$1;
                        Function1<? super T, Unit> function12 = (Function1) channelKt$collect$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelKt$collect$1 channelKt$collect$12 = channelKt$collect$1;
                            ReceiveChannel receiveChannel3 = receiveChannel;
                            function1 = function12;
                            ChannelKt$collect$1 channelKt$collect$13 = channelKt$collect$12;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function1.invoke((Object) it.next());
                                    receiveChannel2 = receiveChannel3;
                                    channelKt$collect$1 = channelKt$collect$13;
                                    try {
                                        channelKt$collect$1.L$0 = function1;
                                        channelKt$collect$1.L$1 = receiveChannel2;
                                        channelKt$collect$1.L$2 = it;
                                        channelKt$collect$1.label = 1;
                                        hasNext = it.hasNext(channelKt$collect$1);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        channelKt$collect$12 = channelKt$collect$1;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        ChannelKt$collect$1 channelKt$collect$132 = channelKt$collect$12;
                                        if (!((Boolean) obj).booleanValue()) {
                                            Unit unit = Unit.INSTANCE;
                                            ChannelsKt.cancelConsumed(receiveChannel3, null);
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        receiveChannel = receiveChannel2;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                receiveChannel = receiveChannel3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th6) {
            ChannelsKt.cancelConsumed(receiveChannel, th);
            throw th6;
        }
        channelKt$collect$1 = new ChannelKt$collect$1(continuation);
        Object obj2 = channelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelKt$collect$1.label;
        if (i != 0) {
        }
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
