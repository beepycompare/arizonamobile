package com.arkivanov.essenty.statekeeper;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.statekeeper.base64.DecoderKt;
import com.arkivanov.essenty.statekeeper.base64.EncoderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
/* compiled from: SerializableContainer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0003\u0014\u0015\u0016B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J%\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\n*\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u0001H\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0011¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "", "data", "", "<init>", "([B)V", "()V", "holder", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer$Holder;", "consume", ExifInterface.GPS_DIRECTION_TRUE, "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "set", "", "value", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)V", "clear", "Holder", "Serializer", "Companion", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = Serializer.class)
/* loaded from: classes3.dex */
public final class SerializableContainer {
    public static final Companion Companion = new Companion(null);
    private byte[] data;
    private Holder<?> holder;

    public /* synthetic */ SerializableContainer(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    /* compiled from: SerializableContainer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/SerializableContainer$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SerializableContainer> serializer() {
            return Serializer.INSTANCE;
        }
    }

    private SerializableContainer(byte[] bArr) {
        this.data = bArr;
    }

    public SerializableContainer() {
        this(null);
    }

    public final <T> T consume(DeserializationStrategy<? extends T> strategy) {
        T t;
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Holder<?> holder = this.holder;
        if (holder == null || (t = (T) holder.getValue()) == null) {
            byte[] bArr = this.data;
            t = bArr != null ? (T) Utils_javaKt.deserialize(bArr, strategy) : null;
        }
        this.holder = null;
        this.data = null;
        return t;
    }

    public final <T> void set(T t, SerializationStrategy<? super T> strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.holder = new Holder<>(t, strategy);
        this.data = null;
    }

    public final void clear() {
        this.holder = null;
        this.data = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SerializableContainer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/SerializableContainer$Holder;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "<init>", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStrategy", "()Lkotlinx/serialization/SerializationStrategy;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder<T> {
        private final SerializationStrategy<T> strategy;
        private final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public Holder(T t, SerializationStrategy<? super T> strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.value = t;
            this.strategy = strategy;
        }

        public final T getValue() {
            return this.value;
        }

        public final SerializationStrategy<T> getStrategy() {
            return this.strategy;
        }
    }

    /* compiled from: SerializableContainer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0010\"\b\b\u0000\u0010\u0011*\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/SerializableContainer$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "()V", "NULL_MARKER", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer$Holder;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Serializer implements KSerializer<SerializableContainer> {
        private static final String NULL_MARKER = ".";
        public static final Serializer INSTANCE = new Serializer();
        private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("SerializableContainer", PrimitiveKind.STRING.INSTANCE);

        private Serializer() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, SerializableContainer value) {
            byte[] bArr;
            String str;
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            Holder holder = value.holder;
            if (holder == null || (bArr = serialize(holder)) == null) {
                bArr = value.data;
            }
            if (bArr == null || (str = EncoderKt.toBase64(bArr)) == null) {
                str = NULL_MARKER;
            }
            encoder.encodeString(str);
        }

        private final <T> byte[] serialize(Holder<T> holder) {
            T value = holder.getValue();
            if (value != null) {
                return Utils_javaKt.serialize(value, holder.getStrategy());
            }
            return null;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public SerializableContainer deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            String decodeString = decoder.decodeString();
            if (Intrinsics.areEqual(decodeString, NULL_MARKER)) {
                decodeString = null;
            }
            return new SerializableContainer(decodeString != null ? DecoderKt.base64ToByteArray(decodeString) : null, null);
        }
    }
}
