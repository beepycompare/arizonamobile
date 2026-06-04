package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RegexExtensionsJVM.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0003¨\u0006\u0004"}, d2 = {"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
class StringsKt__RegexExtensionsJVMKt extends StringsKt__IndentKt {
    private static final Regex toRegex(Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "<this>");
        return new Regex(pattern);
    }
}
