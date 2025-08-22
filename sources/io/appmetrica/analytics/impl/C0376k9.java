package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0376k9 implements ProtobufConverter {
    public static R9 a(C0350j9 c0350j9) {
        R9 r9 = new R9();
        r9.d = new int[c0350j9.b.size()];
        int i = 0;
        for (Integer num : c0350j9.b) {
            r9.d[i] = num.intValue();
            i++;
        }
        r9.c = c0350j9.d;
        r9.b = c0350j9.c;
        r9.f632a = c0350j9.f920a;
        return r9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((C0350j9) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        R9 r9 = (R9) obj;
        return new C0350j9(r9.f632a, r9.b, r9.c, CollectionUtils.hashSetFromIntArray(r9.d));
    }
}
