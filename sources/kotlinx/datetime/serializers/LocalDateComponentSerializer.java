package kotlinx.datetime.serializers;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;
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
import kotlinx.serialization.internal.ShortSerializer;
/* compiled from: LocalDateSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/serializers/LocalDateComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/LocalDate;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalDateComponentSerializer implements KSerializer<LocalDate> {
    public static final LocalDateComponentSerializer INSTANCE = new LocalDateComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.LocalDate", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.datetime.serializers.LocalDateComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.element("year", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
            buildClassSerialDescriptor.element("month", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
            buildClassSerialDescriptor.element("day", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        }
    });

    private LocalDateComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalDate deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Integer num = null;
        Short sh = null;
        Short sh2 = null;
        while (true) {
            LocalDateComponentSerializer localDateComponentSerializer = INSTANCE;
            int decodeElementIndex = beginStructure.decodeElementIndex(localDateComponentSerializer.getDescriptor());
            if (decodeElementIndex == -1) {
                if (num != null) {
                    if (sh != null) {
                        if (sh2 == null) {
                            throw new MissingFieldException("day", localDateComponentSerializer.getDescriptor().getSerialName());
                        }
                        LocalDate localDate = new LocalDate(num.intValue(), sh.shortValue(), sh2.shortValue());
                        beginStructure.endStructure(descriptor2);
                        return localDate;
                    }
                    throw new MissingFieldException("month", localDateComponentSerializer.getDescriptor().getSerialName());
                }
                throw new MissingFieldException("year", localDateComponentSerializer.getDescriptor().getSerialName());
            } else if (decodeElementIndex == 0) {
                num = Integer.valueOf(beginStructure.decodeIntElement(localDateComponentSerializer.getDescriptor(), 0));
            } else if (decodeElementIndex == 1) {
                sh = Short.valueOf(beginStructure.decodeShortElement(localDateComponentSerializer.getDescriptor(), 1));
            } else if (decodeElementIndex == 2) {
                sh2 = Short.valueOf(beginStructure.decodeShortElement(localDateComponentSerializer.getDescriptor(), 2));
            } else {
                DateTimeUnitSerializersKt.throwUnknownIndexException(decodeElementIndex);
                throw new KotlinNothingValueException();
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalDate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LocalDateComponentSerializer localDateComponentSerializer = INSTANCE;
        beginStructure.encodeIntElement(localDateComponentSerializer.getDescriptor(), 0, value.getYear());
        beginStructure.encodeShortElement(localDateComponentSerializer.getDescriptor(), 1, (short) value.getMonthNumber());
        beginStructure.encodeShortElement(localDateComponentSerializer.getDescriptor(), 2, (short) value.getDayOfMonth());
        beginStructure.endStructure(descriptor2);
    }
}
