package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class M implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f675a;
    public final /* synthetic */ Hi b;
    public final /* synthetic */ N c;

    public M(N n, Context context, Hi hi) {
        this.c = n;
        this.f675a = context;
        this.b = hi;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f692a.a(this.f675a, this.b);
    }
}
