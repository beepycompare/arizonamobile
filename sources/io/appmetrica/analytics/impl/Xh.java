package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f757a;
    public final /* synthetic */ C0404li b;

    public Xh(C0404li c0404li, boolean z) {
        this.b = c0404li;
        this.f757a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).setDataSendingEnabled(this.f757a);
    }
}
