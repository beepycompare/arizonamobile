package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f586a;
    public final /* synthetic */ C0497p1 b;

    public P0(C0497p1 c0497p1, String str) {
        this.b = c0497p1;
        this.f586a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0620u0 c0620u0 = this.b.f994a;
        String str = this.f586a;
        c0620u0.getClass();
        C0595t0.c().setUserProfileID(str);
    }
}
