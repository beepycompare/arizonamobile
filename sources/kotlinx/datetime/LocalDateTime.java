package kotlinx.datetime;

import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.time.DateTimeException;
import java.time.chrono.ChronoLocalDateTime;
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
import kotlinx.datetime.format.LocalDateTimeFormat;
import kotlinx.datetime.format.LocalDateTimeFormatKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.serializers.LocalDateTimeSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: LocalDateTimeJvm.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002CDB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006BE\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u000fBE\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0010\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0005\u0010\u0016BE\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\u0019J\b\u0010\"\u001a\u00020\u0017H\u0001J\b\u0010)\u001a\u00020+H\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0002J\b\u0010:\u001a\u00020\bH\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0011\u0010=\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u000209H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001dR\u0011\u0010\t\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010\u0018\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010 \u001a\u0004\b%\u0010\u001dR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001dR\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b.\u0010\u001dR\u0011\u0010\f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b/\u0010\u001dR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b0\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006E"}, d2 = {"Lkotlinx/datetime/LocalDateTime;", "", "Ljava/io/Serializable;", "value", "Ljava/time/LocalDateTime;", "<init>", "(Ljava/time/LocalDateTime;)V", "year", "", "month", "day", "hour", "minute", "second", "nanosecond", "(IIIIIII)V", "Lkotlinx/datetime/Month;", "(ILkotlinx/datetime/Month;IIIII)V", "date", "Lkotlinx/datetime/LocalDate;", "time", "Lkotlinx/datetime/LocalTime;", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalTime;)V", "Ljava/time/Month;", "dayOfMonth", "(ILjava/time/Month;IIIII)V", "getValue$kotlinx_datetime", "()Ljava/time/LocalDateTime;", "getYear", "()I", "monthNumber", "getMonthNumber$annotations", "()V", "getMonthNumber", "getMonth", "()Lkotlinx/datetime/Month;", "getDayOfMonth$annotations", "getDayOfMonth", "getDay", "dayOfWeek", "Lkotlinx/datetime/DayOfWeek;", "getDayOfWeek", "()Lkotlinx/datetime/DayOfWeek;", "Ljava/time/DayOfWeek;", "dayOfYear", "getDayOfYear", "getHour", "getMinute", "getSecond", "getNanosecond", "getDate", "()Lkotlinx/datetime/LocalDate;", "getTime", "()Lkotlinx/datetime/LocalTime;", "equals", "", "other", "", "hashCode", "toString", "", "compareTo", "readObject", "", "ois", "Ljava/io/ObjectInputStream;", "writeReplace", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = LocalDateTimeSerializer.class)
/* loaded from: classes5.dex */
public final class LocalDateTime implements Comparable<LocalDateTime>, java.io.Serializable {
    public static final Companion Companion = new Companion(null);
    private static final LocalDateTime MAX;
    private static final LocalDateTime MIN;
    private static final long serialVersionUID = 0;
    private final java.time.LocalDateTime value;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the 'day' property instead", replaceWith = @ReplaceWith(expression = "this.day", imports = {}))
    public static /* synthetic */ void getDayOfMonth$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the 'month' property instead", replaceWith = @ReplaceWith(expression = "this.month.number", imports = {}))
    public static /* synthetic */ void getMonthNumber$annotations() {
    }

    public LocalDateTime(java.time.LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final java.time.LocalDateTime getValue$kotlinx_datetime() {
        return this.value;
    }

    public /* synthetic */ LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(r2);
        try {
            java.time.LocalDateTime of = java.time.LocalDateTime.of(i, i2, i3, i4, i5, i6, i7);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public /* synthetic */ LocalDateTime(int i, Month month, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, month, i2, i3, i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateTime(int i, Month month, int i2, int i3, int i4, int i5, int i6) {
        this(i, MonthKt.getNumber(month), i2, i3, i4, i5, i6);
        Intrinsics.checkNotNullParameter(month, "month");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalDateTime(LocalDate date, LocalTime time) {
        this(r2);
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        java.time.LocalDateTime of = java.time.LocalDateTime.of(date.getValue$kotlinx_datetime(), time.getValue$kotlinx_datetime());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
    }

    public /* synthetic */ LocalDateTime(int i, java.time.Month month, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, month, i2, i3, i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use kotlinx.datetime.Month", replaceWith = @ReplaceWith(expression = "LocalDateTime(year, month.toKotlinMonth(), dayOfMonth, hour, minute, second, nanosecond)", imports = {}))
    public LocalDateTime(int i, java.time.Month month, int i2, int i3, int i4, int i5, int i6) {
        this(i, ConvertersKt.toKotlinMonth(month), i2, i3, i4, i5, i6);
        Intrinsics.checkNotNullParameter(month, "month");
    }

    public final int getYear() {
        return this.value.getYear();
    }

    public final int getMonthNumber() {
        return this.value.getMonthValue();
    }

    /* renamed from: getMonth  reason: collision with other method in class */
    public final Month m10090getMonth() {
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
    public final DayOfWeek m10089getDayOfWeek() {
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

    public final int getHour() {
        return this.value.getHour();
    }

    public final int getMinute() {
        return this.value.getMinute();
    }

    public final int getSecond() {
        return this.value.getSecond();
    }

    public final int getNanosecond() {
        return this.value.getNano();
    }

    public final LocalDate getDate() {
        java.time.LocalDate localDate = this.value.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return new LocalDate(localDate);
    }

    public final LocalTime getTime() {
        java.time.LocalTime localTime = this.value.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        return new LocalTime(localTime);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LocalDateTime) && Intrinsics.areEqual(this.value, ((LocalDateTime) obj).value);
        }
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localDateTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "toString(...)");
        return localDateTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDateTime other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo((ChronoLocalDateTime<?>) other.value);
    }

    /* compiled from: LocalDateTimeJvm.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aR\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/LocalDateTime$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/LocalDateTime;", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "isoString", "", "MIN", "getMIN$kotlinx_datetime", "()Lkotlinx/datetime/LocalDateTime;", "MAX", "getMAX$kotlinx_datetime", "Format", "builder", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "", "Lkotlin/ExtensionFunctionType;", "serialVersionUID", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalDateTime> serializer() {
            return LocalDateTimeSerializer.INSTANCE;
        }

        public final LocalDateTime parse(CharSequence input, DateTimeFormat<LocalDateTime> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    return new LocalDateTime(java.time.LocalDateTime.parse(UtilKt.removeLeadingZerosFromLongYearFormLocalDateTime(input.toString())));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalDateTime parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalDateTime getMIN$kotlinx_datetime() {
            return LocalDateTime.MIN;
        }

        public final LocalDateTime getMAX$kotlinx_datetime() {
            return LocalDateTime.MAX;
        }

        public final DateTimeFormat<LocalDateTime> Format(Function1<? super DateTimeFormatBuilder.WithDateTime, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return LocalDateTimeFormat.Companion.build(builder);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalDateTime parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalDateTimeKt.getIsoDateTimeFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    static {
        java.time.LocalDateTime MIN2 = java.time.LocalDateTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalDateTime(MIN2);
        java.time.LocalDateTime MAX2 = java.time.LocalDateTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalDateTime(MAX2);
    }

    /* compiled from: LocalDateTimeJvm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/datetime/LocalDateTime$Formats;", "", "<init>", "()V", ExifInterface.TAG_RW2_ISO, "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<LocalDateTime> ISO = LocalDateTimeFormatKt.getISO_DATETIME();

        private Formats() {
        }

        public final DateTimeFormat<LocalDateTime> getISO() {
            return ISO;
        }
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("kotlinx.datetime.LocalDateTime must be deserialized via kotlinx.datetime.Ser");
    }

    private final Object writeReplace() {
        return new Ser(4, this);
    }
}
