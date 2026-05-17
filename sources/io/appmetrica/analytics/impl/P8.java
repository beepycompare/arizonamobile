package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class P8 implements ProtobufConverter {
    public static C0621u9 a(O8 o8) {
        C0621u9 c0621u9 = new C0621u9();
        c0621u9.d = new int[o8.b.size()];
        int i = 0;
        for (Integer num : o8.b) {
            c0621u9.d[i] = num.intValue();
            i++;
        }
        c0621u9.c = o8.d;
        c0621u9.b = o8.c;
        c0621u9.f1258a = o8.f726a;
        return c0621u9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((O8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0621u9 c0621u9 = (C0621u9) obj;
        return new O8(c0621u9.f1258a, c0621u9.b, c0621u9.c, CollectionUtils.hashSetFromIntArray(c0621u9.d));
    }
}
