package com.miami.game.core.downloader.sync.data;

import android.net.Uri;
import com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository;
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
/* compiled from: DownloaderSyncRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.DownloaderSyncRepository$getDestinationUri$2", f = "DownloaderSyncRepository.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloaderSyncRepository$getDestinationUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ String $subPath;
    int label;
    final /* synthetic */ DownloaderSyncRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncRepository$getDestinationUri$2(DownloaderSyncRepository downloaderSyncRepository, String str, Continuation<? super DownloaderSyncRepository$getDestinationUri$2> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncRepository;
        this.$subPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncRepository$getDestinationUri$2(this.this$0, this.$subPath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((DownloaderSyncRepository$getDestinationUri$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloaderSyncApiRepository downloaderSyncApiRepository;
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
        downloaderSyncApiRepository = this.this$0.apiRepository;
        this.label = 1;
        Object destinationUri = downloaderSyncApiRepository.getDestinationUri(this.$subPath, this);
        return destinationUri == coroutine_suspended ? coroutine_suspended : destinationUri;
    }
}
