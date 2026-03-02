package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.xm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0709xm extends BaseProtobufStateSerializer {
    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0684wm defaultValue() {
        C0684wm c0684wm = new C0684wm();
        c0684wm.i = new C0559rm();
        return c0684wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final C0684wm toState(byte[] bArr) throws IOException {
        return (C0684wm) MessageNano.mergeFrom(new C0684wm(), bArr);
    }
}
