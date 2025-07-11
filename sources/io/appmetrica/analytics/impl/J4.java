package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class J4 implements ArgumentsMerger {

    /* renamed from: a  reason: collision with root package name */
    public final String f486a;
    public final Boolean b;
    public final Location c;
    public final Boolean d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Boolean h;
    public final Boolean i;
    public final Map<String, String> j;
    public final Integer k;
    public final Boolean l;
    public final Boolean m;
    public final Boolean n;

    public J4(String str, Boolean bool, Location location, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4, Boolean bool5, Boolean bool6, Boolean bool7) {
        this.f486a = str;
        this.b = bool;
        this.c = location;
        this.d = bool2;
        this.e = num;
        this.f = num2;
        this.g = num3;
        this.h = bool3;
        this.i = bool4;
        this.j = map;
        this.k = num4;
        this.l = bool5;
        this.m = bool6;
        this.n = bool7;
    }

    public final boolean a(J4 j4) {
        return equals(j4);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final J4 mergeFrom(J4 j4) {
        return new J4((String) WrapUtils.getOrDefaultNullable(this.f486a, j4.f486a), (Boolean) WrapUtils.getOrDefaultNullable(this.b, j4.b), (Location) WrapUtils.getOrDefaultNullable(this.c, j4.c), (Boolean) WrapUtils.getOrDefaultNullable(this.d, j4.d), (Integer) WrapUtils.getOrDefaultNullable(this.e, j4.e), (Integer) WrapUtils.getOrDefaultNullable(this.f, j4.f), (Integer) WrapUtils.getOrDefaultNullable(this.g, j4.g), (Boolean) WrapUtils.getOrDefaultNullable(this.h, j4.h), (Boolean) WrapUtils.getOrDefaultNullable(this.i, j4.i), (Map) WrapUtils.getOrDefaultNullable(this.j, j4.j), (Integer) WrapUtils.getOrDefaultNullable(this.k, j4.k), (Boolean) WrapUtils.getOrDefaultNullable(this.l, j4.l), (Boolean) WrapUtils.getOrDefaultNullable(this.m, j4.m), (Boolean) WrapUtils.getOrDefaultNullable(this.n, j4.n));
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        return equals((J4) obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && J4.class == obj.getClass()) {
            J4 j4 = (J4) obj;
            if (Objects.equals(this.f486a, j4.f486a) && Objects.equals(this.b, j4.b) && Objects.equals(this.c, j4.c) && Objects.equals(this.d, j4.d) && Objects.equals(this.e, j4.e) && Objects.equals(this.f, j4.f) && Objects.equals(this.g, j4.g) && Objects.equals(this.h, j4.h) && Objects.equals(this.i, j4.i) && Objects.equals(this.j, j4.j) && Objects.equals(this.k, j4.k) && Objects.equals(this.l, j4.l) && Objects.equals(this.m, j4.m) && Objects.equals(this.n, j4.n)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Objects.hashCode(this.b);
        int hashCode2 = Objects.hashCode(this.c);
        int hashCode3 = Objects.hashCode(this.d);
        int hashCode4 = Objects.hashCode(this.e);
        int hashCode5 = Objects.hashCode(this.f);
        int hashCode6 = Objects.hashCode(this.g);
        int hashCode7 = Objects.hashCode(this.h);
        int hashCode8 = Objects.hashCode(this.i);
        int hashCode9 = Objects.hashCode(this.j);
        int hashCode10 = Objects.hashCode(this.k);
        int hashCode11 = Objects.hashCode(this.l);
        int hashCode12 = Objects.hashCode(this.m);
        return Objects.hashCode(this.n) + ((hashCode12 + ((hashCode11 + ((hashCode10 + ((hashCode9 + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (Objects.hashCode(this.f486a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ReporterArguments{apiKey='" + this.f486a + "', locationTracking=" + this.b + ", manualLocation=" + this.c + ", firstActivationAsUpdate=" + this.d + ", sessionTimeout=" + this.e + ", maxReportsCount=" + this.f + ", dispatchPeriod=" + this.g + ", logEnabled=" + this.h + ", dataSendingEnabled=" + this.i + ", clidsFromClient=" + this.j + ", maxReportsInDbCount=" + this.k + ", nativeCrashesEnabled=" + this.l + ", revenueAutoTrackingEnabled=" + this.m + ", advIdentifiersTrackingEnabled=" + this.n + AbstractJsonLexerKt.END_OBJ;
    }

    public J4(CounterConfiguration counterConfiguration, Map<String, String> map) {
        this(counterConfiguration.getApiKey(), counterConfiguration.isLocationTrackingEnabled(), counterConfiguration.getManualLocation(), counterConfiguration.isFirstActivationAsUpdate(), counterConfiguration.getSessionTimeout(), counterConfiguration.getMaxReportsCount(), counterConfiguration.getDispatchPeriod(), counterConfiguration.isLogEnabled(), counterConfiguration.getDataSendingEnabled(), map, counterConfiguration.getMaxReportsInDbCount(), counterConfiguration.getReportNativeCrashesEnabled(), counterConfiguration.isRevenueAutoTrackingEnabled(), counterConfiguration.isAdvIdentifiersTrackingEnabled());
    }

    public J4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
