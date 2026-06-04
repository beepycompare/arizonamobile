package ru.mrlargha.commonui.elements.shop;

import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: ShopMoneyFormatter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/shop/ShopMoneyFormatter;", "", "<init>", "()V", "format", "", "value", "", "absSafe", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShopMoneyFormatter {
    public static final ShopMoneyFormatter INSTANCE = new ShopMoneyFormatter();

    private ShopMoneyFormatter() {
    }

    public final String format(long j) {
        if (UtilsKt.isArizonaType()) {
            return ":cash: " + (j < 0 ? Constants.FILENAME_SEQUENCE_SEPARATOR : "") + StringsKt.replace$default(MoneyFormatter.INSTANCE.formatPlain(absSafe(j)), " ", ".", false, 4, (Object) null) + " ";
        }
        return String.valueOf(j);
    }

    private final long absSafe(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return Math.abs(j);
    }
}
