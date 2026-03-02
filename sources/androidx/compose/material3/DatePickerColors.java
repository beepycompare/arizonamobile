package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0089\u0002\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u00020\u001c*\u0004\u0018\u00010\u001c2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001c0@H\u0000¢\u0006\u0002\bAJ5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020DH\u0001¢\u0006\u0004\bH\u0010IJ-\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020D2\u0006\u0010K\u001a\u00020DH\u0001¢\u0006\u0004\bL\u0010MJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010N\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020DH\u0001¢\u0006\u0004\bO\u0010MJ%\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020DH\u0001¢\u0006\u0004\bQ\u0010RJ\u0013\u0010S\u001a\u00020D2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010U\u001a\u00020VH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b*\u0010 R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b0\u0010 R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b1\u0010 R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b2\u0010 R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b3\u0010 R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b4\u0010 R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b5\u0010 R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b6\u0010 R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b7\u0010 R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b8\u0010 R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006W"}, d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getTitleContentColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getCurrentYearContentColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDayContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "copy", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "Landroidx/compose/runtime/State;", "isToday", "", "selected", "inRange", "enabled", "dayContentColor$material3", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "dayContainerColor", "animate", "dayContainerColor$material3", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3", "yearContainerColor", "yearContainerColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, textFieldColors);
    }

    private DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors) {
        this.containerColor = j;
        this.titleContentColor = j2;
        this.headlineContentColor = j3;
        this.weekdayContentColor = j4;
        this.subheadContentColor = j5;
        this.navigationContentColor = j6;
        this.yearContentColor = j7;
        this.disabledYearContentColor = j8;
        this.currentYearContentColor = j9;
        this.selectedYearContentColor = j10;
        this.disabledSelectedYearContentColor = j11;
        this.selectedYearContainerColor = j12;
        this.disabledSelectedYearContainerColor = j13;
        this.dayContentColor = j14;
        this.disabledDayContentColor = j15;
        this.selectedDayContentColor = j16;
        this.disabledSelectedDayContentColor = j17;
        this.selectedDayContainerColor = j18;
        this.disabledSelectedDayContainerColor = j19;
        this.todayContentColor = j20;
        this.todayDateBorderColor = j21;
        this.dayInSelectionRangeContainerColor = j22;
        this.dayInSelectionRangeContentColor = j23;
        this.dividerColor = j24;
        this.dateTextFieldColors = textFieldColors;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1958getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m1977getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* renamed from: getHeadlineContentColor-0d7_KjU  reason: not valid java name */
    public final long m1970getHeadlineContentColor0d7_KjU() {
        return this.headlineContentColor;
    }

    /* renamed from: getWeekdayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1980getWeekdayContentColor0d7_KjU() {
        return this.weekdayContentColor;
    }

    /* renamed from: getSubheadContentColor-0d7_KjU  reason: not valid java name */
    public final long m1976getSubheadContentColor0d7_KjU() {
        return this.subheadContentColor;
    }

    /* renamed from: getNavigationContentColor-0d7_KjU  reason: not valid java name */
    public final long m1971getNavigationContentColor0d7_KjU() {
        return this.navigationContentColor;
    }

    /* renamed from: getYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1981getYearContentColor0d7_KjU() {
        return this.yearContentColor;
    }

    /* renamed from: getDisabledYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1968getDisabledYearContentColor0d7_KjU() {
        return this.disabledYearContentColor;
    }

    /* renamed from: getCurrentYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1959getCurrentYearContentColor0d7_KjU() {
        return this.currentYearContentColor;
    }

    /* renamed from: getSelectedYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1975getSelectedYearContentColor0d7_KjU() {
        return this.selectedYearContentColor;
    }

    /* renamed from: getDisabledSelectedYearContentColor-0d7_KjU  reason: not valid java name */
    public final long m1967getDisabledSelectedYearContentColor0d7_KjU() {
        return this.disabledSelectedYearContentColor;
    }

    /* renamed from: getSelectedYearContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1974getSelectedYearContainerColor0d7_KjU() {
        return this.selectedYearContainerColor;
    }

    /* renamed from: getDisabledSelectedYearContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1966getDisabledSelectedYearContainerColor0d7_KjU() {
        return this.disabledSelectedYearContainerColor;
    }

    /* renamed from: getDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1960getDayContentColor0d7_KjU() {
        return this.dayContentColor;
    }

    /* renamed from: getDisabledDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1963getDisabledDayContentColor0d7_KjU() {
        return this.disabledDayContentColor;
    }

    /* renamed from: getSelectedDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1973getSelectedDayContentColor0d7_KjU() {
        return this.selectedDayContentColor;
    }

    /* renamed from: getDisabledSelectedDayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1965getDisabledSelectedDayContentColor0d7_KjU() {
        return this.disabledSelectedDayContentColor;
    }

    /* renamed from: getSelectedDayContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1972getSelectedDayContainerColor0d7_KjU() {
        return this.selectedDayContainerColor;
    }

    /* renamed from: getDisabledSelectedDayContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1964getDisabledSelectedDayContainerColor0d7_KjU() {
        return this.disabledSelectedDayContainerColor;
    }

    /* renamed from: getTodayContentColor-0d7_KjU  reason: not valid java name */
    public final long m1978getTodayContentColor0d7_KjU() {
        return this.todayContentColor;
    }

    /* renamed from: getTodayDateBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1979getTodayDateBorderColor0d7_KjU() {
        return this.todayDateBorderColor;
    }

    /* renamed from: getDayInSelectionRangeContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1961getDayInSelectionRangeContainerColor0d7_KjU() {
        return this.dayInSelectionRangeContainerColor;
    }

    /* renamed from: getDayInSelectionRangeContentColor-0d7_KjU  reason: not valid java name */
    public final long m1962getDayInSelectionRangeContentColor0d7_KjU() {
        return this.dayInSelectionRangeContentColor;
    }

    /* renamed from: getDividerColor-0d7_KjU  reason: not valid java name */
    public final long m1969getDividerColor0d7_KjU() {
        return this.dividerColor;
    }

    public final TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    /* renamed from: copy-tNwlRmA  reason: not valid java name */
    public final DatePickerColors m1957copytNwlRmA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors) {
        return new DatePickerColors(j != 16 ? j : this.containerColor, j2 != 16 ? j2 : this.titleContentColor, j3 != 16 ? j3 : this.headlineContentColor, j4 != 16 ? j4 : this.weekdayContentColor, j5 != 16 ? j5 : this.subheadContentColor, j6 != 16 ? j6 : this.navigationContentColor, j7 != 16 ? j7 : this.yearContentColor, j8 != 16 ? j8 : this.disabledYearContentColor, j9 != 16 ? j9 : this.currentYearContentColor, j10 != 16 ? j10 : this.selectedYearContentColor, j11 != 16 ? j11 : this.disabledSelectedYearContentColor, j12 != 16 ? j12 : this.selectedYearContainerColor, j13 != 16 ? j13 : this.disabledSelectedYearContainerColor, j14 != 16 ? j14 : this.dayContentColor, j15 != 16 ? j15 : this.disabledDayContentColor, j16 != 16 ? j16 : this.selectedDayContentColor, j17 != 16 ? j17 : this.disabledSelectedDayContentColor, j18 != 16 ? j18 : this.selectedDayContainerColor, j19 != 16 ? j19 : this.disabledSelectedDayContainerColor, j20 != 16 ? j20 : this.todayContentColor, j21 != 16 ? j21 : this.todayDateBorderColor, j22 != 16 ? j22 : this.dayInSelectionRangeContainerColor, j23 != 16 ? j23 : this.dayInSelectionRangeContentColor, j24 != 16 ? j24 : this.dividerColor, takeOrElse$material3(textFieldColors, new Function0() { // from class: androidx.compose.material3.DatePickerColors$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextFieldColors textFieldColors2;
                textFieldColors2 = DatePickerColors.this.dateTextFieldColors;
                return textFieldColors2;
            }
        }), null);
    }

    public final TextFieldColors takeOrElse$material3(TextFieldColors textFieldColors, Function0<TextFieldColors> function0) {
        return textFieldColors == null ? function0.invoke() : textFieldColors;
    }

    public final State<Color> dayContentColor$material3(boolean z, boolean z2, boolean z3, boolean z4, Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> m134animateColorAsStateeuL9pac;
        ComposerKt.sourceInformationMarkerStart(composer, -1233694918, "C(dayContentColor)N(isToday,selected,inRange,enabled):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233694918, i, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:940)");
        }
        if (z2 && z4) {
            j = this.selectedDayContentColor;
        } else if (z2 && !z4) {
            j = this.disabledSelectedDayContentColor;
        } else if (z3 && z4) {
            j = this.dayInSelectionRangeContentColor;
        } else if (z3 && !z4) {
            j = this.disabledDayContentColor;
        } else if (z && z4) {
            j = this.todayContentColor;
        } else if (z4) {
            j = this.dayContentColor;
        } else {
            j = this.disabledDayContentColor;
        }
        long j2 = j;
        if (z3) {
            composer.startReplaceGroup(-969483020);
            ComposerKt.sourceInformation(composer, "953@46356L28");
            m134animateColorAsStateeuL9pac = SnapshotStateKt.rememberUpdatedState(Color.m4762boximpl(j2), composer, 0);
            composer.endReplaceGroup();
            composer2 = composer;
        } else {
            composer.startReplaceGroup(-969417610);
            ComposerKt.sourceInformation(composer, "959@46674L7,956@46492L204");
            composer2 = composer;
            m134animateColorAsStateeuL9pac = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(j2, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return m134animateColorAsStateeuL9pac;
    }

    public final State<Color> dayContainerColor$material3(boolean z, boolean z2, boolean z3, Composer composer, int i) {
        long m4807getTransparent0d7_KjU;
        Composer composer2;
        State<Color> rememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart(composer, -1240482658, "C(dayContainerColor)N(selected,enabled,animate):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1240482658, i, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:976)");
        }
        if (z) {
            m4807getTransparent0d7_KjU = z2 ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor;
        } else {
            m4807getTransparent0d7_KjU = Color.Companion.m4807getTransparent0d7_KjU();
        }
        long j = m4807getTransparent0d7_KjU;
        if (z3) {
            composer.startReplaceGroup(-1319856736);
            ComposerKt.sourceInformation(composer, "987@47597L7,984@47415L204");
            composer2 = composer;
            rememberUpdatedState = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(j, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-1319630064);
            ComposerKt.sourceInformation(composer2, "990@47649L28");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4762boximpl(j), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return rememberUpdatedState;
    }

    public final State<Color> yearContentColor$material3(boolean z, boolean z2, boolean z3, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, 874111097, "C(yearContentColor)N(currentYear,selected,enabled)1019@48707L7,1016@48537L188:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(874111097, i, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:1006)");
        }
        if (z2 && z3) {
            j = this.selectedYearContentColor;
        } else if (z2 && !z3) {
            j = this.disabledSelectedYearContentColor;
        } else if (z && z3) {
            j = this.currentYearContentColor;
        } else if (z3) {
            j = this.yearContentColor;
        } else {
            j = this.disabledYearContentColor;
        }
        State<Color> m134animateColorAsStateeuL9pac = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(j, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m134animateColorAsStateeuL9pac;
    }

    public final State<Color> yearContainerColor$material3(boolean z, boolean z2, Composer composer, int i) {
        long m4807getTransparent0d7_KjU;
        ComposerKt.sourceInformationMarkerStart(composer, -1306331107, "C(yearContainerColor)N(selected,enabled)1040@49460L7,1037@49290L188:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1306331107, i, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:1030)");
        }
        if (z) {
            m4807getTransparent0d7_KjU = z2 ? this.selectedYearContainerColor : this.disabledSelectedYearContainerColor;
        } else {
            m4807getTransparent0d7_KjU = Color.Companion.m4807getTransparent0d7_KjU();
        }
        State<Color> m134animateColorAsStateeuL9pac = SingleValueAnimationKt.m134animateColorAsStateeuL9pac(m4807getTransparent0d7_KjU, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m134animateColorAsStateeuL9pac;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DatePickerColors) {
            DatePickerColors datePickerColors = (DatePickerColors) obj;
            return Color.m4773equalsimpl0(this.containerColor, datePickerColors.containerColor) && Color.m4773equalsimpl0(this.titleContentColor, datePickerColors.titleContentColor) && Color.m4773equalsimpl0(this.headlineContentColor, datePickerColors.headlineContentColor) && Color.m4773equalsimpl0(this.weekdayContentColor, datePickerColors.weekdayContentColor) && Color.m4773equalsimpl0(this.subheadContentColor, datePickerColors.subheadContentColor) && Color.m4773equalsimpl0(this.yearContentColor, datePickerColors.yearContentColor) && Color.m4773equalsimpl0(this.disabledYearContentColor, datePickerColors.disabledYearContentColor) && Color.m4773equalsimpl0(this.currentYearContentColor, datePickerColors.currentYearContentColor) && Color.m4773equalsimpl0(this.selectedYearContentColor, datePickerColors.selectedYearContentColor) && Color.m4773equalsimpl0(this.disabledSelectedYearContentColor, datePickerColors.disabledSelectedYearContentColor) && Color.m4773equalsimpl0(this.selectedYearContainerColor, datePickerColors.selectedYearContainerColor) && Color.m4773equalsimpl0(this.disabledSelectedYearContainerColor, datePickerColors.disabledSelectedYearContainerColor) && Color.m4773equalsimpl0(this.dayContentColor, datePickerColors.dayContentColor) && Color.m4773equalsimpl0(this.disabledDayContentColor, datePickerColors.disabledDayContentColor) && Color.m4773equalsimpl0(this.selectedDayContentColor, datePickerColors.selectedDayContentColor) && Color.m4773equalsimpl0(this.disabledSelectedDayContentColor, datePickerColors.disabledSelectedDayContentColor) && Color.m4773equalsimpl0(this.selectedDayContainerColor, datePickerColors.selectedDayContainerColor) && Color.m4773equalsimpl0(this.disabledSelectedDayContainerColor, datePickerColors.disabledSelectedDayContainerColor) && Color.m4773equalsimpl0(this.todayContentColor, datePickerColors.todayContentColor) && Color.m4773equalsimpl0(this.todayDateBorderColor, datePickerColors.todayDateBorderColor) && Color.m4773equalsimpl0(this.dayInSelectionRangeContainerColor, datePickerColors.dayInSelectionRangeContainerColor) && Color.m4773equalsimpl0(this.dayInSelectionRangeContentColor, datePickerColors.dayInSelectionRangeContentColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.m4779hashCodeimpl(this.containerColor) * 31) + Color.m4779hashCodeimpl(this.titleContentColor)) * 31) + Color.m4779hashCodeimpl(this.headlineContentColor)) * 31) + Color.m4779hashCodeimpl(this.weekdayContentColor)) * 31) + Color.m4779hashCodeimpl(this.subheadContentColor)) * 31) + Color.m4779hashCodeimpl(this.yearContentColor)) * 31) + Color.m4779hashCodeimpl(this.disabledYearContentColor)) * 31) + Color.m4779hashCodeimpl(this.currentYearContentColor)) * 31) + Color.m4779hashCodeimpl(this.selectedYearContentColor)) * 31) + Color.m4779hashCodeimpl(this.disabledSelectedYearContentColor)) * 31) + Color.m4779hashCodeimpl(this.selectedYearContainerColor)) * 31) + Color.m4779hashCodeimpl(this.disabledSelectedYearContainerColor)) * 31) + Color.m4779hashCodeimpl(this.dayContentColor)) * 31) + Color.m4779hashCodeimpl(this.disabledDayContentColor)) * 31) + Color.m4779hashCodeimpl(this.selectedDayContentColor)) * 31) + Color.m4779hashCodeimpl(this.disabledSelectedDayContentColor)) * 31) + Color.m4779hashCodeimpl(this.selectedDayContainerColor)) * 31) + Color.m4779hashCodeimpl(this.disabledSelectedDayContainerColor)) * 31) + Color.m4779hashCodeimpl(this.todayContentColor)) * 31) + Color.m4779hashCodeimpl(this.todayDateBorderColor)) * 31) + Color.m4779hashCodeimpl(this.dayInSelectionRangeContainerColor)) * 31) + Color.m4779hashCodeimpl(this.dayInSelectionRangeContentColor);
    }
}
