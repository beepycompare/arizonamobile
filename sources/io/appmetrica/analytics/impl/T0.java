package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f774a;
    public final /* synthetic */ C0644v1 b;

    public T0(C0644v1 c0644v1, boolean z) {
        this.b = c0644v1;
        this.f774a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1246a;
        boolean z = this.f774a;
        b0.getClass();
        A0.c().a(z, true);
    }
}
