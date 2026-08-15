package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class J implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f603a;
    public final /* synthetic */ InterfaceC0151bj b;
    public final /* synthetic */ K c;

    public J(K k, Context context, InterfaceC0151bj interfaceC0151bj) {
        this.c = k;
        this.f603a = context;
        this.b = interfaceC0151bj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f623a.a(this.f603a, this.b);
    }
}
