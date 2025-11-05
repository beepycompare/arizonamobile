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
/* loaded from: classes3.dex */
public final class Nk implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Pk fromModel(Map<String, byte[]> map) {
        Pk pk = new Pk();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Qk qk = new Qk();
            qk.f654a = entry.getKey().getBytes(Charsets.UTF_8);
            qk.b = entry.getValue();
            arrayList.add(qk);
        }
        Object[] array = arrayList.toArray(new Qk[0]);
        if (array != null) {
            pk.f641a = (Qk[]) array;
            return pk;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(Pk pk) {
        Qk[] qkArr = pk.f641a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(qkArr.length), 16));
        for (Qk qk : qkArr) {
            Pair pair = TuplesKt.to(new String(qk.f654a, Charsets.UTF_8), qk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
