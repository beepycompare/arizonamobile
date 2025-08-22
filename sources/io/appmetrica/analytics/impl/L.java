package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes4.dex */
public final class L implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f535a;
    public final /* synthetic */ Yi b;
    public final /* synthetic */ M c;

    public L(M m, Context context, Yi yi) {
        this.c = m;
        this.f535a = context;
        this.b = yi;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f550a.a(this.f535a, this.b);
    }
}
