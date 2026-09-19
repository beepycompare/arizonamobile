package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonatePayPassAdapter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassProgressFill;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "TO_CENTER", "FULL", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassProgressFill {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonatePayPassProgressFill[] $VALUES;
    public static final DonatePayPassProgressFill NONE = new DonatePayPassProgressFill("NONE", 0);
    public static final DonatePayPassProgressFill TO_CENTER = new DonatePayPassProgressFill("TO_CENTER", 1);
    public static final DonatePayPassProgressFill FULL = new DonatePayPassProgressFill("FULL", 2);

    private static final /* synthetic */ DonatePayPassProgressFill[] $values() {
        return new DonatePayPassProgressFill[]{NONE, TO_CENTER, FULL};
    }

    public static EnumEntries<DonatePayPassProgressFill> getEntries() {
        return $ENTRIES;
    }

    public static DonatePayPassProgressFill valueOf(String str) {
        return (DonatePayPassProgressFill) Enum.valueOf(DonatePayPassProgressFill.class, str);
    }

    public static DonatePayPassProgressFill[] values() {
        return (DonatePayPassProgressFill[]) $VALUES.clone();
    }

    private DonatePayPassProgressFill(String str, int i) {
    }

    static {
        DonatePayPassProgressFill[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
