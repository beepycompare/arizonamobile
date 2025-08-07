package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.q  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0785q implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final L fromModel(C0783o c0783o) {
        L l = new L();
        l.f1281a = c0783o.f1311a;
        Object[] array = c0783o.b.toArray(new String[0]);
        if (array != null) {
            l.c = (String[]) array;
            l.b = c0783o.c;
            return l;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0783o toModel(L l) {
        return new C0783o(l.f1281a, ArraysKt.toList(l.c), l.b);
    }
}
