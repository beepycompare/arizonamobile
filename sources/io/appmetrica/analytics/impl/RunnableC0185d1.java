package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.d1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0185d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f949a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0589t1 c;

    public RunnableC0185d1(C0589t1 c0589t1, String str, String str2) {
        this.c = c0589t1;
        this.f949a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.c).b(this.f949a, this.b);
    }
}
