package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0144b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f776a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0497p1 c;

    public RunnableC0144b1(C0497p1 c0497p1, String str, String str2) {
        this.c = c0497p1;
        this.f776a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0620u0 c0620u0 = this.c.f994a;
        String str = this.f776a;
        String str2 = this.b;
        c0620u0.getClass();
        C0595t0.c().putAppEnvironmentValue(str, str2);
    }
}
