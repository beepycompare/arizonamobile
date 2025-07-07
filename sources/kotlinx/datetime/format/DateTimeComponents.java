package kotlinx.datetime.format;

import java.time.DayOfWeek;
import java.time.Month;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeComponentsFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 v2\u00020\u0001:\u0002vwB\u0011\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dJ\u000e\u0010e\u001a\u00020b2\u0006\u0010f\u001a\u00020gJ\u0016\u0010h\u001a\u00020b2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lJ\u0016\u0010h\u001a\u00020b2\u0006\u0010f\u001a\u00020g2\u0006\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u00020b2\u0006\u0010k\u001a\u00020lJ\u000e\u0010n\u001a\u00020b2\u0006\u0010o\u001a\u00020pJ\u0006\u0010q\u001a\u00020jJ\u0006\u0010r\u001a\u00020dJ\u0006\u0010s\u001a\u00020gJ\u0006\u0010t\u001a\u00020pJ\u0006\u0010u\u001a\u00020lR/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r*\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR/\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R4\u0010\u001b\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u000e\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R/\u0010%\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R/\u0010)\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0017\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R/\u0010-\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0017\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R4\u00103\u001a\n\u0018\u000101j\u0004\u0018\u0001`22\u000e\u0010\u0018\u001a\n\u0018\u000101j\u0004\u0018\u0001`28F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R/\u00108\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0017\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015R(\u0010<\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010\u0015R/\u0010?\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010\u0017\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u0010\u0015R/\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u0005\u001a\u0004\u0018\u00010C8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I*\u0004\bE\u0010\tR/\u0010J\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010\u0017\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015R/\u0010N\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010\u0017\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R/\u0010R\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0017\u001a\u0004\bS\u0010\u0013\"\u0004\bT\u0010\u0015R/\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\u0005\u001a\u0004\u0018\u00010V8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\*\u0004\bX\u0010\tR/\u0010]\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b_\u0010\u0013\"\u0004\b`\u0010\u0015*\u0004\b^\u0010\t¨\u0006x"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents;", "", "contents", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "(Lkotlinx/datetime/format/DateTimeComponentsContents;)V", "<set-?>", "Lkotlinx/datetime/format/AmPmMarker;", "amPm", "getAmPm$delegate", "(Lkotlinx/datetime/format/DateTimeComponents;)Ljava/lang/Object;", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "getContents$kotlinx_datetime", "()Lkotlinx/datetime/format/DateTimeComponentsContents;", "", "dayOfMonth", "getDayOfMonth", "()Ljava/lang/Integer;", "setDayOfMonth", "(Ljava/lang/Integer;)V", "dayOfMonth$delegate", "Lkotlinx/datetime/format/TwoDigitNumber;", "value", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "dayOfWeek", "getDayOfWeek", "()Ljava/time/DayOfWeek;", "setDayOfWeek", "(Ljava/time/DayOfWeek;)V", "dayOfYear", "getDayOfYear", "setDayOfYear", "dayOfYear$delegate", "Lkotlinx/datetime/format/ThreeDigitNumber;", "hour", "getHour", "setHour", "hour$delegate", "hourOfAmPm", "getHourOfAmPm", "setHourOfAmPm", "hourOfAmPm$delegate", "minute", "getMinute", "setMinute", "minute$delegate", "Ljava/time/Month;", "Lkotlinx/datetime/Month;", "month", "getMonth", "()Ljava/time/Month;", "setMonth", "(Ljava/time/Month;)V", "monthNumber", "getMonthNumber", "setMonthNumber", "monthNumber$delegate", "nanosecond", "getNanosecond", "setNanosecond", "offsetHours", "getOffsetHours", "setOffsetHours", "offsetHours$delegate", "", "offsetIsNegative", "getOffsetIsNegative$delegate", "getOffsetIsNegative", "()Ljava/lang/Boolean;", "setOffsetIsNegative", "(Ljava/lang/Boolean;)V", "offsetMinutesOfHour", "getOffsetMinutesOfHour", "setOffsetMinutesOfHour", "offsetMinutesOfHour$delegate", "offsetSecondsOfMinute", "getOffsetSecondsOfMinute", "setOffsetSecondsOfMinute", "offsetSecondsOfMinute$delegate", "second", "getSecond", "setSecond", "second$delegate", "", "timeZoneId", "getTimeZoneId$delegate", "getTimeZoneId", "()Ljava/lang/String;", "setTimeZoneId", "(Ljava/lang/String;)V", "year", "getYear$delegate", "getYear", "setYear", "setDate", "", "localDate", "Lkotlinx/datetime/LocalDate;", "setDateTime", "localDateTime", "Lkotlinx/datetime/LocalDateTime;", "setDateTimeOffset", "instant", "Lkotlinx/datetime/Instant;", "utcOffset", "Lkotlinx/datetime/UtcOffset;", "setOffset", "setTime", "localTime", "Lkotlinx/datetime/LocalTime;", "toInstantUsingOffset", "toLocalDate", "toLocalDateTime", "toLocalTime", "toUtcOffset", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTimeComponents {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "monthNumber", "getMonthNumber()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "dayOfMonth", "getDayOfMonth()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "dayOfYear", "getDayOfYear()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hour", "getHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hourOfAmPm", "getHourOfAmPm()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "minute", "getMinute()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "second", "getSecond()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetHours", "getOffsetHours()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetMinutesOfHour", "getOffsetMinutesOfHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetSecondsOfMinute", "getOffsetSecondsOfMinute()Ljava/lang/Integer;", 0))};
    public static final Companion Companion = new Companion(null);
    private final DateTimeComponentsContents contents;
    private final TwoDigitNumber dayOfMonth$delegate;
    private final ThreeDigitNumber dayOfYear$delegate;
    private final TwoDigitNumber hour$delegate;
    private final TwoDigitNumber hourOfAmPm$delegate;
    private final TwoDigitNumber minute$delegate;
    private final TwoDigitNumber monthNumber$delegate;
    private final TwoDigitNumber offsetHours$delegate;
    private final TwoDigitNumber offsetMinutesOfHour$delegate;
    private final TwoDigitNumber offsetSecondsOfMinute$delegate;
    private final TwoDigitNumber second$delegate;

    public DateTimeComponents() {
        this(null, 1, null);
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents$Companion;", "", "()V", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DateTimeFormat<DateTimeComponents> Format(Function1<? super DateTimeFormatBuilder.WithDateTimeComponents, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            DateTimeComponentsFormat.Builder builder = new DateTimeComponentsFormat.Builder(new AppendableFormatStructure());
            block.invoke(builder);
            return new DateTimeComponentsFormat(builder.build());
        }
    }

    public DateTimeComponents(DateTimeComponentsContents contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.contents = contents;
        contents.getDate();
        final IncompleteLocalDate date = contents.getDate();
        this.monthNumber$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(date) { // from class: kotlinx.datetime.format.DateTimeComponents$monthNumber$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getMonthNumber();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalDate) this.receiver).setMonthNumber((Integer) obj);
            }
        });
        final IncompleteLocalDate date2 = contents.getDate();
        this.dayOfMonth$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(date2) { // from class: kotlinx.datetime.format.DateTimeComponents$dayOfMonth$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getDayOfMonth();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalDate) this.receiver).setDayOfMonth((Integer) obj);
            }
        });
        final IncompleteLocalDate date3 = contents.getDate();
        this.dayOfYear$delegate = new ThreeDigitNumber(new MutablePropertyReference0Impl(date3) { // from class: kotlinx.datetime.format.DateTimeComponents$dayOfYear$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getDayOfYear();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalDate) this.receiver).setDayOfYear((Integer) obj);
            }
        });
        final IncompleteLocalTime time = contents.getTime();
        this.hour$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time) { // from class: kotlinx.datetime.format.DateTimeComponents$hour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getHour();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalTime) this.receiver).setHour((Integer) obj);
            }
        });
        final IncompleteLocalTime time2 = contents.getTime();
        this.hourOfAmPm$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time2) { // from class: kotlinx.datetime.format.DateTimeComponents$hourOfAmPm$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getHourOfAmPm();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalTime) this.receiver).setHourOfAmPm((Integer) obj);
            }
        });
        contents.getTime();
        final IncompleteLocalTime time3 = contents.getTime();
        this.minute$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time3) { // from class: kotlinx.datetime.format.DateTimeComponents$minute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getMinute();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalTime) this.receiver).setMinute((Integer) obj);
            }
        });
        final IncompleteLocalTime time4 = contents.getTime();
        this.second$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(time4) { // from class: kotlinx.datetime.format.DateTimeComponents$second$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalTime) this.receiver).getSecond();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalTime) this.receiver).setSecond((Integer) obj);
            }
        });
        contents.getOffset();
        final IncompleteUtcOffset offset = contents.getOffset();
        this.offsetHours$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetHours$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getTotalHoursAbs();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteUtcOffset) this.receiver).setTotalHoursAbs((Integer) obj);
            }
        });
        final IncompleteUtcOffset offset2 = contents.getOffset();
        this.offsetMinutesOfHour$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset2) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetMinutesOfHour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getMinutesOfHour();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteUtcOffset) this.receiver).setMinutesOfHour((Integer) obj);
            }
        });
        final IncompleteUtcOffset offset3 = contents.getOffset();
        this.offsetSecondsOfMinute$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset3) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetSecondsOfMinute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getSecondsOfMinute();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteUtcOffset) this.receiver).setSecondsOfMinute((Integer) obj);
            }
        });
    }

    public /* synthetic */ DateTimeComponents(DateTimeComponentsContents dateTimeComponentsContents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DateTimeComponentsContents(null, null, null, null, 15, null) : dateTimeComponentsContents);
    }

    public final DateTimeComponentsContents getContents$kotlinx_datetime() {
        return this.contents;
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents$Formats;", "", "()V", "ISO_DATE_TIME_OFFSET", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "getISO_DATE_TIME_OFFSET", "()Lkotlinx/datetime/format/DateTimeFormat;", "RFC_1123", "getRFC_1123", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<DateTimeComponents> ISO_DATE_TIME_OFFSET = DateTimeComponents.Companion.Format(new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                invoke2(withDateTimeComponents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents Format) {
                Intrinsics.checkNotNullParameter(Format, "$this$Format");
                Format.date(LocalDateFormatKt.getISO_DATE());
                DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents = Format;
                DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2) {
                        invoke2(withDateTimeComponents2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilderKt.m10056char(alternativeParsing, 't');
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2) {
                        invoke2(withDateTimeComponents2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilderKt.m10056char(alternativeParsing, 'T');
                    }
                });
                DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2 = Format;
                DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default(withDateTimeComponents2, null, 1, null);
                DateTimeFormatBuilderKt.m10056char(withDateTimeComponents, AbstractJsonLexerKt.COLON);
                DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default(withDateTimeComponents2, null, 1, null);
                DateTimeFormatBuilderKt.m10056char(withDateTimeComponents, AbstractJsonLexerKt.COLON);
                DateTimeFormatBuilder.WithTime.DefaultImpls.second$default(withDateTimeComponents2, null, 1, null);
                DateTimeFormatBuilderKt.optional$default(withDateTimeComponents, null, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        DateTimeFormatBuilderKt.m10056char(optional, '.');
                        optional.secondFraction(1, 9);
                    }
                }, 1, null);
                DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(alternativeParsing, null, 1, null);
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.offset(UtcOffset.Formats.INSTANCE.getISO());
                    }
                });
            }
        });
        private static final DateTimeFormat<DateTimeComponents> RFC_1123 = DateTimeComponents.Companion.Format(new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents) {
                invoke2(withDateTimeComponents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents Format) {
                Intrinsics.checkNotNullParameter(Format, "$this$Format");
                DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents = Format;
                DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2) {
                        invoke2(withDateTimeComponents2);
                        return Unit.INSTANCE;
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2) {
                        invoke2(withDateTimeComponents2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.dayOfWeek(DayOfWeekNames.Companion.getENGLISH_ABBREVIATED());
                        alternativeParsing.chars(", ");
                    }
                });
                Format.dayOfMonth(Padding.NONE);
                DateTimeFormatBuilderKt.m10056char(withDateTimeComponents, ' ');
                Format.monthName(MonthNames.Companion.getENGLISH_ABBREVIATED());
                DateTimeFormatBuilderKt.m10056char(withDateTimeComponents, ' ');
                DateTimeFormatBuilder.WithDate.DefaultImpls.year$default(Format, null, 1, null);
                DateTimeFormatBuilderKt.m10056char(withDateTimeComponents, ' ');
                DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2 = Format;
                DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default(withDateTimeComponents2, null, 1, null);
                DateTimeFormatBuilderKt.m10056char(withDateTimeComponents, AbstractJsonLexerKt.COLON);
                DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default(withDateTimeComponents2, null, 1, null);
                DateTimeFormatBuilderKt.optional$default(withDateTimeComponents, null, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        DateTimeFormatBuilderKt.m10056char(optional, AbstractJsonLexerKt.COLON);
                        DateTimeFormatBuilder.WithTime.DefaultImpls.second$default(optional, null, 1, null);
                    }
                }, 1, null);
                Format.chars(" ");
                DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.chars("UT");
                    }
                }, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        alternativeParsing.chars("Z");
                    }
                }}, new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                        invoke2(withDateTimeComponents3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        DateTimeFormatBuilderKt.optional(alternativeParsing, "GMT", new Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit>() { // from class: kotlinx.datetime.format.DateTimeComponents.Formats.RFC_1123.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents3) {
                                invoke2(withDateTimeComponents3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
                                Intrinsics.checkNotNullParameter(optional, "$this$optional");
                                optional.offset(UtcOffset.Formats.INSTANCE.getFOUR_DIGITS());
                            }
                        });
                    }
                });
            }
        });

        private Formats() {
        }

        public final DateTimeFormat<DateTimeComponents> getISO_DATE_TIME_OFFSET() {
            return ISO_DATE_TIME_OFFSET;
        }

        public final DateTimeFormat<DateTimeComponents> getRFC_1123() {
            return RFC_1123;
        }
    }

    public final void setTime(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        this.contents.getTime().populateFrom(localTime);
    }

    public final void setDate(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "localDate");
        this.contents.getDate().populateFrom(localDate);
    }

    public final void setDateTime(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        this.contents.getDate().populateFrom(localDateTime.getDate());
        this.contents.getTime().populateFrom(localDateTime.getTime());
    }

    public final void setOffset(UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(utcOffset, "utcOffset");
        this.contents.getOffset().populateFrom(utcOffset);
    }

    public final void setDateTimeOffset(Instant instant, UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(utcOffset, "utcOffset");
        setDateTime(TimeZoneKt.toLocalDateTime(Instant.Companion.fromEpochSeconds(instant.getEpochSeconds() % DateCalculationsKt.SECONDS_PER_10000_YEARS, instant.getNanosecondsOfSecond()), utcOffset));
        setOffset(utcOffset);
        Integer year = getYear();
        Intrinsics.checkNotNull(year);
        setYear(Integer.valueOf(year.intValue() + ((int) ((instant.getEpochSeconds() / DateCalculationsKt.SECONDS_PER_10000_YEARS) * 10000))));
    }

    public final void setDateTimeOffset(LocalDateTime localDateTime, UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        Intrinsics.checkNotNullParameter(utcOffset, "utcOffset");
        setDateTime(localDateTime);
        setOffset(utcOffset);
    }

    public final Integer getYear() {
        return this.contents.getDate().getYear();
    }

    public final void setYear(Integer num) {
        this.contents.getDate().setYear(num);
    }

    public final Integer getMonthNumber() {
        return this.monthNumber$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setMonthNumber(Integer num) {
        this.monthNumber$delegate.setValue(this, $$delegatedProperties[0], num);
    }

    public final Month getMonth() {
        Integer monthNumber = getMonthNumber();
        if (monthNumber != null) {
            return MonthKt.Month(monthNumber.intValue());
        }
        return null;
    }

    public final void setMonth(Month month) {
        setMonthNumber(month != null ? Integer.valueOf(MonthKt.getNumber(month)) : null);
    }

    public final Integer getDayOfMonth() {
        return this.dayOfMonth$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setDayOfMonth(Integer num) {
        this.dayOfMonth$delegate.setValue(this, $$delegatedProperties[1], num);
    }

    public final DayOfWeek getDayOfWeek() {
        Integer isoDayOfWeek = this.contents.getDate().getIsoDayOfWeek();
        if (isoDayOfWeek != null) {
            return DayOfWeekKt.DayOfWeek(isoDayOfWeek.intValue());
        }
        return null;
    }

    public final void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.contents.getDate().setIsoDayOfWeek(dayOfWeek != null ? Integer.valueOf(DayOfWeekKt.getIsoDayNumber(dayOfWeek)) : null);
    }

    public final Integer getDayOfYear() {
        return this.dayOfYear$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setDayOfYear(Integer num) {
        this.dayOfYear$delegate.setValue(this, $$delegatedProperties[2], num);
    }

    public final Integer getHour() {
        return this.hour$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setHour(Integer num) {
        this.hour$delegate.setValue(this, $$delegatedProperties[3], num);
    }

    public final Integer getHourOfAmPm() {
        return this.hourOfAmPm$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setHourOfAmPm(Integer num) {
        this.hourOfAmPm$delegate.setValue(this, $$delegatedProperties[4], num);
    }

    public final AmPmMarker getAmPm() {
        return this.contents.getTime().getAmPm();
    }

    public final void setAmPm(AmPmMarker amPmMarker) {
        this.contents.getTime().setAmPm(amPmMarker);
    }

    public final Integer getMinute() {
        return this.minute$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setMinute(Integer num) {
        this.minute$delegate.setValue(this, $$delegatedProperties[5], num);
    }

    public final Integer getSecond() {
        return this.second$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final void setSecond(Integer num) {
        this.second$delegate.setValue(this, $$delegatedProperties[6], num);
    }

    public final Integer getNanosecond() {
        return this.contents.getTime().getNanosecond();
    }

    public final void setNanosecond(Integer num) {
        if (num != null && !new IntRange(0, 999999999).contains(num.intValue())) {
            throw new IllegalArgumentException("Nanosecond must be in the range [0, 999_999_999].".toString());
        }
        this.contents.getTime().setNanosecond(num);
    }

    public final Boolean getOffsetIsNegative() {
        return this.contents.getOffset().isNegative();
    }

    public final void setOffsetIsNegative(Boolean bool) {
        this.contents.getOffset().setNegative(bool);
    }

    public final Integer getOffsetHours() {
        return this.offsetHours$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void setOffsetHours(Integer num) {
        this.offsetHours$delegate.setValue(this, $$delegatedProperties[7], num);
    }

    public final Integer getOffsetMinutesOfHour() {
        return this.offsetMinutesOfHour$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final void setOffsetMinutesOfHour(Integer num) {
        this.offsetMinutesOfHour$delegate.setValue(this, $$delegatedProperties[8], num);
    }

    public final Integer getOffsetSecondsOfMinute() {
        return this.offsetSecondsOfMinute$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final void setOffsetSecondsOfMinute(Integer num) {
        this.offsetSecondsOfMinute$delegate.setValue(this, $$delegatedProperties[9], num);
    }

    public final String getTimeZoneId() {
        return this.contents.getTimeZoneId();
    }

    public final void setTimeZoneId(String str) {
        this.contents.setTimeZoneId(str);
    }

    public final UtcOffset toUtcOffset() {
        return this.contents.getOffset().toUtcOffset();
    }

    public final LocalDate toLocalDate() {
        return this.contents.getDate().toLocalDate();
    }

    public final LocalTime toLocalTime() {
        return this.contents.getTime().toLocalTime();
    }

    public final LocalDateTime toLocalDateTime() {
        return LocalDateKt.atTime(toLocalDate(), toLocalTime());
    }

    public final Instant toInstantUsingOffset() {
        UtcOffset utcOffset = toUtcOffset();
        LocalTime localTime = toLocalTime();
        IncompleteLocalDate copy = this.contents.getDate().copy();
        copy.setYear(Integer.valueOf(((Number) LocalDateFormatKt.requireParsedField(copy.getYear(), "year")).intValue() % 10000));
        try {
            Integer year = getYear();
            Intrinsics.checkNotNull(year);
            long safeAdd = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(year.intValue() / 10000, (long) DateCalculationsKt.SECONDS_PER_10000_YEARS), ((copy.toLocalDate().toEpochDays() * 86400) + localTime.toSecondOfDay()) - utcOffset.getTotalSeconds());
            if (safeAdd < Instant.Companion.getMIN$kotlinx_datetime().getEpochSeconds() || safeAdd > Instant.Companion.getMAX$kotlinx_datetime().getEpochSeconds()) {
                throw new DateTimeFormatException("The parsed date is outside the range representable by Instant");
            }
            Instant.Companion companion = Instant.Companion;
            Integer nanosecond = getNanosecond();
            return companion.fromEpochSeconds(safeAdd, nanosecond != null ? nanosecond.intValue() : 0);
        } catch (ArithmeticException e) {
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant", e);
        }
    }
}
