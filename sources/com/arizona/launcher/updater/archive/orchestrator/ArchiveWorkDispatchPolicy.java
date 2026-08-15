package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.planner.ArchivePlanType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveWorkDispatchPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveWorkDispatchPolicy;", "", "<init>", "()V", "hasPendingWork", "", "planType", "Lcom/arizona/launcher/updater/archive/planner/ArchivePlanType;", "requiresFinalization", "isFinalizationOnly", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveWorkDispatchPolicy {
    public static final int $stable = 0;
    public static final ArchiveWorkDispatchPolicy INSTANCE = new ArchiveWorkDispatchPolicy();

    private ArchiveWorkDispatchPolicy() {
    }

    public final boolean hasPendingWork(ArchivePlanType archivePlanType, boolean z) {
        if (z) {
            return true;
        }
        return (archivePlanType == null || archivePlanType == ArchivePlanType.SKIP) ? false : true;
    }

    public final boolean isFinalizationOnly(ArchivePlanType planType, boolean z) {
        Intrinsics.checkNotNullParameter(planType, "planType");
        return planType == ArchivePlanType.SKIP && z;
    }
}
