package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
/* loaded from: classes5.dex */
public final class I implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f583a;
    public final /* synthetic */ K b;

    public I(K k, Context context) {
        this.b = k;
        this.f583a = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.b.f620a.a(this.f583a);
    }
}
