package ru.rustore.sdk.appupdate.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateOptions;", "", "appUpdateType", "", "(I)V", "getAppUpdateType", "()I", "Builder", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppUpdateOptions {
    private final int appUpdateType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\b"}, d2 = {"Lru/rustore/sdk/appupdate/model/AppUpdateOptions$Builder;", "", "()V", "appUpdateType", "", "getAppUpdateType$annotations", "build", "Lru/rustore/sdk/appupdate/model/AppUpdateOptions;", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private int appUpdateType;

        private static /* synthetic */ void getAppUpdateType$annotations() {
        }

        public final Builder appUpdateType(int i) {
            this.appUpdateType = i;
            return this;
        }

        public final AppUpdateOptions build() {
            return new AppUpdateOptions(this.appUpdateType, null);
        }
    }

    private AppUpdateOptions(int i) {
        this.appUpdateType = i;
    }

    public final int getAppUpdateType() {
        return this.appUpdateType;
    }

    public /* synthetic */ AppUpdateOptions(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
