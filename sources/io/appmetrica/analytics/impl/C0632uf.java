package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.uf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0632uf extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2
    public final MessageNano a() {
        return new C0757zf();
    }

    public final C0757zf b() {
        return new C0757zf();
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C0757zf();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0757zf toState(byte[] bArr) throws IOException {
        return (C0757zf) MessageNano.mergeFrom(new C0757zf(), bArr);
    }
}
