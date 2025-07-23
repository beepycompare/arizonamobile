package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0741ym extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b */
    public final C0716xm defaultValue() {
        C0716xm c0716xm = new C0716xm();
        c0716xm.i = new C0591sm();
        return c0716xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0716xm toState(byte[] bArr) throws IOException {
        return (C0716xm) MessageNano.mergeFrom(new C0716xm(), bArr);
    }
}
