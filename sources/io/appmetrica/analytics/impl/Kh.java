package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Kh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0278gi f665a;

    public Kh(C0278gi c0278gi) {
        this.f665a = c0278gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.f665a;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).resumeSession();
    }
}
