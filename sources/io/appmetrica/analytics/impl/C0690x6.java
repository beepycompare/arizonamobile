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
/* renamed from: io.appmetrica.analytics.impl.x6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0690x6 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0532qm[] fromModel(Map<String, ? extends List<String>> map) {
        C0532qm[] c0532qmArr = new C0532qm[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0532qm c0532qm = new C0532qm();
            c0532qm.f1190a = (String) entry.getKey();
            Object[] array = ((Collection) entry.getValue()).toArray(new String[0]);
            if (array != null) {
                c0532qm.b = (String[]) array;
                c0532qmArr[i] = c0532qm;
                i = i2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        return c0532qmArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, List<String>> toModel(C0532qm[] c0532qmArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0532qmArr.length), 16));
        for (C0532qm c0532qm : c0532qmArr) {
            Pair pair = TuplesKt.to(c0532qm.f1190a, ArraysKt.toList(c0532qm.b));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
