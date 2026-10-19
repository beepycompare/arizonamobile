package com.arizona.launcher.updater.archive.orchestrator;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneOwnershipHandoff.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneHandoffDecision;", "", "transfers", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneTransfer;", "collisions", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getTransfers", "()Ljava/util/List;", "getCollisions", "isValid", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneHandoffDecision {
    public static final int $stable = 0;
    private final List<ArchiveContentCollision> collisions;
    private final List<ArchiveCrossLaneTransfer> transfers;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveCrossLaneHandoffDecision copy$default(ArchiveCrossLaneHandoffDecision archiveCrossLaneHandoffDecision, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = archiveCrossLaneHandoffDecision.transfers;
        }
        if ((i & 2) != 0) {
            list2 = archiveCrossLaneHandoffDecision.collisions;
        }
        return archiveCrossLaneHandoffDecision.copy(list, list2);
    }

    public final List<ArchiveCrossLaneTransfer> component1() {
        return this.transfers;
    }

    public final List<ArchiveContentCollision> component2() {
        return this.collisions;
    }

    public final ArchiveCrossLaneHandoffDecision copy(List<ArchiveCrossLaneTransfer> transfers, List<ArchiveContentCollision> collisions) {
        Intrinsics.checkNotNullParameter(transfers, "transfers");
        Intrinsics.checkNotNullParameter(collisions, "collisions");
        return new ArchiveCrossLaneHandoffDecision(transfers, collisions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveCrossLaneHandoffDecision) {
            ArchiveCrossLaneHandoffDecision archiveCrossLaneHandoffDecision = (ArchiveCrossLaneHandoffDecision) obj;
            return Intrinsics.areEqual(this.transfers, archiveCrossLaneHandoffDecision.transfers) && Intrinsics.areEqual(this.collisions, archiveCrossLaneHandoffDecision.collisions);
        }
        return false;
    }

    public int hashCode() {
        return (this.transfers.hashCode() * 31) + this.collisions.hashCode();
    }

    public String toString() {
        List<ArchiveCrossLaneTransfer> list = this.transfers;
        return "ArchiveCrossLaneHandoffDecision(transfers=" + list + ", collisions=" + this.collisions + ")";
    }

    public ArchiveCrossLaneHandoffDecision(List<ArchiveCrossLaneTransfer> transfers, List<ArchiveContentCollision> collisions) {
        Intrinsics.checkNotNullParameter(transfers, "transfers");
        Intrinsics.checkNotNullParameter(collisions, "collisions");
        this.transfers = transfers;
        this.collisions = collisions;
    }

    public final List<ArchiveCrossLaneTransfer> getTransfers() {
        return this.transfers;
    }

    public final List<ArchiveContentCollision> getCollisions() {
        return this.collisions;
    }

    public final boolean isValid() {
        return this.collisions.isEmpty();
    }
}
