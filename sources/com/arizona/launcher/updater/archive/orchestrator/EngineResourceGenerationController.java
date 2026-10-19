package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigrationResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceCleanupResult;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationEvaluation;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationLoadResult;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EngineResourceGenerationController.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bJ:\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\b2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007J\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u0006\u0010\u001d\u001a\u00020\nJ\"\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0007J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0002J(\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\u0003\u0010\u0000¨\u0006)"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationController;", "", "store", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore;", "migration", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration;", "remoteGeneration", "Lkotlin/Function0;", "", "gameActivityExists", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore;Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "gateLock", "cached", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation;", "evaluationFor", "operationToken", "migrationHook", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigration;", "roots", "Lkotlin/Function2;", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupRequest;", "onPrepared", "", "markCompletedIfInstallReady", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "lanesReady", "requiresFreshCheckBeforeNoWork", "onNoWork", "refresh", "reportSuccess", "promoteCompleted", "preparedGeneration", "evaluate", "readyEvaluation", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationEvaluation$Ready;", "prepared", "completed", "markerPresent", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceGenerationController {
    public static final int $stable = 8;
    private EngineResourceGenerationEvaluation cached;
    private final Function0<Boolean> gameActivityExists;
    private final Object gateLock;
    private final EngineResourceGenerationMigration migration;
    private final Function0<Long> remoteGeneration;
    private final EngineResourceGenerationStore store;

    public EngineResourceGenerationController(EngineResourceGenerationStore store, EngineResourceGenerationMigration migration, Function0<Long> remoteGeneration, Function0<Boolean> gameActivityExists) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(migration, "migration");
        Intrinsics.checkNotNullParameter(remoteGeneration, "remoteGeneration");
        Intrinsics.checkNotNullParameter(gameActivityExists, "gameActivityExists");
        this.store = store;
        this.migration = migration;
        this.remoteGeneration = remoteGeneration;
        this.gameActivityExists = gameActivityExists;
        this.gateLock = new Object();
    }

    public final EngineResourceGenerationEvaluation evaluationFor(long j) {
        synchronized (this.gateLock) {
            EngineResourceGenerationEvaluation engineResourceGenerationEvaluation = this.cached;
            if (engineResourceGenerationEvaluation == null || engineResourceGenerationEvaluation.getOperationToken() != j) {
                EngineResourceGenerationEvaluation evaluate = evaluate(j);
                this.cached = evaluate;
                return evaluate;
            }
            return engineResourceGenerationEvaluation;
        }
    }

    public final ArchiveGenerationMigration migrationHook(long j, final Function2<? super ArchiveManifest, ? super ArchiveManifest, EngineResourceCleanupRequest> roots, final Function0<Unit> onPrepared) {
        Intrinsics.checkNotNullParameter(roots, "roots");
        Intrinsics.checkNotNullParameter(onPrepared, "onPrepared");
        final EngineResourceGenerationEvaluation evaluationFor = evaluationFor(j);
        if ((evaluationFor instanceof EngineResourceGenerationEvaluation.Ready) && ((EngineResourceGenerationEvaluation.Ready) evaluationFor).getAction() == EngineResourceGenerationAction.MIGRATE) {
            return new ArchiveGenerationMigration() { // from class: com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationController$migrationHook$1
                private final boolean reuseLocalJournalIndex;
                private final boolean suppressCleanBootstrap = true;
                private final boolean destructiveCleanup = true;

                @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigration
                public boolean getSuppressCleanBootstrap() {
                    return this.suppressCleanBootstrap;
                }

                @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigration
                public boolean getReuseLocalJournalIndex() {
                    return this.reuseLocalJournalIndex;
                }

                @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigration
                public boolean getDestructiveCleanup() {
                    return this.destructiveCleanup;
                }

                @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigration
                public Object afterRemotesValidated(ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2, Continuation<? super ArchiveGenerationMigrationResult> continuation) {
                    Function0 function0;
                    EngineResourceGenerationMigration engineResourceGenerationMigration;
                    EngineResourceGenerationStore engineResourceGenerationStore;
                    function0 = EngineResourceGenerationController.this.gameActivityExists;
                    if (!((Boolean) function0.invoke()).booleanValue()) {
                        engineResourceGenerationMigration = EngineResourceGenerationController.this.migration;
                        EngineResourceCleanupResult cleanup = engineResourceGenerationMigration.cleanup(roots.invoke(archiveManifest, archiveManifest2));
                        if (Intrinsics.areEqual(cleanup, EngineResourceCleanupResult.Success.INSTANCE)) {
                            try {
                                engineResourceGenerationStore = EngineResourceGenerationController.this.store;
                                engineResourceGenerationStore.savePrepared(((EngineResourceGenerationEvaluation.Ready) evaluationFor).getTarget());
                                onPrepared.invoke();
                                return ArchiveGenerationMigrationResult.Prepared.INSTANCE;
                            } catch (IOException e) {
                                return new ArchiveGenerationMigrationResult.Blocked(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "Unable to persist prepared resource generation: " + e.getMessage()));
                            }
                        } else if (!(cleanup instanceof EngineResourceCleanupResult.Failure)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            EngineResourceCleanupResult.Failure failure = (EngineResourceCleanupResult.Failure) cleanup;
                            return new ArchiveGenerationMigrationResult.Blocked(new ArchiveUpdateCheckDecision.Block(failure.getCode(), failure.getDetail()));
                        }
                    }
                    return new ArchiveGenerationMigrationResult.Blocked(new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_INVALID, "Resource generation migration is deferred while the game is running"));
                }
            };
        }
        return null;
    }

    public final ArchiveUpdateCheckDecision.Block markCompletedIfInstallReady(Function0<Boolean> lanesReady) {
        Intrinsics.checkNotNullParameter(lanesReady, "lanesReady");
        EngineResourceGenerationLoadResult load = this.store.load();
        if (load instanceof EngineResourceGenerationLoadResult.Corrupt) {
            return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_CORRUPT, ((EngineResourceGenerationLoadResult.Corrupt) load).getReason());
        }
        if (Intrinsics.areEqual(load, EngineResourceGenerationLoadResult.Missing.INSTANCE)) {
            return null;
        }
        if (!(load instanceof EngineResourceGenerationLoadResult.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        EngineResourceGenerationState state = ((EngineResourceGenerationLoadResult.Loaded) load).getState();
        if (state.getCompletedGeneration() < state.getPreparedGeneration() && lanesReady.invoke().booleanValue()) {
            try {
                this.store.saveCompleted(state.getPreparedGeneration());
                promoteCompleted(state.getPreparedGeneration());
                return null;
            } catch (IOException e) {
                return new ArchiveUpdateCheckDecision.Block(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "Unable to persist completed resource generation: " + e.getMessage());
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (((com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationEvaluation.Ready) r4).getAction() != com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationAction.UP_TO_DATE) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean requiresFreshCheckBeforeNoWork() {
        boolean z;
        synchronized (this.gateLock) {
            EngineResourceGenerationEvaluation engineResourceGenerationEvaluation = this.cached;
            z = false;
            if (engineResourceGenerationEvaluation != null) {
                if (!(engineResourceGenerationEvaluation instanceof EngineResourceGenerationEvaluation.Corrupt)) {
                    if (!(engineResourceGenerationEvaluation instanceof EngineResourceGenerationEvaluation.Ready)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                z = true;
            }
        }
        return z;
    }

    public final void onNoWork(Function0<Unit> refresh, Function0<Unit> reportSuccess) {
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(reportSuccess, "reportSuccess");
        if (requiresFreshCheckBeforeNoWork()) {
            refresh.invoke();
        } else {
            reportSuccess.invoke();
        }
    }

    private final void promoteCompleted(long j) {
        synchronized (this.gateLock) {
            EngineResourceGenerationEvaluation engineResourceGenerationEvaluation = this.cached;
            EngineResourceGenerationEvaluation.Ready ready = engineResourceGenerationEvaluation instanceof EngineResourceGenerationEvaluation.Ready ? (EngineResourceGenerationEvaluation.Ready) engineResourceGenerationEvaluation : null;
            if (ready == null) {
                return;
            }
            if (ready.getTarget() != j) {
                return;
            }
            this.cached = EngineResourceGenerationEvaluation.Ready.copy$default(ready, 0L, 0L, EngineResourceGenerationStoreKt.engineResourceGenerationAction(ready.getTarget(), j, j), j, j, true, 3, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final EngineResourceGenerationEvaluation evaluate(long j) {
        EngineResourceGenerationLoadResult load = this.store.load();
        if (load instanceof EngineResourceGenerationLoadResult.Corrupt) {
            return new EngineResourceGenerationEvaluation.Corrupt(j, ((EngineResourceGenerationLoadResult.Corrupt) load).getReason());
        }
        if (Intrinsics.areEqual(load, EngineResourceGenerationLoadResult.Missing.INSTANCE)) {
            return readyEvaluation(j, 0L, 0L, false);
        }
        if (!(load instanceof EngineResourceGenerationLoadResult.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        EngineResourceGenerationLoadResult.Loaded loaded = (EngineResourceGenerationLoadResult.Loaded) load;
        return readyEvaluation(j, loaded.getState().getPreparedGeneration(), loaded.getState().getCompletedGeneration(), true);
    }

    private final EngineResourceGenerationEvaluation.Ready readyEvaluation(long j, long j2, long j3, boolean z) {
        long engineResourceGenerationTarget = EngineResourceGenerationStoreKt.engineResourceGenerationTarget(this.remoteGeneration.invoke().longValue(), j2, j3);
        return new EngineResourceGenerationEvaluation.Ready(j, engineResourceGenerationTarget, EngineResourceGenerationStoreKt.engineResourceGenerationAction(engineResourceGenerationTarget, j2, j3), j2, j3, z);
    }
}
