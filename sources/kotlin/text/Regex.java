package kotlin.text;

import com.facebook.internal.NativeProtocol;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
/* compiled from: Regex.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:B\u0015\bA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nB\u0019\bV\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\rB\u001f\bV\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0005\u0010\u0010J\u0012\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0084\u0004J\u0012\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0080\u0004J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\u0080\u0004J*\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(&J(\u0010'\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(&J\u001a\u0010(\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\tH\u0086\u0080\u0004J&\u0010(\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190+H\u0086\u0080\u0004J\u001a\u0010,\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\tH\u0086\u0080\u0004J\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0.2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u001eH\u0086\u0080\u0004J0\u00100\u001a\b\u0012\u0004\u0012\u00020\t0 2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(1J\n\u00102\u001a\u00020\tH\u0096\u0080\u0004J\n\u00103\u001a\u00020\u0004H\u0086\u0080\u0004J\n\u00104\u001a\u000205H\u0082\u0080\u0004J\u0012\u00106\u001a\u0002072\u0006\u0010\u0018\u001a\u000208H\u0082\u0080\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\t8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006;"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "nativePattern", "Ljava/util/regex/Pattern;", "<init>", "(Ljava/util/regex/Pattern;)V", "Lkotlin/PublishedApi;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getPattern", "()Ljava/lang/String;", "_options", "getOptions", "()Ljava/util/Set;", "matches", "", "input", "", "containsMatchIn", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matchAt", FirebaseAnalytics.Param.INDEX, "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.7", "matchesAt", "replace", "replacement", "transform", "Lkotlin/Function1;", "replaceFirst", "split", "", "limit", "splitToSequence", "1.6", "toString", "toPattern", "writeReplace", "", "readObject", "", "Ljava/io/ObjectInputStream;", "Serialized", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Regex implements Serializable {
    public static final Companion Companion = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern) {
        this(r2);
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern, RegexOption option) {
        this(r2);
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        Pattern compile = Pattern.compile(pattern, Companion.ensureUnicodeCase(option.getValue()));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern, Set<? extends RegexOption> options) {
        this(r2);
        int i;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(options, "options");
        Companion companion = Companion;
        i = RegexKt.toInt(options);
        Pattern compile = Pattern.compile(pattern, companion.ensureUnicodeCase(i));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
        return pattern;
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set == null) {
            final int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            Intrinsics.checkNotNull(allOf);
            CollectionsKt.retainAll(allOf, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(RegexOption regexOption) {
                    RegexOption regexOption2 = regexOption;
                    return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
                }
            });
            Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(...)");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final MatchResult find(CharSequence input, int i) {
        MatchResult findNext;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        findNext = RegexKt.findNext(matcher, i, input);
        return findNext;
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final Sequence<MatchResult> findAll(final CharSequence input, final int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (i < 0 || i > input.length()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + input.length());
        }
        return SequencesKt.generateSequence(new Function0() { // from class: kotlin.text.Regex$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MatchResult find;
                find = Regex.this.find(input, i);
                return find;
            }
        }, (Function1) Regex$findAll$2.INSTANCE);
    }

    public final MatchResult matchEntire(CharSequence input) {
        MatchResult matchEntire;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        matchEntire = RegexKt.matchEntire(matcher, input);
        return matchEntire;
    }

    public final MatchResult matchAt(CharSequence input, int i) {
        MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i, input.length());
        if (region.lookingAt()) {
            Intrinsics.checkNotNull(region);
            matcherMatchResult = new MatcherMatchResult(region, input);
        } else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }

    public final boolean matchesAt(CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        MatchResult find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i, find$default.getRange().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(input, i, length);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceFirst, "replaceFirst(...)");
        return replaceFirst;
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final List<String> split(CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(i);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList arrayList = new ArrayList(i > 0 ? RangesKt.coerceAtMost(i, 10) : 10);
        int i2 = i - 1;
        int i3 = 0;
        do {
            arrayList.add(input.subSequence(i3, matcher.start()).toString());
            i3 = matcher.end();
            if (i2 >= 0 && arrayList.size() == i2) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i3, input.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    public final Sequence<String> splitToSequence(CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(i);
        return SequencesKt.sequence(new Regex$splitToSequence$1(this, input, i, null));
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(pattern, "toString(...)");
        return pattern;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    /* compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0019\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001a\u00020\u000eH\u0082\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "<init>", "(Ljava/lang/String;I)V", "getPattern", "()Ljava/lang/String;", "getFlags", "()I", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Serialized(String pattern, int i) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            return new Regex(compile);
        }
    }

    /* compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0082\u0080\u0004¨\u0006\r"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "<init>", "()V", "fromLiteral", "Lkotlin/text/Regex;", "literal", "", "escape", "escapeReplacement", "ensureUnicodeCase", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int ensureUnicodeCase(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        private Companion() {
        }

        public final Regex fromLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }

        public final String escape(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String quote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
            return quote;
        }

        public final String escapeReplacement(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(quoteReplacement, "quoteReplacement(...)");
            return quoteReplacement;
        }
    }
}
