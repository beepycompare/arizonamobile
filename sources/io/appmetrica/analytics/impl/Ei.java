package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f416a;
    public final /* synthetic */ Gi b;

    public Ei(Gi gi, Context context) {
        this.b = gi;
        this.f416a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0617u0 c0617u0 = this.b.b;
        Context context = this.f416a;
        c0617u0.getClass();
        C0592t0.a(context);
    }
}
