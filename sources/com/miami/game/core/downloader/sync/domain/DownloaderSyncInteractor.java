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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: DownloaderSyncInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0086@¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0086@¢\u0006\u0002\u0010&J$\u0010'\u001a\u00020$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0!2\u0006\u0010)\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020$H\u0086@¢\u0006\u0002\u0010\"J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0!0\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/miami/game/core/downloader/sync/domain/DownloaderSyncInteractor;", "", "repository", "Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;", "<init>", "(Lcom/miami/game/core/downloader/sync/data/DownloaderSyncRepository;)V", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/downloader/sync/DownloaderState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "downloadQueue", "Ljava/util/LinkedList;", "Lcom/miami/game/core/domain/model/GameInfoFile;", "currentId", "", "_currentTime", "_lastTime", "downloadState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/miami/game/core/downloader/sync/domain/model/BytesAndSpeedState;", "getDestinationUri", "Landroid/net/Uri;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileByPath", "Ljava/io/File;", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirectoryAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSideFiles", "", "listFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFiles", "gameInfoFiles", "currentTime", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDownloadFiles", "getAllFlow", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "downloader-sync_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
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
        final Flow<Long> downloadBytesFlow = this.repository.downloadBytesFlow();
        return new Flow<BytesAndSpeedState>() { // from class: com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DownloaderSyncInteractor this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1$2", f = "DownloaderSyncInteractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                /* renamed from: com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadState$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
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
                /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
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
                                this.this$0._currentTime = System.currentTimeMillis();
                                j = this.this$0._currentTime;
                                j2 = this.this$0._lastTime;
                                long j3 = j - j2;
                                long j4 = 0;
                                if (j3 > 0) {
                                    j4 = 1000 * (longValue / j3);
                                }
                                BytesAndSpeedState bytesAndSpeedState = new BytesAndSpeedState(longValue, j4);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(bytesAndSpeedState, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                int i2 = anonymousClass1.I$0;
                                FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                                Object obj3 = anonymousClass1.L$2;
                                AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$1;
                                Object obj4 = anonymousClass1.L$0;
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

    public final Flow<List<DownloaderInfo>> getAllFlow() {
        return this.repository.getAllFlow();
    }
}
