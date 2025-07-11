package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalTimeJvm.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"atDate", "Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/LocalTime;", "year", "", "month", "Ljava/time/Month;", "dayOfMonth", "fakeArgument", "", "(Lkotlinx/datetime/LocalTime;ILjava/time/Month;ILkotlin/Unit;)Lkotlinx/datetime/LocalDateTime;", "kotlinx-datetime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/datetime/LocalTimeKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class LocalTimeKt__LocalTimeJvmKt {
    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, java.time.Month month, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return LocalTimeKt.atDate(localTime, i, month, i2);
    }

    @Deprecated(message = "Use kotlinx.datetime.Month", replaceWith = @ReplaceWith(expression = "atDate(year, month.toKotlinMonth(), dayOfMonth)", imports = {}))
    public static final LocalDateTime atDate(LocalTime localTime, int i, java.time.Month month, int i2) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return LocalTimeKt.atDate(localTime, i, ConvertersKt.toKotlinMonth(month), i2);
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, java.time.Month month, int i2, Unit unit, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            unit = Unit.INSTANCE;
        }
        return LocalTimeKt.atDate(localTime, i, month, i2, unit);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the overload that accepts a 'month' and a 'day' instead", replaceWith = @ReplaceWith(expression = "this.atDate(year = year, month = month.toKotlinMonth(), day = dayOfMonth)", imports = {}))
    public static final LocalDateTime atDate(LocalTime localTime, int i, java.time.Month month, int i2, Unit fakeArgument) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(fakeArgument, "fakeArgument");
        return new LocalDateTime(i, ConvertersKt.toKotlinMonth(month), i2, localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNanosecond());
    }
}
