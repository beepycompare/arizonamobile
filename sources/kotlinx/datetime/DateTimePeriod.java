package kotlinx.datetime;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.serializers.DateTimePeriodSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0013\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020\tH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000b\u0082\u0001\u0002\"#¨\u0006$"}, d2 = {"Lkotlinx/datetime/DateTimePeriod;", "", "<init>", "()V", "totalMonths", "", "getTotalMonths$kotlinx_datetime", "()J", "days", "", "getDays", "()I", "totalNanoseconds", "getTotalNanoseconds$kotlinx_datetime", "years", "getYears", "months", "getMonths", "hours", "getHours", "minutes", "getMinutes", "seconds", "getSeconds", "nanoseconds", "getNanoseconds", "allNonpositive", "", "toString", "", "equals", "other", "hashCode", "Companion", "Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriodImpl;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = DateTimePeriodSerializer.class)
/* loaded from: classes5.dex */
public abstract class DateTimePeriod {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ DateTimePeriod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDays();

    public abstract long getTotalMonths$kotlinx_datetime();

    public abstract long getTotalNanoseconds$kotlinx_datetime();

    private DateTimePeriod() {
    }

    public final int getYears() {
        return (int) (getTotalMonths$kotlinx_datetime() / 12);
    }

    public final int getMonths() {
        return (int) (getTotalMonths$kotlinx_datetime() % 12);
    }

    public int getHours() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() / DateCalculationsKt.NANOS_PER_HOUR);
    }

    public int getMinutes() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % DateCalculationsKt.NANOS_PER_HOUR) / DateCalculationsKt.NANOS_PER_MINUTE);
    }

    public int getSeconds() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % DateCalculationsKt.NANOS_PER_MINUTE) / 1000000000);
    }

    public int getNanoseconds() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() % 1000000000);
    }

    private final boolean allNonpositive() {
        if (getTotalMonths$kotlinx_datetime() > 0 || getDays() > 0 || getTotalNanoseconds$kotlinx_datetime() > 0) {
            return false;
        }
        return ((getTotalMonths$kotlinx_datetime() | getTotalNanoseconds$kotlinx_datetime()) == 0 && getDays() == 0) ? false : true;
    }

    public String toString() {
        int i;
        String str;
        StringBuilder sb = new StringBuilder();
        if (allNonpositive()) {
            sb.append('-');
            i = -1;
        } else {
            i = 1;
        }
        sb.append('P');
        if (getYears() != 0) {
            sb.append(getYears() * i).append('Y');
        }
        if (getMonths() != 0) {
            sb.append(getMonths() * i).append('M');
        }
        if (getDays() != 0) {
            sb.append(getDays() * i).append('D');
        }
        int hours = getHours();
        String str2 = "";
        String str3 = ExifInterface.GPS_DIRECTION_TRUE;
        if (hours != 0) {
            sb.append(ExifInterface.GPS_DIRECTION_TRUE).append(getHours() * i).append('H');
            str3 = "";
        }
        if (getMinutes() != 0) {
            sb.append(str3).append(getMinutes() * i).append('M');
        } else {
            str2 = str3;
        }
        if ((getSeconds() | getNanoseconds()) != 0) {
            sb.append(str2);
            if (getSeconds() != 0) {
                str = Integer.valueOf(getSeconds() * i);
            } else {
                str = getNanoseconds() * i < 0 ? "-0" : "0";
            }
            sb.append(str);
            if (getNanoseconds() != 0) {
                sb.append('.').append(StringsKt.padStart(String.valueOf(Math.abs(getNanoseconds())), 9, '0'));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTimePeriod) {
            DateTimePeriod dateTimePeriod = (DateTimePeriod) obj;
            return getTotalMonths$kotlinx_datetime() == dateTimePeriod.getTotalMonths$kotlinx_datetime() && getDays() == dateTimePeriod.getDays() && getTotalNanoseconds$kotlinx_datetime() == dateTimePeriod.getTotalNanoseconds$kotlinx_datetime();
        }
        return false;
    }

    public int hashCode() {
        return (((Long.hashCode(getTotalMonths$kotlinx_datetime()) * 31) + getDays()) * 31) + Long.hashCode(getTotalNanoseconds$kotlinx_datetime());
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lkotlinx/datetime/DateTimePeriod$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/DateTimePeriod;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodSerializer.INSTANCE;
        }

        private static final Void parse$parseException(String str, int i) {
            throw new DateTimeFormatException("Parse error at char " + i + ": " + str);
        }

        public final DateTimePeriod parse(String text) {
            int i;
            int i2;
            char charAt;
            char c;
            char c2;
            int i3;
            int i4;
            long j;
            int parse$toIntThrowing;
            char charAt2;
            char c3;
            Intrinsics.checkNotNullParameter(text, "text");
            int i5 = 0;
            char c4 = 0;
            int i6 = 1;
            int i7 = 0;
            int i8 = 0;
            boolean z = false;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i5 < text.length()) {
                int i15 = i14;
                int i16 = i13;
                int i17 = i12;
                int i18 = i10;
                int i19 = i9;
                if (c4 == 0) {
                    int i20 = i5 + 1;
                    if (i20 >= text.length() && (text.charAt(i5) == '+' || text.charAt(i5) == '-')) {
                        parse$parseException("Unexpected end of string; 'P' designator is required", i5);
                        throw new KotlinNothingValueException();
                    }
                    char charAt3 = text.charAt(i5);
                    int i21 = i6;
                    if (charAt3 == '+' || charAt3 == '-') {
                        int i22 = text.charAt(i5) == '-' ? -1 : i21;
                        if (text.charAt(i20) != 'P') {
                            parse$parseException("Expected 'P', got '" + text.charAt(i20) + '\'', i20);
                            throw new KotlinNothingValueException();
                        }
                        i5 += 2;
                        i6 = i22;
                    } else if (charAt3 != 'P') {
                        parse$parseException("Expected '+', '-', 'P', got '" + text.charAt(i5) + '\'', i5);
                        throw new KotlinNothingValueException();
                    } else {
                        i5 = i20;
                        i6 = i21;
                    }
                    i9 = i19;
                    i10 = i18;
                    i12 = i17;
                    i13 = i16;
                    i14 = i15;
                    c4 = 1;
                } else {
                    int i23 = i6;
                    char charAt4 = text.charAt(i5);
                    char c5 = '0';
                    if (charAt4 == '+' || charAt4 == '-') {
                        i = text.charAt(i5) == '-' ? i23 * (-1) : i23;
                        i2 = i5 + 1;
                        if (i2 < text.length() && '0' <= (charAt = text.charAt(i2))) {
                            c = AbstractJsonLexerKt.COLON;
                            if (charAt >= ':') {
                            }
                        }
                        parse$parseException("A number expected after '" + text.charAt(i2) + '\'', i2);
                        throw new KotlinNothingValueException();
                    } else if (('0' <= charAt4 && charAt4 < ':') || charAt4 != 'T') {
                        i2 = i5;
                        i = i23;
                        c = AbstractJsonLexerKt.COLON;
                    } else if (c4 >= 6) {
                        parse$parseException("Only one 'T' designator is allowed", i5);
                        throw new KotlinNothingValueException();
                    } else {
                        i5++;
                        i9 = i19;
                        i10 = i18;
                        i12 = i17;
                        i13 = i16;
                        i14 = i15;
                        i6 = i23;
                        c4 = 6;
                    }
                    long j2 = 0;
                    while (i2 < text.length()) {
                        char charAt5 = text.charAt(i2);
                        if (c5 > charAt5 || charAt5 >= c) {
                            c2 = c5;
                            i3 = i19;
                            i4 = i5;
                            j = j2;
                            break;
                        }
                        char c6 = c5;
                        int i24 = i19;
                        int i25 = i5;
                        try {
                            j2 = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(j2, 10L), text.charAt(i2) - '0');
                            i2++;
                            i19 = i24;
                            c5 = c6;
                            i5 = i25;
                            c = AbstractJsonLexerKt.COLON;
                        } catch (ArithmeticException unused) {
                            parse$parseException("The number is too large", i25);
                            throw new KotlinNothingValueException();
                        }
                    }
                    c2 = c5;
                    i3 = i19;
                    i4 = i5;
                    j = j2;
                    long j3 = i * j;
                    int i26 = i;
                    if (i2 == text.length()) {
                        parse$parseException("Expected a designator after the numerical value", i2);
                        throw new KotlinNothingValueException();
                    }
                    char upperCase = Character.toUpperCase(text.charAt(i2));
                    int i27 = i7;
                    int i28 = i8;
                    if (upperCase == ',' || upperCase == '.') {
                        int i29 = i2 + 1;
                        if (i29 >= text.length()) {
                            parse$parseException("Expected designator 'S' after " + text.charAt(i2), i29);
                            throw new KotlinNothingValueException();
                        }
                        i2 = i29;
                        while (i2 < text.length() && (c3 = c2) <= (charAt2 = text.charAt(i2)) && charAt2 < ':') {
                            i2++;
                            c2 = c3;
                        }
                        int i30 = i2 - i29;
                        if (i30 > 9) {
                            parse$parseException("Only the nanosecond fractions of a second are supported", i29);
                            throw new KotlinNothingValueException();
                        }
                        StringBuilder sb = new StringBuilder();
                        String substring = text.substring(i29, i2);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        int parseInt = Integer.parseInt(sb.append(substring).append(StringsKt.repeat("0", 9 - i30)).toString(), CharsKt.checkRadix(10)) * i26;
                        if (text.charAt(i2) != 'S') {
                            parse$parseException("Expected the 'S' designator after a fraction", i2);
                            throw new KotlinNothingValueException();
                        } else if (c4 >= '\t' || c4 < 6) {
                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                            throw new KotlinNothingValueException();
                        } else {
                            parse$toIntThrowing = parse$toIntThrowing(j3, i4, 'S');
                            i11 = parseInt;
                            c4 = '\t';
                            i9 = i3;
                            i10 = i18;
                            i12 = i17;
                            i13 = i16;
                            i7 = i27;
                            i8 = i28;
                        }
                    } else {
                        if (upperCase != 'D') {
                            if (upperCase != 'H') {
                                if (upperCase != 'M') {
                                    if (upperCase != 'S') {
                                        if (upperCase != 'W') {
                                            if (upperCase != 'Y') {
                                                parse$parseException("Expected a designator after the numerical value", i2);
                                                throw new KotlinNothingValueException();
                                            } else if (c4 >= 2) {
                                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            } else {
                                                i9 = parse$toIntThrowing(j3, i4, 'Y');
                                                c4 = 2;
                                                i10 = i18;
                                                i12 = i17;
                                                i13 = i16;
                                                i14 = i15;
                                                i7 = i27;
                                            }
                                        } else if (c4 >= 4) {
                                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                            throw new KotlinNothingValueException();
                                        } else {
                                            i8 = parse$toIntThrowing(j3, i4, 'W');
                                            c4 = 4;
                                            i9 = i3;
                                            i10 = i18;
                                            i12 = i17;
                                            i13 = i16;
                                            i14 = i15;
                                            i7 = i27;
                                        }
                                    } else if (c4 >= '\t' || c4 < 6) {
                                        parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                        throw new KotlinNothingValueException();
                                    } else {
                                        parse$toIntThrowing = parse$toIntThrowing(j3, i4, 'S');
                                        i9 = i3;
                                        i10 = i18;
                                        i12 = i17;
                                        i13 = i16;
                                        i7 = i27;
                                        i8 = i28;
                                        c4 = '\t';
                                    }
                                } else if (c4 >= 6) {
                                    if (c4 >= '\b') {
                                        parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                        throw new KotlinNothingValueException();
                                    }
                                    int parse$toIntThrowing2 = parse$toIntThrowing(j3, i4, 'M');
                                    c4 = '\b';
                                    i9 = i3;
                                    i10 = i18;
                                    i12 = i17;
                                    i14 = i15;
                                    i7 = i27;
                                    i8 = i28;
                                    i13 = parse$toIntThrowing2;
                                } else if (c4 >= 3) {
                                    parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                } else {
                                    i10 = parse$toIntThrowing(j3, i4, 'M');
                                    c4 = 3;
                                    i9 = i3;
                                    i12 = i17;
                                    i13 = i16;
                                    i14 = i15;
                                    i7 = i27;
                                }
                            } else if (c4 >= 7 || c4 < 6) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            } else {
                                int parse$toIntThrowing3 = parse$toIntThrowing(j3, i4, 'H');
                                c4 = 7;
                                i9 = i3;
                                i10 = i18;
                                i13 = i16;
                                i14 = i15;
                                i7 = i27;
                                i8 = i28;
                                i12 = parse$toIntThrowing3;
                            }
                            i5 = i2 + 1;
                            z = true;
                            i6 = i23;
                        } else if (c4 >= 5) {
                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                            throw new KotlinNothingValueException();
                        } else {
                            i7 = parse$toIntThrowing(j3, i4, 'D');
                            c4 = 5;
                            i9 = i3;
                            i10 = i18;
                            i12 = i17;
                            i13 = i16;
                            i14 = i15;
                        }
                        i8 = i28;
                        i5 = i2 + 1;
                        z = true;
                        i6 = i23;
                    }
                    i14 = parse$toIntThrowing;
                    i5 = i2 + 1;
                    z = true;
                    i6 = i23;
                }
            }
            if (c4 == 0) {
                parse$parseException("Unexpected end of input; 'P' designator is required", i5);
                throw new KotlinNothingValueException();
            } else if (c4 == 6) {
                parse$parseException("Unexpected end of input; at least one time component is required after 'T'", i5);
                throw new KotlinNothingValueException();
            } else {
                long j4 = i7 + (i8 * 7);
                if (SieveCacheKt.NodeMetaAndPreviousMask > j4 || j4 > SieveCacheKt.NodeLinkMask) {
                    parse$parseException("The total number of days under 'D' and 'W' designators should fit into an Int", 0);
                    throw new KotlinNothingValueException();
                }
                int i31 = (int) j4;
                if (!z) {
                    parse$parseException("At least one component is required, but none were found", 0);
                    throw new KotlinNothingValueException();
                }
                return DateTimePeriodKt.DateTimePeriod(i9, i10, i31, i12, i13, i14, i11);
            }
        }

        private static final int parse$toIntThrowing(long j, int i, char c) {
            if (j < SieveCacheKt.NodeMetaAndPreviousMask || j > SieveCacheKt.NodeLinkMask) {
                parse$parseException("Value " + j + " does not fit into an Int, which is required for component '" + c + '\'', i);
                throw new KotlinNothingValueException();
            }
            return (int) j;
        }
    }
}
