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
public final class C0192d9 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0243f9 c0243f9 = new C0243f9();
        C0217e9[] c0217e9Arr = new C0217e9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0217e9 c0217e9 = new C0217e9();
            c0217e9.f962a = (String) entry.getKey();
            c0217e9.b = (byte[]) entry.getValue();
            c0217e9Arr[i] = c0217e9;
            i = i2;
        }
        c0243f9.f979a = c0217e9Arr;
        return MessageNano.toByteArray(c0243f9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0217e9[] c0217e9Arr = ((C0243f9) MessageNano.mergeFrom(new C0243f9(), bArr)).f979a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0217e9Arr.length), 16));
        for (C0217e9 c0217e9 : c0217e9Arr) {
            Pair pair = TuplesKt.to(c0217e9.f962a, c0217e9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
