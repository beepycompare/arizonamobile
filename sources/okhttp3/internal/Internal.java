package okhttp3.internal;

import java.nio.charset.Charset;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
/* compiled from: internal.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0000\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0000\u001a%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 *\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 H\u0000¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$*\u0004\u0018\u00010&H\u0000\u001a\u000e\u0010'\u001a\u00020%*\u0004\u0018\u00010&H\u0000\u001a\u0014\u0010,\u001a\u00020-*\u00020-2\u0006\u0010.\u001a\u00020/H\u0000\u001a\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010.\u001a\u00020/H\u0000\"\u0018\u0010(\u001a\u00020)*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00064"}, d2 = {"parseCookie", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "", "cookieToString", "cookie", "forObsoleteRfc2965", "", "addHeaderLenient", "Lokhttp3/Headers$Builder;", "builder", "line", "name", "value", "cacheGet", "Lokhttp3/Response;", "cache", "Lokhttp3/Cache;", "request", "Lokhttp3/Request;", "applyConnectionSpec", "", "connectionSpec", "Lokhttp3/ConnectionSpec;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "effectiveCipherSuites", "", "socketEnabledCipherSuites", "(Lokhttp3/ConnectionSpec;[Ljava/lang/String;)[Ljava/lang/String;", "chooseCharset", "Lkotlin/Pair;", "Ljava/nio/charset/Charset;", "Lokhttp3/MediaType;", "charsetOrUtf8", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "(Lokhttp3/Response;)Lokhttp3/internal/connection/RealConnection;", "taskRunnerInternal", "Lokhttp3/OkHttpClient$Builder;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "buildConnectionPool", "Lokhttp3/ConnectionPool;", "connectionListener", "Lokhttp3/internal/connection/ConnectionListener;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Internal {
    public static final Cookie parseCookie(long j, HttpUrl url, String setCookie) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j, url, setCookie);
    }

    public static final String cookieToString(Cookie cookie, boolean z) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String line) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return builder.addLenient$okhttp(name, value);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(request, "request");
        return cache.get$okhttp(request);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sslSocket, boolean z) {
        Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z);
    }

    public static final String[] effectiveCipherSuites(ConnectionSpec connectionSpec, String[] socketEnabledCipherSuites) {
        Intrinsics.checkNotNullParameter(connectionSpec, "<this>");
        Intrinsics.checkNotNullParameter(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        return connectionSpec.getCipherSuitesAsString$okhttp() != null ? _UtilCommonKt.intersect(connectionSpec.getCipherSuitesAsString$okhttp(), socketEnabledCipherSuites, CipherSuite.Companion.getORDER_BY_NAME$okhttp()) : socketEnabledCipherSuites;
    }

    public static final Pair<Charset, MediaType> chooseCharset(MediaType mediaType) {
        Charset charset = Charsets.UTF_8;
        if (mediaType != null && (charset = MediaType.charset$default(mediaType, null, 1, null)) == null) {
            charset = Charsets.UTF_8;
            mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
        }
        return TuplesKt.to(charset, mediaType);
    }

    public static final Charset charsetOrUtf8(MediaType mediaType) {
        Charset charset$default;
        return (mediaType == null || (charset$default = MediaType.charset$default(mediaType, null, 1, null)) == null) ? Charsets.UTF_8 : charset$default;
    }

    public static final RealConnection getConnection(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Exchange exchange = response.exchange();
        Intrinsics.checkNotNull(exchange);
        return exchange.getConnection$okhttp();
    }

    public static final OkHttpClient.Builder taskRunnerInternal(OkHttpClient.Builder builder, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        return builder.taskRunner$okhttp(taskRunner);
    }

    public static final ConnectionPool buildConnectionPool(ConnectionListener connectionListener, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(connectionListener, "connectionListener");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        return new ConnectionPool(0, 0L, null, taskRunner, connectionListener, 0, 0, 0, 0, 0, false, false, null, 8167, null);
    }
}
