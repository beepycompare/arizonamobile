package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.internal.format.parser.Copyable;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020#H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006$"}, d2 = {"Lkotlinx/datetime/format/IncompleteLocalDate;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "year", "", "monthNumber", "dayOfMonth", "isoDayOfWeek", "dayOfYear", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDayOfMonth", "()Ljava/lang/Integer;", "setDayOfMonth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDayOfYear", "setDayOfYear", "getIsoDayOfWeek", "setIsoDayOfWeek", "getMonthNumber", "setMonthNumber", "getYear", "setYear", "copy", "equals", "", "other", "", "hashCode", "populateFrom", "", "date", "Lkotlinx/datetime/LocalDate;", "toLocalDate", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncompleteLocalDate implements DateFieldContainer, Copyable<IncompleteLocalDate> {
    private Integer dayOfMonth;
    private Integer dayOfYear;
    private Integer isoDayOfWeek;
    private Integer monthNumber;
    private Integer year;

    public IncompleteLocalDate() {
        this(null, null, null, null, null, 31, null);
    }

    public IncompleteLocalDate(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.year = num;
        this.monthNumber = num2;
        this.dayOfMonth = num3;
        this.isoDayOfWeek = num4;
        this.dayOfYear = num5;
    }

    public /* synthetic */ IncompleteLocalDate(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : num5);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getYear() {
        return this.year;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setYear(Integer num) {
        this.year = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getMonthNumber() {
        return this.monthNumber;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setMonthNumber(Integer num) {
        this.monthNumber = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDayOfMonth() {
        return this.dayOfMonth;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDayOfMonth(Integer num) {
        this.dayOfMonth = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getIsoDayOfWeek() {
        return this.isoDayOfWeek;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setIsoDayOfWeek(Integer num) {
        this.isoDayOfWeek = num;
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
        int intValue2 = ((Number) LocalDateFormatKt.requireParsedField(getYear(), "year")).intValue();
        Integer dayOfYear = getDayOfYear();
        if (dayOfYear == null) {
            localDate = new LocalDate(intValue2, ((Number) LocalDateFormatKt.requireParsedField(getMonthNumber(), "monthNumber")).intValue(), ((Number) LocalDateFormatKt.requireParsedField(getDayOfMonth(), "dayOfMonth")).intValue());
        } else {
            LocalDate plus = LocalDateJvmKt.plus(new LocalDate(intValue2, 1, 1), dayOfYear.intValue() - 1, (DateTimeUnit.DateBased) DateTimeUnit.Companion.getDAY());
            if (plus.getYear() != intValue2) {
                throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + dayOfYear + ", which is not a valid day of year for the year " + intValue2);
            }
            if (getMonthNumber() != null) {
                int monthNumber = plus.getMonthNumber();
                Integer monthNumber2 = getMonthNumber();
                if (monthNumber2 == null || monthNumber != monthNumber2.intValue()) {
                    throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + dayOfYear + ", which is " + plus.getMonth() + ", but " + getMonthNumber() + " was specified as the month number");
                }
            }
            if (getDayOfMonth() != null) {
                int dayOfMonth = plus.getDayOfMonth();
                Integer dayOfMonth2 = getDayOfMonth();
                if (dayOfMonth2 == null || dayOfMonth != dayOfMonth2.intValue()) {
                    throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of year is " + dayOfYear + ", which is the day " + plus.getDayOfMonth() + " of " + plus.getMonth() + ", but " + getDayOfMonth() + " was specified as the day of month");
                }
            }
            localDate = plus;
        }
        Integer isoDayOfWeek = getIsoDayOfWeek();
        if (isoDayOfWeek == null || (intValue = isoDayOfWeek.intValue()) == DayOfWeekKt.getIsoDayNumber(localDate.getDayOfWeek())) {
            return localDate;
        }
        throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of week is " + DayOfWeekKt.DayOfWeek(intValue) + " but the date is " + localDate + ", which is a " + localDate.getDayOfWeek());
    }

    public final void populateFrom(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        setYear(Integer.valueOf(date.getYear()));
        setMonthNumber(Integer.valueOf(date.getMonthNumber()));
        setDayOfMonth(Integer.valueOf(date.getDayOfMonth()));
        setIsoDayOfWeek(Integer.valueOf(DayOfWeekKt.getIsoDayNumber(date.getDayOfWeek())));
        setDayOfYear(Integer.valueOf(date.getDayOfYear()));
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteLocalDate copy() {
        return new IncompleteLocalDate(getYear(), getMonthNumber(), getDayOfMonth(), getIsoDayOfWeek(), getDayOfYear());
    }

    public boolean equals(Object obj) {
        if (obj instanceof IncompleteLocalDate) {
            IncompleteLocalDate incompleteLocalDate = (IncompleteLocalDate) obj;
            return Intrinsics.areEqual(getYear(), incompleteLocalDate.getYear()) && Intrinsics.areEqual(getMonthNumber(), incompleteLocalDate.getMonthNumber()) && Intrinsics.areEqual(getDayOfMonth(), incompleteLocalDate.getDayOfMonth()) && Intrinsics.areEqual(getIsoDayOfWeek(), incompleteLocalDate.getIsoDayOfWeek()) && Intrinsics.areEqual(getDayOfYear(), incompleteLocalDate.getDayOfYear());
        }
        return false;
    }

    public int hashCode() {
        Integer year = getYear();
        int hashCode = (year != null ? year.hashCode() : 0) * 923521;
        Integer monthNumber = getMonthNumber();
        int hashCode2 = hashCode + ((monthNumber != null ? monthNumber.hashCode() : 0) * 29791);
        Integer dayOfMonth = getDayOfMonth();
        int hashCode3 = hashCode2 + ((dayOfMonth != null ? dayOfMonth.hashCode() : 0) * 961);
        Integer isoDayOfWeek = getIsoDayOfWeek();
        int hashCode4 = hashCode3 + ((isoDayOfWeek != null ? isoDayOfWeek.hashCode() : 0) * 31);
        Integer dayOfYear = getDayOfYear();
        return hashCode4 + (dayOfYear != null ? dayOfYear.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Integer year = getYear();
        if (year == null) {
            year = "??";
        }
        StringBuilder append = sb.append(year).append('-');
        Integer monthNumber = getMonthNumber();
        if (monthNumber == null) {
            monthNumber = "??";
        }
        StringBuilder append2 = append.append(monthNumber).append('-');
        Integer dayOfMonth = getDayOfMonth();
        if (dayOfMonth == null) {
            dayOfMonth = "??";
        }
        StringBuilder append3 = append2.append(dayOfMonth).append(" (day of week is ");
        Integer isoDayOfWeek = getIsoDayOfWeek();
        return append3.append(isoDayOfWeek != null ? isoDayOfWeek : "??").append(')').toString();
    }
}
