package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes4.dex */
public final class L implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f527a;
    public final /* synthetic */ Ti b;
    public final /* synthetic */ M c;

    public L(M m, Context context, Ti ti) {
        this.c = m;
        this.f527a = context;
        this.b = ti;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f539a.a(this.f527a, this.b);
    }
}
