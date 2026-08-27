package com.arkivanov.decompose.router.children;

import com.arkivanov.decompose.router.children.ChildrenNavigator;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: ChildrenNavigator.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/arkivanov/decompose/router/children/ChildrenNavigator.SavedChildState.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator$SavedChildState;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes4.dex */
public /* synthetic */ class ChildrenNavigator$SavedChildState$$serializer implements GeneratedSerializer<ChildrenNavigator.SavedChildState> {
    public static final ChildrenNavigator$SavedChildState$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private ChildrenNavigator$SavedChildState$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChildrenNavigator$SavedChildState$$serializer childrenNavigator$SavedChildState$$serializer = new ChildrenNavigator$SavedChildState$$serializer();
        INSTANCE = childrenNavigator$SavedChildState$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arkivanov.decompose.router.children.ChildrenNavigator.SavedChildState", childrenNavigator$SavedChildState$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("key", false);
        pluginGeneratedSerialDescriptor.addElement("savedState", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SerializableContainer.Serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ChildrenNavigator.SavedChildState deserialize(Decoder decoder) {
        String str;
        SerializableContainer serializableContainer;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            str = beginStructure.decodeStringElement(serialDescriptor, 0);
            serializableContainer = (SerializableContainer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SerializableContainer.Serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            SerializableContainer serializableContainer2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    str = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                } else {
                    serializableContainer2 = (SerializableContainer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, SerializableContainer.Serializer.INSTANCE, serializableContainer2);
                    i2 |= 2;
                }
            }
            serializableContainer = serializableContainer2;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ChildrenNavigator.SavedChildState(i, str, serializableContainer, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ChildrenNavigator.SavedChildState value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ChildrenNavigator.SavedChildState.write$Self$decompose_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
