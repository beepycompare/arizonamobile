package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TrailersSource;
import okhttp3.internal.UnreadableResponseBodyKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
/* compiled from: CallServerInterceptor.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "<init>", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", "", "exchange", "Lokhttp3/internal/connection/Exchange;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    private final boolean shouldIgnoreAndWaitForRealResponse(int i, Exchange exchange) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0 A[Catch: IOException -> 0x019a, TryCatch #0 {IOException -> 0x019a, blocks: (B:39:0x00a9, B:41:0x00b2, B:42:0x00b6, B:43:0x00da, B:45:0x00e0, B:47:0x00e9, B:48:0x00ec, B:49:0x0111, B:53:0x011c, B:55:0x013c, B:57:0x014a, B:64:0x0160, B:67:0x016f, B:68:0x0199, B:59:0x0155, B:54:0x0121), top: B:76:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Response.Builder builder;
        Response.Builder builder2;
        Response build;
        int code;
        Response build2;
        Object obj;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        final Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        Intrinsics.checkNotNull(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            exchange$okhttp.writeRequestHeaders(request$okhttp);
            builder = HttpMethod.permitsRequestBody(request$okhttp.method());
            try {
                if (builder != 0 && body != null) {
                    if (StringsKt.equals("100-continue", request$okhttp.header(com.google.common.net.HttpHeaders.EXPECT), true)) {
                        exchange$okhttp.flushRequest();
                        builder = exchange$okhttp.readResponseHeaders(true);
                        try {
                            exchange$okhttp.responseHeadersStart();
                            z = false;
                            obj = builder;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (e instanceof ConnectionShutdownException) {
                                throw e;
                            }
                            builder2 = builder;
                            if (!exchange$okhttp.getHasFailure$okhttp()) {
                                throw e;
                            }
                            if (builder2 == null) {
                            }
                            build = builder2.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                            code = build.code();
                            while (shouldIgnoreAndWaitForRealResponse(code, exchange$okhttp)) {
                            }
                            exchange$okhttp.responseHeadersEnd(build);
                            if (!this.forWebSocket) {
                            }
                            final ResponseBody openResponseBody = exchange$okhttp.openResponseBody(build);
                            build2 = build.newBuilder().body(openResponseBody).trailers(new TrailersSource() { // from class: okhttp3.internal.http.CallServerInterceptor$intercept$1
                                @Override // okhttp3.TrailersSource
                                public Headers peek() {
                                    return Exchange.this.peekTrailers();
                                }

                                @Override // okhttp3.TrailersSource
                                public Headers get() {
                                    BufferedSource source = openResponseBody.source();
                                    if (source.isOpen()) {
                                        _UtilJvmKt.skipAll(source);
                                    }
                                    Headers peek = peek();
                                    if (peek != null) {
                                        return peek;
                                    }
                                    throw new IllegalStateException("null trailers after exhausting response body?!".toString());
                                }
                            }).build();
                            if (!StringsKt.equals("close", build2.request().header(com.google.common.net.HttpHeaders.CONNECTION), true)) {
                            }
                            exchange$okhttp.noNewExchangesOnConnection();
                            if (code != 204) {
                            }
                            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + build2.body().contentLength());
                        }
                    } else {
                        z = true;
                        obj = null;
                    }
                    if (obj == null) {
                        if (body.isDuplex()) {
                            exchange$okhttp.flushRequest();
                            body.writeTo(Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
                            builder = obj;
                        } else {
                            BufferedSink buffer = Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                            body.writeTo(buffer);
                            buffer.close();
                            builder = obj;
                        }
                    } else {
                        exchange$okhttp.noRequestBody();
                        builder = obj;
                        if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                            exchange$okhttp.noNewExchangesOnConnection();
                            builder = obj;
                        }
                    }
                } else {
                    exchange$okhttp.noRequestBody();
                    z = true;
                    builder = 0;
                }
                if (body == null || !body.isDuplex()) {
                    exchange$okhttp.finishRequest();
                }
                e = null;
                builder2 = builder;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            z = true;
            builder = null;
        }
        if (builder2 == null) {
            try {
                builder2 = exchange$okhttp.readResponseHeaders(false);
                Intrinsics.checkNotNull(builder2);
                if (z) {
                    exchange$okhttp.responseHeadersStart();
                    z = false;
                }
            } catch (IOException e4) {
                if (e != null) {
                    ExceptionsKt.addSuppressed(e, e4);
                    throw e;
                }
                throw e4;
            }
        }
        build = builder2.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        code = build.code();
        while (shouldIgnoreAndWaitForRealResponse(code, exchange$okhttp)) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            if (z) {
                exchange$okhttp.responseHeadersStart();
            }
            build = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange$okhttp.responseHeadersEnd(build);
        if (!this.forWebSocket && code == 101) {
            build2 = UnreadableResponseBodyKt.stripBody(build);
        } else {
            final ResponseBody openResponseBody2 = exchange$okhttp.openResponseBody(build);
            build2 = build.newBuilder().body(openResponseBody2).trailers(new TrailersSource() { // from class: okhttp3.internal.http.CallServerInterceptor$intercept$1
                @Override // okhttp3.TrailersSource
                public Headers peek() {
                    return Exchange.this.peekTrailers();
                }

                @Override // okhttp3.TrailersSource
                public Headers get() {
                    BufferedSource source = openResponseBody2.source();
                    if (source.isOpen()) {
                        _UtilJvmKt.skipAll(source);
                    }
                    Headers peek = peek();
                    if (peek != null) {
                        return peek;
                    }
                    throw new IllegalStateException("null trailers after exhausting response body?!".toString());
                }
            }).build();
        }
        if (!StringsKt.equals("close", build2.request().header(com.google.common.net.HttpHeaders.CONNECTION), true) || StringsKt.equals("close", Response.header$default(build2, com.google.common.net.HttpHeaders.CONNECTION, null, 2, null), true)) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if ((code != 204 || code == 205) && build2.body().contentLength() > 0) {
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + build2.body().contentLength());
        }
        return build2;
    }
}
