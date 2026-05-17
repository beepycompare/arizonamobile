package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001!J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010 \u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Integer;", "getConnectTimeout", "()Ljava/lang/Integer;", "connectTimeout", "b", "getReadTimeout", "readTimeout", "Ljavax/net/ssl/SSLSocketFactory;", "c", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "", "d", "Ljava/lang/Boolean;", "getUseCaches", "()Ljava/lang/Boolean;", "useCaches", "e", "getInstanceFollowRedirects", "instanceFollowRedirects", "f", "I", "getMaxResponseSize", "()I", "maxResponseSize", "Builder", "network-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class NetworkClientSettings {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f1389a;
    private final Integer b;
    private final SSLSocketFactory c;
    private final Boolean d;
    private final Boolean e;
    private final int f;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0011¨\u0006\u0015"}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkClientSettings$Builder;", "", "", "connectTimeout", "withConnectTimeout", "readTimeout", "withReadTimeout", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "withSslSocketFactory", "", "useCaches", "withUseCaches", "instanceFollowRedirects", "withInstanceFollowRedirects", "maxResponseSize", "withMaxResponseSize", "Lio/appmetrica/analytics/networkapi/NetworkClientSettings;", "build", "<init>", "()V", "network-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1390a;
        private Integer b;
        private SSLSocketFactory c;
        private Boolean d;
        private Boolean e;
        private int f = Integer.MAX_VALUE;

        public final NetworkClientSettings build() {
            return new NetworkClientSettings(this.f1390a, this.b, this.c, this.d, this.e, this.f, null);
        }

        public final Builder withConnectTimeout(int i) {
            this.f1390a = Integer.valueOf(i);
            return this;
        }

        public final Builder withInstanceFollowRedirects(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        public final Builder withMaxResponseSize(int i) {
            this.f = i;
            return this;
        }

        public final Builder withReadTimeout(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public final Builder withSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.c = sSLSocketFactory;
            return this;
        }

        public final Builder withUseCaches(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }
    }

    public /* synthetic */ NetworkClientSettings(Integer num, Integer num2, SSLSocketFactory sSLSocketFactory, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, sSLSocketFactory, bool, bool2, i);
    }

    public final Integer getConnectTimeout() {
        return this.f1389a;
    }

    public final Boolean getInstanceFollowRedirects() {
        return this.e;
    }

    public final int getMaxResponseSize() {
        return this.f;
    }

    public final Integer getReadTimeout() {
        return this.b;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.c;
    }

    public final Boolean getUseCaches() {
        return this.d;
    }

    public String toString() {
        return "NetworkClientSettings(connectTimeout=" + this.f1389a + ", readTimeout=" + this.b + ", sslSocketFactory=" + this.c + ", useCaches=" + this.d + ", instanceFollowRedirects=" + this.e + ", maxResponseSize=" + this.f + ')';
    }

    private NetworkClientSettings(Integer num, Integer num2, SSLSocketFactory sSLSocketFactory, Boolean bool, Boolean bool2, int i) {
        this.f1389a = num;
        this.b = num2;
        this.c = sSLSocketFactory;
        this.d = bool;
        this.e = bool2;
        this.f = i;
    }
}
