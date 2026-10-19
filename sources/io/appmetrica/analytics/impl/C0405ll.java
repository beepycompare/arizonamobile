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
public final class C0405ll implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0457nl fromModel(Map<String, byte[]> map) {
        C0457nl c0457nl = new C0457nl();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            C0483ol c0483ol = new C0483ol();
            c0483ol.f1141a = entry.getKey().getBytes(Charsets.UTF_8);
            c0483ol.b = entry.getValue();
            arrayList.add(c0483ol);
        }
        c0457nl.f1125a = (C0483ol[]) arrayList.toArray(new C0483ol[0]);
        return c0457nl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(C0457nl c0457nl) {
        C0483ol[] c0483olArr = c0457nl.f1125a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0483olArr.length), 16));
        for (C0483ol c0483ol : c0483olArr) {
            Pair pair = TuplesKt.to(new String(c0483ol.f1141a, Charsets.UTF_8), c0483ol.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
