package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.dm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0205dm implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0230em f951a = new C0230em();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0499p6[] fromModel(List<C0256fm> list) {
        C0499p6[] c0499p6Arr = new C0499p6[list.size()];
        int i = 0;
        for (C0256fm c0256fm : list) {
            c0499p6Arr[i] = this.f951a.fromModel(c0256fm);
            i++;
        }
        return c0499p6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0499p6[] c0499p6Arr = (C0499p6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<C0256fm> a(C0499p6[] c0499p6Arr) {
        throw new UnsupportedOperationException();
    }
}
