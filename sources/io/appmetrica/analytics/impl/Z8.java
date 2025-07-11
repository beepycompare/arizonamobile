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
/* loaded from: classes4.dex */
public final class Z8 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0151b9 c0151b9 = new C0151b9();
        C0125a9[] c0125a9Arr = new C0125a9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0125a9 c0125a9 = new C0125a9();
            c0125a9.f753a = (String) entry.getKey();
            c0125a9.b = (byte[]) entry.getValue();
            c0125a9Arr[i] = c0125a9;
            i = i2;
        }
        c0151b9.f768a = c0125a9Arr;
        return MessageNano.toByteArray(c0151b9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0125a9[] c0125a9Arr = ((C0151b9) MessageNano.mergeFrom(new C0151b9(), bArr)).f768a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0125a9Arr.length), 16));
        for (C0125a9 c0125a9 : c0125a9Arr) {
            Pair pair = TuplesKt.to(c0125a9.f753a, c0125a9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
