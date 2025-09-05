package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Hm extends T2 {
    @Override // io.appmetrica.analytics.impl.T2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b */
    public final Gm defaultValue() {
        Gm gm = new Gm();
        gm.i = new Bm();
        return gm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final Gm toState(byte[] bArr) throws IOException {
        return (Gm) MessageNano.mergeFrom(new Gm(), bArr);
    }
}
