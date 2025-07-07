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
import kotlinx.datetime.serializers.DateTimePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0012\u0010\u0011\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0012\u0010\u0013\u001a\u00020\u0014X \u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006\u0082\u0001\u0002!\"¨\u0006#"}, d2 = {"Lkotlinx/datetime/DateTimePeriod;", "", "()V", "days", "", "getDays", "()I", "hours", "getHours", "minutes", "getMinutes", "months", "getMonths", "nanoseconds", "getNanoseconds", "seconds", "getSeconds", "totalMonths", "getTotalMonths$kotlinx_datetime", "totalNanoseconds", "", "getTotalNanoseconds$kotlinx_datetime", "()J", "years", "getYears", "allNonpositive", "", "equals", "other", "hashCode", "toString", "", "Companion", "Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriodImpl;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = DateTimePeriodIso8601Serializer.class)
/* loaded from: classes5.dex */
public abstract class DateTimePeriod {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ DateTimePeriod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDays();

    public abstract int getTotalMonths$kotlinx_datetime();

    public abstract long getTotalNanoseconds$kotlinx_datetime();

    private DateTimePeriod() {
    }

    public final int getYears() {
        return getTotalMonths$kotlinx_datetime() / 12;
    }

    public final int getMonths() {
        return getTotalMonths$kotlinx_datetime() % 12;
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
        return ((getTotalMonths$kotlinx_datetime() | getDays()) == 0 && getTotalNanoseconds$kotlinx_datetime() == 0) ? false : true;
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
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
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
        return (((getTotalMonths$kotlinx_datetime() * 31) + getDays()) * 31) + Long.hashCode(getTotalNanoseconds$kotlinx_datetime());
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lkotlinx/datetime/DateTimePeriod$Companion;", "", "()V", "parse", "Lkotlinx/datetime/DateTimePeriod;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodIso8601Serializer.INSTANCE;
        }

        private static final Void parse$parseException(String str, int i) {
            throw new DateTimeFormatException("Parse error at char " + i + ": " + str);
        }

        /* JADX WARN: Removed duplicated region for block: B:212:0x0378 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:228:0x01b5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01c1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DateTimePeriod parse(String text) {
            char c;
            char c2;
            int i;
            int i2;
            char charAt;
            int i3;
            int parse$toIntThrowing;
            char charAt2;
            Intrinsics.checkNotNullParameter(text, "text");
            int i4 = 0;
            char c3 = 0;
            int i5 = 1;
            int i6 = 0;
            int i7 = 0;
            boolean z = false;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i4 < text.length()) {
                int i14 = i13;
                int i15 = i12;
                int i16 = i11;
                int i17 = i9;
                int i18 = i8;
                if (c3 == 0) {
                    int i19 = i4 + 1;
                    if (i19 >= text.length() && (text.charAt(i4) == '+' || text.charAt(i4) == '-')) {
                        parse$parseException("Unexpected end of string; 'P' designator is required", i4);
                        throw new KotlinNothingValueException();
                    }
                    char charAt3 = text.charAt(i4);
                    if (charAt3 == '+') {
                        c = '-';
                    } else {
                        c = '-';
                        if (charAt3 != '-') {
                            if (charAt3 != 'P') {
                                parse$parseException("Expected '+', '-', 'P', got '" + text.charAt(i4) + '\'', i4);
                                throw new KotlinNothingValueException();
                            }
                            i4 = i19;
                            i8 = i18;
                            i9 = i17;
                            i11 = i16;
                            i12 = i15;
                            i13 = i14;
                            c3 = 1;
                        }
                    }
                    if (text.charAt(i4) == c) {
                        i5 = -1;
                    }
                    if (text.charAt(i19) != 'P') {
                        parse$parseException("Expected 'P', got '" + text.charAt(i19) + '\'', i19);
                        throw new KotlinNothingValueException();
                    }
                    i4 += 2;
                    i8 = i18;
                    i9 = i17;
                    i11 = i16;
                    i12 = i15;
                    i13 = i14;
                    c3 = 1;
                } else {
                    char charAt4 = text.charAt(i4);
                    if (charAt4 == '+') {
                        c2 = '-';
                    } else {
                        c2 = '-';
                        if (charAt4 != '-') {
                            if (('0' <= charAt4 && charAt4 < ':') || charAt4 != 'T') {
                                i2 = i4;
                                i = i5;
                                long j = 0;
                                int i20 = i5;
                                while (true) {
                                    if (i2 < text.length()) {
                                        i3 = i6;
                                        break;
                                    }
                                    char charAt5 = text.charAt(i2);
                                    i3 = i6;
                                    if ('0' > charAt5 || charAt5 >= ':') {
                                        break;
                                    }
                                    try {
                                        j = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(j, 10L), text.charAt(i2) - '0');
                                        i2++;
                                        i6 = i3;
                                    } catch (ArithmeticException unused) {
                                        parse$parseException("The number is too large", i4);
                                        throw new KotlinNothingValueException();
                                    }
                                }
                                long j2 = j * i;
                                if (i2 != text.length()) {
                                    parse$parseException("Expected a designator after the numerical value", i2);
                                    throw new KotlinNothingValueException();
                                }
                                char upperCase = Character.toUpperCase(text.charAt(i2));
                                int i21 = i;
                                int i22 = i7;
                                if (upperCase != 'Y') {
                                    if (upperCase == 'M') {
                                        if (c3 >= 6) {
                                            if (c3 >= '\b') {
                                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            }
                                            c3 = '\b';
                                            i8 = i18;
                                            i9 = i17;
                                            i11 = i16;
                                            i13 = i14;
                                            i6 = i3;
                                            i7 = i22;
                                            i12 = parse$toIntThrowing(j2, i4, 'M');
                                        } else if (c3 >= 3) {
                                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                            throw new KotlinNothingValueException();
                                        } else {
                                            c3 = 3;
                                            i8 = i18;
                                            i11 = i16;
                                            i12 = i15;
                                            i13 = i14;
                                            i6 = i3;
                                            i7 = i22;
                                            i9 = parse$toIntThrowing(j2, i4, 'M');
                                        }
                                    } else if (upperCase == 'W') {
                                        if (c3 >= 4) {
                                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                            throw new KotlinNothingValueException();
                                        }
                                        i7 = parse$toIntThrowing(j2, i4, 'W');
                                        c3 = 4;
                                        i8 = i18;
                                        i9 = i17;
                                        i11 = i16;
                                        i12 = i15;
                                        i13 = i14;
                                        i6 = i3;
                                    } else if (upperCase == 'D') {
                                        if (c3 >= 5) {
                                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                            throw new KotlinNothingValueException();
                                        }
                                        i6 = parse$toIntThrowing(j2, i4, 'D');
                                        c3 = 5;
                                        i8 = i18;
                                        i9 = i17;
                                        i11 = i16;
                                        i12 = i15;
                                        i13 = i14;
                                    } else if (upperCase != 'H') {
                                        if (upperCase == 'S') {
                                            if (c3 >= '\t' || c3 < 6) {
                                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            }
                                            parse$toIntThrowing = parse$toIntThrowing(j2, i4, 'S');
                                            i8 = i18;
                                            i9 = i17;
                                            i11 = i16;
                                            i12 = i15;
                                            c3 = '\t';
                                        } else if (upperCase == '.' || upperCase == ',') {
                                            int i23 = i2 + 1;
                                            if (i23 >= text.length()) {
                                                parse$parseException("Expected designator 'S' after " + text.charAt(i2), i23);
                                                throw new KotlinNothingValueException();
                                            }
                                            i2 = i23;
                                            while (i2 < text.length() && '0' <= (charAt2 = text.charAt(i2)) && charAt2 < ':') {
                                                i2++;
                                            }
                                            int i24 = i2 - i23;
                                            if (i24 > 9) {
                                                parse$parseException("Only the nanosecond fractions of a second are supported", i23);
                                                throw new KotlinNothingValueException();
                                            }
                                            StringBuilder sb = new StringBuilder();
                                            String substring = text.substring(i23, i2);
                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                            int parseInt = Integer.parseInt(sb.append(substring).append(StringsKt.repeat("0", 9 - i24)).toString(), CharsKt.checkRadix(10)) * i21;
                                            if (text.charAt(i2) != 'S') {
                                                parse$parseException("Expected the 'S' designator after a fraction", i2);
                                                throw new KotlinNothingValueException();
                                            } else if (c3 >= '\t' || c3 < 6) {
                                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            } else {
                                                parse$toIntThrowing = parse$toIntThrowing(j2, i4, 'S');
                                                i10 = parseInt;
                                                c3 = '\t';
                                                i8 = i18;
                                                i9 = i17;
                                                i11 = i16;
                                                i12 = i15;
                                            }
                                        } else {
                                            parse$parseException("Expected a designator after the numerical value", i2);
                                            throw new KotlinNothingValueException();
                                        }
                                        i6 = i3;
                                        i7 = i22;
                                        i13 = parse$toIntThrowing;
                                    } else if (c3 >= 7 || c3 < 6) {
                                        parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                        throw new KotlinNothingValueException();
                                    } else {
                                        c3 = 7;
                                        i8 = i18;
                                        i9 = i17;
                                        i12 = i15;
                                        i13 = i14;
                                        i6 = i3;
                                        i7 = i22;
                                        i11 = parse$toIntThrowing(j2, i4, 'H');
                                    }
                                    i4 = i2 + 1;
                                    z = true;
                                    i5 = i20;
                                } else if (c3 >= 2) {
                                    parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                } else {
                                    i8 = parse$toIntThrowing(j2, i4, 'Y');
                                    c3 = 2;
                                    i9 = i17;
                                    i11 = i16;
                                    i12 = i15;
                                    i13 = i14;
                                    i6 = i3;
                                }
                                i7 = i22;
                                i4 = i2 + 1;
                                z = true;
                                i5 = i20;
                            } else if (c3 >= 6) {
                                parse$parseException("Only one 'T' designator is allowed", i4);
                                throw new KotlinNothingValueException();
                            } else {
                                i4++;
                                i8 = i18;
                                i9 = i17;
                                i11 = i16;
                                i12 = i15;
                                i13 = i14;
                                c3 = 6;
                            }
                        }
                    }
                    i = text.charAt(i4) == c2 ? i5 * (-1) : i5;
                    i2 = i4 + 1;
                    if (i2 >= text.length() || '0' > (charAt = text.charAt(i2)) || charAt >= ':') {
                        parse$parseException("A number expected after '" + text.charAt(i2) + '\'', i2);
                        throw new KotlinNothingValueException();
                    }
                    long j3 = 0;
                    int i202 = i5;
                    while (true) {
                        if (i2 < text.length()) {
                        }
                        i2++;
                        i6 = i3;
                    }
                    long j22 = j3 * i;
                    if (i2 != text.length()) {
                    }
                }
            }
            if (c3 == 0) {
                parse$parseException("Unexpected end of input; 'P' designator is required", i4);
                throw new KotlinNothingValueException();
            } else if (c3 == 6) {
                parse$parseException("Unexpected end of input; at least one time component is required after 'T'", i4);
                throw new KotlinNothingValueException();
            } else {
                long j4 = i6 + (i7 * 7);
                if (SieveCacheKt.NodeMetaAndPreviousMask > j4 || j4 > SieveCacheKt.NodeLinkMask) {
                    parse$parseException("The total number of days under 'D' and 'W' designators should fit into an Int", 0);
                    throw new KotlinNothingValueException();
                }
                int i25 = (int) j4;
                if (!z) {
                    parse$parseException("At least one component is required, but none were found", 0);
                    throw new KotlinNothingValueException();
                }
                return DateTimePeriodKt.DateTimePeriod(i8, i9, i25, i11, i12, i13, i10);
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
