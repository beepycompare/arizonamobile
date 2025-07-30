package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Cl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0650v6 fromModel(Dl dl) {
        C0650v6 c0650v6 = new C0650v6();
        c0650v6.f1097a = (String) WrapUtils.getOrDefault(dl.f402a, c0650v6.f1097a);
        c0650v6.b = (String) WrapUtils.getOrDefault(dl.b, c0650v6.b);
        c0650v6.c = ((Integer) WrapUtils.getOrDefault(dl.c, Integer.valueOf(c0650v6.c))).intValue();
        c0650v6.f = ((Integer) WrapUtils.getOrDefault(dl.d, Integer.valueOf(c0650v6.f))).intValue();
        c0650v6.d = (String) WrapUtils.getOrDefault(dl.e, c0650v6.d);
        c0650v6.e = ((Boolean) WrapUtils.getOrDefault(dl.f, Boolean.valueOf(c0650v6.e))).booleanValue();
        return c0650v6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0650v6 c0650v6 = (C0650v6) obj;
        throw new UnsupportedOperationException();
    }

    public final Dl a(C0650v6 c0650v6) {
        throw new UnsupportedOperationException();
    }
}
