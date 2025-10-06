package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.o9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0481o9 extends T2 {
    @Override // io.appmetrica.analytics.impl.T2
    public final MessageNano a() {
        return new U9();
    }

    public final U9 b() {
        return new U9();
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new U9();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final U9 toState(byte[] bArr) throws IOException {
        return (U9) MessageNano.mergeFrom(new U9(), bArr);
    }
}
