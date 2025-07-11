package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0278g9 extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2
    public final MessageNano a() {
        return new M9();
    }

    public final M9 b() {
        return new M9();
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new M9();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final M9 toState(byte[] bArr) throws IOException {
        return (M9) MessageNano.mergeFrom(new M9(), bArr);
    }
}
