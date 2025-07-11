package kotlinx.datetime.internal.format.parser;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.MathKt;
/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ReducedIntConsumer;", "Receiver", "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "length", "", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "name", "", TtmlNode.RUBY_BASE, "<init>", "(ILkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;I)V", "getLength", "()Ljava/lang/Integer;", "getBase", "()I", "modulo", "baseMod", "baseFloor", "consume", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "storage", "input", "", TtmlNode.START, TtmlNode.END, "(Ljava/lang/Object;Ljava/lang/CharSequence;II)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReducedIntConsumer<Receiver> extends NumberConsumer<Receiver> {
    private final int base;
    private final int baseFloor;
    private final int baseMod;
    private final int length;
    private final int modulo;
    private final AssignableField<Receiver, Integer> setter;

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public Integer getLength() {
        return Integer.valueOf(this.length);
    }

    public final int getBase() {
        return this.base;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntConsumer(int i, AssignableField<? super Receiver, Integer> setter, String name, int i2) {
        super(Integer.valueOf(i), name, null);
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        this.length = i;
        this.setter = setter;
        this.base = i2;
        int i3 = MathKt.getPOWERS_OF_TEN()[getLength().intValue()];
        this.modulo = i3;
        int i4 = i2 % i3;
        this.baseMod = i4;
        this.baseFloor = i2 - i4;
        int intValue = getLength().intValue();
        if (1 > intValue || intValue >= 10) {
            throw new IllegalArgumentException(("Invalid length for field " + getWhatThisExpects() + ": " + getLength().intValue()).toString());
        }
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public NumberConsumptionError consume(Receiver receiver, CharSequence input, int i, int i2) {
        int parseAsciiInt;
        int i3;
        NumberConsumptionError withoutReassigning;
        Intrinsics.checkNotNullParameter(input, "input");
        parseAsciiInt = NumberConsumerKt.parseAsciiInt(input, i, i2);
        AssignableField<Receiver, Integer> assignableField = this.setter;
        if (parseAsciiInt >= this.baseMod) {
            i3 = this.baseFloor;
        } else {
            i3 = this.baseFloor + this.modulo;
        }
        withoutReassigning = NumberConsumerKt.setWithoutReassigning(assignableField, receiver, Integer.valueOf(i3 + parseAsciiInt));
        return withoutReassigning;
    }
}
