package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class Jk implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Lk fromModel(Map<String, byte[]> map) {
        Lk lk = new Lk();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Mk mk = new Mk();
            mk.f552a = entry.getKey().getBytes(Charsets.UTF_8);
            mk.b = entry.getValue();
            arrayList.add(mk);
        }
        Object[] array = arrayList.toArray(new Mk[0]);
        if (array != null) {
            lk.f537a = (Mk[]) array;
            return lk;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(Lk lk) {
        Mk[] mkArr = lk.f537a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(mkArr.length), 16));
        for (Mk mk : mkArr) {
            Pair pair = TuplesKt.to(new String(mk.f552a, Charsets.UTF_8), mk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
