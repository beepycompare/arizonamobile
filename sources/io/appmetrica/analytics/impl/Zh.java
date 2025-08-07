package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f751a;
    public final /* synthetic */ C0613ti b;

    public Zh(C0613ti c0613ti, String str) {
        this.b = c0613ti;
        this.f751a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).setUserProfileID(this.f751a);
    }
}
