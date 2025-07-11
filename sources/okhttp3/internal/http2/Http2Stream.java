package okhttp3.internal.http2;

import com.facebook.widget.FacebookDialog;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;
/* compiled from: Http2Stream.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0004`abcB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020\bJ\b\u0010C\u001a\u0004\u0018\u00010\u000bJ$\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bJ\u000e\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020\u000bJ\u0006\u0010+\u001a\u00020LJ\u0006\u0010/\u001a\u00020LJ\u0018\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108J\b\u0010O\u001a\u00020EH\u0016J\u000e\u0010P\u001a\u00020E2\u0006\u00101\u001a\u000202J\u001a\u0010Q\u001a\u00020\b2\u0006\u00101\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0016\u0010R\u001a\u00020E2\u0006\u0010#\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0004J\u0016\u0010U\u001a\u00020E2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010V\u001a\u00020E2\u0006\u00101\u001a\u000202J\b\u0010W\u001a\u00020\bH\u0002J\r\u0010X\u001a\u00020EH\u0000¢\u0006\u0002\bYJ\u000e\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u0017J\r\u0010\\\u001a\u00020EH\u0000¢\u0006\u0002\b]J\r\u0010^\u001a\u00020EH\u0000¢\u0006\u0002\b_R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\u00060$R\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010'\u001a\u00060(R\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010+\u001a\u00060,R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00060,R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u001e\u00101\u001a\u0004\u0018\u0001028@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b?\u0010>R\u0011\u0010@\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b@\u0010>¨\u0006d"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "Lokhttp3/internal/concurrent/Lockable;", "Lokio/Socket;", "id", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getId", "()I", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "readBytes", "Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "getReadBytes", "()Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "value", "", "writeBytesTotal", "getWriteBytesTotal", "()J", "setWriteBytesTotal$okhttp", "(J)V", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "headersQueue", "Ljava/util/ArrayDeque;", "hasResponseHeaders", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "writeTimeout", "getWriteTimeout$okhttp", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "isOpen", "()Z", "isLocallyInitiated", "isSourceComplete", "takeHeaders", "callerIsIdle", "peekTrailers", "writeHeaders", "", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "enqueueTrailers", "trailers", "Lokio/Timeout;", "close", "rstStatusCode", FacebookDialog.COMPLETION_GESTURE_CANCEL, "closeLater", "closeInternal", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "doReadTimeout", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "addBytesToWriteWindow", "delta", "checkOutNotClosed", "checkOutNotClosed$okhttp", "waitForIo", "waitForIo$okhttp", "FramingSource", "FramingSink", "Companion", "StreamTimeout", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Http2Stream implements Lockable, Socket {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private final WindowCounter readBytes;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    public Http2Stream(int i, Http2Connection connection, boolean z, boolean z2, Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = i;
        this.connection = connection;
        this.readBytes = new WindowCounter(i);
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(connection.getOkHttpSettings().getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers != null) {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        } else if (!isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final int getId() {
        return this.id;
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final void setWriteBytesTotal$okhttp(long j) {
        this.writeBytesTotal = j;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final void setWriteBytesMaximum$okhttp(long j) {
        this.writeBytesMaximum = j;
    }

    @Override // okio.Socket
    public FramingSource getSource() {
        return this.source;
    }

    @Override // okio.Socket
    public FramingSink getSink() {
        return this.sink;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final ErrorCode getErrorCode$okhttp() {
        ErrorCode errorCode;
        synchronized (this) {
            errorCode = this.errorCode;
        }
        return errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final boolean isOpen() {
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            if ((getSource().getFinished$okhttp() || getSource().getClosed$okhttp()) && (getSink().getFinished() || getSink().getClosed())) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.id & 1) == 1);
    }

    public final boolean isSourceComplete() {
        boolean z;
        synchronized (this) {
            if (getSource().getFinished$okhttp()) {
                z = getSource().getReadBuffer().exhausted();
            }
        }
        return z;
    }

    public static /* synthetic */ Headers takeHeaders$default(Http2Stream http2Stream, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = false;
        }
        return http2Stream.takeHeaders(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x000c, B:9:0x0014, B:15:0x0020, B:18:0x002a, B:23:0x0039, B:25:0x0043, B:28:0x0052, B:30:0x0056, B:32:0x0066, B:31:0x0059, B:16:0x0025), top: B:36:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Headers takeHeaders(boolean z) throws IOException {
        Headers headers;
        boolean z2;
        synchronized (this) {
            while (this.headersQueue.isEmpty() && getErrorCode$okhttp() == null) {
                if (!z && !doReadTimeout()) {
                    z2 = false;
                    if (z2) {
                        this.readTimeout.enter();
                    }
                    waitForIo$okhttp();
                    if (!z2) {
                        this.readTimeout.exitAndThrowIfTimedOut();
                    }
                }
                z2 = true;
                if (z2) {
                }
                waitForIo$okhttp();
                if (!z2) {
                }
            }
            if (!this.headersQueue.isEmpty()) {
                Headers removeFirst = this.headersQueue.removeFirst();
                Intrinsics.checkNotNullExpressionValue(removeFirst, "removeFirst(...)");
                headers = removeFirst;
            } else {
                Throwable th = this.errorException;
                if (th == null) {
                    ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                    Intrinsics.checkNotNull(errorCode$okhttp);
                    th = new StreamResetException(errorCode$okhttp);
                }
                throw th;
            }
        }
        return headers;
    }

    public final Headers peekTrailers() throws IOException {
        synchronized (this) {
            if (getSource().getFinished$okhttp() && getSource().getReceiveBuffer().exhausted() && getSource().getReadBuffer().exhausted()) {
                Headers trailers = getSource().getTrailers();
                if (trailers == null) {
                    trailers = Headers.EMPTY;
                }
                return trailers;
            } else if (getErrorCode$okhttp() != null) {
                Throwable th = this.errorException;
                if (th == null) {
                    ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                    Intrinsics.checkNotNull(errorCode$okhttp);
                    th = new StreamResetException(errorCode$okhttp);
                }
                throw th;
            } else {
                return null;
            }
        }
    }

    public final void writeHeaders(List<Header> responseHeaders, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Http2Stream http2Stream = this;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }
        synchronized (http2Stream) {
            this.hasResponseHeaders = true;
            if (z) {
                getSink().setFinished(true);
                Http2Stream http2Stream2 = this;
                Intrinsics.checkNotNull(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                http2Stream2.notifyAll();
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!z2) {
            synchronized (http2Stream) {
                z2 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        this.connection.writeHeaders$okhttp(this.id, z, responseHeaders);
        if (z2) {
            this.connection.flush();
        }
    }

    public final void enqueueTrailers(Headers trailers) {
        Intrinsics.checkNotNullParameter(trailers, "trailers");
        synchronized (this) {
            if (getSink().getFinished()) {
                throw new IllegalStateException("already finished".toString());
            }
            if (trailers.size() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            getSink().setTrailers(trailers);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public final void close(ErrorCode rstStatusCode, IOException iOException) throws IOException {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (closeInternal(rstStatusCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
        }
    }

    @Override // okio.Socket
    public void cancel() {
        closeLater(ErrorCode.CANCEL);
    }

    public final void closeLater(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        Http2Stream http2Stream = this;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }
        synchronized (http2Stream) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            Http2Stream http2Stream2 = this;
            Intrinsics.checkNotNull(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
            http2Stream2.notifyAll();
            if (getSource().getFinished$okhttp() && getSink().getFinished()) {
                return false;
            }
            Unit unit = Unit.INSTANCE;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void receiveData(BufferedSource source, int i) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Http2Stream http2Stream = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
            getSource().receive$okhttp(source, i);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:10:0x003b, B:12:0x0040, B:14:0x0048, B:17:0x0051, B:20:0x0064, B:21:0x006b, B:18:0x0059), top: B:29:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void receiveHeaders(Headers headers, boolean z) {
        boolean isOpen;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Http2Stream http2Stream = this;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }
        synchronized (http2Stream) {
            if (this.hasResponseHeaders && headers.get(Header.RESPONSE_STATUS_UTF8) == null && headers.get(Header.TARGET_METHOD_UTF8) == null) {
                getSource().setTrailers(headers);
                if (z) {
                    getSource().setFinished$okhttp(true);
                }
                isOpen = isOpen();
                Http2Stream http2Stream2 = this;
                Intrinsics.checkNotNull(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                http2Stream2.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            this.hasResponseHeaders = true;
            this.headersQueue.add(headers);
            if (z) {
            }
            isOpen = isOpen();
            Http2Stream http2Stream22 = this;
            Intrinsics.checkNotNull(http2Stream22, "null cannot be cast to non-null type java.lang.Object");
            http2Stream22.notifyAll();
            Unit unit2 = Unit.INSTANCE;
        }
        if (isOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final void receiveRstStream(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        synchronized (this) {
            if (getErrorCode$okhttp() == null) {
                this.errorCode = errorCode;
                Http2Stream http2Stream = this;
                Intrinsics.checkNotNull(http2Stream, "null cannot be cast to non-null type java.lang.Object");
                http2Stream.notifyAll();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doReadTimeout() {
        return !this.connection.getClient$okhttp() || getSink().getClosed() || getSink().getFinished();
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0003H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006'"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "getFinished$okhttp", "()Z", "setFinished$okhttp", "(Z)V", "receiveBuffer", "Lokio/Buffer;", "getReceiveBuffer", "()Lokio/Buffer;", "readBuffer", "getReadBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed$okhttp", "setClosed$okhttp", "read", "sink", "byteCount", "updateConnectionFlowControl", "", "receive", "source", "Lokio/BufferedSource;", "receive$okhttp", "timeout", "Lokio/Timeout;", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private Headers trailers;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00f7, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer sink, long j) throws IOException {
            StreamResetException streamResetException;
            boolean z;
            long j2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j3 = 0;
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            while (true) {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    boolean doReadTimeout = http2Stream.doReadTimeout();
                    if (doReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().enter();
                    }
                    if (http2Stream.getErrorCode$okhttp() == null || this.finished) {
                        streamResetException = null;
                    } else {
                        streamResetException = http2Stream.getErrorException$okhttp();
                        if (streamResetException == null) {
                            ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                            Intrinsics.checkNotNull(errorCode$okhttp);
                            streamResetException = new StreamResetException(errorCode$okhttp);
                        }
                    }
                    if (this.closed) {
                        break;
                    }
                    z = false;
                    if (this.readBuffer.size() > j3) {
                        Buffer buffer = this.readBuffer;
                        j2 = buffer.read(sink, Math.min(j, buffer.size()));
                        WindowCounter.update$default(http2Stream.getReadBytes(), j2, 0L, 2, null);
                        long unacknowledged = http2Stream.getReadBytes().getUnacknowledged();
                        if (streamResetException == null && unacknowledged >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                            http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), unacknowledged);
                            WindowCounter.update$default(http2Stream.getReadBytes(), 0L, unacknowledged, 1, null);
                        }
                    } else {
                        if (!this.finished && streamResetException == null) {
                            http2Stream.waitForIo$okhttp();
                            z = true;
                        }
                        j2 = -1;
                    }
                    if (doReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                    }
                    Unit unit = Unit.INSTANCE;
                }
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.size());
                if (!z) {
                    if (j2 != -1) {
                        return j2;
                    }
                    if (streamResetException == null) {
                        return -1L;
                    }
                    throw streamResetException;
                }
                j3 = 0;
            }
        }

        private final void updateConnectionFlowControl(long j) {
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public final void receive$okhttp(BufferedSource source, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                long j2 = j;
                while (j2 > 0) {
                    synchronized (Http2Stream.this) {
                        z = this.finished;
                        z2 = true;
                        z3 = this.readBuffer.size() + j2 > this.maxByteCount;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (z3) {
                        source.skip(j2);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        source.skip(j2);
                        return;
                    } else {
                        long read = source.read(this.receiveBuffer, j2);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        j2 -= read;
                        Http2Stream http2Stream2 = Http2Stream.this;
                        synchronized (http2Stream2) {
                            if (this.closed) {
                                this.receiveBuffer.clear();
                            } else {
                                if (this.readBuffer.size() != 0) {
                                    z2 = false;
                                }
                                this.readBuffer.writeAll(this.receiveBuffer);
                                if (z2) {
                                    Http2Stream http2Stream3 = http2Stream2;
                                    Intrinsics.checkNotNull(http2Stream3, "null cannot be cast to non-null type java.lang.Object");
                                    http2Stream3.notifyAll();
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
                updateConnectionFlowControl(j);
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.size());
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                Http2Stream http2Stream2 = http2Stream;
                Intrinsics.checkNotNull(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                http2Stream2.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z;
        boolean isOpen;
        Http2Stream http2Stream = this;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }
        synchronized (http2Stream) {
            z = !getSource().getFinished$okhttp() && getSource().getClosed$okhttp() && (getSink().getFinished() || getSink().getClosed());
            isOpen = isOpen();
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else if (isOpen) {
        } else {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006 "}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "getFinished", "()Z", "setFinished", "(Z)V", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed", "setClosed", "write", "", "source", "byteCount", "", "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lokio/Timeout;", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        private Headers trailers;

        public FramingSink(boolean z) {
            this.finished = z;
            this.sendBuffer = new Buffer();
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Sink
        public void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(source, j);
                while (this.sendBuffer.size() >= 16384) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        private final void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                    http2Stream.waitForIo$okhttp();
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                z2 = z && min == this.sendBuffer.size();
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z2, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    http2Stream2.checkOutNotClosed$okhttp();
                    Unit unit = Unit.INSTANCE;
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    Http2Stream.this.getConnection().flush();
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    if (this.closed) {
                        return;
                    }
                    boolean z = http2Stream2.getErrorCode$okhttp() == null;
                    Unit unit = Unit.INSTANCE;
                    if (!Http2Stream.this.getSink().finished) {
                        boolean z2 = this.sendBuffer.size() > 0;
                        if (this.trailers != null) {
                            while (this.sendBuffer.size() > 0) {
                                emitFrame(false);
                            }
                            Http2Connection connection = Http2Stream.this.getConnection();
                            int id = Http2Stream.this.getId();
                            Headers headers = this.trailers;
                            Intrinsics.checkNotNull(headers);
                            connection.writeHeaders$okhttp(id, z, _UtilJvmKt.toHeaderList(headers));
                        } else if (z2) {
                            while (this.sendBuffer.size() > 0) {
                                emitFrame(true);
                            }
                        } else if (z) {
                            Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                        }
                    }
                    Http2Stream http2Stream3 = Http2Stream.this;
                    synchronized (http2Stream3) {
                        this.closed = true;
                        Http2Stream http2Stream4 = http2Stream3;
                        Intrinsics.checkNotNull(http2Stream4, "null cannot be cast to non-null type java.lang.Object");
                        http2Stream4.notifyAll();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Http2Stream.this.getConnection().flush();
                    Http2Stream.this.cancelStreamIfNecessary$okhttp();
                    return;
                }
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "<init>", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void addBytesToWriteWindow(long j) {
        this.writeBytesMaximum += j;
        if (j > 0) {
            Http2Stream http2Stream = this;
            Intrinsics.checkNotNull(http2Stream, "null cannot be cast to non-null type java.lang.Object");
            http2Stream.notifyAll();
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (getSink().getClosed()) {
            throw new IOException("stream closed");
        }
        if (getSink().getFinished()) {
            throw new IOException("stream finished");
        }
        if (getErrorCode$okhttp() != null) {
            Throwable th = this.errorException;
            if (th == null) {
                ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                Intrinsics.checkNotNull(errorCode$okhttp);
                th = new StreamResetException(errorCode$okhttp);
            }
            throw th;
        }
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            Http2Stream http2Stream = this;
            Intrinsics.checkNotNull(http2Stream, "null cannot be cast to non-null type java.lang.Object");
            http2Stream.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "timedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "exitAndThrowIfTimedOut", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}
