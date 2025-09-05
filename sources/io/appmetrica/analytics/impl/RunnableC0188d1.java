package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0188d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f829a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0547r1 c;

    public RunnableC0188d1(C0547r1 c0547r1, String str, String str2) {
        this.c = c0547r1;
        this.f829a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.c.f1054a;
        String str = this.f829a;
        String str2 = this.b;
        c0671w0.getClass();
        C0646v0.c().putAppEnvironmentValue(str, str2);
    }
}
