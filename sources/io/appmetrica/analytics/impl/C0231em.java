package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0231em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0500p6 fromModel(C0257fm c0257fm) {
        C0500p6 c0500p6 = new C0500p6();
        c0500p6.f1145a = (String) WrapUtils.getOrDefault(c0257fm.f987a, c0500p6.f1145a);
        c0500p6.b = (String) WrapUtils.getOrDefault(c0257fm.b, c0500p6.b);
        c0500p6.c = ((Integer) WrapUtils.getOrDefault(c0257fm.c, Integer.valueOf(c0500p6.c))).intValue();
        c0500p6.f = ((Integer) WrapUtils.getOrDefault(c0257fm.d, Integer.valueOf(c0500p6.f))).intValue();
        c0500p6.d = (String) WrapUtils.getOrDefault(c0257fm.e, c0500p6.d);
        c0500p6.e = ((Boolean) WrapUtils.getOrDefault(c0257fm.f, Boolean.valueOf(c0500p6.e))).booleanValue();
        return c0500p6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0500p6 c0500p6 = (C0500p6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0257fm a(C0500p6 c0500p6) {
        throw new UnsupportedOperationException();
    }
}
