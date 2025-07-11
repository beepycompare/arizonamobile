package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f696a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0494p1 c;

    public X0(C0494p1 c0494p1, String str, String str2) {
        this.c = c0494p1;
        this.f696a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0617u0 c0617u0 = this.c.f984a;
        String str = this.f696a;
        String str2 = this.b;
        c0617u0.getClass();
        C0592t0.c().a(str, str2);
    }
}
