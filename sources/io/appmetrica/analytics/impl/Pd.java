package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes5.dex */
public final class Pd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Zk f716a = Na.k().p();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Um[] fromModel(Map<String, ? extends Object> map) {
        Um um;
        Map<String, C0741yd> b = this.f716a.b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0741yd c0741yd = b.get(key);
            if (c0741yd == null || value == null) {
                um = null;
            } else {
                um = new Um();
                um.f798a = key;
                um.b = (byte[]) c0741yd.c.fromModel(value);
            }
            if (um != null) {
                arrayList.add(um);
            }
        }
        return (Um[]) arrayList.toArray(new Um[0]);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(Um[] umArr) {
        Map<String, C0741yd> b = this.f716a.b();
        ArrayList arrayList = new ArrayList();
        for (Um um : umArr) {
            C0741yd c0741yd = b.get(um.f798a);
            Pair pair = c0741yd != null ? TuplesKt.to(um.f798a, c0741yd.c.toModel(um.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
