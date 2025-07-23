package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0143b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f776a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0496p1 c;

    public RunnableC0143b1(C0496p1 c0496p1, String str, String str2) {
        this.c = c0496p1;
        this.f776a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0619u0 c0619u0 = this.c.f994a;
        String str = this.f776a;
        String str2 = this.b;
        c0619u0.getClass();
        C0594t0.c().putAppEnvironmentValue(str, str2);
    }
}
