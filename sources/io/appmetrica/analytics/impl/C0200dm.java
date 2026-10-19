package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0200dm implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0225em f954a = new C0225em();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0494p6[] fromModel(List<C0251fm> list) {
        C0494p6[] c0494p6Arr = new C0494p6[list.size()];
        int i = 0;
        for (C0251fm c0251fm : list) {
            c0494p6Arr[i] = this.f954a.fromModel(c0251fm);
            i++;
        }
        return c0494p6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0494p6[] c0494p6Arr = (C0494p6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<C0251fm> a(C0494p6[] c0494p6Arr) {
        throw new UnsupportedOperationException();
    }
}
