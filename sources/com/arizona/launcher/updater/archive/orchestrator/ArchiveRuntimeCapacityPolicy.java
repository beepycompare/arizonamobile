package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadAheadPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityPolicy;", "", "evaluate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "AssumeEnough", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveRuntimeCapacityPolicy {
    ArchiveRuntimeCapacityResult evaluate(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterState archiveUpdaterState);

    /* compiled from: ArchiveDownloadAheadPolicy.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityPolicy$AssumeEnough;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityPolicy;", "<init>", "()V", "evaluate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class AssumeEnough implements ArchiveRuntimeCapacityPolicy {
        public static final int $stable = 0;
        public static final AssumeEnough INSTANCE = new AssumeEnough();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AssumeEnough) {
                AssumeEnough assumeEnough = (AssumeEnough) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 791007624;
        }

        public String toString() {
            return "AssumeEnough";
        }

        private AssumeEnough() {
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityPolicy
        public ArchiveRuntimeCapacityResult evaluate(ArchiveUpdatePlan plan, ArchiveUpdaterState state) {
            Intrinsics.checkNotNullParameter(plan, "plan");
            Intrinsics.checkNotNullParameter(state, "state");
            return new ArchiveRuntimeCapacityResult.Sufficient(0L);
        }
    }
}
