package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Sh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f783a;
    public final /* synthetic */ C0279gi b;

    public Sh(C0279gi c0279gi, boolean z) {
        this.b = c0279gi;
        this.f783a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).setDataSendingEnabled(this.f783a);
    }
}
