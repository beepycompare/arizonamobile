package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0225em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0494p6 fromModel(C0251fm c0251fm) {
        C0494p6 c0494p6 = new C0494p6();
        c0494p6.f1148a = (String) WrapUtils.getOrDefault(c0251fm.f990a, c0494p6.f1148a);
        c0494p6.b = (String) WrapUtils.getOrDefault(c0251fm.b, c0494p6.b);
        c0494p6.c = ((Integer) WrapUtils.getOrDefault(c0251fm.c, Integer.valueOf(c0494p6.c))).intValue();
        c0494p6.f = ((Integer) WrapUtils.getOrDefault(c0251fm.d, Integer.valueOf(c0494p6.f))).intValue();
        c0494p6.d = (String) WrapUtils.getOrDefault(c0251fm.e, c0494p6.d);
        c0494p6.e = ((Boolean) WrapUtils.getOrDefault(c0251fm.f, Boolean.valueOf(c0494p6.e))).booleanValue();
        return c0494p6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0494p6 c0494p6 = (C0494p6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0251fm a(C0494p6 c0494p6) {
        throw new UnsupportedOperationException();
    }
}
