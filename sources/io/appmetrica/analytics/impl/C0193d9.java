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
/* renamed from: io.appmetrica.analytics.impl.d9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0193d9 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0244f9 c0244f9 = new C0244f9();
        C0218e9[] c0218e9Arr = new C0218e9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0218e9 c0218e9 = new C0218e9();
            c0218e9.f962a = (String) entry.getKey();
            c0218e9.b = (byte[]) entry.getValue();
            c0218e9Arr[i] = c0218e9;
            i = i2;
        }
        c0244f9.f979a = c0218e9Arr;
        return MessageNano.toByteArray(c0244f9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0218e9[] c0218e9Arr = ((C0244f9) MessageNano.mergeFrom(new C0244f9(), bArr)).f979a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0218e9Arr.length), 16));
        for (C0218e9 c0218e9 : c0218e9Arr) {
            Pair pair = TuplesKt.to(c0218e9.f962a, c0218e9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
