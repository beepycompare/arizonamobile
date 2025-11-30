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
/* renamed from: io.appmetrica.analytics.impl.u3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0613u3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0713y3 fromModel(C0588t3 c0588t3) {
        C0713y3 c0713y3 = new C0713y3();
        c0713y3.f1210a = a(c0588t3.f1128a);
        int size = c0588t3.b.size();
        C0638v3[] c0638v3Arr = new C0638v3[size];
        for (int i = 0; i < size; i++) {
            c0638v3Arr[i] = a((C0563s3) c0588t3.b.get(i));
        }
        c0713y3.b = c0638v3Arr;
        return c0713y3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0588t3 toModel(C0713y3 c0713y3) {
        C0638v3 c0638v3 = c0713y3.f1210a;
        if (c0638v3 == null) {
            c0638v3 = new C0638v3();
        }
        C0563s3 a2 = a(c0638v3);
        C0638v3[] c0638v3Arr = c0713y3.b;
        ArrayList arrayList = new ArrayList(c0638v3Arr.length);
        for (C0638v3 c0638v32 : c0638v3Arr) {
            arrayList.add(a(c0638v32));
        }
        return new C0588t3(a2, arrayList);
    }

    public static C0638v3 a(C0563s3 c0563s3) {
        C0688x3 c0688x3;
        C0638v3 c0638v3 = new C0638v3();
        Map map = c0563s3.f1111a;
        int i = 0;
        if (map != null) {
            c0688x3 = new C0688x3();
            int size = map.size();
            C0663w3[] c0663w3Arr = new C0663w3[size];
            for (int i2 = 0; i2 < size; i2++) {
                c0663w3Arr[i2] = new C0663w3();
            }
            c0688x3.f1193a = c0663w3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                C0663w3 c0663w3 = c0688x3.f1193a[i3];
                c0663w3.f1179a = (String) entry.getKey();
                c0663w3.b = (String) entry.getValue();
                i3++;
            }
        } else {
            c0688x3 = null;
        }
        c0638v3.f1160a = c0688x3;
        int ordinal = c0563s3.b.ordinal();
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
        c0638v3.b = i;
        return c0638v3;
    }

    public static C0563s3 a(C0638v3 c0638v3) {
        LinkedHashMap linkedHashMap;
        T7 t7;
        C0688x3 c0688x3 = c0638v3.f1160a;
        if (c0688x3 != null) {
            C0663w3[] c0663w3Arr = c0688x3.f1193a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0663w3Arr.length), 16));
            for (C0663w3 c0663w3 : c0663w3Arr) {
                Pair pair = TuplesKt.to(c0663w3.f1179a, c0663w3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = c0638v3.b;
        if (i == 0) {
            t7 = T7.b;
        } else if (i == 1) {
            t7 = T7.c;
        } else if (i == 2) {
            t7 = T7.d;
        } else if (i != 3) {
            t7 = T7.b;
        } else {
            t7 = T7.e;
        }
        return new C0563s3(linkedHashMap, t7);
    }
}
