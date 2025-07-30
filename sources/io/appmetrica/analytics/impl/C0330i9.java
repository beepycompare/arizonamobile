package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
/* renamed from: io.appmetrica.analytics.impl.i9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0330i9 implements ProtobufConverter {
    public static P9 a(C0305h9 c0305h9) {
        P9 p9 = new P9();
        p9.d = new int[c0305h9.b.size()];
        int i = 0;
        for (Integer num : c0305h9.b) {
            p9.d[i] = num.intValue();
            i++;
        }
        p9.c = c0305h9.d;
        p9.b = c0305h9.c;
        p9.f593a = c0305h9.f881a;
        return p9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((C0305h9) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        P9 p9 = (P9) obj;
        return new C0305h9(p9.f593a, p9.b, p9.c, CollectionUtils.hashSetFromIntArray(p9.d));
    }
}
