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
public final class K8 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        M8 m8 = new M8();
        L8[] l8Arr = new L8[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            L8 l8 = new L8();
            l8.f664a = (String) entry.getKey();
            l8.b = (byte[]) entry.getValue();
            l8Arr[i] = l8;
            i = i2;
        }
        m8.f683a = l8Arr;
        return MessageNano.toByteArray(m8);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        L8[] l8Arr = ((M8) MessageNano.mergeFrom(new M8(), bArr)).f683a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(l8Arr.length), 16));
        for (L8 l8 : l8Arr) {
            Pair pair = TuplesKt.to(l8.f664a, l8.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
