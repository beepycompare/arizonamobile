package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f708a;
    public final /* synthetic */ C0568ri b;

    public Xh(C0568ri c0568ri, String str) {
        this.b = c0568ri;
        this.f708a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).setUserProfileID(this.f708a);
    }
}
