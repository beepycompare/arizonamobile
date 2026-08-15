package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupInspection;", "", "guard", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "corruptReason", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;Ljava/lang/String;)V", "getGuard", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "getCorruptReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStartupInspection {
    public static final int $stable = 0;
    private final String corruptReason;
    private final ArchiveStartupGuard guard;

    public static /* synthetic */ ArchiveStartupInspection copy$default(ArchiveStartupInspection archiveStartupInspection, ArchiveStartupGuard archiveStartupGuard, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveStartupGuard = archiveStartupInspection.guard;
        }
        if ((i & 2) != 0) {
            str = archiveStartupInspection.corruptReason;
        }
        return archiveStartupInspection.copy(archiveStartupGuard, str);
    }

    public final ArchiveStartupGuard component1() {
        return this.guard;
    }

    public final String component2() {
        return this.corruptReason;
    }

    public final ArchiveStartupInspection copy(ArchiveStartupGuard guard, String str) {
        Intrinsics.checkNotNullParameter(guard, "guard");
        return new ArchiveStartupInspection(guard, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveStartupInspection) {
            ArchiveStartupInspection archiveStartupInspection = (ArchiveStartupInspection) obj;
            return this.guard == archiveStartupInspection.guard && Intrinsics.areEqual(this.corruptReason, archiveStartupInspection.corruptReason);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.guard.hashCode() * 31;
        String str = this.corruptReason;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        ArchiveStartupGuard archiveStartupGuard = this.guard;
        return "ArchiveStartupInspection(guard=" + archiveStartupGuard + ", corruptReason=" + this.corruptReason + ")";
    }

    public ArchiveStartupInspection(ArchiveStartupGuard guard, String str) {
        Intrinsics.checkNotNullParameter(guard, "guard");
        this.guard = guard;
        this.corruptReason = str;
    }

    public final ArchiveStartupGuard getGuard() {
        return this.guard;
    }

    public final String getCorruptReason() {
        return this.corruptReason;
    }
}
