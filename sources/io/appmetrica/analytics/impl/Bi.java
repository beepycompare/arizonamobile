package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f369a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ci c;

    public Bi(Ci ci, String str, String str2) {
        this.c = ci;
        this.f369a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f388a, ci.d, ci.e).reportEvent(this.f369a, this.b);
    }
}
