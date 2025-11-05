package io.appmetrica.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.AbstractC0586t1;
import io.appmetrica.analytics.impl.C0561s1;
import io.appmetrica.analytics.impl.I0;
import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class AppMetrica {
    public static void activate(Context context, AppMetricaConfig appMetricaConfig) {
        AbstractC0586t1.f1122a.a(context, appMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        AbstractC0586t1.f1122a.a(context, reporterConfig);
    }

    public static void clearAppEnvironment() {
        AbstractC0586t1.f1122a.a();
    }

    public static void enableActivityAutoTracking(Application application) {
        AbstractC0586t1.f1122a.a(application);
    }

    public static String getDeviceId(Context context) {
        return AbstractC0586t1.f1122a.b();
    }

    public static int getLibraryApiLevel() {
        return 116;
    }

    public static String getLibraryVersion() {
        return "7.13.0";
    }

    public static AppMetricaPlugins getPluginExtension() {
        return I0.f516a;
    }

    public static IReporter getReporter(Context context, String str) {
        return AbstractC0586t1.f1122a.a(context, str);
    }

    public static String getUuid(Context context) {
        return AbstractC0586t1.f1122a.a(context).id;
    }

    public static void initWebViewReporting(WebView webView) {
        AbstractC0586t1.f1122a.a(webView);
    }

    public static void pauseSession(Activity activity) {
        AbstractC0586t1.f1122a.a(activity);
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        AbstractC0586t1.f1122a.a(str, str2);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        AbstractC0586t1.f1122a.b(str, str2);
    }

    public static void registerAnrListener(AnrListener anrListener) {
        AbstractC0586t1.f1122a.a(anrListener);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        AbstractC0586t1.f1122a.a(adRevenue);
    }

    public static void reportAnr(Map<Thread, StackTraceElement[]> map) {
        AbstractC0586t1.f1122a.a(map);
    }

    public static void reportAppOpen(Activity activity) {
        AbstractC0586t1.f1122a.b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        AbstractC0586t1.f1122a.a(eCommerceEvent);
    }

    public static void reportError(String str, String str2) {
        AbstractC0586t1.f1122a.a(str, str2, (Throwable) null);
    }

    public static void reportEvent(String str) {
        AbstractC0586t1.f1122a.b(str);
    }

    public static void reportExternalAdRevenue(Object... objArr) {
        AbstractC0586t1.f1122a.b(objArr);
    }

    public static void reportExternalAttribution(ExternalAttribution externalAttribution) {
        AbstractC0586t1.f1122a.a(externalAttribution);
    }

    public static void reportReferralUrl(String str) {
        AbstractC0586t1.f1122a.d(str);
    }

    public static void reportRevenue(Revenue revenue) {
        AbstractC0586t1.f1122a.a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        AbstractC0586t1.f1122a.a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        AbstractC0586t1.f1122a.a(userProfile);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        AbstractC0586t1.f1122a.a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        AbstractC0586t1.f1122a.a(deferredDeeplinkParametersListener);
    }

    public static void requestStartupParams(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        C0561s1 c0561s1 = AbstractC0586t1.f1122a;
        if (list.isEmpty()) {
            list = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH);
        }
        c0561s1.a(context, startupParamsCallback, list);
    }

    public static void resumeSession(Activity activity) {
        AbstractC0586t1.f1122a.c(activity);
    }

    public static void sendEventsBuffer() {
        AbstractC0586t1.f1122a.f();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        AbstractC0586t1.f1122a.a(z);
    }

    public static void setDataSendingEnabled(boolean z) {
        AbstractC0586t1.f1122a.b(z);
    }

    public static void setLocation(Location location) {
        AbstractC0586t1.f1122a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        AbstractC0586t1.f1122a.c(z);
    }

    public static void setUserProfileID(String str) {
        AbstractC0586t1.f1122a.e(str);
    }

    public static void reportAppOpen(Intent intent) {
        AbstractC0586t1.f1122a.a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        AbstractC0586t1.f1122a.a(str, str2, th);
    }

    public static void reportEvent(String str, String str2) {
        AbstractC0586t1.f1122a.c(str, str2);
    }

    public static void reportAppOpen(String str) {
        AbstractC0586t1.f1122a.a(str);
    }

    public static void reportError(String str, Throwable th) {
        AbstractC0586t1.f1122a.a(str, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        AbstractC0586t1.f1122a.a(str, map);
    }
}
