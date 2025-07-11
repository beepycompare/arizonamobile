package kotlinx.datetime.internal.format.formatter;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.MathKt;
/* compiled from: FormatterOperation.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B+\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/ReducedIntFormatterStructure;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "number", "Lkotlin/Function1;", "", "digits", TtmlNode.RUBY_BASE, "<init>", "(Lkotlin/jvm/functions/Function1;II)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReducedIntFormatterStructure<T> implements FormatterStructure<T> {
    private final int base;
    private final int digits;
    private final Function1<T, Integer> number;

    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntFormatterStructure(Function1<? super T, Integer> number, int i, int i2) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.number = number;
        this.digits = i;
        this.base = i2;
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        int intValue = this.number.invoke(t).intValue();
        int i = MathKt.getPOWERS_OF_TEN()[this.digits];
        int i2 = intValue - this.base;
        if (i2 >= 0 && i2 < i) {
            String valueOf = String.valueOf(intValue % MathKt.getPOWERS_OF_TEN()[this.digits]);
            StringsKt.append(builder, StringsKt.repeat("0", Math.max(0, this.digits - valueOf.length())), valueOf);
            return;
        }
        if (intValue >= 0) {
            builder.append("+");
        }
        builder.append(String.valueOf(intValue));
    }
}
