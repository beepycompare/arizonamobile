package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f712a;
    public final /* synthetic */ C0651v1 b;

    public P0(C0651v1 c0651v1, String str) {
        this.b = c0651v1;
        this.f712a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c().b.a(this.f712a, false);
    }
}
