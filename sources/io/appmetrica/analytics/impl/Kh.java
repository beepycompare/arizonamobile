package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0278gi f660a;

    public Kh(C0278gi c0278gi) {
        this.f660a = c0278gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.f660a;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).resumeSession();
    }
}
