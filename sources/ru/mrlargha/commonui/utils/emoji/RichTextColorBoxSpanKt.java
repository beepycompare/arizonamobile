package ru.mrlargha.commonui.utils.emoji;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
/* compiled from: RichTextColorBoxSpan.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"COLOR_BOX_PLACEHOLDER", "", "richTextColorBoxRegex", "Lkotlin/text/Regex;", "richTextColorBoxParamRegex", "withRichTextColorBoxes", "Landroid/text/SpannableString;", "parseRichTextColorBox", "Lru/mrlargha/commonui/utils/emoji/RichTextColorBox;", "paramsSource", "calculateLuma", "", "isHexDigit", "", "", "PARAM_HEX", "PARAM_LABEL", "DEFAULT_HEX", "HEX_LENGTH", "", "HEX_RADIX", "DARK_TEXT_LUMA_THRESHOLD", "RED_LUMA_WEIGHT", "GREEN_LUMA_WEIGHT", "BLUE_LUMA_WEIGHT", "MIN_WIDTH_RATIO", "", "HORIZONTAL_PADDING_RATIO", "HEIGHT_RATIO", "INLINE_GAP_RATIO", "CORNER_RADIUS_RATIO", "STROKE_WIDTH_RATIO", "FRAMED_BORDER_COLOR", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RichTextColorBoxSpanKt {
    private static final double BLUE_LUMA_WEIGHT = 0.114d;
    private static final String COLOR_BOX_PLACEHOLDER = "￼";
    private static final float CORNER_RADIUS_RATIO = 0.85f;
    private static final double DARK_TEXT_LUMA_THRESHOLD = 140.0d;
    private static final String DEFAULT_HEX = "ffffff";
    private static final String FRAMED_BORDER_COLOR = "#55B4C4CD";
    private static final double GREEN_LUMA_WEIGHT = 0.587d;
    private static final float HEIGHT_RATIO = 2.7f;
    private static final int HEX_LENGTH = 6;
    private static final int HEX_RADIX = 16;
    private static final float HORIZONTAL_PADDING_RATIO = 3.8f;
    private static final float INLINE_GAP_RATIO = 0.55f;
    private static final float MIN_WIDTH_RATIO = 7.5f;
    private static final String PARAM_HEX = "hex";
    private static final String PARAM_LABEL = "label";
    private static final double RED_LUMA_WEIGHT = 0.299d;
    private static final float STROKE_WIDTH_RATIO = 0.14f;
    private static final Regex richTextColorBoxRegex = new Regex("\\[\\[\\s*colorbox\\s*:\\s*([^\\]]*)]]", RegexOption.IGNORE_CASE);
    private static final Regex richTextColorBoxParamRegex = new Regex("([A-Za-z]+)\\s*=\\s*(.*?)(?=,\\s*[A-Za-z]+\\s*=|$)", SetsKt.setOf((Object[]) new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL}));

    private static final boolean isHexDigit(char c) {
        if ('0' > c || c >= ':') {
            if ('a' > c || c >= 'g') {
                return 'A' <= c && c < 'G';
            }
            return true;
        }
        return true;
    }

    public static final SpannableString withRichTextColorBoxes(SpannableString spannableString) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Regex regex = richTextColorBoxRegex;
        SpannableString spannableString2 = spannableString;
        if (regex.containsMatchIn(spannableString2)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString2);
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            MatchResult find = regex.find(spannableStringBuilder2, 0);
            while (find != null) {
                RichTextColorBox parseRichTextColorBox = parseRichTextColorBox(find.getGroupValues().get(1));
                int first = find.getRange().getFirst();
                spannableStringBuilder.replace(first, find.getRange().getLast() + 1, (CharSequence) COLOR_BOX_PLACEHOLDER);
                RichTextColorBoxSpan richTextColorBoxSpan = new RichTextColorBoxSpan(parseRichTextColorBox);
                int i = first + 1;
                spannableStringBuilder.setSpan(richTextColorBoxSpan, first, i, 33);
                find = richTextColorBoxRegex.find(spannableStringBuilder2, i);
            }
            SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder2);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        return spannableString;
    }

    public static final RichTextColorBox parseRichTextColorBox(String paramsSource) {
        Intrinsics.checkNotNullParameter(paramsSource, "paramsSource");
        String str = null;
        Sequence<MatchResult> findAll$default = Regex.findAll$default(richTextColorBoxParamRegex, paramsSource, 0, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MatchResult matchResult : findAll$default) {
            String lowerCase = matchResult.getGroupValues().get(1).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, StringsKt.trim((CharSequence) matchResult.getGroupValues().get(2)).toString());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Object obj = linkedHashMap.get(PARAM_HEX);
        String str2 = (String) obj;
        if (str2 != null && str2.length() != 0) {
            str = obj;
        }
        String str3 = str;
        if (str3 == null) {
            str3 = DEFAULT_HEX;
        }
        String str4 = str3;
        StringBuilder sb = new StringBuilder();
        int length = str4.length();
        for (int i = 0; i < length; i++) {
            char charAt = str4.charAt(i);
            if (isHexDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String take = StringsKt.take(StringsKt.padStart(sb.toString(), 6, '0'), 6);
        String str5 = (String) linkedHashMap.get("label");
        if (str5 == null) {
            str5 = "";
        }
        return new RichTextColorBox(take, str5, calculateLuma(take) > DARK_TEXT_LUMA_THRESHOLD);
    }

    private static final double calculateLuma(String str) {
        String substring = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
        String substring2 = str.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        int parseInt2 = Integer.parseInt(substring2, CharsKt.checkRadix(16));
        String substring3 = str.substring(4, 6);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        return (parseInt * RED_LUMA_WEIGHT) + (parseInt2 * GREEN_LUMA_WEIGHT) + (Integer.parseInt(substring3, CharsKt.checkRadix(16)) * BLUE_LUMA_WEIGHT);
    }
}
