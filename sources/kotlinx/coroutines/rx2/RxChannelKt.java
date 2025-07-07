package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
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
/* compiled from: RxChannel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\u0006\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0001\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0001\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0007H\u0007ø\u0001\u0000\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0003H\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\f"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/reactivex/MaybeSource;", "action", "Lkotlin/Function1;", "(Lio/reactivex/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "kotlinx-coroutines-rx2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:42:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:42:0x0066 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(MaybeSource<T> maybeSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        RxChannelKt$collect$1 rxChannelKt$collect$1;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        Object hasNext;
        try {
            if (continuation instanceof RxChannelKt$collect$1) {
                rxChannelKt$collect$1 = (RxChannelKt$collect$1) continuation;
                if ((rxChannelKt$collect$1.label & Integer.MIN_VALUE) != 0) {
                    rxChannelKt$collect$1.label -= Integer.MIN_VALUE;
                    Object obj = rxChannelKt$collect$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = rxChannelKt$collect$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel channel = toChannel(maybeSource);
                        try {
                            receiveChannel2 = channel;
                            it = channel.iterator();
                            rxChannelKt$collect$1.L$0 = function1;
                            rxChannelKt$collect$1.L$1 = receiveChannel2;
                            rxChannelKt$collect$1.L$2 = it;
                            rxChannelKt$collect$1.label = 1;
                            hasNext = it.hasNext(rxChannelKt$collect$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th2) {
                            receiveChannel = channel;
                            th = th2;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        it = (ChannelIterator) rxChannelKt$collect$1.L$2;
                        receiveChannel = (ReceiveChannel) rxChannelKt$collect$1.L$1;
                        Function1<? super T, Unit> function12 = (Function1) rxChannelKt$collect$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            RxChannelKt$collect$1 rxChannelKt$collect$12 = rxChannelKt$collect$1;
                            ReceiveChannel receiveChannel3 = receiveChannel;
                            function1 = function12;
                            RxChannelKt$collect$1 rxChannelKt$collect$13 = rxChannelKt$collect$12;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function1.invoke((Object) it.next());
                                    receiveChannel2 = receiveChannel3;
                                    rxChannelKt$collect$1 = rxChannelKt$collect$13;
                                    try {
                                        rxChannelKt$collect$1.L$0 = function1;
                                        rxChannelKt$collect$1.L$1 = receiveChannel2;
                                        rxChannelKt$collect$1.L$2 = it;
                                        rxChannelKt$collect$1.label = 1;
                                        hasNext = it.hasNext(rxChannelKt$collect$1);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        rxChannelKt$collect$12 = rxChannelKt$collect$1;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        RxChannelKt$collect$1 rxChannelKt$collect$132 = rxChannelKt$collect$12;
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
        rxChannelKt$collect$1 = new RxChannelKt$collect$1(continuation);
        Object obj2 = rxChannelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxChannelKt$collect$1.label;
        if (i != 0) {
        }
    }

    private static final <T> Object collect$$forInline(MaybeSource<T> maybeSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel channel = toChannel(maybeSource);
        try {
            ReceiveChannel receiveChannel = channel;
            ChannelIterator it = channel.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke((Object) it.next());
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(channel, null);
            Unit unit2 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:42:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:42:0x0066 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(ObservableSource<T> observableSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        RxChannelKt$collect$2 rxChannelKt$collect$2;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        Object hasNext;
        try {
            if (continuation instanceof RxChannelKt$collect$2) {
                rxChannelKt$collect$2 = (RxChannelKt$collect$2) continuation;
                if ((rxChannelKt$collect$2.label & Integer.MIN_VALUE) != 0) {
                    rxChannelKt$collect$2.label -= Integer.MIN_VALUE;
                    Object obj = rxChannelKt$collect$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = rxChannelKt$collect$2.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel channel = toChannel(observableSource);
                        try {
                            receiveChannel2 = channel;
                            it = channel.iterator();
                            rxChannelKt$collect$2.L$0 = function1;
                            rxChannelKt$collect$2.L$1 = receiveChannel2;
                            rxChannelKt$collect$2.L$2 = it;
                            rxChannelKt$collect$2.label = 1;
                            hasNext = it.hasNext(rxChannelKt$collect$2);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th2) {
                            receiveChannel = channel;
                            th = th2;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        it = (ChannelIterator) rxChannelKt$collect$2.L$2;
                        receiveChannel = (ReceiveChannel) rxChannelKt$collect$2.L$1;
                        Function1<? super T, Unit> function12 = (Function1) rxChannelKt$collect$2.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            RxChannelKt$collect$2 rxChannelKt$collect$22 = rxChannelKt$collect$2;
                            ReceiveChannel receiveChannel3 = receiveChannel;
                            function1 = function12;
                            RxChannelKt$collect$2 rxChannelKt$collect$23 = rxChannelKt$collect$22;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function1.invoke((Object) it.next());
                                    receiveChannel2 = receiveChannel3;
                                    rxChannelKt$collect$2 = rxChannelKt$collect$23;
                                    try {
                                        rxChannelKt$collect$2.L$0 = function1;
                                        rxChannelKt$collect$2.L$1 = receiveChannel2;
                                        rxChannelKt$collect$2.L$2 = it;
                                        rxChannelKt$collect$2.label = 1;
                                        hasNext = it.hasNext(rxChannelKt$collect$2);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        rxChannelKt$collect$22 = rxChannelKt$collect$2;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        RxChannelKt$collect$2 rxChannelKt$collect$232 = rxChannelKt$collect$22;
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
        rxChannelKt$collect$2 = new RxChannelKt$collect$2(continuation);
        Object obj2 = rxChannelKt$collect$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxChannelKt$collect$2.label;
        if (i != 0) {
        }
    }

    private static final <T> Object collect$$forInline(ObservableSource<T> observableSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel channel = toChannel(observableSource);
        try {
            ReceiveChannel receiveChannel = channel;
            ChannelIterator it = channel.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke((Object) it.next());
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(channel, null);
            Unit unit2 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
        }
    }

    public static final <T> ReceiveChannel<T> toChannel(MaybeSource<T> maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static final <T> ReceiveChannel<T> toChannel(ObservableSource<T> observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of Flow")
    public static final /* synthetic */ ReceiveChannel openSubscription(ObservableSource observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of Flow")
    public static final /* synthetic */ ReceiveChannel openSubscription(MaybeSource maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }
}
