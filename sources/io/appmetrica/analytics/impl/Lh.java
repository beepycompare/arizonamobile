package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Lh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0279gi f680a;

    public Lh(C0279gi c0279gi) {
        this.f680a = c0279gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.f680a;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).pauseSession();
    }
}
