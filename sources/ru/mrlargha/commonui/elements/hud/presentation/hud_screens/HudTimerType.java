package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudTimer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudTimerType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DEFAULT", "WARNING", "DANGER", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
final class HudTimerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HudTimerType[] $VALUES;
    private final String type;
    public static final HudTimerType DEFAULT = new HudTimerType("DEFAULT", 0, "default");
    public static final HudTimerType WARNING = new HudTimerType("WARNING", 1, "warning");
    public static final HudTimerType DANGER = new HudTimerType("DANGER", 2, "danger");

    private static final /* synthetic */ HudTimerType[] $values() {
        return new HudTimerType[]{DEFAULT, WARNING, DANGER};
    }

    public static EnumEntries<HudTimerType> getEntries() {
        return $ENTRIES;
    }

    public static HudTimerType valueOf(String str) {
        return (HudTimerType) Enum.valueOf(HudTimerType.class, str);
    }

    public static HudTimerType[] values() {
        return (HudTimerType[]) $VALUES.clone();
    }

    private HudTimerType(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        HudTimerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
