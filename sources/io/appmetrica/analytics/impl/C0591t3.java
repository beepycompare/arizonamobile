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
/* renamed from: io.appmetrica.analytics.impl.t3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0591t3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0691x3 fromModel(C0566s3 c0566s3) {
        C0691x3 c0691x3 = new C0691x3();
        c0691x3.f1297a = a(c0566s3.f1216a);
        int size = c0566s3.b.size();
        C0616u3[] c0616u3Arr = new C0616u3[size];
        for (int i = 0; i < size; i++) {
            c0616u3Arr[i] = a((C0541r3) c0566s3.b.get(i));
        }
        c0691x3.b = c0616u3Arr;
        return c0691x3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0566s3 toModel(C0691x3 c0691x3) {
        C0616u3 c0616u3 = c0691x3.f1297a;
        if (c0616u3 == null) {
            c0616u3 = new C0616u3();
        }
        C0541r3 a2 = a(c0616u3);
        C0616u3[] c0616u3Arr = c0691x3.b;
        ArrayList arrayList = new ArrayList(c0616u3Arr.length);
        for (C0616u3 c0616u32 : c0616u3Arr) {
            arrayList.add(a(c0616u32));
        }
        return new C0566s3(a2, arrayList);
    }

    public static C0616u3 a(C0541r3 c0541r3) {
        C0666w3 c0666w3;
        C0616u3 c0616u3 = new C0616u3();
        Map map = c0541r3.f1199a;
        int i = 0;
        if (map != null) {
            c0666w3 = new C0666w3();
            int size = map.size();
            C0641v3[] c0641v3Arr = new C0641v3[size];
            for (int i2 = 0; i2 < size; i2++) {
                c0641v3Arr[i2] = new C0641v3();
            }
            c0666w3.f1280a = c0641v3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                C0641v3 c0641v3 = c0666w3.f1280a[i3];
                c0641v3.f1267a = (String) entry.getKey();
                c0641v3.b = (String) entry.getValue();
                i3++;
            }
        } else {
            c0666w3 = null;
        }
        c0616u3.f1247a = c0666w3;
        int ordinal = c0541r3.b.ordinal();
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
        c0616u3.b = i;
        return c0616u3;
    }

    public static C0541r3 a(C0616u3 c0616u3) {
        LinkedHashMap linkedHashMap;
        S7 s7;
        C0666w3 c0666w3 = c0616u3.f1247a;
        if (c0666w3 != null) {
            C0641v3[] c0641v3Arr = c0666w3.f1280a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c0641v3Arr.length), 16));
            for (C0641v3 c0641v3 : c0641v3Arr) {
                Pair pair = TuplesKt.to(c0641v3.f1267a, c0641v3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = c0616u3.b;
        if (i == 0) {
            s7 = S7.b;
        } else if (i == 1) {
            s7 = S7.c;
        } else if (i == 2) {
            s7 = S7.d;
        } else if (i != 3) {
            s7 = S7.b;
        } else {
            s7 = S7.e;
        }
        return new C0541r3(linkedHashMap, s7);
    }
}
