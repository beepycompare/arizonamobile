package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditUnavailableReason;", "", "<init>", "(Ljava/lang/String;I)V", "GAME_ROOT_MISSING", "STATE_NOT_LOADED", "INSTALL_NOT_READY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePayloadAuditUnavailableReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePayloadAuditUnavailableReason[] $VALUES;
    public static final ArchivePayloadAuditUnavailableReason GAME_ROOT_MISSING = new ArchivePayloadAuditUnavailableReason("GAME_ROOT_MISSING", 0);
    public static final ArchivePayloadAuditUnavailableReason STATE_NOT_LOADED = new ArchivePayloadAuditUnavailableReason("STATE_NOT_LOADED", 1);
    public static final ArchivePayloadAuditUnavailableReason INSTALL_NOT_READY = new ArchivePayloadAuditUnavailableReason("INSTALL_NOT_READY", 2);

    private static final /* synthetic */ ArchivePayloadAuditUnavailableReason[] $values() {
        return new ArchivePayloadAuditUnavailableReason[]{GAME_ROOT_MISSING, STATE_NOT_LOADED, INSTALL_NOT_READY};
    }

    public static EnumEntries<ArchivePayloadAuditUnavailableReason> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePayloadAuditUnavailableReason valueOf(String str) {
        return (ArchivePayloadAuditUnavailableReason) Enum.valueOf(ArchivePayloadAuditUnavailableReason.class, str);
    }

    public static ArchivePayloadAuditUnavailableReason[] values() {
        return (ArchivePayloadAuditUnavailableReason[]) $VALUES.clone();
    }

    private ArchivePayloadAuditUnavailableReason(String str, int i) {
    }

    static {
        ArchivePayloadAuditUnavailableReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
