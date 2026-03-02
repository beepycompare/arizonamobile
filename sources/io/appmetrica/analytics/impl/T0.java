package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class T0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f789a;
    public final /* synthetic */ C0588t1 b;

    public T0(C0588t1 c0588t1, String str) {
        this.b = c0588t1;
        this.f789a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0737z0 c0737z0 = this.b.f1228a;
        String str = this.f789a;
        c0737z0.getClass();
        C0712y0.c().setUserProfileID(str);
    }
}
