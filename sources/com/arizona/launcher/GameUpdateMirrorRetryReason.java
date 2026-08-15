package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GameUpdateCheckRunner.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/GameUpdateMirrorRetryReason;", "", "<init>", "(Ljava/lang/String;I)V", "METADATA_FAILURE", "ARCHIVE_CHECK_BLOCK", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameUpdateMirrorRetryReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GameUpdateMirrorRetryReason[] $VALUES;
    public static final GameUpdateMirrorRetryReason METADATA_FAILURE = new GameUpdateMirrorRetryReason("METADATA_FAILURE", 0);
    public static final GameUpdateMirrorRetryReason ARCHIVE_CHECK_BLOCK = new GameUpdateMirrorRetryReason("ARCHIVE_CHECK_BLOCK", 1);

    private static final /* synthetic */ GameUpdateMirrorRetryReason[] $values() {
        return new GameUpdateMirrorRetryReason[]{METADATA_FAILURE, ARCHIVE_CHECK_BLOCK};
    }

    public static EnumEntries<GameUpdateMirrorRetryReason> getEntries() {
        return $ENTRIES;
    }

    public static GameUpdateMirrorRetryReason valueOf(String str) {
        return (GameUpdateMirrorRetryReason) Enum.valueOf(GameUpdateMirrorRetryReason.class, str);
    }

    public static GameUpdateMirrorRetryReason[] values() {
        return (GameUpdateMirrorRetryReason[]) $VALUES.clone();
    }

    private GameUpdateMirrorRetryReason(String str, int i) {
    }

    static {
        GameUpdateMirrorRetryReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
