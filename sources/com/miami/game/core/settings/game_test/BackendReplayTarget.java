package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\r"}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendReplayTarget;", "", "<init>", "(Ljava/lang/String;I)V", "UI", "VALIDATOR", "BOTH", "includesUi", "", "getIncludesUi", "()Z", "includesValidator", "getIncludesValidator", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackendReplayTarget {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackendReplayTarget[] $VALUES;
    public static final BackendReplayTarget UI = new BackendReplayTarget("UI", 0);
    public static final BackendReplayTarget VALIDATOR = new BackendReplayTarget("VALIDATOR", 1);
    public static final BackendReplayTarget BOTH = new BackendReplayTarget("BOTH", 2);

    private static final /* synthetic */ BackendReplayTarget[] $values() {
        return new BackendReplayTarget[]{UI, VALIDATOR, BOTH};
    }

    public static EnumEntries<BackendReplayTarget> getEntries() {
        return $ENTRIES;
    }

    public static BackendReplayTarget valueOf(String str) {
        return (BackendReplayTarget) Enum.valueOf(BackendReplayTarget.class, str);
    }

    public static BackendReplayTarget[] values() {
        return (BackendReplayTarget[]) $VALUES.clone();
    }

    private BackendReplayTarget(String str, int i) {
    }

    static {
        BackendReplayTarget[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final boolean getIncludesUi() {
        return this == UI || this == BOTH;
    }

    public final boolean getIncludesValidator() {
        return this == VALIDATOR || this == BOTH;
    }
}
