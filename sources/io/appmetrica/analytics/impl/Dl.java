package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Dl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0107a6 fromModel(El el) {
        C0107a6 c0107a6 = new C0107a6();
        c0107a6.f875a = (String) WrapUtils.getOrDefault(el.f549a, c0107a6.f875a);
        c0107a6.b = (String) WrapUtils.getOrDefault(el.b, c0107a6.b);
        c0107a6.c = ((Integer) WrapUtils.getOrDefault(el.c, Integer.valueOf(c0107a6.c))).intValue();
        c0107a6.f = ((Integer) WrapUtils.getOrDefault(el.d, Integer.valueOf(c0107a6.f))).intValue();
        c0107a6.d = (String) WrapUtils.getOrDefault(el.e, c0107a6.d);
        c0107a6.e = ((Boolean) WrapUtils.getOrDefault(el.f, Boolean.valueOf(c0107a6.e))).booleanValue();
        return c0107a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0107a6 c0107a6 = (C0107a6) obj;
        throw new UnsupportedOperationException();
    }

    public final El a(C0107a6 c0107a6) {
        throw new UnsupportedOperationException();
    }
}
