package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudCounterItemType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounterItemType;", "", "<init>", "(Ljava/lang/String;I)V", "SIMPLE_TEXT", "ICON_WITH_TEXT", "TITLE_WITH_TEXT", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudCounterItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HudCounterItemType[] $VALUES;
    public static final HudCounterItemType SIMPLE_TEXT = new HudCounterItemType("SIMPLE_TEXT", 0);
    public static final HudCounterItemType ICON_WITH_TEXT = new HudCounterItemType("ICON_WITH_TEXT", 1);
    public static final HudCounterItemType TITLE_WITH_TEXT = new HudCounterItemType("TITLE_WITH_TEXT", 2);

    private static final /* synthetic */ HudCounterItemType[] $values() {
        return new HudCounterItemType[]{SIMPLE_TEXT, ICON_WITH_TEXT, TITLE_WITH_TEXT};
    }

    public static EnumEntries<HudCounterItemType> getEntries() {
        return $ENTRIES;
    }

    public static HudCounterItemType valueOf(String str) {
        return (HudCounterItemType) Enum.valueOf(HudCounterItemType.class, str);
    }

    public static HudCounterItemType[] values() {
        return (HudCounterItemType[]) $VALUES.clone();
    }

    private HudCounterItemType(String str, int i) {
    }

    static {
        HudCounterItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
