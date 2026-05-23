package kotlinx.coroutines.stream;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Stream.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0096@¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "stream", "Ljava/util/stream/Stream;", "<init>", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StreamFlow<T> implements Flow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile;
    private final Stream<T> stream;

    private final /* synthetic */ int getConsumed$volatile() {
        return this.consumed$volatile;
    }

    private final /* synthetic */ void setConsumed$volatile(int i) {
        this.consumed$volatile = i;
    }

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:12:0x0030, B:19:0x0054, B:21:0x005a, B:18:0x004b), top: B:31:0x0022 }] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        StreamFlow$collect$1 streamFlow$collect$1;
        int i;
        FlowCollector<? super T> flowCollector2;
        Iterator<T> it;
        try {
            if (continuation instanceof StreamFlow$collect$1) {
                streamFlow$collect$1 = (StreamFlow$collect$1) continuation;
                if ((streamFlow$collect$1.label & Integer.MIN_VALUE) != 0) {
                    streamFlow$collect$1.label -= Integer.MIN_VALUE;
                    Object obj = streamFlow$collect$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = streamFlow$collect$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!consumed$volatile$FU.compareAndSet(this, 0, 1)) {
                            throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
                        }
                        flowCollector2 = flowCollector;
                        it = this.stream.iterator();
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = streamFlow$collect$1.L$2;
                        it = (Iterator) streamFlow$collect$1.L$1;
                        FlowCollector<? super T> flowCollector3 = (FlowCollector) streamFlow$collect$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowCollector2 = flowCollector3;
                    }
                    while (it.hasNext()) {
                        Object obj3 = (T) it.next();
                        streamFlow$collect$1.L$0 = flowCollector2;
                        streamFlow$collect$1.L$1 = it;
                        streamFlow$collect$1.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        streamFlow$collect$1.label = 1;
                        if (flowCollector2.emit(obj3, streamFlow$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.stream.close();
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            while (it.hasNext()) {
            }
            this.stream.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.stream.close();
            throw th;
        }
        streamFlow$collect$1 = new StreamFlow$collect$1(this, continuation);
        Object obj4 = streamFlow$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = streamFlow$collect$1.label;
    }
}
