package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0151b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f762a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0502p1 c;

    public RunnableC0151b1(C0502p1 c0502p1, String str, String str2) {
        this.c = c0502p1;
        this.f762a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0625u0 c0625u0 = this.c.f983a;
        String str = this.f762a;
        String str2 = this.b;
        c0625u0.getClass();
        C0600t0.c().putAppEnvironmentValue(str, str2);
    }
}
