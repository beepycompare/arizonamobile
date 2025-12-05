package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.z3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0737z3 extends BaseProtobufStateSerializer {
    public final C0712y3 a() {
        return new C0712y3();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final MessageNano defaultValue() {
        return new C0712y3();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0712y3 toState(byte[] bArr) {
        return (C0712y3) MessageNano.mergeFrom(new C0712y3(), bArr);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0712y3();
    }
}
