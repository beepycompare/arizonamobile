package kotlinx.datetime.serializers;

import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;
/* compiled from: DateTimeUnitSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/serializers/DayBasedDateTimeUnitSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DateTimeUnit$DayBased;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DayBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.DayBased> {
    public static final DayBasedDateTimeUnitSerializer INSTANCE = new DayBasedDateTimeUnitSerializer();
    private static final Lazy descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SerialDescriptor descriptor_delegate$lambda$1;
            descriptor_delegate$lambda$1 = DayBasedDateTimeUnitSerializer.descriptor_delegate$lambda$1();
            return descriptor_delegate$lambda$1;
        }
    });

    private DayBasedDateTimeUnitSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) descriptor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor descriptor_delegate$lambda$1() {
        return SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.DayBased", new SerialDescriptor[0], new Function1() { // from class: kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit descriptor_delegate$lambda$1$lambda$0;
                descriptor_delegate$lambda$1$lambda$0 = DayBasedDateTimeUnitSerializer.descriptor_delegate$lambda$1$lambda$0((ClassSerialDescriptorBuilder) obj);
                return descriptor_delegate$lambda$1$lambda$0;
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DateTimeUnit.DayBased value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor);
        beginStructure.encodeIntElement(INSTANCE.getDescriptor(), 0, value.getDays());
        beginStructure.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DateTimeUnit.DayBased deserialize(Decoder decoder) {
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        boolean z = true;
        if (!beginStructure.decodeSequentially()) {
            i = 0;
            boolean z2 = false;
            while (true) {
                DayBasedDateTimeUnitSerializer dayBasedDateTimeUnitSerializer = INSTANCE;
                int decodeElementIndex = beginStructure.decodeElementIndex(dayBasedDateTimeUnitSerializer.getDescriptor());
                if (decodeElementIndex == -1) {
                    z = z2;
                    break;
                } else if (decodeElementIndex == 0) {
                    i = beginStructure.decodeIntElement(dayBasedDateTimeUnitSerializer.getDescriptor(), 0);
                    z2 = true;
                } else {
                    DateTimeUnitSerializersKt.throwUnknownIndexException(decodeElementIndex);
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            i = beginStructure.decodeIntElement(INSTANCE.getDescriptor(), 0);
        }
        Unit unit = Unit.INSTANCE;
        beginStructure.endStructure(descriptor);
        if (!z) {
            throw new MissingFieldException("days", getDescriptor().getSerialName());
        }
        return new DateTimeUnit.DayBased(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor_delegate$lambda$1$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.element("days", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        return Unit.INSTANCE;
    }
}
