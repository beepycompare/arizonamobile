package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0258g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f899a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0611u1 c;

    public RunnableC0258g1(C0611u1 c0611u1, String str, String str2) {
        this.c = c0611u1;
        this.f899a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735z0 c0735z0 = this.c.f1141a;
        String str = this.f899a;
        String str2 = this.b;
        c0735z0.getClass();
        C0710y0.c().putAppEnvironmentValue(str, str2);
    }
}
