package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "REMOTE_INDEX_UNAVAILABLE", "REMOTE_INDEX_INVALID", "REMOTE_REPRESENTATION_CHANGED", "PACKAGE_METADATA_INVALID", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolutionErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveManifestResolutionErrorCode[] $VALUES;
    public static final ArchiveManifestResolutionErrorCode REMOTE_INDEX_UNAVAILABLE = new ArchiveManifestResolutionErrorCode("REMOTE_INDEX_UNAVAILABLE", 0);
    public static final ArchiveManifestResolutionErrorCode REMOTE_INDEX_INVALID = new ArchiveManifestResolutionErrorCode("REMOTE_INDEX_INVALID", 1);
    public static final ArchiveManifestResolutionErrorCode REMOTE_REPRESENTATION_CHANGED = new ArchiveManifestResolutionErrorCode("REMOTE_REPRESENTATION_CHANGED", 2);
    public static final ArchiveManifestResolutionErrorCode PACKAGE_METADATA_INVALID = new ArchiveManifestResolutionErrorCode("PACKAGE_METADATA_INVALID", 3);

    private static final /* synthetic */ ArchiveManifestResolutionErrorCode[] $values() {
        return new ArchiveManifestResolutionErrorCode[]{REMOTE_INDEX_UNAVAILABLE, REMOTE_INDEX_INVALID, REMOTE_REPRESENTATION_CHANGED, PACKAGE_METADATA_INVALID};
    }

    public static EnumEntries<ArchiveManifestResolutionErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveManifestResolutionErrorCode valueOf(String str) {
        return (ArchiveManifestResolutionErrorCode) Enum.valueOf(ArchiveManifestResolutionErrorCode.class, str);
    }

    public static ArchiveManifestResolutionErrorCode[] values() {
        return (ArchiveManifestResolutionErrorCode[]) $VALUES.clone();
    }

    private ArchiveManifestResolutionErrorCode(String str, int i) {
    }

    static {
        ArchiveManifestResolutionErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
