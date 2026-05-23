package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int POSITION_UNSPECIFIED = 0;
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;
    private final DayViewDecorator dayViewDecorator;
    private final int itemHeight;
    private int keyboardFocusDirection = 0;
    private final MaterialCalendar.OnDayClickListener onDayClickListener;
    private final MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;
    private Month visibleMonth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthsPagerAdapter(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.OnDayClickListener onDayClickListener, MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.itemHeight = (MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(context)) + (MaterialDatePicker.isFullscreen(context) ? MaterialCalendar.getDayHeight(context) : 0);
        this.calendarConstraints = calendarConstraints;
        this.dateSelector = dateSelector;
        this.dayViewDecorator = dayViewDecorator;
        this.onDayClickListener = onDayClickListener;
        this.onMonthNavigationListener = onMonthNavigationListener;
        this.visibleMonth = openAt;
        setHasStableIds(true);
    }

    /* loaded from: classes4.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
            return new ViewHolder(linearLayout, true);
        }
        return new ViewHolder(linearLayout, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Month monthsLater = this.calendarConstraints.getStart().monthsLater(i);
        viewHolder.monthTitle.setText(monthsLater.getLongName());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && monthsLater.equals(materialCalendarGridView.getAdapter2().month)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().updateSelectedStates(materialCalendarGridView);
        } else {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints, this.dayViewDecorator);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (materialCalendarGridView.getAdapter2().withinMonth(i2)) {
                    MonthsPagerAdapter.this.onDayClickListener.onDayClick(materialCalendarGridView.getAdapter2().getItem(i2).longValue());
                }
            }
        });
        materialCalendarGridView.setOnMonthNavigationListener(this.onMonthNavigationListener);
        boolean isFullscreen = MaterialDatePicker.isFullscreen(viewHolder.itemView.getContext());
        if (isFullscreen || monthsLater.equals(this.visibleMonth)) {
            materialCalendarGridView.setFocusable(true);
            materialCalendarGridView.setDescendantFocusability(131072);
        } else {
            materialCalendarGridView.setFocusable(false);
            materialCalendarGridView.setDescendantFocusability(393216);
        }
        if (isFullscreen || !monthsLater.equals(this.visibleMonth)) {
            return;
        }
        setInitialKeyboardFocus(materialCalendarGridView);
    }

    private void setInitialKeyboardFocus(final MaterialCalendarGridView materialCalendarGridView) {
        final int i = this.keyboardFocusDirection;
        this.keyboardFocusDirection = 0;
        materialCalendarGridView.post(new Runnable() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MonthsPagerAdapter.this.m9522x7f109e0a(materialCalendarGridView, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$setInitialKeyboardFocus$0$com-google-android-material-datepicker-MonthsPagerAdapter  reason: not valid java name */
    public /* synthetic */ void m9522x7f109e0a(MaterialCalendarGridView materialCalendarGridView, int i) {
        if (!materialCalendarGridView.hasFocus() || i == 0) {
            return;
        }
        materialCalendarGridView.setSelection(getInitialDayPositionForDirection(materialCalendarGridView.getAdapter2(), i));
    }

    private int getInitialDayPositionForDirection(MonthAdapter monthAdapter, int i) {
        if (i == 1) {
            int findLastValidDayPosition = monthAdapter.findLastValidDayPosition();
            return findLastValidDayPosition == -1 ? monthAdapter.lastPositionInMonth() : findLastValidDayPosition;
        }
        int findFirstValidDayPosition = monthAdapter.findFirstValidDayPosition();
        return findFirstValidDayPosition == -1 ? monthAdapter.firstPositionInMonth() : findFirstValidDayPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.calendarConstraints.getStart().monthsLater(i).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getPageTitle(int i) {
        return getPageMonth(i).getLongName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getPageMonth(int i) {
        return this.calendarConstraints.getStart().monthsLater(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPosition(Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setKeyboardFocusDirection(int i) {
        this.keyboardFocusDirection = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVisibleMonth(Month month) {
        if (month == null || month.equals(this.visibleMonth)) {
            return;
        }
        int position = getPosition(this.visibleMonth);
        this.visibleMonth = month;
        int position2 = getPosition(month);
        notifyItemChanged(position);
        notifyItemChanged(position2);
    }
}
