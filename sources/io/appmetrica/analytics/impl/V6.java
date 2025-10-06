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
/* loaded from: classes4.dex */
public final class V6 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0769zm[] fromModel(Map<String, ? extends List<String>> map) {
        C0769zm[] c0769zmArr = new C0769zm[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0769zm c0769zm = new C0769zm();
            c0769zm.f1196a = (String) entry.getKey();
            Object[] array = ((Collection) entry.getValue()).toArray(new String[0]);
            if (array != null) {
                c0769zm.b = (String[]) array;
                c0769zmArr[i] = c0769zm;
                i = i2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        return c0769zmArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, List<String>> toModel(C0769zm[] c0769zmArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0769zmArr.length), 16));
        for (C0769zm c0769zm : c0769zmArr) {
            Pair pair = TuplesKt.to(c0769zm.f1196a, ArraysKt.toList(c0769zm.b));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
