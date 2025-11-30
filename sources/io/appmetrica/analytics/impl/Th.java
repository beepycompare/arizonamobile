package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f695a;
    public final /* synthetic */ C0301hi b;

    public Th(C0301hi c0301hi, boolean z) {
        this.b = c0301hi;
        this.f695a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).setDataSendingEnabled(this.f695a);
    }
}
