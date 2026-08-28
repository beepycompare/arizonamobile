package kotlin.time;

import androidx.collection.SieveCacheKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0090\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0090\u0001B+\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\b\t\u0012\u0006\b\n0\n8\u000b¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0015J\u0011\u0010\u001c\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b(\u0010!J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b+\u0010,J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b+\u0010.J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b0\u0010,J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b0\u0010.J\u0019\u0010/\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0019H\u0080\u0080\u0004¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b8\u0010\u0015J\u0011\u00109\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b:\u0010\u0015J\u0011\u0010;\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010\u0015J\u0011\u0010=\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b>\u0010\u0015J\u0019\u0010A\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\bB\u0010CJ\u009e\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010PJ\u0089\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010RJt\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010TJ_\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010VJ\u0019\u0010e\u001a\u00020-2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bf\u0010gJ\u0019\u0010h\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bi\u00106J\u0019\u0010j\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bk\u0010lJ\u0011\u0010{\u001a\u00020|H\u0096\u0080\u0004¢\u0006\u0004\b}\u0010~JJ\u0010\u007f\u001a\u00030\u0080\u0001*\b0\u0081\u0001j\u0003`\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u000f2\u0007\u0010\u0084\u0001\u001a\u00020\u000f2\u0007\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u00104\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J%\u0010{\u001a\u00020|2\u0006\u00104\u001a\u00020\u00192\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000fH\u0086\u0080\u0004¢\u0006\u0005\b}\u0010\u008a\u0001J\u0013\u0010\u008b\u0001\u001a\u00020|H\u0086\u0080\u0004¢\u0006\u0005\b\u008c\u0001\u0010~J\u0016\u0010\u008d\u0001\u001a\u00020\u00132\t\u0010\u001f\u001a\u0005\u0018\u00010\u008e\u0001HÖ\u0083\u0004J\u000b\u0010\u008f\u0001\u001a\u00020\u000fHÖ\u0081\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u00020\u00038BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000f8Â\u0002X\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010?\u001a\u00020\u00008FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010\u0005R\u001f\u0010W\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0011R\u001f\u0010\\\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b]\u0010Y\u001a\u0004\b^\u0010\u0011R\u001f\u0010_\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b`\u0010Y\u001a\u0004\ba\u0010\u0011R\u001f\u0010b\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bc\u0010Y\u001a\u0004\bd\u0010\u0011R\u0015\u0010m\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0015\u0010o\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bp\u0010\u0005R\u0015\u0010q\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\br\u0010\u0005R\u0015\u0010s\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bt\u0010\u0005R\u0015\u0010u\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bv\u0010\u0005R\u0015\u0010w\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bx\u0010\u0005R\u0015\u0010y\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bz\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\u000f\b\u0092\u0001\u0012\n\b\u0093\u0001\u0012\u0005\b\b(\u0094\u0001Ê\u0001\u0003\b\u0095\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0091\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "Lkotlin/Deprecated;", "message", "Don't call this constructor directly.", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "ERROR", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", TtmlNode.TAG_DIV, "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "Lkotlin/PublishedApi;", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.6", "Lkotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m11297constructorimpl(0);
    private static final long INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    public static final long INVALID_RAW_VALUE = 9223372036854759646L;
    private static final long INVALID = m11297constructorimpl(INVALID_RAW_VALUE);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m11295boximpl(long j) {
        return new Duration(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Don't call this constructor directly.")
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m11297constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m11301equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m11343unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m11302equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getUnitDiscriminator-impl  reason: not valid java name */
    private static final int m11316getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getValue-impl  reason: not valid java name */
    public static final long m11317getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m11318hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m11320isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isInNanos-impl  reason: not valid java name */
    public static final boolean m11321isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m11323isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m11324isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object obj) {
        return m11301equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m11318hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m11343unboximpl() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m11342compareToLRDsOJo(duration.m11343unboximpl());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Don't call this constructor directly.")
    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final DurationUnit m11315getStorageUnitimpl(long j) {
        return m11321isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0087\u0080\u0004b\u0002\b\u001dJ\u0019\u0010:\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b?\u0010=J\u0019\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bAJ\u0019\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bCR\u001d\u0010\n\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u000f\u0010\u0013\u001a\u00020\u0007X\u0080Ô\b¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\rR$\u0010\u001e\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010\u001e\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010%\u001a\u0004\b\"\u0010\tR$\u0010\u001e\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010&\u001a\u0004\b\"\u0010'R$\u0010(\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010#R$\u0010(\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b*\u0010\tR$\u0010(\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010'R$\u0010+\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#R$\u0010+\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010\tR$\u0010+\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010&\u001a\u0004\b-\u0010'R$\u0010.\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010#R$\u0010.\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010%\u001a\u0004\b0\u0010\tR$\u0010.\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010&\u001a\u0004\b0\u0010'R$\u00101\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010!\u001a\u0004\b3\u0010#R$\u00101\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010%\u001a\u0004\b3\u0010\tR$\u00101\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010&\u001a\u0004\b3\u0010'R$\u00104\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010!\u001a\u0004\b6\u0010#R$\u00104\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b6\u0010\tR$\u00104\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010&\u001a\u0004\b6\u0010'R$\u00107\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010!\u001a\u0004\b9\u0010#R$\u00107\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010%\u001a\u0004\b9\u0010\tR$\u00107\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010&\u001a\u0004\b9\u0010'¨\u0006D"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "fromRawValue", "Lkotlin/time/Duration;", "rawValue", "", "fromRawValue-UwyO8pc$kotlin_stdlib", "(J)J", "ZERO", "getZERO-UwyO8pc$annotations", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "INVALID_RAW_VALUE", "INVALID", "getINVALID-UwyO8pc$kotlin_stdlib$annotations", "getINVALID-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "Lkotlin/time/ExperimentalTime;", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "Lkotlin/internal/InlineOnly;", "(J)V", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11347getDaysUwyO8pc$annotations(double d) {
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11348getDaysUwyO8pc$annotations(int i) {
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11349getDaysUwyO8pc$annotations(long j) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11353getHoursUwyO8pc$annotations(double d) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11354getHoursUwyO8pc$annotations(int i) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11355getHoursUwyO8pc$annotations(long j) {
        }

        /* renamed from: getINVALID-UwyO8pc$kotlin_stdlib$annotations  reason: not valid java name */
        public static /* synthetic */ void m11356getINVALIDUwyO8pc$kotlin_stdlib$annotations() {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11360getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11361getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11362getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11366getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11367getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11368getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11372getMinutesUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11373getMinutesUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11374getMinutesUwyO8pc$annotations(long j) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11378getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11379getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11380getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11384getSecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11385getSecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11386getSecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getZERO-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m11387getZEROUwyO8pc$annotations() {
        }

        private Companion() {
        }

        /* renamed from: fromRawValue-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m11388fromRawValueUwyO8pc$kotlin_stdlib(long j) {
            long m11297constructorimpl = Duration.m11297constructorimpl(j);
            if (DurationJvmKt.getDurationAssertionsEnabled()) {
                if (Duration.m11321isInNanosimpl(m11297constructorimpl)) {
                    long m11317getValueimpl = Duration.m11317getValueimpl(m11297constructorimpl);
                    if (-4611686018426999999L > m11317getValueimpl || m11317getValueimpl >= 4611686018427000000L) {
                        throw new AssertionError(Duration.m11317getValueimpl(m11297constructorimpl) + " ns is out of nanoseconds range");
                    }
                    return m11297constructorimpl;
                }
                long m11317getValueimpl2 = Duration.m11317getValueimpl(m11297constructorimpl);
                if (-4611686018427387903L >= m11317getValueimpl2 || m11317getValueimpl2 >= 4611686018427387903L) {
                    long m11317getValueimpl3 = Duration.m11317getValueimpl(m11297constructorimpl);
                    if (m11317getValueimpl3 != 4611686018427387903L && m11317getValueimpl3 != -4611686018427387903L) {
                        throw new AssertionError(Duration.m11317getValueimpl(m11297constructorimpl) + " ms is out of milliseconds range");
                    }
                }
                long m11317getValueimpl4 = Duration.m11317getValueimpl(m11297constructorimpl);
                if (-4611686018426L > m11317getValueimpl4 || m11317getValueimpl4 >= 4611686018427L) {
                    return m11297constructorimpl;
                }
                throw new AssertionError(Duration.m11317getValueimpl(m11297constructorimpl) + " ms is denormalized");
            }
            return m11297constructorimpl;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m11392getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m11389getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m11391getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getINVALID-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m11390getINVALIDUwyO8pc$kotlin_stdlib() {
            return Duration.INVALID;
        }

        public final double convert(double d, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(d, sourceUnit, targetUnit);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m11376getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m11377getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m11375getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m11358getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m11359getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m11357getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m11364getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m11365getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m11363getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m11382getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m11383getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m11381getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m11370getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m11371getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m11369getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m11351getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m11352getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m11350getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m11345getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m11346getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m11344getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m11393parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long parseDuration$default = DurationKt.parseDuration$default(value, false, false, 4, null);
                if (Duration.m11302equalsimpl0(parseDuration$default, Duration.Companion.m11390getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed".toString());
                }
                return parseDuration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m11394parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long parseDuration$default = DurationKt.parseDuration$default(value, true, false, 4, null);
                if (Duration.m11302equalsimpl0(parseDuration$default, Duration.Companion.m11390getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed".toString());
                }
                return parseDuration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m11396parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long access$parseDuration = DurationKt.access$parseDuration(value, false, false);
            if (Duration.m11302equalsimpl0(access$parseDuration, Duration.Companion.m11390getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m11295boximpl(access$parseDuration);
        }

        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m11395parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long access$parseDuration = DurationKt.access$parseDuration(value, true, false);
            if (Duration.m11302equalsimpl0(access$parseDuration, Duration.Companion.m11390getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m11295boximpl(access$parseDuration);
        }
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m11341unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-m11317getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m11326plusLRDsOJo(long j, long j2) {
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return m11320isInMillisimpl(j) ? m11293addValuesMixedRangesUwyO8pc(j, m11317getValueimpl(j), m11317getValueimpl(j2)) : m11293addValuesMixedRangesUwyO8pc(j, m11317getValueimpl(j2), m11317getValueimpl(j));
        } else if (m11321isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanosNormalized(m11317getValueimpl(j) + m11317getValueimpl(j2));
        } else {
            long access$addMillisWithoutOverflow = DurationKt.access$addMillisWithoutOverflow(m11317getValueimpl(j), m11317getValueimpl(j2));
            if (access$addMillisWithoutOverflow != INVALID_RAW_VALUE) {
                if (access$addMillisWithoutOverflow == 4611686018427387903L || access$addMillisWithoutOverflow == -4611686018427387903L) {
                    return DurationKt.access$durationOfMillis(access$addMillisWithoutOverflow);
                }
                return DurationKt.access$durationOfMillisNormalized(access$addMillisWithoutOverflow);
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m11293addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j3);
        long access$addMillisWithoutOverflow = DurationKt.access$addMillisWithoutOverflow(j2, access$nanosToMillis);
        if (-4611686018426L <= access$addMillisWithoutOverflow && access$addMillisWithoutOverflow < 4611686018427L) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(access$addMillisWithoutOverflow) + (j3 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(access$addMillisWithoutOverflow);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m11325minusLRDsOJo(long j, long j2) {
        return m11326plusLRDsOJo(j, m11341unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m11328timesUwyO8pc(long j, int i) {
        if (m11322isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m11341unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return ZERO;
        } else {
            long m11317getValueimpl = m11317getValueimpl(j);
            long j2 = i;
            long j3 = m11317getValueimpl * j2;
            if (!m11321isInNanosimpl(j)) {
                if (j3 / j2 == m11317getValueimpl) {
                    return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, 4611686018427387903L)));
                }
                return MathKt.getSign(m11317getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
            } else if (-2147483647L <= m11317getValueimpl && m11317getValueimpl < 2147483648L) {
                return DurationKt.access$durationOfNanos(j3);
            } else {
                if (j3 / j2 == m11317getValueimpl) {
                    return DurationKt.access$durationOfNanosNormalized(j3);
                }
                long access$nanosToMillis = DurationKt.access$nanosToMillis(m11317getValueimpl);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m11317getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                    return MathKt.getSign(m11317getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
                }
                return DurationKt.access$durationOfMillis(RangesKt.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m11327timesUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (roundToInt == d) {
            return m11328timesUwyO8pc(j, roundToInt);
        }
        DurationUnit m11315getStorageUnitimpl = m11315getStorageUnitimpl(j);
        return DurationKt.toDuration(m11333toDoubleimpl(j, m11315getStorageUnitimpl) * d, m11315getStorageUnitimpl);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m11300divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m11324isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m11323isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m11321isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanos(m11317getValueimpl(j) / i);
        } else {
            if (m11322isInfiniteimpl(j)) {
                return m11328timesUwyO8pc(j, MathKt.getSign(i));
            }
            long j2 = i;
            long m11317getValueimpl = m11317getValueimpl(j) / j2;
            if (-4611686018426L <= m11317getValueimpl && m11317getValueimpl < 4611686018427L) {
                return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m11317getValueimpl) + (DurationKt.access$millisToNanos(m11317getValueimpl(j) - (m11317getValueimpl * j2)) / j2));
            }
            return DurationKt.access$durationOfMillis(m11317getValueimpl);
        }
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m11299divUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (roundToInt == d && roundToInt != 0) {
            return m11300divUwyO8pc(j, roundToInt);
        }
        DurationUnit m11315getStorageUnitimpl = m11315getStorageUnitimpl(j);
        return DurationKt.toDuration(m11333toDoubleimpl(j, m11315getStorageUnitimpl) / d, m11315getStorageUnitimpl);
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m11298divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.maxOf(m11315getStorageUnitimpl(j), m11315getStorageUnitimpl(j2));
        return m11333toDoubleimpl(j, durationUnit) / m11333toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: truncateTo-UwyO8pc$kotlin_stdlib  reason: not valid java name */
    public static final long m11340truncateToUwyO8pc$kotlin_stdlib(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit m11315getStorageUnitimpl = m11315getStorageUnitimpl(j);
        if (unit.compareTo(m11315getStorageUnitimpl) <= 0 || m11322isInfiniteimpl(j)) {
            return j;
        }
        return DurationKt.toDuration(m11317getValueimpl(j) - (m11317getValueimpl(j) % DurationUnitKt.convertDurationUnit(1L, unit, m11315getStorageUnitimpl)), m11315getStorageUnitimpl);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m11322isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m11319isFiniteimpl(long j) {
        return !m11322isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m11303getAbsoluteValueUwyO8pc(long j) {
        return m11323isNegativeimpl(j) ? m11341unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m11342compareToLRDsOJo(long j) {
        return m11296compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m11296compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m11323isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m11332toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m11305getInWholeDaysimpl(j)), Integer.valueOf(m11304getHoursComponentimpl(j)), Integer.valueOf(m11312getMinutesComponentimpl(j)), Integer.valueOf(m11314getSecondsComponentimpl(j)), Integer.valueOf(m11313getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m11331toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m11306getInWholeHoursimpl(j)), Integer.valueOf(m11312getMinutesComponentimpl(j)), Integer.valueOf(m11314getSecondsComponentimpl(j)), Integer.valueOf(m11313getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m11330toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m11309getInWholeMinutesimpl(j)), Integer.valueOf(m11314getSecondsComponentimpl(j)), Integer.valueOf(m11313getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m11329toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m11311getInWholeSecondsimpl(j)), Integer.valueOf(m11313getNanosecondsComponentimpl(j)));
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m11304getHoursComponentimpl(long j) {
        if (m11322isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m11306getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m11312getMinutesComponentimpl(long j) {
        if (m11322isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m11309getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m11314getSecondsComponentimpl(long j) {
        if (m11322isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m11311getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m11313getNanosecondsComponentimpl(long j) {
        if (m11322isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m11320isInMillisimpl(j) ? DurationKt.access$millisToNanos(m11317getValueimpl(j) % 1000) : m11317getValueimpl(j) % C.NANOS_PER_SECOND);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m11333toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m11317getValueimpl(j), m11315getStorageUnitimpl(j), unit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m11336toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m11317getValueimpl(j), m11315getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m11334toIntimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m11336toLongimpl(j, unit), (long) SieveCacheKt.NodeMetaAndPreviousMask, (long) SieveCacheKt.NodeLinkMask);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m11305getInWholeDaysimpl(long j) {
        return m11336toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m11306getInWholeHoursimpl(long j) {
        return m11336toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m11309getInWholeMinutesimpl(long j) {
        return m11336toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m11311getInWholeSecondsimpl(long j) {
        return m11336toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m11308getInWholeMillisecondsimpl(long j) {
        return (m11320isInMillisimpl(j) && m11319isFiniteimpl(j)) ? m11317getValueimpl(j) : m11336toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m11307getInWholeMicrosecondsimpl(long j) {
        return m11336toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m11310getInWholeNanosecondsimpl(long j) {
        long m11317getValueimpl = m11317getValueimpl(j);
        if (m11321isInNanosimpl(j)) {
            return m11317getValueimpl;
        }
        if (m11317getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (m11317getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.access$millisToNanos(m11317getValueimpl);
    }

    public String toString() {
        return m11337toStringimpl(this.rawValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m11337toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m11323isNegativeimpl = m11323isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m11323isNegativeimpl) {
            sb.append('-');
        }
        long m11303getAbsoluteValueUwyO8pc = m11303getAbsoluteValueUwyO8pc(j);
        long m11305getInWholeDaysimpl = m11305getInWholeDaysimpl(m11303getAbsoluteValueUwyO8pc);
        int m11304getHoursComponentimpl = m11304getHoursComponentimpl(m11303getAbsoluteValueUwyO8pc);
        int m11312getMinutesComponentimpl = m11312getMinutesComponentimpl(m11303getAbsoluteValueUwyO8pc);
        int m11314getSecondsComponentimpl = m11314getSecondsComponentimpl(m11303getAbsoluteValueUwyO8pc);
        int m11313getNanosecondsComponentimpl = m11313getNanosecondsComponentimpl(m11303getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m11305getInWholeDaysimpl != 0;
        boolean z2 = m11304getHoursComponentimpl != 0;
        boolean z3 = m11312getMinutesComponentimpl != 0;
        boolean z4 = (m11314getSecondsComponentimpl == 0 && m11313getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m11305getInWholeDaysimpl).append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m11304getHoursComponentimpl).append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m11312getMinutesComponentimpl).append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m11314getSecondsComponentimpl != 0 || z || z2 || z3) {
                m11294appendFractionalimpl(j, sb, m11314getSecondsComponentimpl, m11313getNanosecondsComponentimpl, 9, CmcdData.STREAMING_FORMAT_SS, false);
            } else if (m11313getNanosecondsComponentimpl >= 1000000) {
                m11294appendFractionalimpl(j, sb, m11313getNanosecondsComponentimpl / 1000000, m11313getNanosecondsComponentimpl % 1000000, 6, AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_STRING_LITERAL, false);
            } else if (m11313getNanosecondsComponentimpl >= 1000) {
                m11294appendFractionalimpl(j, sb, m11313getNanosecondsComponentimpl / 1000, m11313getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m11313getNanosecondsComponentimpl).append("ns");
            }
            i = i4;
        }
        if (m11323isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    private static final void m11294appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                Intrinsics.checkNotNullExpressionValue(sb.append((CharSequence) padStart, 0, ((i4 + 3) / 3) * 3), "append(...)");
            } else {
                Intrinsics.checkNotNullExpressionValue(sb.append((CharSequence) padStart, 0, i6), "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m11339toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m11338toStringimpl(j, durationUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m11338toStringimpl(long j, DurationUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i < 0) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double m11333toDoubleimpl = m11333toDoubleimpl(j, unit);
        return Double.isInfinite(m11333toDoubleimpl) ? String.valueOf(m11333toDoubleimpl) : DurationJvmKt.formatToExactDecimals(m11333toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt.shortName(unit);
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m11335toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m11323isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m11303getAbsoluteValueUwyO8pc = m11303getAbsoluteValueUwyO8pc(j);
        long m11306getInWholeHoursimpl = m11306getInWholeHoursimpl(m11303getAbsoluteValueUwyO8pc);
        int m11312getMinutesComponentimpl = m11312getMinutesComponentimpl(m11303getAbsoluteValueUwyO8pc);
        int m11314getSecondsComponentimpl = m11314getSecondsComponentimpl(m11303getAbsoluteValueUwyO8pc);
        int m11313getNanosecondsComponentimpl = m11313getNanosecondsComponentimpl(m11303getAbsoluteValueUwyO8pc);
        long j2 = m11322isInfiniteimpl(j) ? 9999999999999L : m11306getInWholeHoursimpl;
        boolean z = true;
        boolean z2 = j2 != 0;
        boolean z3 = (m11314getSecondsComponentimpl == 0 && m11313getNanosecondsComponentimpl == 0) ? false : true;
        if (m11312getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(j2).append('H');
        }
        if (z) {
            sb.append(m11312getMinutesComponentimpl).append('M');
        }
        if (z3 || (!z2 && !z)) {
            m11294appendFractionalimpl(j, sb, m11314getSecondsComponentimpl, m11313getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb.toString();
    }
}
