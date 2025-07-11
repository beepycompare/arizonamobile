package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.yl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0738yl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0763zl f1150a = new C0763zl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0573s6[] fromModel(List<Al> list) {
        C0573s6[] c0573s6Arr = new C0573s6[list.size()];
        int i = 0;
        for (Al al : list) {
            c0573s6Arr[i] = this.f1150a.fromModel(al);
            i++;
        }
        return c0573s6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0573s6[] c0573s6Arr = (C0573s6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Al> a(C0573s6[] c0573s6Arr) {
        throw new UnsupportedOperationException();
    }
}
