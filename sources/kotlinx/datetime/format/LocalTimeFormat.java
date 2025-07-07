package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.AbstractWithTimeBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/format/LocalTimeFormat;", "Lkotlinx/datetime/format/AbstractDateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "Lkotlinx/datetime/format/IncompleteLocalTime;", "actualFormat", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "Lkotlinx/datetime/format/TimeFieldContainer;", "(Lkotlinx/datetime/internal/format/CachedFormatStructure;)V", "getActualFormat", "()Lkotlinx/datetime/internal/format/CachedFormatStructure;", "emptyIntermediate", "getEmptyIntermediate", "()Lkotlinx/datetime/format/IncompleteLocalTime;", "intermediateFromValue", "value", "valueFromIntermediate", "intermediate", "Builder", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalTimeFormat extends AbstractDateTimeFormat<LocalTime, IncompleteLocalTime> {
    public static final Companion Companion = new Companion(null);
    private final CachedFormatStructure<TimeFieldContainer> actualFormat;

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public CachedFormatStructure<IncompleteLocalTime> getActualFormat() {
        return this.actualFormat;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalTimeFormat(CachedFormatStructure<? super TimeFieldContainer> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.actualFormat = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public IncompleteLocalTime intermediateFromValue(LocalTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        IncompleteLocalTime incompleteLocalTime = new IncompleteLocalTime(null, null, null, null, null, null, 63, null);
        incompleteLocalTime.populateFrom(value);
        return incompleteLocalTime;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public LocalTime valueFromIntermediate(IncompleteLocalTime intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.toLocalTime();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public IncompleteLocalTime getEmptyIntermediate() {
        IncompleteLocalTime incompleteLocalTime;
        incompleteLocalTime = LocalTimeFormatKt.emptyIncompleteLocalTime;
        return incompleteLocalTime;
    }

    /* compiled from: LocalTimeFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/datetime/format/LocalTimeFormat$Companion;", "", "()V", "build", "Lkotlinx/datetime/format/LocalTimeFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocalTimeFormat build(Function1<? super DateTimeFormatBuilder.WithTime, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(new AppendableFormatStructure());
            block.invoke(builder);
            return new LocalTimeFormat(builder.build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalTimeFormat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/datetime/format/LocalTimeFormat$Builder;", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/format/AbstractWithTimeBuilder;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "(Lkotlinx/datetime/internal/format/AppendableFormatStructure;)V", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "addFormatStructureForTime", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "createEmpty", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements AbstractDateTimeFormatBuilder<TimeFieldContainer, Builder>, AbstractWithTimeBuilder {
        private final AppendableFormatStructure<TimeFieldContainer> actualBuilder;

        public Builder(AppendableFormatStructure<TimeFieldContainer> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.actualBuilder = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void amPmHour(Padding padding) {
            AbstractWithTimeBuilder.DefaultImpls.amPmHour(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void amPmMarker(String str, String str2) {
            AbstractWithTimeBuilder.DefaultImpls.amPmMarker(this, str, str2);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public void appendAlternativeParsingImpl(Function1<? super Builder, Unit>[] function1Arr, Function1<? super Builder, Unit> function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.appendAlternativeParsingImpl(this, function1Arr, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public void appendOptionalImpl(String str, Function1<? super Builder, Unit> function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.appendOptionalImpl(this, str, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public CachedFormatStructure<TimeFieldContainer> build() {
            return AbstractDateTimeFormatBuilder.DefaultImpls.build(this);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder, kotlinx.datetime.format.DateTimeFormatBuilder
        public void chars(String str) {
            AbstractDateTimeFormatBuilder.DefaultImpls.chars(this, str);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public AppendableFormatStructure<TimeFieldContainer> getActualBuilder() {
            return this.actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void hour(Padding padding) {
            AbstractWithTimeBuilder.DefaultImpls.hour(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void minute(Padding padding) {
            AbstractWithTimeBuilder.DefaultImpls.minute(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void second(Padding padding) {
            AbstractWithTimeBuilder.DefaultImpls.second(this, padding);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void secondFraction(int i) {
            AbstractWithTimeBuilder.DefaultImpls.secondFraction(this, i);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void secondFraction(int i, int i2) {
            AbstractWithTimeBuilder.DefaultImpls.secondFraction(this, i, i2);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public void time(DateTimeFormat<LocalTime> dateTimeFormat) {
            AbstractWithTimeBuilder.DefaultImpls.time(this, dateTimeFormat);
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder
        public void addFormatStructureForTime(FormatStructure<? super TimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public Builder createEmpty() {
            return new Builder(new AppendableFormatStructure());
        }
    }
}
