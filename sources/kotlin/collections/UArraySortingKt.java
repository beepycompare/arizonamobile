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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u000b\u0010\f\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u001f\u0010\f\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b \u0010\u0011\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b!\u0010\u0016\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\"\u0010\u001b¨\u0006#"}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", TtmlNode.LEFT, TtmlNode.RIGHT, "partition-4UcCI2c", "([BII)I", "Lkotlin/ExperimentalUnsignedTypes;", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m10361partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m9978getw2LRezQ = UByteArray.m9978getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m9978getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m9978getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m9978getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m9978getw2LRezQ2 = UByteArray.m9978getw2LRezQ(bArr, i);
                UByteArray.m9983setVurrAj0(bArr, i, UByteArray.m9978getw2LRezQ(bArr, i2));
                UByteArray.m9983setVurrAj0(bArr, i2, m9978getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m10365quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m10361partition4UcCI2c = m10361partition4UcCI2c(bArr, i, i2);
        int i3 = m10361partition4UcCI2c - 1;
        if (i < i3) {
            m10365quickSort4UcCI2c(bArr, i, i3);
        }
        if (m10361partition4UcCI2c < i2) {
            m10365quickSort4UcCI2c(bArr, m10361partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m10362partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m10241getMh2AYeg = UShortArray.m10241getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m10241getMh2AYeg2 = UShortArray.m10241getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m10241getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m10241getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m10241getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m10241getMh2AYeg3 = UShortArray.m10241getMh2AYeg(sArr, i);
                UShortArray.m10246set01HTLdE(sArr, i, UShortArray.m10241getMh2AYeg(sArr, i2));
                UShortArray.m10246set01HTLdE(sArr, i2, m10241getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m10366quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m10362partitionAa5vz7o = m10362partitionAa5vz7o(sArr, i, i2);
        int i3 = m10362partitionAa5vz7o - 1;
        if (i < i3) {
            m10366quickSortAa5vz7o(sArr, i, i3);
        }
        if (m10362partitionAa5vz7o < i2) {
            m10366quickSortAa5vz7o(sArr, m10362partitionAa5vz7o, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m10363partitionoBK06Vg(int[] iArr, int i, int i2) {
        int compare;
        int compare2;
        int m10057getpVg5ArA = UIntArray.m10057getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (compare < 0) {
                i++;
            }
            while (compare2 > 0) {
                i2--;
            }
            if (i <= i2) {
                int m10057getpVg5ArA2 = UIntArray.m10057getpVg5ArA(iArr, i);
                UIntArray.m10062setVXSXFK8(iArr, i, UIntArray.m10057getpVg5ArA(iArr, i2));
                UIntArray.m10062setVXSXFK8(iArr, i2, m10057getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m10367quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m10363partitionoBK06Vg = m10363partitionoBK06Vg(iArr, i, i2);
        int i3 = m10363partitionoBK06Vg - 1;
        if (i < i3) {
            m10367quickSortoBK06Vg(iArr, i, i3);
        }
        if (m10363partitionoBK06Vg < i2) {
            m10367quickSortoBK06Vg(iArr, m10363partitionoBK06Vg, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* renamed from: partition--nroSd4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m10360partitionnroSd4(long[] jArr, int i, int i2) {
        int compare;
        int compare2;
        long m10136getsVKNKU = ULongArray.m10136getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (compare < 0) {
                i++;
            }
            while (compare2 > 0) {
                i2--;
            }
            if (i <= i2) {
                long m10136getsVKNKU2 = ULongArray.m10136getsVKNKU(jArr, i);
                ULongArray.m10141setk8EXiF4(jArr, i, ULongArray.m10136getsVKNKU(jArr, i2));
                ULongArray.m10141setk8EXiF4(jArr, i2, m10136getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m10364quickSortnroSd4(long[] jArr, int i, int i2) {
        int m10360partitionnroSd4 = m10360partitionnroSd4(jArr, i, i2);
        int i3 = m10360partitionnroSd4 - 1;
        if (i < i3) {
            m10364quickSortnroSd4(jArr, i, i3);
        }
        if (m10360partitionnroSd4 < i2) {
            m10364quickSortnroSd4(jArr, m10360partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m10369sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10365quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m10370sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10366quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m10371sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10367quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m10368sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10364quickSortnroSd4(array, i, i2 - 1);
    }
}
