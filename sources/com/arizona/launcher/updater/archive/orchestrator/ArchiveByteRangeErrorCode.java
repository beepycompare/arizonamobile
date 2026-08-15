package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_REQUEST", "NETWORK_FAILED", "HTTP_STATUS", "CONTENT_ENCODING_UNSUPPORTED", "CONTENT_RANGE_INVALID", "CONTENT_RANGE_MISMATCH", "BODY_LENGTH_MISMATCH", "EFFECTIVE_URL_UNSAFE", "REDIRECT_LOCATION_MISSING", "REDIRECT_LIMIT_EXCEEDED", "REDIRECT_URL_UNSAFE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveByteRangeErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveByteRangeErrorCode[] $VALUES;
    public static final ArchiveByteRangeErrorCode INVALID_REQUEST = new ArchiveByteRangeErrorCode("INVALID_REQUEST", 0);
    public static final ArchiveByteRangeErrorCode NETWORK_FAILED = new ArchiveByteRangeErrorCode("NETWORK_FAILED", 1);
    public static final ArchiveByteRangeErrorCode HTTP_STATUS = new ArchiveByteRangeErrorCode("HTTP_STATUS", 2);
    public static final ArchiveByteRangeErrorCode CONTENT_ENCODING_UNSUPPORTED = new ArchiveByteRangeErrorCode("CONTENT_ENCODING_UNSUPPORTED", 3);
    public static final ArchiveByteRangeErrorCode CONTENT_RANGE_INVALID = new ArchiveByteRangeErrorCode("CONTENT_RANGE_INVALID", 4);
    public static final ArchiveByteRangeErrorCode CONTENT_RANGE_MISMATCH = new ArchiveByteRangeErrorCode("CONTENT_RANGE_MISMATCH", 5);
    public static final ArchiveByteRangeErrorCode BODY_LENGTH_MISMATCH = new ArchiveByteRangeErrorCode("BODY_LENGTH_MISMATCH", 6);
    public static final ArchiveByteRangeErrorCode EFFECTIVE_URL_UNSAFE = new ArchiveByteRangeErrorCode("EFFECTIVE_URL_UNSAFE", 7);
    public static final ArchiveByteRangeErrorCode REDIRECT_LOCATION_MISSING = new ArchiveByteRangeErrorCode("REDIRECT_LOCATION_MISSING", 8);
    public static final ArchiveByteRangeErrorCode REDIRECT_LIMIT_EXCEEDED = new ArchiveByteRangeErrorCode("REDIRECT_LIMIT_EXCEEDED", 9);
    public static final ArchiveByteRangeErrorCode REDIRECT_URL_UNSAFE = new ArchiveByteRangeErrorCode("REDIRECT_URL_UNSAFE", 10);

    private static final /* synthetic */ ArchiveByteRangeErrorCode[] $values() {
        return new ArchiveByteRangeErrorCode[]{INVALID_REQUEST, NETWORK_FAILED, HTTP_STATUS, CONTENT_ENCODING_UNSUPPORTED, CONTENT_RANGE_INVALID, CONTENT_RANGE_MISMATCH, BODY_LENGTH_MISMATCH, EFFECTIVE_URL_UNSAFE, REDIRECT_LOCATION_MISSING, REDIRECT_LIMIT_EXCEEDED, REDIRECT_URL_UNSAFE};
    }

    public static EnumEntries<ArchiveByteRangeErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveByteRangeErrorCode valueOf(String str) {
        return (ArchiveByteRangeErrorCode) Enum.valueOf(ArchiveByteRangeErrorCode.class, str);
    }

    public static ArchiveByteRangeErrorCode[] values() {
        return (ArchiveByteRangeErrorCode[]) $VALUES.clone();
    }

    private ArchiveByteRangeErrorCode(String str, int i) {
    }

    static {
        ArchiveByteRangeErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
