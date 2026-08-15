package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
/* loaded from: classes5.dex */
public final class K3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O3 fromModel(J3 j3) {
        O3 o3 = new O3();
        o3.f698a = a(j3.f607a);
        int size = j3.b.size();
        L3[] l3Arr = new L3[size];
        for (int i = 0; i < size; i++) {
            l3Arr[i] = a((I3) j3.b.get(i));
        }
        o3.b = l3Arr;
        return o3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J3 toModel(O3 o3) {
        L3 l3 = o3.f698a;
        if (l3 == null) {
            l3 = new L3();
        }
        I3 a2 = a(l3);
        L3[] l3Arr = o3.b;
        ArrayList arrayList = new ArrayList(l3Arr.length);
        for (L3 l32 : l3Arr) {
            arrayList.add(a(l32));
        }
        return new J3(a2, arrayList);
    }

    public static L3 a(I3 i3) {
        N3 n3;
        L3 l3 = new L3();
        Map map = i3.f589a;
        int i = 0;
        if (map != null) {
            n3 = new N3();
            int size = map.size();
            M3[] m3Arr = new M3[size];
            for (int i2 = 0; i2 < size; i2++) {
                m3Arr[i2] = new M3();
            }
            n3.f678a = m3Arr;
            int i4 = 0;
            for (Map.Entry entry : map.entrySet()) {
                M3 m3 = n3.f678a[i4];
                m3.f659a = (String) entry.getKey();
                m3.b = (String) entry.getValue();
                i4++;
            }
        } else {
            n3 = null;
        }
        l3.f641a = n3;
        int ordinal = i3.b.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                i = 2;
                if (ordinal != 2) {
                    i = 3;
                    if (ordinal != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                i = 1;
            }
        }
        l3.b = i;
        return l3;
    }

    public static I3 a(L3 l3) {
        LinkedHashMap linkedHashMap;
        EnumC0398l8 enumC0398l8;
        N3 n3 = l3.f641a;
        if (n3 != null) {
            M3[] m3Arr = n3.f678a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(m3Arr.length), 16));
            for (M3 m3 : m3Arr) {
                Pair pair = TuplesKt.to(m3.f659a, m3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = l3.b;
        if (i == 0) {
            enumC0398l8 = EnumC0398l8.c;
        } else if (i == 1) {
            enumC0398l8 = EnumC0398l8.d;
        } else if (i == 2) {
            enumC0398l8 = EnumC0398l8.e;
        } else if (i != 3) {
            enumC0398l8 = EnumC0398l8.c;
        } else {
            enumC0398l8 = EnumC0398l8.f;
        }
        return new I3(linkedHashMap, enumC0398l8);
    }
}
