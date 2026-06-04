package com.miami.game.core.downloader.sync.domain;

import android.net.Uri;
import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.sync.DownloaderState;
import com.miami.game.core.downloader.sync.data.DownloaderSyncRepository;
import com.miami.game.core.downloader.sync.domain.model.BytesAndSpeedState;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: DownloaderSyncInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0086@¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"H\u0086@¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\"H\u0086@¢\u0006\u0002\u0010'J$\u0010(\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\u0006\u0010*\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020%H\u0086@¢\u0006\u0002\u0010#J\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\"0\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\u0002\b0¨\u0006/"}, d2 = {"Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;", "", "repository", "Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;", "<init>", "(Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;)V", "Ljavax/inject/Inject;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/downloader/sync/DownloaderState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "downloadQueue", "Ljava/util/LinkedList;", "Lcom/miami/game/core/domain/model/GameInfoFile;", "currentId", "", "_currentTime", "_lastTime", "downloadState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/miami/game/core/downloader/sync/domain/model/BytesAndSpeedState;", "getDestinationUri", "Landroid/net/Uri;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileByPath", "Ljava/io/File;", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirectoryAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSideFiles", "", "listFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFiles", "gameInfoFiles", "currentTime", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadFiles", "getAllFlow", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "downloader-sync", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloaderSyncInteractor {
    private long _currentTime;
    private long _lastTime;
    private long currentId;
    private LinkedList<GameInfoFile> downloadQueue;
    private final StateFlow<DownloaderState> interactorStateFlow;
    private final DownloaderSyncRepository repository;
    private final MutableStateFlow<DownloaderState> stateStore;

    @Inject
    public DownloaderSyncInteractor(DownloaderSyncRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        MutableStateFlow<DownloaderState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DownloaderState(null, 0L, false, 7, null));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.downloadQueue = new LinkedList<>();
        this.currentId = -1L;
        this._currentTime = -1L;
        this._lastTime = -1L;
    }

    public final StateFlow<DownloaderState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    public final Flow<BytesAndSpeedState> downloadState() {
        return new DownloaderSyncInteractor$downloadState$$inlined$map$1(this.repository.downloadBytesFlow(), this);
    }

    public final Object getDestinationUri(String str, Continuation<? super Uri> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$getDestinationUri$2(this, str, null), continuation);
    }

    public final Object getFileByPath(Uri uri, Continuation<? super File> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$getFileByPath$2(this, uri, null), continuation);
    }

    public final Object getDirectoryAllFiles(Continuation<? super List<? extends File>> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$getDirectoryAllFiles$2(this, null), continuation);
    }

    public final Object deleteSideFiles(List<? extends File> list, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$deleteSideFiles$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object downloadFiles(List<GameInfoFile> list, long j, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$downloadFiles$2(list, this, j, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object cancelDownloadFiles(Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$cancelDownloadFiles$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Flow<List<DownloaderInfo>> getAllFlow() {
        return this.repository.getAllFlow();
    }
}
