package com.arizona.launcher.updater.archive.verify;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditMode;", "", "<init>", "(Ljava/lang/String;I)V", "METADATA_ONLY", "FULL_INTEGRITY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveInstalledPayloadAuditMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveInstalledPayloadAuditMode[] $VALUES;
    public static final ArchiveInstalledPayloadAuditMode METADATA_ONLY = new ArchiveInstalledPayloadAuditMode("METADATA_ONLY", 0);
    public static final ArchiveInstalledPayloadAuditMode FULL_INTEGRITY = new ArchiveInstalledPayloadAuditMode("FULL_INTEGRITY", 1);

    private static final /* synthetic */ ArchiveInstalledPayloadAuditMode[] $values() {
        return new ArchiveInstalledPayloadAuditMode[]{METADATA_ONLY, FULL_INTEGRITY};
    }

    public static EnumEntries<ArchiveInstalledPayloadAuditMode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveInstalledPayloadAuditMode valueOf(String str) {
        return (ArchiveInstalledPayloadAuditMode) Enum.valueOf(ArchiveInstalledPayloadAuditMode.class, str);
    }

    public static ArchiveInstalledPayloadAuditMode[] values() {
        return (ArchiveInstalledPayloadAuditMode[]) $VALUES.clone();
    }

    private ArchiveInstalledPayloadAuditMode(String str, int i) {
    }

    static {
        ArchiveInstalledPayloadAuditMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
