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
public final class Gk implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ik fromModel(Map<String, byte[]> map) {
        Ik ik = new Ik();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Jk jk = new Jk();
            jk.f494a = entry.getKey().getBytes(Charsets.UTF_8);
            jk.b = entry.getValue();
            arrayList.add(jk);
        }
        Object[] array = arrayList.toArray(new Jk[0]);
        if (array != null) {
            ik.f480a = (Jk[]) array;
            return ik;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(Ik ik) {
        Jk[] jkArr = ik.f480a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(jkArr.length), 16));
        for (Jk jk : jkArr) {
            Pair pair = TuplesKt.to(new String(jk.f494a, Charsets.UTF_8), jk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
