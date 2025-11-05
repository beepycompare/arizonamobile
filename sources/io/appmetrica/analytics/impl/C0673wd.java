package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.wd  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0673wd implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ck f1185a = C0620ua.k().p();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0682wm[] fromModel(Map<String, ? extends Object> map) {
        C0682wm c0682wm;
        Map<String, C0244fd> c = this.f1185a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0244fd c0244fd = c.get(key);
            if (c0244fd == null || value == null) {
                c0682wm = null;
            } else {
                c0682wm = new C0682wm();
                c0682wm.f1192a = key;
                c0682wm.b = (byte[]) c0244fd.c.fromModel(value);
            }
            if (c0682wm != null) {
                arrayList.add(c0682wm);
            }
        }
        Object[] array = arrayList.toArray(new C0682wm[0]);
        if (array != null) {
            return (C0682wm[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Map<String, Object> toModel(C0682wm[] c0682wmArr) {
        Map<String, C0244fd> c = this.f1185a.c();
        ArrayList arrayList = new ArrayList();
        for (C0682wm c0682wm : c0682wmArr) {
            C0244fd c0244fd = c.get(c0682wm.f1192a);
            Pair pair = c0244fd != null ? TuplesKt.to(c0682wm.f1192a, c0244fd.c.toModel(c0682wm.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
