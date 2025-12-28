package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0231f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f978a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0231f1(C0610u1 c0610u1, String str) {
        this.b = c0610u1;
        this.f978a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.b).b(this.f978a);
    }
}
