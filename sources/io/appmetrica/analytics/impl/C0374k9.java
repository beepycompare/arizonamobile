package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0374k9 extends BaseProtobufStateSerializer {
    public final O9 a() {
        return new O9();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final MessageNano defaultValue() {
        return new O9();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final O9 toState(byte[] bArr) throws IOException {
        return (O9) MessageNano.mergeFrom(new O9(), bArr);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new O9();
    }
}
