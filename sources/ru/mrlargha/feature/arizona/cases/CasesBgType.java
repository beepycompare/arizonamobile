package ru.mrlargha.feature.arizona.cases;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0001\u0010\u0004\u001a\u00020\u0005:\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesBgType;", "", "bgName", "", "resId", "", "Landroidx/annotation/DrawableRes;", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getBgName", "()Ljava/lang/String;", "getResId", "()I", "GREEN", "RED", "GOLD", "PURPLE", "NONE", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesBgType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CasesBgType[] $VALUES;
    private final String bgName;
    private final int resId;
    public static final CasesBgType GREEN = new CasesBgType("GREEN", 0, CasesSameCasesAdapter.TOP, R.drawable.arizona_cases_can_win_item_green_bg);
    public static final CasesBgType RED = new CasesBgType("RED", 1, CasesSameCasesAdapter.NEW, R.drawable.arizona_cases_can_win_item_red_bg);
    public static final CasesBgType GOLD = new CasesBgType("GOLD", 2, "gold", R.drawable.arizona_cases_can_win_item_gold_bg);
    public static final CasesBgType PURPLE = new CasesBgType("PURPLE", 3, "purple", R.drawable.arizona_cases_can_win_item_purple_bg);
    public static final CasesBgType NONE = new CasesBgType("NONE", 4, "none", R.drawable.arizona_cases_can_win_item_default_bg);

    private static final /* synthetic */ CasesBgType[] $values() {
        return new CasesBgType[]{GREEN, RED, GOLD, PURPLE, NONE};
    }

    public static EnumEntries<CasesBgType> getEntries() {
        return $ENTRIES;
    }

    public static CasesBgType valueOf(String str) {
        return (CasesBgType) Enum.valueOf(CasesBgType.class, str);
    }

    public static CasesBgType[] values() {
        return (CasesBgType[]) $VALUES.clone();
    }

    private CasesBgType(String str, int i, String str2, int i2) {
        this.bgName = str2;
        this.resId = i2;
    }

    public final String getBgName() {
        return this.bgName;
    }

    public final int getResId() {
        return this.resId;
    }

    static {
        CasesBgType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
