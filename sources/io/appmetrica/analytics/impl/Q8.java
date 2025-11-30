package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class Q8 implements ProtobufConverter {
    public static C0644v9 a(P8 p8) {
        C0644v9 c0644v9 = new C0644v9();
        c0644v9.d = new int[p8.b.size()];
        int i = 0;
        for (Integer num : p8.b) {
            c0644v9.d[i] = num.intValue();
            i++;
        }
        c0644v9.c = p8.d;
        c0644v9.b = p8.c;
        c0644v9.f1166a = p8.f632a;
        return c0644v9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((P8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0644v9 c0644v9 = (C0644v9) obj;
        return new P8(c0644v9.f1166a, c0644v9.b, c0644v9.c, CollectionUtils.hashSetFromIntArray(c0644v9.d));
    }
}
