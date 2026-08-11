package com.miami.game.core.firebase.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;
/* compiled from: NotificationStatsDeviceInfo.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010#\u001a\u0004\u0018\u00010\nH\u0003b\u0010\b$\u0012\f\b%\u0012\b\b\fJ\u0004\b\b(&J\b\u0010'\u001a\u00020\nH\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\f\u0010*\u001a\u00020\u0012*\u00020)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u0011\u0010\u001f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\"\u0010\f¨\u0006,"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsDeviceInfo;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", NotificationStatsPayloadFactory.KEY_PLATFORM, "getPlatform", "appVersionName", "getAppVersionName", "appVersionCode", "", "getAppVersionCode", "()Ljava/lang/Long;", "locale", "getLocale", "androidVersion", "getAndroidVersion", "androidSdk", "", "getAndroidSdk", "()I", "deviceManufacturer", "getDeviceManufacturer", "deviceModel", "getDeviceModel", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "getPackageName", "stableAndroidId", "Landroid/annotation/SuppressLint;", "value", "HardwareIds", "generatedDeviceId", "packageInfo", "Landroid/content/pm/PackageInfo;", "longVersionCodeCompat", "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationStatsDeviceInfo {
    @Deprecated
    public static final String BROKEN_ANDROID_ID = "9774d56d682e549c";
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String KEY_GENERATED_DEVICE_ID = "generated_device_id";
    @Deprecated
    public static final String PREFS_NAME = "notification_stats_device";
    private final Context context;
    private final String platform;
    private final SharedPreferences prefs;

    public NotificationStatsDeviceInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.prefs = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        this.platform = "mobile";
    }

    public final String getDeviceId() {
        String stableAndroidId = stableAndroidId();
        return stableAndroidId == null ? generatedDeviceId() : stableAndroidId;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getAppVersionName() {
        PackageInfo packageInfo = packageInfo();
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public final Long getAppVersionCode() {
        PackageInfo packageInfo = packageInfo();
        if (packageInfo != null) {
            return Long.valueOf(longVersionCodeCompat(packageInfo));
        }
        return null;
    }

    public final String getLocale() {
        String languageTag = Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        return languageTag;
    }

    public final String getAndroidVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    public final int getAndroidSdk() {
        return Build.VERSION.SDK_INT;
    }

    public final String getDeviceManufacturer() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str;
    }

    public final String getDeviceModel() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    public final String getPackageName() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    private final String stableAndroidId() {
        Object m9915constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsDeviceInfo notificationStatsDeviceInfo = this;
            String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
            if (string == null || StringsKt.isBlank(string) || Intrinsics.areEqual(string, BROKEN_ANDROID_ID)) {
                string = null;
            }
            m9915constructorimpl = Result.m9915constructorimpl(string);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9918exceptionOrNullimpl = Result.m9918exceptionOrNullimpl(m9915constructorimpl);
        if (m9918exceptionOrNullimpl != null) {
            Timber.Forest.w(m9918exceptionOrNullimpl, "Failed to read Android ID for notification stats", new Object[0]);
        }
        return Result.m9921isFailureimpl(m9915constructorimpl) ? null : m9915constructorimpl;
    }

    private final String generatedDeviceId() {
        Object m9915constructorimpl;
        Object obj = this.prefs.getAll().get(KEY_GENERATED_DEVICE_ID);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            return str;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsDeviceInfo notificationStatsDeviceInfo = this;
            this.prefs.edit().putString(KEY_GENERATED_DEVICE_ID, uuid).apply();
            m9915constructorimpl = Result.m9915constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9918exceptionOrNullimpl = Result.m9918exceptionOrNullimpl(m9915constructorimpl);
        if (m9918exceptionOrNullimpl != null) {
            Timber.Forest.w(m9918exceptionOrNullimpl, "Failed to persist generated notification stats device ID", new Object[0]);
        }
        return uuid;
    }

    private final PackageInfo packageInfo() {
        Object m9915constructorimpl;
        PackageInfo packageInfo;
        try {
            Result.Companion companion = Result.Companion;
            NotificationStatsDeviceInfo notificationStatsDeviceInfo = this;
            int i = Build.VERSION.SDK_INT;
            Context context = this.context;
            if (i >= 33) {
                packageInfo = context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            }
            m9915constructorimpl = Result.m9915constructorimpl(packageInfo);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9921isFailureimpl(m9915constructorimpl)) {
            m9915constructorimpl = null;
        }
        return (PackageInfo) m9915constructorimpl;
    }

    private final long longVersionCodeCompat(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }

    /* compiled from: NotificationStatsDeviceInfo.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsDeviceInfo$Companion;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_GENERATED_DEVICE_ID", "BROKEN_ANDROID_ID", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
