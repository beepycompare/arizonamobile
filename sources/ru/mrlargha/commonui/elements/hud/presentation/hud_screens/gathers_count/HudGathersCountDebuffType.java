package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudGathersCountModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountDebuffType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "FROZEN", "BLIND", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCountDebuffType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HudGathersCountDebuffType[] $VALUES;
    private final String type;
    public static final HudGathersCountDebuffType FROZEN = new HudGathersCountDebuffType("FROZEN", 0, "frozen");
    public static final HudGathersCountDebuffType BLIND = new HudGathersCountDebuffType("BLIND", 1, "blind");

    private static final /* synthetic */ HudGathersCountDebuffType[] $values() {
        return new HudGathersCountDebuffType[]{FROZEN, BLIND};
    }

    public static EnumEntries<HudGathersCountDebuffType> getEntries() {
        return $ENTRIES;
    }

    public static HudGathersCountDebuffType valueOf(String str) {
        return (HudGathersCountDebuffType) Enum.valueOf(HudGathersCountDebuffType.class, str);
    }

    public static HudGathersCountDebuffType[] values() {
        return (HudGathersCountDebuffType[]) $VALUES.clone();
    }

    private HudGathersCountDebuffType(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        HudGathersCountDebuffType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
