package com.miami.game.core.downloader.sync.domain;

import com.miami.game.core.downloader.sync.data.DownloaderSyncRepository;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncInteractor.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor$getDirectoryAllFiles$2", f = "DownloaderSyncInteractor.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloaderSyncInteractor$getDirectoryAllFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends File>>, Object> {
    int label;
    final /* synthetic */ DownloaderSyncInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncInteractor$getDirectoryAllFiles$2(DownloaderSyncInteractor downloaderSyncInteractor, Continuation<? super DownloaderSyncInteractor$getDirectoryAllFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncInteractor$getDirectoryAllFiles$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends File>> continuation) {
        return ((DownloaderSyncInteractor$getDirectoryAllFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloaderSyncRepository downloaderSyncRepository;
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
        downloaderSyncRepository = this.this$0.repository;
        this.label = 1;
        Object directoryAllFiles = downloaderSyncRepository.getDirectoryAllFiles(this);
        return directoryAllFiles == coroutine_suspended ? coroutine_suspended : directoryAllFiles;
    }
}
