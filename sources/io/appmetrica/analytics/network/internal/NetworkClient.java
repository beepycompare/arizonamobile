package io.appmetrica.analytics.network.internal;

import io.appmetrica.analytics.network.impl.c;
import io.appmetrica.analytics.network.impl.d;
import javax.net.ssl.SSLSocketFactory;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f1221a;
    private final Integer b;
    private final SSLSocketFactory c;
    private final Boolean d;
    private final Boolean e;
    private final int f;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1222a;
        private Integer b;
        private SSLSocketFactory c;
        private Boolean d;
        private Boolean e;
        private Integer f;

        public NetworkClient build() {
            return new NetworkClient(this.f1222a, this.b, this.c, this.d, this.e, this.f, 0);
        }

        public Builder withConnectTimeout(int i) {
            this.f1222a = Integer.valueOf(i);
            return this;
        }

        public Builder withInstanceFollowRedirects(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        public Builder withMaxResponseSize(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        public Builder withReadTimeout(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public Builder withSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.c = sSLSocketFactory;
            return this;
        }

        public Builder withUseCaches(boolean z) {
            this.d = Boolean.valueOf(z);
            return this;
        }
    }

    /* synthetic */ NetworkClient(Integer num, Integer num2, SSLSocketFactory sSLSocketFactory, Boolean bool, Boolean bool2, Integer num3, int i) {
        this(num, num2, sSLSocketFactory, bool, bool2, num3);
    }

    public Integer getConnectTimeout() {
        return this.f1221a;
    }

    public Boolean getInstanceFollowRedirects() {
        return this.e;
    }

    public int getMaxResponseSize() {
        return this.f;
    }

    public Integer getReadTimeout() {
        return this.b;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.c;
    }

    public Boolean getUseCaches() {
        return this.d;
    }

    public Call newCall(Request request) {
        return new c(this, request, new d());
    }

    public String toString() {
        return "NetworkClient{connectTimeout=" + this.f1221a + ", readTimeout=" + this.b + ", sslSocketFactory=" + this.c + ", useCaches=" + this.d + ", instanceFollowRedirects=" + this.e + ", maxResponseSize=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    private NetworkClient(Integer num, Integer num2, SSLSocketFactory sSLSocketFactory, Boolean bool, Boolean bool2, Integer num3) {
        this.f1221a = num;
        this.b = num2;
        this.c = sSLSocketFactory;
        this.d = bool;
        this.e = bool2;
        this.f = num3 == null ? Integer.MAX_VALUE : num3.intValue();
    }
}
