package androidx.compose.material3.internal;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CalendarModelImpl.android.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\fH\u0016J$\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00122\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J&\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0002J\f\u0010,\u001a\u00020+*\u00020\u001bH\u0002J\f\u0010,\u001a\u00020+*\u00020\bH\u0002R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Landroidx/compose/material3/internal/CalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", "year", "month", "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithPattern", "utcTimeMillis", "pattern", "parse", "toString", "firstDayLocalDate", "Ljava/time/LocalDate;", "toLocalDate", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CalendarModelImpl extends CalendarModel {
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ZoneId utcTimeZoneId = ZoneId.of("UTC");

    /* compiled from: CalendarModelImpl.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    public CalendarModelImpl(Locale locale) {
        super(locale);
        this.firstDayOfWeek = WeekFields.of(locale).getFirstDayOfWeek().getValue();
        EnumEntries<DayOfWeek> enumEntries = EntriesMappings.entries$0;
        ArrayList arrayList = new ArrayList(enumEntries.size());
        int size = enumEntries.size();
        for (int i = 0; i < size; i++) {
            DayOfWeek dayOfWeek = (DayOfWeek) enumEntries.get(i);
            arrayList.add(TuplesKt.to(dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, locale), dayOfWeek.getDisplayName(TextStyle.NARROW_STANDALONE, locale)));
        }
        this.weekdayNames = arrayList;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate getToday() {
        LocalDate now = LocalDate.now();
        return new CalendarDate(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public List<Pair<String, String>> getWeekdayNames() {
        return this.weekdayNames;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public DateInputFormat getDateInputFormat(Locale locale) {
        return CalendarModelKt.datePatternAsInputFormat(DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, Chronology.ofLocale(locale), locale));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate getCanonicalDate(long j) {
        LocalDate localDate = Instant.ofEpochMilli(j).atZone(utcTimeZoneId).toLocalDate();
        return new CalendarDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), 1000 * localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(long j) {
        return getMonth(Instant.ofEpochMilli(j).atZone(utcTimeZoneId).withDayOfMonth(1).toLocalDate());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(CalendarDate calendarDate) {
        return getMonth(LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(int i, int i2) {
        return getMonth(LocalDate.of(i, i2, 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getDayOfWeek(CalendarDate calendarDate) {
        return toLocalDate(calendarDate).getDayOfWeek().getValue();
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth plusMonths(CalendarMonth calendarMonth, int i) {
        return i <= 0 ? calendarMonth : getMonth(toLocalDate(calendarMonth).plusMonths(i));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth minusMonths(CalendarMonth calendarMonth, int i) {
        return i <= 0 ? calendarMonth : getMonth(toLocalDate(calendarMonth).minusMonths(i));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String formatWithPattern(long j, String str, Locale locale) {
        return Companion.formatWithPattern(j, str, locale, getFormatterCache$material3());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate parse(String str, String str2, Locale locale) {
        try {
            LocalDate parse = LocalDate.parse(str, Companion.getCachedDateTimeFormatter(str2, locale, getFormatterCache$material3()));
            return new CalendarDate(parse.getYear(), parse.getMonth().getValue(), parse.getDayOfMonth(), parse.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
        } catch (DateTimeParseException unused) {
            return null;
        }
    }

    public String toString() {
        return "CalendarModel";
    }

    /* compiled from: CalendarModelImpl.android.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rJ0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/internal/CalendarModelImpl$Companion;", "", "<init>", "()V", "formatWithPattern", "", "utcTimeMillis", "", "pattern", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "utcTimeZoneId", "Ljava/time/ZoneId;", "getUtcTimeZoneId$material3", "()Ljava/time/ZoneId;", "getCachedDateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatWithPattern(long j, String str, Locale locale, Map<String, Object> map) {
            return Instant.ofEpochMilli(j).atZone(getUtcTimeZoneId$material3()).toLocalDate().format(getCachedDateTimeFormatter(str, locale, map));
        }

        public final ZoneId getUtcTimeZoneId$material3() {
            return CalendarModelImpl.utcTimeZoneId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DateTimeFormatter getCachedDateTimeFormatter(String str, Locale locale, Map<String, Object> map) {
            String str2 = "P:" + str + locale.toLanguageTag();
            Object obj = map.get(str2);
            if (obj == null) {
                obj = DateTimeFormatter.ofPattern(str, locale).withDecimalStyle(DecimalStyle.of(locale));
                map.put(str2, obj);
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.time.format.DateTimeFormatter");
            return (DateTimeFormatter) obj;
        }
    }

    private final CalendarMonth getMonth(LocalDate localDate) {
        int value = localDate.getDayOfWeek().getValue() - getFirstDayOfWeek();
        if (value < 0) {
            value += 7;
        }
        return new CalendarMonth(localDate.getYear(), localDate.getMonthValue(), localDate.lengthOfMonth(), value, localDate.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    }

    private final LocalDate toLocalDate(CalendarMonth calendarMonth) {
        return Instant.ofEpochMilli(calendarMonth.getStartUtcTimeMillis()).atZone(utcTimeZoneId).toLocalDate();
    }

    private final LocalDate toLocalDate(CalendarDate calendarDate) {
        return LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), calendarDate.getDayOfMonth());
    }
}
