package kotlinx.datetime.format;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.YearMonth;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.FormatStructure;
/* compiled from: LocalDateTimeFormat.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "addFormatStructureForDateTime", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "addFormatStructureForDate", "Lkotlinx/datetime/format/DateFieldContainer;", "addFormatStructureForTime", "Lkotlinx/datetime/format/TimeFieldContainer;", "dateTime", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AbstractWithDateTimeBuilder extends AbstractWithDateBuilder, AbstractWithTimeBuilder, DateTimeFormatBuilder.WithDateTime {
    void addFormatStructureForDateTime(FormatStructure<? super DateTimeFieldContainer> formatStructure);

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void addFormatStructureForYearMonth(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, FormatStructure<? super YearMonthFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            AbstractWithDateTimeBuilder.super.addFormatStructureForYearMonth(structure);
        }

        @Deprecated
        public static void amPmHour(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.amPmHour(padding);
        }

        @Deprecated
        public static void amPmMarker(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, String am, String pm) {
            Intrinsics.checkNotNullParameter(am, "am");
            Intrinsics.checkNotNullParameter(pm, "pm");
            AbstractWithDateTimeBuilder.super.amPmMarker(am, pm);
        }

        @Deprecated
        public static void date(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateTimeBuilder.super.date(format);
        }

        @Deprecated
        public static void day(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.day(padding);
        }

        @Deprecated(message = "Use 'day' instead", replaceWith = @ReplaceWith(expression = "day(padding = padding)", imports = {}))
        @Deprecated
        public static void dayOfMonth(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.dayOfMonth(padding);
        }

        @Deprecated
        public static void dayOfWeek(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateTimeBuilder.super.dayOfWeek(names);
        }

        @Deprecated
        public static void dayOfYear(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.dayOfYear(padding);
        }

        @Deprecated
        public static void hour(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.hour(padding);
        }

        @Deprecated
        public static void minute(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.minute(padding);
        }

        @Deprecated
        public static void monthName(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateTimeBuilder.super.monthName(names);
        }

        @Deprecated
        public static void monthNumber(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.monthNumber(padding);
        }

        @Deprecated
        public static void second(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.second(padding);
        }

        @Deprecated
        public static void secondFraction(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, int i) {
            AbstractWithDateTimeBuilder.super.secondFraction(i);
        }

        @Deprecated
        public static void secondFraction(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, int i, int i2) {
            AbstractWithDateTimeBuilder.super.secondFraction(i, i2);
        }

        @Deprecated
        public static void time(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<LocalTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateTimeBuilder.super.time(format);
        }

        @Deprecated
        public static void year(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateTimeBuilder.super.year(padding);
        }

        @Deprecated
        public static void yearMonth(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<YearMonth> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateTimeBuilder.super.yearMonth(format);
        }

        @Deprecated
        public static void yearTwoDigits(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, int i) {
            AbstractWithDateTimeBuilder.super.yearTwoDigits(i);
        }

        @Deprecated
        public static void addFormatStructureForDate(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, FormatStructure<? super DateFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            AbstractWithDateTimeBuilder.super.addFormatStructureForDate(structure);
        }

        @Deprecated
        public static void addFormatStructureForTime(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, FormatStructure<? super TimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            AbstractWithDateTimeBuilder.super.addFormatStructureForTime(structure);
        }

        @Deprecated
        public static void dateTime(AbstractWithDateTimeBuilder abstractWithDateTimeBuilder, DateTimeFormat<LocalDateTime> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateTimeBuilder.super.dateTime(format);
        }
    }

    @Override // kotlinx.datetime.format.AbstractWithDateBuilder
    default void addFormatStructureForDate(FormatStructure<? super DateFieldContainer> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        addFormatStructureForDateTime(structure);
    }

    @Override // kotlinx.datetime.format.AbstractWithTimeBuilder
    default void addFormatStructureForTime(FormatStructure<? super TimeFieldContainer> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        addFormatStructureForDateTime(structure);
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTime
    default void dateTime(DateTimeFormat<LocalDateTime> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof LocalDateTimeFormat) {
            addFormatStructureForDateTime(((LocalDateTimeFormat) format).getActualFormat());
        }
    }
}
