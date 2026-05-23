package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class J implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f600a;
    public final /* synthetic */ InterfaceC0152bj b;
    public final /* synthetic */ K c;

    public J(K k, Context context, InterfaceC0152bj interfaceC0152bj) {
        this.c = k;
        this.f600a = context;
        this.b = interfaceC0152bj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f620a.a(this.f600a, this.b);
    }
}
