package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0764g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(C0762e c0762e) {
        N n = new N();
        n.f1428a = c0762e.f1444a;
        return n;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0762e(((N) obj).f1428a);
    }

    public final C0762e a(N n) {
        return new C0762e(n.f1428a);
    }
}
