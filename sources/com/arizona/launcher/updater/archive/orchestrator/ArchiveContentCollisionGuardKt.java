package com.arizona.launcher.updater.archive.orchestrator;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveContentCollisionGuard.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¨\u0006\u0005"}, d2 = {"buildCollisionMessage", "", "collisions", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveContentCollisionGuardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String buildCollisionMessage(List<ArchiveContentCollision> list) {
        if (list.isEmpty()) {
            return "Archive content lanes are disjoint";
        }
        ArchiveContentCollision archiveContentCollision = (ArchiveContentCollision) CollectionsKt.first((List<? extends Object>) list);
        ArchiveContentCollisionKind kind = archiveContentCollision.getKind();
        String relativePath = archiveContentCollision.getBase().getRelativePath();
        String relativePath2 = archiveContentCollision.getVice().getRelativePath();
        String lowerCase = archiveContentCollision.getBaseSource().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = archiveContentCollision.getViceSource().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return "BASE and VICE archive content paths collide (" + kind + ": '" + relativePath + "' vs '" + relativePath2 + "'; " + lowerCase + "/" + lowerCase2 + ")";
    }
}
