package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class W7 implements InterfaceC0129ad {

    /* renamed from: a  reason: collision with root package name */
    public Location f684a;
    public Boolean b;
    public Boolean c;
    public Boolean d;
    public final LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public boolean g;
    public String h;
    public boolean i;
    public Gi j;

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void a(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.b = valueOf;
        Gi gi = this.j;
        if (gi != null) {
            gi.a(valueOf, this.d, this.c);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void b(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.c = valueOf;
        Gi gi = this.j;
        if (gi != null) {
            gi.a(this.b, this.d, valueOf);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void clearAppEnvironment() {
        this.g = true;
        this.e.clear();
    }

    public final Location j() {
        return this.f684a;
    }

    public final Boolean k() {
        return this.c;
    }

    public final Boolean l() {
        return this.d;
    }

    public final Boolean m() {
        return this.b;
    }

    public final boolean n() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void putAppEnvironmentValue(String str, String str2) {
        this.e.put(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void setDataSendingEnabled(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        this.d = valueOf;
        Gi gi = this.j;
        if (gi != null) {
            gi.a(this.b, valueOf, this.c);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void setUserProfileID(String str) {
        this.h = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void a(Location location) {
        this.f684a = location;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0129ad
    public final void a(String str, String str2) {
        this.f.put(str, str2);
    }

    public final AppMetricaConfig a(AppMetricaConfig appMetricaConfig) {
        if (this.i) {
            return appMetricaConfig;
        }
        AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder(appMetricaConfig.apiKey);
        newConfigBuilder.withDeviceType(appMetricaConfig.deviceType);
        newConfigBuilder.withPreloadInfo(appMetricaConfig.preloadInfo);
        newConfigBuilder.withLocation(appMetricaConfig.location);
        if (fo.a(appMetricaConfig.appVersion)) {
            newConfigBuilder.withAppVersion(appMetricaConfig.appVersion);
        }
        if (fo.a(appMetricaConfig.dispatchPeriodSeconds)) {
            newConfigBuilder.withDispatchPeriodSeconds(appMetricaConfig.dispatchPeriodSeconds.intValue());
        }
        if (fo.a(appMetricaConfig.appBuildNumber)) {
            newConfigBuilder.withAppBuildNumber(appMetricaConfig.appBuildNumber.intValue());
        }
        if (fo.a(appMetricaConfig.maxReportsCount)) {
            newConfigBuilder.withMaxReportsCount(appMetricaConfig.maxReportsCount.intValue());
        }
        if (fo.a(appMetricaConfig.logs) && appMetricaConfig.logs.booleanValue()) {
            newConfigBuilder.withLogs();
        }
        if (fo.a(appMetricaConfig.sessionTimeout)) {
            newConfigBuilder.withSessionTimeout(appMetricaConfig.sessionTimeout.intValue());
        }
        if (fo.a(appMetricaConfig.sessionsAutoTrackingEnabled)) {
            newConfigBuilder.withSessionsAutoTrackingEnabled(appMetricaConfig.sessionsAutoTrackingEnabled.booleanValue());
        }
        if (fo.a(appMetricaConfig.crashReporting)) {
            newConfigBuilder.withCrashReporting(appMetricaConfig.crashReporting.booleanValue());
        }
        if (fo.a(appMetricaConfig.nativeCrashReporting)) {
            newConfigBuilder.withNativeCrashReporting(appMetricaConfig.nativeCrashReporting.booleanValue());
        }
        if (fo.a(appMetricaConfig.locationTracking)) {
            newConfigBuilder.withLocationTracking(appMetricaConfig.locationTracking.booleanValue());
        }
        if (fo.a(appMetricaConfig.advIdentifiersTracking)) {
            newConfigBuilder.withAdvIdentifiersTracking(appMetricaConfig.advIdentifiersTracking.booleanValue());
        }
        if (fo.a(appMetricaConfig.firstActivationAsUpdate)) {
            newConfigBuilder.handleFirstActivationAsUpdate(appMetricaConfig.firstActivationAsUpdate.booleanValue());
        }
        if (fo.a(appMetricaConfig.dataSendingEnabled)) {
            newConfigBuilder.withDataSendingEnabled(appMetricaConfig.dataSendingEnabled.booleanValue());
        }
        if (fo.a(appMetricaConfig.anrMonitoring)) {
            newConfigBuilder.withAnrMonitoring(appMetricaConfig.anrMonitoring.booleanValue());
        }
        if (fo.a(appMetricaConfig.anrMonitoringTimeout)) {
            newConfigBuilder.withAnrMonitoringTimeout(appMetricaConfig.anrMonitoringTimeout.intValue());
        }
        if (fo.a(appMetricaConfig.maxReportsInDatabaseCount)) {
            newConfigBuilder.withMaxReportsInDatabaseCount(appMetricaConfig.maxReportsInDatabaseCount.intValue());
        }
        if (fo.a(appMetricaConfig.crashTransformer)) {
            newConfigBuilder.withCrashTransformer(appMetricaConfig.crashTransformer);
        }
        if (fo.a(appMetricaConfig.userProfileID)) {
            newConfigBuilder.withUserProfileID(appMetricaConfig.userProfileID);
        }
        if (fo.a(appMetricaConfig.revenueAutoTrackingEnabled)) {
            newConfigBuilder.withRevenueAutoTrackingEnabled(appMetricaConfig.revenueAutoTrackingEnabled.booleanValue());
        }
        if (fo.a(appMetricaConfig.appOpenTrackingEnabled)) {
            newConfigBuilder.withAppOpenTrackingEnabled(appMetricaConfig.appOpenTrackingEnabled.booleanValue());
        }
        if (fo.a((Object) appMetricaConfig.customHosts)) {
            newConfigBuilder.withCustomHosts(appMetricaConfig.customHosts);
        }
        LinkedHashMap linkedHashMap = this.e;
        if (!fo.a((Map) linkedHashMap)) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                newConfigBuilder.withAppEnvironmentValue((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Map<String, String> map = appMetricaConfig.appEnvironment;
        if (!fo.a((Map) map)) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                newConfigBuilder.withAppEnvironmentValue(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = this.f;
        if (!fo.a((Map) linkedHashMap2)) {
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                newConfigBuilder.withErrorEnvironmentValue((String) entry3.getKey(), (String) entry3.getValue());
            }
        }
        Map<String, String> map2 = appMetricaConfig.errorEnvironment;
        if (!fo.a((Map) map2)) {
            for (Map.Entry<String, String> entry4 : map2.entrySet()) {
                newConfigBuilder.withErrorEnvironmentValue(entry4.getKey(), entry4.getValue());
            }
        }
        Map<String, Object> map3 = appMetricaConfig.additionalConfig;
        if (!fo.a((Map) map3)) {
            for (Map.Entry<String, Object> entry5 : map3.entrySet()) {
                newConfigBuilder.withAdditionalConfig(entry5.getKey(), entry5.getValue());
            }
        }
        Boolean bool = this.b;
        if (appMetricaConfig.locationTracking == null && fo.a(bool)) {
            newConfigBuilder.withLocationTracking(bool.booleanValue());
        }
        Location location = this.f684a;
        if (appMetricaConfig.location == null && fo.a(location)) {
            newConfigBuilder.withLocation(location);
        }
        Boolean bool2 = this.d;
        if (appMetricaConfig.dataSendingEnabled == null && fo.a(bool2)) {
            newConfigBuilder.withDataSendingEnabled(bool2.booleanValue());
        }
        if (!fo.a(appMetricaConfig.userProfileID) && fo.a(this.h)) {
            newConfigBuilder.withUserProfileID(this.h);
        }
        Boolean bool3 = this.c;
        if (appMetricaConfig.advIdentifiersTracking == null && fo.a(bool3)) {
            newConfigBuilder.withAdvIdentifiersTracking(bool3.booleanValue());
        }
        this.i = true;
        this.f684a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e.clear();
        this.f.clear();
        this.g = false;
        this.h = null;
        return newConfigBuilder.build();
    }

    public final void a(Gi gi) {
        this.j = gi;
    }
}
