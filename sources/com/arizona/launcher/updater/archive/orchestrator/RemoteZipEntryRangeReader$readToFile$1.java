package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader", f = "RemoteZipEntryRangeReader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {239, 248}, m = "readToFile", n = {"session", "entry", FirebaseAnalytics.Param.DESTINATION, "onProgress", "nextLocalHeaderOffset", "session", "entry", FirebaseAnalytics.Param.DESTINATION, "onProgress", "preparation", "nextLocalHeaderOffset"}, nl = {240, 256}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class RemoteZipEntryRangeReader$readToFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteZipEntryRangeReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteZipEntryRangeReader$readToFile$1(RemoteZipEntryRangeReader remoteZipEntryRangeReader, Continuation<? super RemoteZipEntryRangeReader$readToFile$1> continuation) {
        super(continuation);
        this.this$0 = remoteZipEntryRangeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readToFile(null, null, null, 0L, null, this);
    }
}
