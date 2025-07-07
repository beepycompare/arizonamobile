package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattleCoinsMultiplier;", "", "<init>", "(Ljava/lang/String;I)V", "X10", "X100", "X1000", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BattleCoinsMultiplier {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BattleCoinsMultiplier[] $VALUES;
    public static final BattleCoinsMultiplier X10 = new BattleCoinsMultiplier("X10", 0);
    public static final BattleCoinsMultiplier X100 = new BattleCoinsMultiplier("X100", 1);
    public static final BattleCoinsMultiplier X1000 = new BattleCoinsMultiplier("X1000", 2);

    private static final /* synthetic */ BattleCoinsMultiplier[] $values() {
        return new BattleCoinsMultiplier[]{X10, X100, X1000};
    }

    public static EnumEntries<BattleCoinsMultiplier> getEntries() {
        return $ENTRIES;
    }

    private BattleCoinsMultiplier(String str, int i) {
    }

    static {
        BattleCoinsMultiplier[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BattleCoinsMultiplier valueOf(String str) {
        return (BattleCoinsMultiplier) Enum.valueOf(BattleCoinsMultiplier.class, str);
    }

    public static BattleCoinsMultiplier[] values() {
        return (BattleCoinsMultiplier[]) $VALUES.clone();
    }
}
