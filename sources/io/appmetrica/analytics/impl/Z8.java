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
        C0159b9 c0159b9 = new C0159b9();
        C0133a9[] c0133a9Arr = new C0133a9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0133a9 c0133a9 = new C0133a9();
            c0133a9.f752a = (String) entry.getKey();
            c0133a9.b = (byte[]) entry.getValue();
            c0133a9Arr[i] = c0133a9;
            i = i2;
        }
        c0159b9.f767a = c0133a9Arr;
        return MessageNano.toByteArray(c0159b9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0133a9[] c0133a9Arr = ((C0159b9) MessageNano.mergeFrom(new C0159b9(), bArr)).f767a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0133a9Arr.length), 16));
        for (C0133a9 c0133a9 : c0133a9Arr) {
            Pair pair = TuplesKt.to(c0133a9.f752a, c0133a9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
