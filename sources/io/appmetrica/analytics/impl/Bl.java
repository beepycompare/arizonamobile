package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes5.dex */
public final class Bl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cl f524a = new Cl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Z5[] fromModel(List<Dl> list) {
        Z5[] z5Arr = new Z5[list.size()];
        int i = 0;
        for (Dl dl : list) {
            z5Arr[i] = this.f524a.fromModel(dl);
            i++;
        }
        return z5Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Z5[] z5Arr = (Z5[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Dl> a(Z5[] z5Arr) {
        throw new UnsupportedOperationException();
    }
}
