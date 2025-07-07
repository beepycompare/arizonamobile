package io.appmetrica.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.AbstractC0527q1;
import io.appmetrica.analytics.impl.C0502p1;
import io.appmetrica.analytics.impl.F0;
import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class AppMetrica {
    public static void activate(Context context, AppMetricaConfig appMetricaConfig) {
        AbstractC0527q1.f998a.a(context, appMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        AbstractC0527q1.f998a.a(context, reporterConfig);
    }

    public static void clearAppEnvironment() {
        AbstractC0527q1.f998a.a();
    }

    public static void enableActivityAutoTracking(Application application) {
        AbstractC0527q1.f998a.a(application);
    }

    public static String getDeviceId(Context context) {
        return AbstractC0527q1.f998a.b();
    }

    public static int getLibraryApiLevel() {
        return BuildConfig.API_LEVEL;
    }

    public static String getLibraryVersion() {
        return "7.9.0";
    }

    public static AppMetricaPlugins getPluginExtension() {
        return F0.f418a;
    }

    public static IReporter getReporter(Context context, String str) {
        return AbstractC0527q1.f998a.a(context, str);
    }

    public static String getUuid(Context context) {
        return AbstractC0527q1.f998a.a(context).id;
    }

    public static void initWebViewReporting(WebView webView) {
        AbstractC0527q1.f998a.a(webView);
    }

    public static void pauseSession(Activity activity) {
        AbstractC0527q1.f998a.a(activity);
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        AbstractC0527q1.f998a.a(str, str2);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        AbstractC0527q1.f998a.b(str, str2);
    }

    public static void registerAnrListener(AnrListener anrListener) {
        AbstractC0527q1.f998a.a(anrListener);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        AbstractC0527q1.f998a.a(adRevenue);
    }

    public static void reportAnr(Map<Thread, StackTraceElement[]> map) {
        AbstractC0527q1.f998a.a(map);
    }

    public static void reportAppOpen(Activity activity) {
        AbstractC0527q1.f998a.b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        AbstractC0527q1.f998a.a(eCommerceEvent);
    }

    public static void reportError(String str, String str2) {
        AbstractC0527q1.f998a.a(str, str2, (Throwable) null);
    }

    public static void reportEvent(String str) {
        AbstractC0527q1.f998a.b(str);
    }

    public static void reportExternalAdRevenue(Object... objArr) {
        AbstractC0527q1.f998a.b(objArr);
    }

    public static void reportExternalAttribution(ExternalAttribution externalAttribution) {
        AbstractC0527q1.f998a.a(externalAttribution);
    }

    public static void reportReferralUrl(String str) {
        AbstractC0527q1.f998a.d(str);
    }

    public static void reportRevenue(Revenue revenue) {
        AbstractC0527q1.f998a.a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        AbstractC0527q1.f998a.a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        AbstractC0527q1.f998a.a(userProfile);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        AbstractC0527q1.f998a.a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        AbstractC0527q1.f998a.a(deferredDeeplinkParametersListener);
    }

    public static void requestStartupParams(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        C0502p1 c0502p1 = AbstractC0527q1.f998a;
        if (list.isEmpty()) {
            list = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH);
        }
        c0502p1.a(context, startupParamsCallback, list);
    }

    public static void resumeSession(Activity activity) {
        AbstractC0527q1.f998a.c(activity);
    }

    public static void sendEventsBuffer() {
        AbstractC0527q1.f998a.f();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        AbstractC0527q1.f998a.a(z);
    }

    public static void setDataSendingEnabled(boolean z) {
        AbstractC0527q1.f998a.b(z);
    }

    public static void setLocation(Location location) {
        AbstractC0527q1.f998a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        AbstractC0527q1.f998a.c(z);
    }

    public static void setUserProfileID(String str) {
        AbstractC0527q1.f998a.e(str);
    }

    public static void reportAppOpen(Intent intent) {
        AbstractC0527q1.f998a.a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        AbstractC0527q1.f998a.a(str, str2, th);
    }

    public static void reportEvent(String str, String str2) {
        AbstractC0527q1.f998a.c(str, str2);
    }

    public static void reportAppOpen(String str) {
        AbstractC0527q1.f998a.a(str);
    }

    public static void reportError(String str, Throwable th) {
        AbstractC0527q1.f998a.a(str, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        AbstractC0527q1.f998a.a(str, map);
    }
}
