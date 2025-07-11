package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.widget.FacebookDialog;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.FlowControlListener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* compiled from: RealConnection.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 w2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001wBc\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010&\u001a\u00020EH\u0016J\r\u0010,\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020EH\u0000¢\u0006\u0002\bHJ\u0006\u0010I\u001a\u00020EJ\b\u0010J\u001a\u00020EH\u0002J%\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010OH\u0000¢\u0006\u0002\bPJ\u0016\u0010Q\u001a\u00020'2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\n0OH\u0002J\u0010\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010V\u001a\u00020'2\u0006\u0010T\u001a\u00020U2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001d\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0000¢\u0006\u0002\bbJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010c\u001a\u00020EH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010d\u001a\u00020'2\u0006\u0010e\u001a\u00020'J\u0010\u0010f\u001a\u00020E2\u0006\u0010g\u001a\u00020hH\u0016J\u0018\u0010i\u001a\u00020E2\u0006\u0010j\u001a\u00020%2\u0006\u0010k\u001a\u00020lH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J%\u0010m\u001a\u00020E2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020pH\u0000¢\u0006\u0002\bqJ\u001a\u0010r\u001a\u00020E2\u0006\u0010s\u001a\u00020:2\b\u0010t\u001a\u0004\u0018\u00010pH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010u\u001a\u00020vH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0017@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u001d\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0908¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020'8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010)¨\u0006x"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "Lokhttp3/internal/concurrent/Lockable;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "rawSocket", "Ljava/net/Socket;", "socket", "handshake", "Lokhttp3/Handshake;", "protocol", "Lokhttp3/Protocol;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "pingIntervalMillis", "", "connectionListener", "Lokhttp3/internal/connection/ConnectionListener;", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;Ljava/net/Socket;Ljava/net/Socket;Lokhttp3/Handshake;Lokhttp3/Protocol;Lokio/BufferedSource;Lokio/BufferedSink;ILokhttp3/internal/connection/ConnectionListener;)V", "getTaskRunner", "()Lokhttp3/internal/concurrent/TaskRunner;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "getRoute", "()Lokhttp3/Route;", "getConnectionListener$okhttp", "()Lokhttp3/internal/connection/ConnectionListener;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "noNewExchanges", "", "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "noCoalescedConnections", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "successCount", "refusedStreamCount", "value", "allocationLimit", "getAllocationLimit$okhttp", "calls", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "idleAtNs", "", "getIdleAtNs", "()J", "setIdleAtNs", "(J)V", "isMultiplexed", "isMultiplexed$okhttp", "", "noCoalescedConnections$okhttp", "incrementSuccessCount", "incrementSuccessCount$okhttp", TtmlNode.START, "startHttp2", "isEligible", "address", "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "routeMatchesAny", "candidates", "supportsUrl", "url", "Lokhttp3/HttpUrl;", "certificateSupportHost", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", FacebookDialog.COMPLETION_GESTURE_CANCEL, "isHealthy", "doExtensiveChecks", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "onSettings", "connection", "settings", "Lokhttp3/internal/http2/Settings;", "connectFailed", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "trackFailure", NotificationCompat.CATEGORY_CALL, "e", "toString", "", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection, ExchangeCodec.Carrier, Lockable {
    public static final Companion Companion = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final ConnectionListener connectionListener;
    private final RealConnectionPool connectionPool;
    private final Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private final int pingIntervalMillis;
    private final Protocol protocol;
    private final Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private final BufferedSink sink;
    private final Socket socket;
    private final BufferedSource source;
    private int successCount;
    private final TaskRunner taskRunner;

    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public Route getRoute() {
        return this.route;
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public RealConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket rawSocket, Socket socket, Handshake handshake, Protocol protocol, BufferedSource source, BufferedSink sink, int i, ConnectionListener connectionListener) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(rawSocket, "rawSocket");
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.route = route;
        this.rawSocket = rawSocket;
        this.socket = socket;
        this.handshake = handshake;
        this.protocol = protocol;
        this.source = source;
        this.sink = sink;
        this.pingIntervalMillis = i;
        this.connectionListener = connectionListener;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    public final int getAllocationLimit$okhttp() {
        return this.allocationLimit;
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final void setIdleAtNs(long j) {
        this.idleAtNs = j;
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
        synchronized (this) {
            this.noNewExchanges = true;
            Unit unit = Unit.INSTANCE;
        }
        this.connectionListener.noNewExchanges(this);
    }

    public final void noCoalescedConnections$okhttp() {
        synchronized (this) {
            this.noCoalescedConnections = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void incrementSuccessCount$okhttp() {
        synchronized (this) {
            this.successCount++;
        }
    }

    public final void start() throws IOException {
        this.idleAtNs = System.nanoTime();
        if (this.protocol == Protocol.HTTP_2 || this.protocol == Protocol.H2_PRIOR_KNOWLEDGE) {
            startHttp2();
        }
    }

    private final void startHttp2() throws IOException {
        this.socket.setSoTimeout(0);
        ConnectionListener connectionListener = this.connectionListener;
        FlowControlListener.None none = connectionListener instanceof FlowControlListener ? (FlowControlListener) connectionListener : null;
        if (none == null) {
            none = FlowControlListener.None.INSTANCE;
        }
        Http2Connection build = new Http2Connection.Builder(true, this.taskRunner).socket(this.socket, getRoute().address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(this.pingIntervalMillis).flowControlListener(none).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, 1, null);
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        Intrinsics.checkNotNullParameter(address, "address");
        RealConnection realConnection = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !getRoute().address().equalsNonHost$okhttp(address)) {
                return false;
            }
            if (Intrinsics.areEqual(address.url().host(), route().address().url().host())) {
                return true;
            }
            if (this.http2Connection != null && list != null && routeMatchesAny(list) && address.hostnameVerifier() == OkHostnameVerifier.INSTANCE && supportsUrl(address.url())) {
                try {
                    CertificatePinner certificatePinner = address.certificatePinner();
                    Intrinsics.checkNotNull(certificatePinner);
                    String host = address.url().host();
                    Handshake handshake = handshake();
                    Intrinsics.checkNotNull(handshake);
                    certificatePinner.check(host, handshake.peerCertificates());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                    return false;
                }
            }
            return false;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    private final boolean routeMatchesAny(List<Route> list) {
        List<Route> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (Route route : list2) {
            if (route.proxy().type() == Proxy.Type.DIRECT && getRoute().proxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual(getRoute().socketAddress(), route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake;
        RealConnection realConnection = this;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(realConnection)) {
            HttpUrl url = getRoute().address().url();
            if (httpUrl.port() != url.port()) {
                return false;
            }
            if (Intrinsics.areEqual(httpUrl.host(), url.host())) {
                return true;
            }
            return (this.noCoalescedConnections || (handshake = this.handshake) == null || !certificateSupportHost(httpUrl, handshake)) ? false : true;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake) {
        List<Certificate> peerCertificates = handshake.peerCertificates();
        if (!peerCertificates.isEmpty()) {
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
            String host = httpUrl.host();
            Certificate certificate = peerCertificates.get(0);
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (okHostnameVerifier.verify(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient client, RealInterceptorChain chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.socket;
        BufferedSource bufferedSource = this.source;
        BufferedSink bufferedSink = this.sink;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        bufferedSource.timeout().timeout(chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        bufferedSink.timeout().timeout(chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(client, this, bufferedSource, bufferedSink);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        this.socket.setSoTimeout(0);
        noNewExchanges();
        final BufferedSource bufferedSource = this.source;
        final BufferedSink bufferedSink = this.sink;
        return new RealWebSocket.Streams(bufferedSource, bufferedSink) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Exchange.this.bodyComplete(-1L, true, true, null);
            }

            @Override // okhttp3.internal.ws.RealWebSocket.Streams
            public void cancel() {
                Exchange.this.cancel();
            }
        };
    }

    @Override // okhttp3.Connection
    public Route route() {
        return getRoute();
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo10373cancel() {
        _UtilJvmKt.closeQuietly(this.rawSocket);
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.socket;
    }

    public final boolean isHealthy(boolean z) {
        long j;
        RealConnection realConnection = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(realConnection)) {
            long nanoTime = System.nanoTime();
            if (this.rawSocket.isClosed() || this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
                return false;
            }
            Http2Connection http2Connection = this.http2Connection;
            if (http2Connection != null) {
                return http2Connection.isHealthy(nanoTime);
            }
            synchronized (realConnection) {
                j = nanoTime - this.idleAtNs;
            }
            if (j < IDLE_CONNECTION_HEALTHY_NS || !z) {
                return true;
            }
            return _UtilJvmKt.isHealthy(this.socket, this.source);
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection connection, Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        synchronized (this) {
            int i = this.allocationLimit;
            int maxConcurrentStreams = settings.getMaxConcurrentStreams();
            this.allocationLimit = maxConcurrentStreams;
            if (maxConcurrentStreams < i) {
                this.connectionPool.scheduleOpener(getRoute().address());
            } else if (maxConcurrentStreams > i) {
                this.connectionPool.scheduleCloser();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public final void connectFailed$okhttp(OkHttpClient client, Route failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase$okhttp().failed(failedRoute);
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(RealCall call, IOException iOException) {
        boolean z;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        z = !this.noNewExchanges;
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                        Unit unit = Unit.INSTANCE;
                    }
                    z = false;
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !call.isCanceled()) {
                        z = !this.noNewExchanges;
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                        Unit unit22 = Unit.INSTANCE;
                    }
                    z = false;
                    Unit unit222 = Unit.INSTANCE;
                }
            } else {
                if (isMultiplexed$okhttp()) {
                    if (iOException instanceof ConnectionShutdownException) {
                    }
                    z = false;
                    Unit unit2222 = Unit.INSTANCE;
                }
                boolean z2 = !this.noNewExchanges;
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        connectFailed$okhttp(call.getClient(), getRoute(), iOException);
                    }
                    this.routeFailureCount++;
                }
                z = z2;
                Unit unit22222 = Unit.INSTANCE;
            }
        }
        if (z) {
            this.connectionListener.noNewExchanges(this);
        }
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.protocol;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Connection{").append(getRoute().address().url().host()).append(AbstractJsonLexerKt.COLON).append(getRoute().address().url().port()).append(", proxy=").append(getRoute().proxy()).append(" hostAddress=").append(getRoute().socketAddress()).append(" cipherSuite=");
        Handshake handshake = this.handshake;
        return append.append((handshake == null || (r1 = handshake.cipherSuite()) == null) ? "none" : "none").append(" protocol=").append(this.protocol).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    /* compiled from: RealConnection.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "<init>", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RealConnection newTestConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket socket, long j) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection realConnection = new RealConnection(taskRunner, connectionPool, route, new Socket(), socket, null, Protocol.HTTP_2, Okio.buffer(new Source() { // from class: okhttp3.internal.connection.RealConnection$Companion$newTestConnection$result$1
                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // okio.Source
                public long read(Buffer sink, long j2) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    throw new UnsupportedOperationException();
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return Timeout.NONE;
                }
            }), Okio.buffer(new Sink() { // from class: okhttp3.internal.connection.RealConnection$Companion$newTestConnection$result$2
                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return Timeout.NONE;
                }

                @Override // okio.Sink
                public void write(Buffer source, long j2) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    throw new UnsupportedOperationException();
                }
            }), 0, ConnectionListener.Companion.getNONE());
            realConnection.setIdleAtNs(j);
            return realConnection;
        }
    }
}
