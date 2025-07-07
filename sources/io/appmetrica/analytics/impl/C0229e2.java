package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.e2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0229e2 extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2
    public final MessageNano a() {
        return new C0204d2();
    }

    public final C0204d2 b() {
        return new C0204d2();
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0204d2();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0204d2 toState(byte[] bArr) throws IOException {
        return (C0204d2) MessageNano.mergeFrom(new C0204d2(), bArr);
    }
}
