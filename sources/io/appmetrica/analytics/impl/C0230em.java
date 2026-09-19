package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0230em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0499p6 fromModel(C0256fm c0256fm) {
        C0499p6 c0499p6 = new C0499p6();
        c0499p6.f1145a = (String) WrapUtils.getOrDefault(c0256fm.f987a, c0499p6.f1145a);
        c0499p6.b = (String) WrapUtils.getOrDefault(c0256fm.b, c0499p6.b);
        c0499p6.c = ((Integer) WrapUtils.getOrDefault(c0256fm.c, Integer.valueOf(c0499p6.c))).intValue();
        c0499p6.f = ((Integer) WrapUtils.getOrDefault(c0256fm.d, Integer.valueOf(c0499p6.f))).intValue();
        c0499p6.d = (String) WrapUtils.getOrDefault(c0256fm.e, c0499p6.d);
        c0499p6.e = ((Boolean) WrapUtils.getOrDefault(c0256fm.f, Boolean.valueOf(c0499p6.e))).booleanValue();
        return c0499p6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0499p6 c0499p6 = (C0499p6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0256fm a(C0499p6 c0499p6) {
        throw new UnsupportedOperationException();
    }
}
