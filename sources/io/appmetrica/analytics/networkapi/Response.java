package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001'J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R)\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lio/appmetrica/analytics/networkapi/Response;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "isCompleted", "()Z", "", "b", "I", "getCode", "()I", "code", "", "c", "[B", "getResponseData", "()[B", "responseData", "", "", "d", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "headers", "", "e", "Ljava/lang/Throwable;", "getException", "()Ljava/lang/Throwable;", "exception", "f", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "Builder", "network-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class Response {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1389a;
    private final int b;
    private final byte[] c;
    private final Map d;
    private final Throwable e;
    private final String f;

    public /* synthetic */ Response(boolean z, int i, byte[] bArr, Map map, Throwable th, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, bArr, map, th, str);
    }

    public final int getCode() {
        return this.b;
    }

    public final Throwable getException() {
        return this.e;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.d;
    }

    public final byte[] getResponseData() {
        return this.c;
    }

    public final String getUrl() {
        return this.f;
    }

    public final boolean isCompleted() {
        return this.f1389a;
    }

    public String toString() {
        return "Response(isCompleted=" + this.f1389a + ", code=" + this.b + ", responseDataLength=" + this.c.length + ", headers=" + this.d + ", exception=" + this.e + ", url=" + this.f + ')';
    }

    private Response(boolean z, int i, byte[] bArr, Map map, Throwable th, String str) {
        this.f1389a = z;
        this.b = i;
        this.c = bArr;
        this.d = map;
        this.e = th;
        this.f = str;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eB!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\r\u0010\u0015J \u0010\u0006\u001a\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\t¨\u0006\u0016"}, d2 = {"Lio/appmetrica/analytics/networkapi/Response$Builder;", "", "", "", "", "headers", "withHeaders", "url", "withUrl", "Lio/appmetrica/analytics/networkapi/Response;", "build", "", "exception", "<init>", "(Ljava/lang/Throwable;)V", "", "isCompleted", "", "code", "", "responseData", "(ZI[B)V", "network-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f1390a;
        private final int b;
        private final byte[] c;
        private final Throwable d;
        private Map e;
        private String f;

        private Builder(boolean z, int i, byte[] bArr, Throwable th) {
            this.f1390a = z;
            this.b = i;
            this.c = bArr;
            this.d = th;
            this.e = MapsKt.emptyMap();
        }

        public final Response build() {
            return new Response(this.f1390a, this.b, this.c, this.e, this.d, this.f, null);
        }

        public final Builder withHeaders(Map<String, ? extends List<String>> map) {
            this.e = MapsKt.toMap(map);
            return this;
        }

        public final Builder withUrl(String str) {
            this.f = str;
            return this;
        }

        public Builder(Throwable th) {
            this(false, 0, new byte[0], th);
        }

        public Builder(boolean z, int i, byte[] bArr) {
            this(z, i, bArr, null);
        }
    }
}
