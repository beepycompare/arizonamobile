package com.arizona.launcher.updater.archive.orchestrator;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveContentCollisionGuard.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0000¨\u0006!"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", "", "kind", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;", TtmlNode.RUBY_BASE, "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "vice", "baseSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;", "viceSource", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;)V", "getKind", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;", "getBase", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "getVice", "getBaseSource", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;", "getViceSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveContentCollision {
    public static final int $stable = ArchiveOwnedPath.$stable | ArchiveOwnedPath.$stable;
    private final ArchiveOwnedPath base;
    private final ArchiveContentOwnershipSource baseSource;
    private final ArchiveContentCollisionKind kind;
    private final ArchiveOwnedPath vice;
    private final ArchiveContentOwnershipSource viceSource;

    public static /* synthetic */ ArchiveContentCollision copy$default(ArchiveContentCollision archiveContentCollision, ArchiveContentCollisionKind archiveContentCollisionKind, ArchiveOwnedPath archiveOwnedPath, ArchiveOwnedPath archiveOwnedPath2, ArchiveContentOwnershipSource archiveContentOwnershipSource, ArchiveContentOwnershipSource archiveContentOwnershipSource2, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveContentCollisionKind = archiveContentCollision.kind;
        }
        if ((i & 2) != 0) {
            archiveOwnedPath = archiveContentCollision.base;
        }
        if ((i & 4) != 0) {
            archiveOwnedPath2 = archiveContentCollision.vice;
        }
        if ((i & 8) != 0) {
            archiveContentOwnershipSource = archiveContentCollision.baseSource;
        }
        if ((i & 16) != 0) {
            archiveContentOwnershipSource2 = archiveContentCollision.viceSource;
        }
        ArchiveContentOwnershipSource archiveContentOwnershipSource3 = archiveContentOwnershipSource2;
        ArchiveOwnedPath archiveOwnedPath3 = archiveOwnedPath2;
        return archiveContentCollision.copy(archiveContentCollisionKind, archiveOwnedPath, archiveOwnedPath3, archiveContentOwnershipSource, archiveContentOwnershipSource3);
    }

    public final ArchiveContentCollisionKind component1() {
        return this.kind;
    }

    public final ArchiveOwnedPath component2() {
        return this.base;
    }

    public final ArchiveOwnedPath component3() {
        return this.vice;
    }

    public final ArchiveContentOwnershipSource component4() {
        return this.baseSource;
    }

    public final ArchiveContentOwnershipSource component5() {
        return this.viceSource;
    }

    public final ArchiveContentCollision copy(ArchiveContentCollisionKind kind, ArchiveOwnedPath base, ArchiveOwnedPath vice, ArchiveContentOwnershipSource baseSource, ArchiveContentOwnershipSource viceSource) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(vice, "vice");
        Intrinsics.checkNotNullParameter(baseSource, "baseSource");
        Intrinsics.checkNotNullParameter(viceSource, "viceSource");
        return new ArchiveContentCollision(kind, base, vice, baseSource, viceSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveContentCollision) {
            ArchiveContentCollision archiveContentCollision = (ArchiveContentCollision) obj;
            return this.kind == archiveContentCollision.kind && Intrinsics.areEqual(this.base, archiveContentCollision.base) && Intrinsics.areEqual(this.vice, archiveContentCollision.vice) && this.baseSource == archiveContentCollision.baseSource && this.viceSource == archiveContentCollision.viceSource;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.kind.hashCode() * 31) + this.base.hashCode()) * 31) + this.vice.hashCode()) * 31) + this.baseSource.hashCode()) * 31) + this.viceSource.hashCode();
    }

    public String toString() {
        ArchiveContentCollisionKind archiveContentCollisionKind = this.kind;
        ArchiveOwnedPath archiveOwnedPath = this.base;
        ArchiveOwnedPath archiveOwnedPath2 = this.vice;
        ArchiveContentOwnershipSource archiveContentOwnershipSource = this.baseSource;
        return "ArchiveContentCollision(kind=" + archiveContentCollisionKind + ", base=" + archiveOwnedPath + ", vice=" + archiveOwnedPath2 + ", baseSource=" + archiveContentOwnershipSource + ", viceSource=" + this.viceSource + ")";
    }

    public ArchiveContentCollision(ArchiveContentCollisionKind kind, ArchiveOwnedPath base, ArchiveOwnedPath vice, ArchiveContentOwnershipSource baseSource, ArchiveContentOwnershipSource viceSource) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(vice, "vice");
        Intrinsics.checkNotNullParameter(baseSource, "baseSource");
        Intrinsics.checkNotNullParameter(viceSource, "viceSource");
        this.kind = kind;
        this.base = base;
        this.vice = vice;
        this.baseSource = baseSource;
        this.viceSource = viceSource;
    }

    public final ArchiveContentCollisionKind getKind() {
        return this.kind;
    }

    public final ArchiveOwnedPath getBase() {
        return this.base;
    }

    public final ArchiveOwnedPath getVice() {
        return this.vice;
    }

    public final ArchiveContentOwnershipSource getBaseSource() {
        return this.baseSource;
    }

    public final ArchiveContentOwnershipSource getViceSource() {
        return this.viceSource;
    }
}
