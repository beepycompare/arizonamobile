package kotlin;

import com.facebook.internal.NativeProtocol;
/* compiled from: UNumbers.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\n\u0010\u0004\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\f\u0010\u0004\u001a'\u0010\r\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u000e\u0010\u0004\u001a'\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0004\u001a/\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\u0017\u0010\u0014\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001b\u0010\u001a\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001c\u0010\u001a\u001a'\u0010\r\u001a\u00020\u0018*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010\u000f\u001a\u00020\u0018*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001f\u0010\u001e\u001a/\u0010\u0011\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b \u0010!\u001a/\u0010\u0016\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\"\u0010!\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b$\u0010%\u001a'\u0010\t\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b&\u0010%\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b'\u0010%\u001a'\u0010\r\u001a\u00020#*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b(\u0010)\u001a'\u0010\u000f\u001a\u00020#*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b*\u0010)\u001a/\u0010\u0011\u001a\u00020#*\u00020#2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b+\u0010,\u001a/\u0010\u0016\u001a\u00020#*\u00020#2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b-\u0010,\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b/\u00100\u001a'\u0010\t\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b1\u00100\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b2\u00100\u001a'\u0010\r\u001a\u00020.*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b3\u00104\u001a'\u0010\u000f\u001a\u00020.*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b5\u00104\u001a/\u0010\u0011\u001a\u00020.*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b6\u00107\u001a/\u0010\u0016\u001a\u00020.*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b8\u00107¨\u00069"}, d2 = {"countOneBits", "", "Lkotlin/UInt;", "countOneBits-WZ4Q5Ns", "(I)I", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.5", "Lkotlin/internal/InlineOnly;", "countLeadingZeroBits", "countLeadingZeroBits-WZ4Q5Ns", "countTrailingZeroBits", "countTrailingZeroBits-WZ4Q5Ns", "takeHighestOneBit", "takeHighestOneBit-WZ4Q5Ns", "takeLowestOneBit", "takeLowestOneBit-WZ4Q5Ns", "rotateLeft", "bitCount", "rotateLeft-V7xB4Y4", "(II)I", "1.6", "rotateRight", "rotateRight-V7xB4Y4", "Lkotlin/ULong;", "countOneBits-VKZWuLQ", "(J)I", "countLeadingZeroBits-VKZWuLQ", "countTrailingZeroBits-VKZWuLQ", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeLowestOneBit-VKZWuLQ", "rotateLeft-JSWoG40", "(JI)J", "rotateRight-JSWoG40", "Lkotlin/UByte;", "countOneBits-7apg3OU", "(B)I", "countLeadingZeroBits-7apg3OU", "countTrailingZeroBits-7apg3OU", "takeHighestOneBit-7apg3OU", "(B)B", "takeLowestOneBit-7apg3OU", "rotateLeft-LxnNnR4", "(BI)B", "rotateRight-LxnNnR4", "Lkotlin/UShort;", "countOneBits-xj2QHRw", "(S)I", "countLeadingZeroBits-xj2QHRw", "countTrailingZeroBits-xj2QHRw", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit-xj2QHRw", "rotateLeft-olVBNx4", "(SI)S", "rotateRight-olVBNx4", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UNumbersKt {
    /* renamed from: countOneBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m10178countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    /* renamed from: countLeadingZeroBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m10174countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: countTrailingZeroBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m10182countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* renamed from: takeHighestOneBit-WZ4Q5Ns  reason: not valid java name */
    private static final int m10194takeHighestOneBitWZ4Q5Ns(int i) {
        return UInt.m10021constructorimpl(Integer.highestOneBit(i));
    }

    /* renamed from: takeLowestOneBit-WZ4Q5Ns  reason: not valid java name */
    private static final int m10198takeLowestOneBitWZ4Q5Ns(int i) {
        return UInt.m10021constructorimpl(Integer.lowestOneBit(i));
    }

    /* renamed from: rotateLeft-V7xB4Y4  reason: not valid java name */
    private static final int m10186rotateLeftV7xB4Y4(int i, int i2) {
        return UInt.m10021constructorimpl(Integer.rotateLeft(i, i2));
    }

    /* renamed from: rotateRight-V7xB4Y4  reason: not valid java name */
    private static final int m10190rotateRightV7xB4Y4(int i, int i2) {
        return UInt.m10021constructorimpl(Integer.rotateRight(i, i2));
    }

    /* renamed from: countOneBits-VKZWuLQ  reason: not valid java name */
    private static final int m10177countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    /* renamed from: countLeadingZeroBits-VKZWuLQ  reason: not valid java name */
    private static final int m10173countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* renamed from: countTrailingZeroBits-VKZWuLQ  reason: not valid java name */
    private static final int m10181countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* renamed from: takeHighestOneBit-VKZWuLQ  reason: not valid java name */
    private static final long m10193takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m10100constructorimpl(Long.highestOneBit(j));
    }

    /* renamed from: takeLowestOneBit-VKZWuLQ  reason: not valid java name */
    private static final long m10197takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m10100constructorimpl(Long.lowestOneBit(j));
    }

    /* renamed from: rotateLeft-JSWoG40  reason: not valid java name */
    private static final long m10184rotateLeftJSWoG40(long j, int i) {
        return ULong.m10100constructorimpl(Long.rotateLeft(j, i));
    }

    /* renamed from: rotateRight-JSWoG40  reason: not valid java name */
    private static final long m10188rotateRightJSWoG40(long j, int i) {
        return ULong.m10100constructorimpl(Long.rotateRight(j, i));
    }

    /* renamed from: countOneBits-7apg3OU  reason: not valid java name */
    private static final int m10176countOneBits7apg3OU(byte b) {
        return Integer.bitCount(UInt.m10021constructorimpl(b & 255));
    }

    /* renamed from: countLeadingZeroBits-7apg3OU  reason: not valid java name */
    private static final int m10172countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    /* renamed from: countTrailingZeroBits-7apg3OU  reason: not valid java name */
    private static final int m10180countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    /* renamed from: takeHighestOneBit-7apg3OU  reason: not valid java name */
    private static final byte m10192takeHighestOneBit7apg3OU(byte b) {
        return UByte.m9938constructorimpl((byte) Integer.highestOneBit(b & 255));
    }

    /* renamed from: takeLowestOneBit-7apg3OU  reason: not valid java name */
    private static final byte m10196takeLowestOneBit7apg3OU(byte b) {
        return UByte.m9938constructorimpl((byte) Integer.lowestOneBit(b & 255));
    }

    /* renamed from: rotateLeft-LxnNnR4  reason: not valid java name */
    private static final byte m10185rotateLeftLxnNnR4(byte b, int i) {
        return UByte.m9938constructorimpl(NumbersKt.rotateLeft(b, i));
    }

    /* renamed from: rotateRight-LxnNnR4  reason: not valid java name */
    private static final byte m10189rotateRightLxnNnR4(byte b, int i) {
        return UByte.m9938constructorimpl(NumbersKt.rotateRight(b, i));
    }

    /* renamed from: countOneBits-xj2QHRw  reason: not valid java name */
    private static final int m10179countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m10021constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: countLeadingZeroBits-xj2QHRw  reason: not valid java name */
    private static final int m10175countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    /* renamed from: countTrailingZeroBits-xj2QHRw  reason: not valid java name */
    private static final int m10183countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    /* renamed from: takeHighestOneBit-xj2QHRw  reason: not valid java name */
    private static final short m10195takeHighestOneBitxj2QHRw(short s) {
        return UShort.m10207constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    /* renamed from: takeLowestOneBit-xj2QHRw  reason: not valid java name */
    private static final short m10199takeLowestOneBitxj2QHRw(short s) {
        return UShort.m10207constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }

    /* renamed from: rotateLeft-olVBNx4  reason: not valid java name */
    private static final short m10187rotateLeftolVBNx4(short s, int i) {
        return UShort.m10207constructorimpl(NumbersKt.rotateLeft(s, i));
    }

    /* renamed from: rotateRight-olVBNx4  reason: not valid java name */
    private static final short m10191rotateRightolVBNx4(short s, int i) {
        return UShort.m10207constructorimpl(NumbersKt.rotateRight(s, i));
    }
}
