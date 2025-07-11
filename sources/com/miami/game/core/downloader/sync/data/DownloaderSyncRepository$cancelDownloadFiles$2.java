package com.miami.game.core.downloader.sync.data;

import com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository;
import com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.DownloaderSyncRepository$cancelDownloadFiles$2", f = "DownloaderSyncRepository.kt", i = {1}, l = {80, 81}, m = "invokeSuspend", n = {"currentIdTasks"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class DownloaderSyncRepository$cancelDownloadFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DownloaderSyncRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncRepository$cancelDownloadFiles$2(DownloaderSyncRepository downloaderSyncRepository, Continuation<? super DownloaderSyncRepository$cancelDownloadFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncRepository$cancelDownloadFiles$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloaderSyncRepository$cancelDownloadFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r6 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r1.cancelDownloadFiles(r6, r5) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DownloaderSyncDbRepository downloaderSyncDbRepository;
        DownloaderSyncApiRepository downloaderSyncApiRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            downloaderSyncDbRepository = this.this$0.dbRepository;
            this.label = 1;
            obj = downloaderSyncDbRepository.getAllNotCompletedTasks(this);
        } else if (i != 1) {
            if (i == 2) {
                List list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List<Long> list2 = (List) obj;
        downloaderSyncApiRepository = this.this$0.apiRepository;
        this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
        this.label = 2;
    }
}
