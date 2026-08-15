package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource", f = "ArchiveManifestResolver.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {344, 356, 373, 412}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"request", "rangeLength", "retriesConsumed", "request", "error", "details", "retry", "rangeLength", "retriesConsumed", "request", "error", "details", "retry", "rangeLength", "retriesConsumed", "request", "result", "details", "retry", "rangeLength", "retriesConsumed", "status"}, nl = {345, 357, 374, 415}, s = {"L$0", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "I$1"}, v = 2)
/* loaded from: classes3.dex */
public final class OkHttpArchiveByteRangeSource$fetch$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkHttpArchiveByteRangeSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpArchiveByteRangeSource$fetch$1(OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource, Continuation<? super OkHttpArchiveByteRangeSource$fetch$1> continuation) {
        super(continuation);
        this.this$0 = okHttpArchiveByteRangeSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch(null, this);
    }
}
