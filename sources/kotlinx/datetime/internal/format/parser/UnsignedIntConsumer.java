package kotlinx.datetime.internal.format.parser;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;
/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ/\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/datetime/internal/format/parser/UnsignedIntConsumer;", "Receiver", "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "minLength", "", "maxLength", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "name", "", "multiplyByMinus1", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;Z)V", "Ljava/lang/Integer;", "consume", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "storage", "input", "", TtmlNode.START, TtmlNode.END, "(Ljava/lang/Object;Ljava/lang/CharSequence;II)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnsignedIntConsumer<Receiver> extends NumberConsumer<Receiver> {
    private final Integer maxLength;
    private final Integer minLength;
    private final boolean multiplyByMinus1;
    private final AssignableField<Receiver, Integer> setter;

    public /* synthetic */ UnsignedIntConsumer(Integer num, Integer num2, AssignableField assignableField, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, assignableField, str, (i & 16) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnsignedIntConsumer(Integer num, Integer num2, AssignableField<? super Receiver, Integer> setter, String name, boolean z) {
        super(Intrinsics.areEqual(num, num2) ? num : null, name, null);
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        this.minLength = num;
        this.maxLength = num2;
        this.setter = setter;
        this.multiplyByMinus1 = z;
        if (getLength() != null && !new IntRange(1, 9).contains(getLength().intValue())) {
            throw new IllegalArgumentException(("Invalid length for field " + getWhatThisExpects() + ": " + getLength()).toString());
        }
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public NumberConsumptionError consume(Receiver receiver, CharSequence input, int i, int i2) {
        Integer parseAsciiIntOrNull;
        NumberConsumptionError withoutReassigning;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer num = this.maxLength;
        if (num == null || i2 - i <= num.intValue()) {
            Integer num2 = this.minLength;
            if (num2 == null || i2 - i >= num2.intValue()) {
                parseAsciiIntOrNull = NumberConsumerKt.parseAsciiIntOrNull(input, i, i2);
                if (parseAsciiIntOrNull == null) {
                    return NumberConsumptionError.ExpectedInt.INSTANCE;
                }
                AssignableField<Receiver, Integer> assignableField = this.setter;
                boolean z = this.multiplyByMinus1;
                int intValue = parseAsciiIntOrNull.intValue();
                if (z) {
                    intValue = -intValue;
                }
                withoutReassigning = NumberConsumerKt.setWithoutReassigning(assignableField, receiver, Integer.valueOf(intValue));
                return withoutReassigning;
            }
            return new NumberConsumptionError.TooFewDigits(this.minLength.intValue());
        }
        return new NumberConsumptionError.TooManyDigits(this.maxLength.intValue());
    }
}
