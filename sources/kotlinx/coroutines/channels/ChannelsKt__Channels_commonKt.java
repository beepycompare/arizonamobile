package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.selects.SelectClause1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.common.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a$\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087@¢\u0006\u0002\u0010\u0006\u001a$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\b\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0007\u001aP\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001a2\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00100\fH\u0086H¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a6\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00030\u0017*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0018\u001a\u0002H\u0016H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u001a\u0010\u001a\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "receiveOrNull", ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "consume", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "", "action", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "consumeTo", "C", "", "collection", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelConsumed", "cause", "", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        Intrinsics.checkNotNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return receiveChannel.receiveOrNull(continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel receiveChannel) {
        Intrinsics.checkNotNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return receiveChannel.getOnReceiveOrNull();
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        try {
            R invoke = function1.invoke(receiveChannel);
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ChannelsKt.cancelConsumed(receiveChannel, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a A[Catch: all -> 0x00ae, TryCatch #2 {all -> 0x00ae, blocks: (B:26:0x0092, B:28:0x009a, B:22:0x006b, B:29:0x00a6), top: B:44:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6 A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #2 {all -> 0x00ae, blocks: (B:26:0x0092, B:28:0x009a, B:22:0x006b, B:29:0x00a6), top: B:44:0x0092 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008c -> B:14:0x004d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$12;
        int i3;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, Unit> function12;
        int i4;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$1) {
                channelsKt__Channels_commonKt$consumeEach$1 = (ChannelsKt__Channels_commonKt$consumeEach$1) continuation;
                if ((channelsKt__Channels_commonKt$consumeEach$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$consumeEach$1.label -= Integer.MIN_VALUE;
                    Object obj = channelsKt__Channels_commonKt$consumeEach$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$consumeEach$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            i2 = 0;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$consumeEach$12 = channelsKt__Channels_commonKt$consumeEach$1;
                            i3 = 0;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            function12 = function1;
                            i4 = 0;
                            receiveChannel2 = receiveChannel3;
                            channelsKt__Channels_commonKt$consumeEach$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                            channelsKt__Channels_commonKt$consumeEach$12.L$1 = function12;
                            channelsKt__Channels_commonKt$consumeEach$12.L$2 = receiveChannel2;
                            channelsKt__Channels_commonKt$consumeEach$12.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            channelsKt__Channels_commonKt$consumeEach$12.L$4 = it;
                            channelsKt__Channels_commonKt$consumeEach$12.I$0 = i3;
                            channelsKt__Channels_commonKt$consumeEach$12.I$1 = i4;
                            channelsKt__Channels_commonKt$consumeEach$12.I$2 = i2;
                            channelsKt__Channels_commonKt$consumeEach$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$12);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i5 = channelsKt__Channels_commonKt$consumeEach$1.I$2;
                        int i6 = channelsKt__Channels_commonKt$consumeEach$1.I$1;
                        int i7 = channelsKt__Channels_commonKt$consumeEach$1.I$0;
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$2;
                        Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            int i8 = i7;
                            i2 = i5;
                            receiveChannel = receiveChannel6;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            channelsKt__Channels_commonKt$consumeEach$12 = channelsKt__Channels_commonKt$consumeEach$1;
                            function12 = function13;
                            Throwable th4 = null;
                            i4 = i6;
                            receiveChannel2 = receiveChannel5;
                            int i9 = i8;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function12.invoke((E) channelIterator2.next());
                                    receiveChannel3 = receiveChannel4;
                                    i3 = i9;
                                    th2 = th4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                    channelsKt__Channels_commonKt$consumeEach$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$2 = receiveChannel2;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    channelsKt__Channels_commonKt$consumeEach$12.L$4 = it;
                                    channelsKt__Channels_commonKt$consumeEach$12.I$0 = i3;
                                    channelsKt__Channels_commonKt$consumeEach$12.I$1 = i4;
                                    channelsKt__Channels_commonKt$consumeEach$12.I$2 = i2;
                                    channelsKt__Channels_commonKt$consumeEach$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i8 = i3;
                                    receiveChannel4 = receiveChannel3;
                                    obj = hasNext;
                                    channelIterator2 = it;
                                    th4 = th2;
                                    int i92 = i8;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, th4);
                                        return Unit.INSTANCE;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel5;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th7) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th7;
        }
        channelsKt__Channels_commonKt$consumeEach$1 = new ChannelsKt__Channels_commonKt$consumeEach$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$consumeEach$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEach$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9 A[Catch: all -> 0x00de, TryCatch #3 {all -> 0x00de, blocks: (B:25:0x00c1, B:27:0x00c9, B:21:0x0088, B:28:0x00d4), top: B:46:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #3 {all -> 0x00de, blocks: (B:25:0x00c1, B:27:0x00c9, B:21:0x0088, B:28:0x00d4), top: B:46:0x00c1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ba -> B:46:0x00c1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        List list;
        ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$12;
        ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$13;
        ChannelIterator<? extends E> it;
        int i2;
        int i3;
        int i4;
        int i5;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        List list2;
        Object hasNext;
        int i6;
        List list3;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toList$1) {
            channelsKt__Channels_commonKt$toList$1 = (ChannelsKt__Channels_commonKt$toList$1) continuation;
            if ((channelsKt__Channels_commonKt$toList$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toList$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$toList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$toList$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        List createListBuilder = CollectionsKt.createListBuilder();
                        list = createListBuilder;
                        channelsKt__Channels_commonKt$toList$12 = channelsKt__Channels_commonKt$toList$1;
                        channelsKt__Channels_commonKt$toList$13 = channelsKt__Channels_commonKt$toList$12;
                        it = receiveChannel.iterator();
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        th = null;
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel2 = receiveChannel4;
                        receiveChannel5 = receiveChannel2;
                        list2 = createListBuilder;
                        channelsKt__Channels_commonKt$toList$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelsKt__Channels_commonKt$toList$12.L$1 = list;
                        channelsKt__Channels_commonKt$toList$12.L$2 = list2;
                        channelsKt__Channels_commonKt$toList$12.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__Channels_commonKt$toList$12.L$4 = SpillingKt.nullOutSpilledVariable(channelsKt__Channels_commonKt$toList$13);
                        channelsKt__Channels_commonKt$toList$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$toList$12.L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        channelsKt__Channels_commonKt$toList$12.L$7 = it;
                        channelsKt__Channels_commonKt$toList$12.I$0 = i5;
                        channelsKt__Channels_commonKt$toList$12.I$1 = i4;
                        channelsKt__Channels_commonKt$toList$12.I$2 = i3;
                        channelsKt__Channels_commonKt$toList$12.I$3 = i2;
                        channelsKt__Channels_commonKt$toList$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$toList$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i7 = channelsKt__Channels_commonKt$toList$1.I$3;
                    int i8 = channelsKt__Channels_commonKt$toList$1.I$2;
                    int i9 = channelsKt__Channels_commonKt$toList$1.I$1;
                    int i10 = channelsKt__Channels_commonKt$toList$1.I$0;
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$toList$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$5;
                    ChannelsKt__Channels_commonKt$toList$1 channelsKt__Channels_commonKt$toList$14 = (ChannelsKt__Channels_commonKt$toList$1) channelsKt__Channels_commonKt$toList$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$3;
                    List list4 = (List) channelsKt__Channels_commonKt$toList$1.L$2;
                    list = (List) channelsKt__Channels_commonKt$toList$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toList$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i7;
                        receiveChannel2 = receiveChannel7;
                        i4 = i9;
                        channelsKt__Channels_commonKt$toList$13 = channelsKt__Channels_commonKt$toList$14;
                        i5 = i10;
                        i6 = i8;
                        channelsKt__Channels_commonKt$toList$12 = channelsKt__Channels_commonKt$toList$1;
                        receiveChannel4 = receiveChannel8;
                        channelIterator = channelIterator2;
                        th = null;
                        list3 = list4;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            throw th5;
                        }
                    }
                    try {
                        if (!((Boolean) obj).booleanValue()) {
                            list3.add(channelIterator.next());
                            receiveChannel3 = receiveChannel9;
                            receiveChannel5 = receiveChannel6;
                            i3 = i6;
                            it = channelIterator;
                            list2 = list3;
                            channelsKt__Channels_commonKt$toList$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            channelsKt__Channels_commonKt$toList$12.L$1 = list;
                            channelsKt__Channels_commonKt$toList$12.L$2 = list2;
                            channelsKt__Channels_commonKt$toList$12.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                            channelsKt__Channels_commonKt$toList$12.L$4 = SpillingKt.nullOutSpilledVariable(channelsKt__Channels_commonKt$toList$13);
                            channelsKt__Channels_commonKt$toList$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$toList$12.L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                            channelsKt__Channels_commonKt$toList$12.L$7 = it;
                            channelsKt__Channels_commonKt$toList$12.I$0 = i5;
                            channelsKt__Channels_commonKt$toList$12.I$1 = i4;
                            channelsKt__Channels_commonKt$toList$12.I$2 = i3;
                            channelsKt__Channels_commonKt$toList$12.I$3 = i2;
                            channelsKt__Channels_commonKt$toList$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$toList$12);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ReceiveChannel<? extends E> receiveChannel10 = receiveChannel5;
                            receiveChannel9 = receiveChannel3;
                            obj = hasNext;
                            i6 = i3;
                            receiveChannel6 = receiveChannel10;
                            channelIterator = it;
                            list3 = list2;
                            if (!((Boolean) obj).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                return CollectionsKt.build(list);
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$toList$1 = new ChannelsKt__Channels_commonKt$toList$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$toList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toList$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8 A[Catch: all -> 0x0056, TryCatch #1 {all -> 0x0056, blocks: (B:12:0x0045, B:25:0x00a0, B:27:0x00a8, B:28:0x00b4), top: B:41:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:12:0x0045, B:25:0x00a0, B:27:0x00a8, B:28:0x00b4), top: B:41:0x0045 }] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009a -> B:25:0x00a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<E>> Object consumeTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$consumeTo$1 channelsKt__Channels_commonKt$consumeTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$consumeTo$1 channelsKt__Channels_commonKt$consumeTo$12;
        int i3;
        int i4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        C c2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeTo$1) {
            channelsKt__Channels_commonKt$consumeTo$1 = (ChannelsKt__Channels_commonKt$consumeTo$1) continuation;
            if ((channelsKt__Channels_commonKt$consumeTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeTo$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$consumeTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        i2 = 0;
                        it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$consumeTo$12 = channelsKt__Channels_commonKt$consumeTo$1;
                        i3 = 0;
                        i4 = 0;
                        th2 = null;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        c2 = c;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__Channels_commonKt$consumeTo$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__Channels_commonKt$consumeTo$12.L$1 = c2;
                        channelsKt__Channels_commonKt$consumeTo$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__Channels_commonKt$consumeTo$12.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeTo$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelsKt__Channels_commonKt$consumeTo$12.L$5 = it;
                        channelsKt__Channels_commonKt$consumeTo$12.I$0 = i4;
                        channelsKt__Channels_commonKt$consumeTo$12.I$1 = i3;
                        channelsKt__Channels_commonKt$consumeTo$12.I$2 = i2;
                        channelsKt__Channels_commonKt$consumeTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeTo$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = channelsKt__Channels_commonKt$consumeTo$1.I$2;
                    int i6 = channelsKt__Channels_commonKt$consumeTo$1.I$1;
                    int i7 = channelsKt__Channels_commonKt$consumeTo$1.I$0;
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeTo$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeTo$1.L$2;
                    ?? r9 = (Collection) channelsKt__Channels_commonKt$consumeTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i5;
                        receiveChannel = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        i3 = i6;
                        receiveChannel4 = receiveChannel7;
                        int i8 = i7;
                        channelsKt__Channels_commonKt$consumeTo$12 = channelsKt__Channels_commonKt$consumeTo$1;
                        receiveChannel3 = receiveChannel5;
                        Throwable th4 = null;
                        c2 = r9;
                        if (!((Boolean) obj).booleanValue()) {
                            c2.add(channelIterator2.next());
                            receiveChannel2 = receiveChannel6;
                            i4 = i8;
                            th2 = th4;
                            it = channelIterator2;
                            try {
                                channelsKt__Channels_commonKt$consumeTo$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                channelsKt__Channels_commonKt$consumeTo$12.L$1 = c2;
                                channelsKt__Channels_commonKt$consumeTo$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__Channels_commonKt$consumeTo$12.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$consumeTo$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                channelsKt__Channels_commonKt$consumeTo$12.L$5 = it;
                                channelsKt__Channels_commonKt$consumeTo$12.I$0 = i4;
                                channelsKt__Channels_commonKt$consumeTo$12.I$1 = i3;
                                channelsKt__Channels_commonKt$consumeTo$12.I$2 = i2;
                                channelsKt__Channels_commonKt$consumeTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeTo$12);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                int i9 = i4;
                                receiveChannel6 = receiveChannel2;
                                obj = hasNext;
                                channelIterator2 = it;
                                th4 = th2;
                                i8 = i9;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel6, th4);
                                    Unit unit2 = Unit.INSTANCE;
                                    return c2;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel6;
                        throw th;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$consumeTo$1 = new ChannelsKt__Channels_commonKt$consumeTo$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$consumeTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeTo$1.label;
        if (i != 0) {
        }
    }

    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(r0);
    }

    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        try {
            ReceiveChannel<? extends E> receiveChannel2 = receiveChannel;
            ChannelIterator<? extends E> it = receiveChannel.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke((E) it.next());
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ChannelsKt.cancelConsumed(receiveChannel, th);
                throw th2;
            }
        }
    }
}
