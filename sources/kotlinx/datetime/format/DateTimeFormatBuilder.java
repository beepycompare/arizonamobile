package kotlinx.datetime.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.YearMonth;
/* compiled from: DateTimeFormatBuilder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0006\u0007\b\t\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder;", "", "chars", "", "value", "", "WithYearMonth", "WithDate", "WithTime", "WithDateTime", "WithUtcOffset", "WithDateTimeComponents", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithYearMonth;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DateTimeFormatBuilder {
    void chars(String str);

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&\u0082\u0001\u0002\u000f\u0010¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithYearMonth;", "day", "", "padding", "Lkotlinx/datetime/format/Padding;", "dayOfMonth", "dayOfWeek", "names", "Lkotlinx/datetime/format/DayOfWeekNames;", "dayOfYear", "date", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "Lkotlinx/datetime/format/AbstractWithDateBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithDate extends WithYearMonth {
        void date(DateTimeFormat<LocalDate> dateTimeFormat);

        void day(Padding padding);

        void dayOfWeek(DayOfWeekNames dayOfWeekNames);

        void dayOfYear(Padding padding);

        /* compiled from: Deprecations.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"kotlinx/datetime/format/DateTimeFormatBuilder$WithDate$DefaultImpls", "", "<init>", "()V", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public final class DefaultImpls {
            public static final Companion Companion = new Companion(null);

            @JvmStatic
            public static final void dayOfMonth(WithDate withDate, Padding padding) {
                Companion.dayOfMonth(withDate, padding);
            }

            /* compiled from: Deprecations.kt */
            @Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007J,\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007J,\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J,\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0012"}, d2 = {"kotlinx/datetime/format/DateTimeFormatBuilder$WithDate$DefaultImpls.Companion", "", "<init>", "()V", "monthNumber$default", "", "format", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "padding", "Lkotlinx/datetime/format/Padding;", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "", "j", "dayOfYear$default", "year$default", "day$default", "dayOfMonth", "dayOfMonth$default", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @JvmStatic
                public final void monthNumber$default(WithDate format, Padding padding, int i, Object obj) {
                    Intrinsics.checkNotNullParameter(format, "format");
                    WithYearMonth.monthNumber$default(format, null, 1, null);
                }

                @JvmStatic
                public final void dayOfYear$default(WithDate format, Padding padding, int i, Object obj) {
                    Intrinsics.checkNotNullParameter(format, "format");
                    WithDate.dayOfYear$default(format, null, 1, null);
                }

                @JvmStatic
                public final void year$default(WithDate format, Padding padding, int i, Object obj) {
                    Intrinsics.checkNotNullParameter(format, "format");
                    WithYearMonth.year$default(format, null, 1, null);
                }

                @JvmStatic
                public final void day$default(WithDate format, Padding padding, int i, Object obj) {
                    Intrinsics.checkNotNullParameter(format, "format");
                    WithDate.day$default(format, null, 1, null);
                }

                @JvmStatic
                public final void dayOfMonth(WithDate format, Padding padding) {
                    Intrinsics.checkNotNullParameter(format, "format");
                    if (padding == null) {
                        padding = Padding.ZERO;
                    }
                    format.day(padding);
                }

                @JvmStatic
                public final void dayOfMonth$default(WithDate format, Padding padding, int i, Object obj) {
                    Intrinsics.checkNotNullParameter(format, "format");
                    WithDate.day$default(format, null, 1, null);
                }
            }
        }

        static /* synthetic */ void day$default(WithDate withDate, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: day");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withDate.day(padding);
        }

        static /* synthetic */ void dayOfMonth$default(WithDate withDate, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dayOfMonth");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withDate.dayOfMonth(padding);
        }

        @Deprecated(message = "Use 'day' instead", replaceWith = @ReplaceWith(expression = "day(padding = padding)", imports = {}))
        default void dayOfMonth(Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            day(padding);
        }

        static /* synthetic */ void dayOfYear$default(WithDate withDate, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dayOfYear");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withDate.dayOfYear(padding);
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithYearMonth;", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "year", "", "padding", "Lkotlinx/datetime/format/Padding;", "yearTwoDigits", "baseYear", "", "monthNumber", "monthName", "names", "Lkotlinx/datetime/format/MonthNames;", "yearMonth", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/YearMonth;", "Lkotlinx/datetime/format/AbstractWithYearMonthBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithYearMonth extends DateTimeFormatBuilder {
        void monthName(MonthNames monthNames);

        void monthNumber(Padding padding);

        void year(Padding padding);

        void yearMonth(DateTimeFormat<YearMonth> dateTimeFormat);

        void yearTwoDigits(int i);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
        }

        static /* synthetic */ void year$default(WithYearMonth withYearMonth, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: year");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withYearMonth.year(padding);
        }

        static /* synthetic */ void monthNumber$default(WithYearMonth withYearMonth, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monthNumber");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withYearMonth.monthNumber(padding);
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "hour", "", "padding", "Lkotlinx/datetime/format/Padding;", "amPmHour", "amPmMarker", "am", "", "pm", "minute", "second", "secondFraction", "minLength", "", "maxLength", "fixedLength", "time", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithTime extends DateTimeFormatBuilder {
        void amPmHour(Padding padding);

        void amPmMarker(String str, String str2);

        void hour(Padding padding);

        void minute(Padding padding);

        void second(Padding padding);

        void secondFraction(int i, int i2);

        void time(DateTimeFormat<LocalTime> dateTimeFormat);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static void secondFraction(WithTime withTime, int i) {
                WithTime.super.secondFraction(i);
            }
        }

        static /* synthetic */ void hour$default(WithTime withTime, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hour");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withTime.hour(padding);
        }

        static /* synthetic */ void amPmHour$default(WithTime withTime, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: amPmHour");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withTime.amPmHour(padding);
        }

        static /* synthetic */ void minute$default(WithTime withTime, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: minute");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withTime.minute(padding);
        }

        static /* synthetic */ void second$default(WithTime withTime, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: second");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withTime.second(padding);
        }

        static /* synthetic */ void secondFraction$default(WithTime withTime, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: secondFraction");
            }
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 9;
            }
            withTime.secondFraction(i, i2);
        }

        default void secondFraction(int i) {
            secondFraction(i, i);
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "dateTime", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithDateTime extends WithDate, WithTime {
        void dateTime(DateTimeFormat<LocalDateTime> dateTimeFormat);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            @Deprecated(message = "Use 'day' instead", replaceWith = @ReplaceWith(expression = "day(padding = padding)", imports = {}))
            @Deprecated
            public static void dayOfMonth(WithDateTime withDateTime, Padding padding) {
                Intrinsics.checkNotNullParameter(padding, "padding");
                WithDateTime.super.dayOfMonth(padding);
            }

            @Deprecated
            public static void secondFraction(WithDateTime withDateTime, int i) {
                WithDateTime.super.secondFraction(i);
            }
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&\u0082\u0001\u0002\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "offsetHours", "", "padding", "Lkotlinx/datetime/format/Padding;", "offsetMinutesOfHour", "offsetSecondsOfMinute", TypedValues.CycleType.S_WAVE_OFFSET, "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithUtcOffset extends DateTimeFormatBuilder {
        void offset(DateTimeFormat<UtcOffset> dateTimeFormat);

        void offsetHours(Padding padding);

        void offsetMinutesOfHour(Padding padding);

        void offsetSecondsOfMinute(Padding padding);

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
        }

        static /* synthetic */ void offsetHours$default(WithUtcOffset withUtcOffset, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetHours");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withUtcOffset.offsetHours(padding);
        }

        static /* synthetic */ void offsetMinutesOfHour$default(WithUtcOffset withUtcOffset, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetMinutesOfHour");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withUtcOffset.offsetMinutesOfHour(padding);
        }

        static /* synthetic */ void offsetSecondsOfMinute$default(WithUtcOffset withUtcOffset, Padding padding, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetSecondsOfMinute");
            }
            if ((i & 1) != 0) {
                padding = Padding.ZERO;
            }
            withUtcOffset.offsetSecondsOfMinute(padding);
        }
    }

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u0082\u0001\u0001\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTime;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "timeZoneId", "", "dateTimeComponents", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "Lkotlinx/datetime/format/DateTimeComponentsFormat$Builder;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithDateTimeComponents extends WithDateTime, WithUtcOffset {
        void dateTimeComponents(DateTimeFormat<DateTimeComponents> dateTimeFormat);

        void timeZoneId();

        /* compiled from: DateTimeFormatBuilder.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            @Deprecated(message = "Use 'day' instead", replaceWith = @ReplaceWith(expression = "day(padding = padding)", imports = {}))
            @Deprecated
            public static void dayOfMonth(WithDateTimeComponents withDateTimeComponents, Padding padding) {
                Intrinsics.checkNotNullParameter(padding, "padding");
                WithDateTimeComponents.super.dayOfMonth(padding);
            }

            @Deprecated
            public static void secondFraction(WithDateTimeComponents withDateTimeComponents, int i) {
                WithDateTimeComponents.super.secondFraction(i);
            }
        }
    }
}
