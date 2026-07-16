package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.o  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0793o implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final x fromModel(O o) {
        x xVar = new x();
        xVar.f1464a = o.f1442a;
        xVar.c = (String[]) o.b.toArray(new String[0]);
        xVar.b = o.c;
        return xVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O toModel(x xVar) {
        return new O(xVar.f1464a, ArraysKt.toList(xVar.c), xVar.b);
    }
}
