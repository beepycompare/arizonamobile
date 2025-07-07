package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DatePeriod;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
/* compiled from: DateTimePeriodSerializers.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0013H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkotlinx/datetime/serializers/DatePeriodComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DatePeriod;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "unexpectedNonzero", "fieldName", "", "", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DatePeriodComponentSerializer implements KSerializer<DatePeriod> {
    public static final DatePeriodComponentSerializer INSTANCE = new DatePeriodComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.DatePeriod", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.DatePeriodComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.element("years", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
            buildClassSerialDescriptor.element("months", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
            buildClassSerialDescriptor.element("days", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
            buildClassSerialDescriptor.element("hours", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
            buildClassSerialDescriptor.element("minutes", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
            buildClassSerialDescriptor.element("seconds", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
            buildClassSerialDescriptor.element("nanoseconds", LongSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
        }
    });

    private DatePeriodComponentSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unexpectedNonzero(String str, long j) {
        if (j != 0) {
            throw new SerializationException("DatePeriod should have non-date components be zero, but got " + j + " in '" + str + '\'');
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unexpectedNonzero(String str, int i) {
        unexpectedNonzero(str, i);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DatePeriod deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            DatePeriodComponentSerializer datePeriodComponentSerializer = INSTANCE;
            int decodeElementIndex = beginStructure.decodeElementIndex(datePeriodComponentSerializer.getDescriptor());
            switch (decodeElementIndex) {
                case -1:
                    DatePeriod datePeriod = new DatePeriod(i, i2, i3);
                    beginStructure.endStructure(descriptor2);
                    return datePeriod;
                case 0:
                    i = beginStructure.decodeIntElement(datePeriodComponentSerializer.getDescriptor(), 0);
                    break;
                case 1:
                    i2 = beginStructure.decodeIntElement(datePeriodComponentSerializer.getDescriptor(), 1);
                    break;
                case 2:
                    i3 = beginStructure.decodeIntElement(datePeriodComponentSerializer.getDescriptor(), 2);
                    break;
                case 3:
                    datePeriodComponentSerializer.unexpectedNonzero("hours", beginStructure.decodeIntElement(datePeriodComponentSerializer.getDescriptor(), 3));
                    break;
                case 4:
                    datePeriodComponentSerializer.unexpectedNonzero("minutes", beginStructure.decodeIntElement(datePeriodComponentSerializer.getDescriptor(), 4));
                    break;
                case 5:
                    datePeriodComponentSerializer.unexpectedNonzero("seconds", beginStructure.decodeIntElement(datePeriodComponentSerializer.getDescriptor(), 5));
                    break;
                case 6:
                    datePeriodComponentSerializer.unexpectedNonzero("nanoseconds", beginStructure.decodeLongElement(datePeriodComponentSerializer.getDescriptor(), 6));
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + decodeElementIndex);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DatePeriod value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        if (value.getYears() != 0) {
            beginStructure.encodeIntElement(DateTimePeriodComponentSerializer.INSTANCE.getDescriptor(), 0, value.getYears());
        }
        if (value.getMonths() != 0) {
            beginStructure.encodeIntElement(DateTimePeriodComponentSerializer.INSTANCE.getDescriptor(), 1, value.getMonths());
        }
        if (value.getDays() != 0) {
            beginStructure.encodeIntElement(DateTimePeriodComponentSerializer.INSTANCE.getDescriptor(), 2, value.getDays());
        }
        beginStructure.endStructure(descriptor2);
    }
}
