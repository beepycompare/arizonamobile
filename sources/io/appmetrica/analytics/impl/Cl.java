package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes5.dex */
public final class Cl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Dl f533a = new Dl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0107a6[] fromModel(List<El> list) {
        C0107a6[] c0107a6Arr = new C0107a6[list.size()];
        int i = 0;
        for (El el : list) {
            c0107a6Arr[i] = this.f533a.fromModel(el);
            i++;
        }
        return c0107a6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0107a6[] c0107a6Arr = (C0107a6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<El> a(C0107a6[] c0107a6Arr) {
        throw new UnsupportedOperationException();
    }
}
