package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Wk extends T2 {
    @Override // io.appmetrica.analytics.impl.T2
    public final MessageNano a() {
        return new Uk();
    }

    public final Uk b() {
        return new Uk();
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new Uk();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final Uk toState(byte[] bArr) {
        return (Uk) MessageNano.mergeFrom(new Uk(), bArr);
    }
}
