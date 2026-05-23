package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.facebook.widget.FacebookDialog;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Socket;
import okio.Source;
/* compiled from: Exchange.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002BCB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020 J\u0006\u0010(\u001a\u00020 J\u0010\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0013J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020.J\b\u00101\u001a\u0004\u0018\u000102J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020 J\u0006\u00106\u001a\u00020 J\u0006\u00107\u001a\u00020 J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0002J8\u0010;\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00132\b\b\u0002\u0010?\u001a\u00020\u00132\b\b\u0002\u0010@\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u00010:J\u0006\u0010A\u001a\u00020 R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016¨\u0006D"}, d2 = {"Lokhttp3/internal/connection/Exchange;", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "value", "", "isDuplex", "isDuplex$okhttp", "()Z", "hasFailure", "getHasFailure$okhttp", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "isCoalescedConnection", "isCoalescedConnection$okhttp", "writeRequestHeaders", "", "request", "Lokhttp3/Request;", "createRequestBody", "Lokio/Sink;", "duplex", "flushRequest", "finishRequest", "responseHeadersStart", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "responseHeadersEnd", "response", "Lokhttp3/Response;", "openResponseBody", "Lokhttp3/ResponseBody;", "peekTrailers", "Lokhttp3/Headers;", "upgradeToSocket", "Lokio/Socket;", "noNewExchangesOnConnection", FacebookDialog.COMPLETION_GESTURE_CANCEL, "detachWithViolence", "trackFailure", "e", "Ljava/io/IOException;", "bodyComplete", "bytesRead", "", "isSocket", "responseDone", "requestDone", "noRequestBody", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    public Exchange(RealCall call, EventListener eventListener, ExchangeFinder finder, ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final RealConnection getConnection$okhttp() {
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        RealConnection realConnection = carrier instanceof RealConnection ? (RealConnection) carrier : null;
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels".toString());
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual(this.finder.getRoutePlanner().getAddress().url().host(), this.codec.getCarrier().getRoute().address().url().host());
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final Sink createRequestBody(Request request, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.isDuplex = z;
        RequestBody body = request.body();
        Intrinsics.checkNotNull(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength, false);
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        Exchange exchange;
        String header$default;
        long reportedContentLength;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            header$default = Response.header$default(response, "Content-Type", null, 2, null);
            reportedContentLength = this.codec.reportedContentLength(response);
            exchange = this;
        } catch (IOException e) {
            e = e;
            exchange = this;
        }
        try {
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer(new ResponseBodySource(exchange, this.codec.openResponseBodySource(response), reportedContentLength, false)));
        } catch (IOException e2) {
            e = e2;
            IOException iOException = e;
            exchange.eventListener.responseFailed(exchange.call, iOException);
            exchange.trackFailure(iOException);
            throw iOException;
        }
    }

    public final Headers peekTrailers() throws IOException {
        return this.codec.peekTrailers();
    }

    public final Socket upgradeToSocket() {
        this.call.upgradeToSocket();
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        Intrinsics.checkNotNull(carrier, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        ((RealConnection) carrier).useAsSocket$okhttp();
        return new Socket() { // from class: okhttp3.internal.connection.Exchange$upgradeToSocket$1
            private final Exchange.RequestBodySink sink;
            private final Exchange.ResponseBodySource source;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.sink = new Exchange.RequestBodySink(Exchange.this, Exchange.this.codec.getSocket().getSink(), -1L, true);
                this.source = new Exchange.ResponseBodySource(Exchange.this, Exchange.this.codec.getSocket().getSource(), -1L, true);
            }

            @Override // okio.Socket
            public void cancel() {
                Exchange.this.cancel();
            }

            @Override // okio.Socket
            public Exchange.RequestBodySink getSink() {
                return this.sink;
            }

            @Override // okio.Socket
            public Exchange.ResponseBodySource getSource() {
                return this.source;
            }
        };
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getCarrier().noNewExchanges();
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, true, true, null);
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.codec.getCarrier().trackFailure(this.call, iOException);
    }

    public static /* synthetic */ IOException bodyComplete$default(Exchange exchange, long j, boolean z, boolean z2, boolean z3, IOException iOException, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return exchange.bodyComplete(j, z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, iOException);
    }

    public final IOException bodyComplete(long j, boolean z, boolean z2, boolean z3, IOException iOException) {
        boolean z4;
        boolean z5;
        boolean z6;
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z3) {
            EventListener eventListener = this.eventListener;
            if (iOException != null) {
                eventListener.requestFailed(this.call, iOException);
            } else {
                eventListener.requestBodyEnd(this.call, j);
            }
        }
        if (z2) {
            EventListener eventListener2 = this.eventListener;
            if (iOException != null) {
                eventListener2.responseFailed(this.call, iOException);
            } else {
                eventListener2.responseBodyEnd(this.call, j);
            }
        }
        RealCall realCall = this.call;
        boolean z7 = true;
        if (!z3 || z) {
            z4 = true;
            z7 = false;
        } else {
            z4 = true;
        }
        if (!z2 || z) {
            z5 = z;
            z6 = false;
        } else {
            z5 = z;
            z6 = z4;
        }
        return realCall.messageDone$okhttp(this, z7, z6, (z2 && z5) ? z4 : false, (z3 && z5) ? z4 : false, iOException);
    }

    public final void noRequestBody() {
        RealCall.messageDone$okhttp$default(this.call, this, true, false, false, false, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Exchange.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "contentLength", "", "isSocket", "", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;JZ)V", "completed", "bytesReceived", "invokeStartEvent", "closed", "write", "", "source", "Lokio/Buffer;", "byteCount", "flush", "close", "complete", "Ljava/io/IOException;", "e", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink delegate, long j, boolean z) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
            this.isSocket = z;
            this.invokeStartEvent = z;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.contentLength;
            if (j2 != -1 && this.bytesReceived + j > j2) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
            }
            try {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().requestBodyStart(this.this$0.getCall$okhttp());
                }
                super.write(source, j);
                this.bytesReceived += j;
            } catch (IOException e) {
                IOException complete = complete(e);
                Intrinsics.checkNotNull(complete);
                throw complete;
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                IOException complete = complete(e);
                Intrinsics.checkNotNull(complete);
                throw complete;
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                IOException complete = complete(e);
                Intrinsics.checkNotNull(complete);
                throw complete;
            }
        }

        private final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, false, true, iOException, 4, null);
        }
    }

    /* compiled from: Exchange.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "contentLength", "", "isSocket", "", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;JZ)V", "bytesReceived", "invokeStartEvent", "completed", "closed", "read", "sink", "Lokio/Buffer;", "byteCount", "close", "", "complete", "Ljava/io/IOException;", "e", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source delegate, long j, boolean z) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j;
            this.isSocket = z;
            this.invokeStartEvent = true;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long read = delegate().read(sink, j);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (read == -1) {
                    complete(null);
                    return -1L;
                }
                long j2 = this.bytesReceived + read;
                long j3 = this.contentLength;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j2);
                }
                this.bytesReceived = j2;
                if (this.this$0.codec.isResponseComplete()) {
                    complete(null);
                }
                return read;
            } catch (IOException e) {
                IOException complete = complete(e);
                Intrinsics.checkNotNull(complete);
                throw complete;
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                IOException complete = complete(e);
                Intrinsics.checkNotNull(complete);
                throw complete;
            }
        }

        public final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, true, false, iOException, 8, null);
        }
    }
}
