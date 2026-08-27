package com.arizona.launcher.updater.archive.range;

import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectiveEntryDiff.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveEntryChangePlan;", "", "reusable", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "toFetch", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getReusable", "()Ljava/util/List;", "getToFetch", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveEntryChangePlan {
    public static final int $stable = 0;
    private final List<ArchivePackageFileRecord> reusable;
    private final List<ArchivePackageFileRecord> toFetch;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveEntryChangePlan copy$default(ArchiveEntryChangePlan archiveEntryChangePlan, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = archiveEntryChangePlan.reusable;
        }
        if ((i & 2) != 0) {
            list2 = archiveEntryChangePlan.toFetch;
        }
        return archiveEntryChangePlan.copy(list, list2);
    }

    public final List<ArchivePackageFileRecord> component1() {
        return this.reusable;
    }

    public final List<ArchivePackageFileRecord> component2() {
        return this.toFetch;
    }

    public final ArchiveEntryChangePlan copy(List<ArchivePackageFileRecord> reusable, List<ArchivePackageFileRecord> toFetch) {
        Intrinsics.checkNotNullParameter(reusable, "reusable");
        Intrinsics.checkNotNullParameter(toFetch, "toFetch");
        return new ArchiveEntryChangePlan(reusable, toFetch);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveEntryChangePlan) {
            ArchiveEntryChangePlan archiveEntryChangePlan = (ArchiveEntryChangePlan) obj;
            return Intrinsics.areEqual(this.reusable, archiveEntryChangePlan.reusable) && Intrinsics.areEqual(this.toFetch, archiveEntryChangePlan.toFetch);
        }
        return false;
    }

    public int hashCode() {
        return (this.reusable.hashCode() * 31) + this.toFetch.hashCode();
    }

    public String toString() {
        List<ArchivePackageFileRecord> list = this.reusable;
        return "ArchiveEntryChangePlan(reusable=" + list + ", toFetch=" + this.toFetch + ")";
    }

    public ArchiveEntryChangePlan(List<ArchivePackageFileRecord> reusable, List<ArchivePackageFileRecord> toFetch) {
        Intrinsics.checkNotNullParameter(reusable, "reusable");
        Intrinsics.checkNotNullParameter(toFetch, "toFetch");
        this.reusable = reusable;
        this.toFetch = toFetch;
    }

    public final List<ArchivePackageFileRecord> getReusable() {
        return this.reusable;
    }

    public final List<ArchivePackageFileRecord> getToFetch() {
        return this.toFetch;
    }
}
