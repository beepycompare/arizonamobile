package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _SequencesJvm.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001aI\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\bb\u0002\b\n¢\u0006\u0002\u0010\t\u001a*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0086\u0080\u0004\u001a<\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0086\u0080\u0004\u001aw\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010\u0014\u001aw\u0010\u0012\u001a\u0004\u0018\u00010'*\b\u0012\u0004\u0012\u00020'0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010(\u001ay\u0010\u0012\u001a\u0004\u0018\u0001H\r\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010)\u001a\u0096\u0001\u0010*\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020,H\u0087\u0088\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(.\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(/\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u008b\u0001\u00100\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u00101\u001aw\u00104\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010\u0014\u001aw\u00104\u001a\u0004\u0018\u00010'*\b\u0012\u0004\u0012\u00020'0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010(\u001ay\u00104\u001a\u0004\u0018\u0001H\r\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010)\u001a\u0096\u0001\u00107\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020,H\u0087\u0088\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u008b\u0001\u0010:\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(;\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(<\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u00101\u001aZ\u0010=\u001a\u00020>\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020>0,H\u0087\u0088\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001fb\u0002\b@b\f\bA\u0012\b\bB\u0012\u0004\b\b(?b\u0002\bCø\u0001\u0000¢\u0006\u0002\b?\u001aZ\u0010=\u001a\u00020D\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020D0,H\u0087\u0088\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001fb\u0002\b@b\f\bA\u0012\b\bB\u0012\u0004\b\b(Eb\u0002\bCø\u0001\u0000¢\u0006\u0002\bE\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", FirebaseAnalytics.Param.DESTINATION, "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "Lkotlin/IgnorableReturnValue;", "toSortedSet", "Ljava/util/SortedSet;", ExifInterface.GPS_DIRECTION_TRUE, "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "maxBy", "selector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/internal/InlineOnly;", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes5.dex */
public class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public static final <R> Sequence<R> filterIsInstance(Sequence<?> sequence, final Class<R> klass) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Sequence<R> filter = SequencesKt.filter(sequence, new Function1() { // from class: kotlin.sequences.SequencesKt___SequencesJvmKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean isInstance;
                isInstance = klass.isInstance(obj);
                return Boolean.valueOf(isInstance);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return filter;
    }

    @IgnorableReturnValue
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> sequence, C destination, Class<R> klass) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : sequence) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max  reason: collision with other method in class */
    public static final /* synthetic */ Double m11233max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.maxOrNull((Sequence<? extends Double>) sequence);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max  reason: collision with other method in class */
    public static final /* synthetic */ Float m11234max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.maxOrNull((Sequence<? extends Float>) sequence);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.maxOrNull((Sequence<? extends Comparable>) sequence);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object maxWith(Sequence sequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt.maxWithOrNull(sequence, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min  reason: collision with other method in class */
    public static final /* synthetic */ Double m11235min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.minOrNull((Sequence<? extends Double>) sequence);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min  reason: collision with other method in class */
    public static final /* synthetic */ Float m11236min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.minOrNull((Sequence<? extends Float>) sequence);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.minOrNull((Sequence<? extends Comparable>) sequence);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object minWith(Sequence sequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt.minWithOrNull(sequence, comparator);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Sequence<? extends T> sequence, Function1<? super T, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke((T) it.next()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(Sequence<? extends T> sequence, Function1<? super T, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke((T) it.next()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        T t;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(next);
                T t2 = next;
                do {
                    T next2 = it.next();
                    R invoke2 = selector.invoke(next2);
                    t = t2;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        t = next2;
                    }
                    t2 = t;
                } while (it.hasNext());
                return t;
            }
            return next;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        T t;
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(next);
                T t2 = next;
                do {
                    T next2 = it.next();
                    R invoke2 = selector.invoke(next2);
                    t = t2;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        t = next2;
                    }
                    t2 = t;
                } while (it.hasNext());
                return t;
            }
            return next;
        }
        return null;
    }
}
