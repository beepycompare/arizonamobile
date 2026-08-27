package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.apk.LauncherApkNetworkPolicy;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator", f = "ArchiveUpdateCheckCoordinator.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {106, 114, 250}, m = "prepare", n = {"response", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", RemoteConfigConstants.ResponseFieldKey.STATE, "candidate", "selection", "loadedState", "cleanBootstrap", "allowCleanBootstrap", "response", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", RemoteConfigConstants.ResponseFieldKey.STATE, "candidate", "selection", "loadedState", "cleanBootstrap", "allowCleanBootstrap", "response", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", RemoteConfigConstants.ResponseFieldKey.STATE, "candidate", "selection", "loadedState", "cleanBootstrap", "resolution", "remote", "transactionState", "effectiveState", ImagesContract.LOCAL, "sameIdentityRepairPackageIds", "plan", "stagingBytes", "archiveAllocatedBytes", "storageRequirements", "allowCleanBootstrap"}, nl = {114, 120, LauncherApkNetworkPolicy.IPV6_UNIQUE_LOCAL_MASK}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckCoordinator$prepare$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
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
        return this.this$0.prepare(null, null, null, false, null, this);
    }
}
