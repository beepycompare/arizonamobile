package com.miami.game.core.downloader.sync.domain;

import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.downloader.sync.data.DownloaderSyncRepository;
import java.util.LinkedList;
import java.util.List;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$downloadFiles$2", f = "DownloaderSyncInteractor.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloaderSyncInteractor$downloadFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentTime;
    final /* synthetic */ List<GameInfoFile> $gameInfoFiles;
    Object L$0;
    int label;
    final /* synthetic */ DownloaderSyncInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncInteractor$downloadFiles$2(List<GameInfoFile> list, DownloaderSyncInteractor downloaderSyncInteractor, long j, Continuation<? super DownloaderSyncInteractor$downloadFiles$2> continuation) {
        super(2, continuation);
        this.$gameInfoFiles = list;
        this.this$0 = downloaderSyncInteractor;
        this.$currentTime = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncInteractor$downloadFiles$2(this.$gameInfoFiles, this.this$0, this.$currentTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloaderSyncInteractor$downloadFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloaderSyncRepository downloaderSyncRepository;
        LinkedList linkedList;
        DownloaderSyncInteractor downloaderSyncInteractor;
        LinkedList linkedList2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DownloaderSyncInteractor downloaderSyncInteractor2 = this.this$0;
            for (GameInfoFile gameInfoFile : this.$gameInfoFiles) {
                linkedList2 = downloaderSyncInteractor2.downloadQueue;
                linkedList2.add(gameInfoFile);
            }
            this.this$0._lastTime = this.$currentTime;
            this.this$0._currentTime = this.$currentTime;
            DownloaderSyncInteractor downloaderSyncInteractor3 = this.this$0;
            downloaderSyncRepository = downloaderSyncInteractor3.repository;
            linkedList = this.this$0.downloadQueue;
            Object poll = linkedList.poll();
            Intrinsics.checkNotNull(poll);
            this.L$0 = downloaderSyncInteractor3;
            this.label = 1;
            Object downloadFiles = downloaderSyncRepository.downloadFiles((GameInfoFile) poll, this.$currentTime, this);
            if (downloadFiles == coroutine_suspended) {
                return coroutine_suspended;
            }
            downloaderSyncInteractor = downloaderSyncInteractor3;
            obj = downloadFiles;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            downloaderSyncInteractor = (DownloaderSyncInteractor) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        downloaderSyncInteractor.currentId = ((Number) obj).longValue();
        return Unit.INSTANCE;
    }
}
