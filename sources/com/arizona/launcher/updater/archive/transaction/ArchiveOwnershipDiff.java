package com.arizona.launcher.updater.archive.transaction;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveOwnershipDiff.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipDiff;", "", ArchiveFileRetirement.TRASH_ROOT, "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "added", "retained", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipTransition;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getRetired", "()Ljava/util/List;", "getAdded", "getRetained", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnershipDiff {
    public static final int $stable = 0;
    private final List<ArchiveOwnedPath> added;
    private final List<ArchiveOwnershipTransition> retained;
    private final List<ArchiveOwnedPath> retired;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveOwnershipDiff copy$default(ArchiveOwnershipDiff archiveOwnershipDiff, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = archiveOwnershipDiff.retired;
        }
        if ((i & 2) != 0) {
            list2 = archiveOwnershipDiff.added;
        }
        if ((i & 4) != 0) {
            list3 = archiveOwnershipDiff.retained;
        }
        return archiveOwnershipDiff.copy(list, list2, list3);
    }

    public final List<ArchiveOwnedPath> component1() {
        return this.retired;
    }

    public final List<ArchiveOwnedPath> component2() {
        return this.added;
    }

    public final List<ArchiveOwnershipTransition> component3() {
        return this.retained;
    }

    public final ArchiveOwnershipDiff copy(List<ArchiveOwnedPath> retired, List<ArchiveOwnedPath> added, List<ArchiveOwnershipTransition> retained) {
        Intrinsics.checkNotNullParameter(retired, "retired");
        Intrinsics.checkNotNullParameter(added, "added");
        Intrinsics.checkNotNullParameter(retained, "retained");
        return new ArchiveOwnershipDiff(retired, added, retained);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveOwnershipDiff) {
            ArchiveOwnershipDiff archiveOwnershipDiff = (ArchiveOwnershipDiff) obj;
            return Intrinsics.areEqual(this.retired, archiveOwnershipDiff.retired) && Intrinsics.areEqual(this.added, archiveOwnershipDiff.added) && Intrinsics.areEqual(this.retained, archiveOwnershipDiff.retained);
        }
        return false;
    }

    public int hashCode() {
        return (((this.retired.hashCode() * 31) + this.added.hashCode()) * 31) + this.retained.hashCode();
    }

    public String toString() {
        List<ArchiveOwnedPath> list = this.retired;
        List<ArchiveOwnedPath> list2 = this.added;
        return "ArchiveOwnershipDiff(retired=" + list + ", added=" + list2 + ", retained=" + this.retained + ")";
    }

    public ArchiveOwnershipDiff(List<ArchiveOwnedPath> retired, List<ArchiveOwnedPath> added, List<ArchiveOwnershipTransition> retained) {
        Intrinsics.checkNotNullParameter(retired, "retired");
        Intrinsics.checkNotNullParameter(added, "added");
        Intrinsics.checkNotNullParameter(retained, "retained");
        this.retired = retired;
        this.added = added;
        this.retained = retained;
    }

    public final List<ArchiveOwnedPath> getRetired() {
        return this.retired;
    }

    public final List<ArchiveOwnedPath> getAdded() {
        return this.added;
    }

    public final List<ArchiveOwnershipTransition> getRetained() {
        return this.retained;
    }
}
