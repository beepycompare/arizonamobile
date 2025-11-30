package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class U0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f701a;
    public final /* synthetic */ C0611u1 b;

    public U0(C0611u1 c0611u1, String str) {
        this.b = c0611u1;
        this.f701a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735z0 c0735z0 = this.b.f1141a;
        String str = this.f701a;
        c0735z0.getClass();
        C0710y0.c().setUserProfileID(str);
    }
}
