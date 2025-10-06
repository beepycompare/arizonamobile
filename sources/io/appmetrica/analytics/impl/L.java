package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes4.dex */
public final class L implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f548a;
    public final /* synthetic */ InterfaceC0181cj b;
    public final /* synthetic */ M c;

    public L(M m, Context context, InterfaceC0181cj interfaceC0181cj) {
        this.c = m;
        this.f548a = context;
        this.b = interfaceC0181cj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f568a.a(this.f548a, this.b);
    }
}
