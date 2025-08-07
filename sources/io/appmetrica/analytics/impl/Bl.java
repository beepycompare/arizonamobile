package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Bl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cl f362a = new Cl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0651v6[] fromModel(List<Dl> list) {
        C0651v6[] c0651v6Arr = new C0651v6[list.size()];
        int i = 0;
        for (Dl dl : list) {
            c0651v6Arr[i] = this.f362a.fromModel(dl);
            i++;
        }
        return c0651v6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0651v6[] c0651v6Arr = (C0651v6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Dl> a(C0651v6[] c0651v6Arr) {
        throw new UnsupportedOperationException();
    }
}
