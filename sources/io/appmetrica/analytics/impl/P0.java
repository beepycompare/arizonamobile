package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f586a;
    public final /* synthetic */ C0496p1 b;

    public P0(C0496p1 c0496p1, String str) {
        this.b = c0496p1;
        this.f586a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0619u0 c0619u0 = this.b.f994a;
        String str = this.f586a;
        c0619u0.getClass();
        C0594t0.c().setUserProfileID(str);
    }
}
