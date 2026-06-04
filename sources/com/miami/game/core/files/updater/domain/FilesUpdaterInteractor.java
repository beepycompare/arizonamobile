package com.miami.game.core.files.updater.domain;

import android.net.Uri;
import androidx.media3.common.C;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor;
import com.miami.game.core.downloader.sync.domain.model.BytesAndSpeedState;
import com.miami.game.core.files.updater.domain.model.CheckedFile;
import com.miami.game.core.files.updater.domain.model.FilesUpdaterState;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;
/* compiled from: FilesUpdaterInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J.\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0003b\u0010\b\u001d\u0012\f\b\u001e\u0012\b\b\fJ\u0004\b\b(\u001fJ\u000e\u0010 \u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010!J\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010!J\u0016\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0082@¢\u0006\u0002\u0010!J\u000e\u0010,\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010!J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\u0002\b1¨\u00060"}, d2 = {"Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "", "downloaderSyncInteractor", "Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;", "<init>", "(Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;)V", "Ljavax/inject/Inject;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/files/updater/domain/model/FilesUpdaterState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "gameInfoFilesCheckedList", "Ljava/util/LinkedList;", "Lcom/miami/game/core/files/updater/domain/model/CheckedFile;", "collectBytes", "Lkotlinx/coroutines/Job;", "updateStateBytes", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/downloader/sync/domain/model/BytesAndSpeedState;", "calculatePercentage", "bytes", "", "speed", "Landroid/annotation/SuppressLint;", "value", "DefaultLocale", "downloadGame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownload", "onRepairGameClick", "repairGame", "", "downloadFiles", "currentTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finalValidationFiles", "", "Lcom/miami/game/core/domain/model/GameInfoFile;", "cancelDownloadFiles", "md5", "", "Ljava/io/File;", "files-updater", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FilesUpdaterInteractor {
    private final DownloaderSyncInteractor downloaderSyncInteractor;
    private LinkedList<CheckedFile> gameInfoFilesCheckedList;
    private final StateFlow<FilesUpdaterState> interactorStateFlow;
    private final CoroutineScope scope;
    private final MutableStateFlow<FilesUpdaterState> stateStore;

    @Inject
    public FilesUpdaterInteractor(DownloaderSyncInteractor downloaderSyncInteractor) {
        Intrinsics.checkNotNullParameter(downloaderSyncInteractor, "downloaderSyncInteractor");
        this.downloaderSyncInteractor = downloaderSyncInteractor;
        MutableStateFlow<FilesUpdaterState> MutableStateFlow = StateFlowKt.MutableStateFlow(FilesUpdaterState.Companion.initial());
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.gameInfoFilesCheckedList = new LinkedList<>();
    }

    public final StateFlow<FilesUpdaterState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job collectBytes() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FilesUpdaterInteractor$collectBytes$1(this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStateBytes(BytesAndSpeedState bytesAndSpeedState) {
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023a A[LOOP:3: B:60:0x0212->B:63:0x023a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0239 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calculatePercentage(long j, long j2) {
        long allDownloadSize;
        long j3;
        long j4;
        long j5;
        String str;
        String str2;
        String str3;
        MutableStateFlow<FilesUpdaterState> mutableStateFlow;
        FilesUpdaterState value;
        String str4;
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
        long j6 = 0;
        for (CheckedFile checkedFile3 : arrayList) {
            Long size2 = checkedFile3.getGameInfoFile().getSize();
            j6 += size2 != null ? size2.longValue() : 0L;
        }
        long j7 = j6 + j;
        double d = j7 / allDownloadSize;
        long j8 = allDownloadSize - j7;
        double d2 = (Double.isNaN(d) || Double.isInfinite(d)) ? 0.0d : d;
        if (j2 == 0) {
            if (this.stateStore.getValue().getTimeRemainingSeconds() > 0) {
                j3 = this.stateStore.getValue().getTimeRemainingSeconds();
            } else {
                j4 = 0;
                j5 = j4 / 3600;
                long j9 = (j4 % 3600) / 60;
                long j10 = j4 % 60;
                long j11 = allDownloadSize;
                if (j5 <= 0) {
                    str = j5 + " ч, " + j9 + " мин, " + j10 + " сек";
                } else {
                    str = j9 > 0 ? j9 + " мин, " + j10 + " сек" : j10 + " сек";
                }
                long j12 = j7 / C.NANOS_PER_SECOND;
                long j13 = (j7 % C.NANOS_PER_SECOND) / 1000000;
                str2 = str;
                long j14 = j11 / C.NANOS_PER_SECOND;
                long j15 = (j11 % C.NANOS_PER_SECOND) / 1000000;
                str3 = j12 <= 0 ? j12 + " gb, " + j13 + " mb / " + j14 + " gb, " + j15 + " mb" : j14 > 0 ? j13 + " mb / " + j14 + " gb, " + j15 + " mb" : j13 + " mb / " + j15 + " mb";
                Timber.Forest.d("percentage = " + d + ", time = " + j4 + ", minutes = " + j9 + ", seconds = " + j10, new Object[0]);
                mutableStateFlow = this.stateStore;
                while (true) {
                    value = mutableStateFlow.getValue();
                    str4 = str2;
                    if (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, j4, str4, 0L, str3, j8, false, false, false, 0L, d2, false, false, false, 7652, null))) {
                        return;
                    }
                    str2 = str4;
                }
            }
        } else {
            j3 = j8 / j2;
        }
        j4 = j3;
        j5 = j4 / 3600;
        long j92 = (j4 % 3600) / 60;
        long j102 = j4 % 60;
        long j112 = allDownloadSize;
        if (j5 <= 0) {
        }
        long j122 = j7 / C.NANOS_PER_SECOND;
        long j132 = (j7 % C.NANOS_PER_SECOND) / 1000000;
        str2 = str;
        long j142 = j112 / C.NANOS_PER_SECOND;
        long j152 = (j112 % C.NANOS_PER_SECOND) / 1000000;
        str3 = j122 <= 0 ? j122 + " gb, " + j132 + " mb / " + j142 + " gb, " + j152 + " mb" : j142 > 0 ? j132 + " mb / " + j142 + " gb, " + j152 + " mb" : j132 + " mb / " + j152 + " mb";
        Timber.Forest.d("percentage = " + d + ", time = " + j4 + ", minutes = " + j92 + ", seconds = " + j102, new Object[0]);
        mutableStateFlow = this.stateStore;
        while (true) {
            value = mutableStateFlow.getValue();
            str4 = str2;
            if (!mutableStateFlow.compareAndSet(value, FilesUpdaterState.copy$default(value, j4, str4, 0L, str3, j8, false, false, false, 0L, d2, false, false, false, 7652, null))) {
            }
            str2 = str4;
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
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
        if (cancelDownloadFiles(r2) == r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b0, code lost:
        if (r1 != r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0194, code lost:
        if (r1 != r3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0227, code lost:
        if (r5.deleteSideFiles(r6, r2) == r3) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026b A[LOOP:1: B:75:0x0265->B:77:0x026b, LOOP_END] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.miami.game.core.files.updater.domain.FilesUpdaterInteractor] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0194 -> B:46:0x0198). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object finalValidationFiles(Continuation<? super List<GameInfoFile>> continuation) {
        FilesUpdaterInteractor$finalValidationFiles$1 filesUpdaterInteractor$finalValidationFiles$1;
        int i;
        List list;
        HashSet hashSet;
        LinkedList<CheckedFile> linkedList;
        Iterator it;
        List list2;
        HashSet hashSet2;
        Object obj;
        CheckedFile checkedFile;
        boolean z;
        if (continuation instanceof FilesUpdaterInteractor$finalValidationFiles$1) {
            filesUpdaterInteractor$finalValidationFiles$1 = (FilesUpdaterInteractor$finalValidationFiles$1) continuation;
            if ((filesUpdaterInteractor$finalValidationFiles$1.label & Integer.MIN_VALUE) != 0) {
                filesUpdaterInteractor$finalValidationFiles$1.label -= Integer.MIN_VALUE;
                Object obj2 = filesUpdaterInteractor$finalValidationFiles$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = filesUpdaterInteractor$finalValidationFiles$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    filesUpdaterInteractor$finalValidationFiles$1.label = 1;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj2);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj2);
                    list = (List) obj2;
                    List<File> list3 = list;
                    for (File file : list3) {
                        Timber.Forest.d("file = " + file.getName() + " " + file.getPath(), new Object[0]);
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (File file2 : list3) {
                        arrayList.add(file2.getName());
                    }
                    hashSet = CollectionsKt.toHashSet(arrayList);
                    linkedList = this.gameInfoFilesCheckedList;
                    it = linkedList.iterator();
                    if (it.hasNext()) {
                    }
                    return coroutine_suspended;
                } else if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            List list4 = (List) filesUpdaterInteractor$finalValidationFiles$1.L$2;
                            HashSet hashSet3 = (HashSet) filesUpdaterInteractor$finalValidationFiles$1.L$1;
                            List list5 = (List) filesUpdaterInteractor$finalValidationFiles$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj3 : this.gameInfoFilesCheckedList) {
                                if (!((CheckedFile) obj3).isDownloadedAndChecked()) {
                                    arrayList2.add(obj3);
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
                    Uri uri = (Uri) filesUpdaterInteractor$finalValidationFiles$1.L$6;
                    checkedFile = (CheckedFile) filesUpdaterInteractor$finalValidationFiles$1.L$5;
                    Object obj4 = filesUpdaterInteractor$finalValidationFiles$1.L$4;
                    it = (Iterator) filesUpdaterInteractor$finalValidationFiles$1.L$3;
                    hashSet2 = (HashSet) filesUpdaterInteractor$finalValidationFiles$1.L$1;
                    list2 = (List) filesUpdaterInteractor$finalValidationFiles$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    linkedList = (Iterable) filesUpdaterInteractor$finalValidationFiles$1.L$2;
                    File file3 = (File) obj2;
                    if (file3 == null || !file3.exists()) {
                        z = true;
                        checkedFile.setDownloadedAndChecked(false);
                        checkedFile.setNewDownloaded(false);
                    } else if (Intrinsics.areEqual(md5(file3), checkedFile.getGameInfoFile().getHash())) {
                        z = true;
                        checkedFile.setDownloadedAndChecked(true);
                    } else {
                        checkedFile.setDownloadedAndChecked(false);
                        checkedFile.setNewDownloaded(false);
                        z = true;
                    }
                    hashSet = hashSet2;
                    list = list2;
                    if (it.hasNext()) {
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj5 : list) {
                            if (hashSet.contains(((File) obj5).getName())) {
                                arrayList5.add(obj5);
                            }
                        }
                        ArrayList arrayList6 = arrayList5;
                        if (!arrayList6.isEmpty()) {
                            DownloaderSyncInteractor downloaderSyncInteractor = this.downloaderSyncInteractor;
                            filesUpdaterInteractor$finalValidationFiles$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            filesUpdaterInteractor$finalValidationFiles$1.L$1 = SpillingKt.nullOutSpilledVariable(hashSet);
                            filesUpdaterInteractor$finalValidationFiles$1.L$2 = SpillingKt.nullOutSpilledVariable(arrayList6);
                            filesUpdaterInteractor$finalValidationFiles$1.L$3 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.L$4 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.L$5 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.L$6 = null;
                            filesUpdaterInteractor$finalValidationFiles$1.label = 5;
                        }
                        ArrayList arrayList22 = new ArrayList();
                        while (r0.hasNext()) {
                        }
                        ArrayList<CheckedFile> arrayList32 = arrayList22;
                        ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList32, 10));
                        while (r1.hasNext()) {
                        }
                        return arrayList42;
                    }
                    obj = it.next();
                    CheckedFile checkedFile3 = (CheckedFile) obj;
                    String name = checkedFile3.getGameInfoFile().getName();
                    Intrinsics.checkNotNull(name);
                    hashSet.remove(name);
                    DownloaderSyncInteractor downloaderSyncInteractor2 = this.downloaderSyncInteractor;
                    String localPath = checkedFile3.getGameInfoFile().getLocalPath();
                    filesUpdaterInteractor$finalValidationFiles$1.L$0 = list;
                    filesUpdaterInteractor$finalValidationFiles$1.L$1 = hashSet;
                    filesUpdaterInteractor$finalValidationFiles$1.L$2 = SpillingKt.nullOutSpilledVariable(linkedList);
                    filesUpdaterInteractor$finalValidationFiles$1.L$3 = it;
                    filesUpdaterInteractor$finalValidationFiles$1.L$4 = SpillingKt.nullOutSpilledVariable(obj);
                    filesUpdaterInteractor$finalValidationFiles$1.L$5 = checkedFile3;
                    filesUpdaterInteractor$finalValidationFiles$1.L$6 = null;
                    filesUpdaterInteractor$finalValidationFiles$1.label = 3;
                    Object destinationUri = downloaderSyncInteractor2.getDestinationUri(localPath, filesUpdaterInteractor$finalValidationFiles$1);
                    if (destinationUri != coroutine_suspended) {
                        hashSet2 = hashSet;
                        checkedFile = checkedFile3;
                        list2 = list;
                        obj2 = destinationUri;
                        Uri uri2 = (Uri) obj2;
                        DownloaderSyncInteractor downloaderSyncInteractor3 = this.downloaderSyncInteractor;
                        filesUpdaterInteractor$finalValidationFiles$1.L$0 = list2;
                        filesUpdaterInteractor$finalValidationFiles$1.L$1 = hashSet2;
                        filesUpdaterInteractor$finalValidationFiles$1.L$2 = SpillingKt.nullOutSpilledVariable(linkedList);
                        filesUpdaterInteractor$finalValidationFiles$1.L$3 = it;
                        filesUpdaterInteractor$finalValidationFiles$1.L$4 = SpillingKt.nullOutSpilledVariable(obj);
                        filesUpdaterInteractor$finalValidationFiles$1.L$5 = checkedFile;
                        filesUpdaterInteractor$finalValidationFiles$1.L$6 = SpillingKt.nullOutSpilledVariable(uri2);
                        filesUpdaterInteractor$finalValidationFiles$1.label = 4;
                        obj2 = downloaderSyncInteractor3.getFileByPath(uri2, filesUpdaterInteractor$finalValidationFiles$1);
                    }
                    return coroutine_suspended;
                } else {
                    checkedFile = (CheckedFile) filesUpdaterInteractor$finalValidationFiles$1.L$5;
                    Object obj6 = filesUpdaterInteractor$finalValidationFiles$1.L$4;
                    Iterator it2 = (Iterator) filesUpdaterInteractor$finalValidationFiles$1.L$3;
                    ResultKt.throwOnFailure(obj2);
                    obj = obj6;
                    it = it2;
                    linkedList = (Iterable) filesUpdaterInteractor$finalValidationFiles$1.L$2;
                    hashSet2 = (HashSet) filesUpdaterInteractor$finalValidationFiles$1.L$1;
                    list2 = (List) filesUpdaterInteractor$finalValidationFiles$1.L$0;
                    Uri uri22 = (Uri) obj2;
                    DownloaderSyncInteractor downloaderSyncInteractor32 = this.downloaderSyncInteractor;
                    filesUpdaterInteractor$finalValidationFiles$1.L$0 = list2;
                    filesUpdaterInteractor$finalValidationFiles$1.L$1 = hashSet2;
                    filesUpdaterInteractor$finalValidationFiles$1.L$2 = SpillingKt.nullOutSpilledVariable(linkedList);
                    filesUpdaterInteractor$finalValidationFiles$1.L$3 = it;
                    filesUpdaterInteractor$finalValidationFiles$1.L$4 = SpillingKt.nullOutSpilledVariable(obj);
                    filesUpdaterInteractor$finalValidationFiles$1.L$5 = checkedFile;
                    filesUpdaterInteractor$finalValidationFiles$1.L$6 = SpillingKt.nullOutSpilledVariable(uri22);
                    filesUpdaterInteractor$finalValidationFiles$1.label = 4;
                    obj2 = downloaderSyncInteractor32.getFileByPath(uri22, filesUpdaterInteractor$finalValidationFiles$1);
                }
                DownloaderSyncInteractor downloaderSyncInteractor4 = this.downloaderSyncInteractor;
                filesUpdaterInteractor$finalValidationFiles$1.label = 2;
                obj2 = downloaderSyncInteractor4.getDirectoryAllFiles(filesUpdaterInteractor$finalValidationFiles$1);
            }
        }
        filesUpdaterInteractor$finalValidationFiles$1 = new FilesUpdaterInteractor$finalValidationFiles$1(this, continuation);
        Object obj22 = filesUpdaterInteractor$finalValidationFiles$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = filesUpdaterInteractor$finalValidationFiles$1.label;
        if (i != 0) {
        }
        DownloaderSyncInteractor downloaderSyncInteractor42 = this.downloaderSyncInteractor;
        filesUpdaterInteractor$finalValidationFiles$1.label = 2;
        obj22 = downloaderSyncInteractor42.getDirectoryAllFiles(filesUpdaterInteractor$finalValidationFiles$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cancelDownloadFiles(Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FilesUpdaterInteractor$cancelDownloadFiles$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    private final String md5(File file) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(FilesKt.readBytes(file));
        Intrinsics.checkNotNull(digest);
        return HexExtensionsKt.toHexString$default(digest, (HexFormat) null, 1, (Object) null);
    }
}
