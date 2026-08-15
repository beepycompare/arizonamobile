package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DownloadRetryPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/DownloadFailureKind;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTION", "TIMEOUT", "DNS", "IO", "HTTP", "OTHER", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadFailureKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DownloadFailureKind[] $VALUES;
    public static final DownloadFailureKind CONNECTION = new DownloadFailureKind("CONNECTION", 0);
    public static final DownloadFailureKind TIMEOUT = new DownloadFailureKind("TIMEOUT", 1);
    public static final DownloadFailureKind DNS = new DownloadFailureKind("DNS", 2);
    public static final DownloadFailureKind IO = new DownloadFailureKind("IO", 3);
    public static final DownloadFailureKind HTTP = new DownloadFailureKind("HTTP", 4);
    public static final DownloadFailureKind OTHER = new DownloadFailureKind("OTHER", 5);

    private static final /* synthetic */ DownloadFailureKind[] $values() {
        return new DownloadFailureKind[]{CONNECTION, TIMEOUT, DNS, IO, HTTP, OTHER};
    }

    public static EnumEntries<DownloadFailureKind> getEntries() {
        return $ENTRIES;
    }

    public static DownloadFailureKind valueOf(String str) {
        return (DownloadFailureKind) Enum.valueOf(DownloadFailureKind.class, str);
    }

    public static DownloadFailureKind[] values() {
        return (DownloadFailureKind[]) $VALUES.clone();
    }

    private DownloadFailureKind(String str, int i) {
    }

    static {
        DownloadFailureKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
