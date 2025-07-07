package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b!\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/compose/material3/BaseDatePickerStateImpl;", "", "initialDisplayedMonthMillis", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)V", "_displayedMonth", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarMonth;", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "getCalendarModel", "()Landroidx/compose/material3/internal/CalendarModel;", "monthMillis", "displayedMonthMillis", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "<set-?>", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "setSelectableDates", "(Landroidx/compose/material3/SelectableDates;)V", "selectableDates$delegate", "Landroidx/compose/runtime/MutableState;", "getYearRange", "()Lkotlin/ranges/IntRange;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseDatePickerStateImpl {
    public static final int $stable = 0;
    private MutableState<CalendarMonth> _displayedMonth;
    private final CalendarModel calendarModel;
    private final MutableState selectableDates$delegate;
    private final IntRange yearRange;

    public BaseDatePickerStateImpl(Long l, IntRange intRange, SelectableDates selectableDates, Locale locale) {
        MutableState mutableStateOf$default;
        CalendarMonth month;
        MutableState<CalendarMonth> mutableStateOf$default2;
        this.yearRange = intRange;
        CalendarModel createCalendarModel = CalendarModel_androidKt.createCalendarModel(locale);
        this.calendarModel = createCalendarModel;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(selectableDates, null, 2, null);
        this.selectableDates$delegate = mutableStateOf$default;
        if (l != null) {
            month = createCalendarModel.getMonth(l.longValue());
            if (!intRange.contains(month.getYear())) {
                throw new IllegalArgumentException(("The initial display month's year (" + month.getYear() + ") is out of the years range of " + intRange + '.').toString());
            }
        } else {
            month = createCalendarModel.getMonth(createCalendarModel.getToday());
        }
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(month, null, 2, null);
        this._displayedMonth = mutableStateOf$default2;
    }

    public final IntRange getYearRange() {
        return this.yearRange;
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final SelectableDates getSelectableDates() {
        return (SelectableDates) this.selectableDates$delegate.getValue();
    }

    public final void setSelectableDates(SelectableDates selectableDates) {
        this.selectableDates$delegate.setValue(selectableDates);
    }

    public final long getDisplayedMonthMillis() {
        return this._displayedMonth.getValue().getStartUtcTimeMillis();
    }

    public final void setDisplayedMonthMillis(long j) {
        CalendarMonth month = this.calendarModel.getMonth(j);
        if (!this.yearRange.contains(month.getYear())) {
            throw new IllegalArgumentException(("The display month's year (" + month.getYear() + ") is out of the years range of " + this.yearRange + '.').toString());
        }
        this._displayedMonth.setValue(month);
    }
}
