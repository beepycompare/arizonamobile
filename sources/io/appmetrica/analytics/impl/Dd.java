package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Dd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0662vk f390a = Ga.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0540qm[] fromModel(Map<String, ? extends Object> map) {
        C0540qm c0540qm;
        Map<String, C0555rd> c = this.f390a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0555rd c0555rd = c.get(key);
            if (c0555rd == null || value == null) {
                c0540qm = null;
            } else {
                c0540qm = new C0540qm();
                c0540qm.f1011a = key;
                c0540qm.b = (byte[]) c0555rd.c.fromModel(value);
            }
            if (c0540qm != null) {
                arrayList.add(c0540qm);
            }
        }
        Object[] array = arrayList.toArray(new C0540qm[0]);
        if (array != null) {
            return (C0540qm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0540qm[] c0540qmArr) {
        Map<String, C0555rd> c = this.f390a.c();
        ArrayList arrayList = new ArrayList();
        for (C0540qm c0540qm : c0540qmArr) {
            C0555rd c0555rd = c.get(c0540qm.f1011a);
            Pair pair = c0555rd != null ? TuplesKt.to(c0540qm.f1011a, c0555rd.c.toModel(c0540qm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
