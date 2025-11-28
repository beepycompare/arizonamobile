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
public final class B3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F3 fromModel(A3 a3) {
        F3 f3 = new F3();
        f3.f471a = a(a3.f389a);
        int size = a3.b.size();
        C3[] c3Arr = new C3[size];
        for (int i = 0; i < size; i++) {
            c3Arr[i] = a((C0738z3) a3.b.get(i));
        }
        f3.b = c3Arr;
        return f3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A3 toModel(F3 f3) {
        C3 c3 = f3.f471a;
        if (c3 == null) {
            c3 = new C3();
        }
        C0738z3 a2 = a(c3);
        C3[] c3Arr = f3.b;
        ArrayList arrayList = new ArrayList(c3Arr.length);
        for (C3 c32 : c3Arr) {
            arrayList.add(a(c32));
        }
        return new A3(a2, arrayList);
    }

    public static C3 a(C0738z3 c0738z3) {
        E3 e3;
        C3 c3 = new C3();
        Map map = c0738z3.f1224a;
        int i = 0;
        if (map != null) {
            e3 = new E3();
            int size = map.size();
            D3[] d3Arr = new D3[size];
            for (int i2 = 0; i2 < size; i2++) {
                d3Arr[i2] = new D3();
            }
            e3.f450a = d3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                D3 d3 = e3.f450a[i3];
                d3.f435a = (String) entry.getKey();
                d3.b = (String) entry.getValue();
                i3++;
            }
        } else {
            e3 = null;
        }
        c3.f420a = e3;
        int ordinal = c0738z3.b.ordinal();
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
        c3.b = i;
        return c3;
    }

    public static C0738z3 a(C3 c3) {
        LinkedHashMap linkedHashMap;
        Y7 y7;
        E3 e3 = c3.f420a;
        if (e3 != null) {
            D3[] d3Arr = e3.f450a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(d3Arr.length), 16));
            for (D3 d3 : d3Arr) {
                Pair pair = TuplesKt.to(d3.f435a, d3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = c3.b;
        if (i == 0) {
            y7 = Y7.b;
        } else if (i == 1) {
            y7 = Y7.c;
        } else if (i == 2) {
            y7 = Y7.d;
        } else if (i != 3) {
            y7 = Y7.b;
        } else {
            y7 = Y7.e;
        }
        return new C0738z3(linkedHashMap, y7);
    }
}
