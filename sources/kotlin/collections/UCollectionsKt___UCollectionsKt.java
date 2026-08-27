package kotlin.collections;

import com.facebook.internal.NativeProtocol;
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
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0004\u001a+\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\f\u001a+\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0017b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001cb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001d\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001eb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001e\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001fb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "Lkotlin/jvm/JvmName;", "name", "1.5", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes5.dex */
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] m9995constructorimpl = UByteArray.m9995constructorimpl(collection.size());
        int i = 0;
        for (UByte uByte : collection) {
            UByteArray.m10006setVurrAj0(m9995constructorimpl, i, uByte.m9987unboximpl());
            i++;
        }
        return m9995constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] m10074constructorimpl = UIntArray.m10074constructorimpl(collection.size());
        int i = 0;
        for (UInt uInt : collection) {
            UIntArray.m10085setVXSXFK8(m10074constructorimpl, i, uInt.m10072unboximpl());
            i++;
        }
        return m10074constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m10153constructorimpl = ULongArray.m10153constructorimpl(collection.size());
        int i = 0;
        for (ULong uLong : collection) {
            ULongArray.m10164setk8EXiF4(m10153constructorimpl, i, uLong.m10151unboximpl());
            i++;
        }
        return m10153constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] m10258constructorimpl = UShortArray.m10258constructorimpl(collection.size());
        int i = 0;
        for (UShort uShort : collection) {
            UShortArray.m10269set01HTLdE(m10258constructorimpl, i, uShort.m10256unboximpl());
            i++;
        }
        return m10258constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (UInt uInt : iterable) {
            i = UInt.m10020constructorimpl(i + uInt.m10072unboximpl());
        }
        return i;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        long j = 0;
        for (ULong uLong : iterable) {
            j = ULong.m10099constructorimpl(j + uLong.m10151unboximpl());
        }
        return j;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (UByte uByte : iterable) {
            i = UInt.m10020constructorimpl(i + UInt.m10020constructorimpl(uByte.m9987unboximpl() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int i = 0;
        for (UShort uShort : iterable) {
            i = UInt.m10020constructorimpl(i + UInt.m10020constructorimpl(uShort.m10256unboximpl() & UShort.MAX_VALUE));
        }
        return i;
    }
}
