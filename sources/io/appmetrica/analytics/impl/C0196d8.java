package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.d8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0196d8 implements InterfaceC0304hd {

    /* renamed from: a  reason: collision with root package name */
    public Location f840a;
    public Boolean b;
    public Boolean c;
    public Boolean d;
    public boolean g;
    public String h;
    public boolean j;
    public Si k;
    public final LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public List<String> i = new ArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.b = valueOf;
        Si si = this.k;
        if (si != null) {
            si.a(valueOf, this.d, this.c);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void b(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.c = valueOf;
        Si si = this.k;
        if (si != null) {
            si.a(this.b, this.d, valueOf);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void clearAppEnvironment() {
        this.g = true;
        this.e.clear();
    }

    public final C0368k0 j() {
        return new C0368k0(this.i, this.g);
    }

    public final Location k() {
        return this.f840a;
    }

    public final Boolean l() {
        return this.c;
    }

    public final Boolean m() {
        return this.d;
    }

    public final Boolean n() {
        return this.b;
    }

    public final boolean o() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void putAppEnvironmentValue(String str, String str2) {
        this.e.put(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void setDataSendingEnabled(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.d = valueOf;
        Si si = this.k;
        if (si != null) {
            si.a(this.b, valueOf, this.c);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void setUserProfileID(String str) {
        this.h = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(Location location) {
        this.f840a = location;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(String str, String str2) {
        this.f.put(str, str2);
    }

    public final AppMetricaConfig a(AppMetricaConfig appMetricaConfig) {
        if (this.j) {
            return appMetricaConfig;
        }
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder(appMetricaConfig.apiKey);
        newConfigBuilder.withDeviceType(appMetricaConfig.deviceType);
        newConfigBuilder.withPreloadInfo(appMetricaConfig.preloadInfo);
        newConfigBuilder.withLocation(appMetricaConfig.location);
        if (ro.a(appMetricaConfig.appVersion)) {
            newConfigBuilder.withAppVersion(appMetricaConfig.appVersion);
        }
        if (ro.a(appMetricaConfig.dispatchPeriodSeconds)) {
            newConfigBuilder.withDispatchPeriodSeconds(appMetricaConfig.dispatchPeriodSeconds.intValue());
        }
        if (ro.a(appMetricaConfig.appBuildNumber)) {
            newConfigBuilder.withAppBuildNumber(appMetricaConfig.appBuildNumber.intValue());
        }
        if (ro.a(appMetricaConfig.maxReportsCount)) {
            newConfigBuilder.withMaxReportsCount(appMetricaConfig.maxReportsCount.intValue());
        }
        if (ro.a(appMetricaConfig.logs) && appMetricaConfig.logs.booleanValue()) {
            newConfigBuilder.withLogs();
        }
        if (ro.a(appMetricaConfig.sessionTimeout)) {
            newConfigBuilder.withSessionTimeout(appMetricaConfig.sessionTimeout.intValue());
        }
        if (ro.a(appMetricaConfig.sessionsAutoTrackingEnabled)) {
            newConfigBuilder.withSessionsAutoTrackingEnabled(appMetricaConfig.sessionsAutoTrackingEnabled.booleanValue());
        }
        if (ro.a(appMetricaConfig.crashReporting)) {
            newConfigBuilder.withCrashReporting(appMetricaConfig.crashReporting.booleanValue());
        }
        if (ro.a(appMetricaConfig.nativeCrashReporting)) {
            newConfigBuilder.withNativeCrashReporting(appMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (ro.a(appMetricaConfig.locationTracking)) {
            newConfigBuilder.withLocationTracking(appMetricaConfig.locationTracking.booleanValue());
        }
        if (ro.a(appMetricaConfig.advIdentifiersTracking)) {
            newConfigBuilder.withAdvIdentifiersTracking(appMetricaConfig.advIdentifiersTracking.booleanValue());
        }
        if (ro.a(appMetricaConfig.firstActivationAsUpdate)) {
            newConfigBuilder.handleFirstActivationAsUpdate(appMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (ro.a(appMetricaConfig.dataSendingEnabled)) {
            newConfigBuilder.withDataSendingEnabled(appMetricaConfig.dataSendingEnabled.booleanValue());
        }
        if (ro.a(appMetricaConfig.anrMonitoring)) {
            newConfigBuilder.withAnrMonitoring(appMetricaConfig.anrMonitoring.booleanValue());
        }
        if (ro.a(appMetricaConfig.anrMonitoringTimeout)) {
            newConfigBuilder.withAnrMonitoringTimeout(appMetricaConfig.anrMonitoringTimeout.intValue());
        }
        if (ro.a(appMetricaConfig.maxReportsInDatabaseCount)) {
            newConfigBuilder.withMaxReportsInDatabaseCount(appMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (ro.a(appMetricaConfig.crashTransformer)) {
            newConfigBuilder.withCrashTransformer(appMetricaConfig.crashTransformer);
        }
        if (ro.a(appMetricaConfig.userProfileID)) {
            newConfigBuilder.withUserProfileID(appMetricaConfig.userProfileID);
        }
        if (ro.a(appMetricaConfig.revenueAutoTrackingEnabled)) {
            newConfigBuilder.withRevenueAutoTrackingEnabled(appMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
        }
        if (ro.a(appMetricaConfig.appOpenTrackingEnabled)) {
            newConfigBuilder.withAppOpenTrackingEnabled(appMetricaConfig.appOpenTrackingEnabled.booleanValue());
        }
        if (ro.a((Object) appMetricaConfig.customHosts)) {
            newConfigBuilder.withCustomHosts(appMetricaConfig.customHosts);
        }
        LinkedHashMap linkedHashMap = this.e;
        if (!ro.a((Map) linkedHashMap)) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                newConfigBuilder.withAppEnvironmentValue((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Map<String, String> map = appMetricaConfig.appEnvironment;
        if (!ro.a((Map) map)) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                newConfigBuilder.withAppEnvironmentValue(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = this.f;
        if (!ro.a((Map) linkedHashMap2)) {
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                newConfigBuilder.withErrorEnvironmentValue((String) entry3.getKey(), (String) entry3.getValue());
            }
        }
        Map<String, String> map2 = appMetricaConfig.errorEnvironment;
        if (!ro.a((Map) map2)) {
            for (Map.Entry<String, String> entry4 : map2.entrySet()) {
                newConfigBuilder.withErrorEnvironmentValue(entry4.getKey(), entry4.getValue());
            }
        }
        Map<String, Object> map3 = appMetricaConfig.additionalConfig;
        if (!ro.a((Map) map3)) {
            for (Map.Entry<String, Object> entry5 : map3.entrySet()) {
                newConfigBuilder.withAdditionalConfig(entry5.getKey(), entry5.getValue());
            }
        }
        Boolean bool = this.b;
        if (appMetricaConfig.locationTracking == null && ro.a(bool)) {
            newConfigBuilder.withLocationTracking(bool.booleanValue());
        }
        Location location = this.f840a;
        if (appMetricaConfig.location == null && ro.a(location)) {
            newConfigBuilder.withLocation(location);
        }
        Boolean bool2 = this.d;
        if (appMetricaConfig.dataSendingEnabled == null && ro.a(bool2)) {
            newConfigBuilder.withDataSendingEnabled(bool2.booleanValue());
        }
        if (!ro.a(appMetricaConfig.userProfileID) && ro.a(this.h)) {
            newConfigBuilder.withUserProfileID(this.h);
        }
        Boolean bool3 = this.c;
        if (appMetricaConfig.advIdentifiersTracking == null && ro.a(bool3)) {
            newConfigBuilder.withAdvIdentifiersTracking(bool3.booleanValue());
        }
        this.j = true;
        this.f840a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e.clear();
        this.f.clear();
        this.g = false;
        this.h = null;
        return newConfigBuilder.build();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hd
    public final void a(String str) {
        this.i.add(str);
    }

    public final void a(Si si) {
        Boolean bool = this.b;
        if (bool != null || this.d != null || this.c != null) {
            si.a(bool, this.d, this.c);
        }
        this.k = si;
    }
}
