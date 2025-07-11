package com.miami.game.core.downloader.sync.data;

import android.net.Uri;
import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository;
import com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
/* compiled from: DownloaderSyncRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0086@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013J\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;", "", "apiRepository", "Lcom/miami/game/core/downloader/sync/data/api/DownloaderSyncApiRepository;", "dbRepository", "Lcom/miami/game/core/downloader/sync/data/store/DownloaderSyncDbRepository;", "<init>", "(Lcom/miami/game/core/downloader/sync/data/api/DownloaderSyncApiRepository;Lcom/miami/game/core/downloader/sync/data/store/DownloaderSyncDbRepository;)V", "downloadBytesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getDestinationUri", "Landroid/net/Uri;", "subPath", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTask", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileByPath", "Ljava/io/File;", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirectoryAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSideFiles", "", "listFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFiles", "gameInfoFile", "Lcom/miami/game/core/domain/model/GameInfoFile;", "currentTime", "(Lcom/miami/game/core/domain/model/GameInfoFile;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadFiles", "updateIndoDownloaderFile", "idTask", "getAllFlow", "downloader-sync_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderSyncRepository {
    private final DownloaderSyncApiRepository apiRepository;
    private final DownloaderSyncDbRepository dbRepository;

    @Inject
    public DownloaderSyncRepository(DownloaderSyncApiRepository apiRepository, DownloaderSyncDbRepository dbRepository) {
        Intrinsics.checkNotNullParameter(apiRepository, "apiRepository");
        Intrinsics.checkNotNullParameter(dbRepository, "dbRepository");
        this.apiRepository = apiRepository;
        this.dbRepository = dbRepository;
    }

    public final Flow<Long> downloadBytesFlow() {
        return this.apiRepository.downloadBytesFlow();
    }

    public final Object getDestinationUri(String str, Continuation<? super Uri> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$getDestinationUri$2(this, str, null), continuation);
    }

    public final Object getTask(long j, Continuation<? super DownloaderInfo> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$getTask$2(this, j, null), continuation);
    }

    public final Object getFileByPath(Uri uri, Continuation<? super File> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$getFileByPath$2(this, uri, null), continuation);
    }

    public final Object getDirectoryAllFiles(Continuation<? super List<? extends File>> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$getDirectoryAllFiles$2(this, null), continuation);
    }

    public final Object deleteSideFiles(List<? extends File> list, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$deleteSideFiles$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object downloadFiles(GameInfoFile gameInfoFile, long j, Continuation<? super Long> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$downloadFiles$2(gameInfoFile, this, j, null), continuation);
    }

    public final Object cancelDownloadFiles(Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$cancelDownloadFiles$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object updateIndoDownloaderFile(long j, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncRepository$updateIndoDownloaderFile$2(this, j, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Flow<List<DownloaderInfo>> getAllFlow() {
        return this.dbRepository.getAllFlow();
    }
}
