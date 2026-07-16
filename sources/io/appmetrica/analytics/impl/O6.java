package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
/* loaded from: classes5.dex */
public final class O6 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Rm[] fromModel(Map<String, ? extends List<String>> map) {
        Rm[] rmArr = new Rm[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            Rm rm = new Rm();
            rm.f754a = (String) entry.getKey();
            rm.b = (String[]) ((Collection) entry.getValue()).toArray(new String[0]);
            rmArr[i] = rm;
            i = i2;
        }
        return rmArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, List<String>> toModel(Rm[] rmArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(rmArr.length), 16));
        for (Rm rm : rmArr) {
            Pair pair = TuplesKt.to(rm.f754a, ArraysKt.toList(rm.b));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
