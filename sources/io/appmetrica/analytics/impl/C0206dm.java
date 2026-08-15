package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0206dm implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0231em f951a = new C0231em();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0500p6[] fromModel(List<C0257fm> list) {
        C0500p6[] c0500p6Arr = new C0500p6[list.size()];
        int i = 0;
        for (C0257fm c0257fm : list) {
            c0500p6Arr[i] = this.f951a.fromModel(c0257fm);
            i++;
        }
        return c0500p6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0500p6[] c0500p6Arr = (C0500p6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<C0257fm> a(C0500p6[] c0500p6Arr) {
        throw new UnsupportedOperationException();
    }
}
