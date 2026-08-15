package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOADING", "WAITING_FOR_NETWORK", "VERIFYING", "EXTRACTING", "COMMITTING", "RETIRING", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveInstallerPhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveInstallerPhase[] $VALUES;
    public static final ArchiveInstallerPhase DOWNLOADING = new ArchiveInstallerPhase("DOWNLOADING", 0);
    public static final ArchiveInstallerPhase WAITING_FOR_NETWORK = new ArchiveInstallerPhase("WAITING_FOR_NETWORK", 1);
    public static final ArchiveInstallerPhase VERIFYING = new ArchiveInstallerPhase("VERIFYING", 2);
    public static final ArchiveInstallerPhase EXTRACTING = new ArchiveInstallerPhase("EXTRACTING", 3);
    public static final ArchiveInstallerPhase COMMITTING = new ArchiveInstallerPhase("COMMITTING", 4);
    public static final ArchiveInstallerPhase RETIRING = new ArchiveInstallerPhase("RETIRING", 5);

    private static final /* synthetic */ ArchiveInstallerPhase[] $values() {
        return new ArchiveInstallerPhase[]{DOWNLOADING, WAITING_FOR_NETWORK, VERIFYING, EXTRACTING, COMMITTING, RETIRING};
    }

    public static EnumEntries<ArchiveInstallerPhase> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveInstallerPhase valueOf(String str) {
        return (ArchiveInstallerPhase) Enum.valueOf(ArchiveInstallerPhase.class, str);
    }

    public static ArchiveInstallerPhase[] values() {
        return (ArchiveInstallerPhase[]) $VALUES.clone();
    }

    private ArchiveInstallerPhase(String str, int i) {
    }

    static {
        ArchiveInstallerPhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
