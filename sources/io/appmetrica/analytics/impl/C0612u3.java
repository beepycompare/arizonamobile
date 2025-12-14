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
public final class C0612u3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0712y3 fromModel(C0587t3 c0587t3) {
        C0712y3 c0712y3 = new C0712y3();
        c0712y3.f1307a = a(c0587t3.f1225a);
        int size = c0587t3.b.size();
        C0637v3[] c0637v3Arr = new C0637v3[size];
        for (int i = 0; i < size; i++) {
            c0637v3Arr[i] = a((C0562s3) c0587t3.b.get(i));
        }
        c0712y3.b = c0637v3Arr;
        return c0712y3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0587t3 toModel(C0712y3 c0712y3) {
        C0637v3 c0637v3 = c0712y3.f1307a;
        if (c0637v3 == null) {
            c0637v3 = new C0637v3();
        }
        C0562s3 a2 = a(c0637v3);
        C0637v3[] c0637v3Arr = c0712y3.b;
        ArrayList arrayList = new ArrayList(c0637v3Arr.length);
        for (C0637v3 c0637v32 : c0637v3Arr) {
            arrayList.add(a(c0637v32));
        }
        return new C0587t3(a2, arrayList);
    }

    public static C0637v3 a(C0562s3 c0562s3) {
        C0687x3 c0687x3;
        C0637v3 c0637v3 = new C0637v3();
        Map map = c0562s3.f1208a;
        int i = 0;
        if (map != null) {
            c0687x3 = new C0687x3();
            int size = map.size();
            C0662w3[] c0662w3Arr = new C0662w3[size];
            for (int i2 = 0; i2 < size; i2++) {
                c0662w3Arr[i2] = new C0662w3();
            }
            c0687x3.f1290a = c0662w3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                C0662w3 c0662w3 = c0687x3.f1290a[i3];
                c0662w3.f1276a = (String) entry.getKey();
                c0662w3.b = (String) entry.getValue();
                i3++;
            }
        } else {
            c0687x3 = null;
        }
        c0637v3.f1257a = c0687x3;
        int ordinal = c0562s3.b.ordinal();
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
        c0637v3.b = i;
        return c0637v3;
    }

    public static C0562s3 a(C0637v3 c0637v3) {
        LinkedHashMap linkedHashMap;
        T7 t7;
        C0687x3 c0687x3 = c0637v3.f1257a;
        if (c0687x3 != null) {
            C0662w3[] c0662w3Arr = c0687x3.f1290a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0662w3Arr.length), 16));
            for (C0662w3 c0662w3 : c0662w3Arr) {
                Pair pair = TuplesKt.to(c0662w3.f1276a, c0662w3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = c0637v3.b;
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
        return new C0562s3(linkedHashMap, t7);
    }
}
