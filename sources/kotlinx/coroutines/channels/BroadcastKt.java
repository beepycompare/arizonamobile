package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
/* compiled from: Broadcast.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u009b\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072-\b\u0002\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122/\b\u0001\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ReceiveChannel;", "capacity", "", TtmlNode.START, "Lkotlinx/coroutines/CoroutineStart;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BroadcastKt {
    public static /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel receiveChannel, int i, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return broadcast(receiveChannel, i, coroutineStart);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> BroadcastChannel<E> broadcast(final ReceiveChannel<? extends E> receiveChannel, int i, CoroutineStart coroutineStart) {
        return broadcast$default(CoroutineScopeKt.plus(CoroutineScopeKt.plus(GlobalScope.INSTANCE, Dispatchers.getUnconfined()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)), null, i, coroutineStart, new Function1() { // from class: kotlinx.coroutines.channels.BroadcastKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit broadcast$lambda$1;
                broadcast$lambda$1 = BroadcastKt.broadcast$lambda$1(ReceiveChannel.this, (Throwable) obj);
                return broadcast$lambda$1;
            }
        }, new BroadcastKt$broadcast$2(receiveChannel, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit broadcast$lambda$1(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt.cancelConsumed(receiveChannel, th);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        return broadcast(coroutineScope, coroutineContext, i, coroutineStart2, function1, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> BroadcastChannel<E> broadcast(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1<? super Throwable, Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        LazyBroadcastCoroutine broadcastCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        BroadcastChannel BroadcastChannel = BroadcastChannelKt.BroadcastChannel(i);
        if (coroutineStart.isLazy()) {
            broadcastCoroutine = new LazyBroadcastCoroutine(newCoroutineContext, BroadcastChannel, function2);
        } else {
            broadcastCoroutine = new BroadcastCoroutine(newCoroutineContext, BroadcastChannel, true);
        }
        if (function1 != null) {
            broadcastCoroutine.invokeOnCompletion(function1);
        }
        broadcastCoroutine.start(coroutineStart, broadcastCoroutine, function2);
        return broadcastCoroutine;
    }
}
