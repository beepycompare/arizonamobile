package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import coil3.network.internal.UtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ConnectionShutdownException;
/* compiled from: RetryAndFollowUpInterceptor.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "recover", "", "e", "Ljava/io/IOException;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "userRequest", "Lokhttp3/Request;", "requestIsOneShot", "isRecoverable", "requestSendStarted", "followUpRequest", "userResponse", "exchange", "Lokhttp3/internal/connection/Exchange;", "buildRedirectRequest", FirebaseAnalytics.Param.METHOD, "", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
        r6 = okhttp3.internal.UnreadableResponseBodyKt.stripBody(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
        r7 = r0.priorResponse(r6).build();
        r0 = r1.getInterceptorScopedExchange$okhttp();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r6 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        if (r0 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (r0.isDuplex$okhttp() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        r1.getEventListener$okhttp().followUpDecision(r1, r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
        r13 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        r0 = r6.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
        if (r0.isOneShot() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
        r1.getEventListener$okhttp().followUpDecision(r1, r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
        okhttp3.internal._UtilCommonKt.closeQuietly(r7.body());
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
        if (r8 > 20) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
        r1.getEventListener$okhttp().followUpDecision(r1, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009d, code lost:
        r1.getEventListener$okhttp().followUpDecision(r1, r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
        r1.exitNetworkInterceptorExchange$okhttp(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f1, code lost:
        throw r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = r13.proceed(r0).newBuilder().request(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r7 == null) goto L44;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request followUpRequest;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        List emptyList = CollectionsKt.emptyList();
        boolean z = false;
        int i = 0;
        Response response = null;
        while (true) {
            boolean z2 = true;
            while (true) {
                call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z2, realInterceptorChain);
                try {
                    if (call$okhttp.isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    try {
                        break;
                    } catch (IOException e) {
                        boolean recover = recover(e, call$okhttp, request$okhttp);
                        call$okhttp.getEventListener$okhttp().retryDecision(call$okhttp, e, recover);
                        if (!recover) {
                            throw _UtilCommonKt.withSuppressed(e, emptyList);
                        }
                        emptyList = CollectionsKt.plus((Collection<? extends IOException>) emptyList, e);
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                        z2 = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    z = true;
                }
            }
            call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
            request$okhttp = followUpRequest;
        }
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request) {
        boolean z = iOException instanceof ConnectionShutdownException;
        boolean z2 = !z;
        if (this.client.retryOnConnectionFailure()) {
            return (z || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z2) && realCall.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int code = response.code();
        String method = response.request().method();
        if (code != 307 && code != 308) {
            if (code != 401) {
                if (code == 421) {
                    RequestBody body = response.request().body();
                    if ((body == null || !body.isOneShot()) && exchange != null && exchange.isCoalescedConnection$okhttp()) {
                        exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                        return response.request();
                    }
                    return null;
                } else if (code == 503) {
                    Response priorResponse = response.priorResponse();
                    if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                        return response.request();
                    }
                    return null;
                } else if (code == 407) {
                    Intrinsics.checkNotNull(route);
                    if (route.proxy().type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                    return this.client.proxyAuthenticator().authenticate(route, response);
                } else if (code == 408) {
                    if (this.client.retryOnConnectionFailure()) {
                        RequestBody body2 = response.request().body();
                        if (body2 == null || !body2.isOneShot()) {
                            Response priorResponse2 = response.priorResponse();
                            if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                                return response.request();
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (code) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.client.authenticator().authenticate(route, response);
            }
        }
        return buildRedirectRequest(response, method);
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, com.google.common.net.HttpHeaders.LOCATION, null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (Intrinsics.areEqual(resolve.scheme(), response.request().url().scheme()) || this.client.followSslRedirects()) {
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(str)) {
                int code = response.code();
                boolean z = HttpMethod.INSTANCE.redirectsWithBody(str) || code == 308 || code == 307;
                if (HttpMethod.INSTANCE.redirectsToGet(str) && code != 308 && code != 307) {
                    newBuilder.method(UtilsKt.HTTP_METHOD_GET, null);
                } else {
                    newBuilder.method(str, z ? response.request().body() : null);
                }
                if (!z) {
                    newBuilder.removeHeader("Transfer-Encoding");
                    newBuilder.removeHeader("Content-Length");
                    newBuilder.removeHeader("Content-Type");
                }
            }
            if (!_UtilJvmKt.canReuseConnectionFor(response.request().url(), resolve)) {
                newBuilder.removeHeader(com.google.common.net.HttpHeaders.AUTHORIZATION);
            }
            return newBuilder.url(resolve).build();
        }
        return null;
    }

    private final int retryAfter(Response response, int i) {
        String header$default = Response.header$default(response, com.google.common.net.HttpHeaders.RETRY_AFTER, null, 2, null);
        if (header$default == null) {
            return i;
        }
        if (new Regex("\\d+").matches(header$default)) {
            Integer valueOf = Integer.valueOf(header$default);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* compiled from: RetryAndFollowUpInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "<init>", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
