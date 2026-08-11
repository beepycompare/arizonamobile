package com.arizonagames.feature.arizona.bank.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.arizonagames.feature.arizona.bank.BankDepositDisabledTime;
import com.arizonagames.feature.arizona.bank.BankDepositInfo;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
import ru.mrlargha.commonui.utils.ui.textWithIcons.IconAndSize;
import ru.mrlargha.commonui.utils.ui.textWithIcons.TextWithIconsKt;
/* compiled from: BankUiFormatter.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0000\u001a \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0000\u001a&\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\f\b\u0001\u0010\u0016\u001a\u00020\u0017:\u0002\b\u0018H\u0000\u001a\"\u0010\u0019\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\b\u0001\u0010\u0016\u001a\u00020\u0017:\u0002\b\u0018H\u0000\u001a\f\u0010\u001a\u001a\u00020\u0015*\u00020\u0004H\u0000\u001a\f\u0010\u001b\u001a\u00020\u0015*\u00020\u0004H\u0000\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0000\u001a&\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00152\f\b\u0001\u0010\u0016\u001a\u00020\u0017:\u0002\b\u0018H\u0000\u001a\u0016\u0010\u001f\u001a\u00020 2\f\b\u0001\u0010\u0016\u001a\u00020\u0017:\u0002\b\u0018H\u0002\u001a\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0000\u001a\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0017H\u0000\u001a\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0000\u001a\f\u0010+\u001a\u00020,*\u00020-H\u0000\u001a\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"BANK_TEXT_TAG_REGEX", "Lkotlin/text/Regex;", "toBankMoneyText", "", "", "context", "Landroid/content/Context;", "bindBankMoneyParts", "", "primary", "Landroid/widget/TextView;", "secondary", "tertiary", "value", "hideBankMoneyParts", "buildOpenRetirementText", "buyCost", "buildPaydayIncomeText", "paydayIncome", "buildCurrencyAmountText", "amount", "", "iconResId", "", "Landroidx/annotation/DrawableRes;", "toBankCurrencyAmountText", "toBankPlainAmountText", "toBankDollarAmountText", "toBankCurrencyAvailabilityAmountText", "buildCurrencyAvailabilityText", Constants.ScionAnalytics.PARAM_LABEL, "bankCurrencyIcon", "Lru/mrlargha/commonui/utils/ui/textWithIcons/IconAndSize;", "buildDepositStatusText", "deposit", "Lcom/arizonagames/feature/arizona/bank/BankDepositInfo;", "disabledTime", "Lcom/arizonagames/feature/arizona/bank/BankDepositDisabledTime;", "formatBankDuration", "seconds", "applyTaggedPlaceholderText", "view", "Landroid/view/View;", "isCardIssuePage", "", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "buildBankMoneyText", "BANK_CURRENCY_UNLIMITED_AVAILABILITY_THRESHOLD", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankUiFormatterKt {
    private static final long BANK_CURRENCY_UNLIMITED_AVAILABILITY_THRESHOLD = 999999;
    private static final Regex BANK_TEXT_TAG_REGEX = new Regex(":[a-z0-9_+\\-]+:");

    public static final CharSequence toBankMoneyText(long j, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildBankMoneyText(j);
    }

    public static final void bindBankMoneyParts(TextView primary, TextView secondary, TextView tertiary, long j) {
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        Intrinsics.checkNotNullParameter(tertiary, "tertiary");
        primary.setVisibility(0);
        primary.setText(toBankDollarAmountText(j));
        secondary.setVisibility(8);
        tertiary.setVisibility(8);
    }

    public static final void hideBankMoneyParts(TextView primary, TextView secondary, TextView tertiary) {
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        Intrinsics.checkNotNullParameter(tertiary, "tertiary");
        primary.setText("");
        primary.setVisibility(4);
        secondary.setVisibility(8);
        tertiary.setVisibility(8);
    }

    public static final CharSequence buildOpenRetirementText(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableStringBuilder append = new SpannableStringBuilder("ОТКРЫТЬ ЗА ").append(buildBankMoneyText(j));
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    public static final CharSequence buildPaydayIncomeText(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableStringBuilder append = new SpannableStringBuilder("Каждый PayDay Вы получаете + ").append(buildBankMoneyText(j));
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    public static final CharSequence buildCurrencyAmountText(Context context, String amount, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(amount, "amount");
        return TextWithIconsKt.toTextWithIcons("<ic>1<ic> " + amount, context, bankCurrencyIcon(i));
    }

    public static final CharSequence toBankCurrencyAmountText(long j, Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildCurrencyAmountText(context, toBankPlainAmountText(j), i);
    }

    public static final String toBankPlainAmountText(long j) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%,d", Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringsKt.replace$default(format, (char) AbstractJsonLexerKt.COMMA, ' ', false, 4, (Object) null);
    }

    public static final String toBankDollarAmountText(long j) {
        return "$ " + toBankPlainAmountText(j);
    }

    public static final String toBankCurrencyAvailabilityAmountText(long j) {
        if (j >= BANK_CURRENCY_UNLIMITED_AVAILABILITY_THRESHOLD) {
            return null;
        }
        return toBankPlainAmountText(j);
    }

    public static final CharSequence buildCurrencyAvailabilityText(Context context, String label, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(label, "label");
        return TextWithIconsKt.toTextWithIcons(label + " <ic>1<ic>", context, bankCurrencyIcon(i));
    }

    private static final IconAndSize bankCurrencyIcon(int i) {
        return new IconAndSize(i, R.dimen._10sdp, R.dimen._10sdp);
    }

    public static final String buildDepositStatusText(BankDepositInfo deposit, BankDepositDisabledTime disabledTime) {
        String formatBankDuration;
        Intrinsics.checkNotNullParameter(deposit, "deposit");
        Intrinsics.checkNotNullParameter(disabledTime, "disabledTime");
        if (deposit.getLevel() >= deposit.getMaxLevel()) {
            formatBankDuration = "макс.";
        } else {
            formatBankDuration = disabledTime.getUpgrade() > 0 ? formatBankDuration(disabledTime.getUpgrade()) : "доступно";
        }
        return "Комиссии: снять " + deposit.getPercents().getWithdraw() + "%, пополнить " + deposit.getPercents().getDeposit() + "%\nТаймеры: снять " + formatBankDuration(disabledTime.getWithdraw()) + ", пополнить " + formatBankDuration(disabledTime.getDeposit()) + ", апгрейд " + formatBankDuration + ". Уровень: " + deposit.getLevel() + '/' + deposit.getMaxLevel();
    }

    public static final String formatBankDuration(int i) {
        if (i <= 0) {
            return "доступно";
        }
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        if (i2 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public static final void applyTaggedPlaceholderText(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            CharSequence text = textView.getText();
            String obj = text != null ? text.toString() : null;
            if (obj == null) {
                obj = "";
            }
            String str = obj;
            if (BANK_TEXT_TAG_REGEX.containsMatchIn(str)) {
                textView.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str, 0.0f, null, 3, null));
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                applyTaggedPlaceholderText(childAt);
            }
        }
    }

    public static final boolean isCardIssuePage(BankPage bankPage) {
        Intrinsics.checkNotNullParameter(bankPage, "<this>");
        return bankPage == BankPage.CARD_ISSUE;
    }

    private static final CharSequence buildBankMoneyText(long j) {
        return ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, MoneyFormatter.format$default(MoneyFormatter.INSTANCE, j, false, null, null, 14, null), 0.8f, null, 2, null);
    }
}
