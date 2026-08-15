package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveFlowSelector.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveFlowSelector;", "", "<init>", "()V", "select", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveFlowSelection;", "archiveManifestAvailable", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveFlowSelector {
    public static final int $stable = 0;
    public static final ArchiveFlowSelector INSTANCE = new ArchiveFlowSelector();

    private ArchiveFlowSelector() {
    }

    public final ArchiveFlowSelection select(boolean z, ArchiveStateLoadResult state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ArchiveStateLoadResult.Corrupt) {
            return ArchiveFlowSelection.BLOCK_CORRUPT_STATE;
        }
        if (state instanceof ArchiveStateLoadResult.Loaded) {
            if (!z) {
                return ArchiveFlowSelection.BLOCK_ARCHIVE_MANIFEST_REQUIRED;
            }
            return ArchiveFlowSelection.USE_ARCHIVE;
        } else if (Intrinsics.areEqual(state, ArchiveStateLoadResult.Missing.INSTANCE)) {
            if (!z) {
                return ArchiveFlowSelection.BLOCK_ARCHIVE_MANIFEST_REQUIRED;
            }
            return ArchiveFlowSelection.USE_ARCHIVE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
