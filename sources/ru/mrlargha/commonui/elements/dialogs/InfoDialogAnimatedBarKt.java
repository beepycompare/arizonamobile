package ru.mrlargha.commonui.elements.dialogs;

import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
/* compiled from: InfoDialogAnimatedBar.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"parseInfoDialogAnimatedBar", "Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBarContent;", "source", "", "INFO_DIALOG_ANIMATED_BAR_REGEX", "Lkotlin/text/Regex;", "INFO_DIALOG_ANIMATED_BAR_PARAM_REGEX", "PARAM_LABEL", "PARAM_DURATION", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InfoDialogAnimatedBarKt {
    private static final String PARAM_DURATION = "duration";
    private static final String PARAM_LABEL = "label";
    private static final Regex INFO_DIALOG_ANIMATED_BAR_REGEX = new Regex("\\[\\[\\s*barAnim\\s*:\\s*([^\\]]*)]]", RegexOption.IGNORE_CASE);
    private static final Regex INFO_DIALOG_ANIMATED_BAR_PARAM_REGEX = new Regex("([A-Za-z]+)\\s*=\\s*([^,\\]]*)", RegexOption.IGNORE_CASE);

    public static final InfoDialogAnimatedBarContent parseInfoDialogAnimatedBar(String source) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(source, "source");
        String str = source;
        MatchResult find$default = Regex.find$default(INFO_DIALOG_ANIMATED_BAR_REGEX, str, 0, 2, null);
        if (find$default == null) {
            return new InfoDialogAnimatedBarContent(source, null);
        }
        Sequence<MatchResult> findAll$default = Regex.findAll$default(INFO_DIALOG_ANIMATED_BAR_PARAM_REGEX, find$default.getGroupValues().get(1), 0, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MatchResult matchResult : findAll$default) {
            String lowerCase = matchResult.getGroupValues().get(1).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, StringsKt.trim((CharSequence) matchResult.getGroupValues().get(2)).toString());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String str2 = (String) linkedHashMap.get("duration");
        if (str2 != null && (longOrNull = StringsKt.toLongOrNull(str2)) != null) {
            if (longOrNull.longValue() <= 0) {
                longOrNull = null;
            }
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                String obj = StringsKt.trim((CharSequence) StringsKt.removeRange((CharSequence) str, find$default.getRange()).toString()).toString();
                String str3 = (String) linkedHashMap.get("label");
                if (str3 == null) {
                    str3 = "";
                }
                return new InfoDialogAnimatedBarContent(obj, new InfoDialogAnimatedBar(str3, longValue));
            }
        }
        return new InfoDialogAnimatedBarContent(source, null);
    }
}
