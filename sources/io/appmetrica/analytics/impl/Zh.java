package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f752a;
    public final /* synthetic */ C0612ti b;

    public Zh(C0612ti c0612ti, String str) {
        this.b = c0612ti;
        this.f752a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).setUserProfileID(this.f752a);
    }
}
