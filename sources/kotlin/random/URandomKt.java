package kotlin.random;

import com.facebook.internal.NativeProtocol;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
/* compiled from: URandom.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0012\u001a+\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0015\u0010\u0016\u001a)\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0017H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0018\u001a3\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0087\u0080\bb\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001fb\u0002\b ¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001f¢\u0006\u0002\u0010#\u001aG\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0087\u0080\bb\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001fb\u0002\b ¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0004\b*\u0010+\u001a!\u0010,\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0011H\u0080\u0080\u0004¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"nextUInt", "Lkotlin/UInt;", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)I", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.5", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lkotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/IgnorableReturnValue;", "size", "", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class URandomKt {
    public static final int nextUInt(Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.m10017constructorimpl(random.nextInt());
    }

    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m11177nextUIntqCasIEU(Random nextUInt, int i) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m11176nextUInta8DCA5k(nextUInt, 0, i);
    }

    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m11176nextUInta8DCA5k(Random nextUInt, int i, int i2) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m11171checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m10017constructorimpl(nextUInt.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    public static final int nextUInt(Random random, UIntRange range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        compare = Integer.compare(range.m11181getLastpVg5ArA() ^ Integer.MIN_VALUE, (-1) ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return m11176nextUInta8DCA5k(random, range.m11180getFirstpVg5ArA(), UInt.m10017constructorimpl(range.m11181getLastpVg5ArA() + 1));
        }
        compare2 = Integer.compare(range.m11180getFirstpVg5ArA() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare2 > 0 ? UInt.m10017constructorimpl(m11176nextUInta8DCA5k(random, UInt.m10017constructorimpl(range.m11180getFirstpVg5ArA() - 1), range.m11181getLastpVg5ArA()) + 1) : nextUInt(random);
    }

    public static final long nextULong(Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return ULong.m10096constructorimpl(random.nextLong());
    }

    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m11178nextULongV1Xi4fY(Random nextULong, long j) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m11179nextULongjmpaWc(nextULong, 0L, j);
    }

    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m11179nextULongjmpaWc(Random nextULong, long j, long j2) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m11172checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m10096constructorimpl(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    public static final long nextULong(Random random, ULongRange range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        compare = Long.compare(range.m11190getLastsVKNKU() ^ Long.MIN_VALUE, (-1) ^ Long.MIN_VALUE);
        if (compare < 0) {
            return m11179nextULongjmpaWc(random, range.m11189getFirstsVKNKU(), ULong.m10096constructorimpl(range.m11190getLastsVKNKU() + ULong.m10096constructorimpl(1L)));
        }
        compare2 = Long.compare(range.m11189getFirstsVKNKU() ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        return compare2 > 0 ? ULong.m10096constructorimpl(m11179nextULongjmpaWc(random, ULong.m10096constructorimpl(range.m11189getFirstsVKNKU() - ULong.m10096constructorimpl(1L)), range.m11190getLastsVKNKU()) + ULong.m10096constructorimpl(1L)) : nextULong(random);
    }

    @IgnorableReturnValue
    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m11173nextUBytesEVgfTAA(Random nextUBytes, byte[] array) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    public static final byte[] nextUBytes(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UByteArray.m9993constructorimpl(random.nextBytes(i));
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m11175nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m9999getSizeimpl(bArr);
        }
        return m11174nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    @IgnorableReturnValue
    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m11174nextUBytesWvrt4B4(Random nextUBytes, byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i, i2);
        return array;
    }

    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m11171checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m10011boximpl(i), UInt.m10011boximpl(i2)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m11172checkULongRangeBoundseb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        if (compare <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m10090boximpl(j), ULong.m10090boximpl(j2)).toString());
        }
    }
}
