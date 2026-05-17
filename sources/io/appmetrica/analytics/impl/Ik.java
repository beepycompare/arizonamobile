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
/* loaded from: classes5.dex */
public final class Ik implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Kk fromModel(Map<String, byte[]> map) {
        Kk kk = new Kk();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Lk lk = new Lk();
            lk.f686a = entry.getKey().getBytes(Charsets.UTF_8);
            lk.b = entry.getValue();
            arrayList.add(lk);
        }
        Object[] array = arrayList.toArray(new Lk[0]);
        if (array != null) {
            kk.f668a = (Lk[]) array;
            return kk;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(Kk kk) {
        Lk[] lkArr = kk.f668a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(lkArr.length), 16));
        for (Lk lk : lkArr) {
            Pair pair = TuplesKt.to(new String(lk.f686a, Charsets.UTF_8), lk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
