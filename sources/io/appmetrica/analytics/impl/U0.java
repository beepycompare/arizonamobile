package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f799a;
    public final /* synthetic */ C0610u1 b;

    public U0(C0610u1 c0610u1, String str) {
        this.b = c0610u1;
        this.f799a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.b.f1239a;
        String str = this.f799a;
        c0734z0.getClass();
        C0709y0.c().setUserProfileID(str);
    }
}
