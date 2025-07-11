package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.C0791SegmentedByteString;
import okio.Segment;
/* compiled from: SegmentedByteString.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a]\u0010\t\u001a\u00020\n*\u00020\u00072K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0080\bø\u0001\u0000\u001aj\u0010\t\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0082\b\u001a\u001d\u0010\u0015\u001a\u00020\u0016*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u001a\r\u0010\u001a\u001a\u00020\r*\u00020\u0007H\u0080\b\u001a%\u0010\u001b\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\"\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010%\u001a\u00020\u001f*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010&H\u0080\b\u001a\r\u0010'\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "segment", "Lokio/SegmentedByteString;", "pos", "forEachSegment", "", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "beginIndex", "endIndex", "commonSubstring", "Lokio/ByteString;", "commonInternalGet", "", "commonGetSize", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "commonRangeEquals", "", "other", "otherOffset", "commonCopyInto", TypedValues.AttributesType.S_TARGET, "targetOffset", "commonEquals", "", "commonHashCode", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: okio.internal.-SegmentedByteString  reason: invalid class name */
/* loaded from: classes5.dex */
public final class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else if (i6 <= i) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int segment(C0791SegmentedByteString c0791SegmentedByteString, int i) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        int binarySearch = binarySearch(c0791SegmentedByteString.getDirectory$okio(), i + 1, 0, c0791SegmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public static final void forEachSegment(C0791SegmentedByteString c0791SegmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = c0791SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = c0791SegmentedByteString.getDirectory$okio()[length + i];
            int i4 = c0791SegmentedByteString.getDirectory$okio()[i];
            action.invoke(c0791SegmentedByteString.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    private static final void forEachSegment(C0791SegmentedByteString c0791SegmentedByteString, int i, int i2, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int segment = segment(c0791SegmentedByteString, i);
        while (i < i2) {
            int i3 = segment == 0 ? 0 : c0791SegmentedByteString.getDirectory$okio()[segment - 1];
            int i4 = c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i2, (c0791SegmentedByteString.getDirectory$okio()[segment] - i3) + i3) - i;
            function3.invoke(c0791SegmentedByteString.getSegments$okio()[segment], Integer.valueOf(i4 + (i - i3)), Integer.valueOf(min));
            i += min;
            segment++;
        }
    }

    public static final ByteString commonSubstring(C0791SegmentedByteString c0791SegmentedByteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        C0791SegmentedByteString c0791SegmentedByteString2 = c0791SegmentedByteString;
        int resolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c0791SegmentedByteString2, i2);
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (resolveDefaultParameter <= c0791SegmentedByteString.size()) {
            int i3 = resolveDefaultParameter - i;
            if (i3 < 0) {
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i).toString());
            }
            if (i == 0 && resolveDefaultParameter == c0791SegmentedByteString.size()) {
                return c0791SegmentedByteString2;
            }
            if (i == resolveDefaultParameter) {
                return ByteString.EMPTY;
            }
            int segment = segment(c0791SegmentedByteString, i);
            int segment2 = segment(c0791SegmentedByteString, resolveDefaultParameter - 1);
            byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(c0791SegmentedByteString.getSegments$okio(), segment, segment2 + 1);
            byte[][] bArr2 = bArr;
            int[] iArr = new int[bArr2.length * 2];
            if (segment <= segment2) {
                int i4 = segment;
                int i5 = 0;
                while (true) {
                    iArr[i5] = Math.min(c0791SegmentedByteString.getDirectory$okio()[i4] - i, i3);
                    int i6 = i5 + 1;
                    iArr[i5 + bArr2.length] = c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + i4];
                    if (i4 == segment2) {
                        break;
                    }
                    i4++;
                    i5 = i6;
                }
            }
            int i7 = segment != 0 ? c0791SegmentedByteString.getDirectory$okio()[segment - 1] : 0;
            int length = bArr2.length;
            iArr[length] = iArr[length] + (i - i7);
            return new C0791SegmentedByteString(bArr, iArr);
        }
        throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + c0791SegmentedByteString.size() + ')').toString());
    }

    public static final byte commonInternalGet(C0791SegmentedByteString c0791SegmentedByteString, int i) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length - 1], i, 1L);
        int segment = segment(c0791SegmentedByteString, i);
        return c0791SegmentedByteString.getSegments$okio()[segment][(i - (segment == 0 ? 0 : c0791SegmentedByteString.getDirectory$okio()[segment - 1])) + c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + segment]];
    }

    public static final int commonGetSize(C0791SegmentedByteString c0791SegmentedByteString) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        return c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length - 1];
    }

    public static final byte[] commonToByteArray(C0791SegmentedByteString c0791SegmentedByteString) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        byte[] bArr = new byte[c0791SegmentedByteString.size()];
        int length = c0791SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = c0791SegmentedByteString.getDirectory$okio()[length + i];
            int i5 = c0791SegmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(c0791SegmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final boolean commonRangeEquals(C0791SegmentedByteString c0791SegmentedByteString, int i, ByteString other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > c0791SegmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(c0791SegmentedByteString, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : c0791SegmentedByteString.getDirectory$okio()[segment - 1];
            int i6 = c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, (c0791SegmentedByteString.getDirectory$okio()[segment] - i5) + i5) - i;
            if (!other.rangeEquals(i2, c0791SegmentedByteString.getSegments$okio()[segment], i6 + (i - i5), min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    public static final boolean commonRangeEquals(C0791SegmentedByteString c0791SegmentedByteString, int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > c0791SegmentedByteString.size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(c0791SegmentedByteString, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : c0791SegmentedByteString.getDirectory$okio()[segment - 1];
            int i6 = c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, (c0791SegmentedByteString.getDirectory$okio()[segment] - i5) + i5) - i;
            if (!okio.SegmentedByteString.arrayRangeEquals(c0791SegmentedByteString.getSegments$okio()[segment], i6 + (i - i5), other, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    public static final void commonCopyInto(C0791SegmentedByteString c0791SegmentedByteString, int i, byte[] target, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        long j = i3;
        okio.SegmentedByteString.checkOffsetAndCount(c0791SegmentedByteString.size(), i, j);
        okio.SegmentedByteString.checkOffsetAndCount(target.length, i2, j);
        int i4 = i3 + i;
        int segment = segment(c0791SegmentedByteString, i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : c0791SegmentedByteString.getDirectory$okio()[segment - 1];
            int i6 = c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, (c0791SegmentedByteString.getDirectory$okio()[segment] - i5) + i5) - i;
            int i7 = i6 + (i - i5);
            ArraysKt.copyInto(c0791SegmentedByteString.getSegments$okio()[segment], target, i2, i7, i7 + min);
            i2 += min;
            i += min;
            segment++;
        }
    }

    public static final boolean commonEquals(C0791SegmentedByteString c0791SegmentedByteString, Object obj) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        if (obj == c0791SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c0791SegmentedByteString.size() && c0791SegmentedByteString.rangeEquals(0, byteString, 0, c0791SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonHashCode(C0791SegmentedByteString c0791SegmentedByteString) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        int hashCode$okio = c0791SegmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = c0791SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = c0791SegmentedByteString.getDirectory$okio()[length + i];
            int i5 = c0791SegmentedByteString.getDirectory$okio()[i];
            byte[] bArr = c0791SegmentedByteString.getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        c0791SegmentedByteString.setHashCode$okio(i2);
        return i2;
    }

    public static final void commonWrite(C0791SegmentedByteString c0791SegmentedByteString, Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(c0791SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i3 = i + i2;
        int segment = segment(c0791SegmentedByteString, i);
        while (i < i3) {
            int i4 = segment == 0 ? 0 : c0791SegmentedByteString.getDirectory$okio()[segment - 1];
            int i5 = c0791SegmentedByteString.getDirectory$okio()[c0791SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i3, (c0791SegmentedByteString.getDirectory$okio()[segment] - i4) + i4) - i;
            int i6 = i5 + (i - i4);
            Segment segment2 = new Segment(c0791SegmentedByteString.getSegments$okio()[segment], i6, i6 + min, true, false);
            if (buffer.head == null) {
                segment2.prev = segment2;
                segment2.next = segment2.prev;
                buffer.head = segment2.next;
            } else {
                Segment segment3 = buffer.head;
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i2);
    }
}
