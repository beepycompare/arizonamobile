package io.appmetrica.analytics.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Ac {
    public static final B9 a(Ac ac, K9 k9, Map map) {
        int i;
        Object value;
        ac.getClass();
        B9 b9 = new B9();
        switch (k9.ordinal()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 6;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        b9.f491a = i;
        Bc.b.getClass();
        Set<Map.Entry> entrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Object key = entry.getKey();
            if (entry.getValue() instanceof Number) {
                Object value2 = entry.getValue();
                if (value2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
                }
                double doubleValue = ((Number) value2).doubleValue();
                if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                    value = null;
                    Pair pair = TuplesKt.to(key, value);
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
            }
            value = entry.getValue();
            Pair pair2 = TuplesKt.to(key, value);
            linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
        }
        String jSONObject = new JSONObject(linkedHashMap).toString();
        if (jSONObject != null) {
            b9.b = jSONObject.getBytes(Charsets.UTF_8);
        }
        return b9;
    }
}
