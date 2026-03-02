package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* loaded from: classes5.dex */
public final class r implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O fromModel(C0776p c0776p) {
        O o = new O();
        o.f1452a = c0776p.f1482a;
        Object[] array = c0776p.b.toArray(new String[0]);
        if (array != null) {
            o.c = (String[]) array;
            o.b = c0776p.c;
            return o;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0776p toModel(O o) {
        return new C0776p(o.f1452a, ArraysKt.toList(o.c), o.b);
    }
}
