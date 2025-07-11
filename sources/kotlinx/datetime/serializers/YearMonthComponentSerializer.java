package kotlinx.datetime.serializers;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.YearMonth;
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
/* compiled from: YearMonthSerializers.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/serializers/YearMonthComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/YearMonth;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YearMonthComponentSerializer implements KSerializer<YearMonth> {
    public static final YearMonthComponentSerializer INSTANCE = new YearMonthComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.YearMonth/components", new SerialDescriptor[0], new Function1() { // from class: kotlinx.datetime.serializers.YearMonthComponentSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = YearMonthComponentSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private YearMonthComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public YearMonth deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Integer num = null;
        Short sh = null;
        while (true) {
            YearMonthComponentSerializer yearMonthComponentSerializer = INSTANCE;
            int decodeElementIndex = beginStructure.decodeElementIndex(yearMonthComponentSerializer.getDescriptor());
            if (decodeElementIndex == -1) {
                if (num != null) {
                    if (sh == null) {
                        throw new MissingFieldException("month", yearMonthComponentSerializer.getDescriptor().getSerialName());
                    }
                    YearMonth yearMonth = new YearMonth(num.intValue(), sh.shortValue());
                    beginStructure.endStructure(descriptor2);
                    return yearMonth;
                }
                throw new MissingFieldException("year", yearMonthComponentSerializer.getDescriptor().getSerialName());
            } else if (decodeElementIndex == 0) {
                num = Integer.valueOf(beginStructure.decodeIntElement(yearMonthComponentSerializer.getDescriptor(), 0));
            } else if (decodeElementIndex == 1) {
                sh = Short.valueOf(beginStructure.decodeShortElement(yearMonthComponentSerializer.getDescriptor(), 1));
            } else {
                DateTimeUnitSerializersKt.throwUnknownIndexException(decodeElementIndex);
                throw new KotlinNothingValueException();
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, YearMonth value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        YearMonthComponentSerializer yearMonthComponentSerializer = INSTANCE;
        beginStructure.encodeIntElement(yearMonthComponentSerializer.getDescriptor(), 0, value.getYear());
        beginStructure.encodeShortElement(yearMonthComponentSerializer.getDescriptor(), 1, (short) MonthKt.getNumber(value.getMonth()));
        beginStructure.endStructure(descriptor2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.element("year", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("month", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        return Unit.INSTANCE;
    }
}
