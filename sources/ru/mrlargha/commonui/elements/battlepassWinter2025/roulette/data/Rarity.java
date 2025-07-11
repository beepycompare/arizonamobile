package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Rarity.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/Rarity;", "", "<init>", "(Ljava/lang/String;I)V", "gold", "red", "purple", "pink", "aqua", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Rarity {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Rarity[] $VALUES;
    public static final Rarity gold = new Rarity("gold", 0);
    public static final Rarity red = new Rarity("red", 1);
    public static final Rarity purple = new Rarity("purple", 2);
    public static final Rarity pink = new Rarity("pink", 3);
    public static final Rarity aqua = new Rarity("aqua", 4);

    private static final /* synthetic */ Rarity[] $values() {
        return new Rarity[]{gold, red, purple, pink, aqua};
    }

    public static EnumEntries<Rarity> getEntries() {
        return $ENTRIES;
    }

    public static Rarity valueOf(String str) {
        return (Rarity) Enum.valueOf(Rarity.class, str);
    }

    public static Rarity[] values() {
        return (Rarity[]) $VALUES.clone();
    }

    private Rarity(String str, int i) {
    }

    static {
        Rarity[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
