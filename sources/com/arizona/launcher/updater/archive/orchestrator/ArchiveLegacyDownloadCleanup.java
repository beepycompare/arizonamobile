package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.io.ArchiveNodeInspector;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: ArchiveLegacyDownloadCleanup.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveLegacyDownloadCleanup;", "", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;)V", "cleanup", "", "gameRoot", "Ljava/io/File;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveLegacyDownloadCleanup {
    private final ArchiveNodeInspector nodeInspector;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex ARCHIVE_ARTIFACT = new Regex("[A-Za-z0-9][A-Za-z0-9._-]{0,95}-[0-9a-f]{1,8}\\.zip\\.part(?:\\.arizona-resume(?:\\.tmp)?)?");

    /* compiled from: ArchiveLegacyDownloadCleanup.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveFsNodeType.values().length];
            try {
                iArr[ArchiveFsNodeType.ABSENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveFsNodeType.DIRECTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveFsNodeType.SYMBOLIC_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArchiveLegacyDownloadCleanup(ArchiveNodeInspector nodeInspector) {
        Intrinsics.checkNotNullParameter(nodeInspector, "nodeInspector");
        this.nodeInspector = nodeInspector;
    }

    public final void cleanup(File gameRoot) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        File parentFile = gameRoot.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"cache", "archive-updater", "downloads"})) {
            File file = new File(parentFile, str);
            int i = WhenMappings.$EnumSwitchMapping$0[this.nodeInspector.nodeType(file).ordinal()];
            if (i == 1) {
                return;
            }
            if (i != 2) {
                throw new IOException("Invalid legacy archive cache directory: " + file);
            }
            parentFile = file;
        }
        File[] listFiles = parentFile.listFiles();
        if (listFiles == null) {
            throw new IOException("Unable to list legacy archive cache: " + parentFile);
        }
        for (File file2 : listFiles) {
            Regex regex = ARCHIVE_ARTIFACT;
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (regex.matches(name)) {
                ArchiveNodeInspector archiveNodeInspector = this.nodeInspector;
                Intrinsics.checkNotNull(file2);
                int i2 = WhenMappings.$EnumSwitchMapping$0[archiveNodeInspector.nodeType(file2).ordinal()];
                if (i2 == 1) {
                    continue;
                } else if (i2 == 3 || i2 == 4) {
                    if (!file2.delete() && this.nodeInspector.nodeType(file2) != ArchiveFsNodeType.ABSENT) {
                        throw new IOException("Unable to delete legacy archive cache file: " + file2);
                    }
                } else {
                    throw new IOException("Invalid legacy archive cache file: " + file2);
                }
            }
        }
    }

    /* compiled from: ArchiveLegacyDownloadCleanup.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveLegacyDownloadCleanup$Companion;", "", "<init>", "()V", "ARCHIVE_ARTIFACT", "Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
