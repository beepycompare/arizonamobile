package com.arizona.launcher.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.arizona.launcher.model.UpdateStatusData;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateRepository.kt */
@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/data/repository/UpdateRepository;", "", "updateApi", "Lcom/arizona/launcher/data/repository/UpdateApi;", "secondaryUpdateApi", "Lcom/arizona/launcher/data/repository/SecondaryUpdateApi;", "<init>", "(Lcom/arizona/launcher/data/repository/UpdateApi;Lcom/arizona/launcher/data/repository/SecondaryUpdateApi;)V", "updateStatusLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/arizona/launcher/data/repository/UpdateRepository$UpdateStatus;", "kotlin.jvm.PlatformType", "getUpdateStatusLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getUpdateStatus", "Lio/reactivex/Single;", "Lcom/arizona/launcher/model/UpdateStatusData;", "getSecondaryUpdateStatus", "UpdateStatus", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateRepository {
    public static final int $stable = 8;
    private final SecondaryUpdateApi secondaryUpdateApi;
    private final UpdateApi updateApi;
    private final MutableLiveData<UpdateStatus> updateStatusLiveData;

    @Inject
    public UpdateRepository(UpdateApi updateApi, SecondaryUpdateApi secondaryUpdateApi) {
        Intrinsics.checkNotNullParameter(updateApi, "updateApi");
        Intrinsics.checkNotNullParameter(secondaryUpdateApi, "secondaryUpdateApi");
        this.updateApi = updateApi;
        this.secondaryUpdateApi = secondaryUpdateApi;
        this.updateStatusLiveData = new MutableLiveData<>(UpdateStatus.UNDEFINED);
    }

    public final MutableLiveData<UpdateStatus> getUpdateStatusLiveData() {
        return this.updateStatusLiveData;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateRepository.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/data/repository/UpdateRepository$UpdateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "GAME_CACHE_UPDATE_REQUIRED", "LAUNCHER_UPDATE_REQUIRED", "UPDATED", "UNDEFINED", "ERROR", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UpdateStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UpdateStatus[] $VALUES;
        public static final UpdateStatus GAME_CACHE_UPDATE_REQUIRED = new UpdateStatus("GAME_CACHE_UPDATE_REQUIRED", 0);
        public static final UpdateStatus LAUNCHER_UPDATE_REQUIRED = new UpdateStatus("LAUNCHER_UPDATE_REQUIRED", 1);
        public static final UpdateStatus UPDATED = new UpdateStatus("UPDATED", 2);
        public static final UpdateStatus UNDEFINED = new UpdateStatus("UNDEFINED", 3);
        public static final UpdateStatus ERROR = new UpdateStatus("ERROR", 4);

        private static final /* synthetic */ UpdateStatus[] $values() {
            return new UpdateStatus[]{GAME_CACHE_UPDATE_REQUIRED, LAUNCHER_UPDATE_REQUIRED, UPDATED, UNDEFINED, ERROR};
        }

        public static EnumEntries<UpdateStatus> getEntries() {
            return $ENTRIES;
        }

        public static UpdateStatus valueOf(String str) {
            return (UpdateStatus) Enum.valueOf(UpdateStatus.class, str);
        }

        public static UpdateStatus[] values() {
            return (UpdateStatus[]) $VALUES.clone();
        }

        private UpdateStatus(String str, int i) {
        }

        static {
            UpdateStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public final Single<UpdateStatusData> getUpdateStatus() {
        return this.updateApi.getUpdateStatus();
    }

    public final Single<UpdateStatusData> getSecondaryUpdateStatus() {
        return this.secondaryUpdateApi.getSecondaryUpdateStatus();
    }
}
