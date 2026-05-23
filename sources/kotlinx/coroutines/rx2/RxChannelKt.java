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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
/* compiled from: RxChannel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\u0006\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0001\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0001\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0007H\u0007ø\u0001\u0000\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0003H\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\f"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/reactivex/MaybeSource;", "action", "Lkotlin/Function1;", "(Lio/reactivex/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/ObservableSource;", "(Lio/reactivex/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "kotlinx-coroutines-rx2"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0 A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:23:0x00a8, B:25:0x00b0, B:26:0x00c2), top: B:41:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00ca, blocks: (B:23:0x00a8, B:25:0x00b0, B:26:0x00c2), top: B:41:0x00a8 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009c -> B:41:0x00a8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(MaybeSource<T> maybeSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        RxChannelKt$collect$1 rxChannelKt$collect$1;
        int i;
        ReceiveChannel receiveChannel;
        ReceiveChannel channel;
        int i2;
        ChannelIterator it;
        int i3;
        int i4;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        int i5;
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
                        channel = toChannel(maybeSource);
                        i2 = 0;
                        it = channel.iterator();
                        i3 = 0;
                        i4 = 0;
                        th = null;
                        receiveChannel2 = channel;
                        receiveChannel3 = receiveChannel2;
                        i5 = 0;
                        rxChannelKt$collect$1.L$0 = SpillingKt.nullOutSpilledVariable(maybeSource);
                        rxChannelKt$collect$1.L$1 = function1;
                        rxChannelKt$collect$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        rxChannelKt$collect$1.L$3 = receiveChannel2;
                        rxChannelKt$collect$1.L$4 = SpillingKt.nullOutSpilledVariable(channel);
                        rxChannelKt$collect$1.L$5 = it;
                        rxChannelKt$collect$1.I$0 = i4;
                        rxChannelKt$collect$1.I$1 = i5;
                        rxChannelKt$collect$1.I$2 = i3;
                        rxChannelKt$collect$1.I$3 = i2;
                        rxChannelKt$collect$1.label = 1;
                        hasNext = it.hasNext(rxChannelKt$collect$1);
                        if (hasNext != coroutine_suspended) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i6 = rxChannelKt$collect$1.I$3;
                        int i7 = rxChannelKt$collect$1.I$2;
                        int i8 = rxChannelKt$collect$1.I$1;
                        int i9 = rxChannelKt$collect$1.I$0;
                        ChannelIterator channelIterator = (ChannelIterator) rxChannelKt$collect$1.L$5;
                        ReceiveChannel receiveChannel4 = (ReceiveChannel) rxChannelKt$collect$1.L$4;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) rxChannelKt$collect$1.L$3;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) rxChannelKt$collect$1.L$2;
                        Function1<? super T, Unit> function12 = (Function1) rxChannelKt$collect$1.L$1;
                        MaybeSource<T> maybeSource2 = (MaybeSource) rxChannelKt$collect$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        int i10 = i6;
                        maybeSource = maybeSource2;
                        ReceiveChannel receiveChannel7 = receiveChannel6;
                        ReceiveChannel receiveChannel8 = receiveChannel4;
                        int i11 = i9;
                        int i12 = i8;
                        RxChannelKt$collect$1 rxChannelKt$collect$12 = rxChannelKt$collect$1;
                        int i13 = i7;
                        function1 = function12;
                        ReceiveChannel receiveChannel9 = receiveChannel5;
                        ChannelIterator channelIterator2 = channelIterator;
                        Throwable th2 = null;
                        try {
                            if (!((Boolean) obj).booleanValue()) {
                                function1.invoke((Object) channelIterator2.next());
                                i3 = i13;
                                rxChannelKt$collect$1 = rxChannelKt$collect$12;
                                i2 = i10;
                                i5 = i12;
                                th = th2;
                                i4 = i11;
                                it = channelIterator2;
                                channel = receiveChannel8;
                                receiveChannel2 = receiveChannel9;
                                receiveChannel3 = receiveChannel7;
                                try {
                                    rxChannelKt$collect$1.L$0 = SpillingKt.nullOutSpilledVariable(maybeSource);
                                    rxChannelKt$collect$1.L$1 = function1;
                                    rxChannelKt$collect$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    rxChannelKt$collect$1.L$3 = receiveChannel2;
                                    rxChannelKt$collect$1.L$4 = SpillingKt.nullOutSpilledVariable(channel);
                                    rxChannelKt$collect$1.L$5 = it;
                                    rxChannelKt$collect$1.I$0 = i4;
                                    rxChannelKt$collect$1.I$1 = i5;
                                    rxChannelKt$collect$1.I$2 = i3;
                                    rxChannelKt$collect$1.I$3 = i2;
                                    rxChannelKt$collect$1.label = 1;
                                    hasNext = it.hasNext(rxChannelKt$collect$1);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    RxChannelKt$collect$1 rxChannelKt$collect$13 = rxChannelKt$collect$1;
                                    i13 = i3;
                                    obj = hasNext;
                                    receiveChannel7 = receiveChannel3;
                                    receiveChannel9 = receiveChannel2;
                                    receiveChannel8 = channel;
                                    channelIterator2 = it;
                                    i11 = i4;
                                    th2 = th;
                                    i12 = i5;
                                    i10 = i2;
                                    rxChannelKt$collect$12 = rxChannelKt$collect$13;
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
        rxChannelKt$collect$1 = new RxChannelKt$collect$1(continuation);
        Object obj2 = rxChannelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxChannelKt$collect$1.label;
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
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0 A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:23:0x00a8, B:25:0x00b0, B:26:0x00c2), top: B:41:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00ca, blocks: (B:23:0x00a8, B:25:0x00b0, B:26:0x00c2), top: B:41:0x00a8 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009c -> B:41:0x00a8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(ObservableSource<T> observableSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        RxChannelKt$collect$2 rxChannelKt$collect$2;
        int i;
        ReceiveChannel receiveChannel;
        ReceiveChannel channel;
        int i2;
        ChannelIterator it;
        int i3;
        int i4;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        int i5;
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
                        channel = toChannel(observableSource);
                        i2 = 0;
                        it = channel.iterator();
                        i3 = 0;
                        i4 = 0;
                        th = null;
                        receiveChannel2 = channel;
                        receiveChannel3 = receiveChannel2;
                        i5 = 0;
                        rxChannelKt$collect$2.L$0 = SpillingKt.nullOutSpilledVariable(observableSource);
                        rxChannelKt$collect$2.L$1 = function1;
                        rxChannelKt$collect$2.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        rxChannelKt$collect$2.L$3 = receiveChannel2;
                        rxChannelKt$collect$2.L$4 = SpillingKt.nullOutSpilledVariable(channel);
                        rxChannelKt$collect$2.L$5 = it;
                        rxChannelKt$collect$2.I$0 = i4;
                        rxChannelKt$collect$2.I$1 = i5;
                        rxChannelKt$collect$2.I$2 = i3;
                        rxChannelKt$collect$2.I$3 = i2;
                        rxChannelKt$collect$2.label = 1;
                        hasNext = it.hasNext(rxChannelKt$collect$2);
                        if (hasNext != coroutine_suspended) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i6 = rxChannelKt$collect$2.I$3;
                        int i7 = rxChannelKt$collect$2.I$2;
                        int i8 = rxChannelKt$collect$2.I$1;
                        int i9 = rxChannelKt$collect$2.I$0;
                        ChannelIterator channelIterator = (ChannelIterator) rxChannelKt$collect$2.L$5;
                        ReceiveChannel receiveChannel4 = (ReceiveChannel) rxChannelKt$collect$2.L$4;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) rxChannelKt$collect$2.L$3;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) rxChannelKt$collect$2.L$2;
                        Function1<? super T, Unit> function12 = (Function1) rxChannelKt$collect$2.L$1;
                        ObservableSource<T> observableSource2 = (ObservableSource) rxChannelKt$collect$2.L$0;
                        ResultKt.throwOnFailure(obj);
                        int i10 = i6;
                        observableSource = observableSource2;
                        ReceiveChannel receiveChannel7 = receiveChannel6;
                        ReceiveChannel receiveChannel8 = receiveChannel4;
                        int i11 = i9;
                        int i12 = i8;
                        RxChannelKt$collect$2 rxChannelKt$collect$22 = rxChannelKt$collect$2;
                        int i13 = i7;
                        function1 = function12;
                        ReceiveChannel receiveChannel9 = receiveChannel5;
                        ChannelIterator channelIterator2 = channelIterator;
                        Throwable th2 = null;
                        try {
                            if (!((Boolean) obj).booleanValue()) {
                                function1.invoke((Object) channelIterator2.next());
                                i3 = i13;
                                rxChannelKt$collect$2 = rxChannelKt$collect$22;
                                i2 = i10;
                                i5 = i12;
                                th = th2;
                                i4 = i11;
                                it = channelIterator2;
                                channel = receiveChannel8;
                                receiveChannel2 = receiveChannel9;
                                receiveChannel3 = receiveChannel7;
                                try {
                                    rxChannelKt$collect$2.L$0 = SpillingKt.nullOutSpilledVariable(observableSource);
                                    rxChannelKt$collect$2.L$1 = function1;
                                    rxChannelKt$collect$2.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    rxChannelKt$collect$2.L$3 = receiveChannel2;
                                    rxChannelKt$collect$2.L$4 = SpillingKt.nullOutSpilledVariable(channel);
                                    rxChannelKt$collect$2.L$5 = it;
                                    rxChannelKt$collect$2.I$0 = i4;
                                    rxChannelKt$collect$2.I$1 = i5;
                                    rxChannelKt$collect$2.I$2 = i3;
                                    rxChannelKt$collect$2.I$3 = i2;
                                    rxChannelKt$collect$2.label = 1;
                                    hasNext = it.hasNext(rxChannelKt$collect$2);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    RxChannelKt$collect$2 rxChannelKt$collect$23 = rxChannelKt$collect$2;
                                    i13 = i3;
                                    obj = hasNext;
                                    receiveChannel7 = receiveChannel3;
                                    receiveChannel9 = receiveChannel2;
                                    receiveChannel8 = channel;
                                    channelIterator2 = it;
                                    i11 = i4;
                                    th2 = th;
                                    i12 = i5;
                                    i10 = i2;
                                    rxChannelKt$collect$22 = rxChannelKt$collect$23;
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
        rxChannelKt$collect$2 = new RxChannelKt$collect$2(continuation);
        Object obj2 = rxChannelKt$collect$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxChannelKt$collect$2.label;
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
