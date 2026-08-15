package com.arizona.launcher.updater.archive.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateValidation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/IllegalArchivePhaseTransitionException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "packageId", "", "from", "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", TypedValues.TransitionType.S_TO, "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;)V", "getPackageId", "()Ljava/lang/String;", "getFrom", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "getTo", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IllegalArchivePhaseTransitionException extends IllegalStateException {
    public static final int $stable = 8;
    private final ArchivePackagePhase from;
    private final String packageId;
    private final ArchivePackagePhase to;

    public final String getPackageId() {
        return this.packageId;
    }

    public final ArchivePackagePhase getFrom() {
        return this.from;
    }

    public final ArchivePackagePhase getTo() {
        return this.to;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalArchivePhaseTransitionException(String packageId, ArchivePackagePhase from, ArchivePackagePhase to) {
        super("Illegal archive package phase transition for '" + packageId + "': " + from + " -> " + to);
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.packageId = packageId;
        this.from = from;
        this.to = to;
    }
}
