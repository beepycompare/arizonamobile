package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.pd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0502pd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0708xk f1174a = C0449na.k().p();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0585sm[] fromModel(Map<String, ? extends Object> map) {
        C0585sm c0585sm;
        Map<String, Yc> c = this.f1174a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Yc yc = c.get(key);
            if (yc == null || value == null) {
                c0585sm = null;
            } else {
                c0585sm = new C0585sm();
                c0585sm.f1225a = key;
                c0585sm.b = (byte[]) yc.c.fromModel(value);
            }
            if (c0585sm != null) {
                arrayList.add(c0585sm);
            }
        }
        Object[] array = arrayList.toArray(new C0585sm[0]);
        if (array != null) {
            return (C0585sm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0585sm[] c0585smArr) {
        Map<String, Yc> c = this.f1174a.c();
        ArrayList arrayList = new ArrayList();
        for (C0585sm c0585sm : c0585smArr) {
            Yc yc = c.get(c0585sm.f1225a);
            Pair pair = yc != null ? TuplesKt.to(c0585sm.f1225a, yc.c.toModel(c0585sm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
