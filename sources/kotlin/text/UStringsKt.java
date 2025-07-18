package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UStrings.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0019\u0010\u0013\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0019\u0010\u0016\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0011\u0010\u0019\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u0019\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001e\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toUByteOrNull", "toUShortOrNull", "toUIntOrNull", "toULongOrNull", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UStringsKt {
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m9810toStringLxnNnR4(byte b, int i) {
        String num = Integer.toString(b & 255, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m9812toStringolVBNx4(short s, int i) {
        String num = Integer.toString(s & UShort.MAX_VALUE, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m9811toStringV7xB4Y4(int i, int i2) {
        return UnsignedKt.ulongToString(i & 4294967295L, CharsKt.checkRadix(i2));
    }

    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m9809toStringJSWoG40(long j, int i) {
        return UnsignedKt.ulongToString(j, CharsKt.checkRadix(i));
    }

    public static final byte toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.m8539unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final byte toUByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str, i);
        if (uByteOrNull != null) {
            return uByteOrNull.m8539unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.m8807unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str, i);
        if (uShortOrNull != null) {
            return uShortOrNull.m8807unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.m8623unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.m8623unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.m8702unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str, i);
        if (uLongOrNull != null) {
            return uLongOrNull.m8702unboximpl();
        }
        StringsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    public static final UByte toUByteOrNull(String str, int i) {
        int compare;
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            int m8623unboximpl = uIntOrNull.m8623unboximpl();
            compare = Integer.compare(m8623unboximpl ^ Integer.MIN_VALUE, UInt.m8571constructorimpl(255) ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return null;
            }
            return UByte.m8483boximpl(UByte.m8489constructorimpl((byte) m8623unboximpl));
        }
        return null;
    }

    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    public static final UShort toUShortOrNull(String str, int i) {
        int compare;
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            int m8623unboximpl = uIntOrNull.m8623unboximpl();
            compare = Integer.compare(m8623unboximpl ^ Integer.MIN_VALUE, UInt.m8571constructorimpl(65535) ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return null;
            }
            return UShort.m8751boximpl(UShort.m8757constructorimpl((short) m8623unboximpl));
        }
        return null;
    }

    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str, int i) {
        int i2;
        int compare;
        int compare2;
        int compare3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int m8571constructorimpl = UInt.m8571constructorimpl(i);
        int i4 = 119304647;
        while (i2 < length) {
            int digitOf = CharsKt.digitOf(str.charAt(i2), i);
            if (digitOf < 0) {
                return null;
            }
            compare = Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (i4 == 119304647) {
                    i4 = UByte$$ExternalSyntheticBackport0.m(-1, m8571constructorimpl);
                    compare3 = Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            int m8571constructorimpl2 = UInt.m8571constructorimpl(i3 * m8571constructorimpl);
            int m8571constructorimpl3 = UInt.m8571constructorimpl(UInt.m8571constructorimpl(digitOf) + m8571constructorimpl2);
            compare2 = Integer.compare(m8571constructorimpl3 ^ Integer.MIN_VALUE, m8571constructorimpl2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i2++;
            i3 = m8571constructorimpl3;
        }
        return UInt.m8565boximpl(i3);
    }

    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toULongOrNull(str, 10);
    }

    public static final ULong toULongOrNull(String str, int i) {
        int digitOf;
        int compare;
        int compare2;
        int compare3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long m8650constructorimpl = ULong.m8650constructorimpl(i);
        long j = 0;
        long j2 = 512409557603043100L;
        while (i2 < length) {
            if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                return null;
            }
            compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            if (compare > 0) {
                if (j2 == 512409557603043100L) {
                    j2 = UByte$$ExternalSyntheticBackport0.m$1(-1L, m8650constructorimpl);
                    compare3 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            long m8650constructorimpl2 = ULong.m8650constructorimpl(j * m8650constructorimpl);
            long m8650constructorimpl3 = ULong.m8650constructorimpl(ULong.m8650constructorimpl(UInt.m8571constructorimpl(digitOf) & 4294967295L) + m8650constructorimpl2);
            compare2 = Long.compare(m8650constructorimpl3 ^ Long.MIN_VALUE, m8650constructorimpl2 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i2++;
            j = m8650constructorimpl3;
        }
        return ULong.m8644boximpl(j);
    }
}
