package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class D2 extends T2 {
    @Override // io.appmetrica.analytics.impl.T2
    public final MessageNano a() {
        return new C2();
    }

    public final C2 b() {
        return new C2();
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C2();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C2 toState(byte[] bArr) throws IOException {
        return (C2) MessageNano.mergeFrom(new C2(), bArr);
    }
}
