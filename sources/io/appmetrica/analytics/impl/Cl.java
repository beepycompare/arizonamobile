package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Cl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Z5 fromModel(Dl dl) {
        Z5 z5 = new Z5();
        z5.f879a = (String) WrapUtils.getOrDefault(dl.f555a, z5.f879a);
        z5.b = (String) WrapUtils.getOrDefault(dl.b, z5.b);
        z5.c = ((Integer) WrapUtils.getOrDefault(dl.c, Integer.valueOf(z5.c))).intValue();
        z5.f = ((Integer) WrapUtils.getOrDefault(dl.d, Integer.valueOf(z5.f))).intValue();
        z5.d = (String) WrapUtils.getOrDefault(dl.e, z5.d);
        z5.e = ((Boolean) WrapUtils.getOrDefault(dl.f, Boolean.valueOf(z5.e))).booleanValue();
        return z5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Z5 z5 = (Z5) obj;
        throw new UnsupportedOperationException();
    }

    public final Dl a(Z5 z5) {
        throw new UnsupportedOperationException();
    }
}
