package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "", "decision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "viceDecision", "viceContentAvailable", "", "markViceCommitted", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;Ljava/lang/Boolean;Z)V", "getDecision", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "getViceDecision", "getViceContentAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarkViceCommitted", "()Z", "component1", "component2", "component3", "component4", "copy", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;Ljava/lang/Boolean;Z)Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneUpdateCheckResult;", "equals", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneUpdateCheckResult {
    public static final int $stable = 0;
    private final ArchiveUpdateCheckDecision decision;
    private final boolean markViceCommitted;
    private final Boolean viceContentAvailable;
    private final ArchiveUpdateCheckDecision viceDecision;

    public static /* synthetic */ ArchiveCrossLaneUpdateCheckResult copy$default(ArchiveCrossLaneUpdateCheckResult archiveCrossLaneUpdateCheckResult, ArchiveUpdateCheckDecision archiveUpdateCheckDecision, ArchiveUpdateCheckDecision archiveUpdateCheckDecision2, Boolean bool, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveUpdateCheckDecision = archiveCrossLaneUpdateCheckResult.decision;
        }
        if ((i & 2) != 0) {
            archiveUpdateCheckDecision2 = archiveCrossLaneUpdateCheckResult.viceDecision;
        }
        if ((i & 4) != 0) {
            bool = archiveCrossLaneUpdateCheckResult.viceContentAvailable;
        }
        if ((i & 8) != 0) {
            z = archiveCrossLaneUpdateCheckResult.markViceCommitted;
        }
        return archiveCrossLaneUpdateCheckResult.copy(archiveUpdateCheckDecision, archiveUpdateCheckDecision2, bool, z);
    }

    public final ArchiveUpdateCheckDecision component1() {
        return this.decision;
    }

    public final ArchiveUpdateCheckDecision component2() {
        return this.viceDecision;
    }

    public final Boolean component3() {
        return this.viceContentAvailable;
    }

    public final boolean component4() {
        return this.markViceCommitted;
    }

    public final ArchiveCrossLaneUpdateCheckResult copy(ArchiveUpdateCheckDecision decision, ArchiveUpdateCheckDecision archiveUpdateCheckDecision, Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(decision, "decision");
        return new ArchiveCrossLaneUpdateCheckResult(decision, archiveUpdateCheckDecision, bool, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveCrossLaneUpdateCheckResult) {
            ArchiveCrossLaneUpdateCheckResult archiveCrossLaneUpdateCheckResult = (ArchiveCrossLaneUpdateCheckResult) obj;
            return Intrinsics.areEqual(this.decision, archiveCrossLaneUpdateCheckResult.decision) && Intrinsics.areEqual(this.viceDecision, archiveCrossLaneUpdateCheckResult.viceDecision) && Intrinsics.areEqual(this.viceContentAvailable, archiveCrossLaneUpdateCheckResult.viceContentAvailable) && this.markViceCommitted == archiveCrossLaneUpdateCheckResult.markViceCommitted;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.decision.hashCode() * 31;
        ArchiveUpdateCheckDecision archiveUpdateCheckDecision = this.viceDecision;
        int hashCode2 = (hashCode + (archiveUpdateCheckDecision == null ? 0 : archiveUpdateCheckDecision.hashCode())) * 31;
        Boolean bool = this.viceContentAvailable;
        return ((hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + Boolean.hashCode(this.markViceCommitted);
    }

    public String toString() {
        ArchiveUpdateCheckDecision archiveUpdateCheckDecision = this.decision;
        ArchiveUpdateCheckDecision archiveUpdateCheckDecision2 = this.viceDecision;
        Boolean bool = this.viceContentAvailable;
        return "ArchiveCrossLaneUpdateCheckResult(decision=" + archiveUpdateCheckDecision + ", viceDecision=" + archiveUpdateCheckDecision2 + ", viceContentAvailable=" + bool + ", markViceCommitted=" + this.markViceCommitted + ")";
    }

    public ArchiveCrossLaneUpdateCheckResult(ArchiveUpdateCheckDecision decision, ArchiveUpdateCheckDecision archiveUpdateCheckDecision, Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(decision, "decision");
        this.decision = decision;
        this.viceDecision = archiveUpdateCheckDecision;
        this.viceContentAvailable = bool;
        this.markViceCommitted = z;
    }

    public /* synthetic */ ArchiveCrossLaneUpdateCheckResult(ArchiveUpdateCheckDecision archiveUpdateCheckDecision, ArchiveUpdateCheckDecision archiveUpdateCheckDecision2, Boolean bool, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveUpdateCheckDecision, (i & 2) != 0 ? null : archiveUpdateCheckDecision2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? false : z);
    }

    public final ArchiveUpdateCheckDecision getDecision() {
        return this.decision;
    }

    public final ArchiveUpdateCheckDecision getViceDecision() {
        return this.viceDecision;
    }

    public final Boolean getViceContentAvailable() {
        return this.viceContentAvailable;
    }

    public final boolean getMarkViceCommitted() {
        return this.markViceCommitted;
    }
}
