package kotlin.collections;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: _UCollections.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0011\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u001b\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes5.dex */
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] m9917constructorimpl = UByteArray.m9917constructorimpl(collection.size());
        int i = 0;
        for (UByte uByte : collection) {
            UByteArray.m9928setVurrAj0(m9917constructorimpl, i, uByte.m9910unboximpl());
            i++;
        }
        return m9917constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] m9996constructorimpl = UIntArray.m9996constructorimpl(collection.size());
        int i = 0;
        for (UInt uInt : collection) {
            UIntArray.m10007setVXSXFK8(m9996constructorimpl, i, uInt.m9994unboximpl());
            i++;
        }
        return m9996constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m10075constructorimpl = ULongArray.m10075constructorimpl(collection.size());
        int i = 0;
        for (ULong uLong : collection) {
            ULongArray.m10086setk8EXiF4(m10075constructorimpl, i, uLong.m10073unboximpl());
            i++;
        }
        return m10075constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] m10180constructorimpl = UShortArray.m10180constructorimpl(collection.size());
        int i = 0;
        for (UShort uShort : collection) {
            UShortArray.m10191set01HTLdE(m10180constructorimpl, i, uShort.m10178unboximpl());
            i++;
        }
        return m10180constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (UInt uInt : iterable) {
            i = UInt.m9942constructorimpl(i + uInt.m9994unboximpl());
        }
        return i;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        long j = 0;
        for (ULong uLong : iterable) {
            j = ULong.m10021constructorimpl(j + uLong.m10073unboximpl());
        }
        return j;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (UByte uByte : iterable) {
            i = UInt.m9942constructorimpl(i + UInt.m9942constructorimpl(uByte.m9910unboximpl() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (UShort uShort : iterable) {
            i = UInt.m9942constructorimpl(i + UInt.m9942constructorimpl(uShort.m10178unboximpl() & UShort.MAX_VALUE));
        }
        return i;
    }
}
