package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes4.dex */
public final class L implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f511a;
    public final /* synthetic */ Qi b;
    public final /* synthetic */ M c;

    public L(M m, Context context, Qi qi) {
        this.c = m;
        this.f511a = context;
        this.b = qi;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f525a.a(this.f511a, this.b);
    }
}
