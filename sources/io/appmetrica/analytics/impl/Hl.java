package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Hl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0648v6 fromModel(Il il) {
        C0648v6 c0648v6 = new C0648v6();
        c0648v6.f1099a = (String) WrapUtils.getOrDefault(il.f501a, c0648v6.f1099a);
        c0648v6.b = (String) WrapUtils.getOrDefault(il.b, c0648v6.b);
        c0648v6.c = ((Integer) WrapUtils.getOrDefault(il.c, Integer.valueOf(c0648v6.c))).intValue();
        c0648v6.f = ((Integer) WrapUtils.getOrDefault(il.d, Integer.valueOf(c0648v6.f))).intValue();
        c0648v6.d = (String) WrapUtils.getOrDefault(il.e, c0648v6.d);
        c0648v6.e = ((Boolean) WrapUtils.getOrDefault(il.f, Boolean.valueOf(c0648v6.e))).booleanValue();
        return c0648v6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0648v6 c0648v6 = (C0648v6) obj;
        throw new UnsupportedOperationException();
    }

    public final Il a(C0648v6 c0648v6) {
        throw new UnsupportedOperationException();
    }
}
