package kotlin.concurrent.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.measurement.zzah$$ExternalSyntheticBackportWithForwarding0;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AtomicIntrinsics.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a0\u0010\u0000\u001a\u00020\t*\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a0\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u0003\u001a\u0002H\r2\u0006\u0010\u0004\u001a\u0002H\rH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u000f\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a8\u0010\u0000\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001aI\u0010\u0000\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00132\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\r2\u0006\u0010\u0004\u001a\u0002H\rH\u0081\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"compareAndExchange", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "expected", "newValue", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.1", "Lkotlin/PublishedApi;", "", "Ljava/util/concurrent/atomic/AtomicLong;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/atomic/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", FirebaseAnalytics.Param.INDEX, "Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AtomicIntrinsicsKt {
    public static final int compareAndExchange(AtomicInteger atomicInteger, int i, int i2) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        do {
            int i3 = atomicInteger.get();
            if (i != i3) {
                return i3;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static final long compareAndExchange(AtomicLong atomicLong, long j, long j2) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        do {
            long j3 = atomicLong.get();
            if (j != j3) {
                return j3;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        return j;
    }

    public static final boolean compareAndExchange(AtomicBoolean atomicBoolean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        do {
            boolean z3 = atomicBoolean.get();
            if (z != z3) {
                return z3;
            }
        } while (!atomicBoolean.compareAndSet(z, z2));
        return z;
    }

    public static final <T> T compareAndExchange(AtomicReference<T> atomicReference, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        do {
            T t3 = atomicReference.get();
            if (t != t3) {
                return t3;
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, t, t2));
        return t;
    }

    public static final int compareAndExchange(AtomicIntegerArray atomicIntegerArray, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        do {
            int i4 = atomicIntegerArray.get(i);
            if (i2 != i4) {
                return i4;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i2, i3));
        return i2;
    }

    public static final long compareAndExchange(AtomicLongArray atomicLongArray, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        do {
            long j3 = atomicLongArray.get(i);
            if (j != j3) {
                return j3;
            }
        } while (!atomicLongArray.compareAndSet(i, j, j2));
        return j;
    }

    public static final <T> T compareAndExchange(AtomicReferenceArray<T> atomicReferenceArray, int i, T t, T t2) {
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        do {
            T t3 = atomicReferenceArray.get(i);
            if (t != t3) {
                return t3;
            }
        } while (!zzah$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, t, t2));
        return t;
    }
}
