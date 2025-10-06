package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class M0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f569a;
    public final /* synthetic */ C0548r1 b;

    public M0(C0548r1 c0548r1, String str) {
        this.b = c0548r1;
        this.f569a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1.a(this.b).c(this.f569a);
    }
}
