package io.appmetrica.analytics;

import android.location.Location;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.AbstractC0172c4;
import io.appmetrica.analytics.impl.AbstractC0753zb;
import io.appmetrica.analytics.impl.C0244f0;
import io.appmetrica.analytics.impl.C0740yn;
import io.appmetrica.analytics.impl.G5;
import io.appmetrica.analytics.impl.V7;
import io.appmetrica.analytics.impl.fo;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AppMetricaConfig {
    public final Map<String, Object> additionalConfig;
    public final Boolean advIdentifiersTracking;
    public final Boolean anrMonitoring;
    public final Integer anrMonitoringTimeout;
    public final String apiKey;
    public final Integer appBuildNumber;
    public final Map<String, String> appEnvironment;
    public final Boolean appOpenTrackingEnabled;
    public final String appVersion;
    public final Boolean crashReporting;
    public final ICrashTransformer crashTransformer;
    public final List<String> customHosts;
    public final Boolean dataSendingEnabled;
    public final String deviceType;
    public final Integer dispatchPeriodSeconds;
    public final Map<String, String> errorEnvironment;
    public final Boolean firstActivationAsUpdate;
    public final Location location;
    public final Boolean locationTracking;
    public final Boolean logs;
    public final Integer maxReportsCount;
    public final Integer maxReportsInDatabaseCount;
    public final Boolean nativeCrashReporting;
    public final PreloadInfo preloadInfo;
    public final Boolean revenueAutoTrackingEnabled;
    public final Integer sessionTimeout;
    public final Boolean sessionsAutoTrackingEnabled;
    public final String userProfileID;

    /* loaded from: classes4.dex */
    public static class Builder {
        private static final C0740yn D = new C0740yn(new C0244f0());
        private Integer A;
        private List B;
        private final HashMap C;

        /* renamed from: a  reason: collision with root package name */
        private final G5 f193a;
        private final String b;
        private String c;
        private Integer d;
        private Boolean e;
        private Boolean f;
        private Location g;
        private Boolean h;
        private Boolean i;
        private Boolean j;
        private PreloadInfo k;
        private Boolean l;
        private Boolean m;
        private Integer n;
        private final LinkedHashMap o;
        private String p;
        private Boolean q;
        private Boolean r;
        private Boolean s;
        private String t;
        private Integer u;
        private Integer v;
        private Integer w;
        private final LinkedHashMap x;
        private ICrashTransformer y;
        private Boolean z;

        /* synthetic */ Builder(String str, int i) {
            this(str);
        }

        public AppMetricaConfig build() {
            return new AppMetricaConfig(this, 0);
        }

        public Builder handleFirstActivationAsUpdate(boolean z) {
            this.l = Boolean.valueOf(z);
            return this;
        }

        public Builder withAdditionalConfig(String str, Object obj) {
            this.C.put(str, obj);
            return this;
        }

        public Builder withAdvIdentifiersTracking(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public Builder withAnrMonitoring(boolean z) {
            this.z = Boolean.valueOf(z);
            return this;
        }

        public Builder withAnrMonitoringTimeout(int i) {
            this.A = Integer.valueOf(i);
            return this;
        }

        public Builder withAppBuildNumber(int i) {
            if (i >= 0) {
                this.u = Integer.valueOf(i);
                return this;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid %1$s. %1$s should be positive.", "App Build Number"));
        }

        public Builder withAppEnvironmentValue(String str, String str2) {
            this.x.put(str, str2);
            return this;
        }

        public Builder withAppOpenTrackingEnabled(boolean z) {
            this.s = Boolean.valueOf(z);
            return this;
        }

        public Builder withAppVersion(String str) {
            this.c = str;
            return this;
        }

        public Builder withCrashReporting(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        public Builder withCrashTransformer(ICrashTransformer iCrashTransformer) {
            this.y = iCrashTransformer;
            return this;
        }

        public Builder withCustomHosts(List<String> list) {
            this.B = CollectionUtils.unmodifiableListCopy(list);
            return this;
        }

        public Builder withDataSendingEnabled(boolean z) {
            this.m = Boolean.valueOf(z);
            return this;
        }

        public Builder withDeviceType(String str) {
            this.t = str;
            return this;
        }

        public Builder withDispatchPeriodSeconds(int i) {
            this.v = Integer.valueOf(i);
            return this;
        }

        public Builder withErrorEnvironmentValue(String str, String str2) {
            this.o.put(str, str2);
            return this;
        }

        public Builder withLocation(Location location) {
            this.g = location;
            return this;
        }

        public Builder withLocationTracking(boolean z) {
            this.h = Boolean.valueOf(z);
            return this;
        }

        public Builder withLogs() {
            this.j = Boolean.TRUE;
            return this;
        }

        public Builder withMaxReportsCount(int i) {
            this.w = Integer.valueOf(i);
            return this;
        }

        public Builder withMaxReportsInDatabaseCount(int i) {
            this.n = Integer.valueOf(this.f193a.a(i));
            return this;
        }

        public Builder withNativeCrashReporting(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        public Builder withPreloadInfo(PreloadInfo preloadInfo) {
            this.k = preloadInfo;
            return this;
        }

        public Builder withRevenueAutoTrackingEnabled(boolean z) {
            this.q = Boolean.valueOf(z);
            return this;
        }

        public Builder withSessionTimeout(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public Builder withSessionsAutoTrackingEnabled(boolean z) {
            this.r = Boolean.valueOf(z);
            return this;
        }

        public Builder withUserProfileID(String str) {
            this.p = str;
            return this;
        }

        private Builder(String str) {
            this.o = new LinkedHashMap();
            this.x = new LinkedHashMap();
            this.C = new HashMap();
            D.a(str);
            this.f193a = new G5(str);
            this.b = str;
        }
    }

    /* synthetic */ AppMetricaConfig(Builder builder, int i) {
        this(builder);
    }

    public static AppMetricaConfig fromJson(String str) {
        HashMap c;
        HashMap c2;
        new V7();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Builder newConfigBuilder = newConfigBuilder(jSONObject.getString("apikey"));
            if (jSONObject.has("app_version")) {
                newConfigBuilder.withAppVersion(jSONObject.optString("app_version"));
            }
            if (jSONObject.has("session_timeout")) {
                newConfigBuilder.withSessionTimeout(jSONObject.getInt("session_timeout"));
            }
            newConfigBuilder.withLocation(AbstractC0172c4.a(jSONObject.optString(FirebaseAnalytics.Param.LOCATION)));
            newConfigBuilder.withPreloadInfo(AbstractC0172c4.b(jSONObject.optString("preload_info")));
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
            if (jSONObject.has("error_environment") && (c2 = AbstractC0753zb.c(jSONObject.optString("error_environment"))) != null) {
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
                newConfigBuilder.withUserProfileID(jSONObject.optString("user_profile_id", null));
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
            if (jSONObject.has("app_environment") && (c = AbstractC0753zb.c(jSONObject.optString("app_environment"))) != null) {
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
                newConfigBuilder.withCustomHosts(AbstractC0753zb.a(jSONObject.optJSONArray("customHosts")));
            }
            if (jSONObject.has("additional_config")) {
                jSONObject.optJSONObject("additional_config");
            }
            return newConfigBuilder.build();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Builder newConfigBuilder(String str) {
        return new Builder(str, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d A[Catch: all -> 0x011d, TryCatch #1 {all -> 0x011d, blocks: (B:3:0x0005, B:14:0x0058, B:18:0x0092, B:22:0x00e8, B:24:0x00fd, B:28:0x010b, B:27:0x0106, B:29:0x010e, B:21:0x00e3, B:17:0x008d), top: B:35:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e3 A[Catch: all -> 0x011d, TryCatch #1 {all -> 0x011d, blocks: (B:3:0x0005, B:14:0x0058, B:18:0x0092, B:22:0x00e8, B:24:0x00fd, B:28:0x010b, B:27:0x0106, B:29:0x010e, B:21:0x00e3, B:17:0x008d), top: B:35:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fd A[Catch: all -> 0x011d, TryCatch #1 {all -> 0x011d, blocks: (B:3:0x0005, B:14:0x0058, B:18:0x0092, B:22:0x00e8, B:24:0x00fd, B:28:0x010b, B:27:0x0106, B:29:0x010e, B:21:0x00e3, B:17:0x008d), top: B:35:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toJson() {
        String str;
        List<String> list;
        new V7();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apikey", this.apiKey);
            jSONObject.put("app_version", this.appVersion);
            jSONObject.put("session_timeout", this.sessionTimeout);
            jSONObject.put(FirebaseAnalytics.Param.LOCATION, AbstractC0172c4.a(this.location));
            PreloadInfo preloadInfo = this.preloadInfo;
            JSONArray jSONArray = null;
            if (preloadInfo != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("trackid", preloadInfo.getTrackingId());
                    Map<String, String> additionalParams = preloadInfo.getAdditionalParams();
                    jSONObject2.put("params", additionalParams == null ? null : new JSONObject(additionalParams));
                    str = jSONObject2.toString();
                } catch (Throwable unused) {
                    str = null;
                }
                jSONObject.put("preload_info", str);
                jSONObject.put("logs", this.logs);
                jSONObject.put("crash_enabled", this.crashReporting);
                jSONObject.put("crash_native_enabled", this.nativeCrashReporting);
                jSONObject.put("location_enabled", this.locationTracking);
                jSONObject.put("adv_identifiers_tracking", this.advIdentifiersTracking);
                jSONObject.put("max_reports_in_db_count", this.maxReportsInDatabaseCount);
                Map<String, String> map = this.errorEnvironment;
                jSONObject.put("error_environment", map != null ? null : new JSONObject(map));
                jSONObject.put("first_activation_as_update", this.firstActivationAsUpdate);
                jSONObject.put("data_sending_enabled", this.dataSendingEnabled);
                jSONObject.put("user_profile_id", this.userProfileID);
                jSONObject.put("revenue_auto_tracking_enabled", this.revenueAutoTrackingEnabled);
                jSONObject.put("sessions_auto_tracking_enabled", this.sessionsAutoTrackingEnabled);
                jSONObject.put("app_open_tracking_enabled", this.appOpenTrackingEnabled);
                jSONObject.put(CommonUrlParts.DEVICE_TYPE, this.deviceType);
                jSONObject.put(CommonUrlParts.APP_VERSION_CODE, this.appBuildNumber);
                jSONObject.put("dispatch_period_seconds", this.dispatchPeriodSeconds);
                jSONObject.put("max_reports_count", this.maxReportsCount);
                Map<String, String> map2 = this.appEnvironment;
                jSONObject.put("app_environment", map2 != null ? null : new JSONObject(map2));
                jSONObject.put("anr_monitoring", this.anrMonitoring);
                jSONObject.put("anr_monitoring_timeout", this.anrMonitoringTimeout);
                list = this.customHosts;
                if (list != null) {
                    if (!fo.a((Collection) list)) {
                        jSONArray = new JSONArray((Collection) list);
                    }
                    jSONObject.put("customHosts", jSONArray);
                }
                jSONObject.put("additional_config", new JSONObject());
                return jSONObject.toString();
            }
            str = null;
            jSONObject.put("preload_info", str);
            jSONObject.put("logs", this.logs);
            jSONObject.put("crash_enabled", this.crashReporting);
            jSONObject.put("crash_native_enabled", this.nativeCrashReporting);
            jSONObject.put("location_enabled", this.locationTracking);
            jSONObject.put("adv_identifiers_tracking", this.advIdentifiersTracking);
            jSONObject.put("max_reports_in_db_count", this.maxReportsInDatabaseCount);
            Map<String, String> map3 = this.errorEnvironment;
            jSONObject.put("error_environment", map3 != null ? null : new JSONObject(map3));
            jSONObject.put("first_activation_as_update", this.firstActivationAsUpdate);
            jSONObject.put("data_sending_enabled", this.dataSendingEnabled);
            jSONObject.put("user_profile_id", this.userProfileID);
            jSONObject.put("revenue_auto_tracking_enabled", this.revenueAutoTrackingEnabled);
            jSONObject.put("sessions_auto_tracking_enabled", this.sessionsAutoTrackingEnabled);
            jSONObject.put("app_open_tracking_enabled", this.appOpenTrackingEnabled);
            jSONObject.put(CommonUrlParts.DEVICE_TYPE, this.deviceType);
            jSONObject.put(CommonUrlParts.APP_VERSION_CODE, this.appBuildNumber);
            jSONObject.put("dispatch_period_seconds", this.dispatchPeriodSeconds);
            jSONObject.put("max_reports_count", this.maxReportsCount);
            Map<String, String> map22 = this.appEnvironment;
            jSONObject.put("app_environment", map22 != null ? null : new JSONObject(map22));
            jSONObject.put("anr_monitoring", this.anrMonitoring);
            jSONObject.put("anr_monitoring_timeout", this.anrMonitoringTimeout);
            list = this.customHosts;
            if (list != null) {
            }
            jSONObject.put("additional_config", new JSONObject());
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    private AppMetricaConfig(Builder builder) {
        this.apiKey = builder.b;
        this.appVersion = builder.c;
        this.sessionTimeout = builder.d;
        this.crashReporting = builder.e;
        this.nativeCrashReporting = builder.f;
        this.location = builder.g;
        this.locationTracking = builder.h;
        this.advIdentifiersTracking = builder.i;
        this.logs = builder.j;
        this.preloadInfo = builder.k;
        this.firstActivationAsUpdate = builder.l;
        this.dataSendingEnabled = builder.m;
        this.maxReportsInDatabaseCount = builder.n;
        this.errorEnvironment = CollectionUtils.unmodifiableSameOrderMapCopy(builder.o);
        this.userProfileID = builder.p;
        this.revenueAutoTrackingEnabled = builder.q;
        this.sessionsAutoTrackingEnabled = builder.r;
        this.appOpenTrackingEnabled = builder.s;
        this.deviceType = builder.t;
        this.appBuildNumber = builder.u;
        this.dispatchPeriodSeconds = builder.v;
        this.maxReportsCount = builder.w;
        this.appEnvironment = CollectionUtils.unmodifiableSameOrderMapCopy(builder.x);
        this.crashTransformer = builder.y;
        this.anrMonitoring = builder.z;
        this.anrMonitoringTimeout = builder.A;
        this.customHosts = builder.B;
        this.additionalConfig = CollectionUtils.unmodifiableSameOrderMapCopy(builder.C);
    }

    protected AppMetricaConfig(AppMetricaConfig appMetricaConfig) {
        this.apiKey = appMetricaConfig.apiKey;
        this.appVersion = appMetricaConfig.appVersion;
        this.sessionTimeout = appMetricaConfig.sessionTimeout;
        this.crashReporting = appMetricaConfig.crashReporting;
        this.nativeCrashReporting = appMetricaConfig.nativeCrashReporting;
        this.location = appMetricaConfig.location;
        this.locationTracking = appMetricaConfig.locationTracking;
        this.advIdentifiersTracking = appMetricaConfig.advIdentifiersTracking;
        this.logs = appMetricaConfig.logs;
        this.preloadInfo = appMetricaConfig.preloadInfo;
        this.firstActivationAsUpdate = appMetricaConfig.firstActivationAsUpdate;
        this.dataSendingEnabled = appMetricaConfig.dataSendingEnabled;
        this.maxReportsInDatabaseCount = appMetricaConfig.maxReportsInDatabaseCount;
        this.errorEnvironment = appMetricaConfig.errorEnvironment;
        this.userProfileID = appMetricaConfig.userProfileID;
        this.revenueAutoTrackingEnabled = appMetricaConfig.revenueAutoTrackingEnabled;
        this.sessionsAutoTrackingEnabled = appMetricaConfig.sessionsAutoTrackingEnabled;
        this.appOpenTrackingEnabled = appMetricaConfig.appOpenTrackingEnabled;
        this.deviceType = appMetricaConfig.deviceType;
        this.appBuildNumber = appMetricaConfig.appBuildNumber;
        this.dispatchPeriodSeconds = appMetricaConfig.dispatchPeriodSeconds;
        this.maxReportsCount = appMetricaConfig.maxReportsCount;
        this.appEnvironment = appMetricaConfig.appEnvironment;
        this.crashTransformer = appMetricaConfig.crashTransformer;
        this.anrMonitoring = appMetricaConfig.anrMonitoring;
        this.anrMonitoringTimeout = appMetricaConfig.anrMonitoringTimeout;
        this.customHosts = appMetricaConfig.customHosts;
        this.additionalConfig = appMetricaConfig.additionalConfig;
    }
}
