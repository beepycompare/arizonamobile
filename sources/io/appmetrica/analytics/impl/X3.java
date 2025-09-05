package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class X3 extends T2 {
    @Override // io.appmetrica.analytics.impl.T2
    public final MessageNano a() {
        return new W3();
    }

    public final W3 b() {
        return new W3();
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new W3();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final W3 toState(byte[] bArr) {
        return (W3) MessageNano.mergeFrom(new W3(), bArr);
    }
}
