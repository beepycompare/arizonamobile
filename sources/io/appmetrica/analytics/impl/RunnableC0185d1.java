package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0185d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f938a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0650v1 c;

    public RunnableC0185d1(C0650v1 c0650v1, String str, String str2) {
        this.c = c0650v1;
        this.f938a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.c.f1243a;
        String str = this.f938a;
        String str2 = this.b;
        b0.getClass();
        A0.c().a(str, str2);
    }
}
