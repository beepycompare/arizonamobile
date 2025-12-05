package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class R8 extends BaseProtobufStateSerializer {
    public final C0643v9 a() {
        return new C0643v9();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final MessageNano defaultValue() {
        return new C0643v9();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0643v9 toState(byte[] bArr) throws IOException {
        return (C0643v9) MessageNano.mergeFrom(new C0643v9(), bArr);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0643v9();
    }
}
