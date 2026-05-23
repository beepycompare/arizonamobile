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
import okhttp3.internal.UnreadableResponseBody;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
/* compiled from: CallServerInterceptor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "", "code", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallServerInterceptor implements Interceptor {
    public static final CallServerInterceptor INSTANCE = new CallServerInterceptor();

    private final boolean shouldIgnoreAndWaitForRealResponse(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    private CallServerInterceptor() {
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9 A[Catch: IOException -> 0x0205, TryCatch #1 {IOException -> 0x0205, blocks: (B:44:0x00c0, B:46:0x00c9, B:47:0x00cd, B:48:0x00f3, B:50:0x00f9, B:52:0x0102, B:53:0x0105, B:54:0x012c, B:59:0x0138, B:62:0x0143, B:63:0x014a, B:66:0x014e, B:72:0x0160, B:74:0x01a7, B:76:0x01b6, B:83:0x01cb, B:86:0x01da, B:87:0x0204, B:78:0x01c0, B:73:0x018c), top: B:97:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        IOException iOException;
        Response.Builder builder;
        Response build;
        int code;
        boolean z2;
        Response build2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        final Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        Intrinsics.checkNotNull(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = false;
        Response.Builder builder2 = (!HttpMethod.permitsRequestBody(request$okhttp.method()) || body == null) ? null : 1;
        boolean equals = StringsKt.equals("upgrade", request$okhttp.header(com.google.common.net.HttpHeaders.CONNECTION), true);
        try {
            exchange$okhttp.writeRequestHeaders(request$okhttp);
            try {
                if (builder2 != null) {
                    if (StringsKt.equals("100-continue", request$okhttp.header(com.google.common.net.HttpHeaders.EXPECT), true)) {
                        exchange$okhttp.flushRequest();
                        builder2 = exchange$okhttp.readResponseHeaders(true);
                        try {
                            exchange$okhttp.responseHeadersStart();
                            z = false;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (e instanceof ConnectionShutdownException) {
                                throw e;
                            }
                            if (!exchange$okhttp.getHasFailure$okhttp()) {
                                throw e;
                            }
                            Response.Builder builder3 = builder2;
                            iOException = e;
                            builder = builder3;
                            if (builder == null) {
                            }
                            build = builder.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                            code = build.code();
                            while (shouldIgnoreAndWaitForRealResponse(code)) {
                            }
                            exchange$okhttp.responseHeadersEnd(build);
                            if (code != 101) {
                            }
                            if (z2) {
                                throw new ProtocolException("Unexpected 101 code on HTTP/2 connection");
                            }
                            if (z2) {
                            }
                            if (!equals) {
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
                        builder2 = null;
                    }
                    if (builder2 == null) {
                        if (body.isDuplex()) {
                            exchange$okhttp.flushRequest();
                            body.writeTo(Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
                        } else {
                            BufferedSink buffer = Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                            body.writeTo(buffer);
                            buffer.close();
                        }
                    } else {
                        exchange$okhttp.noRequestBody();
                        if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                            exchange$okhttp.noNewExchangesOnConnection();
                        }
                    }
                } else {
                    exchange$okhttp.noRequestBody();
                    z = true;
                    builder2 = null;
                }
                if (body == null || !body.isDuplex()) {
                    exchange$okhttp.finishRequest();
                }
                builder = builder2;
                iOException = null;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            z = true;
            builder2 = null;
        }
        if (builder == null) {
            try {
                builder = exchange$okhttp.readResponseHeaders(false);
                Intrinsics.checkNotNull(builder);
                if (z) {
                    exchange$okhttp.responseHeadersStart();
                    z = false;
                }
            } catch (IOException e4) {
                if (iOException != null) {
                    ExceptionsKt.addSuppressed(iOException, e4);
                    throw iOException;
                }
                throw e4;
            }
        }
        build = builder.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        code = build.code();
        while (shouldIgnoreAndWaitForRealResponse(code)) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(z3);
            Intrinsics.checkNotNull(readResponseHeaders);
            if (z) {
                exchange$okhttp.responseHeadersStart();
            }
            build = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
            z3 = false;
        }
        exchange$okhttp.responseHeadersEnd(build);
        z2 = code != 101;
        if (z2 && exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
            throw new ProtocolException("Unexpected 101 code on HTTP/2 connection");
        }
        boolean z4 = !z2 && StringsKt.equals("upgrade", Response.header$default(build, com.google.common.net.HttpHeaders.CONNECTION, null, 2, null), true);
        if (!equals && z4) {
            build2 = build.newBuilder().body(new UnreadableResponseBody(build.body().contentType(), build.body().contentLength())).socket(exchange$okhttp.upgradeToSocket()).build();
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
