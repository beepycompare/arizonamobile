package ru.mrlargha.commonui.elements.dialogs;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DialogBankHistory.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryTab;", "", "operationTypes", "", "", "<init>", "(Ljava/lang/String;ILjava/util/Set;)V", "getOperationTypes", "()Ljava/util/Set;", "ALL", "WITHDRAW", "DEPOSIT", "TRANSFER", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankHistoryTab {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DialogBankHistoryTab[] $VALUES;
    private final Set<Integer> operationTypes;
    public static final DialogBankHistoryTab ALL = new DialogBankHistoryTab("ALL", 0, SetsKt.emptySet());
    public static final DialogBankHistoryTab WITHDRAW = new DialogBankHistoryTab("WITHDRAW", 1, SetsKt.setOf(0));
    public static final DialogBankHistoryTab DEPOSIT = new DialogBankHistoryTab("DEPOSIT", 2, SetsKt.setOf((Object[]) new Integer[]{1, 2, 4}));
    public static final DialogBankHistoryTab TRANSFER = new DialogBankHistoryTab("TRANSFER", 3, SetsKt.setOf(3));

    private static final /* synthetic */ DialogBankHistoryTab[] $values() {
        return new DialogBankHistoryTab[]{ALL, WITHDRAW, DEPOSIT, TRANSFER};
    }

    public static EnumEntries<DialogBankHistoryTab> getEntries() {
        return $ENTRIES;
    }

    public static DialogBankHistoryTab valueOf(String str) {
        return (DialogBankHistoryTab) Enum.valueOf(DialogBankHistoryTab.class, str);
    }

    public static DialogBankHistoryTab[] values() {
        return (DialogBankHistoryTab[]) $VALUES.clone();
    }

    private DialogBankHistoryTab(String str, int i, Set set) {
        this.operationTypes = set;
    }

    public final Set<Integer> getOperationTypes() {
        return this.operationTypes;
    }

    static {
        DialogBankHistoryTab[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
