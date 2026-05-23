package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Zm extends BaseProtobufStateSerializer {
    @Override // io.appmetrica.analytics.coreutils.internal.data.BaseProtobufStateSerializer, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final Ym defaultValue() {
        Ym ym = new Ym();
        ym.i = new Tm();
        return ym;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* renamed from: a */
    public final Ym toState(byte[] bArr) throws IOException {
        return (Ym) MessageNano.mergeFrom(new Ym(), bArr);
    }
}
