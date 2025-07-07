package ru.mrlargha.commonui.elements.hud.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudConstants.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeterValue;", "", "<init>", "(Ljava/lang/String;I)V", "PRISE", "PERCENT", "TEXT", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeTaximeterValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypeTaximeterValue[] $VALUES;
    public static final TypeTaximeterValue PRISE = new TypeTaximeterValue("PRISE", 0);
    public static final TypeTaximeterValue PERCENT = new TypeTaximeterValue("PERCENT", 1);
    public static final TypeTaximeterValue TEXT = new TypeTaximeterValue("TEXT", 2);

    private static final /* synthetic */ TypeTaximeterValue[] $values() {
        return new TypeTaximeterValue[]{PRISE, PERCENT, TEXT};
    }

    public static EnumEntries<TypeTaximeterValue> getEntries() {
        return $ENTRIES;
    }

    private TypeTaximeterValue(String str, int i) {
    }

    static {
        TypeTaximeterValue[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TypeTaximeterValue valueOf(String str) {
        return (TypeTaximeterValue) Enum.valueOf(TypeTaximeterValue.class, str);
    }

    public static TypeTaximeterValue[] values() {
        return (TypeTaximeterValue[]) $VALUES.clone();
    }
}
