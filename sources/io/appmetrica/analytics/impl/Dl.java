package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Dl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0108a6 fromModel(El el) {
        C0108a6 c0108a6 = new C0108a6();
        c0108a6.f792a = (String) WrapUtils.getOrDefault(el.f466a, c0108a6.f792a);
        c0108a6.b = (String) WrapUtils.getOrDefault(el.b, c0108a6.b);
        c0108a6.c = ((Integer) WrapUtils.getOrDefault(el.c, Integer.valueOf(c0108a6.c))).intValue();
        c0108a6.f = ((Integer) WrapUtils.getOrDefault(el.d, Integer.valueOf(c0108a6.f))).intValue();
        c0108a6.d = (String) WrapUtils.getOrDefault(el.e, c0108a6.d);
        c0108a6.e = ((Boolean) WrapUtils.getOrDefault(el.f, Boolean.valueOf(c0108a6.e))).booleanValue();
        return c0108a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0108a6 c0108a6 = (C0108a6) obj;
        throw new UnsupportedOperationException();
    }

    public final El a(C0108a6 c0108a6) {
        throw new UnsupportedOperationException();
    }
}
