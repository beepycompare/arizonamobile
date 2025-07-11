package kotlinx.datetime.format;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlin.time.Instant;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DayOfWeek;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.Month;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.OverloadMarker;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.YearMonth;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.DateTimeComponentsFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u0081\u00012\u00020\u0001:\u0004\u0081\u0001\u0082\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010y\u001a\u00020\u0017J\u0006\u0010z\u001a\u00020\u000eJ\u0006\u0010{\u001a\u00020\u0011J\u0006\u0010|\u001a\u00020\u000bJ\u0006\u0010}\u001a\u00020\u0014J\u0011\u0010~\u001a\u00020\u001a2\t\b\u0002\u0010\u007f\u001a\u00030\u0080\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#*\u0004\b\u001e\u0010\u001fR/\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R/\u00100\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010(\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R5\u00104\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b9\u0010(\u0012\u0004\b5\u00106\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R(\u0010;\u001a\u0004\u0018\u00010:2\b\u0010)\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R/\u0010@\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R/\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010(\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R/\u0010I\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010(\u001a\u0004\bJ\u0010!\"\u0004\bK\u0010#R/\u0010N\u001a\u0004\u0018\u00010M2\b\u0010\u001b\u001a\u0004\u0018\u00010M8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S*\u0004\bO\u0010\u001fR/\u0010T\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010(\u001a\u0004\bU\u0010!\"\u0004\bV\u0010#R/\u0010X\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010(\u001a\u0004\bY\u0010!\"\u0004\bZ\u0010#R(\u0010\\\u001a\u0004\u0018\u00010\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010!\"\u0004\b^\u0010#R/\u0010`\u001a\u0004\u0018\u00010_2\b\u0010\u001b\u001a\u0004\u0018\u00010_8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e*\u0004\ba\u0010\u001fR/\u0010f\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010(\u001a\u0004\bg\u0010!\"\u0004\bh\u0010#R/\u0010j\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010(\u001a\u0004\bk\u0010!\"\u0004\bl\u0010#R/\u0010n\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010(\u001a\u0004\bo\u0010!\"\u0004\bp\u0010#R/\u0010s\u001a\u0004\u0018\u00010r2\b\u0010\u001b\u001a\u0004\u0018\u00010r8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\bu\u0010v\"\u0004\bw\u0010x*\u0004\bt\u0010\u001f¨\u0006\u0083\u0001"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents;", "", "contents", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "<init>", "(Lkotlinx/datetime/format/DateTimeComponentsContents;)V", "getContents$kotlinx_datetime", "()Lkotlinx/datetime/format/DateTimeComponentsContents;", "setTime", "", "localTime", "Lkotlinx/datetime/LocalTime;", "setYearMonth", "yearMonth", "Lkotlinx/datetime/YearMonth;", "setDate", "localDate", "Lkotlinx/datetime/LocalDate;", "setDateTime", "localDateTime", "Lkotlinx/datetime/LocalDateTime;", "setOffset", "utcOffset", "Lkotlinx/datetime/UtcOffset;", "setDateTimeOffset", "instant", "Lkotlin/time/Instant;", "<set-?>", "", "year", "getYear$delegate", "(Lkotlinx/datetime/format/DateTimeComponents;)Ljava/lang/Object;", "getYear", "()Ljava/lang/Integer;", "setYear", "(Ljava/lang/Integer;)V", "monthNumber", "getMonthNumber", "setMonthNumber", "monthNumber$delegate", "Lkotlinx/datetime/format/TwoDigitNumber;", "value", "Lkotlinx/datetime/Month;", "month", "getMonth", "()Lkotlinx/datetime/Month;", "setMonth", "(Lkotlinx/datetime/Month;)V", "day", "getDay", "setDay", "day$delegate", "dayOfMonth", "getDayOfMonth$annotations", "()V", "getDayOfMonth", "setDayOfMonth", "dayOfMonth$delegate", "Lkotlinx/datetime/DayOfWeek;", "dayOfWeek", "getDayOfWeek", "()Lkotlinx/datetime/DayOfWeek;", "setDayOfWeek", "(Lkotlinx/datetime/DayOfWeek;)V", "dayOfYear", "getDayOfYear", "setDayOfYear", "dayOfYear$delegate", "Lkotlinx/datetime/format/ThreeDigitNumber;", "hour", "getHour", "setHour", "hour$delegate", "hourOfAmPm", "getHourOfAmPm", "setHourOfAmPm", "hourOfAmPm$delegate", "Lkotlinx/datetime/format/AmPmMarker;", "amPm", "getAmPm$delegate", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "minute", "getMinute", "setMinute", "minute$delegate", "second", "getSecond", "setSecond", "second$delegate", "nanosecond", "getNanosecond", "setNanosecond", "", "offsetIsNegative", "getOffsetIsNegative$delegate", "getOffsetIsNegative", "()Ljava/lang/Boolean;", "setOffsetIsNegative", "(Ljava/lang/Boolean;)V", "offsetHours", "getOffsetHours", "setOffsetHours", "offsetHours$delegate", "offsetMinutesOfHour", "getOffsetMinutesOfHour", "setOffsetMinutesOfHour", "offsetMinutesOfHour$delegate", "offsetSecondsOfMinute", "getOffsetSecondsOfMinute", "setOffsetSecondsOfMinute", "offsetSecondsOfMinute$delegate", "", "timeZoneId", "getTimeZoneId$delegate", "getTimeZoneId", "()Ljava/lang/String;", "setTimeZoneId", "(Ljava/lang/String;)V", "toUtcOffset", "toYearMonth", "toLocalDate", "toLocalTime", "toLocalDateTime", "toInstantUsingOffset", "youShallNotPass", "Lkotlinx/datetime/OverloadMarker;", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTimeComponents {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "monthNumber", "getMonthNumber()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "day", "getDay()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "dayOfMonth", "getDayOfMonth()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "dayOfYear", "getDayOfYear()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hour", "getHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hourOfAmPm", "getHourOfAmPm()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "minute", "getMinute()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "second", "getSecond()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetHours", "getOffsetHours()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetMinutesOfHour", "getOffsetMinutesOfHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetSecondsOfMinute", "getOffsetSecondsOfMinute()Ljava/lang/Integer;", 0))};
    public static final Companion Companion = new Companion(null);
    private final DateTimeComponentsContents contents;
    private final TwoDigitNumber day$delegate;
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

    @Deprecated(message = "Use 'day' instead", replaceWith = @ReplaceWith(expression = "day", imports = {}))
    public static /* synthetic */ void getDayOfMonth$annotations() {
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents$Companion;", "", "<init>", "()V", "Format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        this.day$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(date2) { // from class: kotlinx.datetime.format.DateTimeComponents$day$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getDay();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalDate) this.receiver).setDay((Integer) obj);
            }
        });
        final IncompleteLocalDate date3 = contents.getDate();
        this.dayOfMonth$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(date3) { // from class: kotlinx.datetime.format.DateTimeComponents$dayOfMonth$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteLocalDate) this.receiver).getDay();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteLocalDate) this.receiver).setDay((Integer) obj);
            }
        });
        final IncompleteLocalDate date4 = contents.getDate();
        this.dayOfYear$delegate = new ThreeDigitNumber(new MutablePropertyReference0Impl(date4) { // from class: kotlinx.datetime.format.DateTimeComponents$dayOfYear$2
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
                return ((IncompleteUtcOffset) this.receiver).getOffsetHours();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteUtcOffset) this.receiver).setOffsetHours((Integer) obj);
            }
        });
        final IncompleteUtcOffset offset2 = contents.getOffset();
        this.offsetMinutesOfHour$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset2) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetMinutesOfHour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getOffsetMinutesOfHour();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteUtcOffset) this.receiver).setOffsetMinutesOfHour((Integer) obj);
            }
        });
        final IncompleteUtcOffset offset3 = contents.getOffset();
        this.offsetSecondsOfMinute$delegate = new TwoDigitNumber(new MutablePropertyReference0Impl(offset3) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetSecondsOfMinute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((IncompleteUtcOffset) this.receiver).getOffsetSecondsOfMinute();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((IncompleteUtcOffset) this.receiver).setOffsetSecondsOfMinute((Integer) obj);
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponents$Formats;", "", "<init>", "()V", "ISO_DATE_TIME_OFFSET", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "getISO_DATE_TIME_OFFSET", "()Lkotlinx/datetime/format/DateTimeFormat;", "RFC_1123", "getRFC_1123", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();
        private static final DateTimeFormat<DateTimeComponents> ISO_DATE_TIME_OFFSET = DateTimeComponents.Companion.Format(new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATE_TIME_OFFSET$lambda$5;
                ISO_DATE_TIME_OFFSET$lambda$5 = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET$lambda$5((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                return ISO_DATE_TIME_OFFSET$lambda$5;
            }
        });
        private static final DateTimeFormat<DateTimeComponents> RFC_1123 = DateTimeComponents.Companion.Format(new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit RFC_1123$lambda$13;
                RFC_1123$lambda$13 = DateTimeComponents.Formats.RFC_1123$lambda$13((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                return RFC_1123$lambda$13;
            }
        });

        private Formats() {
        }

        public final DateTimeFormat<DateTimeComponents> getISO_DATE_TIME_OFFSET() {
            return ISO_DATE_TIME_OFFSET;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ISO_DATE_TIME_OFFSET$lambda$5(DateTimeFormatBuilder.WithDateTimeComponents Format) {
            Intrinsics.checkNotNullParameter(Format, "$this$Format");
            Format.date(LocalDateFormatKt.getISO_DATE());
            DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents = Format;
            DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$0;
                    ISO_DATE_TIME_OFFSET$lambda$5$lambda$0 = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET$lambda$5$lambda$0((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return ISO_DATE_TIME_OFFSET$lambda$5$lambda$0;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$1;
                    ISO_DATE_TIME_OFFSET$lambda$5$lambda$1 = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET$lambda$5$lambda$1((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return ISO_DATE_TIME_OFFSET$lambda$5$lambda$1;
                }
            });
            DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2 = Format;
            DateTimeFormatBuilder.WithTime.hour$default(withDateTimeComponents2, null, 1, null);
            DateTimeFormatBuilderKt.m10098char(withDateTimeComponents, AbstractJsonLexerKt.COLON);
            DateTimeFormatBuilder.WithTime.minute$default(withDateTimeComponents2, null, 1, null);
            DateTimeFormatBuilderKt.m10098char(withDateTimeComponents, AbstractJsonLexerKt.COLON);
            DateTimeFormatBuilder.WithTime.second$default(withDateTimeComponents2, null, 1, null);
            DateTimeFormatBuilderKt.optional$default(withDateTimeComponents, null, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$2;
                    ISO_DATE_TIME_OFFSET$lambda$5$lambda$2 = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET$lambda$5$lambda$2((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return ISO_DATE_TIME_OFFSET$lambda$5$lambda$2;
                }
            }, 1, null);
            DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$3;
                    ISO_DATE_TIME_OFFSET$lambda$5$lambda$3 = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET$lambda$5$lambda$3((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return ISO_DATE_TIME_OFFSET$lambda$5$lambda$3;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$4;
                    ISO_DATE_TIME_OFFSET$lambda$5$lambda$4 = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET$lambda$5$lambda$4((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return ISO_DATE_TIME_OFFSET$lambda$5$lambda$4;
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$0(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.m10098char(alternativeParsing, 't');
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$1(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.m10098char(alternativeParsing, 'T');
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$2(DateTimeFormatBuilder.WithDateTimeComponents optional) {
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            DateTimeFormatBuilderKt.m10098char(optional, '.');
            optional.secondFraction(1, 9);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$3(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilder.WithUtcOffset.offsetHours$default(alternativeParsing, null, 1, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit ISO_DATE_TIME_OFFSET$lambda$5$lambda$4(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.offset(UtcOffset.Formats.INSTANCE.getISO());
            return Unit.INSTANCE;
        }

        public final DateTimeFormat<DateTimeComponents> getRFC_1123() {
            return RFC_1123;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13(DateTimeFormatBuilder.WithDateTimeComponents Format) {
            Intrinsics.checkNotNullParameter(Format, "$this$Format");
            DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents = Format;
            DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$6;
                    RFC_1123$lambda$13$lambda$6 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$6((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$6;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$7;
                    RFC_1123$lambda$13$lambda$7 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$7((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$7;
                }
            });
            Format.day(Padding.NONE);
            DateTimeFormatBuilderKt.m10098char(withDateTimeComponents, ' ');
            Format.monthName(MonthNames.Companion.getENGLISH_ABBREVIATED());
            DateTimeFormatBuilderKt.m10098char(withDateTimeComponents, ' ');
            DateTimeFormatBuilder.WithYearMonth.year$default(Format, null, 1, null);
            DateTimeFormatBuilderKt.m10098char(withDateTimeComponents, ' ');
            DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents2 = Format;
            DateTimeFormatBuilder.WithTime.hour$default(withDateTimeComponents2, null, 1, null);
            DateTimeFormatBuilderKt.m10098char(withDateTimeComponents, AbstractJsonLexerKt.COLON);
            DateTimeFormatBuilder.WithTime.minute$default(withDateTimeComponents2, null, 1, null);
            DateTimeFormatBuilderKt.optional$default(withDateTimeComponents, null, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$8;
                    RFC_1123$lambda$13$lambda$8 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$8((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$8;
                }
            }, 1, null);
            Format.chars(" ");
            DateTimeFormatBuilderKt.alternativeParsing(withDateTimeComponents, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$9;
                    RFC_1123$lambda$13$lambda$9 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$9((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$9;
                }
            }, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$10;
                    RFC_1123$lambda$13$lambda$10 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$10((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$10;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$12;
                    RFC_1123$lambda$13$lambda$12 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$12((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$12;
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$6(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$7(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.dayOfWeek(DayOfWeekNames.Companion.getENGLISH_ABBREVIATED());
            alternativeParsing.chars(", ");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$8(DateTimeFormatBuilder.WithDateTimeComponents optional) {
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            DateTimeFormatBuilderKt.m10098char(optional, AbstractJsonLexerKt.COLON);
            DateTimeFormatBuilder.WithTime.second$default(optional, null, 1, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$9(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.chars("UT");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$10(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.chars("Z");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$12(DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.optional(alternativeParsing, "GMT", new Function1() { // from class: kotlinx.datetime.format.DateTimeComponents$Formats$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit RFC_1123$lambda$13$lambda$12$lambda$11;
                    RFC_1123$lambda$13$lambda$12$lambda$11 = DateTimeComponents.Formats.RFC_1123$lambda$13$lambda$12$lambda$11((DateTimeFormatBuilder.WithDateTimeComponents) obj);
                    return RFC_1123$lambda$13$lambda$12$lambda$11;
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit RFC_1123$lambda$13$lambda$12$lambda$11(DateTimeFormatBuilder.WithDateTimeComponents optional) {
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            optional.offset(UtcOffset.Formats.INSTANCE.getFOUR_DIGITS());
            return Unit.INSTANCE;
        }
    }

    public final void setTime(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        this.contents.getTime().populateFrom(localTime);
    }

    public final void setYearMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "yearMonth");
        this.contents.getDate().getYearMonth().populateFrom(yearMonth);
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
            return MonthKt.m10091Month(monthNumber.intValue());
        }
        return null;
    }

    public final void setMonth(Month month) {
        setMonthNumber(month != null ? Integer.valueOf(MonthKt.getNumber(month)) : null);
    }

    public final Integer getDay() {
        return this.day$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setDay(Integer num) {
        this.day$delegate.setValue(this, $$delegatedProperties[1], num);
    }

    public final Integer getDayOfMonth() {
        return this.dayOfMonth$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setDayOfMonth(Integer num) {
        this.dayOfMonth$delegate.setValue(this, $$delegatedProperties[2], num);
    }

    public final DayOfWeek getDayOfWeek() {
        Integer dayOfWeek = this.contents.getDate().getDayOfWeek();
        if (dayOfWeek != null) {
            return DayOfWeekKt.m10081DayOfWeek(dayOfWeek.intValue());
        }
        return null;
    }

    public final void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.contents.getDate().setDayOfWeek(dayOfWeek != null ? Integer.valueOf(DayOfWeekKt.getIsoDayNumber(dayOfWeek)) : null);
    }

    public final Integer getDayOfYear() {
        return this.dayOfYear$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setDayOfYear(Integer num) {
        this.dayOfYear$delegate.setValue(this, $$delegatedProperties[3], num);
    }

    public final Integer getHour() {
        return this.hour$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setHour(Integer num) {
        this.hour$delegate.setValue(this, $$delegatedProperties[4], num);
    }

    public final Integer getHourOfAmPm() {
        return this.hourOfAmPm$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setHourOfAmPm(Integer num) {
        this.hourOfAmPm$delegate.setValue(this, $$delegatedProperties[5], num);
    }

    public final AmPmMarker getAmPm() {
        return this.contents.getTime().getAmPm();
    }

    public final void setAmPm(AmPmMarker amPmMarker) {
        this.contents.getTime().setAmPm(amPmMarker);
    }

    public final Integer getMinute() {
        return this.minute$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final void setMinute(Integer num) {
        this.minute$delegate.setValue(this, $$delegatedProperties[6], num);
    }

    public final Integer getSecond() {
        return this.second$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void setSecond(Integer num) {
        this.second$delegate.setValue(this, $$delegatedProperties[7], num);
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
        return this.contents.getOffset().getOffsetIsNegative();
    }

    public final void setOffsetIsNegative(Boolean bool) {
        this.contents.getOffset().setOffsetIsNegative(bool);
    }

    public final Integer getOffsetHours() {
        return this.offsetHours$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final void setOffsetHours(Integer num) {
        this.offsetHours$delegate.setValue(this, $$delegatedProperties[8], num);
    }

    public final Integer getOffsetMinutesOfHour() {
        return this.offsetMinutesOfHour$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final void setOffsetMinutesOfHour(Integer num) {
        this.offsetMinutesOfHour$delegate.setValue(this, $$delegatedProperties[9], num);
    }

    public final Integer getOffsetSecondsOfMinute() {
        return this.offsetSecondsOfMinute$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final void setOffsetSecondsOfMinute(Integer num) {
        this.offsetSecondsOfMinute$delegate.setValue(this, $$delegatedProperties[10], num);
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

    public final YearMonth toYearMonth() {
        return this.contents.getDate().getYearMonth().toYearMonth();
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

    public static /* synthetic */ Instant toInstantUsingOffset$default(DateTimeComponents dateTimeComponents, OverloadMarker overloadMarker, int i, Object obj) {
        if ((i & 1) != 0) {
            overloadMarker = OverloadMarker.Companion.getINSTANCE$kotlinx_datetime();
        }
        return dateTimeComponents.toInstantUsingOffset(overloadMarker);
    }

    public final Instant toInstantUsingOffset(OverloadMarker youShallNotPass) {
        Intrinsics.checkNotNullParameter(youShallNotPass, "youShallNotPass");
        UtcOffset utcOffset = toUtcOffset();
        LocalTime localTime = toLocalTime();
        IncompleteLocalDate copy = this.contents.getDate().copy();
        copy.setYear(Integer.valueOf(((Number) YearMonthFormatKt.requireParsedField(copy.getYear(), "year")).intValue() % 10000));
        try {
            Integer year = getYear();
            Intrinsics.checkNotNull(year);
            long safeAdd = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(year.intValue() / 10000, (long) DateCalculationsKt.SECONDS_PER_10000_YEARS), ((copy.toLocalDate().m10087toEpochDays() * 86400) + localTime.toSecondOfDay()) - utcOffset.getTotalSeconds());
            Instant.Companion companion = Instant.Companion;
            Integer nanosecond = getNanosecond();
            Instant fromEpochSeconds = companion.fromEpochSeconds(safeAdd, nanosecond != null ? nanosecond.intValue() : 0);
            if (fromEpochSeconds.getEpochSeconds() == safeAdd) {
                return fromEpochSeconds;
            }
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant");
        } catch (ArithmeticException e) {
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant", e);
        }
    }
}
