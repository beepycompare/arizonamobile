package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class V0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f801a;
    public final /* synthetic */ C0651v1 b;

    public V0(C0651v1 c0651v1, String str) {
        this.b = c0651v1;
        this.f801a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1241a;
        String str = this.f801a;
        b0.getClass();
        A0.c().setUserProfileID(str);
    }
}
