package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class L implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f658a;
    public final /* synthetic */ N b;

    public L(N n, Context context) {
        this.b = n;
        this.f658a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.b.f691a.a(this.f658a);
    }
}
