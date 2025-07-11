package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f572a;
    public final /* synthetic */ C0494p1 b;

    public P0(C0494p1 c0494p1, String str) {
        this.b = c0494p1;
        this.f572a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0617u0 c0617u0 = this.b.f984a;
        String str = this.f572a;
        c0617u0.getClass();
        C0592t0.c().setUserProfileID(str);
    }
}
