package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.pl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0514pl extends BaseProtobufStateSerializer {
    public final C0462nl a() {
        return new C0462nl();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final MessageNano defaultValue() {
        return new C0462nl();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0462nl toState(byte[] bArr) {
        return (C0462nl) MessageNano.mergeFrom(new C0462nl(), bArr);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0462nl();
    }
}
