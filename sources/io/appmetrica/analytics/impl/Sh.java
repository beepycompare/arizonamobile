package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f788a;
    public final /* synthetic */ C0278gi b;

    public Sh(C0278gi c0278gi, boolean z) {
        this.b = c0278gi;
        this.f788a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).setDataSendingEnabled(this.f788a);
    }
}
