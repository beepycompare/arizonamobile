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
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0177c9 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0228e9 c0228e9 = new C0228e9();
        C0203d9[] c0203d9Arr = new C0203d9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0203d9 c0203d9 = new C0203d9();
            c0203d9.f814a = (String) entry.getKey();
            c0203d9.b = (byte[]) entry.getValue();
            c0203d9Arr[i] = c0203d9;
            i = i2;
        }
        c0228e9.f828a = c0203d9Arr;
        return MessageNano.toByteArray(c0228e9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0203d9[] c0203d9Arr = ((C0228e9) MessageNano.mergeFrom(new C0228e9(), bArr)).f828a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0203d9Arr.length), 16));
        for (C0203d9 c0203d9 : c0203d9Arr) {
            Pair pair = TuplesKt.to(c0203d9.f814a, c0203d9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
