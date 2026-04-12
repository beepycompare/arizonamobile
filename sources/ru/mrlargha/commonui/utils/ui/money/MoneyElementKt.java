package ru.mrlargha.commonui.utils.ui.money;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"toMoneyFormattedSpannable", "Landroid/text/SpannableString;", "", "isInvert", "", "prefix", "", "postfix", "toMoneyShortFormattedSpannable", "toLong", "Lru/mrlargha/commonui/utils/ui/money/MoneyParts;", "resize", "", "size", "", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MoneyElementKt {
    public static /* synthetic */ SpannableString toMoneyFormattedSpannable$default(long j, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        return toMoneyFormattedSpannable(j, z, str, str2);
    }

    public static final SpannableString toMoneyFormattedSpannable(long j, boolean z, String prefix, String postfix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return ChatEmoji.INSTANCE.toSpannable(MoneyFormatter.INSTANCE.format(j, z, prefix, postfix), 0.8f);
    }

    public static final SpannableString toMoneyShortFormattedSpannable(long j) {
        return ChatEmoji.INSTANCE.toSpannable(MoneyFormatter.formatMoneyShort$default(MoneyFormatter.INSTANCE, j, null, 2, null), 0.76f);
    }

    public static final long toLong(MoneyParts moneyParts) {
        Intrinsics.checkNotNullParameter(moneyParts, "<this>");
        return (RangesKt.coerceAtLeast(moneyParts.getM(), 0) * C.NANOS_PER_SECOND) + (RangesKt.coerceAtMost(RangesKt.coerceAtLeast(moneyParts.getKk(), 0), 999) * 1000000) + RangesKt.coerceAtMost(RangesKt.coerceAtLeast(moneyParts.getK(), 0), 999999);
    }

    public static final SpannableString resize(CharSequence charSequence, float f) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new RelativeSizeSpan(f), 0, spannableString.length(), 33);
        return spannableString;
    }
}
