package io.appmetrica.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.AbstractC0635v1;
import io.appmetrica.analytics.impl.C0610u1;
import io.appmetrica.analytics.impl.K0;
import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class AppMetrica {
    public static void activate(Context context, AppMetricaConfig appMetricaConfig) {
        AbstractC0635v1.f1255a.a(context, appMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        AbstractC0635v1.f1255a.a(context, reporterConfig);
    }

    public static void clearAppEnvironment() {
        AbstractC0635v1.f1255a.a();
    }

    public static void enableActivityAutoTracking(Application application) {
        AbstractC0635v1.f1255a.a(application);
    }

    public static String getDeviceId(Context context) {
        return AbstractC0635v1.f1255a.b();
    }

    public static int getLibraryApiLevel() {
        return 116;
    }

    public static String getLibraryVersion() {
        return "7.14.0";
    }

    public static AppMetricaPlugins getPluginExtension() {
        return K0.f643a;
    }

    public static IReporter getReporter(Context context, String str) {
        return AbstractC0635v1.f1255a.a(context, str);
    }

    public static String getUuid(Context context) {
        return AbstractC0635v1.f1255a.a(context).id;
    }

    public static void initWebViewReporting(WebView webView) {
        AbstractC0635v1.f1255a.a(webView);
    }

    public static void pauseSession(Activity activity) {
        AbstractC0635v1.f1255a.a(activity);
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        AbstractC0635v1.f1255a.a(str, str2);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        AbstractC0635v1.f1255a.b(str, str2);
    }

    public static void registerAnrListener(AnrListener anrListener) {
        AbstractC0635v1.f1255a.a(anrListener);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        AbstractC0635v1.f1255a.a(adRevenue);
    }

    public static void reportAnr(Map<Thread, StackTraceElement[]> map) {
        AbstractC0635v1.f1255a.a(map);
    }

    public static void reportAppOpen(Activity activity) {
        AbstractC0635v1.f1255a.b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        AbstractC0635v1.f1255a.a(eCommerceEvent);
    }

    public static void reportError(String str, String str2) {
        AbstractC0635v1.f1255a.a(str, str2, (Throwable) null);
    }

    public static void reportEvent(String str) {
        AbstractC0635v1.f1255a.b(str);
    }

    public static void reportExternalAdRevenue(Object... objArr) {
        AbstractC0635v1.f1255a.b(objArr);
    }

    public static void reportExternalAttribution(ExternalAttribution externalAttribution) {
        AbstractC0635v1.f1255a.a(externalAttribution);
    }

    public static void reportReferralUrl(String str) {
        AbstractC0635v1.f1255a.d(str);
    }

    public static void reportRevenue(Revenue revenue) {
        AbstractC0635v1.f1255a.a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        AbstractC0635v1.f1255a.a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        AbstractC0635v1.f1255a.a(userProfile);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        AbstractC0635v1.f1255a.a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        AbstractC0635v1.f1255a.a(deferredDeeplinkParametersListener);
    }

    public static void requestStartupParams(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        C0610u1 c0610u1 = AbstractC0635v1.f1255a;
        if (list.isEmpty()) {
            list = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH);
        }
        c0610u1.a(context, startupParamsCallback, list);
    }

    public static void resumeSession(Activity activity) {
        AbstractC0635v1.f1255a.c(activity);
    }

    public static void sendEventsBuffer() {
        AbstractC0635v1.f1255a.f();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        AbstractC0635v1.f1255a.a(z);
    }

    public static void setDataSendingEnabled(boolean z) {
        AbstractC0635v1.f1255a.b(z);
    }

    public static void setLocation(Location location) {
        AbstractC0635v1.f1255a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        AbstractC0635v1.f1255a.c(z);
    }

    public static void setUserProfileID(String str) {
        AbstractC0635v1.f1255a.e(str);
    }

    public static void reportAppOpen(Intent intent) {
        AbstractC0635v1.f1255a.a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        AbstractC0635v1.f1255a.a(str, str2, th);
    }

    public static void reportEvent(String str, String str2) {
        AbstractC0635v1.f1255a.c(str, str2);
    }

    public static void reportAppOpen(String str) {
        AbstractC0635v1.f1255a.a(str);
    }

    public static void reportError(String str, Throwable th) {
        AbstractC0635v1.f1255a.a(str, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        AbstractC0635v1.f1255a.a(str, map);
    }
}
