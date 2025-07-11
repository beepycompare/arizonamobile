package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.widget.FacebookDialog;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0017J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0017\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00110\u0010X\u0082\u0004R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "subscriber", "Lorg/reactivestreams/Subscriber;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "requested", "Lkotlinx/atomicfu/AtomicLong;", "producer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlin/coroutines/Continuation;", "cancellationRequested", "", "createInitialContinuation", "flowProcessing", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeFlow", FacebookDialog.COMPLETION_GESTURE_CANCEL, "request", "n", "", "kotlinx-coroutines-reactive"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    private volatile boolean cancellationRequested;
    public final Flow<T> flow;
    private volatile /* synthetic */ Object producer$volatile;
    private volatile /* synthetic */ long requested$volatile;
    public final Subscriber<? super T> subscriber;
    private static final /* synthetic */ AtomicLongFieldUpdater requested$volatile$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater producer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer$volatile");

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.concurrent.atomic.AtomicLongFieldUpdater] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final /* synthetic */ long getAndUpdate$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater atomicLongFieldUpdater, Object obj, Function1<? super Long, Long> function1) {
        AtomicLongFieldUpdater atomicLongFieldUpdater2;
        while (true) {
            long j = atomicLongFieldUpdater2.get(obj);
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            T t = obj;
            if (atomicLongFieldUpdater3.compareAndSet(t, j, function1.invoke(Long.valueOf(j)).longValue())) {
                return j;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            obj = t;
        }
    }

    private final /* synthetic */ Object getProducer$volatile() {
        return this.producer$volatile;
    }

    private final /* synthetic */ long getRequested$volatile() {
        return this.requested$volatile;
    }

    private final /* synthetic */ void setProducer$volatile(Object obj) {
        this.producer$volatile = obj;
    }

    private final /* synthetic */ void setRequested$volatile(long j) {
        this.requested$volatile = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.flow = flow;
        this.subscriber = subscriber;
        this.producer$volatile = createInitialContinuation();
    }

    private final Continuation<Unit> createInitialContinuation() {
        final CoroutineContext coroutineContext = getCoroutineContext();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                CancellableKt.startCoroutineCancellable(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(3:9|10|11)(2:39|40))(4:41|42|43|(1:45)(1:46))|12|13|14|15))|50|6|(0)(0)|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
        kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0.getCoroutineContext(), r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flowProcessing(Continuation<? super Unit> continuation) {
        FlowSubscription$flowProcessing$1 flowSubscription$flowProcessing$1;
        int i;
        FlowSubscription<T> flowSubscription;
        if (continuation instanceof FlowSubscription$flowProcessing$1) {
            flowSubscription$flowProcessing$1 = (FlowSubscription$flowProcessing$1) continuation;
            if ((flowSubscription$flowProcessing$1.label & Integer.MIN_VALUE) != 0) {
                flowSubscription$flowProcessing$1.label -= Integer.MIN_VALUE;
                Object obj = flowSubscription$flowProcessing$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowSubscription$flowProcessing$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        flowSubscription$flowProcessing$1.L$0 = this;
                        flowSubscription$flowProcessing$1.label = 1;
                        if (consumeFlow(flowSubscription$flowProcessing$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowSubscription = this;
                    } catch (Throwable th) {
                        th = th;
                        flowSubscription = this;
                        Throwable unwrapImpl = DebugKt.getRECOVER_STACK_TRACES() ? th : StackTraceRecoveryKt.unwrapImpl(th);
                        if (flowSubscription.cancellationRequested || flowSubscription.isActive() || unwrapImpl != flowSubscription.getCancellationException()) {
                            flowSubscription.subscriber.onError(th);
                        }
                        return Unit.INSTANCE;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    flowSubscription = (FlowSubscription) flowSubscription$flowProcessing$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        if (DebugKt.getRECOVER_STACK_TRACES()) {
                        }
                        if (flowSubscription.cancellationRequested) {
                        }
                        try {
                            flowSubscription.subscriber.onError(th);
                        } catch (Throwable th3) {
                            ExceptionsKt.addSuppressed(th, th3);
                            CoroutineExceptionHandlerKt.handleCoroutineException(flowSubscription.getCoroutineContext(), th);
                        }
                        return Unit.INSTANCE;
                    }
                }
                flowSubscription.subscriber.onComplete();
                return Unit.INSTANCE;
            }
        }
        flowSubscription$flowProcessing$1 = new FlowSubscription$flowProcessing$1(this, continuation);
        Object obj2 = flowSubscription$flowProcessing$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowSubscription$flowProcessing$1.label;
        if (i != 0) {
        }
        flowSubscription.subscriber.onComplete();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new FlowCollector(this) { // from class: kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$2
            final /* synthetic */ FlowSubscription<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
                this.this$0.subscriber.onNext(t);
                atomicLongFieldUpdater = FlowSubscription.requested$volatile$FU;
                if (atomicLongFieldUpdater.decrementAndGet(this.this$0) <= 0) {
                    FlowSubscription<T> flowSubscription = this.this$0;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                    cancellableContinuationImpl.initCancellability();
                    atomicReferenceFieldUpdater = FlowSubscription.producer$volatile$FU;
                    atomicReferenceFieldUpdater.set(flowSubscription, cancellableContinuationImpl);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                JobKt.ensureActive(this.this$0.getCoroutineContext());
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        long j2;
        long j3;
        Continuation continuation;
        if (j <= 0) {
            return;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = requested$volatile$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            j3 = j2 + j;
            if (j3 <= 0) {
                j3 = Long.MAX_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j3));
        if (j2 <= 0) {
            do {
                continuation = (Continuation) producer$volatile$FU.getAndSet(this, null);
            } while (continuation == null);
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m8471constructorimpl(Unit.INSTANCE));
        }
    }
}
