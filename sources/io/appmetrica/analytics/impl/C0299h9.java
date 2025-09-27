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
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0299h9 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0350j9 c0350j9 = new C0350j9();
        C0325i9[] c0325i9Arr = new C0325i9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0325i9 c0325i9 = new C0325i9();
            c0325i9.f921a = (String) entry.getKey();
            c0325i9.b = (byte[]) entry.getValue();
            c0325i9Arr[i] = c0325i9;
            i = i2;
        }
        c0350j9.f938a = c0325i9Arr;
        return MessageNano.toByteArray(c0350j9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0325i9[] c0325i9Arr = ((C0350j9) MessageNano.mergeFrom(new C0350j9(), bArr)).f938a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0325i9Arr.length), 16));
        for (C0325i9 c0325i9 : c0325i9Arr) {
            Pair pair = TuplesKt.to(c0325i9.f921a, c0325i9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
