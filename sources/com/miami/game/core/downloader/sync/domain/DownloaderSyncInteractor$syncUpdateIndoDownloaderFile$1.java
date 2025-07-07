package com.miami.game.core.downloader.sync.domain;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.ts.TsExtractor;
import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.sync.DownloaderState;
import com.miami.game.core.downloader.sync.data.DownloaderSyncRepository;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.datetime.Clock;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import timber.log.Timber;
/* compiled from: DownloaderSyncInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1", f = "DownloaderSyncInteractor.kt", i = {0, 1}, l = {TsExtractor.TS_STREAM_TYPE_DTS, 143, BuiltInsProtoBuf.PROPERTY_GETTER_ANNOTATION_FIELD_NUMBER}, m = "invokeSuspend", n = {TypedValues.TransitionType.S_DURATION, TypedValues.TransitionType.S_DURATION}, s = {"J$0", "J$0"})
/* loaded from: classes4.dex */
final class DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $idTask;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ DownloaderSyncInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1(DownloaderSyncInteractor downloaderSyncInteractor, long j, Continuation<? super DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncInteractor;
        this.$idTask = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1(this.this$0, this.$idTask, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloaderSyncInteractor$syncUpdateIndoDownloaderFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0124, code lost:
        if (r13 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0131  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        long j3;
        Exception exc;
        long j4;
        Object mutexUpdateIndoDownloaderFile;
        DownloaderSyncRepository downloaderSyncRepository;
        long j5;
        String valueOf;
        MutableStateFlow mutableStateFlow;
        Object value;
        LinkedList linkedList;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        DownloaderSyncInteractor downloaderSyncInteractor;
        DownloaderSyncRepository downloaderSyncRepository2;
        LinkedList linkedList2;
        long j6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._currentTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
            j = this.this$0._currentTime;
            j2 = this.this$0._lastTime;
            long j7 = j - j2;
            DownloaderSyncInteractor downloaderSyncInteractor2 = this.this$0;
            j3 = downloaderSyncInteractor2._currentTime;
            downloaderSyncInteractor2._lastTime = j3;
            try {
                this.J$0 = j7;
                this.label = 1;
                mutexUpdateIndoDownloaderFile = this.this$0.mutexUpdateIndoDownloaderFile(this.$idTask, this);
                if (mutexUpdateIndoDownloaderFile != coroutine_suspended) {
                    j4 = j7;
                }
            } catch (Exception e) {
                exc = e;
                j4 = j7;
                Timber.Forest.e(exc);
                downloaderSyncRepository = this.this$0.repository;
                this.J$0 = j4;
                this.label = 2;
                obj = downloaderSyncRepository.getTask(this.$idTask, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            return coroutine_suspended;
        } else if (i == 1) {
            j4 = this.J$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                exc = e2;
                Timber.Forest.e(exc);
                downloaderSyncRepository = this.this$0.repository;
                this.J$0 = j4;
                this.label = 2;
                obj = downloaderSyncRepository.getTask(this.$idTask, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else if (i != 2) {
            if (i == 3) {
                downloaderSyncInteractor = (DownloaderSyncInteractor) this.L$0;
                ResultKt.throwOnFailure(obj);
                downloaderSyncInteractor.currentId = ((Number) obj).longValue();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            long j8 = this.J$0;
            ResultKt.throwOnFailure(obj);
            j5 = j8;
            DownloaderInfo downloaderInfo = (DownloaderInfo) obj;
            valueOf = String.valueOf(downloaderInfo == null ? downloaderInfo.getNameFromGameInfoFile() : null);
            Timber.Forest.d("state Emited " + valueOf + " " + this.$idTask, new Object[0]);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
                Timber.Forest.d("state Emited " + valueOf, new Object[0]);
            } while (!mutableStateFlow.compareAndSet(value, DownloaderState.copy$default((DownloaderState) value, valueOf, j5, false, 4, null)));
            linkedList = this.this$0.downloadQueue;
            if (!linkedList.isEmpty()) {
                mutableStateFlow2 = this.this$0.stateStore;
                do {
                    value2 = mutableStateFlow2.getValue();
                    Timber.Forest.d("state Emited downloadComplete", new Object[0]);
                } while (!mutableStateFlow2.compareAndSet(value2, DownloaderState.copy$default((DownloaderState) value2, null, 0L, true, 3, null)));
                return Unit.INSTANCE;
            }
            downloaderSyncInteractor = this.this$0;
            downloaderSyncRepository2 = downloaderSyncInteractor.repository;
            linkedList2 = this.this$0.downloadQueue;
            Object poll = linkedList2.poll();
            Intrinsics.checkNotNull(poll);
            j6 = this.this$0._currentTime;
            this.L$0 = downloaderSyncInteractor;
            this.label = 3;
            obj = downloaderSyncRepository2.downloadFiles((GameInfoFile) poll, j6, this);
        }
        downloaderSyncRepository = this.this$0.repository;
        this.J$0 = j4;
        this.label = 2;
        obj = downloaderSyncRepository.getTask(this.$idTask, this);
        if (obj != coroutine_suspended) {
            j5 = j4;
            DownloaderInfo downloaderInfo2 = (DownloaderInfo) obj;
            valueOf = String.valueOf(downloaderInfo2 == null ? downloaderInfo2.getNameFromGameInfoFile() : null);
            Timber.Forest.d("state Emited " + valueOf + " " + this.$idTask, new Object[0]);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
                Timber.Forest.d("state Emited " + valueOf, new Object[0]);
            } while (!mutableStateFlow.compareAndSet(value, DownloaderState.copy$default((DownloaderState) value, valueOf, j5, false, 4, null)));
            linkedList = this.this$0.downloadQueue;
            if (!linkedList.isEmpty()) {
            }
        }
        return coroutine_suspended;
    }
}
