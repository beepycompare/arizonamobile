package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class J implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f603a;
    public final /* synthetic */ InterfaceC0150bj b;
    public final /* synthetic */ K c;

    public J(K k, Context context, InterfaceC0150bj interfaceC0150bj) {
        this.c = k;
        this.f603a = context;
        this.b = interfaceC0150bj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f623a.a(this.f603a, this.b);
    }
}
