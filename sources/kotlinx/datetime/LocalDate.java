package kotlinx.datetime;

import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.time.DateTimeException;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeParseException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalDateFormat;
import kotlinx.datetime.format.LocalDateFormatKt;
import kotlinx.datetime.internal.MathKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.serializers.LocalDateSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: LocalDate.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u00029:B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\rB!\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u0010J\b\u0010\u0019\u001a\u00020\u000eH\u0001J\b\u0010 \u001a\u00020\"H\u0001J\u0011\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0000H\u0086\u0002J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0011\u00100\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0000H\u0096\u0002J\u0006\u00101\u001a\u000202J\r\u00103\u001a\u00020\bH\u0001¢\u0006\u0002\b1J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020,H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\t\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010#\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b$\u0010\u0014¨\u0006;"}, d2 = {"Lkotlinx/datetime/LocalDate;", "", "Ljava/io/Serializable;", "value", "Ljava/time/LocalDate;", "<init>", "(Ljava/time/LocalDate;)V", "year", "", "month", "day", "(III)V", "Lkotlinx/datetime/Month;", "(ILkotlinx/datetime/Month;I)V", "Ljava/time/Month;", "dayOfMonth", "(ILjava/time/Month;I)V", "getValue$kotlinx_datetime", "()Ljava/time/LocalDate;", "getYear", "()I", "monthNumber", "getMonthNumber$annotations", "()V", "getMonthNumber", "getMonth", "()Lkotlinx/datetime/Month;", "getDayOfMonth$annotations", "getDayOfMonth", "getDay", "dayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "getDayOfWeek", "()Lkotlinx/datetime/DayOfWeek;", "Ljava/time/DayOfWeek;", "dayOfYear", "getDayOfYear", "rangeTo", "Lkotlinx/datetime/LocalDateRange;", "that", "rangeUntil", "equals", "", "other", "", "hashCode", "toString", "", "compareTo", "toEpochDays", "", "toEpochDaysJvm", "readObject", "", "ois", "Ljava/io/ObjectInputStream;", "writeReplace", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = LocalDateSerializer.class)
/* loaded from: classes5.dex */
public final class LocalDate implements Comparable<LocalDate>, java.io.Serializable {
    public static final Companion Companion = new Companion(null);
    private static final LocalDate MAX;
    private static final LocalDate MIN;
    private static final long serialVersionUID = 0;
    private final java.time.LocalDate value;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the 'day' property instead", replaceWith = @ReplaceWith(expression = "this.day", imports = {}))
    public static /* synthetic */ void getDayOfMonth$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the 'month' property instead", replaceWith = @ReplaceWith(expression = "this.month.number", imports = {}))
    public static /* synthetic */ void getMonthNumber$annotations() {
    }

    public LocalDate(java.time.LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final java.time.LocalDate getValue$kotlinx_datetime() {
        return this.value;
    }

    /* compiled from: LocalDate.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0014J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dR\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u001b\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/datetime/LocalDate$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/LocalDate;", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "isoString", "", "MIN", "getMIN$kotlinx_datetime", "()Lkotlinx/datetime/LocalDate;", "MAX", "getMAX$kotlinx_datetime", "fromEpochDays", "epochDays", "", "", "Format", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "", "Lkotlin/ExtensionFunctionType;", "serialVersionUID", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalDate> serializer() {
            return LocalDateSerializer.INSTANCE;
        }

        public final LocalDate parse(CharSequence input, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    return new LocalDate(java.time.LocalDate.parse(UtilKt.removeLeadingZerosFromLongYearFormLocalDate(input.toString())));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalDate parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalDate getMIN$kotlinx_datetime() {
            return LocalDate.MIN;
        }

        public final LocalDate getMAX$kotlinx_datetime() {
            return LocalDate.MAX;
        }

        public final LocalDate fromEpochDays(long j) {
            try {
                java.time.LocalDate ofEpochDay = java.time.LocalDate.ofEpochDay(j);
                Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
                return new LocalDate(ofEpochDay);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public final LocalDate fromEpochDays(int i) {
            return fromEpochDays(i);
        }

        public final DateTimeFormat<LocalDate> Format(Function1<? super DateTimeFormatBuilder.WithDate, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return LocalDateFormat.Companion.build(block);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalDate parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalDateKt.getIsoDateFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    static {
        java.time.LocalDate MIN2 = java.time.LocalDate.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalDate(MIN2);
        java.time.LocalDate MAX2 = java.time.LocalDate.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalDate(MAX2);
    }

    /* compiled from: LocalDate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/LocalDate$Formats;", "", "<init>", "()V", ExifInterface.TAG_RW2_ISO, "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_BASIC", "getISO_BASIC", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<LocalDate> ISO_BASIC = LocalDateFormatKt.getISO_DATE_BASIC();

        private Formats() {
        }

        public final DateTimeFormat<LocalDate> getISO() {
            return LocalDateFormatKt.getISO_DATE();
        }

        public final DateTimeFormat<LocalDate> getISO_BASIC() {
            return ISO_BASIC;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDate(int i, int i2, int i3) {
        this(r1);
        try {
            java.time.LocalDate of = java.time.LocalDate.of(i, i2, i3);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDate(int i, Month month, int i2) {
        this(i, MonthKt.getNumber(month), i2);
        Intrinsics.checkNotNullParameter(month, "month");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use kotlinx.datetime.Month", replaceWith = @ReplaceWith(expression = "LocalDate(year, month.toKotlinMonth(), dayOfMonth)", imports = {}))
    public LocalDate(int i, java.time.Month month, int i2) {
        this(i, ConvertersKt.toKotlinMonth(month), i2);
        Intrinsics.checkNotNullParameter(month, "month");
    }

    public final int getYear() {
        return this.value.getYear();
    }

    public final int getMonthNumber() {
        return this.value.getMonthValue();
    }

    /* renamed from: getMonth  reason: collision with other method in class */
    public final Month m10086getMonth() {
        java.time.Month month = this.value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "getMonth(...)");
        return ConvertersKt.toKotlinMonth(month);
    }

    public final java.time.Month getMonth() {
        java.time.Month month = this.value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "getMonth(...)");
        return month;
    }

    public final int getDayOfMonth() {
        return this.value.getDayOfMonth();
    }

    public final int getDay() {
        return this.value.getDayOfMonth();
    }

    /* renamed from: getDayOfWeek  reason: collision with other method in class */
    public final DayOfWeek m10085getDayOfWeek() {
        java.time.DayOfWeek dayOfWeek = this.value.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        return ConvertersKt.toKotlinDayOfWeek(dayOfWeek);
    }

    public final java.time.DayOfWeek getDayOfWeek() {
        java.time.DayOfWeek dayOfWeek = this.value.getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek;
    }

    public final int getDayOfYear() {
        return this.value.getDayOfYear();
    }

    public final LocalDateRange rangeTo(LocalDate that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return LocalDateRange.Companion.fromRangeTo$kotlinx_datetime(this, that);
    }

    public final LocalDateRange rangeUntil(LocalDate that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return LocalDateRange.Companion.fromRangeUntil$kotlinx_datetime(this, that);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LocalDate) && Intrinsics.areEqual(this.value, ((LocalDate) obj).value);
        }
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localDate = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
        return localDate;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDate other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo((ChronoLocalDate) other.value);
    }

    /* renamed from: toEpochDays  reason: collision with other method in class */
    public final long m10087toEpochDays() {
        return this.value.toEpochDay();
    }

    public final int toEpochDays() {
        return MathKt.clampToInt(this.value.toEpochDay());
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("kotlinx.datetime.LocalDate must be deserialized via kotlinx.datetime.Ser");
    }

    private final Object writeReplace() {
        return new Ser(2, this);
    }
}
