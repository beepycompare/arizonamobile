package com.miami.game.core.downloader.sync.data.api;

import android.net.Uri;
import com.miami.game.core.files.Files;
import java.io.File;
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
/* compiled from: DownloaderSyncApiRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository$getFileByPath$2", f = "DownloaderSyncApiRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloaderSyncApiRepository$getFileByPath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ DownloaderSyncApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncApiRepository$getFileByPath$2(Uri uri, DownloaderSyncApiRepository downloaderSyncApiRepository, Continuation<? super DownloaderSyncApiRepository$getFileByPath$2> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.this$0 = downloaderSyncApiRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderSyncApiRepository$getFileByPath$2(this.$uri, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return ((DownloaderSyncApiRepository$getFileByPath$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Files files;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$uri == null) {
            return null;
        }
        files = this.this$0.files;
        return files.safeGetFileByUri(this.$uri);
    }
}
