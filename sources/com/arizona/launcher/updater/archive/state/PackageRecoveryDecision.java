package com.arizona.launcher.updater.archive.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PackageRecoveryAction.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/PackageRecoveryDecision;", "", "entry", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "action", "Lcom/arizona/launcher/updater/archive/state/PackageRecoveryAction;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;Lcom/arizona/launcher/updater/archive/state/PackageRecoveryAction;)V", "getEntry", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "getAction", "()Lcom/arizona/launcher/updater/archive/state/PackageRecoveryAction;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PackageRecoveryDecision {
    public static final int $stable = ArchivePackageJournalEntry.$stable;
    private final PackageRecoveryAction action;
    private final ArchivePackageJournalEntry entry;

    public static /* synthetic */ PackageRecoveryDecision copy$default(PackageRecoveryDecision packageRecoveryDecision, ArchivePackageJournalEntry archivePackageJournalEntry, PackageRecoveryAction packageRecoveryAction, int i, Object obj) {
        if ((i & 1) != 0) {
            archivePackageJournalEntry = packageRecoveryDecision.entry;
        }
        if ((i & 2) != 0) {
            packageRecoveryAction = packageRecoveryDecision.action;
        }
        return packageRecoveryDecision.copy(archivePackageJournalEntry, packageRecoveryAction);
    }

    public final ArchivePackageJournalEntry component1() {
        return this.entry;
    }

    public final PackageRecoveryAction component2() {
        return this.action;
    }

    public final PackageRecoveryDecision copy(ArchivePackageJournalEntry entry, PackageRecoveryAction action) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PackageRecoveryDecision(entry, action);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageRecoveryDecision) {
            PackageRecoveryDecision packageRecoveryDecision = (PackageRecoveryDecision) obj;
            return Intrinsics.areEqual(this.entry, packageRecoveryDecision.entry) && this.action == packageRecoveryDecision.action;
        }
        return false;
    }

    public int hashCode() {
        return (this.entry.hashCode() * 31) + this.action.hashCode();
    }

    public String toString() {
        ArchivePackageJournalEntry archivePackageJournalEntry = this.entry;
        return "PackageRecoveryDecision(entry=" + archivePackageJournalEntry + ", action=" + this.action + ")";
    }

    public PackageRecoveryDecision(ArchivePackageJournalEntry entry, PackageRecoveryAction action) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(action, "action");
        this.entry = entry;
        this.action = action;
    }

    public final ArchivePackageJournalEntry getEntry() {
        return this.entry;
    }

    public final PackageRecoveryAction getAction() {
        return this.action;
    }
}
