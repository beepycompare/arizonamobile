package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
/* compiled from: RealInterceptorChain.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010\u0002\u001a\u00020'H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\r\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u000f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "interceptors", "", "Lokhttp3/Interceptor;", FirebaseAnalytics.Param.INDEX, "", "exchange", "Lokhttp3/internal/connection/Exchange;", "request", "Lokhttp3/Request;", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getRequest$okhttp", "()Lokhttp3/Request;", "getConnectTimeoutMillis$okhttp", "()I", "getReadTimeoutMillis$okhttp", "getWriteTimeoutMillis$okhttp", "calls", "copy", "copy$okhttp", "connection", "Lokhttp3/Connection;", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "Lokhttp3/Call;", "proceed", "Lokhttp3/Response;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall call, List<? extends Interceptor> interceptors, int i, Exchange exchange, Request request, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i, Exchange exchange, Request request, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i5 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        if ((i5 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        if ((i5 & 8) != 0) {
            i2 = realInterceptorChain.connectTimeoutMillis;
        }
        if ((i5 & 16) != 0) {
            i3 = realInterceptorChain.readTimeoutMillis;
        }
        if ((i5 & 32) != 0) {
            i4 = realInterceptorChain.writeTimeoutMillis;
        }
        int i6 = i3;
        int i7 = i4;
        return realInterceptorChain.copy$okhttp(i, exchange, request, i2, i6, i7);
    }

    public final RealInterceptorChain copy$okhttp(int i, Exchange exchange, Request request, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i, exchange, request, i2, i3, i4);
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        return exchange != null ? exchange.getConnection$okhttp() : null;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (this.exchange != null) {
            throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
        }
        return copy$okhttp$default(this, 0, null, null, _UtilJvmKt.checkDuration("connectTimeout", i, unit), 0, 0, 55, null);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (this.exchange != null) {
            throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
        }
        return copy$okhttp$default(this, 0, null, null, 0, _UtilJvmKt.checkDuration("readTimeout", i, unit), 0, 47, null);
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (this.exchange != null) {
            throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
        }
        return copy$okhttp$default(this, 0, null, null, 0, 0, _UtilJvmKt.checkDuration("writeTimeout", i, unit), 31, null);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder$okhttp().getRoutePlanner().sameHostAndPort(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response intercept = interceptor.intercept(copy$okhttp$default);
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange == null || this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1) {
            return intercept;
        }
        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
    }
}
