package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes3.dex */
public final class M implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f582a;
    public final /* synthetic */ Li b;
    public final /* synthetic */ N c;

    public M(N n, Context context, Li li) {
        this.c = n;
        this.f582a = context;
        this.b = li;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f598a.a(this.f582a, this.b);
    }
}
