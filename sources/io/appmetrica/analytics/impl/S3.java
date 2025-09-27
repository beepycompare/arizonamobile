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
/* loaded from: classes4.dex */
public final class S3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W3 fromModel(R3 r3) {
        W3 w3 = new W3();
        w3.f722a = a(r3.f650a);
        int size = r3.b.size();
        T3[] t3Arr = new T3[size];
        for (int i = 0; i < size; i++) {
            t3Arr[i] = a((Q3) r3.b.get(i));
        }
        w3.b = t3Arr;
        return w3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final R3 toModel(W3 w3) {
        T3 t3 = w3.f722a;
        if (t3 == null) {
            t3 = new T3();
        }
        Q3 a2 = a(t3);
        T3[] t3Arr = w3.b;
        ArrayList arrayList = new ArrayList(t3Arr.length);
        for (T3 t32 : t3Arr) {
            arrayList.add(a(t32));
        }
        return new R3(a2, arrayList);
    }

    public static T3 a(Q3 q3) {
        V3 v3;
        T3 t3 = new T3();
        Map map = q3.f635a;
        int i = 0;
        if (map != null) {
            v3 = new V3();
            int size = map.size();
            U3[] u3Arr = new U3[size];
            for (int i2 = 0; i2 < size; i2++) {
                u3Arr[i2] = new U3();
            }
            v3.f709a = u3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                U3 u3 = v3.f709a[i3];
                u3.f693a = (String) entry.getKey();
                u3.b = (String) entry.getValue();
                i3++;
            }
        } else {
            v3 = null;
        }
        t3.f679a = v3;
        int ordinal = q3.b.ordinal();
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
        t3.b = i;
        return t3;
    }

    public static Q3 a(T3 t3) {
        LinkedHashMap linkedHashMap;
        EnumC0530q8 enumC0530q8;
        V3 v3 = t3.f679a;
        if (v3 != null) {
            U3[] u3Arr = v3.f709a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(u3Arr.length), 16));
            for (U3 u3 : u3Arr) {
                Pair pair = TuplesKt.to(u3.f693a, u3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = t3.b;
        if (i == 0) {
            enumC0530q8 = EnumC0530q8.b;
        } else if (i == 1) {
            enumC0530q8 = EnumC0530q8.c;
        } else if (i == 2) {
            enumC0530q8 = EnumC0530q8.d;
        } else if (i != 3) {
            enumC0530q8 = EnumC0530q8.b;
        } else {
            enumC0530q8 = EnumC0530q8.e;
        }
        return new Q3(linkedHashMap, enumC0530q8);
    }
}
