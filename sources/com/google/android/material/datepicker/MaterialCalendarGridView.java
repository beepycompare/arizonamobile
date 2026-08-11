package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;
    private MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
        post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MaterialCalendarGridView.this.m9589x267001b4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAttachedToWindow$0$com-google-android-material-datepicker-MaterialCalendarGridView  reason: not valid java name */
    public /* synthetic */ void m9589x267001b4() {
        ensureFocusRingSelector(getAdapter2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnMonthNavigationListener(MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener) {
        this.onMonthNavigationListener = onMonthNavigationListener;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(Math.max(i, getAdapter2().findFirstValidDayPosition()));
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (i != 21) {
            if (i != 22) {
                if (i == 61) {
                    return handleTabNavigation(selectedItemPosition, keyEvent);
                }
                if (super.onKeyDown(i, keyEvent)) {
                    MonthAdapter adapter2 = getAdapter2();
                    int selectedItemPosition2 = getSelectedItemPosition();
                    if (selectedItemPosition2 == -1 || adapter2.isDayPositionValid(selectedItemPosition2)) {
                        return true;
                    }
                    return handleVerticalNavigationOnDisabledDay(i, selectedItemPosition2);
                }
                return false;
            }
            return handleHorizontalNavigation(selectedItemPosition, !isLayoutRtl);
        }
        return handleHorizontalNavigation(selectedItemPosition, isLayoutRtl);
    }

    boolean handleVerticalNavigationOnDisabledDay(int i, int i2) {
        MonthAdapter adapter2 = getAdapter2();
        if (trySelectNearestValidDayPosition(i2)) {
            return true;
        }
        if (19 == i) {
            int numColumns = getNumColumns();
            while (true) {
                i2 -= numColumns;
                if (i2 < adapter2.firstPositionInMonth()) {
                    return false;
                }
                if (trySelectNearestValidDayPosition(i2)) {
                    return true;
                }
                numColumns = getNumColumns();
            }
        } else if (i != 20) {
            return false;
        } else {
            int numColumns2 = getNumColumns();
            while (true) {
                i2 += numColumns2;
                if (i2 > adapter2.lastPositionInMonth()) {
                    return false;
                }
                if (trySelectNearestValidDayPosition(i2)) {
                    return true;
                }
                numColumns2 = getNumColumns();
            }
        }
    }

    private boolean trySelectNearestValidDayPosition(int i) {
        int findNearestValidDayPositionInRow = getAdapter2().findNearestValidDayPositionInRow(i);
        if (findNearestValidDayPositionInRow != -1) {
            setSelection(findNearestValidDayPositionInRow);
            return true;
        }
        return false;
    }

    private boolean handleHorizontalNavigation(int i, boolean z) {
        int findPreviousValidDayPosition;
        MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;
        MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener2;
        if (z) {
            findPreviousValidDayPosition = getAdapter2().findNextValidDayPosition(i);
        } else {
            findPreviousValidDayPosition = getAdapter2().findPreviousValidDayPosition(i);
        }
        if (findPreviousValidDayPosition != -1) {
            setSelection(findPreviousValidDayPosition);
            return true;
        } else if (z || (onMonthNavigationListener2 = this.onMonthNavigationListener) == null) {
            if (!z || (onMonthNavigationListener = this.onMonthNavigationListener) == null) {
                return true;
            }
            return onMonthNavigationListener.onMonthNavigationNext();
        } else {
            return onMonthNavigationListener2.onMonthNavigationPrevious();
        }
    }

    private boolean handleTabNavigation(int i, KeyEvent keyEvent) {
        int findNextValidDayPosition;
        if (keyEvent.isShiftPressed()) {
            findNextValidDayPosition = getAdapter2().findPreviousValidDayPosition(i);
        } else {
            findNextValidDayPosition = getAdapter2().findNextValidDayPosition(i);
        }
        if (findNextValidDayPosition == -1) {
            return false;
        }
        setSelection(findNextValidDayPosition);
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    private void ensureFocusRingSelector(MonthAdapter monthAdapter) {
        Drawable selector = getSelector();
        if (selector instanceof FocusRingDrawable) {
            return;
        }
        Drawable wrap = FocusRingDrawable.wrap(getContext(), selector);
        if (wrap instanceof FocusRingDrawable) {
            FocusRingDrawable focusRingDrawable = (FocusRingDrawable) wrap;
            if (monthAdapter.calendarStyle != null) {
                focusRingDrawable.setFocusRingShapeAppearance(monthAdapter.calendarStyle.day.getItemShapeAppearanceModel());
            }
            setDrawSelectorOnTop(true);
            setSelector(focusRingDrawable);
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int dayToPosition;
        int horizontalMidPoint;
        int dayToPosition2;
        int horizontalMidPoint2;
        int width;
        int i;
        int left;
        int left2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter2 = materialCalendarGridView.getAdapter2();
        DateSelector<?> dateSelector = adapter2.dateSelector;
        CalendarStyle calendarStyle = adapter2.calendarStyle;
        int max = Math.max(adapter2.firstPositionInMonth(), materialCalendarGridView.getFirstVisiblePosition());
        int min = Math.min(adapter2.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter2.getItem(max);
        Long item2 = adapter2.getItem(min);
        for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
            if (pair.first == null) {
                materialCalendarGridView = this;
            } else if (pair.second != null) {
                long longValue = pair.first.longValue();
                long longValue2 = pair.second.longValue();
                if (!skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                    if (longValue < item.longValue()) {
                        if (adapter2.isFirstInRow(max)) {
                            left2 = 0;
                        } else if (!isLayoutRtl) {
                            left2 = materialCalendarGridView.getChildAtPosition(max - 1).getRight();
                        } else {
                            left2 = materialCalendarGridView.getChildAtPosition(max - 1).getLeft();
                        }
                        horizontalMidPoint = left2;
                        dayToPosition = max;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        dayToPosition = adapter2.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        horizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(dayToPosition));
                    }
                    if (longValue2 > item2.longValue()) {
                        if (adapter2.isLastInRow(min)) {
                            left = materialCalendarGridView.getWidth();
                        } else if (!isLayoutRtl) {
                            left = materialCalendarGridView.getChildAtPosition(min).getRight();
                        } else {
                            left = materialCalendarGridView.getChildAtPosition(min).getLeft();
                        }
                        horizontalMidPoint2 = left;
                        dayToPosition2 = min;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        dayToPosition2 = adapter2.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        horizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(dayToPosition2));
                    }
                    int itemId = (int) adapter2.getItemId(dayToPosition);
                    int i2 = max;
                    int i3 = min;
                    int itemId2 = (int) adapter2.getItemId(dayToPosition2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        MonthAdapter monthAdapter = adapter2;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (!isLayoutRtl) {
                            i = numColumns > dayToPosition ? 0 : horizontalMidPoint;
                            width = dayToPosition2 > numColumns2 ? getWidth() : horizontalMidPoint2;
                        } else {
                            int i4 = dayToPosition2 > numColumns2 ? 0 : horizontalMidPoint2;
                            width = numColumns > dayToPosition ? getWidth() : horizontalMidPoint;
                            i = i4;
                        }
                        canvas.drawRect(i, top, width, bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter2 = monthAdapter;
                    }
                    materialCalendarGridView = this;
                    max = i2;
                    min = i3;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.nestedScrollable) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            gainFocus(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    private void gainFocus(int i, Rect rect) {
        int findLastValidDayPosition;
        if (i == 33 || i == 1) {
            findLastValidDayPosition = getAdapter2().findLastValidDayPosition();
        } else {
            findLastValidDayPosition = (i == 130 || i == 2) ? getAdapter2().findFirstValidDayPosition() : -1;
        }
        if (findLastValidDayPosition != -1) {
            setSelection(findLastValidDayPosition);
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    private View getChildAtPosition(int i) {
        return getChildAt(i - getFirstVisiblePosition());
    }

    private static boolean skipMonth(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    private static int horizontalMidPoint(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
