package ru.mrlargha.commonui.elements.donate.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateSubIds;", "", "subIds", "", "<init>", "(Ljava/lang/String;II)V", "getSubIds", "()I", "UPDATE_CATEGORY_LIST", "UPDATE_ITEM_LIST", "GET_DOP_INFO", "ITEM_INIT", "DIALOG_INIT", "CHANGE_LIST", "GET_BOOST", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateSubIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonateSubIds[] $VALUES;
    private final int subIds;
    public static final DonateSubIds UPDATE_CATEGORY_LIST = new DonateSubIds("UPDATE_CATEGORY_LIST", 0, 0);
    public static final DonateSubIds UPDATE_ITEM_LIST = new DonateSubIds("UPDATE_ITEM_LIST", 1, 1);
    public static final DonateSubIds GET_DOP_INFO = new DonateSubIds("GET_DOP_INFO", 2, 2);
    public static final DonateSubIds ITEM_INIT = new DonateSubIds("ITEM_INIT", 3, 3);
    public static final DonateSubIds DIALOG_INIT = new DonateSubIds("DIALOG_INIT", 4, 4);
    public static final DonateSubIds CHANGE_LIST = new DonateSubIds("CHANGE_LIST", 5, 5);
    public static final DonateSubIds GET_BOOST = new DonateSubIds("GET_BOOST", 6, 6);

    private static final /* synthetic */ DonateSubIds[] $values() {
        return new DonateSubIds[]{UPDATE_CATEGORY_LIST, UPDATE_ITEM_LIST, GET_DOP_INFO, ITEM_INIT, DIALOG_INIT, CHANGE_LIST, GET_BOOST};
    }

    public static EnumEntries<DonateSubIds> getEntries() {
        return $ENTRIES;
    }

    public static DonateSubIds valueOf(String str) {
        return (DonateSubIds) Enum.valueOf(DonateSubIds.class, str);
    }

    public static DonateSubIds[] values() {
        return (DonateSubIds[]) $VALUES.clone();
    }

    private DonateSubIds(String str, int i, int i2) {
        this.subIds = i2;
    }

    public final int getSubIds() {
        return this.subIds;
    }

    static {
        DonateSubIds[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
