package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0186d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f936a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0651v1 c;

    public RunnableC0186d1(C0651v1 c0651v1, String str, String str2) {
        this.c = c0651v1;
        this.f936a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.c.f1241a;
        String str = this.f936a;
        String str2 = this.b;
        b0.getClass();
        A0.c().a(str, str2);
    }
}
