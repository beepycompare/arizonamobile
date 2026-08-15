package com.arizona.launcher.updater.archive.state;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PackageRecoveryAction.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveRecoveryPlan;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "packageDecisions", "", "Lcom/arizona/launcher/updater/archive/state/PackageRecoveryDecision;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Ljava/util/List;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "getPackageDecisions", "()Ljava/util/List;", "isInstallReady", "", "()Z", "decisionFor", "packageId", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRecoveryPlan {
    public static final int $stable = ArchiveUpdaterState.$stable;
    private final List<PackageRecoveryDecision> packageDecisions;
    private final ArchiveUpdaterState state;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveRecoveryPlan copy$default(ArchiveRecoveryPlan archiveRecoveryPlan, ArchiveUpdaterState archiveUpdaterState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveUpdaterState = archiveRecoveryPlan.state;
        }
        if ((i & 2) != 0) {
            list = archiveRecoveryPlan.packageDecisions;
        }
        return archiveRecoveryPlan.copy(archiveUpdaterState, list);
    }

    public final ArchiveUpdaterState component1() {
        return this.state;
    }

    public final List<PackageRecoveryDecision> component2() {
        return this.packageDecisions;
    }

    public final ArchiveRecoveryPlan copy(ArchiveUpdaterState state, List<PackageRecoveryDecision> packageDecisions) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(packageDecisions, "packageDecisions");
        return new ArchiveRecoveryPlan(state, packageDecisions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveRecoveryPlan) {
            ArchiveRecoveryPlan archiveRecoveryPlan = (ArchiveRecoveryPlan) obj;
            return Intrinsics.areEqual(this.state, archiveRecoveryPlan.state) && Intrinsics.areEqual(this.packageDecisions, archiveRecoveryPlan.packageDecisions);
        }
        return false;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + this.packageDecisions.hashCode();
    }

    public String toString() {
        ArchiveUpdaterState archiveUpdaterState = this.state;
        return "ArchiveRecoveryPlan(state=" + archiveUpdaterState + ", packageDecisions=" + this.packageDecisions + ")";
    }

    public ArchiveRecoveryPlan(ArchiveUpdaterState state, List<PackageRecoveryDecision> packageDecisions) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(packageDecisions, "packageDecisions");
        this.state = state;
        this.packageDecisions = packageDecisions;
    }

    public final ArchiveUpdaterState getState() {
        return this.state;
    }

    public final List<PackageRecoveryDecision> getPackageDecisions() {
        return this.packageDecisions;
    }

    public final boolean isInstallReady() {
        return this.state.isInstallReady();
    }

    public final PackageRecoveryDecision decisionFor(String packageId) {
        Object obj;
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Iterator<T> it = this.packageDecisions.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PackageRecoveryDecision) obj).getEntry().getPackageId(), packageId)) {
                break;
            }
        }
        return (PackageRecoveryDecision) obj;
    }
}
