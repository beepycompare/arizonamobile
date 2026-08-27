package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader", f = "RemoteZipEntryRangeReader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {296}, m = "readPreparedToFile", n = {"session", "prepared", FirebaseAnalytics.Param.DESTINATION, "onProgress", "entry", "parent", "writeResult", "payloadBytesRead"}, nl = {323}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
/* loaded from: classes3.dex */
public final class RemoteZipEntryRangeReader$readPreparedToFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteZipEntryRangeReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteZipEntryRangeReader$readPreparedToFile$1(RemoteZipEntryRangeReader remoteZipEntryRangeReader, Continuation<? super RemoteZipEntryRangeReader$readPreparedToFile$1> continuation) {
        super(continuation);
        this.this$0 = remoteZipEntryRangeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readPreparedToFile(null, null, null, null, this);
    }
}
