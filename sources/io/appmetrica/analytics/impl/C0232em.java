package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0232em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0501p6 fromModel(C0258fm c0258fm) {
        C0501p6 c0501p6 = new C0501p6();
        c0501p6.f1142a = (String) WrapUtils.getOrDefault(c0258fm.f984a, c0501p6.f1142a);
        c0501p6.b = (String) WrapUtils.getOrDefault(c0258fm.b, c0501p6.b);
        c0501p6.c = ((Integer) WrapUtils.getOrDefault(c0258fm.c, Integer.valueOf(c0501p6.c))).intValue();
        c0501p6.f = ((Integer) WrapUtils.getOrDefault(c0258fm.d, Integer.valueOf(c0501p6.f))).intValue();
        c0501p6.d = (String) WrapUtils.getOrDefault(c0258fm.e, c0501p6.d);
        c0501p6.e = ((Boolean) WrapUtils.getOrDefault(c0258fm.f, Boolean.valueOf(c0501p6.e))).booleanValue();
        return c0501p6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0501p6 c0501p6 = (C0501p6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0258fm a(C0501p6 c0501p6) {
        throw new UnsupportedOperationException();
    }
}
