package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Ll implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0727y6 fromModel(Ml ml) {
        C0727y6 c0727y6 = new C0727y6();
        c0727y6.f1162a = (String) WrapUtils.getOrDefault(ml.f577a, c0727y6.f1162a);
        c0727y6.b = (String) WrapUtils.getOrDefault(ml.b, c0727y6.b);
        c0727y6.c = ((Integer) WrapUtils.getOrDefault(ml.c, Integer.valueOf(c0727y6.c))).intValue();
        c0727y6.f = ((Integer) WrapUtils.getOrDefault(ml.d, Integer.valueOf(c0727y6.f))).intValue();
        c0727y6.d = (String) WrapUtils.getOrDefault(ml.e, c0727y6.d);
        c0727y6.e = ((Boolean) WrapUtils.getOrDefault(ml.f, Boolean.valueOf(c0727y6.e))).booleanValue();
        return c0727y6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0727y6 c0727y6 = (C0727y6) obj;
        throw new UnsupportedOperationException();
    }

    public final Ml a(C0727y6 c0727y6) {
        throw new UnsupportedOperationException();
    }
}
