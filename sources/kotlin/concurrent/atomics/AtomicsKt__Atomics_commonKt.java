package kotlin.concurrent.atomics;

import com.facebook.internal.NativeProtocol;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Atomics.common.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0005\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0005\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a%\u0010\r\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a%\u0010\u000e\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a%\u0010\u000f\u001a\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\f\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0011H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0012\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0011H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0012\u001a%\u0010\u000b\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013\u001a%\u0010\r\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013\u001a%\u0010\u000e\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013\u001a%\u0010\u000f\u001a\u00020\u0011*\u00020\u0010H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\t¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"plusAssign", "", "Lkotlin/concurrent/atomics/AtomicInt;", "delta", "", "(Ljava/util/concurrent/atomic/AtomicInteger;I)V", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.1", "Lkotlin/concurrent/atomics/ExperimentalAtomicApi;", "minusAssign", "fetchAndIncrement", "(Ljava/util/concurrent/atomic/AtomicInteger;)I", "incrementAndFetch", "decrementAndFetch", "fetchAndDecrement", "Lkotlin/concurrent/atomics/AtomicLong;", "", "(Ljava/util/concurrent/atomic/AtomicLong;J)V", "(Ljava/util/concurrent/atomic/AtomicLong;)J", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/concurrent/atomics/AtomicsKt")
/* loaded from: classes5.dex */
class AtomicsKt__Atomics_commonKt {
    public static final void plusAssign(AtomicInteger atomicInteger, int i) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        atomicInteger.addAndGet(i);
    }

    public static final void minusAssign(AtomicInteger atomicInteger, int i) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        atomicInteger.addAndGet(-i);
    }

    public static final int fetchAndIncrement(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        return atomicInteger.getAndAdd(1);
    }

    public static final int incrementAndFetch(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        return atomicInteger.addAndGet(1);
    }

    public static final int decrementAndFetch(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        return atomicInteger.addAndGet(-1);
    }

    public static final int fetchAndDecrement(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        return atomicInteger.getAndAdd(-1);
    }

    public static final void plusAssign(AtomicLong atomicLong, long j) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        atomicLong.addAndGet(j);
    }

    public static final void minusAssign(AtomicLong atomicLong, long j) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        atomicLong.addAndGet(-j);
    }

    public static final long fetchAndIncrement(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        return atomicLong.getAndAdd(1L);
    }

    public static final long incrementAndFetch(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        return atomicLong.addAndGet(1L);
    }

    public static final long decrementAndFetch(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        return atomicLong.addAndGet(-1L);
    }

    public static final long fetchAndDecrement(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        return atomicLong.getAndAdd(-1L);
    }
}
