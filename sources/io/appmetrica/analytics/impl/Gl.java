package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Gl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Hl f461a = new Hl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0648v6[] fromModel(List<Il> list) {
        C0648v6[] c0648v6Arr = new C0648v6[list.size()];
        int i = 0;
        for (Il il : list) {
            c0648v6Arr[i] = this.f461a.fromModel(il);
            i++;
        }
        return c0648v6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0648v6[] c0648v6Arr = (C0648v6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Il> a(C0648v6[] c0648v6Arr) {
        throw new UnsupportedOperationException();
    }
}
