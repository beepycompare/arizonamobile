package ru.mrlargha.commonui.utils.ui.textWithIcons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: textWithIcons.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"toTextWithIcons", "Landroid/text/SpannableString;", "", "context", "Landroid/content/Context;", "icons", "", "Lru/mrlargha/commonui/utils/ui/textWithIcons/IconAndSize;", "(Ljava/lang/CharSequence;Landroid/content/Context;[Lru/mrlargha/commonui/utils/ui/textWithIcons/IconAndSize;)Landroid/text/SpannableString;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TextWithIconsKt {
    public static final SpannableString toTextWithIcons(CharSequence charSequence, Context context, IconAndSize... icons) {
        int length;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(icons, "icons");
        String obj = charSequence.toString();
        Regex regex = new Regex("<ic>(\\d+)<ic>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i = 0;
        for (MatchResult matchResult : Regex.findAll$default(regex, obj, 0, 2, null)) {
            int first = matchResult.getRange().getFirst() - i;
            int last = (matchResult.getRange().getLast() + 1) - i;
            Integer intOrNull = StringsKt.toIntOrNull(matchResult.getGroupValues().get(1));
            Integer valueOf = intOrNull != null ? Integer.valueOf(intOrNull.intValue() - 1) : null;
            IconAndSize iconAndSize = valueOf != null ? (IconAndSize) ArraysKt.getOrNull(icons, valueOf.intValue()) : null;
            if (iconAndSize != null) {
                Drawable drawable = AppCompatResources.getDrawable(context, iconAndSize.getIcon());
                if (drawable != null) {
                    drawable.setBounds(0, 0, context.getResources().getDimensionPixelSize(iconAndSize.getWidthSdpRes()), context.getResources().getDimensionPixelSize(iconAndSize.getHeightSpdRes()));
                    spannableStringBuilder.replace(first, last, (CharSequence) "￼");
                    spannableStringBuilder.setSpan(new CenteredImageSpan(drawable), first, first + 1, 33);
                    length = matchResult.getValue().length() - 1;
                } else {
                    spannableStringBuilder.delete(first, last);
                    length = matchResult.getValue().length();
                }
                i += length;
            }
        }
        SpannableString valueOf2 = SpannableString.valueOf(spannableStringBuilder);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
        return valueOf2;
    }
}
