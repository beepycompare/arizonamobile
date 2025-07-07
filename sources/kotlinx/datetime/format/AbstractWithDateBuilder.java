package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u0019"}, d2 = {"Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "addFormatStructureForDate", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateFieldContainer;", "date", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "dayOfMonth", "padding", "Lkotlinx/datetime/format/Padding;", "dayOfWeek", "names", "Lkotlinx/datetime/format/DayOfWeekNames;", "dayOfYear", "monthName", "Lkotlinx/datetime/format/MonthNames;", "monthNumber", "year", "yearTwoDigits", "baseYear", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AbstractWithDateBuilder extends DateTimeFormatBuilder.WithDate {
    void addFormatStructureForDate(FormatStructure<? super DateFieldContainer> formatStructure);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void date(DateTimeFormat<LocalDate> dateTimeFormat);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void dayOfMonth(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void dayOfWeek(DayOfWeekNames dayOfWeekNames);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void dayOfYear(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void monthName(MonthNames monthNames);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void monthNumber(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void year(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
    void yearTwoDigits(int i);

    /* compiled from: LocalDateFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void year(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new YearDirective(padding, false, 2, null)));
        }

        public static void yearTwoDigits(AbstractWithDateBuilder abstractWithDateBuilder, int i) {
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new ReducedYearDirective(i, false, 2, null)));
        }

        public static void monthNumber(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new MonthDirective(padding)));
        }

        public static void monthName(AbstractWithDateBuilder abstractWithDateBuilder, MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new MonthNameDirective(names)));
        }

        public static void dayOfMonth(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new DayDirective(padding)));
        }

        public static void dayOfWeek(AbstractWithDateBuilder abstractWithDateBuilder, DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new DayOfWeekDirective(names)));
        }

        public static void dayOfYear(AbstractWithDateBuilder abstractWithDateBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithDateBuilder.addFormatStructureForDate(new BasicFormatStructure(new DayOfYearDirective(padding)));
        }

        public static void date(AbstractWithDateBuilder abstractWithDateBuilder, DateTimeFormat<LocalDate> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof LocalDateFormat) {
                abstractWithDateBuilder.addFormatStructureForDate(((LocalDateFormat) format).getActualFormat());
            }
        }
    }
}
