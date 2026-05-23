package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001!J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkCallMetrics;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Long;", "getDnsLookup", "()Ljava/lang/Long;", "dnsLookup", "b", "getTcpConnect", "tcpConnect", "c", "getTlsHandshake", "tlsHandshake", "d", "getTimeToFirstByte", "timeToFirstByte", "e", "getResponse", "response", "", "f", "Z", "getConnectionReused", "()Z", "connectionReused", "g", "Ljava/lang/String;", "getProtocol", "()Ljava/lang/String;", "protocol", "Builder", "network-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class NetworkCallMetrics {

    /* renamed from: a  reason: collision with root package name */
    private final Long f1366a;
    private final Long b;
    private final Long c;
    private final Long d;
    private final Long e;
    private final boolean f;
    private final String g;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0014¨\u0006\u0018"}, d2 = {"Lio/appmetrica/analytics/networkapi/NetworkCallMetrics$Builder;", "", "", "dnsLookup", "withDnsLookup", "(Ljava/lang/Long;)Lio/appmetrica/analytics/networkapi/NetworkCallMetrics$Builder;", "tcpConnect", "withTcpConnect", "tlsHandshake", "withTlsHandshake", "timeToFirstByte", "withTimeToFirstByte", "response", "withResponse", "", "connectionReused", "withConnectionReused", "", "protocol", "withProtocol", "Lio/appmetrica/analytics/networkapi/NetworkCallMetrics;", "build", "<init>", "()V", "network-api_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f1367a;
        private Long b;
        private Long c;
        private Long d;
        private Long e;
        private boolean f;
        private String g;

        public final NetworkCallMetrics build() {
            return new NetworkCallMetrics(this.f1367a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        public final Builder withConnectionReused(boolean z) {
            this.f = z;
            return this;
        }

        public final Builder withDnsLookup(Long l) {
            this.f1367a = l;
            return this;
        }

        public final Builder withProtocol(String str) {
            this.g = str;
            return this;
        }

        public final Builder withResponse(Long l) {
            this.e = l;
            return this;
        }

        public final Builder withTcpConnect(Long l) {
            this.b = l;
            return this;
        }

        public final Builder withTimeToFirstByte(Long l) {
            this.d = l;
            return this;
        }

        public final Builder withTlsHandshake(Long l) {
            this.c = l;
            return this;
        }
    }

    public /* synthetic */ NetworkCallMetrics(Long l, Long l2, Long l3, Long l4, Long l5, boolean z, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2, l3, l4, l5, z, str);
    }

    public final boolean getConnectionReused() {
        return this.f;
    }

    public final Long getDnsLookup() {
        return this.f1366a;
    }

    public final String getProtocol() {
        return this.g;
    }

    public final Long getResponse() {
        return this.e;
    }

    public final Long getTcpConnect() {
        return this.b;
    }

    public final Long getTimeToFirstByte() {
        return this.d;
    }

    public final Long getTlsHandshake() {
        return this.c;
    }

    public String toString() {
        return "NetworkCallMetrics(dnsLookup=" + this.f1366a + ", tcpConnect=" + this.b + ", tlsHandshake=" + this.c + ", timeToFirstByte=" + this.d + ", response=" + this.e + ", connectionReused=" + this.f + ", protocol=" + this.g + ')';
    }

    private NetworkCallMetrics(Long l, Long l2, Long l3, Long l4, Long l5, boolean z, String str) {
        this.f1366a = l;
        this.b = l2;
        this.c = l3;
        this.d = l4;
        this.e = l5;
        this.f = z;
        this.g = str;
    }
}
