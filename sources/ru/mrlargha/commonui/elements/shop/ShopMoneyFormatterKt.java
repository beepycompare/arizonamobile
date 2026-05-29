package ru.mrlargha.commonui.elements.shop;

import android.text.SpannableString;
import kotlin.Metadata;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: ShopMoneyFormatter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toShopMoneyFormattedSpannable", "Landroid/text/SpannableString;", "", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShopMoneyFormatterKt {
    public static final SpannableString toShopMoneyFormattedSpannable(long j) {
        return ChatEmoji.INSTANCE.toSpannable(ShopMoneyFormatter.INSTANCE.format(j), 0.78f, Float.valueOf(-0.08f));
    }
}
