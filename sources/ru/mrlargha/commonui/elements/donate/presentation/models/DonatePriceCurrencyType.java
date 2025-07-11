package ru.mrlargha.commonui.elements.donate.presentation.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ru.mrlargha.commonui.R;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateItemModelUi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePriceCurrencyType;", "", "type", "", "icon", "<init>", "(Ljava/lang/String;III)V", "getType", "()I", "getIcon", "RUB", "AZ", "DOLLAR", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonatePriceCurrencyType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonatePriceCurrencyType[] $VALUES;
    private final int icon;
    private final int type;
    public static final DonatePriceCurrencyType RUB = new DonatePriceCurrencyType("RUB", 0, 0, R.drawable.ic_rubble);
    public static final DonatePriceCurrencyType AZ = new DonatePriceCurrencyType("AZ", 1, 1, R.drawable.ic_az_coins);
    public static final DonatePriceCurrencyType DOLLAR = new DonatePriceCurrencyType("DOLLAR", 2, 2, R.drawable.ic_dollar);

    private static final /* synthetic */ DonatePriceCurrencyType[] $values() {
        return new DonatePriceCurrencyType[]{RUB, AZ, DOLLAR};
    }

    public static EnumEntries<DonatePriceCurrencyType> getEntries() {
        return $ENTRIES;
    }

    public static DonatePriceCurrencyType valueOf(String str) {
        return (DonatePriceCurrencyType) Enum.valueOf(DonatePriceCurrencyType.class, str);
    }

    public static DonatePriceCurrencyType[] values() {
        return (DonatePriceCurrencyType[]) $VALUES.clone();
    }

    private DonatePriceCurrencyType(String str, int i, int i2, int i3) {
        this.type = i2;
        this.icon = i3;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getType() {
        return this.type;
    }

    static {
        DonatePriceCurrencyType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
