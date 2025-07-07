package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.SignedIntFieldFormatDirective;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/YearDirective;", "Lkotlinx/datetime/internal/format/SignedIntFieldFormatDirective;", "Lkotlinx/datetime/format/DateFieldContainer;", "padding", "Lkotlinx/datetime/format/Padding;", "isYearOfEra", "", "(Lkotlinx/datetime/format/Padding;Z)V", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "other", "", "hashCode", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YearDirective extends SignedIntFieldFormatDirective<DateFieldContainer> {
    private final boolean isYearOfEra;
    private final Padding padding;

    /* compiled from: LocalDateFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Padding.values().length];
            try {
                iArr[Padding.ZERO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ YearDirective(Padding padding, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(padding, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YearDirective(Padding padding, boolean z) {
        super(DateFields.INSTANCE.getYear(), Integer.valueOf(padding != Padding.ZERO ? 1 : 4), null, padding == Padding.SPACE ? 4 : null, 4);
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.padding = padding;
        this.isYearOfEra = z;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        String str;
        if (WhenMappings.$EnumSwitchMapping$0[this.padding.ordinal()] == 1) {
            str = "year()";
        } else {
            str = "year(" + DateTimeFormatKt.toKotlinCode(this.padding) + ')';
        }
        return this.isYearOfEra ? str + " /** TODO: the original format had an `y` directive, so the behavior is different on years earlier than 1 AD. See the [kotlinx.datetime.format.byUnicodePattern] documentation for details. */" : str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof YearDirective) {
            YearDirective yearDirective = (YearDirective) obj;
            return this.padding == yearDirective.padding && this.isYearOfEra == yearDirective.isYearOfEra;
        }
        return false;
    }

    public int hashCode() {
        return (this.padding.hashCode() * 31) + Boolean.hashCode(this.isYearOfEra);
    }
}
