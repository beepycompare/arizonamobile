package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.n9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0455n9 implements ProtobufConverter {
    public static U9 a(C0429m9 c0429m9) {
        U9 u9 = new U9();
        u9.d = new int[c0429m9.b.size()];
        int i = 0;
        for (Integer num : c0429m9.b) {
            u9.d[i] = num.intValue();
            i++;
        }
        u9.c = c0429m9.d;
        u9.b = c0429m9.c;
        u9.f698a = c0429m9.f990a;
        return u9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((C0429m9) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        U9 u9 = (U9) obj;
        return new C0429m9(u9.f698a, u9.b, u9.c, CollectionUtils.hashSetFromIntArray(u9.d));
    }
}
