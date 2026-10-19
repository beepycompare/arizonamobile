package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EngineResourceGenerationController.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"engineResourceGenerationLanesReady", "", "baseStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "viceStore", "viceRequired", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceGenerationControllerKt {
    public static final boolean engineResourceGenerationLanesReady(DurableArchiveStateStore baseStore, DurableArchiveStateStore viceStore, boolean z) {
        ArchiveUpdaterState state;
        ArchiveUpdaterState state2;
        Intrinsics.checkNotNullParameter(baseStore, "baseStore");
        Intrinsics.checkNotNullParameter(viceStore, "viceStore");
        ArchiveStateLoadResult load = baseStore.load();
        ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
        if (loaded != null && (state = loaded.getState()) != null && state.isInstallReady()) {
            if (!z) {
                return true;
            }
            ArchiveStateLoadResult load2 = viceStore.load();
            ArchiveStateLoadResult.Loaded loaded2 = load2 instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load2 : null;
            if (loaded2 != null && (state2 = loaded2.getState()) != null && state2.isInstallReady()) {
                return true;
            }
        }
        return false;
    }
}
