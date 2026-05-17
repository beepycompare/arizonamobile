package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class M implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f687a;
    public final /* synthetic */ Gi b;
    public final /* synthetic */ N c;

    public M(N n, Context context, Gi gi) {
        this.c = n;
        this.f687a = context;
        this.b = gi;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f705a.a(this.f687a, this.b);
    }
}
