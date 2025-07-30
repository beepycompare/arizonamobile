package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Fd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0739yk f437a = Ia.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0616tm[] fromModel(Map<String, ? extends Object> map) {
        C0616tm c0616tm;
        Map<String, C0607td> c = this.f437a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0607td c0607td = c.get(key);
            if (c0607td == null || value == null) {
                c0616tm = null;
            } else {
                c0616tm = new C0616tm();
                c0616tm.f1072a = key;
                c0616tm.b = (byte[]) c0607td.c.fromModel(value);
            }
            if (c0616tm != null) {
                arrayList.add(c0616tm);
            }
        }
        Object[] array = arrayList.toArray(new C0616tm[0]);
        if (array != null) {
            return (C0616tm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0616tm[] c0616tmArr) {
        Map<String, C0607td> c = this.f437a.c();
        ArrayList arrayList = new ArrayList();
        for (C0616tm c0616tm : c0616tmArr) {
            C0607td c0607td = c.get(c0616tm.f1072a);
            Pair pair = c0607td != null ? TuplesKt.to(c0616tm.f1072a, c0607td.c.toModel(c0616tm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
