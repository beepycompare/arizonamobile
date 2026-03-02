package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0132b1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f910a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0588t1 c;

    public RunnableC0132b1(C0588t1 c0588t1, String str, String str2) {
        this.c = c0588t1;
        this.f910a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0737z0 c0737z0 = this.c.f1228a;
        String str = this.f910a;
        String str2 = this.b;
        c0737z0.getClass();
        C0712y0.c().a(str, str2);
    }
}
