package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class F4 implements ArgumentsMerger {

    /* renamed from: a  reason: collision with root package name */
    public final String f538a;
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
    public final Set<String> o;

    public F4(String str, Boolean bool, Location location, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4, Boolean bool5, Boolean bool6, Boolean bool7, Set set) {
        this.f538a = str;
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
        this.o = set;
    }

    public final boolean a(F4 f4) {
        return equals(f4);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final F4 mergeFrom(F4 f4) {
        return new F4((String) WrapUtils.getOrDefaultNullable(this.f538a, f4.f538a), (Boolean) WrapUtils.getOrDefaultNullable(this.b, f4.b), (Location) WrapUtils.getOrDefaultNullable(this.c, f4.c), (Boolean) WrapUtils.getOrDefaultNullable(this.d, f4.d), (Integer) WrapUtils.getOrDefaultNullable(this.e, f4.e), (Integer) WrapUtils.getOrDefaultNullable(this.f, f4.f), (Integer) WrapUtils.getOrDefaultNullable(this.g, f4.g), (Boolean) WrapUtils.getOrDefaultNullable(this.h, f4.h), (Boolean) WrapUtils.getOrDefaultNullable(this.i, f4.i), (Map) WrapUtils.getOrDefaultNullable(this.j, f4.j), (Integer) WrapUtils.getOrDefaultNullable(this.k, f4.k), (Boolean) WrapUtils.getOrDefaultNullable(this.l, f4.l), (Boolean) WrapUtils.getOrDefaultNullable(this.m, f4.m), (Boolean) WrapUtils.getOrDefaultNullable(this.n, f4.n), CollectionUtils.merge(this.o, f4.o));
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        return equals((F4) obj);
    }

    public final boolean equals(Object obj) {
        if (obj != null && F4.class == obj.getClass()) {
            F4 f4 = (F4) obj;
            if (Objects.equals(this.f538a, f4.f538a) && Objects.equals(this.b, f4.b) && Objects.equals(this.c, f4.c) && Objects.equals(this.d, f4.d) && Objects.equals(this.e, f4.e) && Objects.equals(this.f, f4.f) && Objects.equals(this.g, f4.g) && Objects.equals(this.h, f4.h) && Objects.equals(this.i, f4.i) && Objects.equals(this.j, f4.j) && Objects.equals(this.k, f4.k) && Objects.equals(this.l, f4.l) && Objects.equals(this.m, f4.m) && Objects.equals(this.n, f4.n) && Objects.equals(this.o, f4.o)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f538a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    public final String toString() {
        return "ReporterArguments{apiKey='" + this.f538a + "', locationTracking=" + this.b + ", manualLocation=" + this.c + ", firstActivationAsUpdate=" + this.d + ", sessionTimeout=" + this.e + ", maxReportsCount=" + this.f + ", dispatchPeriod=" + this.g + ", logEnabled=" + this.h + ", dataSendingEnabled=" + this.i + ", clidsFromClient=" + this.j + ", maxReportsInDbCount=" + this.k + ", nativeCrashesEnabled=" + this.l + ", revenueAutoTrackingEnabled=" + this.m + ", advIdentifiersTrackingEnabled=" + this.n + ", autoCollectedDataSubscribers=" + this.o + AbstractJsonLexerKt.END_OBJ;
    }

    public F4(CounterConfiguration counterConfiguration, Map<String, String> map) {
        this(counterConfiguration.getApiKey(), counterConfiguration.isLocationTrackingEnabled(), counterConfiguration.getManualLocation(), counterConfiguration.isFirstActivationAsUpdate(), counterConfiguration.getSessionTimeout(), counterConfiguration.getMaxReportsCount(), counterConfiguration.getDispatchPeriod(), counterConfiguration.isLogEnabled(), counterConfiguration.getDataSendingEnabled(), map, counterConfiguration.getMaxReportsInDbCount(), counterConfiguration.getReportNativeCrashesEnabled(), counterConfiguration.isRevenueAutoTrackingEnabled(), counterConfiguration.isAdvIdentifiersTrackingEnabled(), new HashSet(counterConfiguration.getAutoCollectedDataSubscribers()));
    }

    public F4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, new HashSet());
    }
}
