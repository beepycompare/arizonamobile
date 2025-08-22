package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Hd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Dk f476a = Ka.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0739ym[] fromModel(Map<String, ? extends Object> map) {
        C0739ym c0739ym;
        Map<String, C0655vd> c = this.f476a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0655vd c0655vd = c.get(key);
            if (c0655vd == null || value == null) {
                c0739ym = null;
            } else {
                c0739ym = new C0739ym();
                c0739ym.f1165a = key;
                c0739ym.b = (byte[]) c0655vd.c.fromModel(value);
            }
            if (c0739ym != null) {
                arrayList.add(c0739ym);
            }
        }
        Object[] array = arrayList.toArray(new C0739ym[0]);
        if (array != null) {
            return (C0739ym[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0739ym[] c0739ymArr) {
        Map<String, C0655vd> c = this.f476a.c();
        ArrayList arrayList = new ArrayList();
        for (C0739ym c0739ym : c0739ymArr) {
            C0655vd c0655vd = c.get(c0739ym.f1165a);
            Pair pair = c0655vd != null ? TuplesKt.to(c0739ym.f1165a, c0655vd.c.toModel(c0739ym.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
