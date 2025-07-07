package com.miami.game.core.downloader.sync.domain;

import androidx.media3.extractor.ts.PsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncInteractor.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor", f = "DownloaderSyncInteractor.kt", i = {0, 0, 1}, l = {PsExtractor.PRIVATE_STREAM_1, 170}, m = "mutexUpdateIndoDownloaderFile", n = {"$this$withLock_u24default$iv", "idTask", "$this$withLock_u24default$iv"}, s = {"L$0", "J$0", "L$0"})
/* loaded from: classes4.dex */
public final class DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloaderSyncInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1(DownloaderSyncInteractor downloaderSyncInteractor, Continuation<? super DownloaderSyncInteractor$mutexUpdateIndoDownloaderFile$1> continuation) {
        super(continuation);
        this.this$0 = downloaderSyncInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object mutexUpdateIndoDownloaderFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        mutexUpdateIndoDownloaderFile = this.this$0.mutexUpdateIndoDownloaderFile(0L, this);
        return mutexUpdateIndoDownloaderFile;
    }
}
