package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.ym  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0732ym extends BaseProtobufStateSerializer {
    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0707xm defaultValue() {
        C0707xm c0707xm = new C0707xm();
        c0707xm.i = new C0582sm();
        return c0707xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0707xm toState(byte[] bArr) throws IOException {
        return (C0707xm) MessageNano.mergeFrom(new C0707xm(), bArr);
    }
}
