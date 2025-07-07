package kotlinx.datetime.format;

import androidx.core.app.NotificationCompat;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.UnicodeFormat;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: Unicode.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\u0011\u001a\u00020\t*\u00020\u00122\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\f\u0010\u0013\u001a\u00020\t*\u00020\u0012H\u0002\u001a\u0014\u0010\u0014\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"nonPlainCharacters", "", "", "unicodeDirective", "Lkotlinx/datetime/format/UnicodeFormat;", "char", "formatLength", "", "unsupportedDirective", "", "fieldName", "", NotificationCompat.CATEGORY_RECOMMENDATION, "byUnicodePattern", "", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "pattern", "localizedDirective", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "unknownLength", "unsupportedPadding", "digits", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnicodeKt {
    private static final List<Character> nonPlainCharacters = CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) CollectionsKt.listOf((Object[]) new Character[]{Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), '\''}));

    public static final void byUnicodePattern(DateTimeFormatBuilder dateTimeFormatBuilder, String pattern) {
        Intrinsics.checkNotNullParameter(dateTimeFormatBuilder, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        byUnicodePattern$rec(dateTimeFormatBuilder, UnicodeFormat.Companion.parse(pattern));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void byUnicodePattern$rec(DateTimeFormatBuilder dateTimeFormatBuilder, final UnicodeFormat unicodeFormat) {
        if (unicodeFormat instanceof UnicodeFormat.StringLiteral) {
            dateTimeFormatBuilder.chars(((UnicodeFormat.StringLiteral) unicodeFormat).getLiteral());
        } else if (!(unicodeFormat instanceof UnicodeFormat.Sequence)) {
            if (unicodeFormat instanceof UnicodeFormat.OptionalGroup) {
                DateTimeFormatBuilderKt.alternativeParsing(dateTimeFormatBuilder, new Function1[]{new Function1<DateTimeFormatBuilder, Unit>() { // from class: kotlinx.datetime.format.UnicodeKt$byUnicodePattern$rec$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder dateTimeFormatBuilder2) {
                        invoke2(dateTimeFormatBuilder2);
                        return Unit.INSTANCE;
                    }
                }}, new Function1<DateTimeFormatBuilder, Unit>() { // from class: kotlinx.datetime.format.UnicodeKt$byUnicodePattern$rec$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder dateTimeFormatBuilder2) {
                        invoke2(dateTimeFormatBuilder2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder alternativeParsing) {
                        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        UnicodeKt.byUnicodePattern$rec(alternativeParsing, ((UnicodeFormat.OptionalGroup) UnicodeFormat.this).getFormat());
                    }
                });
            } else if (unicodeFormat instanceof UnicodeFormat.Directive) {
                UnicodeFormat.Directive directive = (UnicodeFormat.Directive) unicodeFormat;
                if (directive instanceof UnicodeFormat.Directive.TimeBased) {
                    if (!(dateTimeFormatBuilder instanceof DateTimeFormatBuilder.WithTime)) {
                        throw new IllegalArgumentException(("A time-based directive " + unicodeFormat + " was used in a format builder that doesn't support time components").toString());
                    }
                    ((UnicodeFormat.Directive.TimeBased) unicodeFormat).mo10059addToFormat((DateTimeFormatBuilder.WithTime) dateTimeFormatBuilder);
                } else if (directive instanceof UnicodeFormat.Directive.DateBased) {
                    if (!(dateTimeFormatBuilder instanceof DateTimeFormatBuilder.WithDate)) {
                        throw new IllegalArgumentException(("A date-based directive " + unicodeFormat + " was used in a format builder that doesn't support date components").toString());
                    }
                    ((UnicodeFormat.Directive.DateBased) unicodeFormat).mo10057addToFormat((DateTimeFormatBuilder.WithDate) dateTimeFormatBuilder);
                } else if (directive instanceof UnicodeFormat.Directive.ZoneBased) {
                    if (!(dateTimeFormatBuilder instanceof DateTimeFormatBuilder.WithDateTimeComponents)) {
                        throw new IllegalArgumentException(("A time-zone-based directive " + unicodeFormat + " was used in a format builder that doesn't support time-zone components").toString());
                    }
                    ((UnicodeFormat.Directive.ZoneBased) unicodeFormat).mo10060addToFormat((DateTimeFormatBuilder.WithDateTimeComponents) dateTimeFormatBuilder);
                } else if (directive instanceof UnicodeFormat.Directive.OffsetBased) {
                    if (!(dateTimeFormatBuilder instanceof DateTimeFormatBuilder.WithUtcOffset)) {
                        throw new IllegalArgumentException(("A UTC-offset-based directive " + unicodeFormat + " was used in a format builder that doesn't support UTC offset components").toString());
                    }
                    ((UnicodeFormat.Directive.OffsetBased) unicodeFormat).mo10058addToFormat((DateTimeFormatBuilder.WithUtcOffset) dateTimeFormatBuilder);
                } else if (directive instanceof UnknownUnicodeDirective) {
                    throw new IllegalArgumentException("The meaning of the directive '" + unicodeFormat + "' is unknown");
                }
            }
        } else {
            for (UnicodeFormat unicodeFormat2 : ((UnicodeFormat.Sequence) unicodeFormat).getFormats()) {
                byUnicodePattern$rec(dateTimeFormatBuilder, unicodeFormat2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnicodeFormat unicodeDirective(char c, int i) {
        if (c == 'G') {
            return new UnicodeFormat.Directive.DateBased.Era(i);
        }
        if (c == 'y') {
            return new UnicodeFormat.Directive.DateBased.YearOfEra(i);
        }
        if (c == 'Y') {
            return new UnicodeFormat.Directive.DateBased.WeekBasedYear(i);
        }
        if (c == 'u') {
            return new UnicodeFormat.Directive.DateBased.Year(i);
        }
        if (c == 'U') {
            return new UnicodeFormat.Directive.DateBased.CyclicYearName(i);
        }
        if (c == 'r') {
            return new UnicodeFormat.Directive.DateBased.RelatedGregorianYear(i);
        }
        if (c == 'Q') {
            return new UnicodeFormat.Directive.DateBased.QuarterOfYear(i);
        }
        if (c == 'q') {
            return new UnicodeFormat.Directive.DateBased.StandaloneQuarterOfYear(i);
        }
        if (c == 'M') {
            return new UnicodeFormat.Directive.DateBased.MonthOfYear(i);
        }
        if (c == 'L') {
            return new UnicodeFormat.Directive.DateBased.StandaloneMonthOfYear(i);
        }
        if (c == 'w') {
            return new UnicodeFormat.Directive.DateBased.WeekOfWeekBasedYear(i);
        }
        if (c == 'W') {
            return new UnicodeFormat.Directive.DateBased.WeekOfMonth(i);
        }
        if (c == 'd') {
            return new UnicodeFormat.Directive.DateBased.DayOfMonth(i);
        }
        if (c == 'D') {
            return new UnicodeFormat.Directive.DateBased.DayOfYear(i);
        }
        if (c == 'F') {
            return new UnicodeFormat.Directive.DateBased.DayOfWeekInMonth(i);
        }
        if (c == 'g') {
            return new UnicodeFormat.Directive.DateBased.ModifiedJulianDay(i);
        }
        if (c == 'E') {
            return new UnicodeFormat.Directive.DateBased.DayOfWeek(i);
        }
        if (c == 'e') {
            return new UnicodeFormat.Directive.DateBased.LocalizedDayOfWeek(i);
        }
        if (c == 'c') {
            return new UnicodeFormat.Directive.DateBased.StandaloneLocalizedDayOfWeek(i);
        }
        if (c == 'a') {
            return new UnicodeFormat.Directive.TimeBased.AmPmMarker(i);
        }
        if (c == 'h') {
            return new UnicodeFormat.Directive.TimeBased.AmPmHourOfDay(i);
        }
        if (c == 'H') {
            return new UnicodeFormat.Directive.TimeBased.HourOfDay(i);
        }
        if (c == 'm') {
            return new UnicodeFormat.Directive.TimeBased.MinuteOfHour(i);
        }
        if (c == 's') {
            return new UnicodeFormat.Directive.TimeBased.WithSecondPrecision.SecondOfMinute(i);
        }
        if (c == 'S') {
            return new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.FractionOfSecond(i);
        }
        if (c == 'A') {
            return new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.MilliOfDay(i);
        }
        if (c == 'n') {
            return new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.NanoOfSecond(i);
        }
        if (c == 'N') {
            return new UnicodeFormat.Directive.TimeBased.WithSubsecondPrecision.NanoOfDay(i);
        }
        if (c == 'V') {
            return new UnicodeFormat.Directive.ZoneBased.TimeZoneId(i);
        }
        if (c == 'v') {
            return new UnicodeFormat.Directive.ZoneBased.GenericTimeZoneName(i);
        }
        if (c == 'z') {
            return new UnicodeFormat.Directive.ZoneBased.TimeZoneName(i);
        }
        if (c == 'O') {
            return new UnicodeFormat.Directive.OffsetBased.LocalizedZoneOffset(i);
        }
        if (c == 'X') {
            return new UnicodeFormat.Directive.OffsetBased.ZoneOffset1(i);
        }
        if (c == 'x') {
            return new UnicodeFormat.Directive.OffsetBased.ZoneOffset2(i);
        }
        if (c == 'Z') {
            return new UnicodeFormat.Directive.OffsetBased.ZoneOffset3(i);
        }
        return new UnknownUnicodeDirective(c, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void unsupportedDirective$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return unsupportedDirective(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirective(String str, String str2) {
        throw new UnsupportedOperationException("kotlinx.datetime formatting does not support the " + str + " field. " + (str2 != null ? str2 + ' ' : "") + "Please report your use case to https://github.com/Kotlin/kotlinx-datetime/issues");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unknownLength(UnicodeFormat.Directive directive) {
        throw new IllegalArgumentException("Unknown length " + directive.getFormatLength() + " for the " + directive.getFormatLetter() + " directive");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void localizedDirective$default(UnicodeFormat.Directive directive, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return localizedDirective(directive, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void localizedDirective(UnicodeFormat.Directive directive, String str) {
        throw new IllegalArgumentException("The directive '" + directive + "' is locale-dependent, but locales are not supported in Kotlin" + (str != null ? ". " + str : ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedPadding(UnicodeFormat.Directive directive, int i) {
        throw new UnsupportedOperationException("Padding do " + i + " digits is not supported for the " + directive.getFormatLetter() + " directive");
    }
}
