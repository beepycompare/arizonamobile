package io.appmetrica.analytics.coreutils.internal.data;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public abstract class BaseProtobufStateSerializer<T extends MessageNano> implements ProtobufStateSerializer<T> {
    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public abstract T defaultValue();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public /* bridge */ /* synthetic */ byte[] toByteArray(Object obj) {
        return toByteArray((BaseProtobufStateSerializer<T>) ((MessageNano) obj));
    }

    public byte[] toByteArray(T t) {
        return MessageNano.toByteArray(t);
    }
}
