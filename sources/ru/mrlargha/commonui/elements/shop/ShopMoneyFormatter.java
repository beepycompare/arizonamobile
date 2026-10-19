package ru.mrlargha.commonui.elements.shop;

import kotlin.Metadata;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: ShopMoneyFormatter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/shop/ShopMoneyFormatter;", "", "<init>", "()V", "format", "", "value", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShopMoneyFormatter {
    public static final ShopMoneyFormatter INSTANCE = new ShopMoneyFormatter();

    private ShopMoneyFormatter() {
    }

    public final String format(long j) {
        return MoneyFormatter.format$default(MoneyFormatter.INSTANCE, j, false, null, " ", 6, null);
    }
}
