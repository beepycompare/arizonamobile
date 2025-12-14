package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0257g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f996a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0610u1 c;

    public RunnableC0257g1(C0610u1 c0610u1, String str, String str2) {
        this.c = c0610u1;
        this.f996a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.c.f1238a;
        String str = this.f996a;
        String str2 = this.b;
        c0734z0.getClass();
        C0709y0.c().putAppEnvironmentValue(str, str2);
    }
}
