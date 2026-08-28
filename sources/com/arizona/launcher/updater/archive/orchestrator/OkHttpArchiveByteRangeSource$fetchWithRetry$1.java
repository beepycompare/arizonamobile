package com.arizona.launcher.updater.archive.orchestrator;

import androidx.window.core.layout.WindowSizeClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource", f = "ArchiveManifestResolver.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {444, 479, 519}, m = "fetchWithRetry", n = {"request", "consumer", "bodyHasStarted", "expectedBodyBytes", "retriesConsumed", "request", "consumer", "bodyHasStarted", "error", "details", "retry", "expectedBodyBytes", "retriesConsumed", "request", "consumer", "bodyHasStarted", "result", "details", "retry", "expectedBodyBytes", "retriesConsumed", "status"}, nl = {445, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 522}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 2)
/* loaded from: classes3.dex */
public final class OkHttpArchiveByteRangeSource$fetchWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkHttpArchiveByteRangeSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpArchiveByteRangeSource$fetchWithRetry$1(OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource, Continuation<? super OkHttpArchiveByteRangeSource$fetchWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = okHttpArchiveByteRangeSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchWithRetry = this.this$0.fetchWithRetry(null, 0, null, null, this);
        return fetchWithRetry;
    }
}
