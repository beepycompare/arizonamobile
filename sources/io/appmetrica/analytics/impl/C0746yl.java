package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.yl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0746yl implements ListConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0771zl f1149a = new C0771zl();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0581s6[] fromModel(List<Al> list) {
        C0581s6[] c0581s6Arr = new C0581s6[list.size()];
        int i = 0;
        for (Al al : list) {
            c0581s6Arr[i] = this.f1149a.fromModel(al);
            i++;
        }
        return c0581s6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0581s6[] c0581s6Arr = (C0581s6[]) obj;
        throw new UnsupportedOperationException();
    }

    public final List<Al> a(C0581s6[] c0581s6Arr) {
        throw new UnsupportedOperationException();
    }
}
