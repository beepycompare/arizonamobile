package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import com.arizona.launcher.UpdateServiceContract;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HudGathersCountModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountBonusType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SPEED", "GIFT", "MAGNET", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCountBonusType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HudGathersCountBonusType[] $VALUES;
    private final String type;
    public static final HudGathersCountBonusType SPEED = new HudGathersCountBonusType("SPEED", 0, UpdateServiceContract.BundleKey.SPEED);
    public static final HudGathersCountBonusType GIFT = new HudGathersCountBonusType("GIFT", 1, "gift");
    public static final HudGathersCountBonusType MAGNET = new HudGathersCountBonusType("MAGNET", 2, "magnet");

    private static final /* synthetic */ HudGathersCountBonusType[] $values() {
        return new HudGathersCountBonusType[]{SPEED, GIFT, MAGNET};
    }

    public static EnumEntries<HudGathersCountBonusType> getEntries() {
        return $ENTRIES;
    }

    public static HudGathersCountBonusType valueOf(String str) {
        return (HudGathersCountBonusType) Enum.valueOf(HudGathersCountBonusType.class, str);
    }

    public static HudGathersCountBonusType[] values() {
        return (HudGathersCountBonusType[]) $VALUES.clone();
    }

    private HudGathersCountBonusType(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        HudGathersCountBonusType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
