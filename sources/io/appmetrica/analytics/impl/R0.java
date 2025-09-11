package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f647a;
    public final /* synthetic */ C0547r1 b;

    public R0(C0547r1 c0547r1, String str) {
        this.b = c0547r1;
        this.f647a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.b.f1058a;
        String str = this.f647a;
        c0671w0.getClass();
        C0646v0.c().setUserProfileID(str);
    }
}
