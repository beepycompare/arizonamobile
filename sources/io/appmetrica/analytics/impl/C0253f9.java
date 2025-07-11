package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0253f9 implements ProtobufConverter {
    public static M9 a(C0228e9 c0228e9) {
        M9 m9 = new M9();
        m9.d = new int[c0228e9.b.size()];
        int i = 0;
        for (Integer num : c0228e9.b) {
            m9.d[i] = num.intValue();
            i++;
        }
        m9.c = c0228e9.d;
        m9.b = c0228e9.c;
        m9.f533a = c0228e9.f819a;
        return m9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((C0228e9) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        M9 m9 = (M9) obj;
        return new C0228e9(m9.f533a, m9.b, m9.c, CollectionUtils.hashSetFromIntArray(m9.d));
    }
}
