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
/* renamed from: io.appmetrica.analytics.impl.e9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0221e9 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0273g9 c0273g9 = new C0273g9();
        C0247f9[] c0247f9Arr = new C0247f9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0247f9 c0247f9 = new C0247f9();
            c0247f9.f854a = (String) entry.getKey();
            c0247f9.b = (byte[]) entry.getValue();
            c0247f9Arr[i] = c0247f9;
            i = i2;
        }
        c0273g9.f870a = c0247f9Arr;
        return MessageNano.toByteArray(c0273g9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0247f9[] c0247f9Arr = ((C0273g9) MessageNano.mergeFrom(new C0273g9(), bArr)).f870a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0247f9Arr.length), 16));
        for (C0247f9 c0247f9 : c0247f9Arr) {
            Pair pair = TuplesKt.to(c0247f9.f854a, c0247f9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
