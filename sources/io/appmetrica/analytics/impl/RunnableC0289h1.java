package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0289h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1004a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0651v1 c;

    public RunnableC0289h1(C0651v1 c0651v1, String str, String str2) {
        this.c = c0651v1;
        this.f1004a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.c.f1240a;
        String str = this.f1004a;
        String str2 = this.b;
        b0.getClass();
        A0.c().putAppEnvironmentValue(str, str2);
    }
}
