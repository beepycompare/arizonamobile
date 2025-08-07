package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class A2 extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2
    public final MessageNano a() {
        return new C0747z2();
    }

    public final C0747z2 b() {
        return new C0747z2();
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0747z2();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0747z2 toState(byte[] bArr) throws IOException {
        return (C0747z2) MessageNano.mergeFrom(new C0747z2(), bArr);
    }
}
