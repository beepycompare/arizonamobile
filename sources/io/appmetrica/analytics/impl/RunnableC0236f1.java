package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0236f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f987a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0589t1 c;

    public RunnableC0236f1(C0589t1 c0589t1, String str, String str2) {
        this.c = c0589t1;
        this.f987a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0738z0 c0738z0 = this.c.f1228a;
        String str = this.f987a;
        String str2 = this.b;
        c0738z0.getClass();
        C0713y0.c().putAppEnvironmentValue(str, str2);
    }
}
