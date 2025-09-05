package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.g2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0266g2 extends T2 {
    @Override // io.appmetrica.analytics.impl.T2
    public final MessageNano a() {
        return new C0240f2();
    }

    public final C0240f2 b() {
        return new C0240f2();
    }

    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0240f2();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0240f2 toState(byte[] bArr) throws IOException {
        return (C0240f2) MessageNano.mergeFrom(new C0240f2(), bArr);
    }
}
