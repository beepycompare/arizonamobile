package com.miami.game.core.files.updater.domain;

import android.net.Uri;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.sync.DownloaderState;
import com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor;
import com.miami.game.core.downloader.sync.domain.model.BytesAndSpeedState;
import com.miami.game.core.files.updater.domain.model.CheckedFile;
import com.miami.game.core.files.updater.domain.model.FilesUpdaterState;
import com.miami.game.core.gamefiles.info.domain.GamefilesInfoInteractor;
import com.miami.game.core.gamefiles.info.domain.model.GameInfoFileData;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import timber.log.Timber;
/* compiled from: FilesUpdaterInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u001c\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$H\u0003J\u000e\u0010&\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010'J\u0006\u0010)\u001a\u00020\u0017J\u000e\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010'J\u0016\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020$H\u0082@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020+H\u0082@¢\u0006\u0002\u0010'J\u001c\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u000206H\u0082@¢\u0006\u0002\u00107J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020403H\u0082@¢\u0006\u0002\u0010'J\u000e\u00109\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010'J\u0014\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<030;H\u0002J\f\u0010=\u001a\u00020>*\u00020?H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "", "connectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "gamefilesInfoInteractor", "Lcom/miami/game/core/gamefiles/info/domain/GamefilesInfoInteractor;", "downloaderSyncInteractor", "Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;", "<init>", "(Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;Lcom/miami/game/core/gamefiles/info/domain/GamefilesInfoInteractor;Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;)V", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/files/updater/domain/model/FilesUpdaterState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "gameInfoFilesCheckedList", "Ljava/util/LinkedList;", "Lcom/miami/game/core/files/updater/domain/model/CheckedFile;", "retry", "", "initState", "collectBytes", "Lkotlinx/coroutines/Job;", "observerDatabaseState", "updateState", "downloaderInfo", "Lcom/miami/game/core/downloader/sync/DownloaderState;", "updateStateBytes", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/downloader/sync/domain/model/BytesAndSpeedState;", "calculatePercentage", "bytes", "", "speed", "downloadGame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownload", "onRepairGameClick", "repairGame", "", "crc32", "Ljava/util/zip/CRC32;", "downloadFiles", "currentTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUpdateIsNeeded", "validationFiles", "", "Lcom/miami/game/core/domain/model/GameInfoFile;", "gameInfoFiles", "Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;", "(Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finalValidationFiles", "cancelDownloadFiles", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "md5", "", "Ljava/io/File;", "files-updater_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FilesUpdaterInteractor {
    private final ConnectionResolver connectionResolver;
    private final CRC32 crc32;
    private final DownloaderSyncInteractor downloaderSyncInteractor;
    private LinkedList<CheckedFile> gameInfoFilesCheckedList;
    private final GamefilesInfoInteractor gamefilesInfoInteractor;
    private final StateFlow<FilesUpdaterState> interactorStateFlow;
    private final CoroutineScope scope;
    private final MutableStateFlow<FilesUpdaterState> stateStore;

    @Inject
    public FilesUpdaterInteractor(ConnectionResolver connectionResolver, GamefilesInfoInteractor gamefilesInfoInteractor, DownloaderSyncInteractor downloaderSyncInteractor) {
        Intrinsics.checkNotNullParameter(connectionResolver, "connectionResolver");
        Intrinsics.checkNotNullParameter(gamefilesInfoInteractor, "gamefilesInfoInteractor");
        Intrinsics.checkNotNullParameter(downloaderSyncInteractor, "downloaderSyncInteractor");
        this.connectionResolver = connectionResolver;
        this.gamefilesInfoInteractor = gamefilesInfoInteractor;
        this.downloaderSyncInteractor = downloaderSyncInteractor;
        MutableStateFlow<FilesUpdaterState> MutableStateFlow = StateFlowKt.MutableStateFlow(FilesUpdaterState.Companion.initial());
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.gameInfoFilesCheckedList = new LinkedList<>();
        this.crc32 = new CRC32();
    }

    public final StateFlow<FilesUpdaterState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    public final void retry() {
        FilesUpdaterState value;
        initState();
        MutableStateFlow<FilesUpdaterState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, 0L, null, 0L, null, 0L, false, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 7167, null)));
    }

    private final void initState() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FilesUpdaterInteractor$initState$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job collectBytes() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FilesUpdaterInteractor$collectBytes$1(this, null), 3, null);
        return launch$default;
    }

    private final void observerDatabaseState() {
        Timber.Forest.d("observerDatabaseState", new Object[0]);
        FlowKt.launchIn(FlowKt.onEach(this.downloaderSyncInteractor.getInteractorStateFlow(), new FilesUpdaterInteractor$observerDatabaseState$1(this, null)), this.scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(DownloaderState downloaderState) {
        Object obj;
        GameInfoFile gameInfoFile;
        Long size;
        Timber.Forest.d("state Updated " + downloaderState.getNamesLastDownloads(), new Object[0]);
        Iterator<T> it = this.gameInfoFilesCheckedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CheckedFile) obj).getGameInfoFile().getName(), downloaderState.getNamesLastDownloads())) {
                break;
            }
        }
        CheckedFile checkedFile = (CheckedFile) obj;
        if (checkedFile != null) {
            checkedFile.setNewDownloaded(true);
        } else {
            checkedFile = null;
        }
        long j = 0;
        if (downloaderState.getLastDuration() > 0) {
            if (checkedFile != null && (gameInfoFile = checkedFile.getGameInfoFile()) != null && (size = gameInfoFile.getSize()) != null) {
                j = size.longValue();
            }
            j = (j / downloaderState.getLastDuration()) * 1000;
        }
        calculatePercentage$default(this, 0L, j, 1, null);
        if (downloaderState.isAllDownloadsDone()) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FilesUpdaterInteractor$updateState$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStateBytes(BytesAndSpeedState bytesAndSpeedState) {
        Timber.Forest.d("state Updated bytes " + bytesAndSpeedState.getBytes(), new Object[0]);
        calculatePercentage(bytesAndSpeedState.getBytes(), bytesAndSpeedState.getSpeed());
    }

    static /* synthetic */ void calculatePercentage$default(FilesUpdaterInteractor filesUpdaterInteractor, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        filesUpdaterInteractor.calculatePercentage(j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0274 A[LOOP:3: B:59:0x024a->B:62:0x0274, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0273 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calculatePercentage(long j, long j2) {
        long allDownloadSize;
        long j3;
        long j4;
        long j5;
        long j6;
        String str;
        long j7;
        String str2;
        long j8;
        String str3;
        long j9;
        MutableStateFlow<FilesUpdaterState> mutableStateFlow;
        FilesUpdaterState value;
        String str4;
        String str5;
        if (this.stateStore.getValue().getAllDownloadSize() == 0) {
            allDownloadSize = 0;
            for (CheckedFile checkedFile : this.gameInfoFilesCheckedList) {
                Long size = checkedFile.getGameInfoFile().getSize();
                allDownloadSize += size != null ? size.longValue() : 0L;
            }
        } else {
            allDownloadSize = this.stateStore.getValue().getAllDownloadSize();
        }
        ArrayList<CheckedFile> arrayList = new ArrayList();
        for (Object obj : this.gameInfoFilesCheckedList) {
            CheckedFile checkedFile2 = (CheckedFile) obj;
            if (checkedFile2.isNewDownloaded() || checkedFile2.isDownloadedAndChecked()) {
                arrayList.add(obj);
            }
        }
        long j10 = 0;
        for (CheckedFile checkedFile3 : arrayList) {
            Long size2 = checkedFile3.getGameInfoFile().getSize();
            j10 += size2 != null ? size2.longValue() : 0L;
        }
        long j11 = j10 + j;
        Timber.Forest.d("percentage = " + allDownloadSize + " / " + j11 + " speed: " + j2, new Object[0]);
        double d = j11 / allDownloadSize;
        long j12 = allDownloadSize - j11;
        double d2 = (Double.isNaN(d) || Double.isInfinite(d)) ? 0.0d : d;
        if (j2 == 0) {
            if (this.stateStore.getValue().getTimeRemainingSeconds() > 0) {
                j3 = this.stateStore.getValue().getTimeRemainingSeconds();
            } else {
                j4 = 0;
                long j13 = (long) DateCalculationsKt.SECONDS_PER_HOUR;
                j5 = j4 / j13;
                long j14 = 60;
                long j15 = (j4 % j13) / j14;
                long j16 = j4 % j14;
                long j17 = allDownloadSize;
                if (j5 <= 0) {
                    j6 = j11;
                    str = j5 + " ч, " + j15 + " мин, " + j16 + " сек";
                } else {
                    j6 = j11;
                    str = j15 > 0 ? j15 + " мин, " + j16 + " сек" : j16 + " сек";
                }
                long j18 = 1000000000;
                j7 = j6 / j18;
                str2 = str;
                long j19 = 1000000;
                long j20 = (j6 % j18) / j19;
                long j21 = j17 / j18;
                long j22 = (j17 % j18) / j19;
                if (j7 <= 0) {
                    j8 = j4;
                    str3 = j7 + " gb, " + j20 + " mb / " + j21 + " gb, " + j22 + " mb";
                } else {
                    j8 = j4;
                    str3 = j21 > 0 ? j20 + " mb / " + j21 + " gb, " + j22 + " mb" : j20 + " mb / " + j22 + " mb";
                }
                j9 = j8;
                Timber.Forest.d("percentage = " + d + ", time = " + j9 + ", minutes = " + j15 + ", seconds = " + j16, new Object[0]);
                mutableStateFlow = this.stateStore;
                while (true) {
                    value = mutableStateFlow.getValue();
                    str4 = str2;
                    str5 = str3;
                    if (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, j9, str4, 0L, str5, j12, false, false, false, 0L, d2, false, false, false, 7652, null))) {
                        return;
                    }
                    str2 = str4;
                    str3 = str5;
                }
            }
        } else {
            j3 = j12 / j2;
        }
        j4 = j3;
        long j132 = (long) DateCalculationsKt.SECONDS_PER_HOUR;
        j5 = j4 / j132;
        long j142 = 60;
        long j152 = (j4 % j132) / j142;
        long j162 = j4 % j142;
        long j172 = allDownloadSize;
        if (j5 <= 0) {
        }
        long j182 = 1000000000;
        j7 = j6 / j182;
        str2 = str;
        long j192 = 1000000;
        long j202 = (j6 % j182) / j192;
        long j212 = j172 / j182;
        long j222 = (j172 % j182) / j192;
        if (j7 <= 0) {
        }
        j9 = j8;
        Timber.Forest.d("percentage = " + d + ", time = " + j9 + ", minutes = " + j152 + ", seconds = " + j162, new Object[0]);
        mutableStateFlow = this.stateStore;
        while (true) {
            value = mutableStateFlow.getValue();
            str4 = str2;
            str5 = str3;
            if (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, j9, str4, 0L, str5, j12, false, false, false, 0L, d2, false, false, false, 7652, null))) {
            }
            str2 = str4;
            str3 = str5;
        }
    }

    public final Object downloadGame(Continuation<? super Job> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FilesUpdaterInteractor$downloadGame$2(this, null), continuation);
    }

    public final Object cancelDownload(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FilesUpdaterInteractor$cancelDownload$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void onRepairGameClick() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FilesUpdaterInteractor$onRepairGameClick$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7 A[LOOP:0: B:21:0x007c->B:27:0x00c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5 A[EDGE_INSN: B:29:0x00b5->B:23:0x00b5 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object repairGame(Continuation<? super Boolean> continuation) {
        FilesUpdaterInteractor$repairGame$1 filesUpdaterInteractor$repairGame$1;
        int i;
        boolean isEmpty;
        boolean z;
        MutableStateFlow<FilesUpdaterState> mutableStateFlow;
        FilesUpdaterState value;
        FilesUpdaterInteractor filesUpdaterInteractor = this;
        if (continuation instanceof FilesUpdaterInteractor$repairGame$1) {
            filesUpdaterInteractor$repairGame$1 = (FilesUpdaterInteractor$repairGame$1) continuation;
            if ((filesUpdaterInteractor$repairGame$1.label & Integer.MIN_VALUE) != 0) {
                filesUpdaterInteractor$repairGame$1.label -= Integer.MIN_VALUE;
                Object obj = filesUpdaterInteractor$repairGame$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = filesUpdaterInteractor$repairGame$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<FilesUpdaterState> mutableStateFlow2 = filesUpdaterInteractor.stateStore;
                    while (true) {
                        FilesUpdaterState value2 = mutableStateFlow2.getValue();
                        if (mutableStateFlow2.compareAndSet(value2, FilesUpdaterState.copy$default(value2, 0L, null, 0L, null, 0L, true, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 8095, null))) {
                            break;
                        }
                        filesUpdaterInteractor = this;
                    }
                    filesUpdaterInteractor$repairGame$1.label = 1;
                    obj = filesUpdaterInteractor.finalValidationFiles(filesUpdaterInteractor$repairGame$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                isEmpty = ((List) obj).isEmpty();
                z = !isEmpty;
                mutableStateFlow = filesUpdaterInteractor.stateStore;
                while (true) {
                    value = mutableStateFlow.getValue();
                    if (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, 0L, null, 0L, null, 0L, false, z, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, isEmpty, 3999, null))) {
                        break;
                    }
                }
                if (!isEmpty) {
                    calculatePercentage$default(this, 0L, 0L, 3, null);
                }
                return Boxing.boxBoolean(z);
            }
        }
        filesUpdaterInteractor$repairGame$1 = new FilesUpdaterInteractor$repairGame$1(filesUpdaterInteractor, continuation);
        Object obj2 = filesUpdaterInteractor$repairGame$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = filesUpdaterInteractor$repairGame$1.label;
        if (i != 0) {
        }
        isEmpty = ((List) obj2).isEmpty();
        z = !isEmpty;
        mutableStateFlow = filesUpdaterInteractor.stateStore;
        while (true) {
            value = mutableStateFlow.getValue();
            if (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, 0L, null, 0L, null, 0L, false, z, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, isEmpty, 3999, null))) {
            }
        }
        if (!isEmpty) {
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFiles(long j, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FilesUpdaterInteractor$downloadFiles$2(this, j, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r1 == r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r1 != r3) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkUpdateIsNeeded(Continuation<? super Boolean> continuation) {
        FilesUpdaterInteractor$checkUpdateIsNeeded$1 filesUpdaterInteractor$checkUpdateIsNeeded$1;
        int i;
        FilesUpdaterInteractor filesUpdaterInteractor = this;
        if (continuation instanceof FilesUpdaterInteractor$checkUpdateIsNeeded$1) {
            filesUpdaterInteractor$checkUpdateIsNeeded$1 = (FilesUpdaterInteractor$checkUpdateIsNeeded$1) continuation;
            if ((filesUpdaterInteractor$checkUpdateIsNeeded$1.label & Integer.MIN_VALUE) != 0) {
                filesUpdaterInteractor$checkUpdateIsNeeded$1.label -= Integer.MIN_VALUE;
                Object obj = filesUpdaterInteractor$checkUpdateIsNeeded$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = filesUpdaterInteractor$checkUpdateIsNeeded$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<FilesUpdaterState> mutableStateFlow = filesUpdaterInteractor.stateStore;
                    while (true) {
                        FilesUpdaterState value = mutableStateFlow.getValue();
                        if (mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, 0L, null, 0L, null, 0L, true, false, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 8159, null))) {
                            break;
                        }
                        filesUpdaterInteractor = this;
                    }
                    GamefilesInfoInteractor gamefilesInfoInteractor = filesUpdaterInteractor.gamefilesInfoInteractor;
                    filesUpdaterInteractor$checkUpdateIsNeeded$1.label = 1;
                    obj = gamefilesInfoInteractor.getGameInfoFiles(filesUpdaterInteractor$checkUpdateIsNeeded$1);
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        boolean isEmpty = ((List) obj).isEmpty();
                        boolean z = !isEmpty;
                        MutableStateFlow<FilesUpdaterState> mutableStateFlow2 = filesUpdaterInteractor.stateStore;
                        while (true) {
                            FilesUpdaterState value2 = mutableStateFlow2.getValue();
                            if (mutableStateFlow2.compareAndSet(value2, FilesUpdaterState.copy$default(value2, 0L, null, 0L, null, 0L, false, z, false, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, false, false, 8095, null))) {
                                break;
                            }
                            filesUpdaterInteractor = this;
                        }
                        if (!isEmpty) {
                            calculatePercentage$default(filesUpdaterInteractor, 0L, 0L, 3, null);
                        }
                        return Boxing.boxBoolean(z);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                filesUpdaterInteractor$checkUpdateIsNeeded$1.label = 2;
                obj = filesUpdaterInteractor.validationFiles((GameInfoFileData) obj, filesUpdaterInteractor$checkUpdateIsNeeded$1);
            }
        }
        filesUpdaterInteractor$checkUpdateIsNeeded$1 = new FilesUpdaterInteractor$checkUpdateIsNeeded$1(filesUpdaterInteractor, continuation);
        Object obj2 = filesUpdaterInteractor$checkUpdateIsNeeded$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = filesUpdaterInteractor$checkUpdateIsNeeded$1.label;
        if (i != 0) {
        }
        filesUpdaterInteractor$checkUpdateIsNeeded$1.label = 2;
        obj2 = filesUpdaterInteractor.validationFiles((GameInfoFileData) obj2, filesUpdaterInteractor$checkUpdateIsNeeded$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a7, code lost:
        if (cancelDownloadFiles(r2) == r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0184, code lost:
        if (r1 != r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03cf, code lost:
        if (r1.deleteSideFiles(r5, r2) == r3) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03ed A[LOOP:0: B:98:0x03e7->B:100:0x03ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0428 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5 A[LOOP:4: B:28:0x00cf->B:30:0x00d5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010b A[LOOP:5: B:32:0x0105->B:34:0x010b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0184 -> B:16:0x0060). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object validationFiles(GameInfoFileData gameInfoFileData, Continuation<? super List<GameInfoFile>> continuation) {
        FilesUpdaterInteractor$validationFiles$1 filesUpdaterInteractor$validationFiles$1;
        GameInfoFileData gameInfoFileData2;
        LinkedList linkedList;
        GameInfoFileData gameInfoFileData3;
        List list;
        Iterator it;
        HashSet hashSet;
        Iterator it2;
        GameInfoFile gameInfoFile;
        Iterator it3;
        List list2;
        LinkedList linkedList2;
        GameInfoFileData gameInfoFileData4;
        FilesUpdaterInteractor$validationFiles$1 filesUpdaterInteractor$validationFiles$12;
        boolean z;
        HashSet hashSet2;
        List list3;
        Iterator it4;
        GameInfoFileData gameInfoFileData5;
        Object obj;
        Long boxLong;
        ArrayList arrayList;
        GamefilesInfoInteractor gamefilesInfoInteractor;
        if (continuation instanceof FilesUpdaterInteractor$validationFiles$1) {
            filesUpdaterInteractor$validationFiles$1 = (FilesUpdaterInteractor$validationFiles$1) continuation;
            if ((filesUpdaterInteractor$validationFiles$1.label & Integer.MIN_VALUE) != 0) {
                filesUpdaterInteractor$validationFiles$1.label -= Integer.MIN_VALUE;
                Object obj2 = filesUpdaterInteractor$validationFiles$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z2 = true;
                boolean z3 = false;
                switch (filesUpdaterInteractor$validationFiles$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        gameInfoFileData2 = gameInfoFileData;
                        filesUpdaterInteractor$validationFiles$1.L$0 = gameInfoFileData2;
                        filesUpdaterInteractor$validationFiles$1.label = 1;
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj2);
                        gameInfoFileData2 = (GameInfoFileData) filesUpdaterInteractor$validationFiles$1.L$0;
                        linkedList = new LinkedList();
                        DownloaderSyncInteractor downloaderSyncInteractor = this.downloaderSyncInteractor;
                        filesUpdaterInteractor$validationFiles$1.L$0 = gameInfoFileData2;
                        filesUpdaterInteractor$validationFiles$1.L$1 = linkedList;
                        filesUpdaterInteractor$validationFiles$1.label = 2;
                        Object directoryAllFiles = downloaderSyncInteractor.getDirectoryAllFiles(filesUpdaterInteractor$validationFiles$1);
                        if (directoryAllFiles != coroutine_suspended) {
                            gameInfoFileData3 = gameInfoFileData2;
                            obj2 = directoryAllFiles;
                            list = (List) obj2;
                            List<File> list4 = list;
                            it = list4.iterator();
                            while (it.hasNext()) {
                                Timber.Forest.d("file in directory = " + ((File) it.next()).getName(), new Object[0]);
                            }
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                            for (File file : list4) {
                                arrayList2.add(file.getName());
                            }
                            hashSet = CollectionsKt.toHashSet(arrayList2);
                            it2 = gameInfoFileData3.getLoadedGameInfoFile().iterator();
                            if (it2.hasNext()) {
                                GameInfoFile gameInfoFile2 = (GameInfoFile) it2.next();
                                String name = gameInfoFile2.getName();
                                Intrinsics.checkNotNull(name);
                                hashSet.remove(name);
                                DownloaderSyncInteractor downloaderSyncInteractor2 = this.downloaderSyncInteractor;
                                String localPath = gameInfoFile2.getLocalPath();
                                Intrinsics.checkNotNull(localPath);
                                filesUpdaterInteractor$validationFiles$1.L$0 = gameInfoFileData3;
                                filesUpdaterInteractor$validationFiles$1.L$1 = linkedList;
                                filesUpdaterInteractor$validationFiles$1.L$2 = list;
                                filesUpdaterInteractor$validationFiles$1.L$3 = hashSet;
                                filesUpdaterInteractor$validationFiles$1.L$4 = it2;
                                filesUpdaterInteractor$validationFiles$1.L$5 = gameInfoFile2;
                                filesUpdaterInteractor$validationFiles$1.label = 3;
                                Object destinationUri = downloaderSyncInteractor2.getDestinationUri(localPath, filesUpdaterInteractor$validationFiles$1);
                                if (destinationUri != coroutine_suspended) {
                                    Iterator it5 = it2;
                                    list2 = list;
                                    obj2 = destinationUri;
                                    gameInfoFileData4 = gameInfoFileData3;
                                    it3 = it5;
                                    linkedList2 = linkedList;
                                    gameInfoFile = gameInfoFile2;
                                    DownloaderSyncInteractor downloaderSyncInteractor3 = this.downloaderSyncInteractor;
                                    filesUpdaterInteractor$validationFiles$1.L$0 = gameInfoFileData4;
                                    filesUpdaterInteractor$validationFiles$1.L$1 = linkedList2;
                                    filesUpdaterInteractor$validationFiles$1.L$2 = list2;
                                    filesUpdaterInteractor$validationFiles$1.L$3 = hashSet;
                                    filesUpdaterInteractor$validationFiles$1.L$4 = it3;
                                    filesUpdaterInteractor$validationFiles$1.L$5 = gameInfoFile;
                                    filesUpdaterInteractor$validationFiles$1.label = 4;
                                    obj2 = downloaderSyncInteractor3.getFileByPath((Uri) obj2, filesUpdaterInteractor$validationFiles$1);
                                    break;
                                }
                            } else {
                                Iterator it6 = hashSet.iterator();
                                while (it6.hasNext()) {
                                    Timber.Forest.d("file after Check= " + ((String) it6.next()), new Object[0]);
                                }
                                ArrayList arrayList3 = new ArrayList();
                                for (Object obj3 : list) {
                                    if (hashSet.contains(((File) obj3).getName())) {
                                        arrayList3.add(obj3);
                                    }
                                }
                                ArrayList arrayList4 = arrayList3;
                                if (!arrayList4.isEmpty()) {
                                    DownloaderSyncInteractor downloaderSyncInteractor4 = this.downloaderSyncInteractor;
                                    filesUpdaterInteractor$validationFiles$1.L$0 = linkedList;
                                    filesUpdaterInteractor$validationFiles$1.L$1 = null;
                                    filesUpdaterInteractor$validationFiles$1.L$2 = null;
                                    filesUpdaterInteractor$validationFiles$1.L$3 = null;
                                    filesUpdaterInteractor$validationFiles$1.L$4 = null;
                                    filesUpdaterInteractor$validationFiles$1.L$5 = null;
                                    filesUpdaterInteractor$validationFiles$1.label = 5;
                                    break;
                                }
                                LinkedList<CheckedFile> linkedList3 = this.gameInfoFilesCheckedList;
                                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedList3, 10));
                                for (CheckedFile checkedFile : linkedList3) {
                                    arrayList.add(GameInfoFile.copy$default(checkedFile.getGameInfoFile(), null, null, null, null, null, null, checkedFile.isDownloadedAndChecked(), 63, null));
                                }
                                gamefilesInfoInteractor = this.gamefilesInfoInteractor;
                                filesUpdaterInteractor$validationFiles$1.L$0 = linkedList;
                                filesUpdaterInteractor$validationFiles$1.L$1 = null;
                                filesUpdaterInteractor$validationFiles$1.L$2 = null;
                                filesUpdaterInteractor$validationFiles$1.L$3 = null;
                                filesUpdaterInteractor$validationFiles$1.L$4 = null;
                                filesUpdaterInteractor$validationFiles$1.L$5 = null;
                                filesUpdaterInteractor$validationFiles$1.label = 6;
                                if (gamefilesInfoInteractor.saveGameInfoFiles(arrayList, filesUpdaterInteractor$validationFiles$1) != coroutine_suspended) {
                                    return linkedList;
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        linkedList = (LinkedList) filesUpdaterInteractor$validationFiles$1.L$1;
                        gameInfoFileData3 = (GameInfoFileData) filesUpdaterInteractor$validationFiles$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        list = (List) obj2;
                        List<File> list42 = list;
                        it = list42.iterator();
                        while (it.hasNext()) {
                        }
                        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list42, 10));
                        while (r10.hasNext()) {
                        }
                        hashSet = CollectionsKt.toHashSet(arrayList22);
                        it2 = gameInfoFileData3.getLoadedGameInfoFile().iterator();
                        if (it2.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 3:
                        gameInfoFile = (GameInfoFile) filesUpdaterInteractor$validationFiles$1.L$5;
                        it3 = (Iterator) filesUpdaterInteractor$validationFiles$1.L$4;
                        hashSet = (HashSet) filesUpdaterInteractor$validationFiles$1.L$3;
                        list2 = (List) filesUpdaterInteractor$validationFiles$1.L$2;
                        linkedList2 = (LinkedList) filesUpdaterInteractor$validationFiles$1.L$1;
                        gameInfoFileData4 = (GameInfoFileData) filesUpdaterInteractor$validationFiles$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        DownloaderSyncInteractor downloaderSyncInteractor32 = this.downloaderSyncInteractor;
                        filesUpdaterInteractor$validationFiles$1.L$0 = gameInfoFileData4;
                        filesUpdaterInteractor$validationFiles$1.L$1 = linkedList2;
                        filesUpdaterInteractor$validationFiles$1.L$2 = list2;
                        filesUpdaterInteractor$validationFiles$1.L$3 = hashSet;
                        filesUpdaterInteractor$validationFiles$1.L$4 = it3;
                        filesUpdaterInteractor$validationFiles$1.L$5 = gameInfoFile;
                        filesUpdaterInteractor$validationFiles$1.label = 4;
                        obj2 = downloaderSyncInteractor32.getFileByPath((Uri) obj2, filesUpdaterInteractor$validationFiles$1);
                        break;
                    case 4:
                        gameInfoFile = (GameInfoFile) filesUpdaterInteractor$validationFiles$1.L$5;
                        it3 = (Iterator) filesUpdaterInteractor$validationFiles$1.L$4;
                        hashSet = (HashSet) filesUpdaterInteractor$validationFiles$1.L$3;
                        list2 = (List) filesUpdaterInteractor$validationFiles$1.L$2;
                        linkedList2 = (LinkedList) filesUpdaterInteractor$validationFiles$1.L$1;
                        gameInfoFileData4 = (GameInfoFileData) filesUpdaterInteractor$validationFiles$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Iterator it7 = it3;
                        GameInfoFile gameInfoFile3 = gameInfoFile;
                        linkedList = linkedList2;
                        File file2 = (File) obj2;
                        if (file2 == null || !file2.exists()) {
                            filesUpdaterInteractor$validationFiles$12 = filesUpdaterInteractor$validationFiles$1;
                            z = z2;
                            hashSet2 = hashSet;
                            list3 = list2;
                            it4 = it7;
                            gameInfoFileData5 = gameInfoFileData4;
                            Timber.Forest.d("file not found " + gameInfoFile3.getName() + " " + gameInfoFile3.getPath(), new Object[0]);
                            linkedList.add(gameInfoFile3);
                            this.gameInfoFilesCheckedList.add(new CheckedFile(gameInfoFile3));
                        } else {
                            Iterator<T> it8 = gameInfoFileData4.getSavedGameInfoFile().iterator();
                            while (true) {
                                if (it8.hasNext()) {
                                    obj = it8.next();
                                    if (Intrinsics.areEqual(((GameInfoFile) obj).getName(), gameInfoFile3.getName())) {
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            GameInfoFile gameInfoFile4 = (GameInfoFile) obj;
                            Long size = gameInfoFile3.getSize();
                            long length = file2.length();
                            if (size != null && size.longValue() == length) {
                                Long dateChange = gameInfoFile3.getDateChange();
                                if (gameInfoFile4 == null || (boxLong = gameInfoFile4.getDateChange()) == null) {
                                    boxLong = Boxing.boxLong(0L);
                                }
                                if (Intrinsics.areEqual(dateChange, boxLong)) {
                                    if (gameInfoFile4 != null ? gameInfoFile4.isHashChecked() : z3) {
                                        filesUpdaterInteractor$validationFiles$12 = filesUpdaterInteractor$validationFiles$1;
                                        hashSet2 = hashSet;
                                        Timber.Forest.d("file correct loaded:" + gameInfoFile3.getName() + " " + gameInfoFile3.getPath() + " " + file2.length() + " " + gameInfoFile3.getSize(), new Object[0]);
                                        LinkedList<CheckedFile> linkedList4 = this.gameInfoFilesCheckedList;
                                        CheckedFile checkedFile2 = new CheckedFile(gameInfoFile3);
                                        checkedFile2.setDownloadedAndChecked(true);
                                        linkedList4.add(checkedFile2);
                                        list3 = list2;
                                        it4 = it7;
                                        gameInfoFileData5 = gameInfoFileData4;
                                        z = true;
                                    }
                                }
                            }
                            filesUpdaterInteractor$validationFiles$12 = filesUpdaterInteractor$validationFiles$1;
                            hashSet2 = hashSet;
                            it4 = it7;
                            gameInfoFileData5 = gameInfoFileData4;
                            list3 = list2;
                            Timber.Forest.d("file not correct loaded:" + gameInfoFile3.getName() + file2.length() + " " + gameInfoFile3.getSize() + " " + gameInfoFile3.getDateChange() + " " + file2.lastModified(), new Object[0]);
                            String md5 = md5(file2);
                            if (Intrinsics.areEqual(md5, gameInfoFile3.getHash())) {
                                LinkedList<CheckedFile> linkedList5 = this.gameInfoFilesCheckedList;
                                CheckedFile checkedFile3 = new CheckedFile(gameInfoFile3);
                                z = true;
                                checkedFile3.setDownloadedAndChecked(true);
                                linkedList5.add(checkedFile3);
                            } else {
                                Timber.Forest.d("isNotSame hash crc32 name:" + gameInfoFile3.getName() + " " + md5 + " " + file2.length() + " " + gameInfoFile3.getSize(), new Object[0]);
                                linkedList.add(gameInfoFile3);
                                this.gameInfoFilesCheckedList.add(new CheckedFile(gameInfoFile3));
                                z = true;
                            }
                        }
                        filesUpdaterInteractor$validationFiles$1 = filesUpdaterInteractor$validationFiles$12;
                        z2 = z;
                        hashSet = hashSet2;
                        it2 = it4;
                        gameInfoFileData3 = gameInfoFileData5;
                        list = list3;
                        z3 = false;
                        if (it2.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 5:
                        linkedList = (LinkedList) filesUpdaterInteractor$validationFiles$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        LinkedList<CheckedFile> linkedList32 = this.gameInfoFilesCheckedList;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedList32, 10));
                        while (r1.hasNext()) {
                        }
                        gamefilesInfoInteractor = this.gamefilesInfoInteractor;
                        filesUpdaterInteractor$validationFiles$1.L$0 = linkedList;
                        filesUpdaterInteractor$validationFiles$1.L$1 = null;
                        filesUpdaterInteractor$validationFiles$1.L$2 = null;
                        filesUpdaterInteractor$validationFiles$1.L$3 = null;
                        filesUpdaterInteractor$validationFiles$1.L$4 = null;
                        filesUpdaterInteractor$validationFiles$1.L$5 = null;
                        filesUpdaterInteractor$validationFiles$1.label = 6;
                        if (gamefilesInfoInteractor.saveGameInfoFiles(arrayList, filesUpdaterInteractor$validationFiles$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 6:
                        LinkedList linkedList6 = (LinkedList) filesUpdaterInteractor$validationFiles$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        return linkedList6;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        filesUpdaterInteractor$validationFiles$1 = new FilesUpdaterInteractor$validationFiles$1(this, continuation);
        Object obj22 = filesUpdaterInteractor$validationFiles$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z22 = true;
        boolean z32 = false;
        switch (filesUpdaterInteractor$validationFiles$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (cancelDownloadFiles(r2) == r3) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
        if (r1 != r3) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0155, code lost:
        if (r1 != r3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02d2, code lost:
        if (r1.deleteSideFiles(r5, r2) == r3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0316 A[LOOP:1: B:80:0x0310->B:82:0x0316, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0155 -> B:19:0x005b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object finalValidationFiles(Continuation<? super List<GameInfoFile>> continuation) {
        FilesUpdaterInteractor$finalValidationFiles$1 filesUpdaterInteractor$finalValidationFiles$1;
        int i;
        List list;
        HashSet hashSet;
        Iterator it;
        List list2;
        HashSet hashSet2;
        Iterator it2;
        CheckedFile checkedFile;
        FilesUpdaterInteractor$finalValidationFiles$1 filesUpdaterInteractor$finalValidationFiles$12;
        if (continuation instanceof FilesUpdaterInteractor$finalValidationFiles$1) {
            filesUpdaterInteractor$finalValidationFiles$1 = (FilesUpdaterInteractor$finalValidationFiles$1) continuation;
            if ((filesUpdaterInteractor$finalValidationFiles$1.label & Integer.MIN_VALUE) != 0) {
                filesUpdaterInteractor$finalValidationFiles$1.label -= Integer.MIN_VALUE;
                Object obj = filesUpdaterInteractor$finalValidationFiles$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = filesUpdaterInteractor$finalValidationFiles$1.label;
                int i2 = 4;
                int i3 = 3;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    filesUpdaterInteractor$finalValidationFiles$1.label = 1;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    List<File> list3 = list;
                    for (File file : list3) {
                        Timber.Forest.d("file = " + file.getName() + " " + file.getPath(), new Object[0]);
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (File file2 : list3) {
                        arrayList.add(file2.getName());
                    }
                    hashSet = CollectionsKt.toHashSet(arrayList);
                    it = this.gameInfoFilesCheckedList.iterator();
                    if (it.hasNext()) {
                    }
                    return coroutine_suspended;
                } else if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            ResultKt.throwOnFailure(obj);
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj2 : this.gameInfoFilesCheckedList) {
                                if (!((CheckedFile) obj2).isDownloadedAndChecked()) {
                                    arrayList2.add(obj2);
                                }
                            }
                            ArrayList<CheckedFile> arrayList3 = arrayList2;
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                            for (CheckedFile checkedFile2 : arrayList3) {
                                arrayList4.add(checkedFile2.getGameInfoFile());
                            }
                            return arrayList4;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    checkedFile = (CheckedFile) filesUpdaterInteractor$finalValidationFiles$1.L$3;
                    it2 = (Iterator) filesUpdaterInteractor$finalValidationFiles$1.L$2;
                    hashSet2 = (HashSet) filesUpdaterInteractor$finalValidationFiles$1.L$1;
                    list2 = (List) filesUpdaterInteractor$finalValidationFiles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    it = it2;
                    File file3 = (File) obj;
                    if (file3 == null || !file3.exists()) {
                        filesUpdaterInteractor$finalValidationFiles$12 = filesUpdaterInteractor$finalValidationFiles$1;
                        Timber.Forest.d("file not found after loading" + checkedFile.getGameInfoFile().getName() + " " + checkedFile.getGameInfoFile().getPath(), new Object[0]);
                        checkedFile.setDownloadedAndChecked(false);
                        checkedFile.setNewDownloaded(false);
                    } else {
                        String md5 = md5(file3);
                        if (Intrinsics.areEqual(md5, checkedFile.getGameInfoFile().getHash())) {
                            filesUpdaterInteractor$finalValidationFiles$12 = filesUpdaterInteractor$finalValidationFiles$1;
                            Timber.Forest.d("file correct:" + checkedFile.getGameInfoFile().getName() + " " + md5 + " " + checkedFile.getGameInfoFile().getHash() + " " + file3.length() + " " + checkedFile.getGameInfoFile().getSize(), new Object[0]);
                            checkedFile.setDownloadedAndChecked(true);
                        } else {
                            Timber.Forest.d("isNotSame hash after loading:" + checkedFile.getGameInfoFile().getName() + " " + md5 + " " + file3.length() + " " + checkedFile.getGameInfoFile().getSize(), new Object[0]);
                            checkedFile.setDownloadedAndChecked(false);
                            checkedFile.setNewDownloaded(false);
                            filesUpdaterInteractor$finalValidationFiles$12 = filesUpdaterInteractor$finalValidationFiles$1;
                        }
                    }
                    hashSet = hashSet2;
                    list = list2;
                    filesUpdaterInteractor$finalValidationFiles$1 = filesUpdaterInteractor$finalValidationFiles$12;
                    i2 = 4;
                    i3 = 3;
                    if (it.hasNext()) {
                        Iterator it3 = hashSet.iterator();
                        while (it3.hasNext()) {
                            Timber.Forest.d("file after Check= " + ((String) it3.next()), new Object[0]);
                        }
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj3 : list) {
                            if (hashSet.contains(((File) obj3).getName())) {
                                arrayList5.add(obj3);
                            }
                        }
                        ArrayList arrayList6 = arrayList5;
                        if (!arrayList6.isEmpty()) {
                            DownloaderSyncInteractor downloaderSyncInteractor = this.downloaderSyncInteractor;
                            filesUpdaterInteractor$finalValidationFiles$1.L$0 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.L$1 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.L$2 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.L$3 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.label = 5;
                        }
                        ArrayList arrayList22 = new ArrayList();
                        while (r1.hasNext()) {
                        }
                        ArrayList<CheckedFile> arrayList32 = arrayList22;
                        ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList32, 10));
                        while (r2.hasNext()) {
                        }
                        return arrayList42;
                    }
                    CheckedFile checkedFile3 = (CheckedFile) it.next();
                    String name = checkedFile3.getGameInfoFile().getName();
                    Intrinsics.checkNotNull(name);
                    hashSet.remove(name);
                    DownloaderSyncInteractor downloaderSyncInteractor2 = this.downloaderSyncInteractor;
                    String localPath = checkedFile3.getGameInfoFile().getLocalPath();
                    Intrinsics.checkNotNull(localPath);
                    filesUpdaterInteractor$finalValidationFiles$1.L$0 = list;
                    filesUpdaterInteractor$finalValidationFiles$1.L$1 = hashSet;
                    filesUpdaterInteractor$finalValidationFiles$1.L$2 = it;
                    filesUpdaterInteractor$finalValidationFiles$1.L$3 = checkedFile3;
                    filesUpdaterInteractor$finalValidationFiles$1.label = i3;
                    Object destinationUri = downloaderSyncInteractor2.getDestinationUri(localPath, filesUpdaterInteractor$finalValidationFiles$1);
                    if (destinationUri != coroutine_suspended) {
                        list2 = list;
                        hashSet2 = hashSet;
                        checkedFile = checkedFile3;
                        obj = destinationUri;
                        it2 = it;
                        DownloaderSyncInteractor downloaderSyncInteractor3 = this.downloaderSyncInteractor;
                        filesUpdaterInteractor$finalValidationFiles$1.L$0 = list2;
                        filesUpdaterInteractor$finalValidationFiles$1.L$1 = hashSet2;
                        filesUpdaterInteractor$finalValidationFiles$1.L$2 = it2;
                        filesUpdaterInteractor$finalValidationFiles$1.L$3 = checkedFile;
                        filesUpdaterInteractor$finalValidationFiles$1.label = i2;
                        obj = downloaderSyncInteractor3.getFileByPath((Uri) obj, filesUpdaterInteractor$finalValidationFiles$1);
                    }
                    return coroutine_suspended;
                } else {
                    checkedFile = (CheckedFile) filesUpdaterInteractor$finalValidationFiles$1.L$3;
                    it2 = (Iterator) filesUpdaterInteractor$finalValidationFiles$1.L$2;
                    hashSet2 = (HashSet) filesUpdaterInteractor$finalValidationFiles$1.L$1;
                    list2 = (List) filesUpdaterInteractor$finalValidationFiles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    DownloaderSyncInteractor downloaderSyncInteractor32 = this.downloaderSyncInteractor;
                    filesUpdaterInteractor$finalValidationFiles$1.L$0 = list2;
                    filesUpdaterInteractor$finalValidationFiles$1.L$1 = hashSet2;
                    filesUpdaterInteractor$finalValidationFiles$1.L$2 = it2;
                    filesUpdaterInteractor$finalValidationFiles$1.L$3 = checkedFile;
                    filesUpdaterInteractor$finalValidationFiles$1.label = i2;
                    obj = downloaderSyncInteractor32.getFileByPath((Uri) obj, filesUpdaterInteractor$finalValidationFiles$1);
                }
                DownloaderSyncInteractor downloaderSyncInteractor4 = this.downloaderSyncInteractor;
                filesUpdaterInteractor$finalValidationFiles$1.label = 2;
                obj = downloaderSyncInteractor4.getDirectoryAllFiles(filesUpdaterInteractor$finalValidationFiles$1);
            }
        }
        filesUpdaterInteractor$finalValidationFiles$1 = new FilesUpdaterInteractor$finalValidationFiles$1(this, continuation);
        Object obj4 = filesUpdaterInteractor$finalValidationFiles$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = filesUpdaterInteractor$finalValidationFiles$1.label;
        int i22 = 4;
        int i32 = 3;
        if (i != 0) {
        }
        DownloaderSyncInteractor downloaderSyncInteractor42 = this.downloaderSyncInteractor;
        filesUpdaterInteractor$finalValidationFiles$1.label = 2;
        obj4 = downloaderSyncInteractor42.getDirectoryAllFiles(filesUpdaterInteractor$finalValidationFiles$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cancelDownloadFiles(Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FilesUpdaterInteractor$cancelDownloadFiles$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    private final Flow<List<DownloaderInfo>> getAllFlow() {
        return this.downloaderSyncInteractor.getAllFlow();
    }

    private final String md5(File file) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(FilesKt.readBytes(file));
        Intrinsics.checkNotNull(digest);
        return HexExtensionsKt.toHexString$default(digest, (HexFormat) null, 1, (Object) null);
    }
}
