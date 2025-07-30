package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Bl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cl f363a = new Cl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0650v6[] fromModel(List<Dl> list) {
        C0650v6[] c0650v6Arr = new C0650v6[list.size()];
        int i = 0;
        for (Dl dl : list) {
            c0650v6Arr[i] = this.f363a.fromModel(dl);
            i++;
        }
        return c0650v6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0650v6[] c0650v6Arr = (C0650v6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Dl> a(C0650v6[] c0650v6Arr) {
        throw new UnsupportedOperationException();
    }
}
