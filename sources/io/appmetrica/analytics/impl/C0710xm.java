package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.xm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0710xm extends BaseProtobufStateSerializer {
    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0685wm defaultValue() {
        C0685wm c0685wm = new C0685wm();
        c0685wm.i = new C0560rm();
        return c0685wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0685wm toState(byte[] bArr) throws IOException {
        return (C0685wm) MessageNano.mergeFrom(new C0685wm(), bArr);
    }
}
