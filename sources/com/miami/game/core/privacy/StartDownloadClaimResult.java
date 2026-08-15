package com.miami.game.core.privacy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: StartDownloadEventGate.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/privacy/StartDownloadClaimResult;", "", "<init>", "(Ljava/lang/String;I)V", "CLAIMED", "ALREADY_REPORTED", "PERSISTENCE_FAILED", "privacy"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartDownloadClaimResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StartDownloadClaimResult[] $VALUES;
    public static final StartDownloadClaimResult CLAIMED = new StartDownloadClaimResult("CLAIMED", 0);
    public static final StartDownloadClaimResult ALREADY_REPORTED = new StartDownloadClaimResult("ALREADY_REPORTED", 1);
    public static final StartDownloadClaimResult PERSISTENCE_FAILED = new StartDownloadClaimResult("PERSISTENCE_FAILED", 2);

    private static final /* synthetic */ StartDownloadClaimResult[] $values() {
        return new StartDownloadClaimResult[]{CLAIMED, ALREADY_REPORTED, PERSISTENCE_FAILED};
    }

    public static EnumEntries<StartDownloadClaimResult> getEntries() {
        return $ENTRIES;
    }

    public static StartDownloadClaimResult valueOf(String str) {
        return (StartDownloadClaimResult) Enum.valueOf(StartDownloadClaimResult.class, str);
    }

    public static StartDownloadClaimResult[] values() {
        return (StartDownloadClaimResult[]) $VALUES.clone();
    }

    private StartDownloadClaimResult(String str, int i) {
    }

    static {
        StartDownloadClaimResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
