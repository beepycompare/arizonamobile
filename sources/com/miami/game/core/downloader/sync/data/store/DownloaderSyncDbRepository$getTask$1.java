package com.miami.game.core.downloader.sync.data.store;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderSyncDbRepository.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository", f = "DownloaderSyncDbRepository.kt", i = {0}, l = {37}, m = "getTask", n = {"id"}, s = {"J$0"})
/* loaded from: classes4.dex */
public final class DownloaderSyncDbRepository$getTask$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloaderSyncDbRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderSyncDbRepository$getTask$1(DownloaderSyncDbRepository downloaderSyncDbRepository, Continuation<? super DownloaderSyncDbRepository$getTask$1> continuation) {
        super(continuation);
        this.this$0 = downloaderSyncDbRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTask(0L, this);
    }
}
