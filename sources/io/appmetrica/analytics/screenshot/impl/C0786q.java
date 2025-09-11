package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.collections.ArraysKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.q  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0786q implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final L fromModel(C0784o c0784o) {
        L l = new L();
        l.f1300a = c0784o.f1330a;
        Object[] array = c0784o.b.toArray(new String[0]);
        if (array != null) {
            l.c = (String[]) array;
            l.b = c0784o.c;
            return l;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0784o toModel(L l) {
        return new C0784o(l.f1300a, ArraysKt.toList(l.c), l.b);
    }
}
