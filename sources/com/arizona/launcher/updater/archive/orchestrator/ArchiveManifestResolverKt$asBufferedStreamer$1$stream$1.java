package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolverKt$asBufferedStreamer$1", f = "ArchiveManifestResolver.kt", i = {0, 0}, l = {326}, m = "stream", n = {"request", "consumer"}, nl = {327}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveManifestResolverKt$asBufferedStreamer$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1(ArchiveManifestResolverKt$asBufferedStreamer$1 archiveManifestResolverKt$asBufferedStreamer$1, Continuation<? super ArchiveManifestResolverKt$asBufferedStreamer$1$stream$1> continuation) {
        super(continuation);
        this.this$0 = archiveManifestResolverKt$asBufferedStreamer$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stream(null, null, this);
    }
}
