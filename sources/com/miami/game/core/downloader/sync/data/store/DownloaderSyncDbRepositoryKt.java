package com.miami.game.core.downloader.sync.data.store;

import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import kotlin.Metadata;
/* compiled from: DownloaderSyncDbRepository.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toDomain", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "downloader-sync_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderSyncDbRepositoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloaderInfo toDomain(DownloaderInfoDbModel downloaderInfoDbModel) {
        return new DownloaderInfo(downloaderInfoDbModel.getId(), downloaderInfoDbModel.getPath(), downloaderInfoDbModel.getNameFromGameInfoFile(), downloaderInfoDbModel.getSizeFromGameInfoFile(), downloaderInfoDbModel.getHashFromGameInfoFile(), downloaderInfoDbModel.getDateChangeFromGameInfoFile(), downloaderInfoDbModel.getGpuTypeFromGameInfoFile(), downloaderInfoDbModel.isCompletedDownload(), downloaderInfoDbModel.getDownloadStartAt(), downloaderInfoDbModel.getDownloadFinishAt(), downloaderInfoDbModel.getCreatedAt());
    }
}
