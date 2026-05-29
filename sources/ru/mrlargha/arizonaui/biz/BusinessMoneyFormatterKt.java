package ru.mrlargha.arizonaui.biz;

import android.text.SpannableString;
import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: BusinessMoneyFormatter.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002\u001a\f\u0010\r\u001a\u00020\n*\u00020\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"NON_BREAKING_SPACE", "", "MONEY_PATTERN", "Lkotlin/text/Regex;", "toBusinessMoneySpannable", "Landroid/text/SpannableString;", "", "toBusinessCashSpannable", "", "toBusinessMoneyAmount", "", "normalizeBusinessMoneyText", "text", "withNonBreakingSpaces", "business"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BusinessMoneyFormatterKt {
    private static final Regex MONEY_PATTERN = new Regex("(?i)(:cash:|\\$)\\s*([+-]?[0-9](?:[0-9.,\\s]*[0-9])?)");
    private static final char NON_BREAKING_SPACE = 160;

    public static final SpannableString toBusinessMoneySpannable(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeBusinessMoneyText(charSequence.toString()), 0.8f, null, 2, null);
    }

    public static final SpannableString toBusinessCashSpannable(long j) {
        return ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, ":cash: " + toBusinessMoneyAmount(j), 0.8f, null, 2, null);
    }

    public static final String toBusinessMoneyAmount(long j) {
        long abs = j == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(j);
        return (j < 0 ? Constants.FILENAME_SEQUENCE_SEPARATOR : "") + withNonBreakingSpaces(MoneyFormatter.INSTANCE.formatPlain(abs));
    }

    private static final String normalizeBusinessMoneyText(String str) {
        return MONEY_PATTERN.replace(str, new Function1() { // from class: ru.mrlargha.arizonaui.biz.BusinessMoneyFormatterKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BusinessMoneyFormatterKt.normalizeBusinessMoneyText$lambda$0((MatchResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence normalizeBusinessMoneyText$lambda$0(MatchResult result) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(result, "result");
        String obj = StringsKt.trim((CharSequence) result.getGroupValues().get(2)).toString();
        Character firstOrNull = StringsKt.firstOrNull(obj);
        String str = null;
        if (firstOrNull != null) {
            char charValue = firstOrNull.charValue();
            if (charValue != '+' && charValue != '-') {
                firstOrNull = null;
            }
            if (firstOrNull != null) {
                str = String.valueOf(firstOrNull.charValue());
            }
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        int length = obj.length();
        for (int i = 0; i < length; i++) {
            char charAt = obj.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        if (StringsKt.toLongOrNull(sb.toString()) == null) {
            return result.getValue();
        }
        return ":cash: " + str + withNonBreakingSpaces(MoneyFormatter.INSTANCE.formatPlain(longOrNull.longValue()));
    }

    private static final String withNonBreakingSpaces(String str) {
        return StringsKt.replace$default(str, ' ', (char) 160, false, 4, (Object) null);
    }
}
