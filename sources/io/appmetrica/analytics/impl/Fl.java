package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes5.dex */
public final class Fl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Gl f478a = new Gl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0263g6[] fromModel(List<Hl> list) {
        C0263g6[] c0263g6Arr = new C0263g6[list.size()];
        int i = 0;
        for (Hl hl : list) {
            c0263g6Arr[i] = this.f478a.fromModel(hl);
            i++;
        }
        return c0263g6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0263g6[] c0263g6Arr = (C0263g6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Hl> a(C0263g6[] c0263g6Arr) {
        throw new UnsupportedOperationException();
    }
}
