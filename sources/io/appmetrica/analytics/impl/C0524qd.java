package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0524qd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0730yk f1087a = C0471oa.k().p();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0607tm[] fromModel(Map<String, ? extends Object> map) {
        C0607tm c0607tm;
        Map<String, Zc> c = this.f1087a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Zc zc = c.get(key);
            if (zc == null || value == null) {
                c0607tm = null;
            } else {
                c0607tm = new C0607tm();
                c0607tm.f1137a = key;
                c0607tm.b = (byte[]) zc.c.fromModel(value);
            }
            if (c0607tm != null) {
                arrayList.add(c0607tm);
            }
        }
        Object[] array = arrayList.toArray(new C0607tm[0]);
        if (array != null) {
            return (C0607tm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0607tm[] c0607tmArr) {
        Map<String, Zc> c = this.f1087a.c();
        ArrayList arrayList = new ArrayList();
        for (C0607tm c0607tm : c0607tmArr) {
            Zc zc = c.get(c0607tm.f1137a);
            Pair pair = zc != null ? TuplesKt.to(c0607tm.f1137a, zc.c.toModel(c0607tm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
