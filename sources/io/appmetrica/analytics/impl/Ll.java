package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Ll implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0728y6 fromModel(Ml ml) {
        C0728y6 c0728y6 = new C0728y6();
        c0728y6.f1167a = (String) WrapUtils.getOrDefault(ml.f582a, c0728y6.f1167a);
        c0728y6.b = (String) WrapUtils.getOrDefault(ml.b, c0728y6.b);
        c0728y6.c = ((Integer) WrapUtils.getOrDefault(ml.c, Integer.valueOf(c0728y6.c))).intValue();
        c0728y6.f = ((Integer) WrapUtils.getOrDefault(ml.d, Integer.valueOf(c0728y6.f))).intValue();
        c0728y6.d = (String) WrapUtils.getOrDefault(ml.e, c0728y6.d);
        c0728y6.e = ((Boolean) WrapUtils.getOrDefault(ml.f, Boolean.valueOf(c0728y6.e))).booleanValue();
        return c0728y6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0728y6 c0728y6 = (C0728y6) obj;
        throw new UnsupportedOperationException();
    }

    public final Ml a(C0728y6 c0728y6) {
        throw new UnsupportedOperationException();
    }
}
