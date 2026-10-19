package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH¦@¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigration;", "", "suppressCleanBootstrap", "", "getSuppressCleanBootstrap", "()Z", "reuseLocalJournalIndex", "getReuseLocalJournalIndex", "destructiveCleanup", "getDestructiveCleanup", "afterRemotesValidated", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult;", "baseRemote", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "viceRemote", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveGenerationMigration {
    Object afterRemotesValidated(ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2, Continuation<? super ArchiveGenerationMigrationResult> continuation);

    default boolean getDestructiveCleanup() {
        return false;
    }

    boolean getReuseLocalJournalIndex();

    boolean getSuppressCleanBootstrap();

    /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getDestructiveCleanup(ArchiveGenerationMigration archiveGenerationMigration) {
            return ArchiveGenerationMigration.super.getDestructiveCleanup();
        }
    }
}
