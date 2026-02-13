package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0210e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f967a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0210e1(C0589t1 c0589t1, String str) {
        this.b = c0589t1;
        this.f967a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).b(this.f967a);
    }
}
