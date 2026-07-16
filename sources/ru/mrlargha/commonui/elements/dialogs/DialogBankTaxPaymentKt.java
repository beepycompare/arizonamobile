package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\r\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toDialogBankTaxPaymentMoneyText", "", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankTaxPaymentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toDialogBankTaxPaymentMoneyText(long j) {
        return ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, MoneyFormatter.format$default(MoneyFormatter.INSTANCE, j, false, null, null, 14, null), 0.8f, null, 2, null);
    }
}
