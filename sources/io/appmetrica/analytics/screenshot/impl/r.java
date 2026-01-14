package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* loaded from: classes5.dex */
public final class r implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O fromModel(C0777p c0777p) {
        O o = new O();
        o.f1453a = c0777p.f1483a;
        Object[] array = c0777p.b.toArray(new String[0]);
        if (array != null) {
            o.c = (String[]) array;
            o.b = c0777p.c;
            return o;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0777p toModel(O o) {
        return new C0777p(o.f1453a, ArraysKt.toList(o.c), o.b);
    }
}
