package kotlinx.datetime.internal.format.formatter;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Formatter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/ConcatenatedFormatter;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "formatters", "", "(Ljava/util/List;)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConcatenatedFormatter<T> implements FormatterStructure<T> {
    private final List<FormatterStructure<T>> formatters;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcatenatedFormatter(List<? extends FormatterStructure<? super T>> formatters) {
        Intrinsics.checkNotNullParameter(formatters, "formatters");
        this.formatters = formatters;
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (FormatterStructure<T> formatterStructure : this.formatters) {
            formatterStructure.format(t, builder, z);
        }
    }
}
