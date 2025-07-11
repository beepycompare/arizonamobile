package kotlinx.datetime;

import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.YearMonthFormat;
import kotlinx.datetime.format.YearMonthFormatKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.serializers.YearMonthSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: YearMonthJvm.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u000223B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0000H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\u0013\u0010)\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\bH\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020+H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00064"}, d2 = {"Lkotlinx/datetime/YearMonth;", "", "Ljava/io/Serializable;", "value", "Ljava/time/YearMonth;", "<init>", "(Ljava/time/YearMonth;)V", "year", "", "month", "(II)V", "Lkotlinx/datetime/Month;", "(ILkotlinx/datetime/Month;)V", "getValue$kotlinx_datetime", "()Ljava/time/YearMonth;", "getYear", "()I", "monthNumber", "getMonthNumber$kotlinx_datetime", "getMonth", "()Lkotlinx/datetime/Month;", "firstDay", "Lkotlinx/datetime/LocalDate;", "getFirstDay", "()Lkotlinx/datetime/LocalDate;", "lastDay", "getLastDay", "numberOfDays", "getNumberOfDays", "days", "Lkotlinx/datetime/LocalDateRange;", "getDays", "()Lkotlinx/datetime/LocalDateRange;", "rangeTo", "Lkotlinx/datetime/YearMonthRange;", "that", "rangeUntil", "compareTo", "other", "toString", "", "equals", "", "", "hashCode", "readObject", "", "ois", "Ljava/io/ObjectInputStream;", "writeReplace", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = YearMonthSerializer.class)
/* loaded from: classes5.dex */
public final class YearMonth implements Comparable<YearMonth>, java.io.Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private final java.time.YearMonth value;

    public YearMonth(java.time.YearMonth value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final java.time.YearMonth getValue$kotlinx_datetime() {
        return this.value;
    }

    public final int getYear() {
        return this.value.getYear();
    }

    public final int getMonthNumber$kotlinx_datetime() {
        return this.value.getMonthValue();
    }

    public final Month getMonth() {
        java.time.Month month = this.value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "getMonth(...)");
        return ConvertersKt.toKotlinMonth(month);
    }

    public final LocalDate getFirstDay() {
        java.time.LocalDate atDay = this.value.atDay(1);
        Intrinsics.checkNotNullExpressionValue(atDay, "atDay(...)");
        return new LocalDate(atDay);
    }

    public final LocalDate getLastDay() {
        java.time.LocalDate atEndOfMonth = this.value.atEndOfMonth();
        Intrinsics.checkNotNullExpressionValue(atEndOfMonth, "atEndOfMonth(...)");
        return new LocalDate(atEndOfMonth);
    }

    public final int getNumberOfDays() {
        return this.value.lengthOfMonth();
    }

    public final LocalDateRange getDays() {
        return getFirstDay().rangeTo(getLastDay());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public YearMonth(int i, int i2) {
        this(r1);
        try {
            java.time.YearMonth of = java.time.YearMonth.of(i, i2);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public YearMonth(int i, Month month) {
        this(r2);
        Intrinsics.checkNotNullParameter(month, "month");
        try {
            java.time.YearMonth of = java.time.YearMonth.of(i, ConvertersKt.toJavaMonth(month));
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* compiled from: YearMonthJvm.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/datetime/YearMonth$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/YearMonth;", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Format", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithYearMonth;", "", "Lkotlin/ExtensionFunctionType;", "serialVersionUID", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<YearMonth> serializer() {
            return YearMonthSerializer.INSTANCE;
        }

        public final YearMonth parse(CharSequence input, DateTimeFormat<YearMonth> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    return new YearMonth(java.time.YearMonth.parse(UtilKt.removeLeadingZerosFromLongYearFormYearMonth(input.toString())));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        public final DateTimeFormat<YearMonth> Format(Function1<? super DateTimeFormatBuilder.WithYearMonth, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return YearMonthFormat.Companion.build(block);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ YearMonth parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            DateTimeFormat<YearMonth> dateTimeFormat2 = dateTimeFormat;
            if ((i & 2) != 0) {
                dateTimeFormat2 = Formats.INSTANCE.getISO();
            }
            return companion.parse(charSequence, dateTimeFormat2);
        }
    }

    /* compiled from: YearMonthJvm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/datetime/YearMonth$Formats;", "", "<init>", "()V", ExifInterface.TAG_RW2_ISO, "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/YearMonth;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();

        private Formats() {
        }

        public final DateTimeFormat<YearMonth> getISO() {
            return YearMonthFormatKt.getISO_YEAR_MONTH();
        }
    }

    public final YearMonthRange rangeTo(YearMonth that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return YearMonthRange.Companion.fromRangeTo$kotlinx_datetime(this, that);
    }

    public final YearMonthRange rangeUntil(YearMonth that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return YearMonthRange.Companion.fromRangeUntil$kotlinx_datetime(this, that);
    }

    @Override // java.lang.Comparable
    public int compareTo(YearMonth other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public String toString() {
        DateTimeFormatter isoFormat;
        isoFormat = YearMonthJvmKt.getIsoFormat();
        String format = isoFormat.format(this.value);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof YearMonth) && Intrinsics.areEqual(this.value, ((YearMonth) obj).value);
        }
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("kotlinx.datetime.YearMonth must be deserialized via kotlinx.datetime.Ser");
    }

    private final Object writeReplace() {
        return new Ser(11, this);
    }
}
