package io.appmetrica.analytics.impl;

import android.location.Location;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class X3 {

    /* renamed from: a  reason: collision with root package name */
    public volatile U7 f835a = new U7();

    public static Location b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Location location = new Location(jSONObject.has("provider") ? jSONObject.optString("provider") : null);
            location.setLongitude(jSONObject.getDouble("lng"));
            location.setLatitude(jSONObject.getDouble("lat"));
            location.setTime(jSONObject.optLong("time"));
            location.setAccuracy((float) jSONObject.optDouble("accuracy"));
            location.setAltitude((float) jSONObject.optDouble("alt"));
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static PreloadInfo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        PreloadInfo.Builder newBuilder = PreloadInfo.newBuilder(jSONObject.has("trackid") ? jSONObject.optString("trackid") : null);
        HashMap c = Ib.c(jSONObject.optString("params"));
        if (c != null && c.size() > 0) {
            for (Map.Entry entry : c.entrySet()) {
                newBuilder.setAdditionalParams((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return newBuilder.build();
    }

    public final AppMetricaConfig.Builder a(String str) {
        HashMap c;
        HashMap c2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMetricaConfig.Builder newConfigBuilder = AppMetricaConfig.newConfigBuilder(jSONObject.getString("apikey"));
            if (jSONObject.has("app_version")) {
                newConfigBuilder.withAppVersion(jSONObject.optString("app_version"));
            }
            if (jSONObject.has("session_timeout")) {
                newConfigBuilder.withSessionTimeout(jSONObject.getInt("session_timeout"));
            }
            newConfigBuilder.withLocation(b(jSONObject.optString(FirebaseAnalytics.Param.LOCATION)));
            newConfigBuilder.withPreloadInfo(c(jSONObject.optString("preload_info")));
            if (jSONObject.has("logs") && jSONObject.optBoolean("logs")) {
                newConfigBuilder.withLogs();
            }
            if (jSONObject.has("crash_enabled")) {
                newConfigBuilder.withCrashReporting(jSONObject.optBoolean("crash_enabled"));
            }
            if (jSONObject.has("crash_native_enabled")) {
                newConfigBuilder.withNativeCrashReporting(jSONObject.optBoolean("crash_native_enabled"));
            }
            if (jSONObject.has("location_enabled")) {
                newConfigBuilder.withLocationTracking(jSONObject.optBoolean("location_enabled"));
            }
            if (jSONObject.has("adv_identifiers_tracking")) {
                newConfigBuilder.withAdvIdentifiersTracking(jSONObject.optBoolean("adv_identifiers_tracking", true));
            }
            if (jSONObject.has("max_reports_in_db_count")) {
                newConfigBuilder.withMaxReportsInDatabaseCount(jSONObject.optInt("max_reports_in_db_count"));
            }
            if (jSONObject.has("error_environment") && (c2 = Ib.c(jSONObject.optString("error_environment"))) != null) {
                for (Map.Entry entry : c2.entrySet()) {
                    newConfigBuilder.withErrorEnvironmentValue((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (jSONObject.has("first_activation_as_update")) {
                newConfigBuilder.handleFirstActivationAsUpdate(jSONObject.optBoolean("first_activation_as_update"));
            }
            if (jSONObject.has("data_sending_enabled")) {
                newConfigBuilder.withDataSendingEnabled(jSONObject.optBoolean("data_sending_enabled"));
            }
            if (jSONObject.has("user_profile_id")) {
                try {
                    newConfigBuilder.withUserProfileID(jSONObject.optString("user_profile_id", null));
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (jSONObject.has("revenue_auto_tracking_enabled")) {
                newConfigBuilder.withRevenueAutoTrackingEnabled(jSONObject.optBoolean("revenue_auto_tracking_enabled"));
            }
            if (jSONObject.has("sessions_auto_tracking_enabled")) {
                newConfigBuilder.withSessionsAutoTrackingEnabled(jSONObject.optBoolean("sessions_auto_tracking_enabled"));
            }
            if (jSONObject.has("app_open_tracking_enabled")) {
                newConfigBuilder.withAppOpenTrackingEnabled(jSONObject.optBoolean("app_open_tracking_enabled"));
            }
            if (jSONObject.has(CommonUrlParts.DEVICE_TYPE)) {
                newConfigBuilder.withDeviceType(jSONObject.optString(CommonUrlParts.DEVICE_TYPE));
            }
            if (jSONObject.has(CommonUrlParts.APP_VERSION_CODE)) {
                newConfigBuilder.withAppBuildNumber(jSONObject.optInt(CommonUrlParts.APP_VERSION_CODE));
            }
            if (jSONObject.has("dispatch_period_seconds")) {
                newConfigBuilder.withDispatchPeriodSeconds(jSONObject.optInt("dispatch_period_seconds"));
            }
            if (jSONObject.has("max_reports_count")) {
                newConfigBuilder.withMaxReportsCount(jSONObject.optInt("max_reports_count"));
            }
            if (jSONObject.has("app_environment") && (c = Ib.c(jSONObject.optString("app_environment"))) != null) {
                for (Map.Entry entry2 : c.entrySet()) {
                    newConfigBuilder.withAppEnvironmentValue((String) entry2.getKey(), (String) entry2.getValue());
                }
            }
            if (jSONObject.has("anr_monitoring")) {
                newConfigBuilder.withAnrMonitoring(jSONObject.optBoolean("anr_monitoring"));
            }
            if (jSONObject.has("anr_monitoring_timeout")) {
                newConfigBuilder.withAnrMonitoringTimeout(jSONObject.optInt("anr_monitoring_timeout"));
            }
            if (jSONObject.has("customHosts")) {
                newConfigBuilder.withCustomHosts(Ib.a(jSONObject.optJSONArray("customHosts")));
            }
            if (jSONObject.has("additional_config")) {
                U7 u7 = this.f835a;
                jSONObject.optJSONObject("additional_config");
                u7.getClass();
            }
            return newConfigBuilder;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String a(Location location) {
        if (location == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("provider", location.getProvider());
            jSONObject.put("time", location.getTime());
            jSONObject.put("accuracy", location.getAccuracy());
            jSONObject.put("alt", location.getAltitude());
            jSONObject.put("lng", location.getLongitude());
            jSONObject.put("lat", location.getLatitude());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
