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
public final class C0194d9 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final byte[] fromModel(Map<String, byte[]> map) {
        C0245f9 c0245f9 = new C0245f9();
        C0219e9[] c0219e9Arr = new C0219e9[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C0219e9 c0219e9 = new C0219e9();
            c0219e9.f962a = (String) entry.getKey();
            c0219e9.b = (byte[]) entry.getValue();
            c0219e9Arr[i] = c0219e9;
            i = i2;
        }
        c0245f9.f979a = c0219e9Arr;
        return MessageNano.toByteArray(c0245f9);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        C0219e9[] c0219e9Arr = ((C0245f9) MessageNano.mergeFrom(new C0245f9(), bArr)).f979a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0219e9Arr.length), 16));
        for (C0219e9 c0219e9 : c0219e9Arr) {
            Pair pair = TuplesKt.to(c0219e9.f962a, c0219e9.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
