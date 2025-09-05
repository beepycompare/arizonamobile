package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes4.dex */
public final class L implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f543a;
    public final /* synthetic */ InterfaceC0180cj b;
    public final /* synthetic */ M c;

    public L(M m, Context context, InterfaceC0180cj interfaceC0180cj) {
        this.c = m;
        this.f543a = context;
        this.b = interfaceC0180cj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f563a.a(this.f543a, this.b);
    }
}
