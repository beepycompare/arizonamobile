package com.arizona.launcher.updater.archive.transaction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveOwnershipDiff.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipTransition;", "", "previous", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "desired", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;)V", "getPrevious", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "getDesired", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnershipTransition {
    public static final int $stable = 0;
    private final ArchiveOwnedPath desired;
    private final ArchiveOwnedPath previous;

    public static /* synthetic */ ArchiveOwnershipTransition copy$default(ArchiveOwnershipTransition archiveOwnershipTransition, ArchiveOwnedPath archiveOwnedPath, ArchiveOwnedPath archiveOwnedPath2, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveOwnedPath = archiveOwnershipTransition.previous;
        }
        if ((i & 2) != 0) {
            archiveOwnedPath2 = archiveOwnershipTransition.desired;
        }
        return archiveOwnershipTransition.copy(archiveOwnedPath, archiveOwnedPath2);
    }

    public final ArchiveOwnedPath component1() {
        return this.previous;
    }

    public final ArchiveOwnedPath component2() {
        return this.desired;
    }

    public final ArchiveOwnershipTransition copy(ArchiveOwnedPath previous, ArchiveOwnedPath desired) {
        Intrinsics.checkNotNullParameter(previous, "previous");
        Intrinsics.checkNotNullParameter(desired, "desired");
        return new ArchiveOwnershipTransition(previous, desired);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveOwnershipTransition) {
            ArchiveOwnershipTransition archiveOwnershipTransition = (ArchiveOwnershipTransition) obj;
            return Intrinsics.areEqual(this.previous, archiveOwnershipTransition.previous) && Intrinsics.areEqual(this.desired, archiveOwnershipTransition.desired);
        }
        return false;
    }

    public int hashCode() {
        return (this.previous.hashCode() * 31) + this.desired.hashCode();
    }

    public String toString() {
        ArchiveOwnedPath archiveOwnedPath = this.previous;
        return "ArchiveOwnershipTransition(previous=" + archiveOwnedPath + ", desired=" + this.desired + ")";
    }

    public ArchiveOwnershipTransition(ArchiveOwnedPath previous, ArchiveOwnedPath desired) {
        Intrinsics.checkNotNullParameter(previous, "previous");
        Intrinsics.checkNotNullParameter(desired, "desired");
        this.previous = previous;
        this.desired = desired;
    }

    public final ArchiveOwnedPath getPrevious() {
        return this.previous;
    }

    public final ArchiveOwnedPath getDesired() {
        return this.desired;
    }
}
