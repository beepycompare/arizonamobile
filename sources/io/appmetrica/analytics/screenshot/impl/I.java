package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes5.dex */
public final class I implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final y fromModel(U u) {
        y yVar = new y();
        yVar.f1465a = u.f1446a;
        yVar.b = u.b;
        return yVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        y yVar = (y) obj;
        return new U(yVar.f1465a, yVar.b);
    }

    public final U a(y yVar) {
        return new U(yVar.f1465a, yVar.b);
    }
}
