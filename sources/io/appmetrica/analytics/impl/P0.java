package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f628a;
    public final /* synthetic */ C0611u1 b;

    public P0(C0611u1 c0611u1, String str) {
        this.b = c0611u1;
        this.f628a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).c(this.f628a);
    }
}
