package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CipherSink.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", "", "closed", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "update", "remaining", "flush", "timeout", "Lokio/Timeout;", "close", "doFinal", "", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink sink, Cipher cipher) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.sink = sink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        if (blockSize <= 0) {
            throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
        }
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long j2 = j;
        while (j2 > 0) {
            j2 -= update(source, j2);
        }
    }

    private final int update(Buffer buffer, long j) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        int min = (int) Math.min(j, segment.limit - segment.pos);
        Buffer buffer2 = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(min);
        int i = min;
        while (outputSize > 8192) {
            int i2 = this.blockSize;
            if (i <= i2) {
                BufferedSink bufferedSink = this.sink;
                byte[] update = this.cipher.update(buffer.readByteArray(j));
                Intrinsics.checkNotNullExpressionValue(update, "update(...)");
                bufferedSink.write(update);
                return (int) j;
            }
            i -= i2;
            outputSize = this.cipher.getOutputSize(i);
        }
        Segment writableSegment$okio = buffer2.writableSegment$okio(outputSize);
        int update2 = this.cipher.update(segment.data, segment.pos, i, writableSegment$okio.data, writableSegment$okio.limit);
        writableSegment$okio.limit += update2;
        buffer2.setSize$okio(buffer2.size() + update2);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer2.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        this.sink.emitCompleteSegments();
        buffer.setSize$okio(buffer.size() - i);
        segment.pos += i;
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return i;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        Throwable doFinal = doFinal();
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (doFinal == null) {
                doFinal = th;
            }
        }
        if (doFinal != null) {
            throw doFinal;
        }
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                BufferedSink bufferedSink = this.sink;
                byte[] doFinal = this.cipher.doFinal();
                Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
                bufferedSink.write(doFinal);
                return null;
            } catch (Throwable th2) {
                return th2;
            }
        }
        Buffer buffer = this.sink.getBuffer();
        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int doFinal2 = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
            writableSegment$okio.limit += doFinal2;
            buffer.setSize$okio(buffer.size() + doFinal2);
        } catch (Throwable th3) {
            th = th3;
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        return th;
    }
}
