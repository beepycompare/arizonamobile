package ru.mrlargha.commonui.utils.ui;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: utils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001aA\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"textChanges", "Lkotlinx/coroutines/flow/Flow;", "", "Landroid/widget/EditText;", "SPAN_REGEX", "Lkotlin/text/Regex;", "buildSpannableList", "Landroid/text/SpannableString;", "rawList", "", "textColor", "", TtmlNode.BOLD, "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "roundedBadge", "(Ljava/util/List;IZLjava/lang/Integer;Z)Landroid/text/SpannableString;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    private static final Regex SPAN_REGEX = new Regex("<span>(.*?)</span>", RegexOption.IGNORE_CASE);

    public static final Flow<String> textChanges(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        return FlowKt.callbackFlow(new UtilsKt$textChanges$1(editText, null));
    }

    public static /* synthetic */ SpannableString buildSpannableList$default(List list, int i, boolean z, Integer num, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            num = null;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        return buildSpannableList(list, i, z, num, z2);
    }

    public static final SpannableString buildSpannableList(List<String> rawList, int i, boolean z, Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(rawList, "rawList");
        StringBuilder sb = new StringBuilder();
        ArrayList<SpanRange> arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : rawList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            sb.append("● ");
            sb.length();
            String str2 = str;
            int i4 = 0;
            for (MatchResult matchResult : Regex.findAll$default(SPAN_REGEX, str2, 0, 2, null)) {
                sb.append((CharSequence) str2, i4, matchResult.getRange().getFirst());
                int length = sb.length();
                sb.append(matchResult.getGroupValues().get(1));
                arrayList.add(new SpanRange(length, sb.length()));
                i4 = matchResult.getRange().getLast() + 1;
            }
            if (i4 < str.length()) {
                String substring = str.substring(i4);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                sb.append(substring);
            }
            if (i2 < CollectionsKt.getLastIndex(rawList)) {
                sb.append("\n");
            }
            sb.length();
            i2 = i3;
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        for (SpanRange spanRange : arrayList) {
            int component1 = spanRange.component1();
            int component2 = spanRange.component2();
            spannableString.setSpan(new ForegroundColorSpan(i), component1, component2, 33);
            if (z) {
                spannableString.setSpan(new StyleSpan(1), component1, component2, 33);
            }
            if (z2) {
                spannableString.setSpan(new RoundedBackgroundSpan(num != null ? num.intValue() : 0, i, 0.0f, 0.0f, 0.0f, 28, null), component1, component2, 33);
            } else if (num != null) {
                spannableString.setSpan(new BackgroundColorSpan(num.intValue()), component1, component2, 33);
            }
        }
        return spannableString;
    }
}
