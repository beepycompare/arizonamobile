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
public final class P3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T3 fromModel(O3 o3) {
        T3 t3 = new T3();
        t3.f634a = a(o3.f563a);
        int size = o3.b.size();
        Q3[] q3Arr = new Q3[size];
        for (int i = 0; i < size; i++) {
            q3Arr[i] = a((N3) o3.b.get(i));
        }
        t3.b = q3Arr;
        return t3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O3 toModel(T3 t3) {
        Q3 q3 = t3.f634a;
        if (q3 == null) {
            q3 = new Q3();
        }
        N3 a2 = a(q3);
        Q3[] q3Arr = t3.b;
        ArrayList arrayList = new ArrayList(q3Arr.length);
        for (Q3 q32 : q3Arr) {
            arrayList.add(a(q32));
        }
        return new O3(a2, arrayList);
    }

    public static Q3 a(N3 n3) {
        S3 s3;
        Q3 q3 = new Q3();
        Map map = n3.f548a;
        int i = 0;
        if (map != null) {
            s3 = new S3();
            int size = map.size();
            R3[] r3Arr = new R3[size];
            for (int i2 = 0; i2 < size; i2++) {
                r3Arr[i2] = new R3();
            }
            s3.f620a = r3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                R3 r3 = s3.f620a[i3];
                r3.f602a = (String) entry.getKey();
                r3.b = (String) entry.getValue();
                i3++;
            }
        } else {
            s3 = null;
        }
        q3.f590a = s3;
        int ordinal = n3.b.ordinal();
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
        q3.b = i;
        return q3;
    }

    public static N3 a(Q3 q3) {
        LinkedHashMap linkedHashMap;
        EnumC0327i8 enumC0327i8;
        S3 s3 = q3.f590a;
        if (s3 != null) {
            R3[] r3Arr = s3.f620a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r3Arr.length), 16));
            for (R3 r3 : r3Arr) {
                Pair pair = TuplesKt.to(r3.f602a, r3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = q3.b;
        if (i == 0) {
            enumC0327i8 = EnumC0327i8.b;
        } else if (i == 1) {
            enumC0327i8 = EnumC0327i8.c;
        } else if (i == 2) {
            enumC0327i8 = EnumC0327i8.d;
        } else if (i != 3) {
            enumC0327i8 = EnumC0327i8.b;
        } else {
            enumC0327i8 = EnumC0327i8.e;
        }
        return new N3(linkedHashMap, enumC0327i8);
    }
}
