package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.facebook.widget.FacebookDialog;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
/* compiled from: ConnectPlan.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB\u0091\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ2\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020>H\u0002J\r\u0010?\u001a\u00020;H\u0000¢\u0006\u0002\b@J\u0018\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010\u0019H\u0002J#\u0010G\u001a\u00020\u00002\f\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00162\u0006\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\bIJ%\u0010J\u001a\u0004\u0018\u00010\u00002\f\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00162\u0006\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\bKJ\b\u0010L\u001a\u000207H\u0016J\u001a\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020>H\u0016J\b\u0010S\u001a\u00020>H\u0016J\b\u0010T\u001a\u00020\u0001H\u0016J\u0006\u0010U\u001a\u00020>R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u001b\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010%¨\u0006W"}, d2 = {"Lokhttp3/internal/connection/ConnectPlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "readTimeoutMillis", "", "writeTimeoutMillis", "socketConnectTimeoutMillis", "socketReadTimeoutMillis", "pingIntervalMillis", "retryOnConnectionFailure", "", "user", "Lokhttp3/internal/connection/ConnectionUser;", "routePlanner", "Lokhttp3/internal/connection/RealRoutePlanner;", "route", "Lokhttp3/Route;", "routes", "", "attempt", "tunnelRequest", "Lokhttp3/Request;", "connectionSpecIndex", "isTlsFallback", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;IIIIIZLokhttp3/internal/connection/ConnectionUser;Lokhttp3/internal/connection/RealRoutePlanner;Lokhttp3/Route;Ljava/util/List;ILokhttp3/Request;IZ)V", "getRoute", "()Lokhttp3/Route;", "getRoutes$okhttp", "()Ljava/util/List;", "getConnectionSpecIndex$okhttp", "()I", "isTlsFallback$okhttp", "()Z", "canceled", "rawSocket", "Ljava/net/Socket;", "socket", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "handshake", "Lokhttp3/Handshake;", "protocol", "Lokhttp3/Protocol;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "connection", "Lokhttp3/internal/connection/RealConnection;", "isReady", "copy", "connectTcp", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "connectTlsEtc", "connectSocket", "", "connectTunnel", "connectTunnel$okhttp", "connectTls", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionSpec", "Lokhttp3/ConnectionSpec;", "createTunnel", "planWithCurrentOrInitialConnectionSpec", "connectionSpecs", "planWithCurrentOrInitialConnectionSpec$okhttp", "nextConnectionSpec", "nextConnectionSpec$okhttp", "handleSuccess", "trackFailure", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "e", "Ljava/io/IOException;", "noNewExchanges", FacebookDialog.COMPLETION_GESTURE_CANCEL, "retry", "closeQuietly", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final int attempt;
    private volatile boolean canceled;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final int connectionSpecIndex;
    private Handshake handshake;
    private final boolean isTlsFallback;
    private final int pingIntervalMillis;
    private Protocol protocol;
    private Socket rawSocket;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final Route route;
    private final RealRoutePlanner routePlanner;
    private final List<Route> routes;
    private BufferedSink sink;
    private Socket socket;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;
    private BufferedSource source;
    private final TaskRunner taskRunner;
    private final Request tunnelRequest;
    private final ConnectionUser user;
    private final int writeTimeoutMillis;

    /* compiled from: ConnectPlan.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(RealCall call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public ConnectPlan(TaskRunner taskRunner, RealConnectionPool connectionPool, int i, int i2, int i3, int i4, int i5, boolean z, ConnectionUser user, RealRoutePlanner routePlanner, Route route, List<Route> list, int i6, Request request, int i7, boolean z2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(route, "route");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i;
        this.writeTimeoutMillis = i2;
        this.socketConnectTimeoutMillis = i3;
        this.socketReadTimeoutMillis = i4;
        this.pingIntervalMillis = i5;
        this.retryOnConnectionFailure = z;
        this.user = user;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = i6;
        this.tunnelRequest = request;
        this.connectionSpecIndex = i7;
        this.isTlsFallback = z2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public Route getRoute() {
        return this.route;
    }

    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    public final int getConnectionSpecIndex$okhttp() {
        return this.connectionSpecIndex;
    }

    public final boolean isTlsFallback$okhttp() {
        return this.isTlsFallback;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final void setSocket$okhttp(Socket socket) {
        this.socket = socket;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.protocol != null;
    }

    static /* synthetic */ ConnectPlan copy$default(ConnectPlan connectPlan, int i, Request request, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = connectPlan.attempt;
        }
        if ((i3 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        if ((i3 & 4) != 0) {
            i2 = connectPlan.connectionSpecIndex;
        }
        if ((i3 & 8) != 0) {
            z = connectPlan.isTlsFallback;
        }
        return connectPlan.copy(i, request, i2, z);
    }

    private final ConnectPlan copy(int i, Request request, int i2, boolean z) {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.user, this.routePlanner, getRoute(), this.routes, i, request, i2, z);
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTcp */
    public RoutePlanner.ConnectResult mo10377connectTcp() {
        Socket socket;
        Socket socket2;
        if (this.rawSocket != null) {
            throw new IllegalStateException("TCP already connected".toString());
        }
        this.user.addPlanToCancel(this);
        boolean z = false;
        try {
            try {
                this.user.connectStart(getRoute());
                connectSocket();
                z = true;
                RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                this.user.removePlanToCancel(this);
                return connectResult;
            } catch (IOException e) {
                if (getRoute().address().proxy() == null && getRoute().proxy().type() != Proxy.Type.DIRECT) {
                    getRoute().address().proxySelector().connectFailed(getRoute().address().url().uri(), getRoute().proxy().address(), e);
                }
                this.user.connectFailed(getRoute(), null, e);
                RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, null, e, 2, null);
                this.user.removePlanToCancel(this);
                if (!z && (socket = this.rawSocket) != null) {
                    _UtilJvmKt.closeQuietly(socket);
                }
                return connectResult2;
            }
        } catch (Throwable th) {
            this.user.removePlanToCancel(this);
            if (!z && (socket2 = this.rawSocket) != null) {
                _UtilJvmKt.closeQuietly(socket2);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x019b  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTlsEtc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoutePlanner.ConnectResult mo10378connectTlsEtc() {
        ConnectPlan connectPlan;
        ConnectPlan connectPlan2;
        BufferedSource bufferedSource;
        Socket socket = this.rawSocket;
        if (socket != null) {
            if (isReady()) {
                throw new IllegalStateException("already connected".toString());
            }
            List<ConnectionSpec> connectionSpecs = getRoute().address().connectionSpecs();
            this.user.addPlanToCancel(this);
            ConnectPlan connectPlan3 = null;
            boolean z = false;
            try {
                try {
                    if (this.tunnelRequest != null) {
                        RoutePlanner.ConnectResult connectTunnel$okhttp = connectTunnel$okhttp();
                        if (connectTunnel$okhttp.getNextPlan() != null || connectTunnel$okhttp.getThrowable() != null) {
                            this.user.removePlanToCancel(this);
                            Socket socket2 = this.socket;
                            if (socket2 != null) {
                                _UtilJvmKt.closeQuietly(socket2);
                            }
                            _UtilJvmKt.closeQuietly(socket);
                            return connectTunnel$okhttp;
                        }
                    }
                    if (getRoute().address().sslSocketFactory() != null) {
                        BufferedSource bufferedSource2 = this.source;
                        if (bufferedSource2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("source");
                            bufferedSource2 = null;
                        }
                        if (bufferedSource2.getBuffer().exhausted()) {
                            BufferedSink bufferedSink = this.sink;
                            if (bufferedSink == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("sink");
                                bufferedSink = null;
                            }
                            if (bufferedSink.getBuffer().exhausted()) {
                                this.user.secureConnectStart();
                                Socket createSocket = getRoute().address().sslSocketFactory().createSocket(socket, getRoute().address().url().host(), getRoute().address().url().port(), true);
                                Intrinsics.checkNotNull(createSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                                SSLSocket sSLSocket = (SSLSocket) createSocket;
                                ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp = planWithCurrentOrInitialConnectionSpec$okhttp(connectionSpecs, sSLSocket);
                                ConnectionSpec connectionSpec = connectionSpecs.get(planWithCurrentOrInitialConnectionSpec$okhttp.connectionSpecIndex);
                                connectPlan = planWithCurrentOrInitialConnectionSpec$okhttp.nextConnectionSpec$okhttp(connectionSpecs, sSLSocket);
                                try {
                                    connectionSpec.apply$okhttp(sSLSocket, planWithCurrentOrInitialConnectionSpec$okhttp.isTlsFallback);
                                    connectTls(sSLSocket, connectionSpec);
                                    this.user.secureConnectEnd(this.handshake);
                                    connectPlan2 = connectPlan;
                                } catch (IOException e) {
                                    e = e;
                                    this.user.connectFailed(getRoute(), null, e);
                                    if (this.retryOnConnectionFailure && RetryTlsHandshakeKt.retryTlsHandshake(e)) {
                                        connectPlan3 = connectPlan;
                                    }
                                    RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, connectPlan3, e);
                                    this.user.removePlanToCancel(this);
                                    if (!z) {
                                        Socket socket3 = this.socket;
                                        if (socket3 != null) {
                                            _UtilJvmKt.closeQuietly(socket3);
                                        }
                                        _UtilJvmKt.closeQuietly(socket);
                                    }
                                    return connectResult;
                                }
                            }
                        }
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    this.socket = socket;
                    this.protocol = getRoute().address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_1_1;
                    connectPlan2 = null;
                    try {
                        TaskRunner taskRunner = this.taskRunner;
                        RealConnectionPool realConnectionPool = this.connectionPool;
                        Route route = getRoute();
                        Socket socket4 = this.socket;
                        Intrinsics.checkNotNull(socket4);
                        Handshake handshake = this.handshake;
                        Protocol protocol = this.protocol;
                        Intrinsics.checkNotNull(protocol);
                        BufferedSource bufferedSource3 = this.source;
                        if (bufferedSource3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("source");
                            bufferedSource = null;
                        } else {
                            bufferedSource = bufferedSource3;
                        }
                        BufferedSink bufferedSink2 = this.sink;
                        if (bufferedSink2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sink");
                            bufferedSink2 = null;
                        }
                        RealConnection realConnection = new RealConnection(taskRunner, realConnectionPool, route, socket, socket4, handshake, protocol, bufferedSource, bufferedSink2, this.pingIntervalMillis, this.connectionPool.getConnectionListener$okhttp());
                        this.connection = realConnection;
                        realConnection.start();
                        this.user.callConnectEnd(getRoute(), this.protocol);
                    } catch (IOException e2) {
                        e = e2;
                        connectPlan = connectPlan2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    connectPlan = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                this.user.removePlanToCancel(this);
                return connectResult2;
            } catch (IOException e4) {
                e = e4;
                connectPlan = connectPlan2;
                z = true;
                this.user.connectFailed(getRoute(), null, e);
                if (this.retryOnConnectionFailure) {
                    connectPlan3 = connectPlan;
                }
                RoutePlanner.ConnectResult connectResult3 = new RoutePlanner.ConnectResult(this, connectPlan3, e);
                this.user.removePlanToCancel(this);
                if (!z) {
                }
                return connectResult3;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                this.user.removePlanToCancel(this);
                if (!z) {
                    Socket socket5 = this.socket;
                    if (socket5 != null) {
                        _UtilJvmKt.closeQuietly(socket5);
                    }
                    _UtilJvmKt.closeQuietly(socket);
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("TCP not connected".toString());
    }

    private final void connectSocket() throws IOException {
        Socket createSocket;
        Proxy.Type type = getRoute().proxy().type();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1 || i == 2) {
            createSocket = getRoute().address().socketFactory().createSocket();
            Intrinsics.checkNotNull(createSocket);
        } else {
            createSocket = new Socket(getRoute().proxy());
        }
        this.rawSocket = createSocket;
        if (this.canceled) {
            throw new IOException("canceled");
        }
        createSocket.setSoTimeout(this.socketReadTimeoutMillis);
        try {
            Platform.Companion.get().connectSocket(createSocket, getRoute().socketAddress(), this.socketConnectTimeoutMillis);
            try {
                this.source = Okio.buffer(Okio.source(createSocket));
                this.sink = Okio.buffer(Okio.sink(createSocket));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + getRoute().socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request createTunnel = createTunnel();
        if (createTunnel == null) {
            return new RoutePlanner.ConnectResult(this, null, null, 6, null);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int i = this.attempt + 1;
        if (i < 21) {
            this.user.callConnectEnd(getRoute(), null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, i, createTunnel, 0, false, 12, null), null, 4, null);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        this.user.connectFailed(getRoute(), null, protocolException);
        return new RoutePlanner.ConnectResult(this, null, protocolException, 2, null);
    }

    private final void connectTls(SSLSocket sSLSocket, ConnectionSpec connectionSpec) throws IOException {
        final Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Handshake.Companion companion = Handshake.Companion;
            Intrinsics.checkNotNull(session);
            final Handshake handshake = companion.get(session);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            Intrinsics.checkNotNull(hostnameVerifier);
            if (!hostnameVerifier.verify(address.url().host(), session)) {
                List<Certificate> peerCertificates = handshake.peerCertificates();
                if (peerCertificates.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                }
                Certificate certificate = peerCertificates.get(0);
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate x509Certificate = (X509Certificate) certificate;
                throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.Companion.pin(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate) + "\n            ", null, 1, null));
            }
            final CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            final Handshake handshake2 = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new Function0() { // from class: okhttp3.internal.connection.ConnectPlan$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List connectTls$lambda$4;
                    connectTls$lambda$4 = ConnectPlan.connectTls$lambda$4(CertificatePinner.this, handshake, address);
                    return connectTls$lambda$4;
                }
            });
            this.handshake = handshake2;
            certificatePinner.check$okhttp(address.url().host(), new Function0() { // from class: okhttp3.internal.connection.ConnectPlan$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List connectTls$lambda$6;
                    connectTls$lambda$6 = ConnectPlan.connectTls$lambda$6(Handshake.this);
                    return connectTls$lambda$6;
                }
            });
            String selectedProtocol = connectionSpec.supportsTlsExtensions() ? Platform.Companion.get().getSelectedProtocol(sSLSocket) : null;
            this.socket = sSLSocket;
            this.source = Okio.buffer(Okio.source(sSLSocket));
            this.sink = Okio.buffer(Okio.sink(sSLSocket));
            this.protocol = selectedProtocol != null ? Protocol.Companion.get(selectedProtocol) : Protocol.HTTP_1_1;
            Platform.Companion.get().afterHandshake(sSLSocket);
        } catch (Throwable th) {
            Platform.Companion.get().afterHandshake(sSLSocket);
            _UtilJvmKt.closeQuietly(sSLSocket);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List connectTls$lambda$4(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        CertificateChainCleaner certificateChainCleaner$okhttp = certificatePinner.getCertificateChainCleaner$okhttp();
        Intrinsics.checkNotNull(certificateChainCleaner$okhttp);
        return certificateChainCleaner$okhttp.clean(handshake.peerCertificates(), address.url().host());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List connectTls$lambda$6(Handshake handshake) {
        List<Certificate> peerCertificates = handshake.peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    private final Request createTunnel() throws IOException {
        Request request = this.tunnelRequest;
        Intrinsics.checkNotNull(request);
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(getRoute().address().url(), true) + " HTTP/1.1";
        while (true) {
            ConnectPlan connectPlan = this;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource == null) {
                Intrinsics.throwUninitializedPropertyAccessException("source");
                bufferedSource = null;
            }
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sink");
                bufferedSink = null;
            }
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, connectPlan, bufferedSource, bufferedSink);
            BufferedSource bufferedSource2 = this.source;
            if (bufferedSource2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("source");
                bufferedSource2 = null;
            }
            bufferedSource2.timeout().timeout(this.readTimeoutMillis, TimeUnit.MILLISECONDS);
            BufferedSink bufferedSink2 = this.sink;
            if (bufferedSink2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sink");
                bufferedSink2 = null;
            }
            bufferedSink2.timeout().timeout(this.writeTimeoutMillis, TimeUnit.MILLISECONDS);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code == 200) {
                return null;
            }
            if (code == 407) {
                Request authenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), build);
                if (authenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (StringsKt.equals("close", Response.header$default(build, HttpHeaders.CONNECTION, null, 2, null), true)) {
                    return authenticate;
                }
                request = authenticate;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        }
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sslSocket) throws IOException {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan nextConnectionSpec$okhttp = nextConnectionSpec$okhttp(connectionSpecs, sslSocket);
        if (nextConnectionSpec$okhttp != null) {
            return nextConnectionSpec$okhttp;
        }
        StringBuilder append = new StringBuilder("Unable to find acceptable protocols. isFallback=").append(this.isTlsFallback).append(", modes=").append(connectionSpecs).append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        throw new UnknownServiceException(append.append(arrays).toString());
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int size = connectionSpecs.size();
        for (int i = this.connectionSpecIndex + 1; i < size; i++) {
            if (connectionSpecs.get(i).isCompatible(sslSocket)) {
                return copy$default(this, 0, null, i, this.connectionSpecIndex != -1, 3, null);
            }
        }
        return null;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: handleSuccess */
    public RealConnection mo10374handleSuccess() {
        this.user.updateRouteDatabaseAfterSuccess(getRoute());
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        RealConnection realConnection2 = realConnection;
        this.user.connectionConnectEnd(realConnection2, getRoute());
        ReusePlan planReusePooledConnection$okhttp = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp.getConnection();
        }
        synchronized (realConnection) {
            this.connectionPool.put(realConnection);
            this.user.acquireConnectionNoEvents(realConnection);
            Unit unit = Unit.INSTANCE;
        }
        this.user.connectionAcquired(realConnection2);
        this.user.connectionConnectionAcquired(realConnection);
        return realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo10373cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: retry */
    public RoutePlanner.Plan mo10375retry() {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.user, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void closeQuietly() {
        Socket socket = this.socket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    /* compiled from: ConnectPlan.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/ConnectPlan$Companion;", "", "<init>", "()V", "NPE_THROW_WITH_NULL", "", "MAX_TUNNEL_ATTEMPTS", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
