package com.miami.game.core.downloader.sync.data;

import android.net.Uri;
import androidx.media3.extractor.text.ttml.TtmlNode;
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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH\u0086@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001bJ\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0014J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001a0\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;", "", "apiRepository", "Lcom/miami/game/core/downloader/sync/data/api/DownloaderSyncApiRepository;", "dbRepository", "Lcom/miami/game/core/downloader/sync/data/store/DownloaderSyncDbRepository;", "<init>", "(Lcom/miami/game/core/downloader/sync/data/api/DownloaderSyncApiRepository;Lcom/miami/game/core/downloader/sync/data/store/DownloaderSyncDbRepository;)V", "Ljavax/inject/Inject;", "downloadBytesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getDestinationUri", "Landroid/net/Uri;", "subPath", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTask", "Lcom/miami/game/core/domain/model/DownloaderInfo;", TtmlNode.ATTR_ID, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileByPath", "Ljava/io/File;", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirectoryAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSideFiles", "", "listFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFiles", "gameInfoFile", "Lcom/miami/game/core/domain/model/GameInfoFile;", "currentTime", "(Lcom/miami/game/core/domain/model/GameInfoFile;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadFiles", "updateIndoDownloaderFile", "idTask", "getAllFlow", "downloader-sync"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
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
