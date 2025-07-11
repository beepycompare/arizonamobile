package io.appmetrica.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.AbstractC0519q1;
import io.appmetrica.analytics.impl.C0494p1;
import io.appmetrica.analytics.impl.F0;
import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class AppMetrica {
    public static void activate(Context context, AppMetricaConfig appMetricaConfig) {
        AbstractC0519q1.f999a.a(context, appMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        AbstractC0519q1.f999a.a(context, reporterConfig);
    }

    public static void clearAppEnvironment() {
        AbstractC0519q1.f999a.a();
    }

    public static void enableActivityAutoTracking(Application application) {
        AbstractC0519q1.f999a.a(application);
    }

    public static String getDeviceId(Context context) {
        return AbstractC0519q1.f999a.b();
    }

    public static int getLibraryApiLevel() {
        return BuildConfig.API_LEVEL;
    }

    public static String getLibraryVersion() {
        return "7.9.0";
    }

    public static AppMetricaPlugins getPluginExtension() {
        return F0.f419a;
    }

    public static IReporter getReporter(Context context, String str) {
        return AbstractC0519q1.f999a.a(context, str);
    }

    public static String getUuid(Context context) {
        return AbstractC0519q1.f999a.a(context).id;
    }

    public static void initWebViewReporting(WebView webView) {
        AbstractC0519q1.f999a.a(webView);
    }

    public static void pauseSession(Activity activity) {
        AbstractC0519q1.f999a.a(activity);
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        AbstractC0519q1.f999a.a(str, str2);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        AbstractC0519q1.f999a.b(str, str2);
    }

    public static void registerAnrListener(AnrListener anrListener) {
        AbstractC0519q1.f999a.a(anrListener);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        AbstractC0519q1.f999a.a(adRevenue);
    }

    public static void reportAnr(Map<Thread, StackTraceElement[]> map) {
        AbstractC0519q1.f999a.a(map);
    }

    public static void reportAppOpen(Activity activity) {
        AbstractC0519q1.f999a.b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        AbstractC0519q1.f999a.a(eCommerceEvent);
    }

    public static void reportError(String str, String str2) {
        AbstractC0519q1.f999a.a(str, str2, (Throwable) null);
    }

    public static void reportEvent(String str) {
        AbstractC0519q1.f999a.b(str);
    }

    public static void reportExternalAdRevenue(Object... objArr) {
        AbstractC0519q1.f999a.b(objArr);
    }

    public static void reportExternalAttribution(ExternalAttribution externalAttribution) {
        AbstractC0519q1.f999a.a(externalAttribution);
    }

    public static void reportReferralUrl(String str) {
        AbstractC0519q1.f999a.d(str);
    }

    public static void reportRevenue(Revenue revenue) {
        AbstractC0519q1.f999a.a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        AbstractC0519q1.f999a.a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        AbstractC0519q1.f999a.a(userProfile);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        AbstractC0519q1.f999a.a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        AbstractC0519q1.f999a.a(deferredDeeplinkParametersListener);
    }

    public static void requestStartupParams(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        C0494p1 c0494p1 = AbstractC0519q1.f999a;
        if (list.isEmpty()) {
            list = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH);
        }
        c0494p1.a(context, startupParamsCallback, list);
    }

    public static void resumeSession(Activity activity) {
        AbstractC0519q1.f999a.c(activity);
    }

    public static void sendEventsBuffer() {
        AbstractC0519q1.f999a.f();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        AbstractC0519q1.f999a.a(z);
    }

    public static void setDataSendingEnabled(boolean z) {
        AbstractC0519q1.f999a.b(z);
    }

    public static void setLocation(Location location) {
        AbstractC0519q1.f999a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        AbstractC0519q1.f999a.c(z);
    }

    public static void setUserProfileID(String str) {
        AbstractC0519q1.f999a.e(str);
    }

    public static void reportAppOpen(Intent intent) {
        AbstractC0519q1.f999a.a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        AbstractC0519q1.f999a.a(str, str2, th);
    }

    public static void reportEvent(String str, String str2) {
        AbstractC0519q1.f999a.c(str, str2);
    }

    public static void reportAppOpen(String str) {
        AbstractC0519q1.f999a.a(str);
    }

    public static void reportError(String str, Throwable th) {
        AbstractC0519q1.f999a.a(str, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        AbstractC0519q1.f999a.a(str, map);
    }
}
