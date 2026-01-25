package ru.mrlargha.commonui.utils.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
/* compiled from: DecodeEmoji.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"unicodeEmojiRegex", "Lkotlin/text/Regex;", "decodeUnicodeEmojiPlaceholders", "", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DecodeEmojiKt {
    private static final Regex unicodeEmojiRegex = new Regex(":u([0-9a-fA-F]{4,6}):");

    public static final String decodeUnicodeEmojiPlaceholders(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return unicodeEmojiRegex.replace(str, new Function1() { // from class: ru.mrlargha.commonui.utils.ui.DecodeEmojiKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence decodeUnicodeEmojiPlaceholders$lambda$0;
                decodeUnicodeEmojiPlaceholders$lambda$0 = DecodeEmojiKt.decodeUnicodeEmojiPlaceholders$lambda$0((MatchResult) obj);
                return decodeUnicodeEmojiPlaceholders$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence decodeUnicodeEmojiPlaceholders$lambda$0(MatchResult m) {
        Intrinsics.checkNotNullParameter(m, "m");
        char[] chars = Character.toChars(Integer.parseInt(m.getGroupValues().get(1), CharsKt.checkRadix(16)));
        Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
        return new String(chars);
    }
}
