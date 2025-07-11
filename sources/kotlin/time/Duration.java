package kotlin.time;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
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
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b*\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b*\u0010(J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\r¢\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\r¢\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r¢\u0006\u0004\b6\u0010\u000fJ\r\u00107\u001a\u00020\r¢\u0006\u0004\b8\u0010\u000fJ\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010JJ\u0088\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010LJs\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010NJ^\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010PJ\u0015\u0010^\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bb\u00100J\u0015\u0010c\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bd\u0010eJ\u000f\u0010t\u001a\u00020uH\u0016¢\u0006\u0004\bv\u0010wJA\u0010x\u001a\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010.\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\rH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J!\u0010t\u001a\u00020u2\u0006\u0010.\u001a\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001a\u00020\t¢\u0006\u0005\bv\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020u¢\u0006\u0005\b\u0085\u0001\u0010wJ\u0015\u0010\u0086\u0001\u001a\u00020\r2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u00109\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010\u0005R\u001a\u0010Q\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010\u000bR\u001a\u0010U\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bV\u0010S\u001a\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\\\u0010S\u001a\u0004\b]\u0010\u000bR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0005R\u0011\u0010j\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u0005R\u0011\u0010l\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0005R\u0011\u0010p\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u0005R\u0011\u0010r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", TtmlNode.TAG_DIV, "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m9823constructorimpl(0);
    private static final long INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m9821boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m9827equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m9869unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m9828equalsimpl0(long j, long j2) {
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
    private static final int m9842getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    private static final long m9843getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m9844hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m9846isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    private static final boolean m9847isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m9849isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m9850isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object obj) {
        return m9827equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m9844hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m9869unboximpl() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m9868compareToLRDsOJo(duration.m9869unboximpl());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final DurationUnit m9841getStorageUnitimpl(long j) {
        return m9847isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m9823constructorimpl(long j) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m9847isInNanosimpl(j)) {
                long m9843getValueimpl = m9843getValueimpl(j);
                if (-4611686018426999999L > m9843getValueimpl || m9843getValueimpl >= 4611686018427000000L) {
                    throw new AssertionError(m9843getValueimpl(j) + " ns is out of nanoseconds range");
                }
                return j;
            }
            long m9843getValueimpl2 = m9843getValueimpl(j);
            if (-4611686018427387903L > m9843getValueimpl2 || m9843getValueimpl2 >= 4611686018427387904L) {
                throw new AssertionError(m9843getValueimpl(j) + " ms is out of milliseconds range");
            }
            long m9843getValueimpl3 = m9843getValueimpl(j);
            if (-4611686018426L > m9843getValueimpl3 || m9843getValueimpl3 >= 4611686018427L) {
                return j;
            }
            throw new AssertionError(m9843getValueimpl(j) + " ms is denormalized");
        }
        return j;
    }

    /* compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b5\u00103J\u0015\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b7J\u0015\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b9R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0017\u0010\u001bR\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001dR\u001f\u0010!\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001f\u0010!\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001bR\u001f\u0010!\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001dR\u001f\u0010$\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001f\u0010$\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u001f\u0010$\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001dR\u001f\u0010'\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001f\u0010'\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001bR\u001f\u0010'\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u0010*\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001bR\u001f\u0010*\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001dR\u001f\u0010-\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001f\u0010-\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001bR\u001f\u0010-\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001d¨\u0006:"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "ZERO", "Lkotlin/time/Duration;", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "", "(J)V", "(J)J", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9873getDaysUwyO8pc$annotations(double d) {
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9874getDaysUwyO8pc$annotations(int i) {
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9875getDaysUwyO8pc$annotations(long j) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9879getHoursUwyO8pc$annotations(double d) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9880getHoursUwyO8pc$annotations(int i) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9881getHoursUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9885getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9886getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9887getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9891getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9892getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9893getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9897getMinutesUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9898getMinutesUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9899getMinutesUwyO8pc$annotations(long j) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9903getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9904getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9905getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9909getSecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9910getSecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m9911getSecondsUwyO8pc$annotations(long j) {
        }

        private Companion() {
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m9914getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m9912getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m9913getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        public final double convert(double d, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(d, sourceUnit, targetUnit);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m9901getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m9902getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m9900getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m9883getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m9884getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m9882getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m9889getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m9890getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m9888getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m9907getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m9908getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m9906getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m9895getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m9896getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m9894getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m9877getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m9878getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m9876getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m9871getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m9872getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m9870getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m9915parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m9916parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m9918parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m9821boximpl(DurationKt.access$parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m9917parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m9821boximpl(DurationKt.access$parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m9867unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-m9843getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m9852plusLRDsOJo(long j, long j2) {
        if (m9848isInfiniteimpl(j)) {
            if (m9845isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m9848isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long m9843getValueimpl = m9843getValueimpl(j) + m9843getValueimpl(j2);
                if (m9847isInNanosimpl(j)) {
                    return DurationKt.access$durationOfNanosNormalized(m9843getValueimpl);
                }
                return DurationKt.access$durationOfMillisNormalized(m9843getValueimpl);
            } else if (m9846isInMillisimpl(j)) {
                return m9819addValuesMixedRangesUwyO8pc(j, m9843getValueimpl(j), m9843getValueimpl(j2));
            } else {
                return m9819addValuesMixedRangesUwyO8pc(j, m9843getValueimpl(j2), m9843getValueimpl(j));
            }
        }
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m9819addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j3);
        long j4 = j2 + access$nanosToMillis;
        if (-4611686018426L <= j4 && j4 < 4611686018427L) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j4) + (j3 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m9851minusLRDsOJo(long j, long j2) {
        return m9852plusLRDsOJo(j, m9867unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m9854timesUwyO8pc(long j, int i) {
        if (m9848isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m9867unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return ZERO;
        } else {
            long m9843getValueimpl = m9843getValueimpl(j);
            long j2 = i;
            long j3 = m9843getValueimpl * j2;
            if (!m9847isInNanosimpl(j)) {
                if (j3 / j2 == m9843getValueimpl) {
                    return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, 4611686018427387903L)));
                }
                return MathKt.getSign(m9843getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
            } else if (-2147483647L <= m9843getValueimpl && m9843getValueimpl < 2147483648L) {
                return DurationKt.access$durationOfNanos(j3);
            } else {
                if (j3 / j2 == m9843getValueimpl) {
                    return DurationKt.access$durationOfNanosNormalized(j3);
                }
                long access$nanosToMillis = DurationKt.access$nanosToMillis(m9843getValueimpl);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m9843getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                    return MathKt.getSign(m9843getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
                }
                return DurationKt.access$durationOfMillis(RangesKt.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m9853timesUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (roundToInt == d) {
            return m9854timesUwyO8pc(j, roundToInt);
        }
        DurationUnit m9841getStorageUnitimpl = m9841getStorageUnitimpl(j);
        return DurationKt.toDuration(m9859toDoubleimpl(j, m9841getStorageUnitimpl) * d, m9841getStorageUnitimpl);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m9826divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m9850isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m9849isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m9847isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanos(m9843getValueimpl(j) / i);
        } else {
            if (m9848isInfiniteimpl(j)) {
                return m9854timesUwyO8pc(j, MathKt.getSign(i));
            }
            long j2 = i;
            long m9843getValueimpl = m9843getValueimpl(j) / j2;
            if (-4611686018426L <= m9843getValueimpl && m9843getValueimpl < 4611686018427L) {
                return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m9843getValueimpl) + (DurationKt.access$millisToNanos(m9843getValueimpl(j) - (m9843getValueimpl * j2)) / j2));
            }
            return DurationKt.access$durationOfMillis(m9843getValueimpl);
        }
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m9825divUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (roundToInt == d && roundToInt != 0) {
            return m9826divUwyO8pc(j, roundToInt);
        }
        DurationUnit m9841getStorageUnitimpl = m9841getStorageUnitimpl(j);
        return DurationKt.toDuration(m9859toDoubleimpl(j, m9841getStorageUnitimpl) / d, m9841getStorageUnitimpl);
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m9824divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.maxOf(m9841getStorageUnitimpl(j), m9841getStorageUnitimpl(j2));
        return m9859toDoubleimpl(j, durationUnit) / m9859toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: truncateTo-UwyO8pc$kotlin_stdlib  reason: not valid java name */
    public static final long m9866truncateToUwyO8pc$kotlin_stdlib(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit m9841getStorageUnitimpl = m9841getStorageUnitimpl(j);
        if (unit.compareTo(m9841getStorageUnitimpl) <= 0 || m9848isInfiniteimpl(j)) {
            return j;
        }
        return DurationKt.toDuration(m9843getValueimpl(j) - (m9843getValueimpl(j) % DurationUnitKt.convertDurationUnit(1L, unit, m9841getStorageUnitimpl)), m9841getStorageUnitimpl);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m9848isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m9845isFiniteimpl(long j) {
        return !m9848isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m9829getAbsoluteValueUwyO8pc(long j) {
        return m9849isNegativeimpl(j) ? m9867unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m9868compareToLRDsOJo(long j) {
        return m9822compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m9822compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m9849isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m9858toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9831getInWholeDaysimpl(j)), Integer.valueOf(m9830getHoursComponentimpl(j)), Integer.valueOf(m9838getMinutesComponentimpl(j)), Integer.valueOf(m9840getSecondsComponentimpl(j)), Integer.valueOf(m9839getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m9857toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9832getInWholeHoursimpl(j)), Integer.valueOf(m9838getMinutesComponentimpl(j)), Integer.valueOf(m9840getSecondsComponentimpl(j)), Integer.valueOf(m9839getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m9856toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9835getInWholeMinutesimpl(j)), Integer.valueOf(m9840getSecondsComponentimpl(j)), Integer.valueOf(m9839getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m9855toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m9837getInWholeSecondsimpl(j)), Integer.valueOf(m9839getNanosecondsComponentimpl(j)));
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m9830getHoursComponentimpl(long j) {
        if (m9848isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9832getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m9838getMinutesComponentimpl(long j) {
        if (m9848isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9835getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m9840getSecondsComponentimpl(long j) {
        if (m9848isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9837getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m9839getNanosecondsComponentimpl(long j) {
        if (m9848isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m9846isInMillisimpl(j) ? DurationKt.access$millisToNanos(m9843getValueimpl(j) % 1000) : m9843getValueimpl(j) % 1000000000);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m9859toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m9843getValueimpl(j), m9841getStorageUnitimpl(j), unit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m9862toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m9843getValueimpl(j), m9841getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m9860toIntimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m9862toLongimpl(j, unit), (long) SieveCacheKt.NodeMetaAndPreviousMask, (long) SieveCacheKt.NodeLinkMask);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m9831getInWholeDaysimpl(long j) {
        return m9862toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m9832getInWholeHoursimpl(long j) {
        return m9862toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m9835getInWholeMinutesimpl(long j) {
        return m9862toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m9837getInWholeSecondsimpl(long j) {
        return m9862toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m9834getInWholeMillisecondsimpl(long j) {
        return (m9846isInMillisimpl(j) && m9845isFiniteimpl(j)) ? m9843getValueimpl(j) : m9862toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m9833getInWholeMicrosecondsimpl(long j) {
        return m9862toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m9836getInWholeNanosecondsimpl(long j) {
        long m9843getValueimpl = m9843getValueimpl(j);
        if (m9847isInNanosimpl(j)) {
            return m9843getValueimpl;
        }
        if (m9843getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (m9843getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.access$millisToNanos(m9843getValueimpl);
    }

    public String toString() {
        return m9863toStringimpl(this.rawValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m9863toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m9849isNegativeimpl = m9849isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m9849isNegativeimpl) {
            sb.append('-');
        }
        long m9829getAbsoluteValueUwyO8pc = m9829getAbsoluteValueUwyO8pc(j);
        long m9831getInWholeDaysimpl = m9831getInWholeDaysimpl(m9829getAbsoluteValueUwyO8pc);
        int m9830getHoursComponentimpl = m9830getHoursComponentimpl(m9829getAbsoluteValueUwyO8pc);
        int m9838getMinutesComponentimpl = m9838getMinutesComponentimpl(m9829getAbsoluteValueUwyO8pc);
        int m9840getSecondsComponentimpl = m9840getSecondsComponentimpl(m9829getAbsoluteValueUwyO8pc);
        int m9839getNanosecondsComponentimpl = m9839getNanosecondsComponentimpl(m9829getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m9831getInWholeDaysimpl != 0;
        boolean z2 = m9830getHoursComponentimpl != 0;
        boolean z3 = m9838getMinutesComponentimpl != 0;
        boolean z4 = (m9840getSecondsComponentimpl == 0 && m9839getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m9831getInWholeDaysimpl).append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m9830getHoursComponentimpl).append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m9838getMinutesComponentimpl).append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m9840getSecondsComponentimpl != 0 || z || z2 || z3) {
                m9820appendFractionalimpl(j, sb, m9840getSecondsComponentimpl, m9839getNanosecondsComponentimpl, 9, CmcdData.STREAMING_FORMAT_SS, false);
            } else if (m9839getNanosecondsComponentimpl >= 1000000) {
                m9820appendFractionalimpl(j, sb, m9839getNanosecondsComponentimpl / 1000000, m9839getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m9839getNanosecondsComponentimpl >= 1000) {
                m9820appendFractionalimpl(j, sb, m9839getNanosecondsComponentimpl / 1000, m9839getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m9839getNanosecondsComponentimpl).append("ns");
            }
            i = i4;
        }
        if (m9849isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    private static final void m9820appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
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
    public static /* synthetic */ String m9865toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m9864toStringimpl(j, durationUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m9864toStringimpl(long j, DurationUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i < 0) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double m9859toDoubleimpl = m9859toDoubleimpl(j, unit);
        return Double.isInfinite(m9859toDoubleimpl) ? String.valueOf(m9859toDoubleimpl) : DurationJvmKt.formatToExactDecimals(m9859toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt.shortName(unit);
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m9861toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m9849isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m9829getAbsoluteValueUwyO8pc = m9829getAbsoluteValueUwyO8pc(j);
        long m9832getInWholeHoursimpl = m9832getInWholeHoursimpl(m9829getAbsoluteValueUwyO8pc);
        int m9838getMinutesComponentimpl = m9838getMinutesComponentimpl(m9829getAbsoluteValueUwyO8pc);
        int m9840getSecondsComponentimpl = m9840getSecondsComponentimpl(m9829getAbsoluteValueUwyO8pc);
        int m9839getNanosecondsComponentimpl = m9839getNanosecondsComponentimpl(m9829getAbsoluteValueUwyO8pc);
        long j2 = m9848isInfiniteimpl(j) ? 9999999999999L : m9832getInWholeHoursimpl;
        boolean z = true;
        boolean z2 = j2 != 0;
        boolean z3 = (m9840getSecondsComponentimpl == 0 && m9839getNanosecondsComponentimpl == 0) ? false : true;
        if (m9838getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(j2).append('H');
        }
        if (z) {
            sb.append(m9838getMinutesComponentimpl).append('M');
        }
        if (z3 || (!z2 && !z)) {
            m9820appendFractionalimpl(j, sb, m9840getSecondsComponentimpl, m9839getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb.toString();
    }
}
