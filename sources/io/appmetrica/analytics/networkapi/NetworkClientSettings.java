package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001*J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010!\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010&\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010)\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001d¨\u0006+"}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Integer;", "getConnectTimeout", "()Ljava/lang/Integer;", "connectTimeout", "b", "getReadTimeout", "readTimeout", "", "c", "Ljava/lang/Long;", "getCallTimeout", "()Ljava/lang/Long;", "callTimeout", "Ljavax/net/ssl/SSLSocketFactory;", "d", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "", "e", "Ljava/lang/Boolean;", "getUseCaches", "()Ljava/lang/Boolean;", "useCaches", "f", "getInstanceFollowRedirects", "instanceFollowRedirects", "g", "I", "getMaxResponseSize", "()I", "maxResponseSize", CmcdData.STREAMING_FORMAT_HLS, "getCollectMetrics", "collectMetrics", "Builder", "network-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class NetworkClientSettings {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f1373a;
    private final Integer b;
    private final Long c;
    private final SSLSocketFactory d;
    private final Boolean e;
    private final Boolean f;
    private final int g;
    private final Boolean h;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u0018¨\u0006\u001c"}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkClientSettings$Builder;", "", "", "connectTimeout", "withConnectTimeout", "readTimeout", "withReadTimeout", "", "callTimeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "withCallTimeout", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "withSslSocketFactory", "", "useCaches", "withUseCaches", "instanceFollowRedirects", "withInstanceFollowRedirects", "maxResponseSize", "withMaxResponseSize", "collectMetrics", "withCollectMetrics", "Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "build", "<init>", "()V", "network-api_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1374a;
        private Integer b;
        private Long c;
        private SSLSocketFactory d;
        private Boolean e;
        private Boolean f;
        private int g = Integer.MAX_VALUE;
        private Boolean h;

        public final NetworkClientSettings build() {
            return new NetworkClientSettings(this.f1374a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        public final Builder withCallTimeout(long j, TimeUnit timeUnit) {
            this.c = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        public final Builder withCollectMetrics(boolean z) {
            this.h = Boolean.valueOf(z);
            return this;
        }

        public final Builder withConnectTimeout(int i) {
            this.f1374a = Integer.valueOf(i);
            return this;
        }

        public final Builder withInstanceFollowRedirects(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        public final Builder withMaxResponseSize(int i) {
            this.g = i;
            return this;
        }

        public final Builder withReadTimeout(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public final Builder withSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.d = sSLSocketFactory;
            return this;
        }

        public final Builder withUseCaches(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }
    }

    public /* synthetic */ NetworkClientSettings(Integer num, Integer num2, Long l, SSLSocketFactory sSLSocketFactory, Boolean bool, Boolean bool2, int i, Boolean bool3, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, l, sSLSocketFactory, bool, bool2, i, bool3);
    }

    public final Long getCallTimeout() {
        return this.c;
    }

    public final Boolean getCollectMetrics() {
        return this.h;
    }

    public final Integer getConnectTimeout() {
        return this.f1373a;
    }

    public final Boolean getInstanceFollowRedirects() {
        return this.f;
    }

    public final int getMaxResponseSize() {
        return this.g;
    }

    public final Integer getReadTimeout() {
        return this.b;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.d;
    }

    public final Boolean getUseCaches() {
        return this.e;
    }

    public String toString() {
        return "NetworkClientSettings(connectTimeout=" + this.f1373a + ", readTimeout=" + this.b + ", callTimeout=" + this.c + ", sslSocketFactory=" + this.d + ", useCaches=" + this.e + ", instanceFollowRedirects=" + this.f + ", maxResponseSize=" + this.g + ", collectMetrics=" + this.h + ')';
    }

    private NetworkClientSettings(Integer num, Integer num2, Long l, SSLSocketFactory sSLSocketFactory, Boolean bool, Boolean bool2, int i, Boolean bool3) {
        this.f1373a = num;
        this.b = num2;
        this.c = l;
        this.d = sSLSocketFactory;
        this.e = bool;
        this.f = bool2;
        this.g = i;
        this.h = bool3;
    }
}
