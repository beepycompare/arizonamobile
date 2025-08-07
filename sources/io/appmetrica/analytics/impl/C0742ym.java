package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0742ym extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b */
    public final C0717xm defaultValue() {
        C0717xm c0717xm = new C0717xm();
        c0717xm.i = new C0592sm();
        return c0717xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0717xm toState(byte[] bArr) throws IOException {
        return (C0717xm) MessageNano.mergeFrom(new C0717xm(), bArr);
    }
}
