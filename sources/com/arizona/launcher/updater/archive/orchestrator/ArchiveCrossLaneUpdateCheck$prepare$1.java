package com.arizona.launcher.updater.archive.orchestrator;

import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveCrossLaneUpdateCheck", f = "ArchiveCrossLaneUpdateCheck.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {40, 67, 77, 94, 159, ComposerKt.reuseKey, 219}, m = "prepare", n = {"baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "baseStage", "baseRemote", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "baseStage", "baseRemote", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "disallowExistingAdoption", "baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "baseStage", "baseRemote", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "baseStage", "baseRemote", "viceStage", "viceRemote", "loadedBase", "loadedVice", "handoff", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "destructive", "baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "baseStage", "baseRemote", "viceStage", "viceRemote", "loadedBase", "loadedVice", "handoff", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "destructive", "disallowExistingAdoption", "baseCoordinator", "viceCoordinator", "baseStateStore", "viceStateStore", "baseResponse", "viceResponse", "selectedGpu", "serverBaseUrl", "bootstrapPrefetcher", "nowEpochMs", "migration", "baseStage", "baseRemote", "viceStage", "viceRemote", "loadedBase", "loadedVice", "handoff", "baseDecision", "viceEnabled", "allowCleanBootstrap", "baseMetadataAuditValidatedForFinalization", "viceMetadataAuditValidatedForFinalization", "forceNoAdoption", "reuseLocalJournalIndex", "destructive", "disallowExistingAdoption"}, nl = {48, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 83, 100, 158, 213, 225}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "Z$2", "Z$3", "Z$4", "I$0", "I$1", "I$2"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneUpdateCheck$prepare$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
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
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    boolean Z$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArchiveCrossLaneUpdateCheck this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveCrossLaneUpdateCheck$prepare$1(ArchiveCrossLaneUpdateCheck archiveCrossLaneUpdateCheck, Continuation<? super ArchiveCrossLaneUpdateCheck$prepare$1> continuation) {
        super(continuation);
        this.this$0 = archiveCrossLaneUpdateCheck;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.prepare(null, null, null, null, null, null, false, null, null, false, null, false, false, null, null, false, this);
    }
}
