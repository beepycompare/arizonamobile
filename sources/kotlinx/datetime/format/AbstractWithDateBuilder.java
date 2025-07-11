package kotlinx.datetime.format;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.YearMonth;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/AbstractWithYearMonthBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "addFormatStructureForDate", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateFieldContainer;", "addFormatStructureForYearMonth", "Lkotlinx/datetime/format/YearMonthFieldContainer;", "day", "padding", "Lkotlinx/datetime/format/Padding;", "dayOfWeek", "names", "Lkotlinx/datetime/format/DayOfWeekNames;", "dayOfYear", "date", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AbstractWithDateBuilder extends AbstractWithYearMonthBuilder, DateTimeFormatBuilder.WithDate {
    void addFormatStructureForDate(FormatStructure<? super DateFieldContainer> formatStructure);

    /* compiled from: LocalDateFormat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated(message = "Use 'day' instead", replaceWith = @ReplaceWith(expression = "day(padding = padding)", imports = {}))
        @Deprecated
        public static void dayOfMonth(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.super.dayOfMonth(padding);
        }

        @Deprecated
        public static void monthName(AbstractWithDateBuilder abstractWithDateBuilder, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateBuilder.super.monthName(names);
        }

        @Deprecated
        public static void monthNumber(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.super.monthNumber(padding);
        }

        @Deprecated
        public static void year(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.super.year(padding);
        }

        @Deprecated
        public static void yearMonth(AbstractWithDateBuilder abstractWithDateBuilder, DateTimeFormat<YearMonth> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateBuilder.super.yearMonth(format);
        }

        @Deprecated
        public static void yearTwoDigits(AbstractWithDateBuilder abstractWithDateBuilder, int i) {
            AbstractWithDateBuilder.super.yearTwoDigits(i);
        }

        @Deprecated
        public static void addFormatStructureForYearMonth(AbstractWithDateBuilder abstractWithDateBuilder, FormatStructure<? super YearMonthFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            AbstractWithDateBuilder.super.addFormatStructureForYearMonth(structure);
        }

        @Deprecated
        public static void day(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.super.day(padding);
        }

        @Deprecated
        public static void dayOfWeek(AbstractWithDateBuilder abstractWithDateBuilder, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            AbstractWithDateBuilder.super.dayOfWeek(names);
        }

        @Deprecated
        public static void dayOfYear(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithDateBuilder.super.dayOfYear(padding);
        }

        @Deprecated
        public static void date(AbstractWithDateBuilder abstractWithDateBuilder, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithDateBuilder.super.date(format);
        }
    }

    @Override // kotlinx.datetime.format.AbstractWithYearMonthBuilder
    default void addFormatStructureForYearMonth(FormatStructure<? super YearMonthFieldContainer> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        addFormatStructureForDate(structure);
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    default void day(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForDate(new BasicFormatStructure(new DayDirective(padding)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    default void dayOfWeek(DayOfWeekNames names) {
        Intrinsics.checkNotNullParameter(names, "names");
        addFormatStructureForDate(new BasicFormatStructure(new DayOfWeekDirective(names)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    default void dayOfYear(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForDate(new BasicFormatStructure(new DayOfYearDirective(padding)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    default void date(DateTimeFormat<LocalDate> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof LocalDateFormat) {
            addFormatStructureForDate(((LocalDateFormat) format).getActualFormat());
        }
    }
}
