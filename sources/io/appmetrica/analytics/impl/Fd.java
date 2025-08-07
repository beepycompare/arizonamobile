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
    public final C0740yk f436a = Ia.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0617tm[] fromModel(Map<String, ? extends Object> map) {
        C0617tm c0617tm;
        Map<String, C0608td> c = this.f436a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0608td c0608td = c.get(key);
            if (c0608td == null || value == null) {
                c0617tm = null;
            } else {
                c0617tm = new C0617tm();
                c0617tm.f1071a = key;
                c0617tm.b = (byte[]) c0608td.c.fromModel(value);
            }
            if (c0617tm != null) {
                arrayList.add(c0617tm);
            }
        }
        Object[] array = arrayList.toArray(new C0617tm[0]);
        if (array != null) {
            return (C0617tm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0617tm[] c0617tmArr) {
        Map<String, C0608td> c = this.f436a.c();
        ArrayList arrayList = new ArrayList();
        for (C0617tm c0617tm : c0617tmArr) {
            C0608td c0608td = c.get(c0617tm.f1071a);
            Pair pair = c0608td != null ? TuplesKt.to(c0617tm.f1071a, c0608td.c.toModel(c0617tm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
