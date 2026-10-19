package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f715a;
    public final /* synthetic */ C0644v1 b;

    public P0(C0644v1 c0644v1, String str) {
        this.b = c0644v1;
        this.f715a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c().b.a(this.f715a, false);
    }
}
