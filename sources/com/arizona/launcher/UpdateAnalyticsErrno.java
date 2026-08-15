package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/UpdateAnalyticsErrno;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "NoError", "UpdateServerUnreachable", "ConnectionRefused", "CorruptedFilesFound", "InsufficientStorage", "ForegroundServiceUnavailable", "ArchiveRecoveryBlocked", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateAnalyticsErrno {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UpdateAnalyticsErrno[] $VALUES;
    private final int code;
    public static final UpdateAnalyticsErrno NoError = new UpdateAnalyticsErrno("NoError", 0, 0);
    public static final UpdateAnalyticsErrno UpdateServerUnreachable = new UpdateAnalyticsErrno("UpdateServerUnreachable", 1, 1);
    public static final UpdateAnalyticsErrno ConnectionRefused = new UpdateAnalyticsErrno("ConnectionRefused", 2, 2);
    public static final UpdateAnalyticsErrno CorruptedFilesFound = new UpdateAnalyticsErrno("CorruptedFilesFound", 3, 3);
    public static final UpdateAnalyticsErrno InsufficientStorage = new UpdateAnalyticsErrno("InsufficientStorage", 4, 4);
    public static final UpdateAnalyticsErrno ForegroundServiceUnavailable = new UpdateAnalyticsErrno("ForegroundServiceUnavailable", 5, 5);
    public static final UpdateAnalyticsErrno ArchiveRecoveryBlocked = new UpdateAnalyticsErrno("ArchiveRecoveryBlocked", 6, 6);

    private static final /* synthetic */ UpdateAnalyticsErrno[] $values() {
        return new UpdateAnalyticsErrno[]{NoError, UpdateServerUnreachable, ConnectionRefused, CorruptedFilesFound, InsufficientStorage, ForegroundServiceUnavailable, ArchiveRecoveryBlocked};
    }

    public static EnumEntries<UpdateAnalyticsErrno> getEntries() {
        return $ENTRIES;
    }

    public static UpdateAnalyticsErrno valueOf(String str) {
        return (UpdateAnalyticsErrno) Enum.valueOf(UpdateAnalyticsErrno.class, str);
    }

    public static UpdateAnalyticsErrno[] values() {
        return (UpdateAnalyticsErrno[]) $VALUES.clone();
    }

    private UpdateAnalyticsErrno(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        UpdateAnalyticsErrno[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
