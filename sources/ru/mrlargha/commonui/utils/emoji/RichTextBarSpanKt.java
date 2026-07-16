package ru.mrlargha.commonui.utils.emoji;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
/* compiled from: RichTextBarSpan.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0002\u001a\u000e\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0001H\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"BAR_PLACEHOLDER", "", "richTextBarRegex", "Lkotlin/text/Regex;", "richTextBarParamRegex", "withRichTextBars", "Landroid/text/SpannableString;", "toRichTextBar", "Lru/mrlargha/commonui/utils/emoji/RichTextBar;", "toIntOrZero", "", "toFloatOrZero", "", "toBarValueText", "DEFAULT_BAR_LABEL", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RichTextBarSpanKt {
    private static final String BAR_PLACEHOLDER = "￼";
    private static final String DEFAULT_BAR_LABEL = "Текущий уровень депозита";
    private static final Regex richTextBarRegex = new Regex("\\[\\[bar:([^\\]]*)\\]\\]", RegexOption.IGNORE_CASE);
    private static final Regex richTextBarParamRegex = new Regex("([A-Za-z]+)=([^,\\]]*)", RegexOption.IGNORE_CASE);

    public static final SpannableString withRichTextBars(SpannableString spannableString) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Regex regex = richTextBarRegex;
        SpannableString spannableString2 = spannableString;
        if (regex.containsMatchIn(spannableString2)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString2);
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            MatchResult find = regex.find(spannableStringBuilder2, 0);
            while (find != null) {
                RichTextBar richTextBar = toRichTextBar(find.getGroupValues().get(1));
                int first = find.getRange().getFirst();
                spannableStringBuilder.replace(first, find.getRange().getLast() + 1, (CharSequence) BAR_PLACEHOLDER);
                RichTextBarSpan richTextBarSpan = new RichTextBarSpan(richTextBar);
                int i = first + 1;
                spannableStringBuilder.setSpan(richTextBarSpan, first, i, 33);
                find = richTextBarRegex.find(spannableStringBuilder2, i);
            }
            SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder2);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        return spannableString;
    }

    private static final RichTextBar toRichTextBar(String str) {
        Sequence<MatchResult> findAll$default = Regex.findAll$default(richTextBarParamRegex, str, 0, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MatchResult matchResult : findAll$default) {
            String lowerCase = matchResult.getGroupValues().get(1).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, StringsKt.trim((CharSequence) matchResult.getGroupValues().get(2)).toString());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        int intOrZero = toIntOrZero((String) linkedHashMap.get(FirebaseAnalytics.Param.LEVEL));
        float floatOrZero = toFloatOrZero((String) linkedHashMap.get("cur"));
        float floatOrZero2 = toFloatOrZero((String) linkedHashMap.get("max"));
        String str2 = (String) linkedHashMap.get(Constants.ScionAnalytics.PARAM_LABEL);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        if (StringsKt.isBlank(str3)) {
            str3 = DEFAULT_BAR_LABEL;
        }
        return new RichTextBar(intOrZero, floatOrZero, floatOrZero2, str3);
    }

    private static final int toIntOrZero(String str) {
        Integer intOrNull;
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    private static final float toFloatOrZero(String str) {
        Float floatOrNull;
        if (str == null || (floatOrNull = StringsKt.toFloatOrNull(str)) == null) {
            return 0.0f;
        }
        return floatOrNull.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toBarValueText(float f) {
        int roundToInt = MathKt.roundToInt(f);
        if (f == roundToInt) {
            return String.valueOf(roundToInt);
        }
        return StringsKt.removeSuffix(String.valueOf(MathKt.roundToInt(f * 10.0f) / 10.0f), (CharSequence) ".0");
    }
}
