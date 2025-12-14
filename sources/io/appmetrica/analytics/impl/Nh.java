package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Nh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f705a;
    public final /* synthetic */ C0300hi b;

    public Nh(C0300hi c0300hi, String str) {
        this.b = c0300hi;
        this.f705a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).setUserProfileID(this.f705a);
    }
}
