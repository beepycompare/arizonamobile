package io.appmetrica.analytics.adrevenue.other.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes5.dex */
public final class b implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final c fromModel(j jVar) {
        c cVar = new c();
        cVar.f235a = jVar.f240a;
        cVar.b = jVar.b;
        return cVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        c cVar = (c) obj;
        return new j(cVar.f235a, cVar.b);
    }

    public final j a(c cVar) {
        return new j(cVar.f235a, cVar.b);
    }
}
