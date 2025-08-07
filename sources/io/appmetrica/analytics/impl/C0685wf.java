package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.wf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0685wf extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2
    public final MessageNano a() {
        return new Bf();
    }

    public final Bf b() {
        return new Bf();
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new Bf();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final Bf toState(byte[] bArr) throws IOException {
        return (Bf) MessageNano.mergeFrom(new Bf(), bArr);
    }
}
