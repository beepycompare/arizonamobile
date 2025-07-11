package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.vm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0664vm extends Q2 {
    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: b */
    public final C0639um defaultValue() {
        C0639um c0639um = new C0639um();
        c0639um.i = new C0515pm();
        return c0639um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0639um toState(byte[] bArr) throws IOException {
        return (C0639um) MessageNano.mergeFrom(new C0639um(), bArr);
    }
}
