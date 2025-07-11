package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f709a;
    public final /* synthetic */ C0560ri b;

    public Xh(C0560ri c0560ri, String str) {
        this.b = c0560ri;
        this.f709a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).setUserProfileID(this.f709a);
    }
}
