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
public final class Sk implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Uk fromModel(Map<String, byte[]> map) {
        Uk uk = new Uk();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Vk vk = new Vk();
            vk.f716a = entry.getKey().getBytes(Charsets.UTF_8);
            vk.b = entry.getValue();
            arrayList.add(vk);
        }
        Object[] array = arrayList.toArray(new Vk[0]);
        if (array != null) {
            uk.f703a = (Vk[]) array;
            return uk;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(Uk uk) {
        Vk[] vkArr = uk.f703a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(vkArr.length), 16));
        for (Vk vk : vkArr) {
            Pair pair = TuplesKt.to(new String(vk.f716a, Charsets.UTF_8), vk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
