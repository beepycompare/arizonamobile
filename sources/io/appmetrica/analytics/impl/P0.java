package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f725a;
    public final /* synthetic */ C0610u1 b;

    public P0(C0610u1 c0610u1, String str) {
        this.b = c0610u1;
        this.f725a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).c(this.f725a);
    }
}
