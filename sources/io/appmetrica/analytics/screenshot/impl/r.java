package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* loaded from: classes5.dex */
public final class r implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O fromModel(C0774p c0774p) {
        O o = new O();
        o.f1346a = c0774p.f1376a;
        Object[] array = c0774p.b.toArray(new String[0]);
        if (array != null) {
            o.c = (String[]) array;
            o.b = c0774p.c;
            return o;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0774p toModel(O o) {
        return new C0774p(o.f1346a, ArraysKt.toList(o.c), o.b);
    }
}
