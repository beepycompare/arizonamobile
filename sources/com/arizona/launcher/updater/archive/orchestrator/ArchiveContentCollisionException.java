package com.arizona.launcher.updater.archive.orchestrator;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveContentCollisionGuard.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "collisions", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", "<init>", "(Ljava/util/List;)V", "getCollisions", "()Ljava/util/List;", "first", "getFirst", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveContentCollisionException extends IllegalArgumentException {
    public static final int $stable = 8;
    private final List<ArchiveContentCollision> collisions;

    public final List<ArchiveContentCollision> getCollisions() {
        return this.collisions;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArchiveContentCollisionException(List<ArchiveContentCollision> collisions) {
        super(r0);
        String buildCollisionMessage;
        Intrinsics.checkNotNullParameter(collisions, "collisions");
        buildCollisionMessage = ArchiveContentCollisionGuardKt.buildCollisionMessage(collisions);
        this.collisions = collisions;
    }

    public final ArchiveContentCollision getFirst() {
        return (ArchiveContentCollision) CollectionsKt.first((List<? extends Object>) this.collisions);
    }
}
