package com.arizona.launcher.updater.archive.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveRecoveryPlanner.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rÊ\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveRecoveryPlanner;", "", "<init>", "()V", "actionFor", "Lcom/arizona/launcher/updater/archive/state/PackageRecoveryAction;", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "entry", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "plan", "Lcom/arizona/launcher/updater/archive/state/ArchiveRecoveryPlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRecoveryPlanner {
    public static final int $stable = 0;
    public static final ArchiveRecoveryPlanner INSTANCE = new ArchiveRecoveryPlanner();

    /* compiled from: ArchiveRecoveryPlanner.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchivePackagePhase.values().length];
            try {
                iArr[ArchivePackagePhase.PLANNED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchivePackagePhase.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchivePackagePhase.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchivePackagePhase.VERIFYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchivePackagePhase.VERIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ArchivePackagePhase.EXTRACTING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ArchivePackagePhase.EXTRACTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ArchivePackagePhase.COMMITTING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ArchivePackagePhase.COMMITTED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ArchiveRecoveryPlanner() {
    }

    public final PackageRecoveryAction actionFor(ArchivePackagePhase phase) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        switch (WhenMappings.$EnumSwitchMapping$0[phase.ordinal()]) {
            case 1:
                return PackageRecoveryAction.START_DOWNLOAD;
            case 2:
                return PackageRecoveryAction.CONTINUE_DOWNLOAD;
            case 3:
            case 4:
                return PackageRecoveryAction.REVERIFY_ARCHIVE;
            case 5:
            case 6:
                return PackageRecoveryAction.DISCARD_AND_REEXTRACT;
            case 7:
                return PackageRecoveryAction.BEGIN_COMMIT;
            case 8:
                return PackageRecoveryAction.REAPPLY_DIRTY_COMMIT;
            case 9:
                return PackageRecoveryAction.SKIP_COMPLETE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final PackageRecoveryAction actionFor(ArchivePackageJournalEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return actionFor(entry.getPhase());
    }

    public final ArchiveRecoveryPlan plan(ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ArchiveStateValidation.INSTANCE.requireValidState(state);
        List<ArchivePackageJournalEntry> packages = state.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
            arrayList.add(new PackageRecoveryDecision(archivePackageJournalEntry, INSTANCE.actionFor(archivePackageJournalEntry)));
        }
        return new ArchiveRecoveryPlan(state, arrayList);
    }
}
