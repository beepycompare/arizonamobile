package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f500a;
    public final /* synthetic */ Ki b;

    public Ii(Ki ki, Context context) {
        this.b = ki;
        this.f500a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.b.b;
        Context context = this.f500a;
        c0671w0.getClass();
        C0646v0.a(context);
    }
}
