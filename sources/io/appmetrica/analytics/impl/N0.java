package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class N0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f693a;
    public final /* synthetic */ C0610u1 b;

    public N0(C0610u1 c0610u1, String str) {
        this.b = c0610u1;
        this.f693a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f693a, false);
    }
}
