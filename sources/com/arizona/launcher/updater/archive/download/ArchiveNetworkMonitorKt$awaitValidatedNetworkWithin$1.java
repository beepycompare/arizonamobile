package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveNetworkMonitor.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitorKt", f = "ArchiveNetworkMonitor.kt", i = {0, 0}, l = {23}, m = "awaitValidatedNetworkWithin", n = {"$this$awaitValidatedNetworkWithin", "timeoutMs"}, nl = {-1}, s = {"L$0", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1(Continuation<? super ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ArchiveNetworkMonitorKt.awaitValidatedNetworkWithin(null, 0L, this);
    }
}
