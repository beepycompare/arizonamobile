package kotlin.random;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
/* compiled from: Random.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\b\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a$\u0010\u000b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u0012\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0016\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0018H\u0080\u0080\u0004¨\u0006\u0019"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "fastLog2", "value", "takeUpperBits", "bitCount", "checkRangeBounds", "", "from", "until", "", "boundsErrorMessage", "", "", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RandomKt {
    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final Random Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final int nextInt(Random random, IntRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        return range.getLast() < Integer.MAX_VALUE ? random.nextInt(range.getFirst(), range.getLast() + 1) : range.getFirst() > Integer.MIN_VALUE ? random.nextInt(range.getFirst() - 1, range.getLast()) + 1 : random.nextInt();
    }

    public static final long nextLong(Random random, LongRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        return range.getLast() < Long.MAX_VALUE ? random.nextLong(range.getFirst(), range.getLast() + 1) : range.getFirst() > Long.MIN_VALUE ? random.nextLong(range.getFirst() - 1, range.getLast()) + 1 : random.nextLong();
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d, double d2) {
        if (d2 <= d) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }
}
