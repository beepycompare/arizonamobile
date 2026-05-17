package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0209e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f972a;
    public final /* synthetic */ C0588t1 b;

    public RunnableC0209e1(C0588t1 c0588t1, String str) {
        this.b = c0588t1;
        this.f972a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.b).b(this.f972a);
    }
}
