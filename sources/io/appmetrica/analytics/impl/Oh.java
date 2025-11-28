package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Oh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f621a;
    public final /* synthetic */ C0404li b;

    public Oh(C0404li c0404li, Throwable th) {
        this.b = c0404li;
        this.f621a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportUnhandledException(this.f621a);
    }
}
