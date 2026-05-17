package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0767g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(C0765e c0765e) {
        N n = new N();
        n.f1456a = c0765e.f1472a;
        return n;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C0765e(((N) obj).f1456a);
    }

    public final C0765e a(N n) {
        return new C0765e(n.f1456a);
    }
}
