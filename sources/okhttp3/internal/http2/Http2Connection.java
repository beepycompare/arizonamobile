package okhttp3.internal.http2;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.FlowControlListener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
/* compiled from: Http2Connection.kt */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¡\u00012\u00020\u00012\u00020\u0002:\b\u009e\u0001\u009f\u0001 \u0001¡\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010V\u001a\u00020\u0011J\u0010\u0010W\u001a\u0004\u0018\u00010\u00122\u0006\u0010X\u001a\u00020\u0011J\u0017\u0010Y\u001a\u0004\u0018\u00010\u00122\u0006\u0010Z\u001a\u00020\u0011H\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020+H\u0000¢\u0006\u0002\b_J$\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\bJ\u001c\u0010f\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\bJ&\u0010f\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\bH\u0002J+\u0010g\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\b2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0002\bjJ(\u0010k\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\b2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020+J\u001d\u0010o\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010p\u001a\u00020qH\u0000¢\u0006\u0002\brJ\u001d\u0010s\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010t\u001a\u00020qH\u0000¢\u0006\u0002\buJ\u001d\u0010v\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010w\u001a\u00020+H\u0000¢\u0006\u0002\bxJ\u001e\u0010y\u001a\u00020]2\u0006\u0010z\u001a\u00020\b2\u0006\u0010{\u001a\u00020\u00112\u0006\u0010|\u001a\u00020\u0011J\u0006\u0010}\u001a\u00020]J\u0006\u0010y\u001a\u00020]J\u0006\u0010~\u001a\u00020]J\u0006\u0010\u007f\u001a\u00020]J\u000f\u0010\u0080\u0001\u001a\u00020]2\u0006\u0010t\u001a\u00020qJ\t\u0010\u0081\u0001\u001a\u00020]H\u0016J-\u0010\u0081\u0001\u001a\u00020]2\u0007\u0010\u0082\u0001\u001a\u00020q2\u0007\u0010\u0083\u0001\u001a\u00020q2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0000¢\u0006\u0003\b\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020]2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\u0014\u0010\u0089\u0001\u001a\u00020]2\t\b\u0002\u0010\u008a\u0001\u001a\u00020\bH\u0007J\u0010\u0010\u008b\u0001\u001a\u00020]2\u0007\u0010\u008c\u0001\u001a\u000207J\u0010\u0010\u008d\u0001\u001a\u00020\b2\u0007\u0010\u008e\u0001\u001a\u00020+J\u000f\u0010\u008f\u0001\u001a\u00020]H\u0000¢\u0006\u0003\b\u0090\u0001J\u0017\u0010\u0091\u0001\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u0011H\u0000¢\u0006\u0003\b\u0092\u0001J%\u0010\u0093\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0003\b\u0094\u0001J.\u0010\u0095\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b\u0097\u0001J2\u0010\u0098\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0006\u0010n\u001a\u00020\u00112\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b\u009b\u0001J\u001f\u0010\u009c\u0001\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00112\u0006\u0010p\u001a\u00020qH\u0000¢\u0006\u0003\b\u009d\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u000203X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00109\"\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001e\u0010C\u001a\u00020+2\u0006\u0010B\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020+2\u0006\u0010B\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010L\u001a\u00020M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0015\u0010P\u001a\u00060QR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00110UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "Lokhttp3/internal/concurrent/Lockable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "client", "", "getClient$okhttp", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "streams", "", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "isShutdown", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writerQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "pushQueue", "settingsListenerQueue", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "intervalPingsSent", "", "intervalPongsReceived", "degradedPingsSent", "degradedPongsReceived", "awaitPingsSent", "awaitPongsReceived", "degradedPongDeadlineNs", "flowControlListener", "Lokhttp3/internal/http2/FlowControlListener;", "getFlowControlListener$okhttp", "()Lokhttp3/internal/http2/FlowControlListener;", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "readBytes", "Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "getReadBytes", "()Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "value", "writeBytesTotal", "getWriteBytesTotal", "()J", "writeBytesMaximum", "getWriteBytesMaximum", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "currentPushRequests", "", "openStreamCount", "getStream", "id", "removeStream", "streamId", "removeStream$okhttp", "updateConnectionFlowControl", "", "read", "updateConnectionFlowControl$okhttp", "pushStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "newStream", "writeHeaders", "outFinished", "alternating", "writeHeaders$okhttp", "writeData", "buffer", "Lokio/Buffer;", "byteCount", "writeSynResetLater", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "writeSynResetLater$okhttp", "writeSynReset", "statusCode", "writeSynReset$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "awaitPong", "flush", "shutdown", "close", "connectionCode", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", TtmlNode.START, "sendConnectionPreface", "setSettings", "settings", "isHealthy", "nowNs", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "pushedStream", "pushedStream$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushHeadersLater", "inFinished", "pushHeadersLater$okhttp", "pushDataLater", "source", "Lokio/BufferedSource;", "pushDataLater$okhttp", "pushResetLater", "pushResetLater$okhttp", "Builder", "ReaderRunnable", "Listener", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Http2Connection implements Closeable, Lockable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private final FlowControlListener flowControlListener;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private final WindowCounter readBytes;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    public final boolean pushedStream$okhttp(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public final void start() throws IOException {
        start$default(this, false, 1, null);
    }

    public Http2Connection(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        this.flowControlListener = builder.getFlowControlListener$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(4, 16777216);
        }
        this.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.readBytes = new WindowCounter(0);
        this.writeBytesMaximum = this.peerSettings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            newQueue.schedule(connectionName$okhttp + " ping", nanos, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    long _init_$lambda$2;
                    _init_$lambda$2 = Http2Connection._init_$lambda$2(Http2Connection.this, nanos);
                    return Long.valueOf(_init_$lambda$2);
                }
            });
        }
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final FlowControlListener getFlowControlListener$okhttp() {
        return this.flowControlListener;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public static final long _init_$lambda$2(Http2Connection http2Connection, long j) {
        boolean z;
        synchronized (http2Connection) {
            long j2 = http2Connection.intervalPongsReceived;
            long j3 = http2Connection.intervalPingsSent;
            if (j2 < j3) {
                z = true;
            } else {
                http2Connection.intervalPingsSent = j3 + 1;
                z = false;
            }
        }
        if (z) {
            http2Connection.failConnection(null);
            return -1L;
        }
        http2Connection.writePing(false, 1, 0);
        return j;
    }

    public final int openStreamCount() {
        int size;
        synchronized (this) {
            size = this.streams.size();
        }
        return size;
    }

    public final Http2Stream getStream(int i) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = this.streams.get(Integer.valueOf(i));
        }
        return http2Stream;
    }

    public final void updateConnectionFlowControl$okhttp(long j) {
        synchronized (this) {
            WindowCounter.update$default(this.readBytes, j, 0L, 2, null);
            long unacknowledged = this.readBytes.getUnacknowledged();
            if (unacknowledged >= this.okHttpSettings.getInitialWindowSize() / 2) {
                writeWindowUpdateLater$okhttp(0, unacknowledged);
                WindowCounter.update$default(this.readBytes, 0L, unacknowledged, 1, null);
            }
            this.flowControlListener.receivingConnectionWindowChanged(this.readBytes);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Http2Stream pushStream(int i, List<Header> requestHeaders, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.".toString());
        }
        return newStream(i, requestHeaders, z);
    }

    public final Http2Stream newStream(List<Header> requestHeaders, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x005e A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:98:0x005b, B:100:0x005e, B:104:0x006d, B:101:0x0064, B:103:0x0068, B:109:0x0078, B:110:0x0083, B:119:0x0090, B:120:0x0091), top: B:128:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0064 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:98:0x005b, B:100:0x005e, B:104:0x006d, B:101:0x0064, B:103:0x0068, B:109:0x0078, B:110:0x0083, B:119:0x0090, B:120:0x0091), top: B:128:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0050 A[Catch: all -> 0x008b, TryCatch #3 {all -> 0x008b, blocks: (B:85:0x002d, B:87:0x0032, B:89:0x003a, B:94:0x004a, B:96:0x0050, B:97:0x0059, B:112:0x0085, B:113:0x008a), top: B:133:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Http2Stream newStream(int i, List<Header> list, boolean z) throws IOException {
        Throwable th;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.writer) {
            try {
                try {
                    synchronized (this) {
                        try {
                            if (this.nextStreamId > 1073741823) {
                                try {
                                    shutdown(ErrorCode.REFUSED_STREAM);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            try {
                                if (this.isShutdown) {
                                    throw new ConnectionShutdownException();
                                }
                                int i2 = this.nextStreamId;
                                this.nextStreamId = i2 + 2;
                                Http2Stream http2Stream = new Http2Stream(i2, this, z3, false, null);
                                if (z && this.writeBytesTotal < this.writeBytesMaximum && http2Stream.getWriteBytesTotal() < http2Stream.getWriteBytesMaximum()) {
                                    z2 = false;
                                    if (http2Stream.isOpen()) {
                                        this.streams.put(Integer.valueOf(i2), http2Stream);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    if (i != 0) {
                                        this.writer.headers(z3, i2, list);
                                    } else if (this.client) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                                    } else {
                                        this.writer.pushPromise(i, i2, list);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                    if (z2) {
                                        this.writer.flush();
                                    }
                                    return http2Stream;
                                }
                                z2 = true;
                                if (http2Stream.isOpen()) {
                                }
                                Unit unit3 = Unit.INSTANCE;
                                if (i != 0) {
                                }
                                Unit unit22 = Unit.INSTANCE;
                                if (z2) {
                                }
                                return http2Stream;
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public final void writeHeaders$okhttp(int i, boolean z, List<Header> alternating) throws IOException {
        Intrinsics.checkNotNullParameter(alternating, "alternating");
        this.writer.headers(z, i, alternating);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x003e, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0040, code lost:
        r4 = java.lang.Math.min((int) java.lang.Math.min(r13, r6 - r4), r9.writer.maxDataLength());
        r7 = r4;
        r9.writeBytesTotal += r7;
        r5 = kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        loop0: while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j3 = this.writeBytesTotal;
                        long j4 = this.writeBytesMaximum;
                        if (j3 < j4) {
                            break;
                        } else if (!this.streams.containsKey(Integer.valueOf(i))) {
                            break loop0;
                        } else {
                            Http2Connection http2Connection = this;
                            Intrinsics.checkNotNull(http2Connection, "null cannot be cast to non-null type java.lang.Object");
                            http2Connection.wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            j -= j2;
            this.writer.data(z && j == 0, i, buffer, min);
        }
    }

    public final void writeSynResetLater$okhttp(final int i, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.writerQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + i + "] writeSynReset", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit writeSynResetLater$lambda$12;
                writeSynResetLater$lambda$12 = Http2Connection.writeSynResetLater$lambda$12(Http2Connection.this, i, errorCode);
                return writeSynResetLater$lambda$12;
            }
        }, 6, null);
    }

    public static final Unit writeSynResetLater$lambda$12(Http2Connection http2Connection, int i, ErrorCode errorCode) {
        try {
            http2Connection.writeSynReset$okhttp(i, errorCode);
        } catch (IOException e) {
            http2Connection.failConnection(e);
        }
        return Unit.INSTANCE;
    }

    public final void writeSynReset$okhttp(int i, ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.writer.rstStream(i, statusCode);
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + i + "] windowUpdate", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit writeWindowUpdateLater$lambda$13;
                writeWindowUpdateLater$lambda$13 = Http2Connection.writeWindowUpdateLater$lambda$13(Http2Connection.this, i, j);
                return writeWindowUpdateLater$lambda$13;
            }
        }, 6, null);
    }

    public static final Unit writeWindowUpdateLater$lambda$13(Http2Connection http2Connection, int i, long j) {
        try {
            http2Connection.writer.windowUpdate(i, j);
        } catch (IOException e) {
            http2Connection.failConnection(e);
        }
        return Unit.INSTANCE;
    }

    public final void writePing(boolean z, int i, int i2) {
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final void awaitPong() throws InterruptedException {
        synchronized (this) {
            while (this.awaitPongsReceived < this.awaitPingsSent) {
                Http2Connection http2Connection = this;
                Intrinsics.checkNotNull(http2Connection, "null cannot be cast to non-null type java.lang.Object");
                http2Connection.wait();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.writer) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                intRef.element = this.lastGoodStreamId;
                Unit unit = Unit.INSTANCE;
                this.writer.goAway(intRef.element, statusCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int i;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        Http2Connection http2Connection = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Connection)) {
            try {
                shutdown(connectionCode);
            } catch (IOException unused) {
            }
            synchronized (http2Connection) {
                if (this.streams.isEmpty()) {
                    objArr = null;
                } else {
                    objArr = this.streams.values().toArray(new Http2Stream[0]);
                    this.streams.clear();
                }
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) objArr;
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    try {
                        http2Stream.close(streamCode, iOException);
                    } catch (IOException unused2) {
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException unused3) {
            }
            try {
                this.socket.close();
            } catch (IOException unused4) {
            }
            this.writerQueue.shutdown();
            this.pushQueue.shutdown();
            this.settingsListenerQueue.shutdown();
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Connection);
    }

    public final void failConnection(IOException iOException) {
        close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        http2Connection.start(z);
    }

    public final void start(boolean z) throws IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - 65535);
            }
        }
        TaskQueue.execute$default(this.taskRunner.newQueue(), this.connectionName, 0L, false, this.readerRunnable, 6, null);
    }

    public final void setSettings(Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                Unit unit = Unit.INSTANCE;
            }
            this.writer.settings(settings);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final boolean isHealthy(long j) {
        synchronized (this) {
            if (this.isShutdown) {
                return false;
            }
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                if (j >= this.degradedPongDeadlineNs) {
                    return false;
                }
            }
            return true;
        }
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j2 = this.degradedPingsSent;
            if (j < j2) {
                return;
            }
            this.degradedPingsSent = j2 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
            Unit unit = Unit.INSTANCE;
            TaskQueue.execute$default(this.writerQueue, this.connectionName + " ping", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit sendDegradedPingLater$lambda$28;
                    sendDegradedPingLater$lambda$28 = Http2Connection.sendDegradedPingLater$lambda$28(Http2Connection.this);
                    return sendDegradedPingLater$lambda$28;
                }
            }, 6, null);
        }
    }

    public static final Unit sendDegradedPingLater$lambda$28(Http2Connection http2Connection) {
        http2Connection.writePing(false, 2, 0);
        return Unit.INSTANCE;
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010>\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020!H\u0007J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J\u000e\u00102\u001a\u00020\u00002\u0006\u00102\u001a\u000203J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0006\u0010?\u001a\u00020@R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "flowControlListener", "Lokhttp3/internal/http2/FlowControlListener;", "getFlowControlListener$okhttp", "()Lokhttp3/internal/http2/FlowControlListener;", "setFlowControlListener$okhttp", "(Lokhttp3/internal/http2/FlowControlListener;)V", "peerName", "build", "Lokhttp3/internal/http2/Http2Connection;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private FlowControlListener flowControlListener;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public final Builder socket(Socket socket) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String peerName) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            return socket$default(this, socket, peerName, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String peerName, BufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            return socket$default(this, socket, peerName, source, null, 8, null);
        }

        public Builder(boolean z, TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = z;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.flowControlListener = FlowControlListener.None.INSTANCE;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final void setSocket$okhttp(Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final void setConnectionName$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final void setSource$okhttp(BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final void setSink$okhttp(BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "<set-?>");
            this.listener = listener;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final FlowControlListener getFlowControlListener$okhttp() {
            return this.flowControlListener;
        }

        public final void setFlowControlListener$okhttp(FlowControlListener flowControlListener) {
            Intrinsics.checkNotNullParameter(flowControlListener, "<set-?>");
            this.flowControlListener = flowControlListener;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i, Object obj) throws IOException {
            if ((i & 2) != 0) {
                str = _UtilJvmKt.peerName(socket);
            }
            if ((i & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        public final Builder socket(Socket socket, String peerName, BufferedSource source, BufferedSink sink) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            setSocket$okhttp(socket);
            setConnectionName$okhttp(this.client ? _UtilJvmKt.okHttpName + ' ' + peerName : "MockWebServer " + peerName);
            setSource$okhttp(source);
            setSink$okhttp(sink);
            return this;
        }

        public final Builder listener(Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public final Builder flowControlListener(FlowControlListener flowControlListener) {
            Intrinsics.checkNotNullParameter(flowControlListener, "flowControlListener");
            this.flowControlListener = flowControlListener;
            return this;
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003H\u0096\u0002J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J.\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u0003H\u0016J \u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J \u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\rH\u0016J&\u0010/\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J8\u00102\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020'2\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020*H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u00069"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "reader", "Lokhttp3/internal/http2/Http2Reader;", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "invoke", "data", "inFinished", "", "streamId", "", "source", "Lokio/BufferedSource;", "length", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "rstStream", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "applyAndAckSettings", "ackSettings", "ping", "ack", "payload1", "payload2", "goAway", "lastGoodStreamId", "debugData", "Lokio/ByteString;", "windowUpdate", "windowSizeIncrement", "", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "alternateService", "origin", "", "protocol", "host", "port", "maxAge", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String origin, ByteString protocol, String host, int i2, long j) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(host, "host");
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.this$0 = http2Connection;
            this.reader = reader;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v8, types: [okhttp3.internal.http2.ErrorCode] */
        /* renamed from: invoke */
        public void invoke2() {
            ErrorCode errorCode;
            Http2Reader http2Reader = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    do {
                    } while (this.reader.nextFrame(false, this));
                    http2Reader = ErrorCode.NO_ERROR;
                    errorCode2 = ErrorCode.CANCEL;
                    errorCode = http2Reader;
                } catch (IOException e2) {
                    e = e2;
                    ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    errorCode = errorCode3;
                }
            } finally {
                this.this$0.close$okhttp(http2Reader, errorCode2, e);
                _UtilCommonKt.closeQuietly(this.reader);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource source, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushDataLater$okhttp(i, source, i2, z);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                this.this$0.updateConnectionFlowControl$okhttp(j);
                source.skip(j);
                return;
            }
            stream.receiveData(source, i2);
            if (z) {
                stream.receiveHeaders(Headers.EMPTY, true);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<Header> headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushHeadersLater$okhttp(i, headerBlock, z);
                return;
            }
            final Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i);
                if (stream == null) {
                    if (http2Connection.isShutdown) {
                        return;
                    }
                    if (i <= http2Connection.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if (i % 2 == http2Connection.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i, http2Connection, false, z, _UtilJvmKt.toHeaders(headerBlock));
                    http2Connection.setLastGoodStreamId$okhttp(i);
                    http2Connection.getStreams$okhttp().put(Integer.valueOf(i), http2Stream);
                    TaskQueue.execute$default(http2Connection.taskRunner.newQueue(), http2Connection.getConnectionName$okhttp() + AbstractJsonLexerKt.BEGIN_LIST + i + "] onStream", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit headers$lambda$2$lambda$1;
                            headers$lambda$2$lambda$1 = Http2Connection.ReaderRunnable.headers$lambda$2$lambda$1(Http2Connection.this, http2Stream);
                            return headers$lambda$2$lambda$1;
                        }
                    }, 6, null);
                    return;
                }
                Unit unit = Unit.INSTANCE;
                stream.receiveHeaders(_UtilJvmKt.toHeaders(headerBlock), z);
            }
        }

        public static final Unit headers$lambda$2$lambda$1(Http2Connection http2Connection, Http2Stream http2Stream) {
            try {
                http2Connection.getListener$okhttp().onStream(http2Stream);
            } catch (IOException e) {
                Platform.Companion.get().log("Http2Connection.Listener failure for " + http2Connection.getConnectionName$okhttp(), 4, e);
                try {
                    http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                } catch (IOException unused) {
                }
            }
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushResetLater$okhttp(i, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            TaskQueue.execute$default(this.this$0.writerQueue, this.this$0.getConnectionName$okhttp() + " applyAndAckSettings", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Http2Connection.ReaderRunnable.settings$lambda$3(Http2Connection.ReaderRunnable.this, z, settings);
                    return unit;
                }
            }, 6, null);
        }

        public static final Unit settings$lambda$3(ReaderRunnable readerRunnable, boolean z, Settings settings) {
            readerRunnable.applyAndAckSettings(z, settings);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void applyAndAckSettings(boolean z, Settings settings) {
            T t;
            long initialWindowSize;
            int i;
            Http2Stream[] http2StreamArr;
            Http2Stream[] http2StreamArr2;
            Settings settings2 = settings;
            Intrinsics.checkNotNullParameter(settings2, "settings");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Http2Writer writer = this.this$0.getWriter();
            final Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    Settings peerSettings = http2Connection.getPeerSettings();
                    if (z) {
                        t = settings2;
                    } else {
                        Settings settings3 = new Settings();
                        settings3.merge(peerSettings);
                        settings3.merge(settings2);
                        t = settings3;
                    }
                    objectRef.element = t;
                    initialWindowSize = ((Settings) objectRef.element).getInitialWindowSize() - peerSettings.getInitialWindowSize();
                    if (initialWindowSize != 0 && !http2Connection.getStreams$okhttp().isEmpty()) {
                        http2StreamArr = (Http2Stream[]) http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                        http2StreamArr2 = http2StreamArr;
                        http2Connection.setPeerSettings((Settings) objectRef.element);
                        TaskQueue.execute$default(http2Connection.settingsListenerQueue, http2Connection.getConnectionName$okhttp() + " onSettings", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit applyAndAckSettings$lambda$7$lambda$6$lambda$5;
                                applyAndAckSettings$lambda$7$lambda$6$lambda$5 = Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$7$lambda$6$lambda$5(Http2Connection.this, objectRef);
                                return applyAndAckSettings$lambda$7$lambda$6$lambda$5;
                            }
                        }, 6, null);
                        Unit unit = Unit.INSTANCE;
                    }
                    http2StreamArr = null;
                    http2StreamArr2 = http2StreamArr;
                    http2Connection.setPeerSettings((Settings) objectRef.element);
                    TaskQueue.execute$default(http2Connection.settingsListenerQueue, http2Connection.getConnectionName$okhttp() + " onSettings", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit applyAndAckSettings$lambda$7$lambda$6$lambda$5;
                            applyAndAckSettings$lambda$7$lambda$6$lambda$5 = Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$7$lambda$6$lambda$5(Http2Connection.this, objectRef);
                            return applyAndAckSettings$lambda$7$lambda$6$lambda$5;
                        }
                    }, 6, null);
                    Unit unit2 = Unit.INSTANCE;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) objectRef.element);
                } catch (IOException e) {
                    http2Connection.failConnection(e);
                }
                Unit unit3 = Unit.INSTANCE;
            }
            if (http2StreamArr2 != null) {
                for (Http2Stream http2Stream : http2StreamArr2) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
            }
        }

        public static final Unit applyAndAckSettings$lambda$7$lambda$6$lambda$5(Http2Connection http2Connection, Ref.ObjectRef objectRef) {
            http2Connection.getListener$okhttp().onSettings(http2Connection, (Settings) objectRef.element);
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, final int i, final int i2) {
            if (!z) {
                final Http2Connection http2Connection = this.this$0;
                TaskQueue.execute$default(this.this$0.writerQueue, this.this$0.getConnectionName$okhttp() + " ping", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ping$lambda$10;
                        ping$lambda$10 = Http2Connection.ReaderRunnable.ping$lambda$10(Http2Connection.this, i, i2);
                        return ping$lambda$10;
                    }
                }, 6, null);
                return;
            }
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection2) {
                if (i == 1) {
                    long j = http2Connection2.intervalPongsReceived;
                    http2Connection2.intervalPongsReceived = 1 + j;
                    Long.valueOf(j);
                } else if (i == 2) {
                    long j2 = http2Connection2.degradedPongsReceived;
                    http2Connection2.degradedPongsReceived = 1 + j2;
                    Long.valueOf(j2);
                } else {
                    if (i == 3) {
                        http2Connection2.awaitPongsReceived++;
                        Http2Connection http2Connection3 = http2Connection2;
                        Intrinsics.checkNotNull(http2Connection3, "null cannot be cast to non-null type java.lang.Object");
                        http2Connection3.notifyAll();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public static final Unit ping$lambda$10(Http2Connection http2Connection, int i, int i2) {
            http2Connection.writePing(true, i, i2);
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString debugData) {
            int i2;
            Object[] array;
            Http2Stream[] http2StreamArr;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.size();
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
                Unit unit = Unit.INSTANCE;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j;
                    Http2Connection http2Connection2 = http2Connection;
                    Intrinsics.checkNotNull(http2Connection2, "null cannot be cast to non-null type java.lang.Object");
                    http2Connection2.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i2, requestHeaders);
        }
    }

    public final void pushRequestLater$okhttp(final int i, final List<Header> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + i + "] onRequest", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit pushRequestLater$lambda$32;
                    pushRequestLater$lambda$32 = Http2Connection.pushRequestLater$lambda$32(Http2Connection.this, i, requestHeaders);
                    return pushRequestLater$lambda$32;
                }
            }, 6, null);
        }
    }

    public static final Unit pushRequestLater$lambda$32(Http2Connection http2Connection, int i, List list) {
        if (http2Connection.pushObserver.onRequest(i, list)) {
            try {
                http2Connection.writer.rstStream(i, ErrorCode.CANCEL);
                synchronized (http2Connection) {
                    http2Connection.currentPushRequests.remove(Integer.valueOf(i));
                    Unit unit = Unit.INSTANCE;
                }
            } catch (IOException unused) {
            }
        }
        return Unit.INSTANCE;
    }

    public final void pushHeadersLater$okhttp(final int i, final List<Header> requestHeaders, final boolean z) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + i + "] onHeaders", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pushHeadersLater$lambda$35;
                pushHeadersLater$lambda$35 = Http2Connection.pushHeadersLater$lambda$35(Http2Connection.this, i, requestHeaders, z);
                return pushHeadersLater$lambda$35;
            }
        }, 6, null);
    }

    public static final Unit pushHeadersLater$lambda$35(Http2Connection http2Connection, int i, List list, boolean z) {
        boolean onHeaders = http2Connection.pushObserver.onHeaders(i, list, z);
        if (onHeaders) {
            try {
                http2Connection.writer.rstStream(i, ErrorCode.CANCEL);
            } catch (IOException unused) {
            }
        }
        if (onHeaders || z) {
            synchronized (http2Connection) {
                http2Connection.currentPushRequests.remove(Integer.valueOf(i));
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final void pushDataLater$okhttp(final int i, BufferedSource source, final int i2, final boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        final Buffer buffer = new Buffer();
        long j = i2;
        source.require(j);
        source.read(buffer, j);
        TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + i + "] onData", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pushDataLater$lambda$38;
                pushDataLater$lambda$38 = Http2Connection.pushDataLater$lambda$38(Http2Connection.this, i, buffer, i2, z);
                return pushDataLater$lambda$38;
            }
        }, 6, null);
    }

    public static final Unit pushDataLater$lambda$38(Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z) {
        try {
            boolean onData = http2Connection.pushObserver.onData(i, buffer, i2, z);
            if (onData) {
                http2Connection.writer.rstStream(i, ErrorCode.CANCEL);
            }
            if (onData || z) {
                synchronized (http2Connection) {
                    http2Connection.currentPushRequests.remove(Integer.valueOf(i));
                    Unit unit = Unit.INSTANCE;
                }
            }
        } catch (IOException unused) {
        }
        return Unit.INSTANCE;
    }

    public final void pushResetLater$okhttp(final int i, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + AbstractJsonLexerKt.BEGIN_LIST + i + "] onReset", 0L, false, new Function0() { // from class: okhttp3.internal.http2.Http2Connection$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pushResetLater$lambda$40;
                pushResetLater$lambda$40 = Http2Connection.pushResetLater$lambda$40(Http2Connection.this, i, errorCode);
                return pushResetLater$lambda$40;
            }
        }, 6, null);
    }

    public static final Unit pushResetLater$lambda$40(Http2Connection http2Connection, int i, ErrorCode errorCode) {
        http2Connection.pushObserver.onReset(i, errorCode);
        synchronized (http2Connection) {
            http2Connection.currentPushRequests.remove(Integer.valueOf(i));
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "<init>", "()V", "onStream", "", "stream", "Lokhttp3/internal/http2/Http2Stream;", "onSettings", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream stream) throws IOException {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public void onSettings(Http2Connection connection, Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;

        /* compiled from: Http2Connection.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "<init>", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "<init>", "()V", "OKHTTP_CLIENT_WINDOW_SIZE", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "INTERVAL_PING", "DEGRADED_PING", "AWAIT_PING", "DEGRADED_PONG_TIMEOUT_NS", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(4, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public final Http2Stream removeStream$okhttp(int i) {
        Http2Stream remove;
        synchronized (this) {
            remove = this.streams.remove(Integer.valueOf(i));
            Http2Connection http2Connection = this;
            Intrinsics.checkNotNull(http2Connection, "null cannot be cast to non-null type java.lang.Object");
            http2Connection.notifyAll();
        }
        return remove;
    }
}
