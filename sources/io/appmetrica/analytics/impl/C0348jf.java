package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.jf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0348jf extends BaseProtobufStateSerializer {
    public final C0475of a() {
        return new C0475of();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final MessageNano defaultValue() {
        return new C0475of();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0475of toState(byte[] bArr) throws IOException {
        return (C0475of) MessageNano.mergeFrom(new C0475of(), bArr);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0475of();
    }
}
