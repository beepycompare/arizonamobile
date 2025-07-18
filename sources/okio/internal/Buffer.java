package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.base.Ascii;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okio.Buffer;
import okio.ByteString;
import okio.C0791SegmentedByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
/* compiled from: Buffer.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a?\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u001a\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u00140\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0007H\u0000\u001a%\u0010\u001d\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\r\u0010!\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0010H\u0080\b\u001a\r\u0010$\u001a\u00020%*\u00020\u0010H\u0080\b\u001a\r\u0010&\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a\r\u0010'\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\u0015\u0010(\u001a\u00020#*\u00020\u00102\u0006\u0010)\u001a\u00020\u0012H\u0080\b\u001a\r\u0010*\u001a\u00020+*\u00020\u0010H\u0080\b\u001a\u0015\u0010,\u001a\u00020+*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a)\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0012H\u0002\u001a\u0015\u00105\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u0015\u00106\u001a\u00020\t*\u00020\u00102\u0006\u00107\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020\u0001H\u0080\b\u001a%\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\r\u00109\u001a\u00020\u0001*\u00020\u0010H\u0080\b\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0005*\u00020\u00102\u0006\u0010;\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010<\u001a\u00020+*\u00020\u00102\u0006\u0010;\u001a\u00020\u0001H\u0080\b\u001a%\u0010:\u001a\u00020\u0005*\u00020\u00102\u0006\u0010;\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\r\u0010?\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010@\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010A\u001a\u00020/*\u00020\u0010H\u0080\b\u001a\u0015\u0010A\u001a\u00020/*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010B\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0080\b\u001a\u001d\u0010<\u001a\u00020+*\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010C\u001a\u00020\u0012*\u00020\u00102\u0006\u0010;\u001a\u00020DH\u0080\b\u001a\u0015\u0010E\u001a\u00020\u000f*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u000f\u0010F\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u000f*\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0080\b\u001a\r\u0010I\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a%\u0010J\u001a\u00020\u0010*\u00020\u00102\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010N\u001a\u00020\u0010*\u00020\u00102\u0006\u0010O\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010P\u001a\u00020\u0012*\u00020\u00102\u0006\u00108\u001a\u00020QH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020Q2\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010R\u001a\u00020\u0010*\u00020\u00102\u0006\u0010S\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010T\u001a\u00020\u0010*\u00020\u00102\u0006\u0010U\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0010*\u00020\u00102\u0006\u0010W\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010X\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010-\u001a\u00020+*\u00020\u00102\u0006\u00108\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0012*\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a%\u0010Y\u001a\u00020\u0012*\u00020\u00102\u0006\u0010S\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0080\b\u001a:\u0010Y\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u000b\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010Z\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005H\u0000\u001a\u001d\u0010[\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\\\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u0012H\u0080\b\u001a-\u0010]\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0017\u0010^\u001a\u00020\u0007*\u00020\u00102\b\u0010_\u001a\u0004\u0018\u00010`H\u0080\b\u001a\r\u0010a\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a\r\u0010b\u001a\u00020\u0010*\u00020\u0010H\u0080\b\u001a\r\u0010c\u001a\u00020/*\u00020\u0010H\u0080\b\u001a\u0015\u0010c\u001a\u00020/*\u00020\u00102\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0014\u0010d\u001a\u00020e*\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0000\u001a\u0014\u0010g\u001a\u00020e*\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0000\u001a\r\u0010h\u001a\u00020\u0005*\u00020eH\u0080\b\u001a\u0015\u0010i\u001a\u00020\u0005*\u00020e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010j\u001a\u00020\u0012*\u00020e2\u0006\u0010k\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010l\u001a\u00020\u0012*\u00020e2\u0006\u0010m\u001a\u00020\u0005H\u0080\b\u001a\r\u0010n\u001a\u00020+*\u00020eH\u0080\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006o"}, d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES", "()[B", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "readUtf8Line", "", "Lokio/Buffer;", "newline", "", "seek", ExifInterface.GPS_DIRECTION_TRUE, "fromIndex", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "options", "Lokio/Options;", "selectTruncated", "commonCopyTo", "out", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "commonCompleteSegmentByteCount", "commonReadByte", "", "commonReadShort", "", "commonReadInt", "commonReadLong", "commonGet", "pos", "commonClear", "", "commonSkip", "commonWrite", "byteString", "Lokio/ByteString;", "commonWriteDecimalLong", "v", "countDigitsIn", "DigitCountToLargestValue", "", "commonWriteHexadecimalUnsignedLong", "commonWritableSegment", "minimumCapacity", "source", "commonReadByteArray", "commonRead", "sink", "commonReadFully", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "commonSelect", "commonReadAll", "Lokio/Sink;", "commonReadUtf8", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonWriteUtf8", TypedValues.Custom.S_STRING, "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "commonWriteAll", "Lokio/Source;", "commonWriteByte", "b", "commonWriteShort", CmcdData.STREAMING_FORMAT_SS, "commonWriteInt", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "commonWriteLong", "commonIndexOf", "toIndex", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonEquals", "other", "", "commonHashCode", "commonCopy", "commonSnapshot", "commonReadUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "commonReadAndWriteUnsafe", "commonNext", "commonSeek", "commonResizeBuffer", "newSize", "commonExpandBuffer", "minByteCount", "commonClose", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: okio.internal.-Buffer */
/* loaded from: classes5.dex */
public final class Buffer {
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    private static final long[] DigitCountToLargestValue = {-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bytes, int i2, int i3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != bytes[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == 13) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(okio.Buffer buffer, long j, Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= segment.limit - segment.pos;
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 <= j) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            } else {
                return lambda.invoke(segment, Long.valueOf(j2));
            }
        }
    }

    public static /* synthetic */ int selectPrefix$default(okio.Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int selectPrefix(okio.Buffer buffer, Options options, boolean z) {
        int i;
        int i2;
        Segment segment;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i5 = segment2.pos;
        int i6 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = trie$okio[i8];
            int i11 = i8 + 2;
            int i12 = trie$okio[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (segment3 == null) {
                break;
            } else if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & 255;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == trie$okio[i11]) {
                        i2 = trie$okio[i11 + i10];
                        if (i == i6) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            i = segment3.pos;
                            bArr = segment3.data;
                            i6 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                        if (i2 >= 0) {
                            return i2;
                        }
                        i8 = -i2;
                        i5 = i;
                    } else {
                        i11++;
                    }
                }
                break loop0;
            } else {
                int i15 = i11 + (i10 * (-1));
                while (true) {
                    int i16 = i5 + 1;
                    int i17 = i11 + 1;
                    if ((bArr[i5] & 255) != trie$okio[i11]) {
                        break loop0;
                    }
                    boolean z2 = i17 == i15;
                    if (i16 == i6) {
                        Intrinsics.checkNotNull(segment3);
                        Segment segment4 = segment3.next;
                        Intrinsics.checkNotNull(segment4);
                        i4 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i3 = segment4.limit;
                        if (segment4 != segment2) {
                            segment = segment4;
                            bArr = bArr2;
                        } else if (!z2) {
                            break loop0;
                        } else {
                            bArr = bArr2;
                            segment = null;
                        }
                    } else {
                        segment = segment3;
                        i3 = i6;
                        i4 = i16;
                    }
                    if (z2) {
                        i2 = trie$okio[i17];
                        i = i4;
                        i6 = i3;
                        segment3 = segment;
                        break;
                    }
                    i5 = i4;
                    i6 = i3;
                    segment3 = segment;
                    i11 = i17;
                }
            }
        }
        if (z) {
            return -2;
        }
        return i7;
    }

    public static final okio.Buffer commonCopyTo(okio.Buffer buffer, okio.Buffer out, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        long j3 = j;
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j3, j2);
        if (j2 != 0) {
            out.setSize$okio(out.size() + j2);
            Segment segment = buffer.head;
            while (true) {
                Intrinsics.checkNotNull(segment);
                if (j3 < segment.limit - segment.pos) {
                    break;
                }
                j3 -= segment.limit - segment.pos;
                segment = segment.next;
            }
            Segment segment2 = segment;
            long j4 = j2;
            while (j4 > 0) {
                Intrinsics.checkNotNull(segment2);
                Segment sharedCopy = segment2.sharedCopy();
                sharedCopy.pos += (int) j3;
                sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j4), sharedCopy.limit);
                if (out.head == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy.prev;
                    out.head = sharedCopy.next;
                } else {
                    Segment segment3 = out.head;
                    Intrinsics.checkNotNull(segment3);
                    Segment segment4 = segment3.prev;
                    Intrinsics.checkNotNull(segment4);
                    segment4.push(sharedCopy);
                }
                j4 -= sharedCopy.limit - sharedCopy.pos;
                segment2 = segment2.next;
                j3 = 0;
            }
        }
        return buffer;
    }

    public static final long commonCompleteSegmentByteCount(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (segment2.limit - segment2.pos);
    }

    public static final byte commonReadByte(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        buffer.setSize$okio(buffer.size() - 1);
        if (i3 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
            return b;
        }
        segment.pos = i3;
        return b;
    }

    public static final short commonReadShort(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() < 2) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = (bArr[i3] & 255) | ((bArr[i] & 255) << 8);
        buffer.setSize$okio(buffer.size() - 2);
        if (i4 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    public static final int commonReadInt(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() < 4) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i3 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i4 = i + 3;
        int i5 = i + 4;
        int i6 = (bArr[i4] & 255) | i3 | ((bArr[i + 2] & 255) << 8);
        buffer.setSize$okio(buffer.size() - 4);
        if (i5 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
            return i6;
        }
        segment.pos = i5;
        return i6;
    }

    public static final long commonReadLong(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() < 8) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((buffer.readInt() & 4294967295L) << 32) | (4294967295L & buffer.readInt());
        }
        byte[] bArr = segment.data;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40);
        int i3 = i + 7;
        int i4 = i + 8;
        long j2 = j | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8) | (bArr[i3] & 255);
        buffer.setSize$okio(buffer.size() - 8);
        if (i4 == i2) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
            return j2;
        }
        segment.pos = i4;
        return j2;
    }

    public static final byte commonGet(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.checkNotNull(null);
            byte[] bArr = segment2.data;
            throw null;
        } else if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= segment.limit - segment.pos;
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((segment.pos + j) - size)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = (segment.limit - segment.pos) + j2;
                if (j3 > j) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((segment.pos + j) - j2)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
        }
    }

    public static final void commonClear(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonSkip(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = min;
            buffer.setSize$okio(buffer.size() - j2);
            j -= j2;
            segment.pos += min;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public static /* synthetic */ okio.Buffer commonWrite$default(okio.Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final okio.Buffer commonWriteDecimalLong(okio.Buffer buffer, long j) {
        boolean z;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i != 0) {
            if (i < 0) {
                j = -j;
                if (j < 0) {
                    return buffer.writeUtf8("-9223372036854775808");
                }
                z = true;
            } else {
                z = false;
            }
            int countDigitsIn = countDigitsIn(j);
            if (z) {
                countDigitsIn++;
            }
            Segment writableSegment$okio = buffer.writableSegment$okio(countDigitsIn);
            byte[] bArr = writableSegment$okio.data;
            int i2 = writableSegment$okio.limit + countDigitsIn;
            while (j != 0) {
                long j2 = 10;
                i2--;
                bArr[i2] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
                j /= j2;
            }
            if (z) {
                bArr[i2 - 1] = 45;
            }
            writableSegment$okio.limit += countDigitsIn;
            buffer.setSize$okio(buffer.size() + countDigitsIn);
            return buffer;
        }
        return buffer.writeByte(48);
    }

    public static final int countDigitsIn(long j) {
        int numberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        return numberOfLeadingZeros + (j > DigitCountToLargestValue[numberOfLeadingZeros] ? 1 : 0);
    }

    public static final okio.Buffer commonWriteHexadecimalUnsignedLong(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + i);
        return buffer;
    }

    public static final Segment commonWritableSegment(okio.Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        if (buffer.head == null) {
            Segment take = SegmentPool.take();
            buffer.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, byte[] source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return buffer.write(source, 0, source.length);
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt.copyInto(source, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final byte[] commonReadByteArray(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    public static final byte[] commonReadByteArray(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        buffer.readFully(bArr);
        return bArr;
    }

    public static final int commonRead(okio.Buffer buffer, byte[] sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        return buffer.read(sink, 0, sink.length);
    }

    public static final void commonReadFully(okio.Buffer buffer, byte[] sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int read = buffer.read(sink, i, sink.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    public static final int commonRead(okio.Buffer buffer, byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.copyInto(segment.data, sink, i, segment.pos, segment.pos + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00a5, code lost:
        r19.setSize$okio(r19.size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ae, code lost:
        if (r2 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00b0, code lost:
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00b2, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00b3, code lost:
        if (r1 >= r14) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00bb, code lost:
        if (r19.size() == r17) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00bd, code lost:
        if (r2 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00bf, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00c2, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00ea, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.toHexString(r19.getByte(r17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00f0, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00f1, code lost:
        if (r2 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x00f3, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00f5, code lost:
        return -r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadDecimalLong(okio.Buffer buffer) {
        long j;
        byte b;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long j2 = 0;
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        int i = 0;
        boolean z = false;
        long j3 = 0;
        long j4 = -7;
        boolean z2 = false;
        loop0: while (true) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            while (i2 < i3) {
                b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    int i5 = (j3 > OVERFLOW_ZONE ? 1 : (j3 == OVERFLOW_ZONE ? 0 : -1));
                    if (i5 < 0) {
                        break loop0;
                    }
                    j = j2;
                    if (i5 == 0 && i4 < j4) {
                        break loop0;
                    }
                    j3 = (j3 * 10) + i4;
                } else {
                    j = j2;
                    if (b != 45 || i != 0) {
                        z2 = true;
                        break;
                    }
                    j4--;
                    z = true;
                }
                i2++;
                i++;
                j2 = j;
            }
            j = j2;
            if (i2 == i3) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i2;
            }
            if (z2 || buffer.head == null) {
                break;
            }
            j2 = j;
        }
        okio.Buffer writeByte = new okio.Buffer().writeDecimalLong(j3).writeByte((int) b);
        if (!z) {
            writeByte.readByte();
        }
        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a8 A[EDGE_INSN: B:90:0x00a8->B:85:0x00a8 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadHexadecimalUnsignedLong(okio.Buffer buffer) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            byte[] bArr = segment.data;
            int i3 = segment.pos;
            int i4 = segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else if (b >= 65 && b <= 70) {
                    i = b - 55;
                } else if (i2 == 0) {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + SegmentedByteString.toHexString(b));
                } else {
                    z = true;
                    if (i3 != i4) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i3;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new okio.Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z) {
            }
        } while (buffer.head != null);
        buffer.setSize$okio(buffer.size() - i2);
        return j;
    }

    public static final ByteString commonReadByteString(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final ByteString commonReadByteString(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() >= j) {
            if (j >= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                ByteString snapshot = buffer.snapshot((int) j);
                buffer.skip(j);
                return snapshot;
            }
            return new ByteString(buffer.readByteArray(j));
        }
        throw new EOFException();
    }

    public static final int commonSelect(okio.Buffer buffer, Options options) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonReadFully(okio.Buffer buffer, okio.Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (buffer.size() < j) {
            sink.write(buffer, buffer.size());
            throw new EOFException();
        } else {
            sink.write(buffer, j);
        }
    }

    public static final long commonReadAll(okio.Buffer buffer, Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final String commonReadUtf8(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() >= j) {
            if (i == 0) {
                return "";
            }
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            if (segment.pos + j > segment.limit) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
            }
            int i2 = (int) j;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, segment.pos, segment.pos + i2);
            segment.pos += i2;
            buffer.setSize$okio(buffer.size() - j);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
        throw new EOFException();
    }

    public static final String commonReadUtf8Line(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long indexOf = buffer.indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == 13 && buffer.getByte(j2) == 10) {
                return readUtf8Line(buffer, j2);
            }
            okio.Buffer buffer2 = new okio.Buffer();
            buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    public static final int commonReadUtf8CodePoint(okio.Buffer buffer) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        byte b = buffer.getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i3 = 0;
            i2 = 1;
        } else if ((b & 224) == 192) {
            i = b & Ascii.US;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & Ascii.SI;
            i2 = 3;
            i3 = 2048;
        } else if ((b & 248) != 240) {
            buffer.skip(1L);
            return Utf8.REPLACEMENT_CODE_POINT;
        } else {
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (buffer.size() < j) {
            throw new EOFException("size < " + i2 + ": " + buffer.size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = buffer.getByte(j2);
            if ((b2 & 192) != 128) {
                buffer.skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
        }
        buffer.skip(j);
        return i > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 > i || i >= 57344) && i >= i3) ? i : Utf8.REPLACEMENT_CODE_POINT;
    }

    public static final okio.Buffer commonWriteUtf8(okio.Buffer buffer, String string, int i, int i2) {
        char charAt;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (i >= 0) {
            if (i2 < i) {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
            if (i2 <= string.length()) {
                while (i < i2) {
                    char charAt2 = string.charAt(i);
                    if (charAt2 < 128) {
                        Segment writableSegment$okio = buffer.writableSegment$okio(1);
                        byte[] bArr = writableSegment$okio.data;
                        int i3 = writableSegment$okio.limit - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt2;
                        while (true) {
                            i = i4;
                            if (i >= min || (charAt = string.charAt(i)) >= 128) {
                                break;
                            }
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                        int i5 = (i3 + i) - writableSegment$okio.limit;
                        writableSegment$okio.limit += i5;
                        buffer.setSize$okio(buffer.size() + i5);
                    } else {
                        if (charAt2 < 2048) {
                            Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt2 >> 6) | 192);
                            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt2 & '?') | 128);
                            writableSegment$okio2.limit += 2;
                            buffer.setSize$okio(buffer.size() + 2);
                        } else if (charAt2 < 55296 || charAt2 > 57343) {
                            Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt2 >> '\f') | 224);
                            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((charAt2 >> 6) & 63) | 128);
                            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt2 & '?') | 128);
                            writableSegment$okio3.limit += 3;
                            buffer.setSize$okio(buffer.size() + 3);
                        } else {
                            int i6 = i + 1;
                            char charAt3 = i6 < i2 ? string.charAt(i6) : (char) 0;
                            if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                                buffer.writeByte(63);
                                i = i6;
                            } else {
                                int i7 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i7 >> 18) | 240);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i7 >> 12) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i7 >> 6) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i7 & 63) | 128);
                                writableSegment$okio4.limit += 4;
                                buffer.setSize$okio(buffer.size() + 4);
                                i += 2;
                            }
                        }
                        i++;
                    }
                }
                return buffer;
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public static final okio.Buffer commonWriteUtf8CodePoint(okio.Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i < 128) {
            buffer.writeByte(i);
            return buffer;
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            buffer.setSize$okio(buffer.size() + 2);
            return buffer;
        } else if (55296 <= i && i < 57344) {
            buffer.writeByte(63);
            return buffer;
        } else if (i < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | 224);
            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit += 3;
            buffer.setSize$okio(buffer.size() + 3);
            return buffer;
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | 240);
            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit += 4;
            buffer.setSize$okio(buffer.size() + 4);
            return buffer;
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i));
        }
    }

    public static final long commonWriteAll(okio.Buffer buffer, Source source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, Source source, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return buffer;
    }

    public static final okio.Buffer commonWriteByte(okio.Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final okio.Buffer commonWriteShort(okio.Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 2;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final okio.Buffer commonWriteInt(okio.Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 4;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final okio.Buffer commonWriteLong(okio.Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        writableSegment$okio.limit = i + 8;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final void commonWrite(okio.Buffer buffer, okio.Buffer source, long j) {
        Segment segment;
        Segment segment2;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == buffer) {
            throw new IllegalArgumentException("source == this".toString());
        }
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment3 = source.head;
            Intrinsics.checkNotNull(segment3);
            int i = segment3.limit;
            Intrinsics.checkNotNull(source.head);
            if (j < i - segment.pos) {
                if (buffer.head != null) {
                    Segment segment4 = buffer.head;
                    Intrinsics.checkNotNull(segment4);
                    segment2 = segment4.prev;
                } else {
                    segment2 = null;
                }
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j) - (segment2.shared ? 0 : segment2.pos) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        Segment segment5 = source.head;
                        Intrinsics.checkNotNull(segment5);
                        segment5.writeTo(segment2, (int) j);
                        source.setSize$okio(source.size() - j);
                        buffer.setSize$okio(buffer.size() + j);
                        return;
                    }
                }
                Segment segment6 = source.head;
                Intrinsics.checkNotNull(segment6);
                source.head = segment6.split((int) j);
            }
            Segment segment7 = source.head;
            Intrinsics.checkNotNull(segment7);
            long j2 = segment7.limit - segment7.pos;
            source.head = segment7.pop();
            if (buffer.head == null) {
                buffer.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7.prev;
            } else {
                Segment segment8 = buffer.head;
                Intrinsics.checkNotNull(segment8);
                Segment segment9 = segment8.prev;
                Intrinsics.checkNotNull(segment9);
                segment9.push(segment7).compact();
            }
            source.setSize$okio(source.size() - j2);
            buffer.setSize$okio(buffer.size() + j2);
            j -= j2;
        }
    }

    public static final long commonRead(okio.Buffer buffer, okio.Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j > buffer.size()) {
            j = buffer.size();
        }
        sink.write(buffer, j);
        return j;
    }

    public static final long commonIndexOf(okio.Buffer buffer, byte b, long j, long j2) {
        Segment segment;
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > buffer.size()) {
            j2 = buffer.size();
        }
        if (j == j2 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            j3 = buffer.size();
            while (j3 > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                j3 -= segment.limit - segment.pos;
            }
            if (segment == null) {
                return -1L;
            }
            while (j3 < j2) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
                i = (int) ((segment.pos + j) - j3);
                while (i < min) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j3;
            }
            return -1L;
        }
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j) {
                break;
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j3 = j4;
        }
        if (segment == null) {
            return -1L;
        }
        while (j3 < j2) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j2) - j3);
            i = (int) ((segment.pos + j) - j3);
            while (i < min2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            j3 += segment.limit - segment.pos;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j = j3;
        }
        return -1L;
        return (i - segment.pos) + j3;
    }

    public static /* synthetic */ long commonIndexOf$default(okio.Buffer buffer, ByteString byteString, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j2 = Long.MAX_VALUE;
        }
        return commonIndexOf(buffer, byteString, j, j2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? byteString.size() : i2);
    }

    public static final long commonIndexOf(okio.Buffer buffer, ByteString bytes, long j, long j2, int i, int i2) {
        Segment segment;
        int i3;
        long j3 = j;
        long j4 = j2;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j5 = i2;
        SegmentedByteString.checkOffsetAndCount(bytes.size(), i, j5);
        if (i2 > 0) {
            long j6 = 0;
            if (j3 >= 0) {
                if (j3 > j4) {
                    throw new IllegalArgumentException(("fromIndex > toIndex: " + j3 + " > " + j4).toString());
                }
                if (j4 > buffer.size()) {
                    j4 = buffer.size();
                }
                long j7 = -1;
                if (j3 == j4 || (segment = buffer.head) == null) {
                    return -1L;
                }
                if (buffer.size() - j3 >= j3) {
                    while (true) {
                        long j8 = (segment.limit - segment.pos) + j6;
                        if (j8 > j3) {
                            break;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j6 = j8;
                    }
                    if (segment == null) {
                        return -1L;
                    }
                    byte[] internalArray$okio = bytes.internalArray$okio();
                    byte b = internalArray$okio[i];
                    long min = Math.min(j4, (buffer.size() - j5) + 1);
                    while (j6 < min) {
                        byte[] bArr = segment.data;
                        int min2 = (int) Math.min(segment.limit, (segment.pos + min) - j6);
                        i3 = (int) ((segment.pos + j3) - j6);
                        while (i3 < min2) {
                            if (bArr[i3] != b || !rangeEquals(segment, i3 + 1, internalArray$okio, i + 1, i2)) {
                                i3++;
                            }
                        }
                        j6 += segment.limit - segment.pos;
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j3 = j6;
                    }
                    return -1L;
                }
                j6 = buffer.size();
                while (j6 > j3) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j6 -= segment.limit - segment.pos;
                    j7 = j7;
                }
                long j9 = j7;
                if (segment == null) {
                    return j9;
                }
                byte[] internalArray$okio2 = bytes.internalArray$okio();
                byte b2 = internalArray$okio2[i];
                long min3 = Math.min(j4, (buffer.size() - j5) + 1);
                while (j6 < min3) {
                    byte[] bArr2 = segment.data;
                    int min4 = (int) Math.min(segment.limit, (segment.pos + min3) - j6);
                    i3 = (int) ((segment.pos + j3) - j6);
                    while (i3 < min4) {
                        if (bArr2[i3] != b2 || !rangeEquals(segment, i3 + 1, internalArray$okio2, i + 1, i2)) {
                            i3++;
                        }
                    }
                    j6 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j6;
                }
                return j9;
                return (i3 - segment.pos) + j6;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        throw new IllegalArgumentException("byteCount == 0".toString());
    }

    public static final boolean commonRangeEquals(okio.Buffer buffer, long j, ByteString bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return i2 >= 0 && j >= 0 && ((long) i2) + j <= buffer.size() && i >= 0 && i + i2 <= bytes.size() && (i2 == 0 || commonIndexOf(buffer, bytes, j, j + 1, i, i2) != -1);
    }

    public static final boolean commonEquals(okio.Buffer buffer, Object obj) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer == obj) {
            return true;
        }
        if (obj instanceof okio.Buffer) {
            okio.Buffer buffer2 = (okio.Buffer) obj;
            if (buffer.size() != buffer2.size()) {
                return false;
            }
            if (buffer.size() == 0) {
                return true;
            }
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            Segment segment2 = buffer2.head;
            Intrinsics.checkNotNull(segment2);
            int i = segment.pos;
            int i2 = segment2.pos;
            long j = 0;
            while (j < buffer.size()) {
                long min = Math.min(segment.limit - i, segment2.limit - i2);
                long j2 = 0;
                while (j2 < min) {
                    int i3 = i + 1;
                    int i4 = i2 + 1;
                    if (segment.data[i] != segment2.data[i2]) {
                        return false;
                    }
                    j2++;
                    i = i3;
                    i2 = i4;
                }
                if (i == segment.limit) {
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    i = segment.pos;
                }
                if (i2 == segment2.limit) {
                    segment2 = segment2.next;
                    Intrinsics.checkNotNull(segment2);
                    i2 = segment2.pos;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public static final int commonHashCode(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != buffer.head);
        return i;
    }

    public static final okio.Buffer commonCopy(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        okio.Buffer buffer2 = new okio.Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = buffer2.head;
        sharedCopy.next = sharedCopy.prev;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final ByteString commonSnapshot(okio.Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
        }
        return buffer.snapshot((int) buffer.size());
    }

    public static final ByteString commonSnapshot(okio.Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            if (segment.limit == segment.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += segment.limit - segment.pos;
            i4++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i4];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = buffer.head;
        int i5 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i5] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i5] = Math.min(i2, i);
            iArr[bArr.length + i5] = segment2.pos;
            segment2.shared = true;
            i5++;
            segment2 = segment2.next;
        }
        return new C0791SegmentedByteString(bArr, iArr);
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(okio.Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        resolveDefaultParameter.buffer = buffer;
        resolveDefaultParameter.readWrite = false;
        return resolveDefaultParameter;
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(okio.Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        resolveDefaultParameter.buffer = buffer;
        resolveDefaultParameter.readWrite = true;
        return resolveDefaultParameter;
    }

    public static final int commonNext(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        long j = unsafeCursor.offset;
        okio.Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j != buffer.size()) {
            return unsafeCursor.seek(unsafeCursor.offset == -1 ? 0L : unsafeCursor.offset + (unsafeCursor.end - unsafeCursor.start));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final int commonSeek(Buffer.UnsafeCursor unsafeCursor, long j) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
        if (i < 0 || j > buffer.size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size());
        }
        if (i == 0 || j == buffer.size()) {
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = j;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return -1;
        }
        long size = buffer.size();
        Segment segment = buffer.head;
        Segment segment2 = buffer.head;
        long j2 = 0;
        if (unsafeCursor.getSegment$okio() != null) {
            long j3 = unsafeCursor.offset;
            int i2 = unsafeCursor.start;
            Segment segment$okio = unsafeCursor.getSegment$okio();
            Intrinsics.checkNotNull(segment$okio);
            long j4 = j3 - (i2 - segment$okio.pos);
            if (j4 > j) {
                segment2 = unsafeCursor.getSegment$okio();
                size = j4;
            } else {
                segment = unsafeCursor.getSegment$okio();
                j2 = j4;
            }
        }
        if (size - j > j - j2) {
            while (true) {
                Intrinsics.checkNotNull(segment);
                if (j < (segment.limit - segment.pos) + j2) {
                    break;
                }
                j2 += segment.limit - segment.pos;
                segment = segment.next;
            }
        } else {
            while (size > j) {
                Intrinsics.checkNotNull(segment2);
                segment2 = segment2.prev;
                Intrinsics.checkNotNull(segment2);
                size -= segment2.limit - segment2.pos;
            }
            j2 = size;
            segment = segment2;
        }
        if (unsafeCursor.readWrite) {
            Intrinsics.checkNotNull(segment);
            if (segment.shared) {
                Segment unsharedCopy = segment.unsharedCopy();
                if (buffer.head == segment) {
                    buffer.head = unsharedCopy;
                }
                segment = segment.push(unsharedCopy);
                Segment segment3 = segment.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.pop();
            }
        }
        unsafeCursor.setSegment$okio(segment);
        unsafeCursor.offset = j;
        Intrinsics.checkNotNull(segment);
        unsafeCursor.data = segment.data;
        unsafeCursor.start = segment.pos + ((int) (j - j2));
        unsafeCursor.end = segment.limit;
        return unsafeCursor.end - unsafeCursor.start;
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor unsafeCursor, long j) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long size = buffer.size();
        int i = (j > size ? 1 : (j == size ? 0 : -1));
        if (i <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException(("newSize < 0: " + j).toString());
            }
            long j2 = size - j;
            while (true) {
                if (j2 <= 0) {
                    break;
                }
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                long j3 = segment2.limit - segment2.pos;
                if (j3 <= j2) {
                    buffer.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                    j2 -= j3;
                } else {
                    segment2.limit -= (int) j2;
                    break;
                }
            }
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = j;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
        } else if (i > 0) {
            long j4 = j - size;
            boolean z = true;
            while (j4 > 0) {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int min = (int) Math.min(j4, 8192 - writableSegment$okio.limit);
                writableSegment$okio.limit += min;
                j4 -= min;
                if (z) {
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    unsafeCursor.start = writableSegment$okio.limit - min;
                    unsafeCursor.end = writableSegment$okio.limit;
                    z = false;
                }
            }
        }
        buffer.setSize$okio(j);
        return size;
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor unsafeCursor, int i) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (i > 0) {
            if (i > 8192) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
            }
            okio.Buffer buffer = unsafeCursor.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!unsafeCursor.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            Segment writableSegment$okio = buffer.writableSegment$okio(i);
            int i2 = 8192 - writableSegment$okio.limit;
            writableSegment$okio.limit = 8192;
            long j = i2;
            buffer.setSize$okio(size + j);
            unsafeCursor.setSegment$okio(writableSegment$okio);
            unsafeCursor.offset = size;
            unsafeCursor.data = writableSegment$okio.data;
            unsafeCursor.start = 8192 - i2;
            unsafeCursor.end = 8192;
            return j;
        }
        throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
    }

    public static final void commonClose(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (unsafeCursor.buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }

    public static final long commonIndexOfElement(okio.Buffer buffer, ByteString targetBytes, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            j2 = buffer.size();
            while (j2 > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                j2 -= segment.limit - segment.pos;
            }
            if (segment == null) {
                return -1L;
            }
            if (targetBytes.size() == 2) {
                byte b = targetBytes.getByte(0);
                byte b2 = targetBytes.getByte(1);
                while (j2 < buffer.size()) {
                    byte[] bArr = segment.data;
                    i = (int) ((segment.pos + j) - j2);
                    int i3 = segment.limit;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (b3 != b && b3 != b2) {
                            i++;
                        }
                        i2 = segment.pos;
                    }
                    j2 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
            } else {
                byte[] internalArray$okio = targetBytes.internalArray$okio();
                while (j2 < buffer.size()) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((segment.pos + j) - j2);
                    int i4 = segment.limit;
                    while (i < i4) {
                        byte b4 = bArr2[i];
                        for (byte b5 : internalArray$okio) {
                            if (b4 == b5) {
                                i2 = segment.pos;
                            }
                        }
                        i++;
                    }
                    j2 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
            }
            return -1L;
        }
        while (true) {
            long j3 = (segment.limit - segment.pos) + j2;
            if (j3 > j) {
                break;
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j2 = j3;
        }
        if (segment == null) {
            return -1L;
        }
        if (targetBytes.size() == 2) {
            byte b6 = targetBytes.getByte(0);
            byte b7 = targetBytes.getByte(1);
            while (j2 < buffer.size()) {
                byte[] bArr3 = segment.data;
                i = (int) ((segment.pos + j) - j2);
                int i5 = segment.limit;
                while (i < i5) {
                    byte b8 = bArr3[i];
                    if (b8 != b6 && b8 != b7) {
                        i++;
                    }
                    i2 = segment.pos;
                }
                j2 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j2;
            }
        } else {
            byte[] internalArray$okio2 = targetBytes.internalArray$okio();
            while (j2 < buffer.size()) {
                byte[] bArr4 = segment.data;
                i = (int) ((segment.pos + j) - j2);
                int i6 = segment.limit;
                while (i < i6) {
                    byte b9 = bArr4[i];
                    for (byte b10 : internalArray$okio2) {
                        if (b9 == b10) {
                            i2 = segment.pos;
                        }
                    }
                    i++;
                }
                j2 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j2;
            }
        }
        return -1L;
        return (i - i2) + j2;
    }
}
