package ru.mrlargha.commonui.elements.blueprint;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BlueprintResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/blueprint/WeaponType;", "", "weaponId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWeaponId", "()Ljava/lang/String;", "RPG_WEAPON", "AK_WEAPON", "PM_WEAPON", "RIFLE_WEAPON", "SNIPE_WEAPON", "PIPE_ONE", "PIPE_TWO", "PIPE_THREE", "PIPE_FOUR", "PIPE_FIVE", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WeaponType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WeaponType[] $VALUES;
    public static final Companion Companion;
    private final String weaponId;
    public static final WeaponType RPG_WEAPON = new WeaponType("RPG_WEAPON", 0, "rpg");
    public static final WeaponType AK_WEAPON = new WeaponType("AK_WEAPON", 1, "ak");
    public static final WeaponType PM_WEAPON = new WeaponType("PM_WEAPON", 2, "pm");
    public static final WeaponType RIFLE_WEAPON = new WeaponType("RIFLE_WEAPON", 3, "rifle");
    public static final WeaponType SNIPE_WEAPON = new WeaponType("SNIPE_WEAPON", 4, "snipe");
    public static final WeaponType PIPE_ONE = new WeaponType("PIPE_ONE", 5, "pipe");
    public static final WeaponType PIPE_TWO = new WeaponType("PIPE_TWO", 6, "pipeTwo");
    public static final WeaponType PIPE_THREE = new WeaponType("PIPE_THREE", 7, "pipeThree");
    public static final WeaponType PIPE_FOUR = new WeaponType("PIPE_FOUR", 8, "pipeFour");
    public static final WeaponType PIPE_FIVE = new WeaponType("PIPE_FIVE", 9, "pipeFive");

    private static final /* synthetic */ WeaponType[] $values() {
        return new WeaponType[]{RPG_WEAPON, AK_WEAPON, PM_WEAPON, RIFLE_WEAPON, SNIPE_WEAPON, PIPE_ONE, PIPE_TWO, PIPE_THREE, PIPE_FOUR, PIPE_FIVE};
    }

    public static EnumEntries<WeaponType> getEntries() {
        return $ENTRIES;
    }

    private WeaponType(String str, int i, String str2) {
        this.weaponId = str2;
    }

    public final String getWeaponId() {
        return this.weaponId;
    }

    static {
        WeaponType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: BlueprintResponse.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/blueprint/WeaponType$Companion;", "", "<init>", "()V", "fromWeaponId", "Lru/mrlargha/commonui/elements/blueprint/WeaponType;", "weaponId", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WeaponType fromWeaponId(String weaponId) {
            Object obj;
            Intrinsics.checkNotNullParameter(weaponId, "weaponId");
            Iterator<E> it = WeaponType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((WeaponType) obj).getWeaponId(), weaponId)) {
                    break;
                }
            }
            WeaponType weaponType = (WeaponType) obj;
            return weaponType == null ? WeaponType.RPG_WEAPON : weaponType;
        }
    }

    public static WeaponType valueOf(String str) {
        return (WeaponType) Enum.valueOf(WeaponType.class, str);
    }

    public static WeaponType[] values() {
        return (WeaponType[]) $VALUES.clone();
    }
}
