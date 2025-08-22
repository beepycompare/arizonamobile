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
public final class Ok implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qk fromModel(Map<String, byte[]> map) {
        Qk qk = new Qk();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Rk rk = new Rk();
            rk.f639a = entry.getKey().getBytes(Charsets.UTF_8);
            rk.b = entry.getValue();
            arrayList.add(rk);
        }
        Object[] array = arrayList.toArray(new Rk[0]);
        if (array != null) {
            qk.f624a = (Rk[]) array;
            return qk;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(Qk qk) {
        Rk[] rkArr = qk.f624a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(rkArr.length), 16));
        for (Rk rk : rkArr) {
            Pair pair = TuplesKt.to(new String(rk.f639a, Charsets.UTF_8), rk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
