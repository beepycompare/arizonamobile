package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.router.panels.PanelsWebNavigation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
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
/* compiled from: PanelsWebNavigation.kt */
@Metadata(d1 = {"\u0000<\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\t\u0010\u0001*\u0004\b\n\u0010\u0002*\u0004\b\u000b\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0016\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\t0\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u000b0\t¢\u0006\u0004\b\u0006\u0010\fJ\u0015\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000e¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b0\u00052\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b0\u0005J\u0015\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"com/arkivanov/decompose/router/panels/PanelsWebNavigation.HistoryItemKey.$serializer", "MC", "DC", "EC", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation$HistoryItemKey;", "<init>", "()V", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "typeSerial1", "typeSerial2", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "childSerializers", "", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "typeParametersSerializers", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes3.dex */
public /* synthetic */ class PanelsWebNavigation$HistoryItemKey$$serializer<MC, DC, EC> implements GeneratedSerializer<PanelsWebNavigation.HistoryItemKey<? extends MC, ? extends DC, ? extends EC>> {
    private final SerialDescriptor descriptor;
    private final /* synthetic */ KSerializer<?> typeSerial0;
    private final /* synthetic */ KSerializer<?> typeSerial1;
    private final /* synthetic */ KSerializer<?> typeSerial2;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    private PanelsWebNavigation$HistoryItemKey$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arkivanov.decompose.router.panels.PanelsWebNavigation.HistoryItemKey", this, 3);
        pluginGeneratedSerialDescriptor.addElement(JvmProtoBufUtil.DEFAULT_MODULE_NAME, false);
        pluginGeneratedSerialDescriptor.addElement("details", false);
        pluginGeneratedSerialDescriptor.addElement("extra", false);
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PanelsWebNavigation$HistoryItemKey$$serializer(KSerializer<MC> typeSerial0, KSerializer<DC> typeSerial1, KSerializer<EC> typeSerial2) {
        this();
        Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
        Intrinsics.checkNotNullParameter(typeSerial1, "typeSerial1");
        Intrinsics.checkNotNullParameter(typeSerial2, "typeSerial2");
        this.typeSerial0 = typeSerial0;
        this.typeSerial1 = typeSerial1;
        this.typeSerial2 = typeSerial2;
    }

    private final /* synthetic */ KSerializer getTypeSerial0() {
        return this.typeSerial0;
    }

    private final /* synthetic */ KSerializer getTypeSerial1() {
        return this.typeSerial1;
    }

    private final /* synthetic */ KSerializer getTypeSerial2() {
        return this.typeSerial2;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{this.typeSerial0, BuiltinSerializersKt.getNullable(this.typeSerial1), BuiltinSerializersKt.getNullable(this.typeSerial2)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PanelsWebNavigation.HistoryItemKey<MC, DC, EC> deserialize(Decoder decoder) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = this.descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        Object obj4 = null;
        if (beginStructure.decodeSequentially()) {
            Object decodeSerializableElement = beginStructure.decodeSerializableElement(serialDescriptor, 0, this.typeSerial0, null);
            Object decodeNullableSerializableElement = beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, this.typeSerial1, null);
            obj = decodeSerializableElement;
            obj3 = beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, this.typeSerial2, null);
            obj2 = decodeNullableSerializableElement;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            Object obj5 = null;
            Object obj6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    obj4 = beginStructure.decodeSerializableElement(serialDescriptor, 0, this.typeSerial0, obj4);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    obj5 = beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, this.typeSerial1, obj5);
                    i2 |= 2;
                } else if (decodeElementIndex != 2) {
                    throw new UnknownFieldException(decodeElementIndex);
                } else {
                    obj6 = beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, this.typeSerial2, obj6);
                    i2 |= 4;
                }
            }
            i = i2;
            obj = obj4;
            obj2 = obj5;
            obj3 = obj6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PanelsWebNavigation.HistoryItemKey<>(i, obj, obj2, obj3, null);
    }

    public final void serialize(Encoder encoder, PanelsWebNavigation.HistoryItemKey<? extends MC, ? extends DC, ? extends EC> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = this.descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PanelsWebNavigation.HistoryItemKey.write$Self$decompose_release(value, beginStructure, serialDescriptor, this.typeSerial0, this.typeSerial1, this.typeSerial2);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        serialize(encoder, (PanelsWebNavigation.HistoryItemKey) ((PanelsWebNavigation.HistoryItemKey) obj));
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] typeParametersSerializers() {
        return new KSerializer[]{this.typeSerial0, this.typeSerial1, this.typeSerial2};
    }
}
