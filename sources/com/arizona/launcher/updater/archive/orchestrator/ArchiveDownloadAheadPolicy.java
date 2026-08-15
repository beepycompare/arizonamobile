package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadAheadPolicy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadAheadPolicy;", "", "canStart", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "nextPackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "Disabled", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveDownloadAheadPolicy {
    boolean canStart(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState, ArchivePackage archivePackage);

    /* compiled from: ArchiveDownloadAheadPolicy.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadAheadPolicy$Disabled;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadAheadPolicy;", "<init>", "()V", "canStart", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "nextPackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Disabled implements ArchiveDownloadAheadPolicy {
        public static final int $stable = 0;
        public static final Disabled INSTANCE = new Disabled();

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadAheadPolicy
        public boolean canStart(ArchiveUpdatePlan plan, ArchiveUpdaterState state, ArchivePackage nextPackage) {
            Intrinsics.checkNotNullParameter(plan, "plan");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(nextPackage, "nextPackage");
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Disabled) {
                Disabled disabled = (Disabled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1026557183;
        }

        public String toString() {
            return "Disabled";
        }

        private Disabled() {
        }
    }
}
