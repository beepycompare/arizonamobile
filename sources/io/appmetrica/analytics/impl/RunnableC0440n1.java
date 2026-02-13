package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0440n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1127a;
    public final /* synthetic */ C0589t1 b;

    public RunnableC0440n1(C0589t1 c0589t1, String str) {
        this.b = c0589t1;
        this.f1127a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0589t1.a(this.b).reportEvent(this.f1127a);
    }
}
