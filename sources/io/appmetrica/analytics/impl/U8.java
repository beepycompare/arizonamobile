package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* loaded from: classes3.dex */
public final class U8 implements ProtobufConverter {
    public static B9 a(T8 t8) {
        B9 b9 = new B9();
        b9.d = new int[t8.b.size()];
        int i = 0;
        for (Integer num : t8.b) {
            b9.d[i] = num.intValue();
            i++;
        }
        b9.c = t8.d;
        b9.b = t8.c;
        b9.f410a = t8.f701a;
        return b9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((T8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        B9 b9 = (B9) obj;
        return new T8(b9.f410a, b9.b, b9.c, CollectionUtils.hashSetFromIntArray(b9.d));
    }
}
