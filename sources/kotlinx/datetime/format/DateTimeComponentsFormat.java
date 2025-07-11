package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponentsFormat;", "Lkotlinx/datetime/format/AbstractDateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "actualFormat", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "<init>", "(Lkotlinx/datetime/internal/format/CachedFormatStructure;)V", "getActualFormat", "()Lkotlinx/datetime/internal/format/CachedFormatStructure;", "intermediateFromValue", "value", "valueFromIntermediate", "intermediate", "emptyIntermediate", "getEmptyIntermediate", "()Lkotlinx/datetime/format/DateTimeComponentsContents;", "Builder", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTimeComponentsFormat extends AbstractDateTimeFormat<DateTimeComponents, DateTimeComponentsContents> {
    private final CachedFormatStructure<DateTimeComponentsContents> actualFormat;

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public CachedFormatStructure<DateTimeComponentsContents> getActualFormat() {
        return this.actualFormat;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DateTimeComponentsFormat(CachedFormatStructure<? super DateTimeComponentsContents> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.actualFormat = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public DateTimeComponentsContents intermediateFromValue(DateTimeComponents value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getContents$kotlinx_datetime();
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public DateTimeComponents valueFromIntermediate(DateTimeComponentsContents intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return new DateTimeComponents(intermediate);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public DateTimeComponentsContents getEmptyIntermediate() {
        DateTimeComponentsContents dateTimeComponentsContents;
        dateTimeComponentsContents = DateTimeComponentsKt.emptyDateTimeComponentsContents;
        return dateTimeComponentsContents;
    }

    /* compiled from: DateTimeComponents.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0016\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0000H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlinx/datetime/format/DateTimeComponentsFormat$Builder;", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "Lkotlinx/datetime/format/AbstractWithDateTimeBuilder;", "Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "<init>", "(Lkotlinx/datetime/internal/format/AppendableFormatStructure;)V", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "addFormatStructureForDateTime", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "addFormatStructureForOffset", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "timeZoneId", "dateTimeComponents", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "createEmpty", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder implements AbstractDateTimeFormatBuilder<DateTimeComponentsContents, Builder>, AbstractWithDateTimeBuilder, AbstractWithOffsetBuilder, DateTimeFormatBuilder.WithDateTimeComponents {
        private final AppendableFormatStructure<DateTimeComponentsContents> actualBuilder;

        public Builder(AppendableFormatStructure<DateTimeComponentsContents> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.actualBuilder = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public AppendableFormatStructure<DateTimeComponentsContents> getActualBuilder() {
            return this.actualBuilder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.datetime.format.AbstractWithDateTimeBuilder
        public void addFormatStructureForDateTime(FormatStructure<? super DateTimeFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder
        public void addFormatStructureForOffset(FormatStructure<? super UtcOffsetFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTimeComponents
        public void timeZoneId() {
            getActualBuilder().add(new BasicFormatStructure(new TimeZoneIdDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDateTimeComponents
        public void dateTimeComponents(DateTimeFormat<DateTimeComponents> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof DateTimeComponentsFormat) {
                getActualBuilder().add(((DateTimeComponentsFormat) format).getActualFormat());
            }
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public Builder createEmpty() {
            return new Builder(new AppendableFormatStructure());
        }
    }
}
