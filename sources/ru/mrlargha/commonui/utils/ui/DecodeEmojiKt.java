package ru.mrlargha.commonui.utils.ui;

import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: DecodeEmoji.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0005\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006*\u00020\u0005H\u0002¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"unicodeEmojiRegex", "Lkotlin/text/Regex;", "namedEmojiRegex", "namedEmojiAliases", "", "", "", "decodeUnicodeEmojiPlaceholders", "resolveNamedEmojiCodePoint", "(Ljava/lang/String;)Ljava/lang/Integer;", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DecodeEmojiKt {
    private static final Regex unicodeEmojiRegex = new Regex(":u([0-9a-fA-F]{4,6}):?");
    private static final Regex namedEmojiRegex = new Regex("(:{1,4})([A-Za-z][A-Za-z0-9_-]{1,32})\\1");
    private static final Map<String, Integer> namedEmojiAliases = MapsKt.mapOf(TuplesKt.to("angel", 128519), TuplesKt.to("beaming", 128513), TuplesKt.to("beamingsmile", 128513), TuplesKt.to("blushhappy", 128522), TuplesKt.to("blushsmile", 128522), TuplesKt.to("blushlove", 129392), TuplesKt.to("cleargrinning", 128515), TuplesKt.to("cool", 128526), TuplesKt.to("crazylove", 128525), TuplesKt.to("devil", 128520), TuplesKt.to("grinningwithbigeyes", 128515), TuplesKt.to("grinningwithsmilingeyes", 128516), TuplesKt.to("grinningwithsweat", 128517), TuplesKt.to("grinningsquinting", 128518), TuplesKt.to("laugh", 128518), TuplesKt.to("laughing", 129315), TuplesKt.to("laughsweat", 128517), TuplesKt.to("rofl", 129315), TuplesKt.to("rollingonfloorlaughing", 129315), TuplesKt.to("melting", 129760), TuplesKt.to("shushing", 129323), TuplesKt.to("slightlysmile", 128578), TuplesKt.to("slightlysmiling", 128578), TuplesKt.to("smile", 128516), TuplesKt.to("smile2", 128515), TuplesKt.to("smile3", 128512), TuplesKt.to("smilewithtear", 129394), TuplesKt.to("tearsofjoy", 128514), TuplesKt.to("upsidedownsmile", 128579), TuplesKt.to("upsidedown", 128579), TuplesKt.to("winking", 128521), TuplesKt.to("winkingwithtongue", 128540));

    public static final String decodeUnicodeEmojiPlaceholders(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return namedEmojiRegex.replace(unicodeEmojiRegex.replace(str, new Function1() { // from class: ru.mrlargha.commonui.utils.ui.DecodeEmojiKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecodeEmojiKt.decodeUnicodeEmojiPlaceholders$lambda$0((MatchResult) obj);
            }
        }), new Function1() { // from class: ru.mrlargha.commonui.utils.ui.DecodeEmojiKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DecodeEmojiKt.decodeUnicodeEmojiPlaceholders$lambda$1((MatchResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence decodeUnicodeEmojiPlaceholders$lambda$0(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        char[] chars = Character.toChars(Integer.parseInt(m.getGroupValues().get(1), CharsKt.checkRadix(16)));
        Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
        return new String(chars);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence decodeUnicodeEmojiPlaceholders$lambda$1(MatchResult match) {
        Intrinsics.checkNotNullParameter(match, "match");
        Integer resolveNamedEmojiCodePoint = resolveNamedEmojiCodePoint(match.getGroupValues().get(2));
        if (resolveNamedEmojiCodePoint != null) {
            char[] chars = Character.toChars(resolveNamedEmojiCodePoint.intValue());
            Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
            return new String(chars);
        }
        return match.getValue();
    }

    private static final Integer resolveNamedEmojiCodePoint(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (charAt != '_' && charAt != '-') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        String lowerCase2 = new Regex("([a-z0-9])([A-Z])").replace(str, "$1_$2").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        Integer num = namedEmojiAliases.get(sb2);
        if (num == null) {
            Integer num2 = ChatEmoji.INSTANCE.getNamedTags().get(lowerCase);
            if (num2 == null) {
                Integer num3 = ChatEmoji.INSTANCE.getNamedTags().get(lowerCase2);
                return num3 == null ? ChatEmoji.INSTANCE.getNamedTags().get(sb2) : num3;
            }
            return num2;
        }
        return num;
    }
}
