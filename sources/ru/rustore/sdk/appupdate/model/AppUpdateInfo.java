package ru.rustore.sdk.appupdate.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.f0;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B_\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000bJ\r\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u0006)"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "", "appName", "", "iconUrl", "fileSize", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "availableVersionCode", "installStatus", "", "updateAvailability", "updatePriority", "updatedAt", "forceUpdateAvailable", "", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JIIILjava/lang/String;Z)V", "getAppId$sdk_public_appupdate_release", "()J", "getAppName$sdk_public_appupdate_release", "()Ljava/lang/String;", "getAvailableVersionCode", "getFileSize$sdk_public_appupdate_release", "getIconUrl$sdk_public_appupdate_release", "getInstallStatus", "()I", "<set-?>", "isUsed", "isUsed$sdk_public_appupdate_release", "()Z", "getPackageName", "getUpdateAvailability", "getUpdatePriority", "getUpdatedAt", "isUpdateTypeAllowed", "updateType", "markIsUsed", "", "markIsUsed$sdk_public_appupdate_release", "Factory", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppUpdateInfo {
    private final long appId;
    private final String appName;
    private final long availableVersionCode;
    private final long fileSize;
    private final boolean forceUpdateAvailable;
    private final String iconUrl;
    private final int installStatus;
    private boolean isUsed;
    private final String packageName;
    private final int updateAvailability;
    private final int updatePriority;
    private final String updatedAt;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J_\u0010\u0018\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateInfo$Factory;", "", "", "updatePriority", "", "updatedAt", "", "getForceUpdateAvailable", "Ljava/util/Date;", "currentTime", "updatedAtDate", "calcDayBetween", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "appName", "iconUrl", "fileSize", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "availableVersionCode", "installStatus", "updateAvailability", "Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "create$sdk_public_appupdate_release", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JIIILjava/lang/String;)Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "create", "Lru/rustore/sdk/appupdate/f0;", "timeProvider", "Lru/rustore/sdk/appupdate/f0;", "<init>", "(Lru/rustore/sdk/appupdate/f0;)V", "Companion", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes5.dex */
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
        private final f0 timeProvider;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateInfo$Factory$Companion;", "", "()V", "DAYS_BETWEEN_10", "", "DAYS_BETWEEN_20", "DAYS_BETWEEN_3", "DAYS_BETWEEN_30", "UPDATED_FORMAT", "", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Factory(f0 timeProvider) {
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
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(UPDATED_FORMAT, f0.b);
            simpleDateFormat.setTimeZone(f0.c);
            Date parse = simpleDateFormat.parse(string);
            Intrinsics.checkNotNull(parse);
            Date time = this.timeProvider.f1348a.getTime();
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

        public final AppUpdateInfo create$sdk_public_appupdate_release(long j, String appName, String iconUrl, long j2, String packageName, long j3, int i, int i2, int i3, String updatedAt) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
            return new AppUpdateInfo(j, appName, iconUrl, j2, packageName, j3, i, i2, i3, updatedAt, getForceUpdateAvailable(i3, updatedAt), null);
        }
    }

    private AppUpdateInfo(long j, String str, String str2, long j2, String str3, long j3, int i, int i2, int i3, String str4, boolean z) {
        this.appId = j;
        this.appName = str;
        this.iconUrl = str2;
        this.fileSize = j2;
        this.packageName = str3;
        this.availableVersionCode = j3;
        this.installStatus = i;
        this.updateAvailability = i2;
        this.updatePriority = i3;
        this.updatedAt = str4;
        this.forceUpdateAvailable = z;
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

    public final long getFileSize$sdk_public_appupdate_release() {
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

    public /* synthetic */ AppUpdateInfo(long j, String str, String str2, long j2, String str3, long j3, int i, int i2, int i3, String str4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, j2, str3, j3, i, i2, i3, str4, z);
    }
}
