package io.appmetrica.analytics.idsync.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u0017\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010&\u001a\u00020\u001e\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\u0004\b,\u0010-J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R)\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010&\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lio/appmetrica/analytics/idsync/internal/model/RequestConfig;", "", "other", "", "equals", "", "hashCode", "", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "b", "getUrl", "url", "Lio/appmetrica/analytics/idsync/internal/model/Preconditions;", "c", "Lio/appmetrica/analytics/idsync/internal/model/Preconditions;", "getPreconditions", "()Lio/appmetrica/analytics/idsync/internal/model/Preconditions;", "preconditions", "", "", "d", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "headers", "", "e", "J", "getResendIntervalForValidResponse", "()J", "resendIntervalForValidResponse", "f", "getResendIntervalForInvalidResponse", "resendIntervalForInvalidResponse", "g", "Ljava/util/List;", "getValidResponseCodes", "()Ljava/util/List;", "validResponseCodes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/appmetrica/analytics/idsync/internal/model/Preconditions;Ljava/util/Map;JJLjava/util/List;)V", "id-sync_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class RequestConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f388a;
    private final String b;
    private final Preconditions c;
    private final Map d;
    private final long e;
    private final long f;
    private final List g;

    public RequestConfig(String str, String str2, Preconditions preconditions, Map<String, ? extends List<String>> map, long j, long j2, List<Integer> list) {
        this.f388a = str;
        this.b = str2;
        this.c = preconditions;
        this.d = map;
        this.e = j;
        this.f = j2;
        this.g = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(RequestConfig.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                RequestConfig requestConfig = (RequestConfig) obj;
                return this.e == requestConfig.e && this.f == requestConfig.f && Intrinsics.areEqual(this.f388a, requestConfig.f388a) && Intrinsics.areEqual(this.b, requestConfig.b) && Intrinsics.areEqual(this.c, requestConfig.c) && Intrinsics.areEqual(this.d, requestConfig.d) && Intrinsics.areEqual(this.g, requestConfig.g);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.idsync.internal.model.RequestConfig");
        }
        return false;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.d;
    }

    public final Preconditions getPreconditions() {
        return this.c;
    }

    public final long getResendIntervalForInvalidResponse() {
        return this.f;
    }

    public final long getResendIntervalForValidResponse() {
        return this.e;
    }

    public final String getType() {
        return this.f388a;
    }

    public final String getUrl() {
        return this.b;
    }

    public final List<Integer> getValidResponseCodes() {
        return this.g;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.f);
        int hashCode2 = this.f388a.hashCode();
        int hashCode3 = this.b.hashCode();
        int hashCode4 = this.c.hashCode();
        int hashCode5 = this.d.hashCode();
        return this.g.hashCode() + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (Long.hashCode(this.e) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "RequestConfig(type='" + this.f388a + "', url='" + this.b + "', preconditions=" + this.c + ", headers=" + this.d + ", resendIntervalForValidResponse=" + this.e + ", resendIntervalForInvalidResponse=" + this.f + ", validResponseCodes=" + this.g + ')';
    }
}
