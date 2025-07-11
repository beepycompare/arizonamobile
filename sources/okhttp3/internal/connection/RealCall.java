package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.widget.FacebookDialog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;
/* compiled from: RealCall.kt */
@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0019\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002deB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0018\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0001H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\tH\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u000209H\u0002J\r\u0010B\u001a\u00020<H\u0000¢\u0006\u0002\bCJ\u001e\u0010D\u001a\u0002092\u0006\u00107\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020GJ\u0015\u0010H\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0000¢\u0006\u0002\bIJ\u000e\u0010J\u001a\u0002092\u0006\u0010#\u001a\u00020\"J?\u0010K\u001a\u0002HL\"\n\b\u0000\u0010L*\u0004\u0018\u00010M2\u0006\u0010/\u001a\u00020'2\b\b\u0002\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u0002HLH\u0000¢\u0006\u0004\bQ\u0010RJ\u0019\u0010S\u001a\u0004\u0018\u00010M2\b\u0010P\u001a\u0004\u0018\u00010MH\u0000¢\u0006\u0002\bTJ!\u0010U\u001a\u0002HL\"\n\b\u0000\u0010L*\u0004\u0018\u00010M2\u0006\u0010P\u001a\u0002HLH\u0002¢\u0006\u0002\u0010VJ\u000f\u0010W\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0002\bYJ!\u0010Z\u001a\u0002HL\"\n\b\u0000\u0010L*\u0004\u0018\u00010M2\u0006\u0010[\u001a\u0002HLH\u0002¢\u0006\u0002\u0010VJ\u0006\u0010&\u001a\u000209J\u0015\u0010\\\u001a\u0002092\u0006\u0010]\u001a\u00020\tH\u0000¢\u0006\u0002\b^J\u0006\u0010_\u001a\u00020\tJ\b\u0010`\u001a\u00020aH\u0002J\r\u0010b\u001a\u00020aH\u0000¢\u0006\u0002\bcR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006f"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "", "Lokhttp3/internal/concurrent/Lockable;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "getClient", "()Lokhttp3/OkHttpClient;", "getOriginalRequest", "()Lokhttp3/Request;", "getForWebSocket", "()Z", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "callStackTrace", "", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "value", "Lokhttp3/internal/connection/RealConnection;", "connection", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "timeoutEarlyExit", "Lokhttp3/internal/connection/Exchange;", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "exchange", "plansToCancel", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "getPlansToCancel$okhttp", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Lokio/Timeout;", "clone", "request", FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "isCanceled", "execute", "Lokhttp3/Response;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "isExecuted", "callStart", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "enterNetworkInterceptorExchange", "newRoutePlanner", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange", "initExchange$okhttp", "acquireConnectionNoEvents", "messageDone", ExifInterface.LONGITUDE_EAST, "Ljava/io/IOException;", "requestDone", "responseDone", "e", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "noMoreExchanges$okhttp", "callDone", "(Ljava/io/IOException;)Ljava/io/IOException;", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "timeoutExit", "cause", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "retryAfterFailure", "toLoggableString", "", "redactedUrl", "redactedUrl$okhttp", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealCall implements Call, Cloneable, Lockable {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> plansToCancel;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    /* JADX WARN: Type inference failed for: r4v5, types: [okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(OkHttpClient client, Request originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.connectionPool = client.connectionPool().getDelegate$okhttp();
        this.eventListener = client.eventListenerFactory().create(this);
        ?? r4 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        r4.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r4;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList<>();
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final CopyOnWriteArrayList<RoutePlanner.Plan> getPlansToCancel$okhttp() {
        return this.plansToCancel;
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public Call clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        Iterator<RoutePlanner.Plan> it = this.plansToCancel.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().mo10373cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    @Override // okhttp3.Call
    public void enqueue(Callback responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        CollectionsKt.addAll(arrayList2, this.client.interceptors());
        arrayList2.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList2.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList2.add(new CacheInterceptor(this.client.cache()));
        arrayList2.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt.addAll(arrayList2, this.client.networkInterceptors());
        }
        arrayList2.add(new CallServerInterceptor(this.forWebSocket));
        boolean z = false;
        try {
            try {
                Response proceed = new RealInterceptorChain(this, arrayList, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
                if (isCanceled()) {
                    _UtilCommonKt.closeQuietly(proceed);
                    throw new IOException("Canceled");
                }
                noMoreExchanges$okhttp(null);
                return proceed;
            } catch (IOException e) {
                z = true;
                IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
                Intrinsics.checkNotNull(noMoreExchanges$okhttp, "null cannot be cast to non-null type kotlin.Throwable");
                throw noMoreExchanges$okhttp;
            }
        } catch (Throwable th) {
            if (!z) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z, RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            RealRoutePlanner realRoutePlanner = new RealRoutePlanner(this.client.getTaskRunner$okhttp(), this.connectionPool, this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), this.client.pingIntervalMillis(), this.client.retryOnConnectionFailure(), this.client.fastFallback(), this.client.address(request.url()), this.client.getRouteDatabase$okhttp(), new CallConnectionUser(this, this.connectionPool.getConnectionListener$okhttp(), chain));
            this.exchangeFinder = this.client.fastFallback() ? new FastFallbackExchangeFinder(realRoutePlanner, this.client.getTaskRunner$okhttp()) : new SequentialExchangeFinder(realRoutePlanner);
        }
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealCall realCall = this;
        synchronized (realCall) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find().newCodec$okhttp(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (realCall) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    public final void acquireConnectionNoEvents(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        RealConnection realConnection = connection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.connection != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public static /* synthetic */ IOException messageDone$okhttp$default(RealCall realCall, Exchange exchange, boolean z, boolean z2, IOException iOException, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return realCall.messageDone$okhttp(exchange, z, z2, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0024 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:58:0x0015, B:67:0x0024, B:69:0x0028, B:70:0x002a, B:72:0x002f, B:77:0x0038, B:79:0x003c, B:84:0x0045, B:64:0x001e), top: B:96:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0028 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:58:0x0015, B:67:0x0024, B:69:0x0028, B:70:0x002a, B:72:0x002f, B:77:0x0038, B:79:0x003c, B:84:0x0045, B:64:0x001e), top: B:96:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <E extends IOException> E messageDone$okhttp(Exchange exchange, boolean z, boolean z2, E e) {
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (Intrinsics.areEqual(exchange, this.exchange)) {
            synchronized (this) {
                z3 = false;
                if (z) {
                    try {
                        if (!this.requestBodyOpen) {
                        }
                        if (z) {
                            this.requestBodyOpen = false;
                        }
                        if (z2) {
                            this.responseBodyOpen = false;
                        }
                        z5 = this.requestBodyOpen;
                        boolean z6 = z5 && !this.responseBodyOpen;
                        if (!z5 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z2 || !this.responseBodyOpen) {
                    z4 = false;
                    Unit unit2 = Unit.INSTANCE;
                }
                if (z) {
                }
                if (z2) {
                }
                z5 = this.requestBodyOpen;
                if (z5) {
                }
                if (!z5) {
                    z3 = true;
                }
                z4 = z3;
                z3 = z6;
                Unit unit22 = Unit.INSTANCE;
            }
            if (z3) {
                this.exchange = null;
                RealConnection realConnection = this.connection;
                if (realConnection != null) {
                    realConnection.incrementSuccessCount$okhttp();
                }
            }
            if (z4) {
                return (E) callDone(e);
            }
        }
        return e;
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return z ? callDone(iOException) : iOException;
    }

    private final <E extends IOException> E callDone(E e) {
        Socket releaseConnectionNoEvents$okhttp;
        RealCall realCall = this;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(realCall)) {
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                RealConnection realConnection2 = realConnection;
                if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(realConnection2)) {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection2);
                }
                synchronized (realConnection2) {
                    releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
                }
                if (this.connection == null) {
                    if (releaseConnectionNoEvents$okhttp != null) {
                        _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                    }
                    RealCall realCall2 = this;
                    RealConnection realConnection3 = realConnection;
                    this.eventListener.connectionReleased(realCall2, realConnection3);
                    realConnection.getConnectionListener$okhttp().connectionReleased(realConnection3, realCall2);
                    if (releaseConnectionNoEvents$okhttp != null) {
                        realConnection.getConnectionListener$okhttp().connectionClosed(realConnection3);
                    }
                } else if (releaseConnectionNoEvents$okhttp != null) {
                    throw new IllegalStateException("Check failed.");
                }
            }
            E e2 = (E) timeoutExit(e);
            if (e != null) {
                Intrinsics.checkNotNull(e2);
                this.eventListener.callFailed(this, e2);
                return e2;
            }
            this.eventListener.callEnd(this);
            return e2;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realCall);
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        RealConnection realConnection2 = realConnection;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(realConnection2)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            Iterator<Reference<RealCall>> it = calls.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().get(), this)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                throw new IllegalStateException("Check failed.");
            }
            calls.remove(i);
            this.connection = null;
            if (calls.isEmpty()) {
                realConnection.setIdleAtNs(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(realConnection)) {
                    return realConnection.socket();
                }
            }
            return null;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection2);
    }

    private final <E extends IOException> E timeoutExit(E e) {
        if (!this.timeoutEarlyExit && exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
            return interruptedIOException;
        }
        return e;
    }

    public final void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        exit();
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final boolean retryAfterFailure() {
        Exchange exchange = this.exchange;
        if (exchange == null || !exchange.getHasFailure$okhttp()) {
            return false;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        RoutePlanner routePlanner = exchangeFinder.getRoutePlanner();
        Exchange exchange2 = this.exchange;
        return routePlanner.hasNext(exchange2 != null ? exchange2.getConnection$okhttp() : null);
    }

    public final String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl$okhttp();
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    /* compiled from: RealCall.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0000R\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0019\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "value", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "reuseCallsPerHostFrom", "", "other", "Lokhttp3/internal/connection/RealCall;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", NotificationCompat.CATEGORY_CALL, "getCall", "()Lokhttp3/internal/connection/RealCall;", "executeOn", "executorService", "Ljava/util/concurrent/ExecutorService;", "failRejected", "e", "Ljava/util/concurrent/RejectedExecutionException;", "failRejected$okhttp", "run", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final void reuseCallsPerHostFrom(AsyncCall other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final void executeOn(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            _UtilJvmKt.assertLockNotHeld(this.this$0.getClient().dispatcher());
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    failRejected$okhttp(e);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        public static /* synthetic */ void failRejected$okhttp$default(AsyncCall asyncCall, RejectedExecutionException rejectedExecutionException, int i, Object obj) {
            if ((i & 1) != 0) {
                rejectedExecutionException = null;
            }
            asyncCall.failRejected$okhttp(rejectedExecutionException);
        }

        public final void failRejected$okhttp(RejectedExecutionException rejectedExecutionException) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
            interruptedIOException.initCause(rejectedExecutionException);
            InterruptedIOException interruptedIOException2 = interruptedIOException;
            this.this$0.noMoreExchanges$okhttp(interruptedIOException2);
            this.responseCallback.onFailure(this.this$0, interruptedIOException2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Dispatcher dispatcher;
            RealCall realCall = this.this$0;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName("OkHttp " + this.this$0.redactedUrl$okhttp());
            try {
                realCall.timeout.enter();
                boolean z = false;
                try {
                    try {
                        this.responseCallback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                        dispatcher = realCall.getClient().dispatcher();
                    } catch (IOException e) {
                        e = e;
                        z = true;
                        if (z) {
                            Platform.Companion.get().log("Callback failure for " + realCall.toLoggableString(), 4, e);
                        } else {
                            this.responseCallback.onFailure(realCall, e);
                        }
                        dispatcher = realCall.getClient().dispatcher();
                        dispatcher.finished$okhttp(this);
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        realCall.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            ExceptionsKt.addSuppressed(iOException, th);
                            this.responseCallback.onFailure(realCall, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
                dispatcher.finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* compiled from: RealCall.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }
    }
}
