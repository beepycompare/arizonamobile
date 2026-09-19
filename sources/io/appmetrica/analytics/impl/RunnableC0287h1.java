package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0287h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1007a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0649v1 c;

    public RunnableC0287h1(C0649v1 c0649v1, String str, String str2) {
        this.c = c0649v1;
        this.f1007a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.c.f1243a;
        String str = this.f1007a;
        String str2 = this.b;
        b0.getClass();
        A0.c().putAppEnvironmentValue(str, str2);
    }
}
