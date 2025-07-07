package ru.mrlargha.commonui.elements.donate.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateSubIds;", "", "subIds", "", "<init>", "(Ljava/lang/String;II)V", "getSubIds", "()I", "MAIN_LIST_INIT", "ORDINARY_LIST_INIT", "PURCHASE_LIST_INIT", "DIALOG_INIT", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateSubIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonateSubIds[] $VALUES;
    private final int subIds;
    public static final DonateSubIds MAIN_LIST_INIT = new DonateSubIds("MAIN_LIST_INIT", 0, 0);
    public static final DonateSubIds ORDINARY_LIST_INIT = new DonateSubIds("ORDINARY_LIST_INIT", 1, 1);
    public static final DonateSubIds PURCHASE_LIST_INIT = new DonateSubIds("PURCHASE_LIST_INIT", 2, 2);
    public static final DonateSubIds DIALOG_INIT = new DonateSubIds("DIALOG_INIT", 3, 3);

    private static final /* synthetic */ DonateSubIds[] $values() {
        return new DonateSubIds[]{MAIN_LIST_INIT, ORDINARY_LIST_INIT, PURCHASE_LIST_INIT, DIALOG_INIT};
    }

    public static EnumEntries<DonateSubIds> getEntries() {
        return $ENTRIES;
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

    public static DonateSubIds valueOf(String str) {
        return (DonateSubIds) Enum.valueOf(DonateSubIds.class, str);
    }

    public static DonateSubIds[] values() {
        return (DonateSubIds[]) $VALUES.clone();
    }
}
