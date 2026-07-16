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
public final class C0412ll implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0464nl fromModel(Map<String, byte[]> map) {
        C0464nl c0464nl = new C0464nl();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            C0490ol c0490ol = new C0490ol();
            c0490ol.f1138a = entry.getKey().getBytes(Charsets.UTF_8);
            c0490ol.b = entry.getValue();
            arrayList.add(c0490ol);
        }
        c0464nl.f1122a = (C0490ol[]) arrayList.toArray(new C0490ol[0]);
        return c0464nl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(C0464nl c0464nl) {
        C0490ol[] c0490olArr = c0464nl.f1122a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0490olArr.length), 16));
        for (C0490ol c0490ol : c0490olArr) {
            Pair pair = TuplesKt.to(new String(c0490ol.f1138a, Charsets.UTF_8), c0490ol.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
