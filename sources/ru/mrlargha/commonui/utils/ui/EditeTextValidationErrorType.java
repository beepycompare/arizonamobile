package ru.mrlargha.commonui.utils.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: EditTextValidationBuilder.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/utils/ui/EditeTextValidationErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESSFUL", "EMPTY", "MIN_VALUE", "MAX_VALUE", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EditeTextValidationErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EditeTextValidationErrorType[] $VALUES;
    public static final EditeTextValidationErrorType SUCCESSFUL = new EditeTextValidationErrorType("SUCCESSFUL", 0);
    public static final EditeTextValidationErrorType EMPTY = new EditeTextValidationErrorType("EMPTY", 1);
    public static final EditeTextValidationErrorType MIN_VALUE = new EditeTextValidationErrorType("MIN_VALUE", 2);
    public static final EditeTextValidationErrorType MAX_VALUE = new EditeTextValidationErrorType("MAX_VALUE", 3);

    private static final /* synthetic */ EditeTextValidationErrorType[] $values() {
        return new EditeTextValidationErrorType[]{SUCCESSFUL, EMPTY, MIN_VALUE, MAX_VALUE};
    }

    public static EnumEntries<EditeTextValidationErrorType> getEntries() {
        return $ENTRIES;
    }

    public static EditeTextValidationErrorType valueOf(String str) {
        return (EditeTextValidationErrorType) Enum.valueOf(EditeTextValidationErrorType.class, str);
    }

    public static EditeTextValidationErrorType[] values() {
        return (EditeTextValidationErrorType[]) $VALUES.clone();
    }

    private EditeTextValidationErrorType(String str, int i) {
    }

    static {
        EditeTextValidationErrorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
