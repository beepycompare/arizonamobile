package io.appmetrica.analytics.networkapi;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.network.internal.UtilsKt;
import com.android.volley.toolbox.HttpClientStack;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.liulishuo.okdownload.core.Util;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u001b\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/appmetrica/analytics/networkapi/Request;", "", "", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "Lio/appmetrica/analytics/networkapi/Request$Method;", "b", "Lio/appmetrica/analytics/networkapi/Request$Method;", "getMethod", "()Lio/appmetrica/analytics/networkapi/Request$Method;", FirebaseAnalytics.Param.METHOD, "", "c", "[B", "getBody", "()[B", TtmlNode.TAG_BODY, "", "d", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "headers", "Builder", "Method", "network-api_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class Request {

    /* renamed from: a  reason: collision with root package name */
    private final String f1375a;
    private final Method b;
    private final byte[] c;
    private final Map d;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/networkapi/Request$Builder;", "", "", "key", "value", "addHeader", "", TtmlNode.TAG_BODY, "withBody", "Lio/appmetrica/analytics/networkapi/Request$Method;", FirebaseAnalytics.Param.METHOD, "withMethod", "Lio/appmetrica/analytics/networkapi/Request;", "build", "url", "<init>", "(Ljava/lang/String;)V", "network-api_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f1376a;
        private Method b = Method.GET;
        private byte[] c = new byte[0];
        private final LinkedHashMap d = new LinkedHashMap();

        public Builder(String str) {
            this.f1376a = str;
        }

        public final Builder addHeader(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public final Request build() {
            return new Request(this.f1376a, this.b, this.c, MapsKt.toMap(this.d), null);
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lio/appmetrica/analytics/networkapi/Request$Method;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getMethodName", "()Ljava/lang/String;", "methodName", UtilsKt.HTTP_METHOD_GET, "POST", Util.METHOD_HEAD, "PUT", "DELETE", HttpClientStack.HttpPatch.METHOD_NAME, "OPTIONS", "network-api_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Method {
        public static final Method DELETE;
        public static final Method GET;
        public static final Method HEAD;
        public static final Method OPTIONS;
        public static final Method PATCH;
        public static final Method POST;
        public static final Method PUT;
        private static final /* synthetic */ Method[] b;
        private static final /* synthetic */ EnumEntries c;

        /* renamed from: a  reason: collision with root package name */
        private final String f1377a;

        static {
            Method method = new Method(UtilsKt.HTTP_METHOD_GET, 0, UtilsKt.HTTP_METHOD_GET);
            GET = method;
            Method method2 = new Method("POST", 1, "POST");
            POST = method2;
            Method method3 = new Method(Util.METHOD_HEAD, 2, Util.METHOD_HEAD);
            HEAD = method3;
            Method method4 = new Method("PUT", 3, "PUT");
            PUT = method4;
            Method method5 = new Method("DELETE", 4, "DELETE");
            DELETE = method5;
            Method method6 = new Method(HttpClientStack.HttpPatch.METHOD_NAME, 5, HttpClientStack.HttpPatch.METHOD_NAME);
            PATCH = method6;
            Method method7 = new Method("OPTIONS", 6, "OPTIONS");
            OPTIONS = method7;
            Method[] methodArr = {method, method2, method3, method4, method5, method6, method7};
            b = methodArr;
            c = EnumEntriesKt.enumEntries(methodArr);
        }

        private Method(String str, int i, String str2) {
            this.f1377a = str2;
        }

        public static EnumEntries<Method> getEntries() {
            return c;
        }

        public static Method valueOf(String str) {
            return (Method) Enum.valueOf(Method.class, str);
        }

        public static Method[] values() {
            return (Method[]) b.clone();
        }

        public final String getMethodName() {
            return this.f1377a;
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
        return this.f1375a;
    }

    public String toString() {
        return "Request(url='" + this.f1375a + "', method='" + this.b + "', bodyLength=" + this.c.length + ", headers=" + this.d + ')';
    }

    private Request(String str, Method method, byte[] bArr, Map map) {
        this.f1375a = str;
        this.b = method;
        this.c = bArr;
        this.d = map;
    }
}
