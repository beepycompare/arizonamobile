package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class N0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f702a;
    public final /* synthetic */ C0589t1 b;

    public N0(C0589t1 c0589t1, String str) {
        this.b = c0589t1;
        this.f702a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f702a, false);
    }
}
