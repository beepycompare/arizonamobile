package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveLaneDownloadSequence.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveLaneDownloadSequence;", "", "<init>", "()V", "first", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "basePending", "", "vicePending", "afterSuccess", "completed", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveLaneDownloadSequence {
    public static final int $stable = 0;
    public static final ArchiveLaneDownloadSequence INSTANCE = new ArchiveLaneDownloadSequence();

    private ArchiveLaneDownloadSequence() {
    }

    public final ArchiveUpdaterStorageScope first(boolean z, boolean z2) {
        if (z) {
            return ArchiveUpdaterStorageScope.BASE;
        }
        if (z2) {
            return ArchiveUpdaterStorageScope.VICE;
        }
        return null;
    }

    public final ArchiveUpdaterStorageScope afterSuccess(ArchiveUpdaterStorageScope completed, boolean z) {
        Intrinsics.checkNotNullParameter(completed, "completed");
        if (completed == ArchiveUpdaterStorageScope.BASE && z) {
            return ArchiveUpdaterStorageScope.VICE;
        }
        return null;
    }
}
