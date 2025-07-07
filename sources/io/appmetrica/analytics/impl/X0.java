package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f695a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0502p1 c;

    public X0(C0502p1 c0502p1, String str, String str2) {
        this.c = c0502p1;
        this.f695a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0625u0 c0625u0 = this.c.f983a;
        String str = this.f695a;
        String str2 = this.b;
        c0625u0.getClass();
        C0600t0.c().a(str, str2);
    }
}
