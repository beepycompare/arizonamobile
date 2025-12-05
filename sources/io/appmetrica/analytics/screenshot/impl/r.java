package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* loaded from: classes5.dex */
public final class r implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O fromModel(C0773p c0773p) {
        O o = new O();
        o.f1429a = c0773p.f1459a;
        Object[] array = c0773p.b.toArray(new String[0]);
        if (array != null) {
            o.c = (String[]) array;
            o.b = c0773p.c;
            return o;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0773p toModel(O o) {
        return new C0773p(o.f1429a, ArraysKt.toList(o.c), o.b);
    }
}
