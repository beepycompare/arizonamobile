package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public abstract class Q2 implements ProtobufStateSerializer {
    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public abstract MessageNano defaultValue();

    public final byte[] a(MessageNano messageNano) {
        return MessageNano.toByteArray(messageNano);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final byte[] toByteArray(Object obj) {
        return MessageNano.toByteArray((MessageNano) obj);
    }
}
