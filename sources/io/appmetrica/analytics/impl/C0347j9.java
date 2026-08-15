package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.j9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0347j9 implements ProtobufConverter {
    public static O9 a(C0322i9 c0322i9) {
        O9 o9 = new O9();
        o9.d = new int[c0322i9.b.size()];
        int i = 0;
        for (Integer num : c0322i9.b) {
            o9.d[i] = num.intValue();
            i++;
        }
        o9.c = c0322i9.d;
        o9.b = c0322i9.c;
        o9.f701a = c0322i9.f1032a;
        return o9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((C0322i9) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        O9 o9 = (O9) obj;
        return new C0322i9(o9.f701a, o9.b, o9.c, CollectionUtils.hashSetFromIntArray(o9.d));
    }
}
