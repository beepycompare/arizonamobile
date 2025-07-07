package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassModelType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "MainBattlePass", "LevelItems", "ShopItems", "BattlePassLevelSets", "BuyPremiumTypes", "UpdateCoins", "CommonTasks", "InitRoulette", "RoulettePossiblePrises", "RoulettePrises", "OldPrises", "Welcome", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BattlePassModelType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BattlePassModelType[] $VALUES;
    public static final Companion Companion;
    private final int type;
    public static final BattlePassModelType MainBattlePass = new BattlePassModelType("MainBattlePass", 0, 0);
    public static final BattlePassModelType LevelItems = new BattlePassModelType("LevelItems", 1, 2);
    public static final BattlePassModelType ShopItems = new BattlePassModelType("ShopItems", 2, 3);
    public static final BattlePassModelType BattlePassLevelSets = new BattlePassModelType("BattlePassLevelSets", 3, 8);
    public static final BattlePassModelType BuyPremiumTypes = new BattlePassModelType("BuyPremiumTypes", 4, 7);
    public static final BattlePassModelType UpdateCoins = new BattlePassModelType("UpdateCoins", 5, 6);
    public static final BattlePassModelType CommonTasks = new BattlePassModelType("CommonTasks", 6, 18);
    public static final BattlePassModelType InitRoulette = new BattlePassModelType("InitRoulette", 7, 19);
    public static final BattlePassModelType RoulettePossiblePrises = new BattlePassModelType("RoulettePossiblePrises", 8, 11);
    public static final BattlePassModelType RoulettePrises = new BattlePassModelType("RoulettePrises", 9, 12);
    public static final BattlePassModelType OldPrises = new BattlePassModelType("OldPrises", 10, 17);
    public static final BattlePassModelType Welcome = new BattlePassModelType("Welcome", 11, 20);

    private static final /* synthetic */ BattlePassModelType[] $values() {
        return new BattlePassModelType[]{MainBattlePass, LevelItems, ShopItems, BattlePassLevelSets, BuyPremiumTypes, UpdateCoins, CommonTasks, InitRoulette, RoulettePossiblePrises, RoulettePrises, OldPrises, Welcome};
    }

    public static EnumEntries<BattlePassModelType> getEntries() {
        return $ENTRIES;
    }

    private BattlePassModelType(String str, int i, int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }

    static {
        BattlePassModelType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: BattlePassData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassModelType$Companion;", "", "<init>", "()V", "fromType", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassModelType;", "type", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BattlePassModelType fromType(int i) {
            for (BattlePassModelType battlePassModelType : BattlePassModelType.getEntries()) {
                if (battlePassModelType.getType() == i) {
                    return battlePassModelType;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    public static BattlePassModelType valueOf(String str) {
        return (BattlePassModelType) Enum.valueOf(BattlePassModelType.class, str);
    }

    public static BattlePassModelType[] values() {
        return (BattlePassModelType[]) $VALUES.clone();
    }
}
