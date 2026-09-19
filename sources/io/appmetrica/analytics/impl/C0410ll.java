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
public final class C0410ll implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0462nl fromModel(Map<String, byte[]> map) {
        C0462nl c0462nl = new C0462nl();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            C0488ol c0488ol = new C0488ol();
            c0488ol.f1138a = entry.getKey().getBytes(Charsets.UTF_8);
            c0488ol.b = entry.getValue();
            arrayList.add(c0488ol);
        }
        c0462nl.f1122a = (C0488ol[]) arrayList.toArray(new C0488ol[0]);
        return c0462nl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(C0462nl c0462nl) {
        C0488ol[] c0488olArr = c0462nl.f1122a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0488olArr.length), 16));
        for (C0488ol c0488ol : c0488olArr) {
            Pair pair = TuplesKt.to(new String(c0488ol.f1138a, Charsets.UTF_8), c0488ol.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
