package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Dm extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b */
    public final Cm defaultValue() {
        Cm cm = new Cm();
        cm.i = new C0714xm();
        return cm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final Cm toState(byte[] bArr) throws IOException {
        return (Cm) MessageNano.mergeFrom(new Cm(), bArr);
    }
}
