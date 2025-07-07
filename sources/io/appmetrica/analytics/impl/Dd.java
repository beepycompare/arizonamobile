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
    public final C0670vk f389a = Ga.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0548qm[] fromModel(Map<String, ? extends Object> map) {
        C0548qm c0548qm;
        Map<String, C0563rd> c = this.f389a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0563rd c0563rd = c.get(key);
            if (c0563rd == null || value == null) {
                c0548qm = null;
            } else {
                c0548qm = new C0548qm();
                c0548qm.f1010a = key;
                c0548qm.b = (byte[]) c0563rd.c.fromModel(value);
            }
            if (c0548qm != null) {
                arrayList.add(c0548qm);
            }
        }
        Object[] array = arrayList.toArray(new C0548qm[0]);
        if (array != null) {
            return (C0548qm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0548qm[] c0548qmArr) {
        Map<String, C0563rd> c = this.f389a.c();
        ArrayList arrayList = new ArrayList();
        for (C0548qm c0548qm : c0548qmArr) {
            C0563rd c0563rd = c.get(c0548qm.f1010a);
            Pair pair = c0563rd != null ? TuplesKt.to(c0548qm.f1010a, c0563rd.c.toModel(c0548qm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
