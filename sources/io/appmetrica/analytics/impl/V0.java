package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f806a;
    public final /* synthetic */ C0644v1 b;

    public V0(C0644v1 c0644v1, String str) {
        this.b = c0644v1;
        this.f806a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1246a;
        String str = this.f806a;
        b0.getClass();
        A0.c().setUserProfileID(str);
    }
}
