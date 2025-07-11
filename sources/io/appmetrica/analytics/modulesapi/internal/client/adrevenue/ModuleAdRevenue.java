package io.appmetrica.analytics.modulesapi.internal.client.adrevenue;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010)\u0012\b\b\u0002\u00104\u001a\u00020/¢\u0006\u0004\b5\u00106R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0019\u0010%\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u0019\u0010(\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R%\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdRevenue;", "", "Ljava/math/BigDecimal;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/math/BigDecimal;", "getAdRevenue", "()Ljava/math/BigDecimal;", "adRevenue", "Ljava/util/Currency;", "b", "Ljava/util/Currency;", "getCurrency", "()Ljava/util/Currency;", FirebaseAnalytics.Param.CURRENCY, "Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdType;", "c", "Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdType;", "getAdType", "()Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdType;", "adType", "", "d", "Ljava/lang/String;", "getAdNetwork", "()Ljava/lang/String;", "adNetwork", "e", "getAdUnitId", "adUnitId", "f", "getAdUnitName", "adUnitName", "g", "getAdPlacementId", "adPlacementId", CmcdData.STREAMING_FORMAT_HLS, "getAdPlacementName", "adPlacementName", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "getPrecision", "precision", "", "j", "Ljava/util/Map;", "getPayload", "()Ljava/util/Map;", "payload", "", "k", "Z", "getAutoCollected", "()Z", "autoCollected", "<init>", "(Ljava/math/BigDecimal;Ljava/util/Currency;Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class ModuleAdRevenue {

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f1208a;
    private final Currency b;
    private final ModuleAdType c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final Map j;
    private final boolean k;

    public ModuleAdRevenue(BigDecimal bigDecimal, Currency currency, ModuleAdType moduleAdType, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, boolean z) {
        this.f1208a = bigDecimal;
        this.b = currency;
        this.c = moduleAdType;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
        this.j = map;
        this.k = z;
    }

    public final String getAdNetwork() {
        return this.d;
    }

    public final String getAdPlacementId() {
        return this.g;
    }

    public final String getAdPlacementName() {
        return this.h;
    }

    public final BigDecimal getAdRevenue() {
        return this.f1208a;
    }

    public final ModuleAdType getAdType() {
        return this.c;
    }

    public final String getAdUnitId() {
        return this.e;
    }

    public final String getAdUnitName() {
        return this.f;
    }

    public final boolean getAutoCollected() {
        return this.k;
    }

    public final Currency getCurrency() {
        return this.b;
    }

    public final Map<String, String> getPayload() {
        return this.j;
    }

    public final String getPrecision() {
        return this.i;
    }

    public /* synthetic */ ModuleAdRevenue(BigDecimal bigDecimal, Currency currency, ModuleAdType moduleAdType, String str, String str2, String str3, String str4, String str5, String str6, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigDecimal, currency, (i & 4) != 0 ? null : moduleAdType, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : map, (i & 1024) != 0 ? true : z);
    }
}
