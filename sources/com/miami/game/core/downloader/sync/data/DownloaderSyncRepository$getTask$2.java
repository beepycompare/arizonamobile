package com.miami.game.core.downloader.sync.data;

import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: DownloaderSyncRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.DownloaderSyncRepository$getTask$2", f = "DownloaderSyncRepository.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DownloaderSyncRepository$getTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DownloaderInfo>, Object> {
    final /* synthetic */ long $id;
    int label;
    final /* synthetic */ DownloaderSyncRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncRepository$getTask$2(DownloaderSyncRepository downloaderSyncRepository, long j, Continuation<? super DownloaderSyncRepository$getTask$2> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncRepository;
        this.$id = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncRepository$getTask$2(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DownloaderInfo> continuation) {
        return ((DownloaderSyncRepository$getTask$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloaderSyncDbRepository downloaderSyncDbRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        downloaderSyncDbRepository = this.this$0.dbRepository;
        this.label = 1;
        Object task = downloaderSyncDbRepository.getTask(this.$id, this);
        return task == coroutine_suspended ? coroutine_suspended : task;
    }
}
