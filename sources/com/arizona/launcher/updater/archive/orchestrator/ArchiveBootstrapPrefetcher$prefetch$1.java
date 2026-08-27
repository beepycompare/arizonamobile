package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveBootstrapPrefetcher.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveBootstrapPrefetcher", f = "ArchiveBootstrapPrefetcher.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "prefetch", n = {"packages", "serverBaseUrl", "archivePackage", "url", "identity"}, nl = {49}, s = {"L$0", "L$1", "L$3", "L$4", "L$5"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveBootstrapPrefetcher$prefetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveBootstrapPrefetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveBootstrapPrefetcher$prefetch$1(ArchiveBootstrapPrefetcher archiveBootstrapPrefetcher, Continuation<? super ArchiveBootstrapPrefetcher$prefetch$1> continuation) {
        super(continuation);
        this.this$0 = archiveBootstrapPrefetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.prefetch(null, null, this);
    }
}
