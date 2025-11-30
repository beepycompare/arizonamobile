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
/* renamed from: io.appmetrica.analytics.impl.p4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0490p4 implements ArgumentsMerger {

    /* renamed from: a  reason: collision with root package name */
    public final String f1059a;
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

    public C0490p4(String str, Boolean bool, Location location, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4, Boolean bool5, Boolean bool6, Boolean bool7, Set set) {
        this.f1059a = str;
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

    public final boolean a(C0490p4 c0490p4) {
        return equals(c0490p4);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0490p4 mergeFrom(C0490p4 c0490p4) {
        return new C0490p4((String) WrapUtils.getOrDefaultNullable(this.f1059a, c0490p4.f1059a), (Boolean) WrapUtils.getOrDefaultNullable(this.b, c0490p4.b), (Location) WrapUtils.getOrDefaultNullable(this.c, c0490p4.c), (Boolean) WrapUtils.getOrDefaultNullable(this.d, c0490p4.d), (Integer) WrapUtils.getOrDefaultNullable(this.e, c0490p4.e), (Integer) WrapUtils.getOrDefaultNullable(this.f, c0490p4.f), (Integer) WrapUtils.getOrDefaultNullable(this.g, c0490p4.g), (Boolean) WrapUtils.getOrDefaultNullable(this.h, c0490p4.h), (Boolean) WrapUtils.getOrDefaultNullable(this.i, c0490p4.i), (Map) WrapUtils.getOrDefaultNullable(this.j, c0490p4.j), (Integer) WrapUtils.getOrDefaultNullable(this.k, c0490p4.k), (Boolean) WrapUtils.getOrDefaultNullable(this.l, c0490p4.l), (Boolean) WrapUtils.getOrDefaultNullable(this.m, c0490p4.m), (Boolean) WrapUtils.getOrDefaultNullable(this.n, c0490p4.n), CollectionUtils.merge(this.o, c0490p4.o));
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        return equals((C0490p4) obj);
    }

    public final boolean equals(Object obj) {
        if (obj != null && C0490p4.class == obj.getClass()) {
            C0490p4 c0490p4 = (C0490p4) obj;
            if (Objects.equals(this.f1059a, c0490p4.f1059a) && Objects.equals(this.b, c0490p4.b) && Objects.equals(this.c, c0490p4.c) && Objects.equals(this.d, c0490p4.d) && Objects.equals(this.e, c0490p4.e) && Objects.equals(this.f, c0490p4.f) && Objects.equals(this.g, c0490p4.g) && Objects.equals(this.h, c0490p4.h) && Objects.equals(this.i, c0490p4.i) && Objects.equals(this.j, c0490p4.j) && Objects.equals(this.k, c0490p4.k) && Objects.equals(this.l, c0490p4.l) && Objects.equals(this.m, c0490p4.m) && Objects.equals(this.n, c0490p4.n) && Objects.equals(this.o, c0490p4.o)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f1059a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    public final String toString() {
        return "ReporterArguments{apiKey='" + this.f1059a + "', locationTracking=" + this.b + ", manualLocation=" + this.c + ", firstActivationAsUpdate=" + this.d + ", sessionTimeout=" + this.e + ", maxReportsCount=" + this.f + ", dispatchPeriod=" + this.g + ", logEnabled=" + this.h + ", dataSendingEnabled=" + this.i + ", clidsFromClient=" + this.j + ", maxReportsInDbCount=" + this.k + ", nativeCrashesEnabled=" + this.l + ", revenueAutoTrackingEnabled=" + this.m + ", advIdentifiersTrackingEnabled=" + this.n + ", autoCollectedDataSubscribers=" + this.o + AbstractJsonLexerKt.END_OBJ;
    }

    public C0490p4(CounterConfiguration counterConfiguration, Map<String, String> map) {
        this(counterConfiguration.getApiKey(), counterConfiguration.isLocationTrackingEnabled(), counterConfiguration.getManualLocation(), counterConfiguration.isFirstActivationAsUpdate(), counterConfiguration.getSessionTimeout(), counterConfiguration.getMaxReportsCount(), counterConfiguration.getDispatchPeriod(), counterConfiguration.isLogEnabled(), counterConfiguration.getDataSendingEnabled(), map, counterConfiguration.getMaxReportsInDbCount(), counterConfiguration.getReportNativeCrashesEnabled(), counterConfiguration.isRevenueAutoTrackingEnabled(), counterConfiguration.isAdvIdentifiersTrackingEnabled(), new HashSet(counterConfiguration.getAutoCollectedDataSubscribers()));
    }

    public C0490p4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, new HashSet());
    }
}
