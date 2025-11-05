package okio.internal;

import com.facebook.widget.FacebookDialog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Socket;
import okio.Source;
/* compiled from: DefaultSocket.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lokio/internal/DefaultSocket;", "Lokio/Socket;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "getSocket", "()Ljava/net/Socket;", "closeBits", "Ljava/util/concurrent/atomic/AtomicInteger;", "source", "Lokio/Source;", "getSource", "()Lokio/Source;", "sink", "Lokio/Sink;", "getSink", "()Lokio/Sink;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "toString", "", "SocketSink", "SocketSource", "okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultSocket implements Socket {
    private AtomicInteger closeBits;
    private final Sink sink;
    private final java.net.Socket socket;
    private final Source source;

    public DefaultSocket(java.net.Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
        this.closeBits = new AtomicInteger();
        this.source = new SocketSource();
        this.sink = new SocketSink();
    }

    public final java.net.Socket getSocket() {
        return this.socket;
    }

    @Override // okio.Socket
    public Source getSource() {
        return this.source;
    }

    @Override // okio.Socket
    public Sink getSink() {
        return this.sink;
    }

    @Override // okio.Socket
    public void cancel() {
        this.socket.close();
    }

    public String toString() {
        String socket = this.socket.toString();
        Intrinsics.checkNotNullExpressionValue(socket, "toString(...)");
        return socket;
    }

    /* compiled from: DefaultSocket.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lokio/internal/DefaultSocket$SocketSink;", "Lokio/Sink;", "<init>", "(Lokio/internal/DefaultSocket;)V", "outputStream", "Ljava/io/OutputStream;", "kotlin.jvm.PlatformType", "timeout", "Lokio/internal/SocketAsyncTimeout;", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "flush", "close", "toString", "", "okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class SocketSink implements Sink {
        private final OutputStream outputStream;
        private final SocketAsyncTimeout timeout;

        public SocketSink() {
            this.outputStream = DefaultSocket.this.getSocket().getOutputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override // okio.Sink
        public void write(Buffer source, long j) {
            Intrinsics.checkNotNullParameter(source, "source");
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
            while (j > 0) {
                this.timeout.throwIfReached();
                Segment segment = source.head;
                Intrinsics.checkNotNull(segment);
                int min = (int) Math.min(j, segment.limit - segment.pos);
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        this.outputStream.write(segment.data, segment.pos, min);
                        Unit unit = Unit.INSTANCE;
                        if (!socketAsyncTimeout.exit()) {
                            segment.pos += min;
                            long j2 = min;
                            j -= j2;
                            source.setSize$okio(source.size() - j2);
                            if (segment.pos == segment.limit) {
                                source.head = segment.pop();
                                SegmentPool.recycle(segment);
                            }
                        } else {
                            throw socketAsyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e) {
                        IOException iOException = e;
                        if (socketAsyncTimeout.exit()) {
                            iOException = socketAsyncTimeout.access$newTimeoutException(iOException);
                        }
                        throw iOException;
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            socketAsyncTimeout.enter();
            try {
                this.outputStream.flush();
                Unit unit = Unit.INSTANCE;
                if (socketAsyncTimeout.exit()) {
                    throw socketAsyncTimeout.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                e = e;
                if (socketAsyncTimeout.exit()) {
                    e = socketAsyncTimeout.access$newTimeoutException(e);
                }
                throw e;
            } finally {
                socketAsyncTimeout.exit();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            socketAsyncTimeout.enter();
            try {
                int bitsOrZero = _AtomicKt.setBitsOrZero(defaultSocket.closeBits, 1);
                if (bitsOrZero != 0) {
                    if (bitsOrZero != 3) {
                        if (!defaultSocket.getSocket().isClosed() && !defaultSocket.getSocket().isOutputShutdown()) {
                            this.outputStream.flush();
                            try {
                                defaultSocket.getSocket().shutdownOutput();
                            } catch (UnsupportedOperationException unused) {
                                this.outputStream.close();
                            }
                        }
                        return;
                    }
                    defaultSocket.getSocket().close();
                    Unit unit = Unit.INSTANCE;
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                }
            } catch (IOException e) {
                e = e;
                if (socketAsyncTimeout.exit()) {
                    e = socketAsyncTimeout.access$newTimeoutException(e);
                }
                throw e;
            } finally {
                socketAsyncTimeout.exit();
            }
        }

        @Override // okio.Sink
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        public String toString() {
            return "sink(" + DefaultSocket.this.getSocket() + ')';
        }
    }

    /* compiled from: DefaultSocket.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokio/internal/DefaultSocket$SocketSource;", "Lokio/Source;", "<init>", "(Lokio/internal/DefaultSocket;)V", "inputStream", "Ljava/io/InputStream;", "kotlin.jvm.PlatformType", "timeout", "Lokio/internal/SocketAsyncTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "close", "", "toString", "", "okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class SocketSource implements Source {
        private final InputStream inputStream;
        private final SocketAsyncTimeout timeout;

        public SocketSource() {
            this.inputStream = DefaultSocket.this.getSocket().getInputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override // okio.Source
        public long read(Buffer sink, long j) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return 0L;
            }
            if (i < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            this.timeout.throwIfReached();
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int min = (int) Math.min(j, 8192 - writableSegment$okio.limit);
            try {
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    int read = this.inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, min);
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                    if (read == -1) {
                        if (writableSegment$okio.pos == writableSegment$okio.limit) {
                            sink.head = writableSegment$okio.pop();
                            SegmentPool.recycle(writableSegment$okio);
                            return -1L;
                        }
                        return -1L;
                    }
                    writableSegment$okio.limit += read;
                    long j2 = read;
                    sink.setSize$okio(sink.size() + j2);
                    return j2;
                } catch (IOException e) {
                    e = e;
                    if (socketAsyncTimeout.exit()) {
                        e = socketAsyncTimeout.access$newTimeoutException(e);
                    }
                    throw e;
                }
            } catch (AssertionError e2) {
                if (_JavaIoKt.isAndroidGetsocknameError(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            socketAsyncTimeout.enter();
            try {
                int bitsOrZero = _AtomicKt.setBitsOrZero(defaultSocket.closeBits, 2);
                if (bitsOrZero != 0) {
                    if (bitsOrZero == 3) {
                        defaultSocket.getSocket().close();
                    } else if (defaultSocket.getSocket().isClosed() || defaultSocket.getSocket().isInputShutdown()) {
                        return;
                    } else {
                        try {
                            defaultSocket.getSocket().shutdownInput();
                        } catch (UnsupportedOperationException unused) {
                            this.inputStream.close();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                }
            } catch (IOException e) {
                e = e;
                if (socketAsyncTimeout.exit()) {
                    e = socketAsyncTimeout.access$newTimeoutException(e);
                }
                throw e;
            } finally {
                socketAsyncTimeout.exit();
            }
        }

        @Override // okio.Source
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        public String toString() {
            return "source(" + DefaultSocket.this.getSocket() + ')';
        }
    }
}
