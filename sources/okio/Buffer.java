package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
/* compiled from: Buffer.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0094\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J \u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\nJ\u001a\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\nJ \u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b+J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\nH\u0016J\b\u00106\u001a\u000207H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0016J'\u00108\u001a\u0004\u0018\u0001H;\"\b\b\u0000\u0010;*\u00020<2\f\u00109\u001a\b\u0012\u0004\u0012\u0002H;0=H\u0016¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010E\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010F\u001a\u00020GH\u0016J\n\u0010H\u001a\u0004\u0018\u00010DH\u0016J\b\u0010I\u001a\u00020DH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020/H\u0016J\b\u0010L\u001a\u00020MH\u0016J\u0010\u0010L\u001a\u00020M2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020MH\u0016J\u0010\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020MH\u0016J \u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020M2\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020\u0019J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u000207H\u0016J \u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u0002072\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020DH\u0016J \u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/H\u0016J\u0010\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020/H\u0016J\u0018\u0010Z\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0016J(\u0010Z\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020MH\u0016J \u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020M2\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010[\u001a\u00020OH\u0016J\u0010\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020]H\u0016J\u0018\u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020]2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020/H\u0016J\u0010\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020/H\u0016J\u0010\u0010b\u001a\u00020\u00002\u0006\u0010a\u001a\u00020/H\u0016J\u0010\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020/H\u0016J\u0010\u0010e\u001a\u00020\u00002\u0006\u0010d\u001a\u00020/H\u0016J\u0010\u0010f\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010h\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010i\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010j\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0015\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020/H\u0000¢\u0006\u0002\bmJ\u0018\u0010R\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0018\u0010N\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(H\u0016J\u0018\u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(2\u0006\u0010o\u001a\u00020\nH\u0016J \u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u000207H\u0016J\u0018\u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010o\u001a\u00020\nH\u0016J\u0010\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u000207H\u0016J\u0018\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u0002072\u0006\u0010o\u001a\u00020\nH\u0016J\u0018\u0010t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010q\u001a\u000207H\u0016J(\u0010t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010u\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\b\u0010v\u001a\u00020\u0019H\u0016J\b\u0010w\u001a\u00020\u0017H\u0016J\b\u0010x\u001a\u00020\u0019H\u0016J\b\u0010y\u001a\u00020zH\u0016J\u0006\u0010{\u001a\u000207J\u0006\u0010|\u001a\u000207J\u0006\u0010}\u001a\u000207J\u0006\u0010~\u001a\u000207J\u0011\u0010\u007f\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020DH\u0002J\u0010\u0010\u0081\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u0010\u0010\u0083\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u0010\u0010\u0084\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u001b\u0010\u0085\u0001\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020D2\u0007\u0010\u0082\u0001\u001a\u000207H\u0002J\u0015\u0010\u0086\u0001\u001a\u00020\u00172\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010<H\u0096\u0002J\t\u0010\u0088\u0001\u001a\u00020/H\u0016J\t\u0010\u0089\u0001\u001a\u00020DH\u0016J\u0007\u0010\u008a\u0001\u001a\u00020\u0000J\t\u0010\u008b\u0001\u001a\u00020\u0000H\u0016J\u0007\u0010\u008c\u0001\u001a\u000207J\u000f\u0010\u008c\u0001\u001a\u0002072\u0006\u0010\u001a\u001a\u00020/J\u0016\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0016\u0010\u0090\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0017\u0010+\u001a\u00020(2\u0007\u0010\u0091\u0001\u001a\u00020\nH\u0007¢\u0006\u0003\b\u0092\u0001J\u000e\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0003\b\u0093\u0001R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0095\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "<init>", "()V", TtmlNode.TAG_HEAD, "Lokio/Segment;", "value", "", "size", "()J", "setSize$okio", "(J)V", "buffer", "getBuffer", "()Lokio/Buffer;", "outputStream", "Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "exhausted", "", "require", "", "byteCount", "request", "peek", "inputStream", "Ljava/io/InputStream;", "copyTo", "out", TypedValues.CycleType.S_WAVE_OFFSET, "writeTo", "readFrom", "input", "forever", "completeSegmentByteCount", "readByte", "", "get", "pos", "getByte", "readShort", "", "readInt", "", "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "Lokio/ByteString;", "select", "options", "Lokio/Options;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readFully", "sink", "readAll", "Lokio/Sink;", "readUtf8", "", "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readByteArray", "", "read", "Ljava/nio/ByteBuffer;", "clear", "skip", "write", "byteString", "writeUtf8", TypedValues.Custom.S_STRING, "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "source", "writeAll", "Lokio/Source;", "writeByte", "b", "writeShort", CmcdData.STREAMING_FORMAT_SS, "writeShortLe", "writeInt", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "writableSegment", "minimumCapacity", "writableSegment$okio", "indexOf", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "flush", "isOpen", "close", "timeout", "Lokio/Timeout;", "md5", "sha1", "sha256", "sha512", "digest", "algorithm", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "equals", "other", "hashCode", "toString", "copy", "clone", "snapshot", "readUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readAndWriteUnsafe", FirebaseAnalytics.Param.INDEX, "-deprecated_getByte", "-deprecated_size", "UnsafeCursor", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final Buffer copyTo(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo$default(this, out, 0L, 0L, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream out, long j) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo$default(this, out, j, 0L, 4, (Object) null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final Buffer writeTo(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        return writeTo$default(this, out, 0L, 2, null);
    }

    public final long size() {
        return this.size;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i, int i2) {
                Intrinsics.checkNotNullParameter(data, "data");
                Buffer.this.write(data, i, i2);
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i, int i2) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return Buffer.this.read(sink, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = buffer.size - j3;
        }
        return buffer.copyTo(outputStream, j3, j2);
    }

    public final Buffer copyTo(OutputStream out, long j, long j2) throws IOException {
        int i;
        Intrinsics.checkNotNullParameter(out, "out");
        long j3 = j;
        SegmentedByteString.checkOffsetAndCount(this.size, j3, j2);
        if (j2 != 0) {
            Segment segment = this.head;
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
                int min = (int) Math.min(segment2.limit - i, j4);
                out.write(segment2.data, (int) (segment2.pos + j3), min);
                j4 -= min;
                segment2 = segment2.next;
                j3 = 0;
            }
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public final Buffer copyTo(Buffer out, long j) {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo(out, j, this.size - j);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    public final Buffer writeTo(OutputStream out, long j) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        long j2 = j;
        while (j2 > 0) {
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j2, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j3 = min;
            this.size -= j3;
            j2 -= j3;
            if (segment.pos == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public final Buffer readFrom(InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream input, long j) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        readFrom(input, j, false);
        return this;
    }

    private final void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public <T> T select(TypedOptions<T> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int select = select(options.getOptions$okio());
        if (select == -1) {
            return null;
        }
        return options.get(select);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (this.size >= j) {
            if (i == 0) {
                return "";
            }
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            if (segment.pos + j > segment.limit) {
                return new String(readByteArray(j), charset);
            }
            int i2 = (int) j;
            String str = new String(segment.data, segment.pos, i2, charset);
            segment.pos += i2;
            this.size -= j;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (i >= 0) {
            if (i2 < i) {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
            if (i2 > string.length()) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
            }
            if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                return writeUtf8(string, i, i2);
            }
            String substring = string.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        int remaining = source.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) i));
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(SegmentedByteString.reverseBytes(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(SegmentedByteString.reverseBytes(j));
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(j, bytes, 0, bytes.size());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
            Segment segment2 = segment.next;
            Intrinsics.checkNotNull(segment2);
            while (segment2 != segment) {
                messageDigest.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
            }
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return new ByteString(digest);
    }

    public final ByteString hmacSha1(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac("HmacSHA512", key);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                Segment segment2 = segment.next;
                Intrinsics.checkNotNull(segment2);
                while (segment2 != segment) {
                    mac.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    Intrinsics.checkNotNull(segment2);
                }
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toString() {
        return snapshot().toString();
    }

    public Buffer clone() {
        return copy();
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m10296deprecated_getByte(long j) {
        return getByte(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m10297deprecated_size() {
        return this.size;
    }

    /* compiled from: Buffer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "<init>", "()V", "buffer", "Lokio/Buffer;", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", TypedValues.CycleType.S_WAVE_OFFSET, "", "data", "", TtmlNode.START, "", TtmlNode.END, "next", "seek", "resizeBuffer", "newSize", "expandBuffer", "minByteCount", "close", "", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final void setSegment$okio(Segment segment) {
            this.segment = segment;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            Intrinsics.checkNotNull(buffer);
            if (j == buffer.size()) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j2 = this.offset;
            return seek(j2 == -1 ? 0L : j2 + (this.end - this.start));
        }

        public final int seek(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i < 0 || j > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size());
            }
            if (i == 0 || j == buffer.size()) {
                setSegment$okio(null);
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = buffer.size();
            Segment segment = buffer.head;
            Segment segment2 = buffer.head;
            long j2 = 0;
            if (getSegment$okio() != null) {
                long j3 = this.offset;
                int i2 = this.start;
                Segment segment$okio = getSegment$okio();
                Intrinsics.checkNotNull(segment$okio);
                long j4 = j3 - (i2 - segment$okio.pos);
                if (j4 > j) {
                    segment2 = getSegment$okio();
                    size = j4;
                } else {
                    segment = getSegment$okio();
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
            if (this.readWrite) {
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
            setSegment$okio(segment);
            this.offset = j;
            Intrinsics.checkNotNull(segment);
            this.data = segment.data;
            this.start = segment.pos + ((int) (j - j2));
            int i3 = segment.limit;
            this.end = i3;
            return i3 - this.start;
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
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
                setSegment$okio(null);
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (i > 0) {
                long j4 = j - size;
                boolean z = true;
                while (j4 > 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(1);
                    int min = (int) Math.min(j4, 8192 - writableSegment$okio.limit);
                    writableSegment$okio.limit += min;
                    j4 -= min;
                    if (z) {
                        setSegment$okio(writableSegment$okio);
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = writableSegment$okio.limit - min;
                        this.end = writableSegment$okio.limit;
                        z = false;
                    }
                }
            }
            buffer.setSize$okio(j);
            return size;
        }

        public final long expandBuffer(int i) {
            if (i > 0) {
                if (i > 8192) {
                    throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
                }
                Buffer buffer = this.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer".toString());
                }
                if (!this.readWrite) {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
                long size = buffer.size();
                Segment writableSegment$okio = buffer.writableSegment$okio(i);
                int i2 = 8192 - writableSegment$okio.limit;
                writableSegment$okio.limit = 8192;
                long j = i2;
                buffer.setSize$okio(size + j);
                setSegment$okio(writableSegment$okio);
                this.offset = size;
                this.data = writableSegment$okio.data;
                this.start = 8192 - i2;
                this.end = 8192;
                return j;
            }
            throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }

    public final Buffer copyTo(Buffer out, long j, long j2) {
        Intrinsics.checkNotNullParameter(out, "out");
        long j3 = j;
        SegmentedByteString.checkOffsetAndCount(size(), j3, j2);
        if (j2 != 0) {
            out.setSize$okio(out.size() + j2);
            Segment segment = this.head;
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
                Segment segment3 = out.head;
                if (segment3 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy.prev;
                    out.head = sharedCopy.next;
                } else {
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
        return this;
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (segment2.limit - segment2.pos);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        setSize$okio(size() - 1);
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return b;
        }
        segment.pos = i3;
        return b;
    }

    public final byte getByte(long j) {
        SegmentedByteString.checkOffsetAndCount(size(), j, 1L);
        Segment segment = this.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.checkNotNull(null);
            byte[] bArr = segment2.data;
            throw null;
        } else if (size() - j < j) {
            long size = size();
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

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = (bArr[i3] & 255) | ((bArr[i] & 255) << 8);
        setSize$okio(size() - 2);
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i4 = i + 3;
        int i5 = i + 4;
        int i6 = (bArr[i4] & 255) | i3 | ((bArr[i + 2] & 255) << 8);
        setSize$okio(size() - 4);
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return i6;
        }
        segment.pos = i5;
        return i6;
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40);
        int i3 = i + 7;
        int i4 = i + 8;
        long j2 = j | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8) | (bArr[i3] & 255);
        setSize$okio(size() - 8);
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return j2;
        }
        segment.pos = i4;
        return j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
        setSize$okio(size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
        if (r2 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ab, code lost:
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ae, code lost:
        if (r1 >= r14) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b6, code lost:
        if (size() == r17) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b8, code lost:
        if (r2 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ba, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.toHexString(getByte(r17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00eb, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ec, code lost:
        if (r2 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ee, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f0, code lost:
        return -r8;
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() throws EOFException {
        long j;
        byte b;
        long j2 = 0;
        if (size() == 0) {
            throw new EOFException();
        }
        int i = 0;
        boolean z = false;
        long j3 = 0;
        long j4 = -7;
        boolean z2 = false;
        loop0: while (true) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            while (i2 < i3) {
                b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    int i5 = (j3 > okio.internal.Buffer.OVERFLOW_ZONE ? 1 : (j3 == okio.internal.Buffer.OVERFLOW_ZONE ? 0 : -1));
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
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i2;
            }
            if (z2 || this.head == null) {
                break;
            }
            j2 = j;
        }
        Buffer writeByte = new Buffer().writeDecimalLong(j3).writeByte((int) b);
        if (!z) {
            writeByte.readByte();
        }
        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[EDGE_INSN: B:42:0x00a3->B:37:0x00a3 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() throws EOFException {
        int i;
        if (size() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = this.head;
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
                        this.head = segment.pop();
                        SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i3;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z) {
            }
        } while (this.head != null);
        setSize$okio(size() - i2);
        return j;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() >= j) {
            if (j >= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                ByteString snapshot = snapshot((int) j);
                skip(j);
                return snapshot;
            }
            return new ByteString(readByteArray(j));
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = okio.internal.Buffer.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (size() < j) {
            sink.write(this, size());
            throw new EOFException();
        } else {
            sink.write(this, j);
        }
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long indexOf = indexOf((byte) 10, 0L, j2);
            if (indexOf != -1) {
                return okio.internal.Buffer.readUtf8Line(this, indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return okio.internal.Buffer.readUtf8Line(this, j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0L, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
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
            skip(1L);
            return Utf8.REPLACEMENT_CODE_POINT;
        } else {
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (size() < j) {
            throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
        }
        skip(j);
        return i > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 > i || i >= 57344) && i >= i3) ? i : Utf8.REPLACEMENT_CODE_POINT;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int read = read(sink, i, sink.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.copyInto(segment.data, sink, i, segment.pos, segment.pos + min);
        segment.pos += min;
        setSize$okio(size() - min);
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = min;
            setSize$okio(size() - j2);
            j -= j2;
            segment.pos += min;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, i, i2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string, int i, int i2) {
        char charAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (i >= 0) {
            if (i2 < i) {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
            if (i2 <= string.length()) {
                while (i < i2) {
                    char charAt2 = string.charAt(i);
                    if (charAt2 < 128) {
                        Segment writableSegment$okio = writableSegment$okio(1);
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
                        setSize$okio(size() + i5);
                    } else {
                        if (charAt2 < 2048) {
                            Segment writableSegment$okio2 = writableSegment$okio(2);
                            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt2 >> 6) | 192);
                            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt2 & '?') | 128);
                            writableSegment$okio2.limit += 2;
                            setSize$okio(size() + 2);
                        } else if (charAt2 < 55296 || charAt2 > 57343) {
                            Segment writableSegment$okio3 = writableSegment$okio(3);
                            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt2 >> '\f') | 224);
                            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((charAt2 >> 6) & 63) | 128);
                            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt2 & '?') | 128);
                            writableSegment$okio3.limit += 3;
                            setSize$okio(size() + 3);
                        } else {
                            int i6 = i + 1;
                            char charAt3 = i6 < i2 ? string.charAt(i6) : (char) 0;
                            if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                                writeByte(63);
                                i = i6;
                            } else {
                                int i7 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                Segment writableSegment$okio4 = writableSegment$okio(4);
                                writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i7 >> 18) | 240);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i7 >> 12) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i7 >> 6) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i7 & 63) | 128);
                                writableSegment$okio4.limit += 4;
                                setSize$okio(size() + 4);
                                i += 2;
                            }
                        }
                        i++;
                    }
                }
                return this;
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
            return this;
        } else if (i < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            setSize$okio(size() + 2);
            return this;
        } else if (55296 <= i && i < 57344) {
            writeByte(63);
            return this;
        } else if (i < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | 224);
            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit += 3;
            setSize$okio(size() + 3);
            return this;
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | 240);
            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit += 4;
            setSize$okio(size() + 4);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i));
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt.copyInto(source, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        setSize$okio(size() + j);
        return this;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment writableSegment$okio = writableSegment$okio(8);
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
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        boolean z;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        int access$countDigitsIn = okio.internal.Buffer.access$countDigitsIn(j);
        if (z) {
            access$countDigitsIn++;
        }
        Segment writableSegment$okio = writableSegment$okio(access$countDigitsIn);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit + access$countDigitsIn;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        writableSegment$okio.limit += access$countDigitsIn;
        setSize$okio(size() + access$countDigitsIn);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
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
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + i);
        return this;
    }

    public final Segment writableSegment$okio(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) {
        Segment segment;
        Segment segment2;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this".toString());
        }
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment3 = source.head;
            Intrinsics.checkNotNull(segment3);
            int i = segment3.limit;
            Intrinsics.checkNotNull(source.head);
            if (j < i - segment.pos) {
                Segment segment4 = this.head;
                if (segment4 != null) {
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
                        setSize$okio(size() + j);
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
            Segment segment8 = this.head;
            if (segment8 == null) {
                this.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7.prev;
            } else {
                Intrinsics.checkNotNull(segment8);
                Segment segment9 = segment8.prev;
                Intrinsics.checkNotNull(segment9);
                segment9.push(segment7).compact();
            }
            source.setSize$okio(source.size() - j2);
            setSize$okio(size() + j2);
            j -= j2;
        }
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j > size()) {
            j = size();
        }
        sink.write(this, j);
        return j;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        int i;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > size()) {
            j2 = size();
        }
        if (j == j2 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j < j) {
            j3 = size();
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

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes, long j) throws IOException {
        int i;
        long j2 = j;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (bytes.size() > 0) {
            long j3 = 0;
            if (j2 < 0) {
                throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
            }
            Segment segment = this.head;
            if (segment == null) {
                return -1L;
            }
            if (size() - j2 >= j2) {
                while (true) {
                    long j4 = (segment.limit - segment.pos) + j3;
                    if (j4 > j2) {
                        break;
                    }
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j4;
                }
                if (segment == null) {
                    return -1L;
                }
                byte[] internalArray$okio = bytes.internalArray$okio();
                byte b = internalArray$okio[0];
                int size = bytes.size();
                long size2 = (size() - size) + 1;
                while (j3 < size2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size2) - j3);
                    i = (int) ((segment.pos + j2) - j3);
                    while (i < min) {
                        if (bArr[i] == b && okio.internal.Buffer.rangeEquals(segment, i + 1, internalArray$okio, 1, size)) {
                        }
                        i++;
                    }
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j2 = j3;
                }
                return -1L;
            }
            j3 = size();
            while (j3 > j2) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                j3 -= segment.limit - segment.pos;
            }
            if (segment == null) {
                return -1L;
            }
            byte[] internalArray$okio2 = bytes.internalArray$okio();
            byte b2 = internalArray$okio2[0];
            int size3 = bytes.size();
            long size4 = (size() - size3) + 1;
            while (j3 < size4) {
                byte[] bArr2 = segment.data;
                long j5 = size4;
                int min2 = (int) Math.min(segment.limit, (segment.pos + size4) - j3);
                i = (int) ((segment.pos + j2) - j3);
                while (i < min2) {
                    if (bArr2[i] != b2 || !okio.internal.Buffer.rangeEquals(segment, i + 1, internalArray$okio2, 1, size3)) {
                        i++;
                    }
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
                size4 = j5;
            }
            return -1L;
            return (i - segment.pos) + j3;
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j < j) {
            j2 = size();
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
                while (j2 < size()) {
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
                while (j2 < size()) {
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
            while (j2 < size()) {
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
            while (j2 < size()) {
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

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < i2 || bytes.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != bytes.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment segment2 = buffer.head;
            Intrinsics.checkNotNull(segment2);
            int i = segment.pos;
            int i2 = segment2.pos;
            long j = 0;
            while (j < size()) {
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

    public int hashCode() {
        Segment segment = this.head;
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
        } while (segment != this.head);
        return i;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() == 0) {
            return buffer;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy.prev;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(size());
        return buffer;
    }

    public final ByteString snapshot() {
        if (size() > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
        }
        return snapshot((int) size());
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(size(), 0L, i);
        Segment segment = this.head;
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
        Segment segment2 = this.head;
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
        return new C0799SegmentedByteString(bArr, iArr);
    }
}
