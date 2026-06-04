package kotlin.text;

import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\f\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\r\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\u000e\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u0006*\u00020\u0002H\u0086\u0080\u0004\u001a\u0012\u0010\u0010\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u0010\u0011\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001aV\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001a\u0012\u0002\b\fb\u0016\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0002\b\u0007\u001a \u0010 \u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a \u0010#\u001a\u00020$*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a$\u0010#\u001a\u00020$*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0087\u0080\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u001aV\u0010'\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b((\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b()\u0012\u0006\b\u001a\u0012\u0002\b\fb\u0016\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0002\b\u0007\u001a \u0010*\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a \u0010+\u001a\u00020$*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a$\u0010+\u001a\u00020$*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0087\u0080\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u001a\u0012\u0010,\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001aV\u0010-\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(/\u0012\u0006\b\u001a\u0012\u0002\b\fb\u0016\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0002\b\u0007\u001a \u00100\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001db\u0002\b\u0007\u001a$\u00101\u001a\u00020$*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0087\u0080\u0004b\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u001a\u0012\u00106\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u0012\u00107\u001a\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a\u001a\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u000209H\u0080\u0080\u0004\u001a\u001a\u0010<\u001a\u0002092\u0006\u0010;\u001a\u000209H\u0081\u0080\bb\u0002\b=b\u0002\b>\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u00102\u001a\u000203*\u00020\u00028FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006?"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "isDefined", "", "Lkotlin/internal/InlineOnly;", "isLetter", "isLetterOrDigit", "isDigit", "isIdentifierIgnorable", "isISOControl", "isJavaIdentifierPart", "isJavaIdentifierStart", "isWhitespace", "isUpperCase", "isLowerCase", "toUpperCase", "Lkotlin/Deprecated;", "message", "Use uppercaseChar() instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "uppercaseChar()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.5", "errorSince", "2.1", "uppercaseChar", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "uppercase", "", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "toLowerCase", "Use lowercaseChar() instead.", "lowercaseChar()", "lowercaseChar", "lowercase", "isTitleCase", "toTitleCase", "Use titlecaseChar() instead.", "titlecaseChar()", "titlecaseChar", "titlecase", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "isHighSurrogate", "isLowSurrogate", "digitOf", "", "char", "radix", "checkRadix", "Lkotlin/PublishedApi;", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/text/CharsKt")
/* loaded from: classes5.dex */
public class CharsKt__CharJVMKt {
    public static final CharCategory getCategory(char c) {
        return CharCategory.Companion.valueOf(Character.getType(c));
    }

    private static final boolean isDefined(char c) {
        return Character.isDefined(c);
    }

    private static final boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    private static final boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static final boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static final boolean isIdentifierIgnorable(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    private static final boolean isISOControl(char c) {
        return Character.isISOControl(c);
    }

    private static final boolean isJavaIdentifierPart(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    private static final boolean isJavaIdentifierStart(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    private static final boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    private static final boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    private static final char uppercaseChar(char c) {
        return Character.toUpperCase(c);
    }

    private static final String uppercase(char c) {
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static final String uppercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    private static final char lowercaseChar(char c) {
        return Character.toLowerCase(c);
    }

    private static final String lowercase(char c) {
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String lowercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final boolean isTitleCase(char c) {
        return Character.isTitleCase(c);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toTitleCase(char c) {
        return Character.toTitleCase(c);
    }

    private static final char titlecaseChar(char c) {
        return Character.toTitleCase(c);
    }

    public static final String titlecase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String uppercase = CharsKt.uppercase(c, locale);
        if (uppercase.length() <= 1) {
            String valueOf = String.valueOf(c);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(uppercase, upperCase)) {
                return String.valueOf(Character.toTitleCase(c));
            }
        } else if (c != 329) {
            char charAt = uppercase.charAt(0);
            Intrinsics.checkNotNull(uppercase, "null cannot be cast to non-null type java.lang.String");
            String substring = uppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return charAt + lowerCase;
        }
        return uppercase;
    }

    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(c));
    }

    private static final boolean isHighSurrogate(char c) {
        return Character.isHighSurrogate(c);
    }

    private static final boolean isLowSurrogate(char c) {
        return Character.isLowSurrogate(c);
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    @IgnorableReturnValue
    public static final int checkRadix(int i) {
        if (2 > i || i >= 37) {
            throw new IllegalArgumentException("radix " + i + " was not in valid range " + new IntRange(2, 36));
        }
        return i;
    }
}
