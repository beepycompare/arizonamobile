package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.vm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0672vm extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b */
    public final C0647um defaultValue() {
        C0647um c0647um = new C0647um();
        c0647um.i = new C0523pm();
        return c0647um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0647um toState(byte[] bArr) throws IOException {
        return (C0647um) MessageNano.mergeFrom(new C0647um(), bArr);
    }
}
