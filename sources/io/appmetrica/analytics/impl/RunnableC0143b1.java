package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0143b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f763a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0494p1 c;

    public RunnableC0143b1(C0494p1 c0494p1, String str, String str2) {
        this.c = c0494p1;
        this.f763a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0617u0 c0617u0 = this.c.f984a;
        String str = this.f763a;
        String str2 = this.b;
        c0617u0.getClass();
        C0592t0.c().putAppEnvironmentValue(str, str2);
    }
}
