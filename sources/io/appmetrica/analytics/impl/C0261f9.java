package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0261f9 implements ProtobufConverter {
    public static M9 a(C0236e9 c0236e9) {
        M9 m9 = new M9();
        m9.d = new int[c0236e9.b.size()];
        int i = 0;
        for (Integer num : c0236e9.b) {
            m9.d[i] = num.intValue();
            i++;
        }
        m9.c = c0236e9.d;
        m9.b = c0236e9.c;
        m9.f532a = c0236e9.f818a;
        return m9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((C0236e9) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        M9 m9 = (M9) obj;
        return new C0236e9(m9.f532a, m9.b, m9.c, CollectionUtils.hashSetFromIntArray(m9.d));
    }
}
