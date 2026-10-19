package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator", f = "ArchiveUpdateCheckCoordinator.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {165, 173}, m = "resolveRemoteCheck", n = {"response", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", RemoteConfigConstants.ResponseFieldKey.STATE, "candidate", "loadedState", "cleanBootstrap", "indexState", "allowCleanBootstrap", "reuseLocalJournalIndex", "response", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", RemoteConfigConstants.ResponseFieldKey.STATE, "candidate", "loadedState", "cleanBootstrap", "indexState", "allowCleanBootstrap", "reuseLocalJournalIndex"}, nl = {173, 179}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "Z$1"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveUpdateCheckCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1(ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator, Continuation<? super ArchiveUpdateCheckCoordinator$resolveRemoteCheck$1> continuation) {
        super(continuation);
        this.this$0 = archiveUpdateCheckCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resolveRemoteCheck(null, null, null, false, null, false, this);
    }
}
