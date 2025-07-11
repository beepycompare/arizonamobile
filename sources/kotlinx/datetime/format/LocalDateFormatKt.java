package kotlinx.datetime.format;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.DayOfWeekNames;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\"!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"toKotlinCode", "", "Lkotlinx/datetime/format/DayOfWeekNames;", "ISO_DATE", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO_DATE", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_DATE$delegate", "Lkotlin/Lazy;", "ISO_DATE_BASIC", "getISO_DATE_BASIC", "ISO_DATE_BASIC$delegate", "emptyIncompleteLocalDate", "Lkotlinx/datetime/format/IncompleteLocalDate;", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalDateFormatKt {
    private static final Lazy ISO_DATE$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormat ISO_DATE_delegate$lambda$1;
            ISO_DATE_delegate$lambda$1 = LocalDateFormatKt.ISO_DATE_delegate$lambda$1();
            return ISO_DATE_delegate$lambda$1;
        }
    });
    private static final Lazy ISO_DATE_BASIC$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormat ISO_DATE_BASIC_delegate$lambda$3;
            ISO_DATE_BASIC_delegate$lambda$3 = LocalDateFormatKt.ISO_DATE_BASIC_delegate$lambda$3();
            return ISO_DATE_BASIC_delegate$lambda$3;
        }
    });
    private static final IncompleteLocalDate emptyIncompleteLocalDate = new IncompleteLocalDate(null, null, null, null, 15, null);

    public static final /* synthetic */ IncompleteLocalDate access$getEmptyIncompleteLocalDate$p() {
        return emptyIncompleteLocalDate;
    }

    public static final String toKotlinCode(DayOfWeekNames dayOfWeekNames) {
        List<String> names = dayOfWeekNames.getNames();
        if (Intrinsics.areEqual(names, DayOfWeekNames.Companion.getENGLISH_FULL().getNames())) {
            DayOfWeekNames.Companion companion = DayOfWeekNames.Companion;
            return "DayOfWeekNames.ENGLISH_FULL";
        } else if (Intrinsics.areEqual(names, DayOfWeekNames.Companion.getENGLISH_ABBREVIATED().getNames())) {
            DayOfWeekNames.Companion companion2 = DayOfWeekNames.Companion;
            return "DayOfWeekNames.ENGLISH_ABBREVIATED";
        } else {
            return CollectionsKt.joinToString$default(dayOfWeekNames.getNames(), ", ", "DayOfWeekNames(", ")", 0, null, LocalDateFormatKt$toKotlinCode$1.INSTANCE, 24, null);
        }
    }

    public static final DateTimeFormat<LocalDate> getISO_DATE() {
        return (DateTimeFormat) ISO_DATE$delegate.getValue();
    }

    public static final DateTimeFormat ISO_DATE_delegate$lambda$1() {
        return LocalDateFormat.Companion.build(new Function1() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATE_delegate$lambda$1$lambda$0;
                ISO_DATE_delegate$lambda$1$lambda$0 = LocalDateFormatKt.ISO_DATE_delegate$lambda$1$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return ISO_DATE_delegate$lambda$1$lambda$0;
            }
        });
    }

    public static final Unit ISO_DATE_delegate$lambda$1$lambda$0(DateTimeFormatBuilder.WithDate build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilder.WithDate withDate = build;
        DateTimeFormatBuilder.WithYearMonth.year$default(withDate, null, 1, null);
        DateTimeFormatBuilder.WithDate withDate2 = build;
        DateTimeFormatBuilderKt.m10098char(withDate2, '-');
        DateTimeFormatBuilder.WithYearMonth.monthNumber$default(withDate, null, 1, null);
        DateTimeFormatBuilderKt.m10098char(withDate2, '-');
        DateTimeFormatBuilder.WithDate.day$default(build, null, 1, null);
        return Unit.INSTANCE;
    }

    public static final DateTimeFormat<LocalDate> getISO_DATE_BASIC() {
        return (DateTimeFormat) ISO_DATE_BASIC$delegate.getValue();
    }

    public static final DateTimeFormat ISO_DATE_BASIC_delegate$lambda$3() {
        return LocalDateFormat.Companion.build(new Function1() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATE_BASIC_delegate$lambda$3$lambda$2;
                ISO_DATE_BASIC_delegate$lambda$3$lambda$2 = LocalDateFormatKt.ISO_DATE_BASIC_delegate$lambda$3$lambda$2((DateTimeFormatBuilder.WithDate) obj);
                return ISO_DATE_BASIC_delegate$lambda$3$lambda$2;
            }
        });
    }

    public static final Unit ISO_DATE_BASIC_delegate$lambda$3$lambda$2(DateTimeFormatBuilder.WithDate build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilder.WithDate withDate = build;
        DateTimeFormatBuilder.WithYearMonth.year$default(withDate, null, 1, null);
        DateTimeFormatBuilder.WithYearMonth.monthNumber$default(withDate, null, 1, null);
        DateTimeFormatBuilder.WithDate.day$default(build, null, 1, null);
        return Unit.INSTANCE;
    }
}
