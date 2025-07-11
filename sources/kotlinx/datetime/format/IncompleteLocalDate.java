package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.internal.format.parser.Copyable;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B5\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0000H\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001a\u0010$\u001a\u0004\u0018\u00010\u0007X\u0096\u000f¢\u0006\f\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u0004\u0018\u00010\u0007X\u0096\u000f¢\u0006\f\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011¨\u0006*"}, d2 = {"Lkotlinx/datetime/format/IncompleteLocalDate;", "Lkotlinx/datetime/format/YearMonthFieldContainer;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "yearMonth", "Lkotlinx/datetime/format/IncompleteYearMonth;", "day", "", "dayOfWeek", "dayOfYear", "<init>", "(Lkotlinx/datetime/format/IncompleteYearMonth;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getYearMonth", "()Lkotlinx/datetime/format/IncompleteYearMonth;", "getDay", "()Ljava/lang/Integer;", "setDay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDayOfWeek", "setDayOfWeek", "getDayOfYear", "setDayOfYear", "toLocalDate", "Lkotlinx/datetime/LocalDate;", "populateFrom", "", "date", "copy", "equals", "", "other", "", "hashCode", "toString", "", "monthNumber", "getMonthNumber", "setMonthNumber", "year", "getYear", "setYear", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncompleteLocalDate implements YearMonthFieldContainer, DateFieldContainer, Copyable<IncompleteLocalDate> {
    private Integer day;
    private Integer dayOfWeek;
    private Integer dayOfYear;
    private final IncompleteYearMonth yearMonth;

    public IncompleteLocalDate() {
        this(null, null, null, null, 15, null);
    }

    @Override // kotlinx.datetime.format.YearMonthFieldContainer
    public Integer getMonthNumber() {
        return this.yearMonth.getMonthNumber();
    }

    @Override // kotlinx.datetime.format.YearMonthFieldContainer
    public Integer getYear() {
        return this.yearMonth.getYear();
    }

    @Override // kotlinx.datetime.format.YearMonthFieldContainer
    public void setMonthNumber(Integer num) {
        this.yearMonth.setMonthNumber(num);
    }

    @Override // kotlinx.datetime.format.YearMonthFieldContainer
    public void setYear(Integer num) {
        this.yearMonth.setYear(num);
    }

    public IncompleteLocalDate(IncompleteYearMonth yearMonth, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(yearMonth, "yearMonth");
        this.yearMonth = yearMonth;
        this.day = num;
        this.dayOfWeek = num2;
        this.dayOfYear = num3;
    }

    public /* synthetic */ IncompleteLocalDate(IncompleteYearMonth incompleteYearMonth, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IncompleteYearMonth(null, null, 3, null) : incompleteYearMonth, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }

    public final IncompleteYearMonth getYearMonth() {
        return this.yearMonth;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDay() {
        return this.day;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDay(Integer num) {
        this.day = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDayOfWeek() {
        return this.dayOfWeek;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDayOfWeek(Integer num) {
        this.dayOfWeek = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDayOfYear() {
        return this.dayOfYear;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDayOfYear(Integer num) {
        this.dayOfYear = num;
    }

    public final LocalDate toLocalDate() {
        LocalDate localDate;
        int intValue;
        int intValue2 = ((Number) YearMonthFormatKt.requireParsedField(getYear(), "year")).intValue();
        Integer dayOfYear = getDayOfYear();
        if (dayOfYear == null) {
            localDate = new LocalDate(intValue2, ((Number) YearMonthFormatKt.requireParsedField(getMonthNumber(), "monthNumber")).intValue(), ((Number) YearMonthFormatKt.requireParsedField(getDay(), "day")).intValue());
        } else {
            LocalDate plus = LocalDateKt.plus(new LocalDate(intValue2, 1, 1), dayOfYear.intValue() - 1, DateTimeUnit.Companion.getDAY());
            if (plus.getYear() != intValue2) {
                throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + dayOfYear + ", which is not a valid day of year for the year " + intValue2);
            }
            if (getMonthNumber() != null) {
                int number = MonthKt.getNumber(plus.m10086getMonth());
                Integer monthNumber = getMonthNumber();
                if (monthNumber == null || number != monthNumber.intValue()) {
                    throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + dayOfYear + ", which is " + plus.m10086getMonth() + ", but " + getMonthNumber() + " was specified as the month number");
                }
            }
            if (getDay() != null) {
                int day = plus.getDay();
                Integer day2 = getDay();
                if (day2 == null || day != day2.intValue()) {
                    throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + dayOfYear + ", which is the day " + plus.getDay() + " of " + plus.m10086getMonth() + ", but " + getDay() + " was specified as the day of month");
                }
            }
            localDate = plus;
        }
        Integer dayOfWeek = getDayOfWeek();
        if (dayOfWeek == null || (intValue = dayOfWeek.intValue()) == DayOfWeekKt.getIsoDayNumber(localDate.m10085getDayOfWeek())) {
            return localDate;
        }
        throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of week is " + DayOfWeekKt.m10081DayOfWeek(intValue) + " but the date is " + localDate + ", which is a " + localDate.m10085getDayOfWeek());
    }

    public final void populateFrom(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        setYear(Integer.valueOf(date.getYear()));
        setMonthNumber(Integer.valueOf(MonthKt.getNumber(date.m10086getMonth())));
        setDay(Integer.valueOf(date.getDay()));
        setDayOfWeek(Integer.valueOf(DayOfWeekKt.getIsoDayNumber(date.m10085getDayOfWeek())));
        setDayOfYear(Integer.valueOf(date.getDayOfYear()));
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteLocalDate copy() {
        return new IncompleteLocalDate(this.yearMonth.copy(), getDay(), getDayOfWeek(), getDayOfYear());
    }

    public boolean equals(Object obj) {
        if (obj instanceof IncompleteLocalDate) {
            IncompleteLocalDate incompleteLocalDate = (IncompleteLocalDate) obj;
            return Intrinsics.areEqual(this.yearMonth, incompleteLocalDate.yearMonth) && Intrinsics.areEqual(getDay(), incompleteLocalDate.getDay()) && Intrinsics.areEqual(getDayOfWeek(), incompleteLocalDate.getDayOfWeek()) && Intrinsics.areEqual(getDayOfYear(), incompleteLocalDate.getDayOfYear());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.yearMonth.hashCode() * 29791;
        Integer day = getDay();
        int hashCode2 = hashCode + ((day != null ? day.hashCode() : 0) * 961);
        Integer dayOfWeek = getDayOfWeek();
        int hashCode3 = hashCode2 + ((dayOfWeek != null ? dayOfWeek.hashCode() : 0) * 31);
        Integer dayOfYear = getDayOfYear();
        return hashCode3 + (dayOfYear != null ? dayOfYear.hashCode() : 0);
    }

    public String toString() {
        if (getDayOfYear() == null) {
            StringBuilder append = new StringBuilder().append(this.yearMonth).append('-');
            Integer day = getDay();
            if (day == null) {
                day = "??";
            }
            StringBuilder append2 = append.append(day).append(" (day of week is ");
            Integer dayOfWeek = getDayOfWeek();
            return append2.append(dayOfWeek != null ? dayOfWeek : "??").append(')').toString();
        } else if (getDay() == null && getMonthNumber() == null) {
            StringBuilder sb = new StringBuilder("(");
            Integer year = this.yearMonth.getYear();
            if (year == null) {
                year = "??";
            }
            StringBuilder append3 = sb.append(year).append(")-").append(getDayOfYear()).append(" (day of week is ");
            Integer dayOfWeek2 = getDayOfWeek();
            return append3.append(dayOfWeek2 != null ? dayOfWeek2 : "??").append(')').toString();
        } else {
            StringBuilder append4 = new StringBuilder().append(this.yearMonth).append('-');
            Integer day2 = getDay();
            if (day2 == null) {
                day2 = "??";
            }
            StringBuilder append5 = append4.append(day2).append(" (day of week is ");
            Integer dayOfWeek3 = getDayOfWeek();
            return append5.append(dayOfWeek3 != null ? dayOfWeek3 : "??").append(", day of year is ").append(getDayOfYear()).append(')').toString();
        }
    }
}
