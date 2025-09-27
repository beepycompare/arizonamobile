package ru.rustore.sdk.appupdate.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.i0;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,Bo\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\fJ\r\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006-"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "", "appName", "", "iconUrl", "fileSize", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "availableVersionName", "availableVersionCode", "installStatus", "", "updateAvailability", "updatePriority", "updatedAt", "forceUpdateAvailable", "", "whatsNew", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JIIILjava/lang/String;ZLjava/lang/String;)V", "getAppId$sdk_public_appupdate_release", "()J", "getAppName$sdk_public_appupdate_release", "()Ljava/lang/String;", "getAvailableVersionCode", "getAvailableVersionName", "getFileSize", "getIconUrl$sdk_public_appupdate_release", "getInstallStatus", "()I", "<set-?>", "isUsed", "isUsed$sdk_public_appupdate_release", "()Z", "getPackageName", "getUpdateAvailability", "getUpdatePriority", "getUpdatedAt", "getWhatsNew", "isUpdateTypeAllowed", "updateType", "markIsUsed", "", "markIsUsed$sdk_public_appupdate_release", "Factory", "sdk-public-appupdate_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AppUpdateInfo {
    private final long appId;
    private final String appName;
    private final long availableVersionCode;
    private final String availableVersionName;
    private final long fileSize;
    private final boolean forceUpdateAvailable;
    private final String iconUrl;
    private final int installStatus;
    private boolean isUsed;
    private final String packageName;
    private final int updateAvailability;
    private final int updatePriority;
    private final String updatedAt;
    private final String whatsNew;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011Jo\u0010 \u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!¨\u0006#"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateInfo$Factory;", "", "Lru/rustore/sdk/appupdate/i0;", "timeProvider", "<init>", "(Lru/rustore/sdk/appupdate/i0;)V", "", "updatePriority", "", "updatedAt", "", "getForceUpdateAvailable", "(ILjava/lang/String;)Z", "Ljava/util/Date;", "currentTime", "updatedAtDate", "calcDayBetween", "(Ljava/util/Date;Ljava/util/Date;)I", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "appName", "iconUrl", "fileSize", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "availableVersionName", "availableVersionCode", "installStatus", "updateAvailability", "whatsNew", "Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "create$sdk_public_appupdate_release", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JIIILjava/lang/String;Ljava/lang/String;)Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "create", "Lru/rustore/sdk/appupdate/i0;", "Companion", "sdk-public-appupdate_release"}, k = 1, mv = {1, 7, 0})
    /* loaded from: classes6.dex */
    public static final class Factory {
        private static final Companion Companion = new Companion(null);
        @Deprecated
        public static final int DAYS_BETWEEN_10 = 10;
        @Deprecated
        public static final int DAYS_BETWEEN_20 = 20;
        @Deprecated
        public static final int DAYS_BETWEEN_3 = 3;
        @Deprecated
        public static final int DAYS_BETWEEN_30 = 30;
        @Deprecated
        public static final String UPDATED_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        private final i0 timeProvider;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateInfo$Factory$Companion;", "", "()V", "DAYS_BETWEEN_10", "", "DAYS_BETWEEN_20", "DAYS_BETWEEN_3", "DAYS_BETWEEN_30", "UPDATED_FORMAT", "", "sdk-public-appupdate_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Factory(i0 timeProvider) {
            Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
            this.timeProvider = timeProvider;
        }

        private final int calcDayBetween(Date date, Date date2) {
            return (int) TimeUnit.DAYS.convert(date.getTime() - date2.getTime(), TimeUnit.MILLISECONDS);
        }

        private final boolean getForceUpdateAvailable(int i, String string) {
            this.timeProvider.getClass();
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(UPDATED_FORMAT, "dateFormat");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(UPDATED_FORMAT, i0.b);
            simpleDateFormat.setTimeZone(i0.c);
            Date parse = simpleDateFormat.parse(string);
            Intrinsics.checkNotNull(parse);
            Date time = this.timeProvider.f1400a.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
            int calcDayBetween = calcDayBetween(time, parse);
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                        } else if (calcDayBetween < 3) {
                            return false;
                        }
                    } else if (calcDayBetween < 10) {
                        return false;
                    }
                } else if (calcDayBetween < 20) {
                    return false;
                }
            } else if (calcDayBetween < 30) {
                return false;
            }
            return true;
        }

        public final AppUpdateInfo create$sdk_public_appupdate_release(long j, String appName, String iconUrl, long j2, String packageName, String availableVersionName, long j3, int i, int i2, int i3, String updatedAt, String whatsNew) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(availableVersionName, "availableVersionName");
            Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
            Intrinsics.checkNotNullParameter(whatsNew, "whatsNew");
            return new AppUpdateInfo(j, appName, iconUrl, j2, packageName, availableVersionName, j3, i, i2, i3, updatedAt, getForceUpdateAvailable(i3, updatedAt), whatsNew, null);
        }
    }

    private AppUpdateInfo(long j, String str, String str2, long j2, String str3, String str4, long j3, int i, int i2, int i3, String str5, boolean z, String str6) {
        this.appId = j;
        this.appName = str;
        this.iconUrl = str2;
        this.fileSize = j2;
        this.packageName = str3;
        this.availableVersionName = str4;
        this.availableVersionCode = j3;
        this.installStatus = i;
        this.updateAvailability = i2;
        this.updatePriority = i3;
        this.updatedAt = str5;
        this.forceUpdateAvailable = z;
        this.whatsNew = str6;
    }

    public final long getAppId$sdk_public_appupdate_release() {
        return this.appId;
    }

    public final String getAppName$sdk_public_appupdate_release() {
        return this.appName;
    }

    public final long getAvailableVersionCode() {
        return this.availableVersionCode;
    }

    public final String getAvailableVersionName() {
        return this.availableVersionName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getIconUrl$sdk_public_appupdate_release() {
        return this.iconUrl;
    }

    public final int getInstallStatus() {
        return this.installStatus;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getUpdateAvailability() {
        return this.updateAvailability;
    }

    public final int getUpdatePriority() {
        return this.updatePriority;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getWhatsNew() {
        return this.whatsNew;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isUpdateTypeAllowed(int i) {
        if (i != 0) {
            if (i == 1) {
                return this.updateAvailability == 2 && this.forceUpdateAvailable;
            } else if (i != 2) {
                return false;
            }
        }
        if (this.updateAvailability != 2) {
            return false;
        }
    }

    public final boolean isUsed$sdk_public_appupdate_release() {
        return this.isUsed;
    }

    public final void markIsUsed$sdk_public_appupdate_release() {
        this.isUsed = true;
    }

    public /* synthetic */ AppUpdateInfo(long j, String str, String str2, long j2, String str3, String str4, long j3, int i, int i2, int i3, String str5, boolean z, String str6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, j2, str3, str4, j3, i, i2, i3, str5, z, str6);
    }
}
