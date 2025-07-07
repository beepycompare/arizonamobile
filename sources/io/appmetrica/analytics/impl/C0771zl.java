package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.zl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0771zl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0581s6 fromModel(Al al) {
        C0581s6 c0581s6 = new C0581s6();
        c0581s6.f1038a = (String) WrapUtils.getOrDefault(al.f340a, c0581s6.f1038a);
        c0581s6.b = (String) WrapUtils.getOrDefault(al.b, c0581s6.b);
        c0581s6.c = ((Integer) WrapUtils.getOrDefault(al.c, Integer.valueOf(c0581s6.c))).intValue();
        c0581s6.f = ((Integer) WrapUtils.getOrDefault(al.d, Integer.valueOf(c0581s6.f))).intValue();
        c0581s6.d = (String) WrapUtils.getOrDefault(al.e, c0581s6.d);
        c0581s6.e = ((Boolean) WrapUtils.getOrDefault(al.f, Boolean.valueOf(c0581s6.e))).booleanValue();
        return c0581s6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0581s6 c0581s6 = (C0581s6) obj;
        throw new UnsupportedOperationException();
    }

    public final Al a(C0581s6 c0581s6) {
        throw new UnsupportedOperationException();
    }
}
