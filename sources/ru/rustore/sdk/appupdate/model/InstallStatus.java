package ru.rustore.sdk.appupdate.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lru/rustore/sdk/appupdate/model/InstallStatus;", "", "Companion", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes5.dex */
public @interface InstallStatus {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DOWNLOADED = 1;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 3;
    public static final int INSTALLING = 4;
    public static final int PENDING = 5;
    public static final int UNKNOWN = 0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/rustore/sdk/appupdate/model/InstallStatus$Companion;", "", "()V", "DOWNLOADED", "", "DOWNLOADING", "FAILED", "INSTALLING", "PENDING", "UNKNOWN", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DOWNLOADED = 1;
        public static final int DOWNLOADING = 2;
        public static final int FAILED = 3;
        public static final int INSTALLING = 4;
        public static final int PENDING = 5;
        public static final int UNKNOWN = 0;

        private Companion() {
        }
    }
}
