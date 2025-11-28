package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
/* loaded from: classes5.dex */
public final class O8 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        Q8 q8 = new Q8();
        P8[] p8Arr = new P8[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            P8 p8 = new P8();
            p8.f633a = (String) entry.getKey();
            p8.b = (byte[]) entry.getValue();
            p8Arr[i] = p8;
            i = i2;
        }
        q8.f648a = p8Arr;
        return MessageNano.toByteArray(q8);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        P8[] p8Arr = ((Q8) MessageNano.mergeFrom(new Q8(), bArr)).f648a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(p8Arr.length), 16));
        for (P8 p8 : p8Arr) {
            Pair pair = TuplesKt.to(p8.f633a, p8.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
