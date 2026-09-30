package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver", f = "ArchiveManifestResolver.kt", i = {0, 0, 0, 0}, l = {271}, m = "readRemoteIndex", n = {"packageDescriptor", "serverBaseUrl", "host", "startedAt"}, nl = {273}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolver$readRemoteIndex$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveManifestResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveManifestResolver$readRemoteIndex$1(ArchiveManifestResolver archiveManifestResolver, Continuation<? super ArchiveManifestResolver$readRemoteIndex$1> continuation) {
        super(continuation);
        this.this$0 = archiveManifestResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readRemoteIndex;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readRemoteIndex = this.this$0.readRemoteIndex(null, null, this);
        return readRemoteIndex;
    }
}
