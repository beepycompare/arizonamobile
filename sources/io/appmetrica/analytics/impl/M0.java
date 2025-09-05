package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class M0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f564a;
    public final /* synthetic */ C0547r1 b;

    public M0(C0547r1 c0547r1, String str) {
        this.b = c0547r1;
        this.f564a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1.a(this.b).c(this.f564a);
    }
}
