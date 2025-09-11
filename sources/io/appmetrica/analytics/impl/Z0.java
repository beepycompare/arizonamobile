package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f765a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0547r1 c;

    public Z0(C0547r1 c0547r1, String str, String str2) {
        this.c = c0547r1;
        this.f765a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.c.f1058a;
        String str = this.f765a;
        String str2 = this.b;
        c0671w0.getClass();
        C0646v0.c().a(str, str2);
    }
}
