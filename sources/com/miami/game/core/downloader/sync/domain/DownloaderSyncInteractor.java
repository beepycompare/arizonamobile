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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.datetime.Clock;
import timber.log.Timber;
/* compiled from: DownloaderSyncInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0086@¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020!0%H\u0086@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020!0%H\u0086@¢\u0006\u0002\u0010*J$\u0010+\u001a\u00020(2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110%2\u0006\u0010-\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020(H\u0086@¢\u0006\u0002\u0010&J\u000e\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0013J\u0016\u00102\u001a\u00020(2\u0006\u00101\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u00020(2\u0006\u00101\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00103J\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060%0\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;", "", "repository", "Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;", "<init>", "(Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/downloader/sync/DownloaderState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "downloadQueue", "Ljava/util/LinkedList;", "Lcom/miami/game/core/domain/model/GameInfoFile;", "currentId", "", "_currentTime", "_lastTime", "updateMutex", "Lkotlinx/coroutines/sync/Mutex;", "downloadState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/miami/game/core/downloader/sync/domain/model/BytesAndSpeedState;", "getDestinationUri", "Landroid/net/Uri;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileByPath", "Ljava/io/File;", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirectoryAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSideFiles", "", "listFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFiles", "gameInfoFiles", "currentTime", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadFiles", "syncUpdateIndoDownloaderFile", "idTask", "mutexUpdateIndoDownloaderFile", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateIndoDownloaderFile", "getAllFlow", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "downloader-sync_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderSyncInteractor {
    private long _currentTime;
    private long _lastTime;
    private long currentId;
    private LinkedList<GameInfoFile> downloadQueue;
    private final StateFlow<DownloaderState> interactorStateFlow;
    private final DownloaderSyncRepository repository;
    private final CoroutineScope scope;
    private final MutableStateFlow<DownloaderState> stateStore;
    private final Mutex updateMutex;

    @Inject
    public DownloaderSyncInteractor(DownloaderSyncRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        MutableStateFlow<DownloaderState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DownloaderState(null, 0L, false, 7, null));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.downloadQueue = new LinkedList<>();
        this.currentId = -1L;
        this._currentTime = -1L;
        this._lastTime = -1L;
        this.updateMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public final StateFlow<DownloaderState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    public final Flow<BytesAndSpeedState> downloadState() {
        final Flow<Long> downloadBytesFlow = this.repository.downloadBytesFlow();
        return new Flow<BytesAndSpeedState>() { // from class: com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DownloaderSyncInteractor this$0;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1$2", f = "DownloaderSyncInteractor.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
                /* renamed from: com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DownloaderSyncInteractor downloaderSyncInteractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = downloaderSyncInteractor;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    long j;
                    long j2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                long longValue = ((Number) obj).longValue();
                                this.this$0._currentTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
                                j = this.this$0._currentTime;
                                j2 = this.this$0._lastTime;
                                long j3 = j - j2;
                                long j4 = 0;
                                if (j3 > 0) {
                                    j4 = 1000 * (longValue / j3);
                                }
                                BytesAndSpeedState bytesAndSpeedState = new BytesAndSpeedState(longValue, j4);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(bytesAndSpeedState, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BytesAndSpeedState> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
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

    public final void syncUpdateIndoDownloaderFile(long j) {
        if (this.currentId == j) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1(this, j, null), 2, null);
        } else {
            Timber.Forest.d("state Emited recieved unknown id task " + j, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r9.lock(null, r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mutexUpdateIndoDownloaderFile(long j, Continuation<? super Unit> continuation) {
        DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1 downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        Mutex mutex2;
        try {
            if (continuation instanceof DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1) {
                downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1 = (DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1) continuation;
                if ((downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label & Integer.MIN_VALUE) != 0) {
                    downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label -= Integer.MIN_VALUE;
                    Object obj = downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.updateMutex;
                        downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.L$0 = mutex;
                        downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.J$0 = j;
                        downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label = 1;
                    } else if (i != 1) {
                        if (i == 2) {
                            mutex2 = (Mutex) downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return unit;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        j = downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.L$0;
                    }
                    downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.L$0 = mutex;
                    downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label = 2;
                    if (updateIndoDownloaderFile(j, downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1) != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit2;
                    }
                    return coroutine_suspended;
                }
            }
            downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.L$0 = mutex;
            downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label = 2;
            if (updateIndoDownloaderFile(j, downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
        downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1 = new DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1(this, continuation);
        Object obj2 = downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = downloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateIndoDownloaderFile(long j, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncInteractor$updateIndoDownloaderFile$2(this, j, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Flow<List<DownloaderInfo>> getAllFlow() {
        return this.repository.getAllFlow();
    }
}
