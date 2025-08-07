package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f709a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0497p1 c;

    public X0(C0497p1 c0497p1, String str, String str2) {
        this.c = c0497p1;
        this.f709a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0620u0 c0620u0 = this.c.f994a;
        String str = this.f709a;
        String str2 = this.b;
        c0620u0.getClass();
        C0595t0.c().a(str, str2);
    }
}
