package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f352a;
    public final /* synthetic */ Ci b;

    public Ai(Ci ci, String str) {
        this.b = ci;
        this.f352a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportEvent(this.f352a);
    }
}
