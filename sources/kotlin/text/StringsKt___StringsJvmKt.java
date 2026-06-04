package kotlin.text;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _StringsJvm.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u0002H\u0086\u0080\u0004\u001ac\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\t\u001a\u008a\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\u0088\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010#j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`$H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b('\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010%\u001ac\u0010(\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b()\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(*\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\t\u001a\u008a\u0001\u0010+\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\u0088\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(-\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010#j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`$H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(/\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(0\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010%\u001aN\u00101\u001a\u000202*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002020\u001dH\u0087\u0088\u0004b\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0014b\u0002\b6b\f\b7\u0012\b\b8\u0012\u0004\b\b(3b\u0002\b\u0005ø\u0001\u0000¢\u0006\u0002\b3\u001aN\u00101\u001a\u000209*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090\u001dH\u0087\u0088\u0004b\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0014b\u0002\b6b\f\b7\u0012\b\b8\u0012\u0004\b\b(:b\u0002\b\u0005ø\u0001\u0000¢\u0006\u0002\b:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"elementAt", "", "", FirebaseAnalytics.Param.INDEX, "", "Lkotlin/internal/InlineOnly;", "toSortedSet", "Ljava/util/SortedSet;", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    private static final char elementAt(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.charAt(i);
    }

    public static final SortedSet<Character> toSortedSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (SortedSet) StringsKt.toCollection(charSequence, new TreeSet());
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character max(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.maxOrNull(charSequence);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character maxWith(CharSequence charSequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.maxWithOrNull(charSequence, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character min(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.minOrNull(charSequence);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character minWith(CharSequence charSequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.minWithOrNull(charSequence, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charSequence.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charSequence.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) < 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                R invoke2 = selector.invoke(Character.valueOf(charAt2));
                if (invoke.compareTo(invoke2) > 0) {
                    charAt = charAt2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }
}
