package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0731ym extends BaseProtobufStateSerializer {
    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0706xm defaultValue() {
        C0706xm c0706xm = new C0706xm();
        c0706xm.i = new C0581sm();
        return c0706xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0706xm toState(byte[] bArr) throws IOException {
        return (C0706xm) MessageNano.mergeFrom(new C0706xm(), bArr);
    }
}
