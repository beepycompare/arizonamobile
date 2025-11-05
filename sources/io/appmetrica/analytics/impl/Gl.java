package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes3.dex */
public final class Gl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0263g6 fromModel(Hl hl) {
        C0263g6 c0263g6 = new C0263g6();
        c0263g6.f888a = (String) WrapUtils.getOrDefault(hl.f512a, c0263g6.f888a);
        c0263g6.b = (String) WrapUtils.getOrDefault(hl.b, c0263g6.b);
        c0263g6.c = ((Integer) WrapUtils.getOrDefault(hl.c, Integer.valueOf(c0263g6.c))).intValue();
        c0263g6.f = ((Integer) WrapUtils.getOrDefault(hl.d, Integer.valueOf(c0263g6.f))).intValue();
        c0263g6.d = (String) WrapUtils.getOrDefault(hl.e, c0263g6.d);
        c0263g6.e = ((Boolean) WrapUtils.getOrDefault(hl.f, Boolean.valueOf(c0263g6.e))).booleanValue();
        return c0263g6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0263g6 c0263g6 = (C0263g6) obj;
        throw new UnsupportedOperationException();
    }

    public final Hl a(C0263g6 c0263g6) {
        throw new UnsupportedOperationException();
    }
}
