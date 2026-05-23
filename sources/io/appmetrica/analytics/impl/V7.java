package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class V7 implements InterfaceC0327id {

    /* renamed from: a  reason: collision with root package name */
    public Location f804a;
    public Boolean b;
    public Boolean c;
    public Boolean e;
    public boolean h;
    public String i;
    public boolean k;
    public Qi l;
    public Boolean d = Boolean.FALSE;
    public final LinkedHashMap f = new LinkedHashMap();
    public final LinkedHashMap g = new LinkedHashMap();
    public List<String> j = new ArrayList();

    public final void a(AppMetricaConfig.Builder builder, AppMetricaConfig appMetricaConfig) {
        Boolean bool = this.b;
        if (appMetricaConfig.locationTracking == null && Oo.a(bool)) {
            builder.withLocationTracking(bool.booleanValue());
        }
        Location location = this.f804a;
        if (appMetricaConfig.location == null && Oo.a(location)) {
            builder.withLocation(location);
        }
        Boolean bool2 = this.e;
        if (appMetricaConfig.dataSendingEnabled == null && Oo.a(bool2)) {
            builder.withDataSendingEnabled(bool2.booleanValue());
        }
        if (!Oo.a(appMetricaConfig.userProfileID) && Oo.a(this.i)) {
            builder.withUserProfileID(this.i);
        }
        Boolean bool3 = this.c;
        if (appMetricaConfig.advIdentifiersTracking == null && Oo.a(bool3)) {
            builder.withAdvIdentifiersTracking(bool3.booleanValue());
        }
    }

    public final AppMetricaConfig c(AppMetricaConfig appMetricaConfig) {
        AppMetricaConfig.Builder a2 = a(appMetricaConfig);
        a(a2, appMetricaConfig);
        return a2.build();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void clearAppEnvironment() {
        this.h = true;
        this.f.clear();
    }

    public final AppMetricaConfig d(AppMetricaConfig appMetricaConfig) {
        if (this.k) {
            return appMetricaConfig;
        }
        AppMetricaConfig.Builder a2 = a(appMetricaConfig);
        a(a2, appMetricaConfig);
        this.k = true;
        this.f804a = null;
        this.b = null;
        this.c = null;
        this.d = Boolean.FALSE;
        this.e = null;
        this.f.clear();
        this.g.clear();
        this.h = false;
        this.i = null;
        return a2.build();
    }

    public final C0443n0 j() {
        return new C0443n0(this.j, this.h);
    }

    public final Location k() {
        return this.f804a;
    }

    public final Boolean l() {
        return this.c;
    }

    public final Boolean m() {
        return this.e;
    }

    public final Boolean n() {
        return this.b;
    }

    public final boolean o() {
        return this.h;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void putAppEnvironmentValue(String str, String str2) {
        this.f.put(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void setDataSendingEnabled(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.e = valueOf;
        Qi qi = this.l;
        if (qi != null) {
            qi.a(this.b, valueOf, this.c, this.d);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void setUserProfileID(String str) {
        this.i = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.b = valueOf;
        Qi qi = this.l;
        if (qi != null) {
            qi.a(valueOf, this.e, this.c, this.d);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(boolean z, boolean z2) {
        boolean z3 = this.c == null;
        boolean booleanValue = this.d.booleanValue();
        if (z2 || z3 || !booleanValue) {
            this.c = Boolean.valueOf(z);
            Boolean valueOf = Boolean.valueOf(z2);
            this.d = valueOf;
            Qi qi = this.l;
            if (qi != null) {
                qi.a(this.b, this.e, this.c, valueOf);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(Location location) {
        this.f804a = location;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(String str, String str2) {
        this.g.put(str, str2);
    }

    public final AppMetricaConfig.Builder a(AppMetricaConfig appMetricaConfig) {
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder(appMetricaConfig.apiKey);
        newConfigBuilder.withDeviceType(appMetricaConfig.deviceType);
        newConfigBuilder.withPreloadInfo(appMetricaConfig.preloadInfo);
        newConfigBuilder.withLocation(appMetricaConfig.location);
        if (Oo.a(appMetricaConfig.appVersion)) {
            newConfigBuilder.withAppVersion(appMetricaConfig.appVersion);
        }
        if (Oo.a(appMetricaConfig.dispatchPeriodSeconds)) {
            newConfigBuilder.withDispatchPeriodSeconds(appMetricaConfig.dispatchPeriodSeconds.intValue());
        }
        if (Oo.a(appMetricaConfig.appBuildNumber)) {
            newConfigBuilder.withAppBuildNumber(appMetricaConfig.appBuildNumber.intValue());
        }
        if (Oo.a(appMetricaConfig.maxReportsCount)) {
            newConfigBuilder.withMaxReportsCount(appMetricaConfig.maxReportsCount.intValue());
        }
        if (Oo.a(appMetricaConfig.logs) && appMetricaConfig.logs.booleanValue()) {
            newConfigBuilder.withLogs();
        }
        if (Oo.a(appMetricaConfig.sessionTimeout)) {
            newConfigBuilder.withSessionTimeout(appMetricaConfig.sessionTimeout.intValue());
        }
        if (Oo.a(appMetricaConfig.sessionsAutoTrackingEnabled)) {
            newConfigBuilder.withSessionsAutoTrackingEnabled(appMetricaConfig.sessionsAutoTrackingEnabled.booleanValue());
        }
        if (Oo.a(appMetricaConfig.crashReporting)) {
            newConfigBuilder.withCrashReporting(appMetricaConfig.crashReporting.booleanValue());
        }
        if (Oo.a(appMetricaConfig.nativeCrashReporting)) {
            newConfigBuilder.withNativeCrashReporting(appMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (Oo.a(appMetricaConfig.locationTracking)) {
            newConfigBuilder.withLocationTracking(appMetricaConfig.locationTracking.booleanValue());
        }
        if (Oo.a(appMetricaConfig.advIdentifiersTracking)) {
            newConfigBuilder.withAdvIdentifiersTracking(appMetricaConfig.advIdentifiersTracking.booleanValue());
        }
        if (Oo.a(appMetricaConfig.firstActivationAsUpdate)) {
            newConfigBuilder.handleFirstActivationAsUpdate(appMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (Oo.a(appMetricaConfig.dataSendingEnabled)) {
            newConfigBuilder.withDataSendingEnabled(appMetricaConfig.dataSendingEnabled.booleanValue());
        }
        if (Oo.a(appMetricaConfig.anrMonitoring)) {
            newConfigBuilder.withAnrMonitoring(appMetricaConfig.anrMonitoring.booleanValue());
        }
        if (Oo.a(appMetricaConfig.anrMonitoringTimeout)) {
            newConfigBuilder.withAnrMonitoringTimeout(appMetricaConfig.anrMonitoringTimeout.intValue());
        }
        if (Oo.a(appMetricaConfig.maxReportsInDatabaseCount)) {
            newConfigBuilder.withMaxReportsInDatabaseCount(appMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (Oo.a(appMetricaConfig.crashTransformer)) {
            newConfigBuilder.withCrashTransformer(appMetricaConfig.crashTransformer);
        }
        if (Oo.a(appMetricaConfig.userProfileID)) {
            newConfigBuilder.withUserProfileID(appMetricaConfig.userProfileID);
        }
        if (Oo.a(appMetricaConfig.revenueAutoTrackingEnabled)) {
            newConfigBuilder.withRevenueAutoTrackingEnabled(appMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
        }
        if (Oo.a(appMetricaConfig.appOpenTrackingEnabled)) {
            newConfigBuilder.withAppOpenTrackingEnabled(appMetricaConfig.appOpenTrackingEnabled.booleanValue());
        }
        if (Oo.a((Object) appMetricaConfig.customHosts)) {
            newConfigBuilder.withCustomHosts(appMetricaConfig.customHosts);
        }
        LinkedHashMap linkedHashMap = this.f;
        if (!Oo.a((Map) linkedHashMap)) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                newConfigBuilder.withAppEnvironmentValue((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Map<String, String> map = appMetricaConfig.appEnvironment;
        if (!Oo.a((Map) map)) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                newConfigBuilder.withAppEnvironmentValue(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = this.g;
        if (!Oo.a((Map) linkedHashMap2)) {
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                newConfigBuilder.withErrorEnvironmentValue((String) entry3.getKey(), (String) entry3.getValue());
            }
        }
        Map<String, String> map2 = appMetricaConfig.errorEnvironment;
        if (!Oo.a((Map) map2)) {
            for (Map.Entry<String, String> entry4 : map2.entrySet()) {
                newConfigBuilder.withErrorEnvironmentValue(entry4.getKey(), entry4.getValue());
            }
        }
        Map<String, Object> map3 = appMetricaConfig.additionalConfig;
        if (!Oo.a((Map) map3)) {
            for (Map.Entry<String, Object> entry5 : map3.entrySet()) {
                newConfigBuilder.withAdditionalConfig(entry5.getKey(), entry5.getValue());
            }
        }
        return newConfigBuilder;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327id
    public final void a(String str) {
        this.j.add(str);
    }

    public final void a(Qi qi) {
        Boolean bool = this.b;
        if (bool != null || this.e != null || this.c != null) {
            qi.a(bool, this.e, this.c, this.d);
        }
        this.l = qi;
    }
}
