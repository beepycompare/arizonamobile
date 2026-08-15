package com.arizona.launcher;

import com.google.android.vending.expansion.downloader.impl.DownloadsDB;
import kotlin.Metadata;
/* compiled from: UpdateServiceContract.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0007\u0012\b\b\b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/UpdateServiceContract;", "", "<init>", "()V", "MessageCode", "BundleKey", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateServiceContract {
    public static final int $stable = 0;
    public static final UpdateServiceContract INSTANCE = new UpdateServiceContract();

    private UpdateServiceContract() {
    }

    /* compiled from: UpdateServiceContract.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/UpdateServiceContract$MessageCode;", "", "<init>", "()V", "CHECK_UPDATE", "", "UPDATE_GAME_DATA", "CHECK_LAUNCHER_UPDATE", "UPDATE_STATUS", "GAME_STATUS", "UPDATE_LAUNCHER", "UPDATE_INFO", "FULL_CHECK", "CHECK_STATE_ERROR", "CHECK_AND_UPDATE", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class MessageCode {
        public static final int $stable = 0;
        public static final int CHECK_AND_UPDATE = 10;
        public static final int CHECK_LAUNCHER_UPDATE = 3;
        public static final int CHECK_STATE_ERROR = 9;
        public static final int CHECK_UPDATE = 0;
        public static final int FULL_CHECK = 8;
        public static final int GAME_STATUS = 5;
        public static final MessageCode INSTANCE = new MessageCode();
        public static final int UPDATE_GAME_DATA = 2;
        public static final int UPDATE_INFO = 7;
        public static final int UPDATE_LAUNCHER = 6;
        public static final int UPDATE_STATUS = 4;

        private MessageCode() {
        }
    }

    /* compiled from: UpdateServiceContract.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/UpdateServiceContract$BundleKey;", "", "<init>", "()V", DownloadsDB.DownloadColumns.STATUS, "", "IS_GAME_DATA_UPDATE_EXISTS", "TOTAL_SIZE", "ERRNO", "NEED_UPDATE", "NEED_FREE_SPACE_SIZE", "NEED_GAME_FREE_SPACE_SIZE", "NEED_DOWNLOAD_FREE_SPACE_SIZE", "ARCHIVE_STORAGE_SAME_DEVICE", "ARCHIVE_PHASE", "ARCHIVE_UPDATE_ACTIVE", "WITH_PROGRESS", "CURRENT", "TOTAL", "TOTAL_ALL", "CURRENT_LENGTH", "TIME_LEFT", "SPEED", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BundleKey {
        public static final int $stable = 0;
        public static final String ARCHIVE_PHASE = "archive_phase";
        public static final String ARCHIVE_STORAGE_SAME_DEVICE = "archiveStorageSameDevice";
        public static final String ARCHIVE_UPDATE_ACTIVE = "archive_update_active";
        public static final String CURRENT = "current";
        public static final String CURRENT_LENGTH = "current_len";
        public static final String ERRNO = "errno";
        public static final BundleKey INSTANCE = new BundleKey();
        public static final String IS_GAME_DATA_UPDATE_EXISTS = "isGameDataUpdateExists";
        public static final String NEED_DOWNLOAD_FREE_SPACE_SIZE = "needDownloadFreeSpaceSize";
        public static final String NEED_FREE_SPACE_SIZE = "needFreeSpaceSize";
        public static final String NEED_GAME_FREE_SPACE_SIZE = "needGameFreeSpaceSize";
        public static final String NEED_UPDATE = "needUpdateMsg";
        public static final String SPEED = "speed";
        public static final String STATUS = "status";
        public static final String TIME_LEFT = "timeLeft";
        public static final String TOTAL = "total";
        public static final String TOTAL_ALL = "total_all";
        public static final String TOTAL_SIZE = "total_size";
        public static final String WITH_PROGRESS = "withProgress";

        private BundleKey() {
        }
    }
}
