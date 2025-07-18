package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
/* compiled from: Semaphore.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001a\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eH\u0005Jb\u0010\u001a\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u001d\u001a\u0002H\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00190!2!\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160!H\u0083\b¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00162\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0004J\b\u0010*\u001a\u00020\u0003H\u0002J\u0006\u0010+\u001a\u00020\u0016J\b\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002J\f\u00100\u001a\u00020\u0019*\u00020\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004R\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000bX\u0082\u0004R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "", "permits", "", "acquiredPermits", "<init>", "(II)V", TtmlNode.TAG_HEAD, "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "tail", "enqIdx", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "onCancellationRelease", "Lkotlin/Function3;", "", "", "Lkotlin/coroutines/CoroutineContext;", "tryAcquire", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "waiter", "Lkotlinx/coroutines/CancellableContinuation;", ExifInterface.LONGITUDE_WEST, "suspend", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "decPermits", "release", "coerceAvailablePermitsAtMaximum", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SemaphoreAndMutexImpl {
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private final Function3<Throwable, Unit, CoroutineContext, Unit> onCancellationRelease;
    private final int permits;
    private volatile /* synthetic */ Object tail$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");

    private final /* synthetic */ long getDeqIdx$volatile() {
        return this.deqIdx$volatile;
    }

    private final /* synthetic */ long getEnqIdx$volatile() {
        return this.enqIdx$volatile;
    }

    private final /* synthetic */ Object getHead$volatile() {
        return this.head$volatile;
    }

    private final /* synthetic */ Object getTail$volatile() {
        return this.tail$volatile;
    }

    private final /* synthetic */ int get_availablePermits$volatile() {
        return this._availablePermits$volatile;
    }

    private final /* synthetic */ void setDeqIdx$volatile(long j) {
        this.deqIdx$volatile = j;
    }

    private final /* synthetic */ void setEnqIdx$volatile(long j) {
        this.enqIdx$volatile = j;
    }

    private final /* synthetic */ void setHead$volatile(Object obj) {
        this.head$volatile = obj;
    }

    private final /* synthetic */ void setTail$volatile(Object obj) {
        this.tail$volatile = obj;
    }

    private final /* synthetic */ void set_availablePermits$volatile(int i) {
        this._availablePermits$volatile = i;
    }

    public SemaphoreAndMutexImpl(int i, int i2) {
        this.permits = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
        }
        if (i2 < 0 || i2 > i) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = i - i2;
        this.onCancellationRelease = new Function3() { // from class: kotlinx.coroutines.sync.SemaphoreAndMutexImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit onCancellationRelease$lambda$2;
                onCancellationRelease$lambda$2 = SemaphoreAndMutexImpl.onCancellationRelease$lambda$2(SemaphoreAndMutexImpl.this, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
                return onCancellationRelease$lambda$2;
            }
        };
    }

    public final int getAvailablePermits() {
        return Math.max(_availablePermits$volatile$FU.get(this), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCancellationRelease$lambda$2(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Throwable th, Unit unit, CoroutineContext coroutineContext) {
        semaphoreAndMutexImpl.release();
        return Unit.INSTANCE;
    }

    public final boolean tryAcquire() {
        while (true) {
            int i = _availablePermits$volatile$FU.get(this);
            if (i > this.permits) {
                coerceAvailablePermitsAtMaximum();
            } else if (i <= 0) {
                return false;
            } else {
                if (_availablePermits$volatile$FU.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }

    public final Object acquire(Continuation<? super Unit> continuation) {
        if (decPermits() > 0) {
            return Unit.INSTANCE;
        }
        Object acquireSlowPath = acquireSlowPath(continuation);
        return acquireSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? acquireSlowPath : Unit.INSTANCE;
    }

    private final <W> void acquire(W w, Function1<? super W, Boolean> function1, Function1<? super W, Unit> function12) {
        while (decPermits() <= 0) {
            if (function1.invoke(w).booleanValue()) {
                return;
            }
        }
        function12.invoke(w);
    }

    private final int decPermits() {
        int andDecrement;
        do {
            andDecrement = _availablePermits$volatile$FU.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    public final void release() {
        do {
            int andIncrement = _availablePermits$volatile$FU.getAndIncrement(this);
            if (andIncrement >= this.permits) {
                coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            } else if (andIncrement >= 0) {
                return;
            }
        } while (!tryResumeNextFromQueue());
    }

    private final void coerceAvailablePermitsAtMaximum() {
        int i;
        do {
            i = _availablePermits$volatile$FU.get(this);
            if (i <= this.permits) {
                return;
            }
        } while (!_availablePermits$volatile$FU.compareAndSet(this, i, this.permits));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addAcquireToQueue(Waiter waiter) {
        int i;
        Object findSegmentInternal;
        int i2;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) tail$volatile$FU.get(this);
        long andIncrement = enqIdx$volatile$FU.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$volatile$FU;
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.m10058isClosedimpl(findSegmentInternal)) {
                Segment m10056getSegmentimpl = SegmentOrClosed.m10056getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m10056getSegmentimpl.id) {
                        break loop0;
                    } else if (!m10056getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, m10056getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m10056getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m10056getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m10056getSegmentimpl(findSegmentInternal);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i3 = (int) (andIncrement % i2);
        if (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), i3, null, waiter)) {
            symbol = SemaphoreKt.PERMIT;
            symbol2 = SemaphoreKt.TAKEN;
            if (Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), i3, symbol, symbol2)) {
                if (waiter instanceof CancellableContinuation) {
                    Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((CancellableContinuation) waiter).resume((CancellableContinuation) Unit.INSTANCE, (Function3<? super Throwable, ? super CancellableContinuation, ? super CoroutineContext, Unit>) this.onCancellationRelease);
                } else if (waiter instanceof SelectInstance) {
                    ((SelectInstance) waiter).selectInRegistrationPhase(Unit.INSTANCE);
                } else {
                    throw new IllegalStateException(("unexpected: " + waiter).toString());
                }
                return true;
            } else if (DebugKt.getASSERTIONS_ENABLED()) {
                Object obj = semaphoreSegment2.getAcquirers().get(i3);
                symbol3 = SemaphoreKt.BROKEN;
                if (obj == symbol3) {
                    return false;
                }
                throw new AssertionError();
            } else {
                return false;
            }
        }
        waiter.invokeOnCancellation(semaphoreSegment2, i3);
        return true;
    }

    private final boolean tryResumeNextFromQueue() {
        int i;
        Object findSegmentInternal;
        int i2;
        Symbol symbol;
        Symbol symbol2;
        int i3;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) head$volatile$FU.get(this);
        long andIncrement = deqIdx$volatile$FU.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$volatile$FU;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.m10058isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m10056getSegmentimpl = SegmentOrClosed.m10056getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.id >= m10056getSegmentimpl.id) {
                    break loop0;
                } else if (!m10056getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, m10056getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (m10056getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m10056getSegmentimpl.remove();
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m10056getSegmentimpl(findSegmentInternal);
        semaphoreSegment2.cleanPrev();
        if (semaphoreSegment2.id > j) {
            return false;
        }
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i4 = (int) (andIncrement % i2);
        symbol = SemaphoreKt.PERMIT;
        Object andSet = semaphoreSegment2.getAcquirers().getAndSet(i4, symbol);
        if (andSet == null) {
            i3 = SemaphoreKt.MAX_SPIN_CYCLES;
            for (int i5 = 0; i5 < i3; i5++) {
                Object obj = semaphoreSegment2.getAcquirers().get(i4);
                symbol5 = SemaphoreKt.TAKEN;
                if (obj == symbol5) {
                    return true;
                }
            }
            symbol3 = SemaphoreKt.PERMIT;
            symbol4 = SemaphoreKt.BROKEN;
            return !Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), i4, symbol3, symbol4);
        }
        symbol2 = SemaphoreKt.CANCELLED;
        if (andSet == symbol2) {
            return false;
        }
        return tryResumeAcquire(andSet);
    }

    private final boolean tryResumeAcquire(Object obj) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
            if (tryResume != null) {
                cancellableContinuation.completeResume(tryResume);
                return true;
            }
            return false;
        } else if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, Unit.INSTANCE);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                acquire((CancellableContinuation<? super Unit>) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void acquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.resume((CancellableContinuation<? super Unit>) Unit.INSTANCE, this.onCancellationRelease);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onAcquireRegFunction(SelectInstance<?> selectInstance, Object obj) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) selectInstance)) {
                return;
            }
        }
        selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
    }
}
