package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/utils/TuningItems;", "", "<init>", "(Ljava/lang/String;I)V", "TUNING_WHEEL", "TUNING_BONNET_TYPE_STOCK", "TUNING_BONNET_TYPE_FOUR_SLOT", "TUNING_BONNET_TYPE_SPEEDLINE", "TUNING_BONNET_TYPE_TREMOR", "TUNING_BONNET_TYPE_DOUBLE_V", "TUNING_BONNET_TYPE_TWISTER", "TUNING_SPOILER_TYPE_STOCK", "TUNING_SPOILER_TYPE_DUCKTAIL", "TUNING_SPOILER_TYPE_REAPER", "TUNING_SPOILER_TYPE_DAYTONA", "TUNING_SPOILER_TYPE_CURSE", "TUNING_REAR_BUMPER_TYPE_GS", "TUNING_REAR_BUMPER_TYPE_CR", "TUNING_REAR_BUMPER_TYPE_CT", "TUNING_REAR_BUMPER_TYPE_GT", "TUNING_REAR_BUMPER_TYPE_GRID", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TuningItems {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TuningItems[] $VALUES;
    public static final TuningItems TUNING_WHEEL = new TuningItems("TUNING_WHEEL", 0);
    public static final TuningItems TUNING_BONNET_TYPE_STOCK = new TuningItems("TUNING_BONNET_TYPE_STOCK", 1);
    public static final TuningItems TUNING_BONNET_TYPE_FOUR_SLOT = new TuningItems("TUNING_BONNET_TYPE_FOUR_SLOT", 2);
    public static final TuningItems TUNING_BONNET_TYPE_SPEEDLINE = new TuningItems("TUNING_BONNET_TYPE_SPEEDLINE", 3);
    public static final TuningItems TUNING_BONNET_TYPE_TREMOR = new TuningItems("TUNING_BONNET_TYPE_TREMOR", 4);
    public static final TuningItems TUNING_BONNET_TYPE_DOUBLE_V = new TuningItems("TUNING_BONNET_TYPE_DOUBLE_V", 5);
    public static final TuningItems TUNING_BONNET_TYPE_TWISTER = new TuningItems("TUNING_BONNET_TYPE_TWISTER", 6);
    public static final TuningItems TUNING_SPOILER_TYPE_STOCK = new TuningItems("TUNING_SPOILER_TYPE_STOCK", 7);
    public static final TuningItems TUNING_SPOILER_TYPE_DUCKTAIL = new TuningItems("TUNING_SPOILER_TYPE_DUCKTAIL", 8);
    public static final TuningItems TUNING_SPOILER_TYPE_REAPER = new TuningItems("TUNING_SPOILER_TYPE_REAPER", 9);
    public static final TuningItems TUNING_SPOILER_TYPE_DAYTONA = new TuningItems("TUNING_SPOILER_TYPE_DAYTONA", 10);
    public static final TuningItems TUNING_SPOILER_TYPE_CURSE = new TuningItems("TUNING_SPOILER_TYPE_CURSE", 11);
    public static final TuningItems TUNING_REAR_BUMPER_TYPE_GS = new TuningItems("TUNING_REAR_BUMPER_TYPE_GS", 12);
    public static final TuningItems TUNING_REAR_BUMPER_TYPE_CR = new TuningItems("TUNING_REAR_BUMPER_TYPE_CR", 13);
    public static final TuningItems TUNING_REAR_BUMPER_TYPE_CT = new TuningItems("TUNING_REAR_BUMPER_TYPE_CT", 14);
    public static final TuningItems TUNING_REAR_BUMPER_TYPE_GT = new TuningItems("TUNING_REAR_BUMPER_TYPE_GT", 15);
    public static final TuningItems TUNING_REAR_BUMPER_TYPE_GRID = new TuningItems("TUNING_REAR_BUMPER_TYPE_GRID", 16);

    private static final /* synthetic */ TuningItems[] $values() {
        return new TuningItems[]{TUNING_WHEEL, TUNING_BONNET_TYPE_STOCK, TUNING_BONNET_TYPE_FOUR_SLOT, TUNING_BONNET_TYPE_SPEEDLINE, TUNING_BONNET_TYPE_TREMOR, TUNING_BONNET_TYPE_DOUBLE_V, TUNING_BONNET_TYPE_TWISTER, TUNING_SPOILER_TYPE_STOCK, TUNING_SPOILER_TYPE_DUCKTAIL, TUNING_SPOILER_TYPE_REAPER, TUNING_SPOILER_TYPE_DAYTONA, TUNING_SPOILER_TYPE_CURSE, TUNING_REAR_BUMPER_TYPE_GS, TUNING_REAR_BUMPER_TYPE_CR, TUNING_REAR_BUMPER_TYPE_CT, TUNING_REAR_BUMPER_TYPE_GT, TUNING_REAR_BUMPER_TYPE_GRID};
    }

    public static EnumEntries<TuningItems> getEntries() {
        return $ENTRIES;
    }

    public static TuningItems valueOf(String str) {
        return (TuningItems) Enum.valueOf(TuningItems.class, str);
    }

    public static TuningItems[] values() {
        return (TuningItems[]) $VALUES.clone();
    }

    private TuningItems(String str, int i) {
    }

    static {
        TuningItems[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
