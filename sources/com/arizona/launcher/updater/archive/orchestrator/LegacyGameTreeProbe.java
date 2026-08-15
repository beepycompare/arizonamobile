package com.arizona.launcher.updater.archive.orchestrator;

import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: LegacyGameTreeProbe.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/LegacyGameTreeProbe;", "", "<init>", "()V", "ignoredRootNames", "", "", "isEmptyForArchiveBootstrap", "", "gameRoot", "Ljava/io/File;", "isLegacyManifestBackup", "name", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LegacyGameTreeProbe {
    public static final int $stable = 0;
    public static final LegacyGameTreeProbe INSTANCE = new LegacyGameTreeProbe();
    private static final Set<String> ignoredRootNames = SetsKt.setOf((Object[]) new String[]{"settings.json", "local_manifest.json", "logcat", "recent-log-share", ".archive-installing"});

    private LegacyGameTreeProbe() {
    }

    public final boolean isEmptyForArchiveBootstrap(File gameRoot) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        if (gameRoot.exists()) {
            if (gameRoot.isDirectory() && (listFiles = gameRoot.listFiles()) != null) {
                for (File file : listFiles) {
                    if (!ignoredRootNames.contains(file.getName())) {
                        LegacyGameTreeProbe legacyGameTreeProbe = INSTANCE;
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (!legacyGameTreeProbe.isLegacyManifestBackup(name)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private final boolean isLegacyManifestBackup(String str) {
        return StringsKt.startsWith$default(str, "local_manifest.bak_", false, 2, (Object) null) && StringsKt.endsWith$default(str, ".json", false, 2, (Object) null);
    }
}
