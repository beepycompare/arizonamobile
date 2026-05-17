package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.pd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0501pd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0707xk f1179a = C0448na.k().p();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0584sm[] fromModel(Map<String, ? extends Object> map) {
        C0584sm c0584sm;
        Map<String, Yc> c = this.f1179a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Yc yc = c.get(key);
            if (yc == null || value == null) {
                c0584sm = null;
            } else {
                c0584sm = new C0584sm();
                c0584sm.f1230a = key;
                c0584sm.b = (byte[]) yc.c.fromModel(value);
            }
            if (c0584sm != null) {
                arrayList.add(c0584sm);
            }
        }
        Object[] array = arrayList.toArray(new C0584sm[0]);
        if (array != null) {
            return (C0584sm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0584sm[] c0584smArr) {
        Map<String, Yc> c = this.f1179a.c();
        ArrayList arrayList = new ArrayList();
        for (C0584sm c0584sm : c0584smArr) {
            Yc yc = c.get(c0584sm.f1230a);
            Pair pair = yc != null ? TuplesKt.to(c0584sm.f1230a, yc.c.toModel(c0584sm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
