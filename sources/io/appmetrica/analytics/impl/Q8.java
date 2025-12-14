package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class Q8 implements ProtobufConverter {
    public static C0643v9 a(P8 p8) {
        C0643v9 c0643v9 = new C0643v9();
        c0643v9.d = new int[p8.b.size()];
        int i = 0;
        for (Integer num : p8.b) {
            c0643v9.d[i] = num.intValue();
            i++;
        }
        c0643v9.c = p8.d;
        c0643v9.b = p8.c;
        c0643v9.f1263a = p8.f729a;
        return c0643v9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((P8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0643v9 c0643v9 = (C0643v9) obj;
        return new P8(c0643v9.f1263a, c0643v9.b, c0643v9.c, CollectionUtils.hashSetFromIntArray(c0643v9.d));
    }
}
