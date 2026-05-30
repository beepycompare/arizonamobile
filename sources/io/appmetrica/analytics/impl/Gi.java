package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f563a;
    public final /* synthetic */ Ii b;

    public Gi(Ii ii, Context context) {
        this.b = ii;
        this.f563a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.b;
        Context context = this.f563a;
        b0.getClass();
        A0.a(context);
    }
}
