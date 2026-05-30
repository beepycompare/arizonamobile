package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0207dm implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0232em f949a = new C0232em();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0501p6[] fromModel(List<C0258fm> list) {
        C0501p6[] c0501p6Arr = new C0501p6[list.size()];
        int i = 0;
        for (C0258fm c0258fm : list) {
            c0501p6Arr[i] = this.f949a.fromModel(c0258fm);
            i++;
        }
        return c0501p6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0501p6[] c0501p6Arr = (C0501p6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<C0258fm> a(C0501p6[] c0501p6Arr) {
        throw new UnsupportedOperationException();
    }
}
