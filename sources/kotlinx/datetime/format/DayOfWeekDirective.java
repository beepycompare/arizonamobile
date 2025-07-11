package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/DayOfWeekDirective;", "Lkotlinx/datetime/internal/format/NamedUnsignedIntFieldFormatDirective;", "Lkotlinx/datetime/format/DateFieldContainer;", "names", "Lkotlinx/datetime/format/DayOfWeekNames;", "<init>", "(Lkotlinx/datetime/format/DayOfWeekNames;)V", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
final class DayOfWeekDirective extends NamedUnsignedIntFieldFormatDirective<DateFieldContainer> {
    private final DayOfWeekNames names;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayOfWeekDirective(DayOfWeekNames names) {
        super(DateFields.INSTANCE.getIsoDayOfWeek(), names.getNames(), "dayOfWeekName");
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        String kotlinCode;
        StringBuilder sb = new StringBuilder("dayOfWeek(");
        kotlinCode = LocalDateFormatKt.toKotlinCode(this.names);
        return sb.append(kotlinCode).append(')').toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof DayOfWeekDirective) && Intrinsics.areEqual(this.names.getNames(), ((DayOfWeekDirective) obj).names.getNames());
    }

    public int hashCode() {
        return this.names.getNames().hashCode();
    }
}
