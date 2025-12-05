package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.q9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0519q9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0469o9 fromModel(C0494p9 c0494p9) {
        C0469o9 c0469o9 = new C0469o9();
        String str = c0494p9.f1146a;
        if (str != null) {
            c0469o9.f1128a = str.getBytes();
        }
        return c0469o9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0494p9 toModel(C0469o9 c0469o9) {
        return new C0494p9(new String(c0469o9.f1128a));
    }
}
