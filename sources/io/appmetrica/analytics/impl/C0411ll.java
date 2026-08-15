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
/* renamed from: io.appmetrica.analytics.impl.ll  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0411ll implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0463nl fromModel(Map<String, byte[]> map) {
        C0463nl c0463nl = new C0463nl();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            C0489ol c0489ol = new C0489ol();
            c0489ol.f1138a = entry.getKey().getBytes(Charsets.UTF_8);
            c0489ol.b = entry.getValue();
            arrayList.add(c0489ol);
        }
        c0463nl.f1122a = (C0489ol[]) arrayList.toArray(new C0489ol[0]);
        return c0463nl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(C0463nl c0463nl) {
        C0489ol[] c0489olArr = c0463nl.f1122a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0489olArr.length), 16));
        for (C0489ol c0489ol : c0489olArr) {
            Pair pair = TuplesKt.to(new String(c0489ol.f1138a, Charsets.UTF_8), c0489ol.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
