package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Kl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ll f544a = new Ll();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0728y6[] fromModel(List<Ml> list) {
        C0728y6[] c0728y6Arr = new C0728y6[list.size()];
        int i = 0;
        for (Ml ml : list) {
            c0728y6Arr[i] = this.f544a.fromModel(ml);
            i++;
        }
        return c0728y6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0728y6[] c0728y6Arr = (C0728y6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Ml> a(C0728y6[] c0728y6Arr) {
        throw new UnsupportedOperationException();
    }
}
