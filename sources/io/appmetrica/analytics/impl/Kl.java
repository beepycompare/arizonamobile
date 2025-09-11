package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Kl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ll f543a = new Ll();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0727y6[] fromModel(List<Ml> list) {
        C0727y6[] c0727y6Arr = new C0727y6[list.size()];
        int i = 0;
        for (Ml ml : list) {
            c0727y6Arr[i] = this.f543a.fromModel(ml);
            i++;
        }
        return c0727y6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0727y6[] c0727y6Arr = (C0727y6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Ml> a(C0727y6[] c0727y6Arr) {
        throw new UnsupportedOperationException();
    }
}
