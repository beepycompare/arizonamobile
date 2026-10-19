package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class J implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f606a;
    public final /* synthetic */ InterfaceC0145bj b;
    public final /* synthetic */ K c;

    public J(K k, Context context, InterfaceC0145bj interfaceC0145bj) {
        this.c = k;
        this.f606a = context;
        this.b = interfaceC0145bj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f626a.a(this.f606a, this.b);
    }
}
