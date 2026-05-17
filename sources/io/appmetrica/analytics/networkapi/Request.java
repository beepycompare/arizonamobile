package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.network.internal.UtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u001b\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/appmetrica/analytics/networkapi/Request;", "", "", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "Lio/appmetrica/analytics/networkapi/Request$Method;", "b", "Lio/appmetrica/analytics/networkapi/Request$Method;", "getMethod", "()Lio/appmetrica/analytics/networkapi/Request$Method;", FirebaseAnalytics.Param.METHOD, "", "c", "[B", "getBody", "()[B", TtmlNode.TAG_BODY, "", "d", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "headers", "Builder", "Method", "network-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class Request {

    /* renamed from: a  reason: collision with root package name */
    private final String f1391a;
    private final Method b;
    private final byte[] c;
    private final Map d;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/networkapi/Request$Builder;", "", "", "key", "value", "addHeader", "", TtmlNode.TAG_BODY, "withBody", "Lio/appmetrica/analytics/networkapi/Request$Method;", FirebaseAnalytics.Param.METHOD, "withMethod", "Lio/appmetrica/analytics/networkapi/Request;", "build", "url", "<init>", "(Ljava/lang/String;)V", "network-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f1392a;
        private Method b = Method.GET;
        private byte[] c = new byte[0];
        private final LinkedHashMap d = new LinkedHashMap();

        public Builder(String str) {
            this.f1392a = str;
        }

        public final Builder addHeader(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public final Request build() {
            return new Request(this.f1392a, this.b, this.c, MapsKt.toMap(this.d), null);
        }

        public final Builder withBody(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public final Builder withMethod(Method method) {
            this.b = method;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/networkapi/Request$Method;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getMethodName", "()Ljava/lang/String;", "methodName", UtilsKt.HTTP_METHOD_GET, "POST", "network-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes5.dex */
    public enum Method {
        GET(UtilsKt.HTTP_METHOD_GET),
        POST("POST");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1393a;

        Method(String str) {
            this.f1393a = str;
        }

        public final String getMethodName() {
            return this.f1393a;
        }
    }

    public /* synthetic */ Request(String str, Method method, byte[] bArr, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, method, bArr, map);
    }

    public final byte[] getBody() {
        return this.c;
    }

    public final Map<String, String> getHeaders() {
        return this.d;
    }

    public final Method getMethod() {
        return this.b;
    }

    public final String getUrl() {
        return this.f1391a;
    }

    public String toString() {
        return "Request(url='" + this.f1391a + "', method='" + this.b + "', bodyLength=" + this.c.length + ", headers=" + this.d + ')';
    }

    private Request(String str, Method method, byte[] bArr, Map map) {
        this.f1391a = str;
        this.b = method;
        this.c = bArr;
        this.d = map;
    }
}
