package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStartupGuard.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuardPolicy;", "", "<init>", "()V", "decide", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "transactionActive", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStartupGuardPolicy {
    public static final int $stable = 0;
    public static final ArchiveStartupGuardPolicy INSTANCE = new ArchiveStartupGuardPolicy();

    private ArchiveStartupGuardPolicy() {
    }

    public final ArchiveStartupGuard decide(ArchiveStateLoadResult state, boolean z) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (z) {
            return ArchiveStartupGuard.RECOVERY_REQUIRED;
        }
        if (state instanceof ArchiveStateLoadResult.Corrupt) {
            return ArchiveStartupGuard.CORRUPT_STATE;
        }
        if ((state instanceof ArchiveStateLoadResult.Loaded) && !((ArchiveStateLoadResult.Loaded) state).getState().isInstallReady()) {
            return ArchiveStartupGuard.RECOVERY_REQUIRED;
        }
        return ArchiveStartupGuard.RECOVERY_REQUIRED;
    }
}
