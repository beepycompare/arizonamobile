package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.format.DateTimeFormat;
/* compiled from: LocalDateTime.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"getIsoDateTimeFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDateTime;", "format", "", "toLocalDateTime", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalDateTimeKt {
    public static final String format(LocalDateTime localDateTime, DateTimeFormat<LocalDateTime> format) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format(localDateTime);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "LocalDateTime.parse(this)", imports = {}))
    public static final LocalDateTime toLocalDateTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return LocalDateTime.Companion.parse$default(LocalDateTime.Companion, str, null, 2, null);
    }

    public static final DateTimeFormat<LocalDateTime> getIsoDateTimeFormat() {
        return LocalDateTime.Formats.INSTANCE.getISO();
    }
}
