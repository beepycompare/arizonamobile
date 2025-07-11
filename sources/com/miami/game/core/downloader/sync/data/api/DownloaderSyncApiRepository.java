package com.miami.game.core.downloader.sync.data.api;

import android.net.Uri;
import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.Downloader;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import com.miami.game.core.files.Files;
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
/* compiled from: DownloaderSyncApiRepository.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\"J\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010(J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/miami/game/core/downloader/sync/data/api/DownloaderSyncApiRepository;", "", "downloader", "Lcom/miami/game/core/downloader/Downloader;", "connectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "files", "Lcom/miami/game/core/files/Files;", "<init>", "(Lcom/miami/game/core/downloader/Downloader;Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;Lcom/miami/game/core/files/Files;)V", "getDestinationUri", "Landroid/net/Uri;", "subPath", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileByPath", "Ljava/io/File;", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirectoryAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSideFiles", "", "listFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadFiles", "ids", "", "downloadFile", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "gameInfoFile", "Lcom/miami/game/core/domain/model/GameInfoFile;", "currentTime", "(Lcom/miami/game/core/domain/model/GameInfoFile;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "path", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFileWithoutCopy", "destinationUri", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadBytesFlow", "Lkotlinx/coroutines/flow/Flow;", "downloader-sync_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderSyncApiRepository {
    private final ConnectionResolver connectionResolver;
    private final Downloader downloader;
    private final Files files;

    @Inject
    public DownloaderSyncApiRepository(Downloader downloader, ConnectionResolver connectionResolver, Files files) {
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(connectionResolver, "connectionResolver");
        Intrinsics.checkNotNullParameter(files, "files");
        this.downloader = downloader;
        this.connectionResolver = connectionResolver;
        this.files = files;
    }

    public final Object getDestinationUri(String str, Continuation<? super Uri> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$getDestinationUri$2(this, str, null), continuation);
    }

    public final Object getFileByPath(Uri uri, Continuation<? super File> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$getFileByPath$2(uri, this, null), continuation);
    }

    public final Object getDirectoryAllFiles(Continuation<? super List<? extends File>> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$getDirectoryAllFiles$2(this, null), continuation);
    }

    public final Object deleteSideFiles(List<? extends File> list, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$deleteSideFiles$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object cancelDownloadFiles(List<Long> list, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$cancelDownloadFiles$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object downloadFile(GameInfoFile gameInfoFile, long j, Continuation<? super DownloaderInfoDbModel> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$downloadFile$2(this, gameInfoFile, j, null), continuation);
    }

    public final Object downloadFile(String str, String str2, Continuation<? super Long> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$downloadFile$4(this, str2, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFileWithoutCopy(String str, Uri uri, Continuation<? super Long> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncApiRepository$downloadFileWithoutCopy$2(this, uri, str, null), continuation);
    }

    public final Flow<Long> downloadBytesFlow() {
        return this.downloader.downloadBytesFlow();
    }
}
