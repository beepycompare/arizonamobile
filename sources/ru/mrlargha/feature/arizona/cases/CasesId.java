package ru.mrlargha.feature.arizona.cases;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesId;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "MAIN_PAGE_INIT", "SET_WIN_CASES", "UPDATE_DIAMOND_COUNT", "SHOW_SPECIAL_VIDEO", "SHOW_OPEN_CASE_VIDEO", "SET_GUARANTEED_LIST", "SET_CAN_WIN_LIST", "SET_SAME_CASES", "SET_PRIZE_PROGRESS", "cases"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CasesId[] $VALUES;
    private final int subId;
    public static final CasesId MAIN_PAGE_INIT = new CasesId("MAIN_PAGE_INIT", 0, 0);
    public static final CasesId SET_WIN_CASES = new CasesId("SET_WIN_CASES", 1, 1);
    public static final CasesId UPDATE_DIAMOND_COUNT = new CasesId("UPDATE_DIAMOND_COUNT", 2, 2);
    public static final CasesId SHOW_SPECIAL_VIDEO = new CasesId("SHOW_SPECIAL_VIDEO", 3, 3);
    public static final CasesId SHOW_OPEN_CASE_VIDEO = new CasesId("SHOW_OPEN_CASE_VIDEO", 4, 4);
    public static final CasesId SET_GUARANTEED_LIST = new CasesId("SET_GUARANTEED_LIST", 5, 5);
    public static final CasesId SET_CAN_WIN_LIST = new CasesId("SET_CAN_WIN_LIST", 6, 6);
    public static final CasesId SET_SAME_CASES = new CasesId("SET_SAME_CASES", 7, 7);
    public static final CasesId SET_PRIZE_PROGRESS = new CasesId("SET_PRIZE_PROGRESS", 8, 8);

    private static final /* synthetic */ CasesId[] $values() {
        return new CasesId[]{MAIN_PAGE_INIT, SET_WIN_CASES, UPDATE_DIAMOND_COUNT, SHOW_SPECIAL_VIDEO, SHOW_OPEN_CASE_VIDEO, SET_GUARANTEED_LIST, SET_CAN_WIN_LIST, SET_SAME_CASES, SET_PRIZE_PROGRESS};
    }

    public static EnumEntries<CasesId> getEntries() {
        return $ENTRIES;
    }

    public static CasesId valueOf(String str) {
        return (CasesId) Enum.valueOf(CasesId.class, str);
    }

    public static CasesId[] values() {
        return (CasesId[]) $VALUES.clone();
    }

    private CasesId(String str, int i, int i2) {
        this.subId = i2;
    }

    public final int getSubId() {
        return this.subId;
    }

    static {
        CasesId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
