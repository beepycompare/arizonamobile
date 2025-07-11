package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.zl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0763zl implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0573s6 fromModel(Al al) {
        C0573s6 c0573s6 = new C0573s6();
        c0573s6.f1039a = (String) WrapUtils.getOrDefault(al.f341a, c0573s6.f1039a);
        c0573s6.b = (String) WrapUtils.getOrDefault(al.b, c0573s6.b);
        c0573s6.c = ((Integer) WrapUtils.getOrDefault(al.c, Integer.valueOf(c0573s6.c))).intValue();
        c0573s6.f = ((Integer) WrapUtils.getOrDefault(al.d, Integer.valueOf(c0573s6.f))).intValue();
        c0573s6.d = (String) WrapUtils.getOrDefault(al.e, c0573s6.d);
        c0573s6.e = ((Boolean) WrapUtils.getOrDefault(al.f, Boolean.valueOf(c0573s6.e))).booleanValue();
        return c0573s6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0573s6 c0573s6 = (C0573s6) obj;
        throw new UnsupportedOperationException();
    }

    public final Al a(C0573s6 c0573s6) {
        throw new UnsupportedOperationException();
    }
}
