package kotlinx.datetime.format;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AlternativesParsingFormatStructure;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.ConstantFormatStructure;
import kotlinx.datetime.internal.format.OptionalFormatStructure;
/* compiled from: DateTimeFormatBuilder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00002\u00020\u0003J\r\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\tJ\\\u0010\n\u001a\u00020\u000b24\u0010\f\u001a\u001b\u0012\u0017\b\u0001\u0012\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000f0\r\"\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000fH\u0016¢\u0006\u0002\u0010\u0011J)\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Target", "ActualSelf", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "createEmpty", "()Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "appendAlternativeParsingImpl", "", "otherFormats", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "mainFormat", "([Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "appendOptionalImpl", "onZero", "", "format", "chars", "value", "build", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AbstractDateTimeFormatBuilder<Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> extends DateTimeFormatBuilder {
    ActualSelf createEmpty();

    AppendableFormatStructure<Target> getActualBuilder();

    /* compiled from: DateTimeFormatBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> void appendAlternativeParsingImpl(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder, Function1<? super ActualSelf, Unit>[] otherFormats, Function1<? super ActualSelf, Unit> mainFormat) {
            Intrinsics.checkNotNullParameter(otherFormats, "otherFormats");
            Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
            AbstractDateTimeFormatBuilder.super.appendAlternativeParsingImpl(otherFormats, mainFormat);
        }

        @Deprecated
        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> void appendOptionalImpl(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder, String onZero, Function1<? super ActualSelf, Unit> format) {
            Intrinsics.checkNotNullParameter(onZero, "onZero");
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractDateTimeFormatBuilder.super.appendOptionalImpl(onZero, format);
        }

        @Deprecated
        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> void chars(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            AbstractDateTimeFormatBuilder.super.chars(value);
        }

        @Deprecated
        public static <Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> CachedFormatStructure<Target> build(AbstractDateTimeFormatBuilder<Target, ActualSelf> abstractDateTimeFormatBuilder) {
            return AbstractDateTimeFormatBuilder.super.build();
        }
    }

    default void appendOptionalImpl(String onZero, Function1<? super ActualSelf, Unit> format) {
        Intrinsics.checkNotNullParameter(onZero, "onZero");
        Intrinsics.checkNotNullParameter(format, "format");
        AppendableFormatStructure<Target> actualBuilder = getActualBuilder();
        ActualSelf createEmpty = createEmpty();
        format.invoke(createEmpty);
        Unit unit = Unit.INSTANCE;
        actualBuilder.add(new OptionalFormatStructure(onZero, createEmpty.getActualBuilder().build()));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder
    default void chars(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getActualBuilder().add(new ConstantFormatStructure(value));
    }

    default CachedFormatStructure<Target> build() {
        return new CachedFormatStructure<>(getActualBuilder().build().getFormats());
    }

    default void appendAlternativeParsingImpl(Function1<? super ActualSelf, Unit>[] otherFormats, Function1<? super ActualSelf, Unit> mainFormat) {
        Intrinsics.checkNotNullParameter(otherFormats, "otherFormats");
        Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
        ArrayList arrayList = new ArrayList(otherFormats.length);
        for (Function1<? super ActualSelf, Unit> function1 : otherFormats) {
            ActualSelf createEmpty = createEmpty();
            function1.invoke(createEmpty);
            arrayList.add(createEmpty.getActualBuilder().build());
        }
        ActualSelf createEmpty2 = createEmpty();
        mainFormat.invoke(createEmpty2);
        getActualBuilder().add(new AlternativesParsingFormatStructure(createEmpty2.getActualBuilder().build(), arrayList));
    }
}
