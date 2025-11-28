package kotlin.collections;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UArraySorting.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", TtmlNode.LEFT, TtmlNode.RIGHT, "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m10366partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m9982getw2LRezQ = UByteArray.m9982getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m9982getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m9982getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m9982getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m9982getw2LRezQ2 = UByteArray.m9982getw2LRezQ(bArr, i);
                UByteArray.m9987setVurrAj0(bArr, i, UByteArray.m9982getw2LRezQ(bArr, i2));
                UByteArray.m9987setVurrAj0(bArr, i2, m9982getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m10370quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m10366partition4UcCI2c = m10366partition4UcCI2c(bArr, i, i2);
        int i3 = m10366partition4UcCI2c - 1;
        if (i < i3) {
            m10370quickSort4UcCI2c(bArr, i, i3);
        }
        if (m10366partition4UcCI2c < i2) {
            m10370quickSort4UcCI2c(bArr, m10366partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m10367partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m10245getMh2AYeg = UShortArray.m10245getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m10245getMh2AYeg2 = UShortArray.m10245getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m10245getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m10245getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m10245getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m10245getMh2AYeg3 = UShortArray.m10245getMh2AYeg(sArr, i);
                UShortArray.m10250set01HTLdE(sArr, i, UShortArray.m10245getMh2AYeg(sArr, i2));
                UShortArray.m10250set01HTLdE(sArr, i2, m10245getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m10371quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m10367partitionAa5vz7o = m10367partitionAa5vz7o(sArr, i, i2);
        int i3 = m10367partitionAa5vz7o - 1;
        if (i < i3) {
            m10371quickSortAa5vz7o(sArr, i, i3);
        }
        if (m10367partitionAa5vz7o < i2) {
            m10371quickSortAa5vz7o(sArr, m10367partitionAa5vz7o, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m10368partitionoBK06Vg(int[] iArr, int i, int i2) {
        int compare;
        int compare2;
        int m10061getpVg5ArA = UIntArray.m10061getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (compare < 0) {
                i++;
            }
            while (compare2 > 0) {
                i2--;
            }
            if (i <= i2) {
                int m10061getpVg5ArA2 = UIntArray.m10061getpVg5ArA(iArr, i);
                UIntArray.m10066setVXSXFK8(iArr, i, UIntArray.m10061getpVg5ArA(iArr, i2));
                UIntArray.m10066setVXSXFK8(iArr, i2, m10061getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m10372quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m10368partitionoBK06Vg = m10368partitionoBK06Vg(iArr, i, i2);
        int i3 = m10368partitionoBK06Vg - 1;
        if (i < i3) {
            m10372quickSortoBK06Vg(iArr, i, i3);
        }
        if (m10368partitionoBK06Vg < i2) {
            m10372quickSortoBK06Vg(iArr, m10368partitionoBK06Vg, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* renamed from: partition--nroSd4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m10365partitionnroSd4(long[] jArr, int i, int i2) {
        int compare;
        int compare2;
        long m10140getsVKNKU = ULongArray.m10140getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (compare < 0) {
                i++;
            }
            while (compare2 > 0) {
                i2--;
            }
            if (i <= i2) {
                long m10140getsVKNKU2 = ULongArray.m10140getsVKNKU(jArr, i);
                ULongArray.m10145setk8EXiF4(jArr, i, ULongArray.m10140getsVKNKU(jArr, i2));
                ULongArray.m10145setk8EXiF4(jArr, i2, m10140getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m10369quickSortnroSd4(long[] jArr, int i, int i2) {
        int m10365partitionnroSd4 = m10365partitionnroSd4(jArr, i, i2);
        int i3 = m10365partitionnroSd4 - 1;
        if (i < i3) {
            m10369quickSortnroSd4(jArr, i, i3);
        }
        if (m10365partitionnroSd4 < i2) {
            m10369quickSortnroSd4(jArr, m10365partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m10374sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-array$0");
        m10370quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m10375sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-array$0");
        m10371quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m10376sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-array$0");
        m10372quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m10373sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-array$0");
        m10369quickSortnroSd4(jArr, i, i2 - 1);
    }
}
