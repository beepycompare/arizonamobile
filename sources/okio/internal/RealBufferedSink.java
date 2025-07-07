package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
/* compiled from: RealBufferedSink.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0080\b\u001a%\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0080\b\u001a%\u0010\f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0011\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0080\b\u001a%\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0080\b\u001a\u001d\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0018\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0080\b\u001a\r\u0010#\u001a\u00020\u0007*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010'\u001a\u00020(*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020\u000e*\u00020\u0002H\u0080\b¨\u0006*"}, d2 = {"commonWrite", "", "Lokio/RealBufferedSink;", "source", "Lokio/Buffer;", "byteCount", "", "Lokio/BufferedSink;", "byteString", "Lokio/ByteString;", TypedValues.CycleType.S_WAVE_OFFSET, "", "commonWriteUtf8", TypedValues.Custom.S_STRING, "", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "", "commonWriteAll", "Lokio/Source;", "commonWriteByte", "b", "commonWriteShort", CmcdData.STREAMING_FORMAT_SS, "commonWriteShortLe", "commonWriteInt", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "commonWriteIntLe", "commonWriteLong", "v", "commonWriteLongLe", "commonWriteDecimalLong", "commonWriteHexadecimalUnsignedLong", "commonEmitCompleteSegments", "commonEmit", "commonFlush", "commonClose", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: okio.internal.-RealBufferedSink  reason: invalid class name */
/* loaded from: classes5.dex */
public final class RealBufferedSink {
    public static final void commonWrite(okio.RealBufferedSink realBufferedSink, Buffer source, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(source, j);
        realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, ByteString byteString) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(byteString);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(byteString, i, i2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(okio.RealBufferedSink realBufferedSink, String string) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8(string);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(okio.RealBufferedSink realBufferedSink, String string, int i, int i2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8(string, i, i2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(okio.RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8CodePoint(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, byte[] source) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(source);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(source, i, i2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteByte(okio.RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeByte(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(okio.RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShort(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(okio.RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShortLe(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(okio.RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeInt(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(okio.RealBufferedSink realBufferedSink, int i) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeIntLe(i);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(okio.RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLong(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(okio.RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLongLe(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(okio.RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeDecimalLong(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(okio.RealBufferedSink realBufferedSink, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonEmitCompleteSegments(okio.RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
        }
        return realBufferedSink;
    }

    public static final BufferedSink commonEmit(okio.RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long size = realBufferedSink.bufferField.size();
        if (size > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, size);
        }
        return realBufferedSink;
    }

    public static final void commonFlush(okio.RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSink.bufferField.size() > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
        }
        realBufferedSink.sink.flush();
    }

    public static final void commonClose(okio.RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            return;
        }
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        realBufferedSink.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final Timeout commonTimeout(okio.RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(okio.RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final long commonWriteAll(okio.RealBufferedSink realBufferedSink, Source source) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, Source source, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(realBufferedSink.bufferField, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            realBufferedSink.emitCompleteSegments();
        }
        return realBufferedSink;
    }
}
