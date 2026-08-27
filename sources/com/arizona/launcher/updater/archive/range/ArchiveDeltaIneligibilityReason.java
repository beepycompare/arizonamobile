package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/ArchiveDeltaIneligibilityReason;", "", "<init>", "(Ljava/lang/String;I)V", "MISSING_OBSERVED_STRONG_ETAG", "MISSING_PUBLISHED_REPRESENTATION_BINDING", "PUBLISHED_ETAG_MISMATCH", "CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE", "PUBLISHED_CENTRAL_DIRECTORY_DIGEST_MISMATCH", "RESOLVED_CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE", "RESOLVED_CENTRAL_DIRECTORY_DIGEST_MISMATCH", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDeltaIneligibilityReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveDeltaIneligibilityReason[] $VALUES;
    public static final ArchiveDeltaIneligibilityReason MISSING_OBSERVED_STRONG_ETAG = new ArchiveDeltaIneligibilityReason("MISSING_OBSERVED_STRONG_ETAG", 0);
    public static final ArchiveDeltaIneligibilityReason MISSING_PUBLISHED_REPRESENTATION_BINDING = new ArchiveDeltaIneligibilityReason("MISSING_PUBLISHED_REPRESENTATION_BINDING", 1);
    public static final ArchiveDeltaIneligibilityReason PUBLISHED_ETAG_MISMATCH = new ArchiveDeltaIneligibilityReason("PUBLISHED_ETAG_MISMATCH", 2);
    public static final ArchiveDeltaIneligibilityReason CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE = new ArchiveDeltaIneligibilityReason("CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE", 3);
    public static final ArchiveDeltaIneligibilityReason PUBLISHED_CENTRAL_DIRECTORY_DIGEST_MISMATCH = new ArchiveDeltaIneligibilityReason("PUBLISHED_CENTRAL_DIRECTORY_DIGEST_MISMATCH", 4);
    public static final ArchiveDeltaIneligibilityReason RESOLVED_CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE = new ArchiveDeltaIneligibilityReason("RESOLVED_CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE", 5);
    public static final ArchiveDeltaIneligibilityReason RESOLVED_CENTRAL_DIRECTORY_DIGEST_MISMATCH = new ArchiveDeltaIneligibilityReason("RESOLVED_CENTRAL_DIRECTORY_DIGEST_MISMATCH", 6);

    private static final /* synthetic */ ArchiveDeltaIneligibilityReason[] $values() {
        return new ArchiveDeltaIneligibilityReason[]{MISSING_OBSERVED_STRONG_ETAG, MISSING_PUBLISHED_REPRESENTATION_BINDING, PUBLISHED_ETAG_MISMATCH, CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE, PUBLISHED_CENTRAL_DIRECTORY_DIGEST_MISMATCH, RESOLVED_CENTRAL_DIRECTORY_DIGEST_UNAVAILABLE, RESOLVED_CENTRAL_DIRECTORY_DIGEST_MISMATCH};
    }

    public static EnumEntries<ArchiveDeltaIneligibilityReason> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveDeltaIneligibilityReason valueOf(String str) {
        return (ArchiveDeltaIneligibilityReason) Enum.valueOf(ArchiveDeltaIneligibilityReason.class, str);
    }

    public static ArchiveDeltaIneligibilityReason[] values() {
        return (ArchiveDeltaIneligibilityReason[]) $VALUES.clone();
    }

    private ArchiveDeltaIneligibilityReason(String str, int i) {
    }

    static {
        ArchiveDeltaIneligibilityReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
