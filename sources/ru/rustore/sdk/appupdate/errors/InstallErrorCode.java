package ru.rustore.sdk.appupdate.errors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lru/rustore/sdk/appupdate/errors/InstallErrorCode;", "", "Companion", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes5.dex */
public @interface InstallErrorCode {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int ERROR_ABORTED = 4010;
    public static final int ERROR_ACTIVITY_SEND_INTENT = 9901;
    public static final int ERROR_ACTIVITY_UNKNOWN = 9902;
    public static final int ERROR_APK_NOT_FOUND = 4011;
    public static final int ERROR_APP_NOT_OWNED = 4008;
    public static final int ERROR_BLOCKED = 4003;
    public static final int ERROR_CONFLICT = 4005;
    public static final int ERROR_DOWNLOAD = 4002;
    public static final int ERROR_EXTERNAL_SOURCE_DENIED = 4012;
    public static final int ERROR_INCOMPATIBLE = 4007;
    public static final int ERROR_INTERNAL_ERROR = 4009;
    public static final int ERROR_INVALID_APK = 4004;
    public static final int ERROR_STORAGE = 4006;
    public static final int ERROR_UNKNOWN = 4001;
    public static final int NO_ERROR = 0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/rustore/sdk/appupdate/errors/InstallErrorCode$Companion;", "", "()V", "ERROR_ABORTED", "", "ERROR_ACTIVITY_SEND_INTENT", "ERROR_ACTIVITY_UNKNOWN", "ERROR_APK_NOT_FOUND", "ERROR_APP_NOT_OWNED", "ERROR_BLOCKED", "ERROR_CONFLICT", "ERROR_DOWNLOAD", "ERROR_EXTERNAL_SOURCE_DENIED", "ERROR_INCOMPATIBLE", "ERROR_INTERNAL_ERROR", "ERROR_INVALID_APK", "ERROR_STORAGE", "ERROR_UNKNOWN", "NO_ERROR", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ERROR_ABORTED = 4010;
        public static final int ERROR_ACTIVITY_SEND_INTENT = 9901;
        public static final int ERROR_ACTIVITY_UNKNOWN = 9902;
        public static final int ERROR_APK_NOT_FOUND = 4011;
        public static final int ERROR_APP_NOT_OWNED = 4008;
        public static final int ERROR_BLOCKED = 4003;
        public static final int ERROR_CONFLICT = 4005;
        public static final int ERROR_DOWNLOAD = 4002;
        public static final int ERROR_EXTERNAL_SOURCE_DENIED = 4012;
        public static final int ERROR_INCOMPATIBLE = 4007;
        public static final int ERROR_INTERNAL_ERROR = 4009;
        public static final int ERROR_INVALID_APK = 4004;
        public static final int ERROR_STORAGE = 4006;
        public static final int ERROR_UNKNOWN = 4001;
        public static final int NO_ERROR = 0;

        private Companion() {
        }
    }
}
