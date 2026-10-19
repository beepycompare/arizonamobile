package com.arizona.launcher.updater.archive.orchestrator;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveContentCollisionGuard.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\u0000J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionResult;", "", "collisions", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", "<init>", "(Ljava/util/List;)V", "getCollisions", "()Ljava/util/List;", "isValid", "", "()Z", "requireValid", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveContentCollisionResult {
    public static final int $stable = 8;
    private final List<ArchiveContentCollision> collisions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveContentCollisionResult copy$default(ArchiveContentCollisionResult archiveContentCollisionResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = archiveContentCollisionResult.collisions;
        }
        return archiveContentCollisionResult.copy(list);
    }

    public final List<ArchiveContentCollision> component1() {
        return this.collisions;
    }

    public final ArchiveContentCollisionResult copy(List<ArchiveContentCollision> collisions) {
        Intrinsics.checkNotNullParameter(collisions, "collisions");
        return new ArchiveContentCollisionResult(collisions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ArchiveContentCollisionResult) && Intrinsics.areEqual(this.collisions, ((ArchiveContentCollisionResult) obj).collisions);
    }

    public int hashCode() {
        return this.collisions.hashCode();
    }

    public String toString() {
        return "ArchiveContentCollisionResult(collisions=" + this.collisions + ")";
    }

    public ArchiveContentCollisionResult(List<ArchiveContentCollision> collisions) {
        Intrinsics.checkNotNullParameter(collisions, "collisions");
        this.collisions = collisions;
    }

    public final List<ArchiveContentCollision> getCollisions() {
        return this.collisions;
    }

    public final boolean isValid() {
        return this.collisions.isEmpty();
    }

    public final ArchiveContentCollisionResult requireValid() {
        if (isValid()) {
            return this;
        }
        throw new ArchiveContentCollisionException(this.collisions);
    }
}
