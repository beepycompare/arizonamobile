package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.PropertyAccessor;
/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a \u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\" \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"format", "", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "parse", "Lkotlinx/datetime/format/DateTimeComponents$Companion;", "input", "", "timeZoneField", "Lkotlinx/datetime/internal/format/GenericFieldSpec;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "getTimeZoneField", "()Lkotlinx/datetime/internal/format/GenericFieldSpec;", "emptyDateTimeComponentsContents", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTimeComponentsKt {
    private static final GenericFieldSpec<DateTimeComponentsContents, String> timeZoneField = new GenericFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateTimeComponentsKt$timeZoneField$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((DateTimeComponentsContents) obj).getTimeZoneId();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((DateTimeComponentsContents) obj).setTimeZoneId((String) obj2);
        }
    }, null, 2, null), null, null, null, 14, null);
    private static final DateTimeComponentsContents emptyDateTimeComponentsContents = new DateTimeComponentsContents(null, null, null, null, 15, null);

    public static final String format(DateTimeFormat<DateTimeComponents> dateTimeFormat, Function1<? super DateTimeComponents, Unit> block) {
        Intrinsics.checkNotNullParameter(dateTimeFormat, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DateTimeComponents dateTimeComponents = new DateTimeComponents(null, 1, null);
        block.invoke(dateTimeComponents);
        return dateTimeFormat.format(dateTimeComponents);
    }

    public static final DateTimeComponents parse(DateTimeComponents.Companion companion, CharSequence input, DateTimeFormat<DateTimeComponents> format) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.parse(input);
    }

    public static final GenericFieldSpec<DateTimeComponentsContents, String> getTimeZoneField() {
        return timeZoneField;
    }
}
