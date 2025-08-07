package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Cl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0651v6 fromModel(Dl dl) {
        C0651v6 c0651v6 = new C0651v6();
        c0651v6.f1096a = (String) WrapUtils.getOrDefault(dl.f401a, c0651v6.f1096a);
        c0651v6.b = (String) WrapUtils.getOrDefault(dl.b, c0651v6.b);
        c0651v6.c = ((Integer) WrapUtils.getOrDefault(dl.c, Integer.valueOf(c0651v6.c))).intValue();
        c0651v6.f = ((Integer) WrapUtils.getOrDefault(dl.d, Integer.valueOf(c0651v6.f))).intValue();
        c0651v6.d = (String) WrapUtils.getOrDefault(dl.e, c0651v6.d);
        c0651v6.e = ((Boolean) WrapUtils.getOrDefault(dl.f, Boolean.valueOf(c0651v6.e))).booleanValue();
        return c0651v6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0651v6 c0651v6 = (C0651v6) obj;
        throw new UnsupportedOperationException();
    }

    public final Dl a(C0651v6 c0651v6) {
        throw new UnsupportedOperationException();
    }
}
