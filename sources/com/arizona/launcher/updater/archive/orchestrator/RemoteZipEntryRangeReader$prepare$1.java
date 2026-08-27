package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryRangeReader", f = "RemoteZipEntryRangeReader.kt", i = {0, 0, 0, 0}, l = {121}, m = "prepare", n = {"session", "entry", "nextLocalHeaderOffset", "headerEnd"}, nl = {131}, s = {"L$0", "L$1", "J$0", "J$1"}, v = 2)
/* loaded from: classes3.dex */
public final class RemoteZipEntryRangeReader$prepare$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteZipEntryRangeReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteZipEntryRangeReader$prepare$1(RemoteZipEntryRangeReader remoteZipEntryRangeReader, Continuation<? super RemoteZipEntryRangeReader$prepare$1> continuation) {
        super(continuation);
        this.this$0 = remoteZipEntryRangeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.prepare(null, null, 0L, this);
    }
}
