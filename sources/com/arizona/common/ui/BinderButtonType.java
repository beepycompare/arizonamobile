package com.arizona.common.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KeyboardButton.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/common/ui/BinderButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "BINDED", "EDITABLE", "CommonLibs"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BinderButtonType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BinderButtonType[] $VALUES;
    public static final BinderButtonType INITIAL = new BinderButtonType("INITIAL", 0);
    public static final BinderButtonType BINDED = new BinderButtonType("BINDED", 1);
    public static final BinderButtonType EDITABLE = new BinderButtonType("EDITABLE", 2);

    private static final /* synthetic */ BinderButtonType[] $values() {
        return new BinderButtonType[]{INITIAL, BINDED, EDITABLE};
    }

    public static EnumEntries<BinderButtonType> getEntries() {
        return $ENTRIES;
    }

    public static BinderButtonType valueOf(String str) {
        return (BinderButtonType) Enum.valueOf(BinderButtonType.class, str);
    }

    public static BinderButtonType[] values() {
        return (BinderButtonType[]) $VALUES.clone();
    }

    private BinderButtonType(String str, int i) {
    }

    static {
        BinderButtonType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
