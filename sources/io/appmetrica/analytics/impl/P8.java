package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes5.dex */
public final class P8 implements ProtobufConverter {
    public static C0622u9 a(O8 o8) {
        C0622u9 c0622u9 = new C0622u9();
        c0622u9.d = new int[o8.b.size()];
        int i = 0;
        for (Integer num : o8.b) {
            c0622u9.d[i] = num.intValue();
            i++;
        }
        c0622u9.c = o8.d;
        c0622u9.b = o8.c;
        c0622u9.f1254a = o8.f722a;
        return c0622u9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((O8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0622u9 c0622u9 = (C0622u9) obj;
        return new O8(c0622u9.f1254a, c0622u9.b, c0622u9.c, CollectionUtils.hashSetFromIntArray(c0622u9.d));
    }
}
