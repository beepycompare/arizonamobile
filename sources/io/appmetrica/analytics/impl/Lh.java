package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Lh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0301hi f572a;

    public Lh(C0301hi c0301hi) {
        this.f572a = c0301hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.f572a;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).resumeSession();
    }
}
