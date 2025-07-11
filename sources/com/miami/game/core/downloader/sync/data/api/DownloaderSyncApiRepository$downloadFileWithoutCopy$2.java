package com.miami.game.core.downloader.sync.data.api;

import android.net.Uri;
import com.miami.game.core.downloader.Downloader;
import com.miami.game.core.files.Files;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncApiRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository$downloadFileWithoutCopy$2", f = "DownloaderSyncApiRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloaderSyncApiRepository$downloadFileWithoutCopy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Uri $destinationUri;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ DownloaderSyncApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncApiRepository$downloadFileWithoutCopy$2(DownloaderSyncApiRepository downloaderSyncApiRepository, Uri uri, String str, Continuation<? super DownloaderSyncApiRepository$downloadFileWithoutCopy$2> continuation) {
        super(2, continuation);
        this.this$0 = downloaderSyncApiRepository;
        this.$destinationUri = uri;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncApiRepository$downloadFileWithoutCopy$2(this.this$0, this.$destinationUri, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((DownloaderSyncApiRepository$downloadFileWithoutCopy$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Files files;
        Files files2;
        Downloader downloader;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            files = this.this$0.files;
            File safeGetFileByUri = files.safeGetFileByUri(this.$destinationUri);
            files2 = this.this$0.files;
            files2.safeDelete(safeGetFileByUri);
            downloader = this.this$0.downloader;
            return Boxing.boxLong(downloader.downloadFile(Uri.parse(this.$url), this.$destinationUri));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
