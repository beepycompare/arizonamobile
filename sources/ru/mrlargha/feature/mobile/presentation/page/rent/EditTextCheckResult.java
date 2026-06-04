package ru.mrlargha.feature.mobile.presentation.page.rent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArizonaRentResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/EditTextCheckResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESSFUL", "TOO_BIG_VALUE", "TOO_SMALL_VALUE", "EMPTY_VALUE", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EditTextCheckResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EditTextCheckResult[] $VALUES;
    public static final EditTextCheckResult SUCCESSFUL = new EditTextCheckResult("SUCCESSFUL", 0);
    public static final EditTextCheckResult TOO_BIG_VALUE = new EditTextCheckResult("TOO_BIG_VALUE", 1);
    public static final EditTextCheckResult TOO_SMALL_VALUE = new EditTextCheckResult("TOO_SMALL_VALUE", 2);
    public static final EditTextCheckResult EMPTY_VALUE = new EditTextCheckResult("EMPTY_VALUE", 3);

    private static final /* synthetic */ EditTextCheckResult[] $values() {
        return new EditTextCheckResult[]{SUCCESSFUL, TOO_BIG_VALUE, TOO_SMALL_VALUE, EMPTY_VALUE};
    }

    public static EnumEntries<EditTextCheckResult> getEntries() {
        return $ENTRIES;
    }

    public static EditTextCheckResult valueOf(String str) {
        return (EditTextCheckResult) Enum.valueOf(EditTextCheckResult.class, str);
    }

    public static EditTextCheckResult[] values() {
        return (EditTextCheckResult[]) $VALUES.clone();
    }

    private EditTextCheckResult(String str, int i) {
    }

    static {
        EditTextCheckResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
