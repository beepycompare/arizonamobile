package kotlinx.datetime.format;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.Copyable;
import kotlinx.datetime.internal.format.parser.ParseException;
import kotlinx.datetime.internal.format.parser.Parser;
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u0002H\u0019\"\f\b\u0002\u0010\u0019*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001c\u001a\u0002H\u00192\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0002\u0010!R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0011\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0006#$%&'(¨\u0006)"}, d2 = {"Lkotlinx/datetime/format/AbstractDateTimeFormat;", ExifInterface.GPS_DIRECTION_TRUE, "U", "Lkotlinx/datetime/internal/format/parser/Copyable;", "Lkotlinx/datetime/format/DateTimeFormat;", "<init>", "()V", "actualFormat", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "getActualFormat", "()Lkotlinx/datetime/internal/format/CachedFormatStructure;", "intermediateFromValue", "value", "(Ljava/lang/Object;)Lkotlinx/datetime/internal/format/parser/Copyable;", "valueFromIntermediate", "intermediate", "(Lkotlinx/datetime/internal/format/parser/Copyable;)Ljava/lang/Object;", "emptyIntermediate", "getEmptyIntermediate", "()Lkotlinx/datetime/internal/format/parser/Copyable;", "valueFromIntermediateOrNull", "format", "", "(Ljava/lang/Object;)Ljava/lang/String;", "formatTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "appendable", "(Ljava/lang/Appendable;Ljava/lang/Object;)Ljava/lang/Appendable;", "parse", "input", "", "(Ljava/lang/CharSequence;)Ljava/lang/Object;", "parseOrNull", "Lkotlinx/datetime/format/DateTimeComponentsFormat;", "Lkotlinx/datetime/format/LocalDateFormat;", "Lkotlinx/datetime/format/LocalDateTimeFormat;", "Lkotlinx/datetime/format/LocalTimeFormat;", "Lkotlinx/datetime/format/UtcOffsetFormat;", "Lkotlinx/datetime/format/YearMonthFormat;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractDateTimeFormat<T, U extends Copyable<U>> implements DateTimeFormat<T> {
    public /* synthetic */ AbstractDateTimeFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract CachedFormatStructure<U> getActualFormat();

    public abstract U getEmptyIntermediate();

    public abstract U intermediateFromValue(T t);

    public abstract T valueFromIntermediate(U u);

    private AbstractDateTimeFormat() {
    }

    public T valueFromIntermediateOrNull(U intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        try {
            return valueFromIntermediate(intermediate);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // kotlinx.datetime.format.DateTimeFormat
    public String format(T t) {
        StringBuilder sb = new StringBuilder();
        FormatterStructure.format$default(getActualFormat().formatter(), intermediateFromValue(t), sb, false, 4, null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Override // kotlinx.datetime.format.DateTimeFormat
    public <A extends Appendable> A formatTo(A appendable, T t) {
        Intrinsics.checkNotNullParameter(appendable, "appendable");
        FormatterStructure.format$default(getActualFormat().formatter(), intermediateFromValue(t), appendable, false, 4, null);
        return appendable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.datetime.format.DateTimeFormat
    public T parse(CharSequence input) {
        CharSequence charSequence;
        String str;
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            charSequence = input;
        } catch (ParseException e) {
            e = e;
            charSequence = input;
        }
        try {
            try {
                return (T) valueFromIntermediate(Parser.m10138matchimpl$default(Parser.m10133constructorimpl(getActualFormat().parser()), charSequence, getEmptyIntermediate(), 0, 4, null));
            } catch (IllegalArgumentException e2) {
                String message = e2.getMessage();
                if (message == null) {
                    str = "The value parsed from '" + ((Object) charSequence) + "' is invalid";
                } else {
                    str = message + " (when parsing '" + ((Object) charSequence) + "')";
                }
                throw new DateTimeFormatException(str, e2);
            }
        } catch (ParseException e3) {
            e = e3;
            throw new DateTimeFormatException("Failed to parse value from '" + ((Object) charSequence) + '\'', e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.datetime.format.DateTimeFormat
    public T parseOrNull(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Copyable m10140matchOrNullimpl$default = Parser.m10140matchOrNullimpl$default(Parser.m10133constructorimpl(getActualFormat().parser()), input, getEmptyIntermediate(), 0, 4, null);
        if (m10140matchOrNullimpl$default != null) {
            return (T) valueFromIntermediateOrNull(m10140matchOrNullimpl$default);
        }
        return null;
    }
}
