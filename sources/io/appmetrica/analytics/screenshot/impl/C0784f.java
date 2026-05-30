package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0784f implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final w fromModel(N n) {
        w wVar = new w();
        wVar.f1461a = n.f1439a;
        return wVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new N(((w) obj).f1461a);
    }

    public final N a(w wVar) {
        return new N(wVar.f1461a);
    }
}
