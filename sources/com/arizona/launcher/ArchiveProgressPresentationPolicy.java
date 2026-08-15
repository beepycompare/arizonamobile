package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveInstallerPhase;
import kotlin.Metadata;
/* compiled from: ArchiveProgressPresentation.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bÊ\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/ArchiveProgressPresentationPolicy;", "", "<init>", "()V", "selectInstallerPhase", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "installerPhase", "hasPendingDownload", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveProgressPresentationPolicy {
    public static final int $stable = 0;
    public static final ArchiveProgressPresentationPolicy INSTANCE = new ArchiveProgressPresentationPolicy();

    private ArchiveProgressPresentationPolicy() {
    }

    public final ArchiveInstallerPhase selectInstallerPhase(ArchiveInstallerPhase archiveInstallerPhase, boolean z) {
        return (archiveInstallerPhase != ArchiveInstallerPhase.WAITING_FOR_NETWORK && z) ? ArchiveInstallerPhase.DOWNLOADING : archiveInstallerPhase;
    }
}
