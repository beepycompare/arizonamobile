package okhttp3.internal.http2;

import androidx.collection.SieveCacheKt;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
/* compiled from: Http2Writer.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0006\u0010\u001d\u001a\u00020\u0013J\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\fJ(\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\fJ(\u0010&\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0016J\u001e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fJ\u001e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u000201J\u0016\u00102\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00103\u001a\u000204J&\u00105\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fJ\b\u00108\u001a\u00020\u0013H\u0016J\u0018\u00109\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010%\u001a\u000204H\u0002J$\u0010:\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006="}, d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "Lokhttp3/internal/concurrent/Lockable;", "sink", "Lokio/BufferedSink;", "client", "", "<init>", "(Lokio/BufferedSink;Z)V", "hpackBuffer", "Lokio/Buffer;", "maxFrameSize", "", "closed", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "connectionPreface", "", "applyAndAckSettings", "peerSettings", "Lokhttp3/internal/http2/Settings;", "pushPromise", "streamId", "promisedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "flush", "rstStream", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "maxDataLength", "data", "outFinished", "source", "byteCount", "dataFrame", DownloaderServiceMarshaller.PARAMS_FLAGS, "buffer", "settings", "ping", "ack", "payload1", "payload2", "goAway", "lastGoodStreamId", "debugData", "", "windowUpdate", "windowSizeIncrement", "", "frameHeader", "length", "type", "close", "writeContinuationFrames", "headers", "headerBlock", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Http2Writer implements Closeable, Lockable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(BufferedSink sink, boolean z) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void connectionPreface() throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void applyAndAckSettings(Settings peerSettings) throws IOException {
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void pushPromise(int i, int i2, List<Header> requestHeaders) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(requestHeaders);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize - 4, size);
            int i3 = min + 4;
            long j = min;
            int i4 = (size > j ? 1 : (size == j ? 0 : -1));
            frameHeader(i, i3, 5, i4 == 0 ? 4 : 0);
            this.sink.writeInt(i2 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j);
            if (i4 > 0) {
                writeContinuationFrames(i, size - j);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void flush() throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void rstStream(int i, ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            frameHeader(i, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            dataFrame(i, z ? 1 : 0, buffer, i2);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void dataFrame(int i, int i2, Buffer buffer, int i3) throws IOException {
        frameHeader(i, i3, 0, i2);
        if (i3 > 0) {
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(buffer);
            bufferedSink.write(buffer, i3);
        }
    }

    public final void settings(Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, settings.size() * 6, 4, 0);
            for (int i = 0; i < 10; i++) {
                if (settings.isSet(i)) {
                    this.sink.writeShort(i);
                    this.sink.writeInt(settings.get(i));
                }
            }
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void ping(boolean z, int i, int i2) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, 6, z ? 1 : 0);
            this.sink.writeInt(i);
            this.sink.writeInt(i2);
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void goAway(int i, ErrorCode errorCode, byte[] debugData) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
            frameHeader(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(i);
            this.sink.writeInt(errorCode.getHttpCode());
            if (!(debugData.length == 0)) {
                this.sink.write(debugData);
            }
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void windowUpdate(int i, long j) throws IOException {
        int i2;
        long j2;
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (j == 0 || j > SieveCacheKt.NodeLinkMask) {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
            }
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                i2 = i;
                j2 = j;
                logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(false, i2, 4, j2));
            } else {
                i2 = i;
                j2 = j;
            }
            frameHeader(i2, 4, 8, 0);
            this.sink.writeInt((int) j2);
            this.sink.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void frameHeader(int i, int i2, int i3, int i4) throws IOException {
        int i5;
        int i6;
        int i7;
        int i8;
        if (i3 != 8) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                i5 = i;
                i6 = i2;
                i7 = i3;
                i8 = i4;
                logger2.fine(Http2.INSTANCE.frameLog(false, i5, i6, i7, i8));
                if (i6 <= this.maxFrameSize) {
                    throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i6).toString());
                }
                if ((Integer.MIN_VALUE & i5) != 0) {
                    throw new IllegalArgumentException(("reserved bit set: " + i5).toString());
                }
                _UtilCommonKt.writeMedium(this.sink, i6);
                this.sink.writeByte(i7 & 255);
                this.sink.writeByte(i8 & 255);
                this.sink.writeInt(Integer.MAX_VALUE & i5);
                return;
            }
        }
        i5 = i;
        i6 = i2;
        i7 = i3;
        i8 = i4;
        if (i6 <= this.maxFrameSize) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void writeContinuationFrames(int i, long j) throws IOException {
        while (j > 0) {
            long min = Math.min(this.maxFrameSize, j);
            j -= min;
            frameHeader(i, (int) min, 9, j == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final void headers(boolean z, int i, List<Header> headerBlock) throws IOException {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(headerBlock);
            long size = this.hpackBuffer.size();
            long min = Math.min(this.maxFrameSize, size);
            int i2 = (size > min ? 1 : (size == min ? 0 : -1));
            int i3 = i2 == 0 ? 4 : 0;
            if (z) {
                i3 |= 1;
            }
            frameHeader(i, (int) min, 1, i3);
            this.sink.write(this.hpackBuffer, min);
            if (i2 > 0) {
                writeContinuationFrames(i, size - min);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* compiled from: Http2Writer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "<init>", "()V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
