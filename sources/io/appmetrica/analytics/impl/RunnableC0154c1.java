package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0154c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f920a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0610u1 c;

    public RunnableC0154c1(C0610u1 c0610u1, String str, String str2) {
        this.c = c0610u1;
        this.f920a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.c.f1239a;
        String str = this.f920a;
        String str2 = this.b;
        c0734z0.getClass();
        C0709y0.c().a(str, str2);
    }
}
