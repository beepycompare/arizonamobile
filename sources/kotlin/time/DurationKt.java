package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\n\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001d\u001a/\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010 \u001a\u0016\u0010!\u001a\u00020\t*\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010$\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u001e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a&\u0010(\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\u0016\u0010*\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a%\u0010+\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u0016H\u0083\u0088\u0004b\u0002\b\u0011¢\u0006\u0002\u0010-\u001a'\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\u0082\u0088\u0004¢\u0006\u0004\b1\u00102\u001a\u0018\u00103\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0018\u00105\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0012\u0010A\u001a\u00020\t*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010A\u001a\u00020\u0002*\u00020\u0002H\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0017\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u001f\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010Z\u001a\u0017\u0010[\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010\\\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\"\u001f\u00106\u001a\u00020\u000b*\u00020\u00048BX\u0082\u0084\b¢\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0019\u0010;\u001a\u00020\t*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u0019\u0010>\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b?\u0010@\"\u000f\u0010B\u001a\u00020\u0002X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010C\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010D\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010E\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010F\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010G\u001a\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010H\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010I\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010J\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010K\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010L\u001a\u00020\u0016X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010M\u001a\u00020\u0002X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.6", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", TypedValues.TransitionType.S_DURATION, "times-mvk6XK0", "(IJ)J", "Lkotlin/internal/InlineOnly;", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "throwException", "(Ljava/lang/String;ZZ)J", "parseIsoStringFormat", "startIndex", "(Ljava/lang/String;IZ)J", "parseDefaultStringFormat", "hasSign", "(Ljava/lang/String;IZZ)J", "addMillisWithoutOverflow", "other", "isInfiniteMillis", "isFiniteMillis", "sameSign", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "parseFractionFallback", "endIndex", "fractionDigitsToNanos", "handleError", "message", "(ZLjava/lang/String;)J", "onInvalid", "block", "Lkotlin/Function0;", "onInvalid-ge6A_vg", "(JLkotlin/jvm/functions/Function0;)Lkotlin/time/Duration;", "defaultDurationUnitByShortNameOrNull", TtmlNode.START, "isoDurationUnitByShortNameOrNull", "fractionMultiplier", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "fallbackFractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "shortNameLength", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "multiplyBy10", "NANOS_IN_MILLIS", "MICROS_IN_MILLIS", "NANOS_IN_MICROS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "MILLIS_IN_SECOND", "MILLIS_IN_MINUTE", "MILLIS_IN_HOUR", "MILLIS_IN_DAY", "INFINITY_STRING", "FRACTION_LIMIT", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DurationKt {
    private static final int FRACTION_LIMIT = 15;
    private static final String INFINITY_STRING = "Infinity";
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final long MICROS_IN_MILLIS = 1000;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SECOND = 1000;
    public static final long NANOS_IN_MICROS = 1000;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* compiled from: Duration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getFractionMultiplier$annotations(DurationUnit durationUnit) {
    }

    private static final boolean isFiniteMillis(long j) {
        return -4611686018427387903L < j && j < 4611686018427387903L;
    }

    private static final boolean isInfiniteMillis(long j) {
        return j == 4611686018427387903L || j == -4611686018427387903L;
    }

    public static final long millisToNanos(long j) {
        return j * 1000000;
    }

    private static final int multiplyBy10(int i) {
        return (i << 3) + (i << 1);
    }

    private static final long multiplyBy10(long j) {
        return (j << 3) + (j << 1);
    }

    private static final boolean sameSign(long j, long j2) {
        return (j ^ j2) >= 0;
    }

    public static final long toDuration(int i, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(i, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i, unit);
    }

    public static final long toDuration(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long convertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        if ((-convertDurationUnitOverflow) <= j && j <= convertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(j, unit, DurationUnit.NANOSECONDS));
        }
        if (unit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return durationOfMillis(MathKt.getSign(j) * DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast(j, (long) C.TIME_UNSET)), unit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long toDuration(double d, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(convertDurationUnit)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long roundToLong = MathKt.roundToLong(convertDurationUnit);
        if (-4611686018426999999L <= roundToLong && roundToLong < 4611686018427000000L) {
            return durationOfNanos(roundToLong);
        }
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS)));
    }

    /* renamed from: times-mvk6XK0 */
    private static final long m11395timesmvk6XK0(int i, long j) {
        return Duration.m11324timesUwyO8pc(j, i);
    }

    /* renamed from: times-kIfJnKk */
    private static final long m11394timeskIfJnKk(double d, long j) {
        return Duration.m11323timesUwyO8pc(j, d);
    }

    public static /* synthetic */ long parseDuration$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return parseDuration(str, z, z2);
    }

    public static final long parseDuration(String str, boolean z, boolean z2) {
        int i;
        int i2;
        long parseDefaultStringFormat;
        if (str.length() == 0) {
            if (z2) {
                throw new IllegalArgumentException("The string is empty");
            }
            return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
        }
        char charAt = str.charAt(0);
        if (charAt != '+') {
            i = charAt != '-' ? 0 : 1;
            i2 = i;
        } else {
            i = 0;
            i2 = 1;
        }
        boolean z3 = i2 > 0;
        if (str.length() <= i2) {
            if (z2) {
                throw new IllegalArgumentException("No components");
            }
            return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
        }
        if (str.charAt(i2) == 'P') {
            parseDefaultStringFormat = parseIsoStringFormat(str, i2 + 1, z2);
        } else if (z) {
            if (z2) {
                throw new IllegalArgumentException("");
            }
            return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
        } else if (StringsKt.regionMatches(str, i2, INFINITY_STRING, 0, Math.max(str.length() - i2, 8), true)) {
            parseDefaultStringFormat = Duration.Companion.m11385getINFINITEUwyO8pc();
        } else {
            parseDefaultStringFormat = parseDefaultStringFormat(str, i2, z3, z2);
        }
        return (i == 0 || Duration.m11298equalsimpl0(parseDefaultStringFormat, Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib())) ? parseDefaultStringFormat : Duration.m11337unaryMinusUwyO8pc(parseDefaultStringFormat);
    }

    /* JADX WARN: Code restructure failed: missing block: B:348:0x01c6, code lost:
        if (r5 == r23.length()) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x01ce, code lost:
        if (r23.charAt(r5) == 'S') goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x01d1, code lost:
        r9 = r15 * fractionDigitsToNanos((r10 * androidx.media3.common.C.NANOS_PER_SECOND) + r13, kotlin.time.DurationUnit.SECONDS);
     */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x028d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:420:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0082 A[ADDED_TO_REGION, EDGE_INSN: B:425:0x0082->B:264:0x0082 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseIsoStringFormat(String str, int i, boolean z) {
        int i2;
        int i3;
        char c;
        long j;
        String str2;
        int i4;
        DurationUnit isoDurationUnitByShortNameOrNull;
        char charAt;
        char charAt2;
        int i5;
        char charAt3;
        String str3 = "";
        int i6 = i;
        if (i6 == str.length()) {
            if (z) {
                throw new IllegalArgumentException("");
            }
            return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
        }
        DurationUnit durationUnit = null;
        long j2 = 0;
        long j3 = 0;
        boolean z2 = false;
        while (i6 < str.length()) {
            char charAt4 = str.charAt(i6);
            if (charAt4 == 'T') {
                if (z2 || (i6 = i6 + 1) == str.length()) {
                    if (z) {
                        throw new IllegalArgumentException(str3);
                    }
                    return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                }
                z2 = true;
            } else {
                LongParser iso = LongParser.Companion.getIso();
                if (iso.allowSign) {
                    char charAt5 = str.charAt(i6);
                    if (charAt5 == '+') {
                        i2 = i6 + 1;
                        i3 = 1;
                        while (true) {
                            if (i2 < str.length()) {
                                break;
                            }
                            break;
                            i2++;
                        }
                        j = 0;
                        while (i2 < str.length()) {
                            int i7 = charAt2 - '0';
                            if (j > iso.overflowThreshold) {
                            }
                            String str4 = str3;
                            i4 = i5;
                            while (i4 < str.length()) {
                                i4++;
                            }
                            if (i4 != str.length()) {
                            }
                            if (z) {
                            }
                        }
                        str2 = str3;
                        i4 = i2;
                        if (i4 != str.length()) {
                        }
                        if (z) {
                        }
                    } else if (charAt5 == '-') {
                        i2 = i6 + 1;
                        i3 = -1;
                        while (true) {
                            if (i2 < str.length() || str.charAt(i2) != '0') {
                                break;
                            }
                            i2++;
                        }
                        j = 0;
                        for (c = '0'; i2 < str.length() && c <= (charAt2 = str.charAt(i2)) && charAt2 < ':'; c = '0') {
                            int i72 = charAt2 - '0';
                            if (j > iso.overflowThreshold) {
                                if (j == iso.overflowThreshold) {
                                    i5 = i2;
                                    if (i72 > iso.lastDigitMax) {
                                    }
                                } else {
                                    i5 = i2;
                                }
                                j = (j << 3) + (j << 1) + i72;
                                i2 = i5 + 1;
                                str3 = str3;
                            } else {
                                i5 = i2;
                            }
                            String str42 = str3;
                            i4 = i5;
                            while (i4 < str.length() && '0' <= (charAt3 = str.charAt(i4)) && charAt3 < ':') {
                                i4++;
                            }
                            if (i4 != str.length()) {
                                if (i4 != i6 + ((charAt4 == '+' || charAt4 == '-') ? 1 : 0)) {
                                    j = iso.overflowLimit;
                                    str2 = str42;
                                    long j4 = j;
                                    if (str.charAt(i4) == '.') {
                                        int i8 = i4 + 1;
                                        FractionalParser fractionalParser = FractionalParser.INSTANCE;
                                        int min = Math.min(i4 + 7, str.length());
                                        int i9 = i8;
                                        int i10 = 0;
                                        while (i9 < min) {
                                            char charAt6 = str.charAt(i9);
                                            if ('0' > charAt6 || charAt6 >= ':') {
                                                break;
                                            }
                                            i10 = (i10 << 3) + (i10 << 1) + (charAt6 - '0');
                                            i9++;
                                        }
                                        for (int i11 = 0; i11 < 6 - (i9 - i8); i11++) {
                                            i10 = (i10 << 1) + (i10 << 3);
                                        }
                                        int min2 = Math.min(i9 + 9, str.length());
                                        int i12 = i9;
                                        int i13 = 0;
                                        while (i12 < min2) {
                                            char charAt7 = str.charAt(i12);
                                            int i14 = min2;
                                            if ('0' > charAt7 || charAt7 >= ':') {
                                                break;
                                            }
                                            i13 = (i13 << 3) + (i13 << 1) + (charAt7 - '0');
                                            i12++;
                                            min2 = i14;
                                        }
                                        int i15 = 9 - (i12 - i9);
                                        for (int i16 = 0; i16 < i15; i16++) {
                                            i13 = (i13 << 1) + (i13 << 3);
                                        }
                                        i4 = i12;
                                        while (i4 < str.length() && '0' <= (charAt = str.charAt(i4)) && charAt < ':') {
                                            i4++;
                                        }
                                        if (z) {
                                            throw new IllegalArgumentException(str2);
                                        }
                                        return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                                    }
                                    isoDurationUnitByShortNameOrNull = isoDurationUnitByShortNameOrNull(str, i4);
                                    if (isoDurationUnitByShortNameOrNull != null) {
                                        String str5 = "Unknown duration unit short name: " + str.charAt(i4);
                                        if (z) {
                                            throw new IllegalArgumentException(str5);
                                        }
                                        return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                                    } else if (durationUnit != null && durationUnit.compareTo(isoDurationUnitByShortNameOrNull) <= 0) {
                                        if (z) {
                                            throw new IllegalArgumentException("Unexpected order of duration components");
                                        }
                                        return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                                    } else {
                                        if (isoDurationUnitByShortNameOrNull == DurationUnit.DAYS) {
                                            if (z2) {
                                                if (z) {
                                                    throw new IllegalArgumentException(str2);
                                                }
                                                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                                            }
                                            j2 = i3 * DurationUnitKt.convertDurationUnitToMilliseconds(j4, isoDurationUnitByShortNameOrNull);
                                        } else if (!z2) {
                                            if (z) {
                                                throw new IllegalArgumentException(str2);
                                            }
                                            return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                                        } else {
                                            long addMillisWithoutOverflow = addMillisWithoutOverflow(j2, i3 * DurationUnitKt.convertDurationUnitToMilliseconds(j4, isoDurationUnitByShortNameOrNull));
                                            if (addMillisWithoutOverflow == Duration.INVALID_RAW_VALUE) {
                                                if (z) {
                                                    throw new IllegalArgumentException(str2);
                                                }
                                                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                                            }
                                            j2 = addMillisWithoutOverflow;
                                        }
                                        i6 = i4 + 1;
                                        str3 = str2;
                                        durationUnit = isoDurationUnitByShortNameOrNull;
                                    }
                                }
                            }
                            if (z) {
                                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                            }
                            throw new IllegalArgumentException(str42);
                        }
                        str2 = str3;
                        i4 = i2;
                        if (i4 != str.length()) {
                            if (i4 == i6 + ((charAt4 == '+' || charAt4 == '-') ? 1 : 0)) {
                            }
                            long j42 = j;
                            if (str.charAt(i4) == '.') {
                            }
                            isoDurationUnitByShortNameOrNull = isoDurationUnitByShortNameOrNull(str, i4);
                            if (isoDurationUnitByShortNameOrNull != null) {
                            }
                        }
                        if (z) {
                            throw new IllegalArgumentException(str2);
                        }
                        return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                    }
                }
                i2 = i6;
                i3 = 1;
                while (true) {
                    if (i2 < str.length()) {
                    }
                    i2++;
                }
                j = 0;
                while (i2 < str.length()) {
                }
                str2 = str3;
                i4 = i2;
                if (i4 != str.length()) {
                }
                if (z) {
                }
            }
        }
        return Duration.m11322plusLRDsOJo(toDuration(j2, DurationUnit.MILLISECONDS), toDuration(j3, DurationUnit.NANOSECONDS));
    }

    /* JADX WARN: Code restructure failed: missing block: B:255:0x00d0, code lost:
        if (r13 >= r25.length()) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x00d2, code lost:
        r1 = r25.charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x00d8, code lost:
        if ('0' > r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x00da, code lost:
        if (r1 >= ':') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x00dc, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x00df, code lost:
        if (r28 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x00e7, code lost:
        return kotlin.time.Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x00ed, code lost:
        throw new java.lang.IllegalArgumentException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0193, code lost:
        if (r10 != r1) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0196, code lost:
        r2 = (r14 * androidx.media3.common.C.NANOS_PER_SECOND) + r12;
        r4 = r13;
        r13 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseDefaultStringFormat(String str, int i, boolean z, boolean z2) {
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        int i3;
        long j;
        long j2;
        long fractionDigitsToNanos;
        int i4;
        char charAt;
        char charAt2;
        int length = str.length();
        boolean z6 = !z;
        if (z && str.charAt(i) == '(' && str.charAt(length - 1) == ')') {
            i2 = i + 1;
            length--;
            if (i2 == length) {
                if (z2) {
                    throw new IllegalArgumentException("No components");
                }
                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
            }
            z3 = true;
        } else {
            z3 = z6;
            i2 = i;
        }
        DurationUnit durationUnit = null;
        long j3 = 0;
        long j4 = 0;
        boolean z7 = true;
        loop0: while (i2 < length) {
            if (!z7 && z3) {
                while (i2 < str.length() && str.charAt(i2) == ' ') {
                    i2++;
                }
            }
            LongParser longParser = LongParser.Companion.getDefault();
            int i5 = (longParser.allowSign && ((charAt2 = str.charAt(i2)) == '+' || charAt2 == '-')) ? i2 + 1 : i2;
            while (i5 < str.length() && str.charAt(i5) == '0') {
                i5++;
            }
            long j5 = 0;
            while (true) {
                if (i5 >= str.length()) {
                    z4 = z3;
                    break;
                }
                char charAt3 = str.charAt(i5);
                z4 = z3;
                if ('0' > charAt3 || charAt3 >= ':') {
                    break;
                }
                int i6 = charAt3 - '0';
                if (j5 > longParser.overflowThreshold) {
                    break loop0;
                }
                long j6 = j4;
                if (j5 == longParser.overflowThreshold && i6 > longParser.lastDigitMax) {
                    break loop0;
                }
                j5 = i6 + (j5 << 3) + (j5 << 1);
                i5++;
                z3 = z4;
                j4 = j6;
            }
            long j7 = j4;
            if (i5 == i2 || i5 == length) {
                if (z2) {
                    throw new IllegalArgumentException("");
                }
                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
            }
            boolean z8 = str.charAt(i5) == '.';
            if (z8) {
                int i7 = i5 + 1;
                FractionalParser fractionalParser = FractionalParser.INSTANCE;
                int min = Math.min(i5 + 7, str.length());
                int i8 = i7;
                int i9 = 0;
                while (true) {
                    if (i8 >= min) {
                        z5 = z8;
                        break;
                    }
                    char charAt4 = str.charAt(i8);
                    z5 = z8;
                    if ('0' > charAt4 || charAt4 >= ':') {
                        break;
                    }
                    i9 = (i9 << 3) + (i9 << 1) + (charAt4 - '0');
                    i8++;
                    z8 = z5;
                }
                for (int i10 = 0; i10 < 6 - (i8 - i7); i10++) {
                    i9 = (i9 << 1) + (i9 << 3);
                }
                int min2 = Math.min(i8 + 9, str.length());
                int i11 = i8;
                int i12 = 0;
                while (true) {
                    if (i11 >= min2) {
                        i4 = i11;
                        break;
                    }
                    int i13 = min2;
                    char charAt5 = str.charAt(i11);
                    i4 = i11;
                    if ('0' > charAt5 || charAt5 >= ':') {
                        break;
                    }
                    i12 = (i12 << 3) + (i12 << 1) + (charAt5 - '0');
                    i11 = i4 + 1;
                    min2 = i13;
                }
                for (int i14 = 0; i14 < 9 - (i4 - i8); i14++) {
                    i12 = (i12 << 1) + (i12 << 3);
                }
                int i15 = i4;
                while (i15 < str.length() && '0' <= (charAt = str.charAt(i15)) && charAt < ':') {
                    i15++;
                }
                if (z2) {
                    throw new IllegalArgumentException("");
                }
                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
            }
            z5 = z8;
            i3 = -1;
            j = 0;
            DurationUnit defaultDurationUnitByShortNameOrNull = defaultDurationUnitByShortNameOrNull(str, i5);
            if (defaultDurationUnitByShortNameOrNull == null) {
                String str2 = "Unknown duration unit short name: " + str.charAt(i5);
                if (z2) {
                    throw new IllegalArgumentException(str2);
                }
                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
            } else if (durationUnit != null && durationUnit.compareTo(defaultDurationUnitByShortNameOrNull) <= 0) {
                if (z2) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
            } else {
                int i16 = WhenMappings.$EnumSwitchMapping$0[defaultDurationUnitByShortNameOrNull.ordinal()];
                if (i16 == 1) {
                    j3 += j5 / 1000;
                    if (j3 <= MAX_NANOS_IN_MILLIS) {
                        j2 = (j5 % 1000) * 1000;
                        j7 = j2;
                    }
                } else if (i16 == 2) {
                    j3 += j5 / 1000000;
                    j2 = j7 + (j5 % 1000000);
                    j7 = j2;
                } else {
                    j3 = addMillisWithoutOverflow(j3, DurationUnitKt.convertDurationUnitToMilliseconds(j5, defaultDurationUnitByShortNameOrNull));
                }
                int shortNameLength = getShortNameLength(defaultDurationUnitByShortNameOrNull) + i5;
                if (!z5) {
                    i2 = shortNameLength;
                    durationUnit = defaultDurationUnitByShortNameOrNull;
                    z3 = z4;
                    j4 = j7;
                    z7 = false;
                } else if (shortNameLength < length) {
                    if (z2) {
                        throw new IllegalArgumentException("Fractional component must be last");
                    }
                    return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
                } else {
                    if (defaultDurationUnitByShortNameOrNull.compareTo(DurationUnit.MINUTES) >= 0 && shortNameLength - i3 > 15) {
                        fractionDigitsToNanos = parseFractionFallback(str, i3, shortNameLength - getShortNameLength(defaultDurationUnitByShortNameOrNull), defaultDurationUnitByShortNameOrNull);
                    } else {
                        fractionDigitsToNanos = fractionDigitsToNanos(j, defaultDurationUnitByShortNameOrNull);
                    }
                    durationUnit = defaultDurationUnitByShortNameOrNull;
                    z3 = z4;
                    z7 = false;
                    j4 = j7 + fractionDigitsToNanos;
                    i2 = shortNameLength;
                }
            }
        }
        return Duration.m11322plusLRDsOJo(toDuration(j3, DurationUnit.MILLISECONDS), toDuration(j4, DurationUnit.NANOSECONDS));
    }

    public static final long addMillisWithoutOverflow(long j, long j2) {
        return (j == 4611686018427387903L || j == -4611686018427387903L) ? ((-4611686018427387903L >= j2 || j2 >= 4611686018427387903L) && (j2 ^ j) < 0) ? Duration.INVALID_RAW_VALUE : j : (j2 == 4611686018427387903L || j2 == -4611686018427387903L) ? j2 : RangesKt.coerceIn(j + j2, -4611686018427387903L, 4611686018427387903L);
    }

    private static final long parseFractionFallback(String str, int i, int i2, DurationUnit durationUnit) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return MathKt.roundToLong(Double.parseDouble(substring) * getFallbackFractionMultiplier(durationUnit));
    }

    private static final long fractionDigitsToNanos(long j, DurationUnit durationUnit) {
        return MathKt.roundToLong(j * getFractionMultiplier(durationUnit));
    }

    static /* synthetic */ long handleError$default(boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
    }

    private static final long handleError(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib();
    }

    /* renamed from: onInvalid-ge6A_vg */
    private static final Duration m11393onInvalidge6A_vg(long j, Function0<Duration> function0) {
        return Duration.m11298equalsimpl0(j, Duration.Companion.m11386getINVALIDUwyO8pc$kotlin_stdlib()) ? function0.invoke() : Duration.m11291boximpl(j);
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String str, int i) {
        char charAt = str.charAt(i);
        char charAt2 = i < StringsKt.getLastIndex(str) ? str.charAt(i + 1) : (char) 0;
        if (charAt != 'd') {
            if (charAt != 'h') {
                if (charAt != 's') {
                    if (charAt == 'u') {
                        if (charAt2 == 's') {
                            return DurationUnit.MICROSECONDS;
                        }
                        return null;
                    } else if (charAt == 'm') {
                        return charAt2 == 's' ? DurationUnit.MILLISECONDS : DurationUnit.MINUTES;
                    } else if (charAt == 'n' && charAt2 == 's') {
                        return DurationUnit.NANOSECONDS;
                    } else {
                        return null;
                    }
                }
                return DurationUnit.SECONDS;
            }
            return DurationUnit.HOURS;
        }
        return DurationUnit.DAYS;
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String str, int i) {
        char charAt = str.charAt(i);
        if (charAt != 'D') {
            if (charAt != 'H') {
                if (charAt != 'M') {
                    if (charAt != 'S') {
                        return null;
                    }
                    return DurationUnit.SECONDS;
                }
                return DurationUnit.MINUTES;
            }
            return DurationUnit.HOURS;
        }
        return DurationUnit.DAYS;
    }

    private static final double getFractionMultiplier(DurationUnit durationUnit) {
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return 1.0E-12d;
            case 2:
                return 1.0E-15d;
            case 3:
                return 1.0E-9d;
            case 4:
                return 1.0E-6d;
            case 5:
                return 6.0E-5d;
            case 6:
                return 0.0036d;
            case 7:
                return 0.0864d;
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }

    private static final long getFallbackFractionMultiplier(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        if (i != 5) {
            if (i != 6) {
                if (i == 7) {
                    return DateCalculationsKt.NANOS_PER_DAY;
                }
                throw new IllegalStateException(("Invalid unit: " + durationUnit + " for fallback fraction multiplier").toString());
            }
            return DateCalculationsKt.NANOS_PER_HOUR;
        }
        return DateCalculationsKt.NANOS_PER_MINUTE;
    }

    private static final int getShortNameLength(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? 2 : 1;
    }

    public static final long nanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long durationOfNanos(long j) {
        return Duration.Companion.m11384fromRawValueUwyO8pc$kotlin_stdlib(j << 1);
    }

    public static final long durationOfMillis(long j) {
        return Duration.Companion.m11384fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + 1);
    }

    public static final long durationOf(long j, int i) {
        return Duration.Companion.m11384fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + i);
    }

    public static final long durationOfNanosNormalized(long j) {
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    public static final long durationOfMillisNormalized(long j) {
        if (-4611686018426L <= j && j < 4611686018427L) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L));
    }
}
