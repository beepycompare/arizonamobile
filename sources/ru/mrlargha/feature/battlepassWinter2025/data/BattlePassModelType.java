package ru.mrlargha.feature.battlepassWinter2025.data;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BattlePassData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassModelType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "MainBattlePass", "LevelItems", "BattlePassLevelSets", "BuyPremiumTypes", "UpdateCoins", "CommonTasks", "InitRoulette", "RoulettePossiblePrises", "RoulettePrises", "OldPrises", "Welcome", "ModalWindow", "BlockTimer", "ArizonaWelcome", "PremiumRewardDescription", "Companion", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassModelType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BattlePassModelType[] $VALUES;
    public static final Companion Companion;
    private final int type;
    public static final BattlePassModelType MainBattlePass = new BattlePassModelType("MainBattlePass", 0, 0);
    public static final BattlePassModelType LevelItems = new BattlePassModelType("LevelItems", 1, 2);
    public static final BattlePassModelType BattlePassLevelSets = new BattlePassModelType("BattlePassLevelSets", 2, 8);
    public static final BattlePassModelType BuyPremiumTypes = new BattlePassModelType("BuyPremiumTypes", 3, 7);
    public static final BattlePassModelType UpdateCoins = new BattlePassModelType("UpdateCoins", 4, 6);
    public static final BattlePassModelType CommonTasks = new BattlePassModelType("CommonTasks", 5, 18);
    public static final BattlePassModelType InitRoulette = new BattlePassModelType("InitRoulette", 6, 19);
    public static final BattlePassModelType RoulettePossiblePrises = new BattlePassModelType("RoulettePossiblePrises", 7, 11);
    public static final BattlePassModelType RoulettePrises = new BattlePassModelType("RoulettePrises", 8, 12);
    public static final BattlePassModelType OldPrises = new BattlePassModelType("OldPrises", 9, 17);
    public static final BattlePassModelType Welcome = new BattlePassModelType("Welcome", 10, 20);
    public static final BattlePassModelType ModalWindow = new BattlePassModelType("ModalWindow", 11, 21);
    public static final BattlePassModelType BlockTimer = new BattlePassModelType("BlockTimer", 12, 22);
    public static final BattlePassModelType ArizonaWelcome = new BattlePassModelType("ArizonaWelcome", 13, 23);
    public static final BattlePassModelType PremiumRewardDescription = new BattlePassModelType("PremiumRewardDescription", 14, 27);

    private static final /* synthetic */ BattlePassModelType[] $values() {
        return new BattlePassModelType[]{MainBattlePass, LevelItems, BattlePassLevelSets, BuyPremiumTypes, UpdateCoins, CommonTasks, InitRoulette, RoulettePossiblePrises, RoulettePrises, OldPrises, Welcome, ModalWindow, BlockTimer, ArizonaWelcome, PremiumRewardDescription};
    }

    public static EnumEntries<BattlePassModelType> getEntries() {
        return $ENTRIES;
    }

    public static BattlePassModelType valueOf(String str) {
        return (BattlePassModelType) Enum.valueOf(BattlePassModelType.class, str);
    }

    public static BattlePassModelType[] values() {
        return (BattlePassModelType[]) $VALUES.clone();
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassModelType$Companion;", "", "<init>", "()V", "fromType", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassModelType;", "type", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BattlePassModelType fromType(int i) {
            Object obj;
            Iterator<E> it = BattlePassModelType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((BattlePassModelType) obj).getType() == i) {
                    break;
                }
            }
            return (BattlePassModelType) obj;
        }
    }
}
