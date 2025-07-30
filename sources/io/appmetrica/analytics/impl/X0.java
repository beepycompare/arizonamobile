package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f710a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0496p1 c;

    public X0(C0496p1 c0496p1, String str, String str2) {
        this.c = c0496p1;
        this.f710a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0619u0 c0619u0 = this.c.f995a;
        String str = this.f710a;
        String str2 = this.b;
        c0619u0.getClass();
        C0594t0.c().a(str, str2);
    }
}
