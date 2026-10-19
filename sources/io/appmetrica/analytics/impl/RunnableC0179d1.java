package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0179d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f941a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0644v1 c;

    public RunnableC0179d1(C0644v1 c0644v1, String str, String str2) {
        this.c = c0644v1;
        this.f941a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.c.f1246a;
        String str = this.f941a;
        String str2 = this.b;
        b0.getClass();
        A0.c().a(str, str2);
    }
}
