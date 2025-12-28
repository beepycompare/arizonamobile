package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0523qd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0729yk f1185a = C0470oa.k().p();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0606tm[] fromModel(Map<String, ? extends Object> map) {
        C0606tm c0606tm;
        Map<String, Zc> c = this.f1185a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Zc zc = c.get(key);
            if (zc == null || value == null) {
                c0606tm = null;
            } else {
                c0606tm = new C0606tm();
                c0606tm.f1235a = key;
                c0606tm.b = (byte[]) zc.c.fromModel(value);
            }
            if (c0606tm != null) {
                arrayList.add(c0606tm);
            }
        }
        Object[] array = arrayList.toArray(new C0606tm[0]);
        if (array != null) {
            return (C0606tm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0606tm[] c0606tmArr) {
        Map<String, Zc> c = this.f1185a.c();
        ArrayList arrayList = new ArrayList();
        for (C0606tm c0606tm : c0606tmArr) {
            Zc zc = c.get(c0606tm.f1235a);
            Pair pair = zc != null ? TuplesKt.to(c0606tm.f1235a, zc.c.toModel(c0606tm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
