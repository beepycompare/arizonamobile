package com.arizona.launcher.updater.archive.orchestrator;

import androidx.media3.container.MdtaMetadataEntry;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator", f = "ArchiveUpdateCheckCoordinator.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m = "prepare", n = {"response", "selectedGpu", "serverBaseUrl", RemoteConfigConstants.ResponseFieldKey.STATE, "candidate", "selection", "loadedState"}, nl = {83}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckCoordinator$prepare$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveUpdateCheckCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateCheckCoordinator$prepare$1(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, Continuation<? super ArchiveUpdateCheckCoordinator$prepare$1> continuation) {
        super(continuation);
        this.this$0 = archiveUpdateCheckCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.prepare(null, null, null, this);
    }
}
