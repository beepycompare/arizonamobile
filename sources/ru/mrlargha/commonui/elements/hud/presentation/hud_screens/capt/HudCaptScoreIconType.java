package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudCaptModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptScoreIconType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SKULL", "BOX", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudCaptScoreIconType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HudCaptScoreIconType[] $VALUES;
    private final int type;
    public static final HudCaptScoreIconType SKULL = new HudCaptScoreIconType("SKULL", 0, 0);
    public static final HudCaptScoreIconType BOX = new HudCaptScoreIconType("BOX", 1, 1);

    private static final /* synthetic */ HudCaptScoreIconType[] $values() {
        return new HudCaptScoreIconType[]{SKULL, BOX};
    }

    public static EnumEntries<HudCaptScoreIconType> getEntries() {
        return $ENTRIES;
    }

    public static HudCaptScoreIconType valueOf(String str) {
        return (HudCaptScoreIconType) Enum.valueOf(HudCaptScoreIconType.class, str);
    }

    public static HudCaptScoreIconType[] values() {
        return (HudCaptScoreIconType[]) $VALUES.clone();
    }

    private HudCaptScoreIconType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        HudCaptScoreIconType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
