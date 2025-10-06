package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Ld implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Hk f559a = Na.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cm[] fromModel(Map<String, ? extends Object> map) {
        Cm cm;
        Map<String, C0735yd> c = this.f559a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0735yd c0735yd = c.get(key);
            if (c0735yd == null || value == null) {
                cm = null;
            } else {
                cm = new Cm();
                cm.f396a = key;
                cm.b = (byte[]) c0735yd.c.fromModel(value);
            }
            if (cm != null) {
                arrayList.add(cm);
            }
        }
        Object[] array = arrayList.toArray(new Cm[0]);
        if (array != null) {
            return (Cm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(Cm[] cmArr) {
        Map<String, C0735yd> c = this.f559a.c();
        ArrayList arrayList = new ArrayList();
        for (Cm cm : cmArr) {
            C0735yd c0735yd = c.get(cm.f396a);
            Pair pair = c0735yd != null ? TuplesKt.to(cm.f396a, c0735yd.c.toModel(cm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
