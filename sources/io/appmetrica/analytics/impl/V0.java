package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f803a;
    public final /* synthetic */ C0650v1 b;

    public V0(C0650v1 c0650v1, String str) {
        this.b = c0650v1;
        this.f803a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1243a;
        String str = this.f803a;
        b0.getClass();
        A0.c().setUserProfileID(str);
    }
}
