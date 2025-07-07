package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes4.dex */
public final class K implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f497a;
    public final /* synthetic */ M b;

    public K(M m, Context context) {
        this.b = m;
        this.f497a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.b.f524a.a(this.f497a);
    }
}
